package com.juan.sanchez.service.impl;

import com.juan.sanchez.domain.Book;
import com.juan.sanchez.exception.BookEmptyCollectionException;
import com.juan.sanchez.exception.BookNotFoundException;
import com.juan.sanchez.repository.BookRepository;
import com.juan.sanchez.service.BookService;
import com.juan.sanchez.service.CacheService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@Profile("p3")
class BookP3ServiceImpl implements BookService {

    private BookRepository bookRepository;

    private CacheService<Book, Integer> cacheService;

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Lazy
    @Autowired
    public void setCacheService(CacheService<Book,Integer> cacheService) {
        this.cacheService = cacheService;
    }

    @Override
    public Book save(Book book) {
        book = bookRepository.save(book);
        cacheService.add(book);
        return book;
    }

    @Override
    public Book findById(int id) {
        if(cacheService.get(id) != null) {
            return cacheService.get(id);
        } else {
            Book book = null;
            book = Optional.ofNullable(bookRepository.findById(id))
                    .orElseThrow(() -> new BookNotFoundException("Book 'id' " + id + " not found"));

            cacheService.add(book);
            return book;
        }
    }

    @Override
    public Collection<Book> findAll() {
        return Optional.ofNullable(bookRepository.findAll())
                .orElseThrow(() -> new BookEmptyCollectionException("There are no books"));
    }

    @Override
    public long count() {
        return bookRepository.count();
    }

    @Override
    public Book update(Book book) {
        book = bookRepository.update(book);
        cacheService.delete(book.getId());
        cacheService.add(book);
        return book;
    }

    @Override
    public void delete(int id) {
        if(cacheService.get(id) != null) {
            bookRepository.delete(id);
            cacheService.delete(id);
        } else {
            bookRepository.delete(id);
        }
    }

    @Override
    public void report(Book book) {
        System.out.println("Book Report");
        System.out.println(book.toString());
    }

    @Override
    public void report(Collection<Book> books) {
        System.out.println("Book Reports...");
        for (Book book : books) {
            report(book);
        }
    }

    @Override
    public void report(long count) {
        System.out.println("Amount books report: " + count);
    }

    @Override
    public void report() {
        cacheService.report();
    }

    @PostConstruct
    private void postConstruct() {
        System.out.println(" postConstruct:");
        System.out.println(" BookRepository: " + bookRepository.getClass());
        System.out.println(" CacheService : " + cacheService.getClass());
    }

}
