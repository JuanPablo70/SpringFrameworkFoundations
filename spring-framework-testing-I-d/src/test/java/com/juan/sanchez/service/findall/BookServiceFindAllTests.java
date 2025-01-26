package com.juan.sanchez.service.findall;

import com.juan.sanchez.config.AppConfig;
import com.juan.sanchez.domain.Book;
import com.juan.sanchez.service.BookService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles({"dev","cache"})
@SpringJUnitConfig(classes={AppConfig.class})
@DisplayName("Testing Single 'findAll' Test Method")
class BookServiceFindAllTests {

    @Autowired
    private BookService bookService;

    @Test
    @DisplayName("Testing 'findAll'")
    void findAllTest() {
        System.out.println(" Testing 'findAll' - Start");
        Collection<Book> books = bookService.findAll();
        assertNotNull(books);
        assertFalse(books.isEmpty());
        assertEquals(31, books.size());
        System.out.println(" Testing 'findAll' - End");
    }

}
