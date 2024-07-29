package com.juan.sanchez.service.findbyid.assumefalse;

import com.juan.sanchez.domain.Book;
import com.juan.sanchez.factory.ApplicationFactory;
import com.juan.sanchez.service.BookService;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeFalse;

@DisplayName("Testing Multiple 'findById' Test Methods - Property 'assumeFalse'")
class BookServiceFindByIdWithSystemPropertyAssumeFalseTests {

    private BookService libroService;

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
        libroService = ApplicationFactory.getBookService();
    }

    @Test
    @DisplayName("Testing 'findById' with 'id' 1 - Property 'assumeFalse' Case 01")
    void findByIdWithId1PropertyAssumeFalseCase01Test() {
        System.out.println(" findByIdWithId1PropertyAssumeFalseCase01Test - Start");
        System.out.println(" env: " + System.getProperty("env"));
        assumeFalse(System.getProperty("env") != null, "env must NOT exist");
        System.out.println(" Testing 'findById' with 'id' 1 - Start");
        Book book = libroService.findById(1);

        assertAll("Entity 'id' 1",
                () -> assertNotNull(book),
                () -> assertEquals("Spring Recipes", book.getTitle()),
                () -> assertEquals("978-1-4302-0623-1", book.getIsbn()),
                () -> assertEquals(1, book.getEdition())
        );

        System.out.println(" Testing 'findById' with 'id' 1 - End");
        System.out.println(" findByIdWithId1PropertyAssumeFalseCase01Test - End");
    }

    @Test
    @DisplayName("Testing 'findById' with 'id' 1 - Property 'assumeFalse' Case 02")
    void findByIdWithId1PropertyAssumeFalseCase02Test() {
        System.out.println(" findByIdWithId1PropertyAssumeFalseCase02Test - Start");
        System.out.println(" env: " + System.getProperty("env"));
        assumeFalse(System.getProperty("env") == null, "env must exist");
        System.out.println(" Testing 'findById' with 'id' 1 - Start");
        Book book = libroService.findById(1);

        assertAll("Entity 'id' 1",
                () -> assertNotNull(book),
                () -> assertEquals("Spring Recipes", book.getTitle()),
                () -> assertEquals("978-1-4302-0623-1", book.getIsbn()),
                () -> assertEquals(1, book.getEdition())
        );

        System.out.println(" Testing 'findById' with 'id' 1 - End");
        System.out.println(" findByIdWithId1PropertyAssumeFalseCase02Test - End");
    }

    @AfterEach
    void afterEach() {
        System.out.println("[Destroying BookService]");
        libroService = null;
    }

    @AfterAll
    static void afterAll() {
        System.out.println("**********************");
        System.out.println("Destroying Application");
        System.out.println("**********************");
    }

}
