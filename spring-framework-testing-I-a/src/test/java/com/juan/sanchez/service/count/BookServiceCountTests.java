package com.juan.sanchez.service.count;

import com.juan.sanchez.config.AppConfig;
import com.juan.sanchez.service.BookService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringJUnitConfig(classes={AppConfig.class})
@DisplayName("Testing Single 'count' Test Method")
class BookServiceCountTests {

    @Autowired
    private BookService bookService;

    @Test
    @DisplayName("Testing 'count'")
    void countTest() {
        System.out.println(" Testing 'count' - Start");
        long count = bookService.count();
        assertEquals(31, count);
        System.out.println(" Testing 'count' - End");
    }

}
