package com.juan.sanchez.service.findbyid.assumetrue;

import com.juan.sanchez.domain.Book;
import com.juan.sanchez.factory.ApplicationFactory;
import com.juan.sanchez.service.BookService;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@DisplayName("Testing Multiple 'findById' Test Methods - Environment 'assumeTrue'")
class BookServiceFindByIdWithSystemEnvironmentAssumeTrueTests {

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
    @DisplayName("Testing 'findById' with 'id' 1 - Environment 'assumeTrue' Case 01")
    void findByIdWithId1EnvironmentAssumeTrueCase01Test() {
        System.out.println(" findByIdWithId1EnvironmentAssumeTrueCase01Test - Start");
        System.out.println(" JAVA_HOME: " + System.getenv("JAVA_HOME"));
        assumeTrue(System.getenv("JAVA_HOME") != null, "JAVA_HOME must exist");
        System.out.println(" Testing 'findById' with 'id' 1 - Start");
        Book book = bookService.findById(1);

        assertAll("Entity 'id' 1",
                () -> assertNotNull(book),
                () -> assertEquals("Spring Recipes", book.getTitle()),
                () -> assertEquals("978-1-4302-0623-1", book.getIsbn()),
                () -> assertEquals(1, book.getEdition())
        );

        System.out.println(" Testing 'findById' with 'id' 1 - End");
        System.out.println(" findByIdWithId1EnvironmentAssumeTrueCase01Test - End");
    }

    @Test
    @DisplayName("Testing 'findById' with 'id' 1 - Environment 'assumeTrue' Case 02")
    void findByIdWithId1EnvironmentAssumeTrueCase02Test() {
        System.out.println(" findByIdWithId1EnvironmentAssumeTrueCase02Test - Start");
        System.out.println(" JAVA_HOME: " + System.getenv("JAVA_HOME"));
        assumeTrue(System.getenv("JAVA_HOME") == null, "JAVA_HOME must NOT exist");
        System.out.println(" Testing 'findById' with 'id' 1 - Start");
        Book book = bookService.findById(1);

        assertAll("Entidad 'id' 1",
                () -> assertNotNull(book),
                () -> assertEquals("Spring Recipes", book.getTitle()),
                () -> assertEquals("978-1-4302-0623-1", book.getIsbn()),
                () -> assertEquals(1, book.getEdition())
        );

        System.out.println(" Testing 'findById' with 'id' 1 - End");
        System.out.println(" findByIdWithId1EnvironmentAssumeTrueCase02Test - End");
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
