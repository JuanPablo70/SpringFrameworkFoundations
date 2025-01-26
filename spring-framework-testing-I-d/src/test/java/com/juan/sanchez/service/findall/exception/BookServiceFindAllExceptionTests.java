package com.juan.sanchez.service.findall.exception;

import com.juan.sanchez.config.AppConfig;
import com.juan.sanchez.exception.BookEmptyCollectionException;
import com.juan.sanchez.service.BookService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ActiveProfiles({"dev","cache"})
@SpringJUnitConfig(classes={AppConfig.class})
@Disabled("Disabled until table 'book' has no data")
@DisplayName("Testing Single 'findAll' Test Method - 'assertThrows'")
class BookServiceFindAllExceptionTests {

    @Autowired
    private BookService bookService;

    @Test
    @DisplayName("Testing 'findAll'")
    void findAllTest() {
        System.out.println(" Testing 'findAll' - Start");
        Throwable throwable =
                assertThrows(BookEmptyCollectionException.class, () -> bookService.findAll());
        assertEquals("There are no books", throwable.getMessage());
        System.out.println(" Testing 'findAll' - End");
    }

}
