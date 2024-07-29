package com.juan.sanchez.service.findbyid.assumingthat;

import com.juan.sanchez.domain.Book;
import com.juan.sanchez.factory.ApplicationFactory;
import com.juan.sanchez.service.BookService;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumingThat;

@DisplayName("Testing Multiple 'findById' Test Methods - Environment 'assumingThat'")
class BookServiceFindByIdWithSystemEnvironmentAssumingThatTests {

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
    @DisplayName("Testing 'findById' with 'id' 1 - Environment assumingThat Case 01")
    void findByIdWithId1EnvironmentAssumingThatCase01Test() {
        System.out.println(" findByIdWithId1EnvironmentAssumingThatCase01Test - Start");
        System.out.println(" JAVA_HOME: " + System.getenv("JAVA_HOME"));
        assumingThat(System.getenv("JAVA_HOME") != null,

                () -> {

                    System.out.println(" Testing 'findById' with 'id' 1 - Start");
                    Book book = bookService.findById(1);
                    assertAll("Entity 'id' 1",

                            () -> assertNotNull(book),
                            () -> assertEquals("Spring Recipes", book.getTitle()),
                            () -> assertEquals("978-1-4302-0623-1", book.getIsbn()),
                            () -> assertEquals(1, book.getEdition())
                    );

                    System.out.println(" Testing 'findById' with 'id' 1 - End");
                }

        );
        System.out.println(" findByIdWithId1EnvironmentAssumingThatCase01Test - End");
    }

    @Test
    @DisplayName("Testing 'findById' with 'id' 1 - Environment 'assumingThat' Case 02")
    void findByIdWithId1EnvironmentAssumingThatCase02Test() {
        System.out.println(" findByIdWithId1EnvironmentAssumingThatCase02Test - Start");
        System.out.println(" JAVA_HOME: " + System.getenv("JAVA_HOME"));
        assumingThat(System.getenv("JAVA_HOME") == null,

                () -> {

                    System.out.println(" Testing 'findById' with 'id' 1 - Start");
                    Book book = bookService.findById(1);
                    assertAll("Entity 'id' 1",

                            () -> assertNotNull(book),
                            () -> assertEquals("Spring Recipes", book.getTitle()),
                            () -> assertEquals("978-1-4302-0623-1", book.getIsbn()),
                            () -> assertEquals(1, book.getEdition())
                    );

                    System.out.println(" Testing 'findById' with 'id' 1 - End");
                }

        );
        System.out.println(" findByIdWithId1EnvironmentAssumingThatCase02Test - End");
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
