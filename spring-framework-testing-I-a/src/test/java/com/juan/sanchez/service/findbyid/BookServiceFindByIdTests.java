package com.juan.sanchez.service.findbyid;

import com.juan.sanchez.config.AppConfig;
import com.juan.sanchez.domain.Book;
import com.juan.sanchez.service.BookService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringJUnitConfig(classes={AppConfig.class})
@DisplayName("Testing Multiple 'findById' Test Methods")
class BookServiceFindByIdTests {

    @Autowired
    private BookService bookService;

    @Test
    @DisplayName("Testing 'findById' with 'id' 1")
    void findByIdWithId1Test() {
        System.out.println(" Testing 'findById' with 'id' 1 - Start");
        Book book = bookService.findById(1);
        assertNotNull(book);
        assertEquals("Spring Recipes", book.getTitle());
        assertEquals("978-1-4302-0623-1", book.getIsbn());
        assertEquals(1, book.getEdition());
        System.out.println(" Testing 'findById' with 'id' 1 - End");
    }

    @Test
    @DisplayName("Testing 'findById' with 'id' 15")
    void findByIdWithId15Test() {
        System.out.println(" Testing 'findById' with 'id' 15 - Start");
        Book book = bookService.findById(15);
        assertNotNull(book);
        assertEquals("Pro Spring Integration", book.getTitle());
        assertEquals("978-1-4302-3345-9", book.getIsbn());
        assertEquals(1, book.getEdition());
        System.out.println(" Testing 'findById' with 'id' 15- End");
    }

    @Test
    @DisplayName("Testing 'findById' with 'id' 27")
    void findByIdWithId27Test() {
        System.out.println(" Testing 'findById' with 'id' 27 - Start");
        Book book = bookService.findById(27);
        assertNotNull(book);
        assertEquals("Beginning Spring Data", book.getTitle());
        assertEquals("978-1-4842-8763-7", book.getIsbn());
        assertEquals(1, book.getEdition());
        System.out.println(" Testing 'findById' with 'id' 27 - End");
    }

}
