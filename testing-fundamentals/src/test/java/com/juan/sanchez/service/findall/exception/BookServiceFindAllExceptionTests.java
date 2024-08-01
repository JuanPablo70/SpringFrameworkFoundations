package com.juan.sanchez.service.findall.exception;

import com.juan.sanchez.exception.BookEmptyCollectionException;
import com.juan.sanchez.factory.ApplicationFactory;
import com.juan.sanchez.service.BookService;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Disabled("Disabled until table 'book' has no data")
@DisplayName("Testing Single 'findAll' Test Method - 'assertThrows'")
class BookServiceFindAllExceptionTests {

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
    @DisplayName("Testing 'findAll'")
    void findAllTest() {
        System.out.println(" Testing 'findAll' - Start");
        Throwable throwable =
                assertThrows(BookEmptyCollectionException.class, () -> bookService.findAll());
        assertEquals("There are no books", throwable.getMessage());
        System.out.println(" Testing 'findAll' - End");
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
