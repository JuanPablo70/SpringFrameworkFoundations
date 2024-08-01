package com.juan.sanchez.service.findbyid.assumefalse;

import com.juan.sanchez.domain.Book;
import com.juan.sanchez.factory.ApplicationFactory;
import com.juan.sanchez.service.BookService;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeFalse;

@DisplayName("Testing Multiple 'findById' Test Methods - Environment 'assumeFalse'")
class BookServiceFindByIdWithSystemEnvironmentAssumeFalseTests {

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
    @DisplayName("Testing 'findById' with 'id' 1 - Environment 'assumeFalse' Case 01")
    void findByIdWithId1EnvironmentAssumeFalseCase01Test() {
        System.out.println(" findByIdWithId1EnvironmentAssumeFalseCase01Test - Start");
        System.out.println(" JRE_HOME: " + System.getenv("JRE_HOME"));
        assumeFalse(System.getenv("JRE_HOME") != null, "JRE_HOME must NOT exist");
        System.out.println(" Testing 'findById' with 'id' 1 - Start");
        Book book = bookService.findById(1);

        assertAll("Entity 'id' 1",
                () -> assertNotNull(book),
                () -> assertEquals("Spring Recipes", book.getTitle()),
                () -> assertEquals("978-1-4302-0623-1", book.getIsbn()),
                () -> assertEquals(1, book.getEdition())
        );

        System.out.println(" Testing 'findById' with 'id' 1 - End");
        System.out.println(" findByIdWithId1EnvironmentAssumeFalseCase01Test - End");
    }

    @Test
    @DisplayName("Testing 'findById' with 'id' 1 - Environment 'assumeFalse' Case 02")
    void findByIdWithId1EnvironmentAssumeFalseCase02Test() {
        System.out.println(" findByIdWithId1EnvironmentAssumeFalseCase02Test - Start");
        System.out.println(" JRE_HOME: " + System.getenv("JRE_HOME"));
        assumeFalse(System.getenv("JRE_HOME") == null, "JRE_HOME must exist");
        System.out.println(" Testing 'findById' with 'id' 1 - Start");
        Book book = bookService.findById(1);

        assertAll("Entity 'id' 1",
                () -> assertNotNull(book),
                () -> assertEquals("Spring Recipes", book.getTitle()),
                () -> assertEquals("978-1-4302-0623-1", book.getIsbn()),
                () -> assertEquals(1, book.getEdition())
        );

        System.out.println(" Testing 'findById' with 'id' 1 - End");
        System.out.println(" findByIdWithId1EnvironmentAssumeFalseCase02Test - End");
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
