package com.juan.sanchez.service.findbyid.assumingthat;

import com.juan.sanchez.domain.Book;
import com.juan.sanchez.factory.ApplicationFactory;
import com.juan.sanchez.service.BookService;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumingThat;

@DisplayName("Testing Multiple 'findById' Test Methods - Property 'assumingThat'")
class BookServiceFindByIdWithSystemPropertyAssumingThatTests {

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
    @DisplayName("Testing 'findById' with 'id' 1 - Property 'assumingThat' Case 01")
    void findByIdWithId1PropertyAssumingThatCase01Test() {
        System.out.println(" findByIdWithId1PropertyAssumingThatCase01Test - Start");
        System.out.println(" env: " + System.getProperty("env"));
        assumingThat(System.getProperty("env") != null,

                () -> {

                    System.out.println(" Testing 'findById' with 'id' 1 - Start");
                    Book book = libroService.findById(1);
                    assertAll("Entity 'id' 1",

                            () -> assertNotNull(book),
                            () -> assertEquals("Spring Recipes", book.getTitle()),
                            () -> assertEquals("978-1-4302-0623-1", book.getIsbn()),
                            () -> assertEquals(1, book.getEdition())
                    );

                    System.out.println(" Testing 'findById' with 'id' 1 - End");
                }

        );
        System.out.println(" findByIdWithId1PropertyAssumingThatCase01Test - End");
    }

    @Test
    @DisplayName("Testing 'findById' with 'id' 1 - Property 'assumingThat' Case 02")
    void findByIdWithId1PropertyAssumingThatCase02Test() {
        System.out.println(" findByIdWithId1PropertyAssumingThatCase02Test - Start");
        System.out.println(" env: " + System.getProperty("env"));
        assumingThat(System.getProperty("env") == null,

                () -> {

                    System.out.println(" Testing 'findById' with 'id' 1 - Start");
                    Book book = libroService.findById(1);
                    assertAll("Entity 'id' 1",
                            () -> assertNotNull(book),

                            () -> assertEquals("Spring Recipes", book.getTitle()),
                            () -> assertEquals("978-1-4302-0623-1", book.getIsbn()),
                            () -> assertEquals(1, book.getEdition())
                    );

                    System.out.println(" Testing 'findById' with 'id' 1 - End");
                }

        );
        System.out.println(" findByIdWithId1PropertyAssumingThatCase02Test - End");
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
