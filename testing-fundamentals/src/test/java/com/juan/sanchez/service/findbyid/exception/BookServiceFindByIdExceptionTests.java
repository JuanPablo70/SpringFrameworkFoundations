package com.juan.sanchez.service.findbyid.exception;

import com.juan.sanchez.exception.BookNotFoundException;
import com.juan.sanchez.factory.ApplicationFactory;
import com.juan.sanchez.service.BookService;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Testing Single 'findById' Test Method - 'assertThrows'")
class BookServiceFindByIdExceptionTests {

    private BookService bookService;

    @BeforeAll
    static void beforeAll() {
        System.out.println("******************");
        System.out.println("Creating Application");
        System.out.println("******************");
        ApplicationFactory.createApplication();
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("[Getting BookService]");
        bookService = ApplicationFactory.getBookService();
    }

    @Test
    @DisplayName("Testing 'findById' with 'id' 99")
    void findByIdWithId99Test() {
        System.out.println(" Testing 'findById' with 'id' 99 - Start");
        Throwable throwable =

                assertThrows(BookNotFoundException.class, () -> bookService.findById(99));

        assertEquals("Book 'id' 99 not found", throwable.getMessage());
        System.out.println(" Testing 'findById' with 'id' 99 - End");
    }

    @AfterEach
    void afterEach() {
        System.out.println("[Destroying BookService]");
        bookService = null;
    }

    @AfterAll
    static void afterAll() {
        System.out.println("**********************");
        System.out.println("Destroying Application");
        System.out.println("**********************");
    }

}
