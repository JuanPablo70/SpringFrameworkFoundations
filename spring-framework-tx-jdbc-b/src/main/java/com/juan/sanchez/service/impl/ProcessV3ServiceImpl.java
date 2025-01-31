package com.juan.sanchez.service.impl;

import com.juan.sanchez.domain.Author;
import com.juan.sanchez.domain.Book;
import com.juan.sanchez.service.AuthorService;
import com.juan.sanchez.service.BookService;
import com.juan.sanchez.service.BusinessService;
import com.juan.sanchez.service.ProcessService;
import com.juan.sanchez.utils.DateTimeUtils;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
@Profile("process-v3")
class ProcessV3ServiceImpl implements ProcessService {

    private final AuthorService authorService;
    private final BookService bookService;
    private final BusinessService businessService;

    public ProcessV3ServiceImpl(AuthorService authorService, BookService bookService, BusinessService businessService) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.businessService = businessService;
    }

    @Override
    public void createProcess(Author author, Book book) throws Exception {
        LocalDateTime startDateTime = DateTimeUtils.now();
        System.out.printf("[ProcessService] CreateProcess Starting  at: %s%n",
                DateTimeUtils.nowFormatted(startDateTime));

        authorService.save(author);
        businessService.doBusiness();
        bookService.save(book);

        LocalDateTime endDateTime = DateTimeUtils.now();
        System.out.printf("[ProcessService] CreateProcess Ending    at: %s - Duration: %s millis%n",
                DateTimeUtils.nowFormatted(endDateTime),
                DateTimeUtils.durationAsMillis(startDateTime, endDateTime));
    }

    @Override
    public void readProcess(int idAuthor) throws Exception {
        LocalDateTime startDateTime = DateTimeUtils.now();
        System.out.printf("[ProcessService] ReadProcess Starting  at: %s%n",
                DateTimeUtils.nowFormatted(startDateTime));

        Author author = authorService.findByIdWithBooks(idAuthor);
        System.out.println(" " + author.toString());
        businessService.doBusiness();
        for(Book book : author.getBooks()) {
            System.out.println("  " + bookService.findById(book.getId()));
        }

        LocalDateTime endDateTime = DateTimeUtils.now();
        System.out.printf("[ProcessService] ReadProcess Ending    at: %s - Duration: %s millis%n",
                DateTimeUtils.nowFormatted(endDateTime),
                DateTimeUtils.durationAsMillis(startDateTime, endDateTime));
    }

    @Override
    public void updateProcess(int idAuthor) throws Exception {
        LocalDateTime startDateTime = DateTimeUtils.now();
        System.out.printf("[ProcessService] UpdateProcess Starting  at: %s%n",
                DateTimeUtils.nowFormatted(startDateTime));

        Author author = authorService.findByIdWithBooks(idAuthor);
        author.setName(author.getName().toUpperCase());
        author.setLastname(author.getLastname().toUpperCase());
        authorService.update(author);
        businessService.doBusiness();
        for(Book book : author.getBooks()) {
            book.setTitle(book.getTitle().toUpperCase());
            book.setIsbn(book.getIsbn().toUpperCase());
            bookService.update(book);
        }

        LocalDateTime endDateTime = DateTimeUtils.now();
        System.out.printf("[ProcessService] UpdateProcess Ending    at: %s - Duration: %s millis%n",
                DateTimeUtils.nowFormatted(endDateTime),
                DateTimeUtils.durationAsMillis(startDateTime, endDateTime));
    }

    @Override
    public void deleteProcess(int idAuthor) throws Exception {
        LocalDateTime startDateTime = DateTimeUtils.now();
        System.out.printf("[ProcessService] DeleteProcess Starting  at: %s%n",
                DateTimeUtils.nowFormatted(startDateTime));

        Author author = authorService.findByIdWithBooks(idAuthor);
        for(Book book : author.getBooks()) {
            bookService.delete(book.getId());
        }
        businessService.doBusiness();
        authorService.delete(idAuthor);

        LocalDateTime endDateTime = DateTimeUtils.now();
        System.out.printf("[ProcessService] DeleteProcess Ending    at: %s - Duration: %s millis%n",
                DateTimeUtils.nowFormatted(endDateTime),
                DateTimeUtils.durationAsMillis(startDateTime, endDateTime));
    }

}
