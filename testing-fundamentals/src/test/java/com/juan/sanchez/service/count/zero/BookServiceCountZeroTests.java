package com.juan.sanchez.service.count.zero;

import com.juan.sanchez.factory.ApplicationFactory;
import com.juan.sanchez.service.BookService;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Disabled("Disabled until table 'book' has no data")
@DisplayName("Testing Single 'count' Test Method")
class BookServiceCountZeroTests {

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
    @DisplayName("Testing 'count'")
    void countTest() {
        System.out.println(" Testing 'count' - Start");
        long count = bookService.count();
        assertEquals(0, count);
        System.out.println(" Testing 'count' - End");
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
