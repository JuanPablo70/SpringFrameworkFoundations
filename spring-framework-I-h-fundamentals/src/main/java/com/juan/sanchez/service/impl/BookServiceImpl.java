package com.juan.sanchez.service.impl;

import com.juan.sanchez.domain.Book;
import com.juan.sanchez.exception.BookEmptyCollectionException;
import com.juan.sanchez.exception.BookNotFoundException;
import com.juan.sanchez.repository.BookRepository;
import com.juan.sanchez.service.BookService;

import java.util.Collection;
import java.util.Optional;

public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book findById(int id) {
        return Optional.ofNullable(bookRepository.findById(id))
                .orElseThrow(() -> new BookNotFoundException("Book 'id' " + id + " not found"));
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
        return bookRepository.update(book);
    }

    @Override
    public void delete(int id) {
        bookRepository.delete(id);
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

    @SuppressWarnings("unused")
    private void beanNameForBookRepository() {
        System.out.println("\nBeanName For BookRepository: " + bookRepository.getBeanName());
    }

}
