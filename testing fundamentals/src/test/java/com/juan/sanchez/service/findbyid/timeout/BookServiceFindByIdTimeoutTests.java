package com.juan.sanchez.service.findbyid.timeout;

import com.juan.sanchez.factory.ApplicationFactory;
import com.juan.sanchez.service.BookService;
import org.junit.jupiter.api.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTimeout;

@DisplayName("Testing Multiple 'findById' Test Methods - 'assertTimeout'")
class BookServiceFindByIdTimeoutTests {

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
    @DisplayName("Testing 'findById' with 'id' 1 - Timeout 1 Second")
    void findByIdWithId1WithTimeout1SecondTest() {
        System.out.println(" Testing 'findById' with 'id' 1 - Start");
        assertTimeout(Duration.ofSeconds(1),

                () -> bookService.findById(1),
                "Test method exceeds time of 1 second");

        System.out.println(" Testing 'findById' with 'id' 1 - End");
    }

    @Test
    @DisplayName("Testing 'findById' with 'id' 1 - Timeout 5 Seconds")
    void findByIdWithId1WithTimeout5SecondsTest() {
        System.out.println(" Testing 'findById' with 'id' 1 - Start");
        assertTimeout(Duration.ofSeconds(5),

                () -> bookService.findById(1),
                "Test method exceeds time of 5 seconds");

        System.out.println(" Testing 'findById' with 'id' 1 - End");
    }

    @Test
    @DisplayName("Testing 'findById' with 'id' 1 - Timeout 500 MilliSeconds")
    void findByIdWithId1WithTimeout500MilliSecondsTest() {
        System.out.println(" Testing 'findById' with 'id' 1 - Start");
        assertTimeout(Duration.ofMillis(500),

                () -> bookService.findById(1),
                "Test method exceeds time of 500 milliseconds");

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
