package com.juan.sanchez.factory;

import com.juan.sanchez.domain.Author;
import com.juan.sanchez.domain.Book;

import java.time.LocalDate;

public class BookFactory {

    public static Book createBookWithId19(Author author) {
        Book book = new Book();
        book.setTitle("Programming in Something");
        book.setIsbn("1234567890");
        book.setEdition(1);
        book.setPublishDate(LocalDate.of(2000, 01, 01));
        book.setChapters(1000);
        book.setPages(100);
        author.addBook(book);
        return book;
    }

    private BookFactory() {}

}
