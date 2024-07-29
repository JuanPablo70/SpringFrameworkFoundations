package com.juan.sanchez.service.findbyid.failure.timeout;

import com.juan.sanchez.factory.ApplicationFactory;
import com.juan.sanchez.service.BookService;
import org.junit.jupiter.api.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTimeout;

@DisplayName("Testing Single 'findById' Test Method - 'assertTimeout'")
class BookServiceFindByIdFailureTimeoutTests {

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
    @Disabled("Enable only for demonstration purposes to fail")
    @DisplayName("Testing 'findById' with 'id' 1 - Timeout 10 MilliSeconds")
    void findByIdWithId1WithTimeout10MilliSecondsTest() {
        System.out.println(" Testing 'findById' with 'id' 1 - Start");
        assertTimeout(Duration.ofMillis(10),

                () -> bookService.findById(1),
                "Test method exceeds time of 10 milliseconds");

        System.out.println(" Testing 'findById' with 'id' 1 - End");
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
