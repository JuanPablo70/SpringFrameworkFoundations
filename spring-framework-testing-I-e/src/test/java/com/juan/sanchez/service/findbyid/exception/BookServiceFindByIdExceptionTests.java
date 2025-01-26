package com.juan.sanchez.service.findbyid.exception;

import com.juan.sanchez.config.AppConfig;
import com.juan.sanchez.exception.BookNotFoundException;
import com.juan.sanchez.service.BookService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringJUnitConfig(classes={AppConfig.class})
@DisplayName("Testing Single 'findById' Test Method - 'assertThrows'")
class BookServiceFindByIdExceptionTests {

    @Autowired
    private BookService bookService;

    @Test
    @DisplayName("Testing 'findById' with 'id' 99")
    void findByIdWithId99Test() {
        System.out.println(" Testing 'findById' with 'id' 99 - Start");
        Throwable throwable =
                assertThrows(BookNotFoundException.class, () -> bookService.findById(99));
        assertEquals("Book 'id' 99 not found", throwable.getMessage());
        System.out.println(" Testing 'findById' with 'id' 99 - End");
    }

}
