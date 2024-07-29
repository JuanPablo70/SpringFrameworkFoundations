package com.juan.sanchez.service.findbyid.failure;

import com.juan.sanchez.domain.Book;
import com.juan.sanchez.factory.ApplicationFactory;
import com.juan.sanchez.service.BookService;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testing Multiple 'findById' Test Methods. They are expected to fail.")
class BookServiceFindByIdFailureTests {

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
    @DisplayName("Testing 'findById' with 'id' 1 - Sin 'assertAll'")
    void findByIdWithId1Approach01Test() {
        System.out.println(" Testing 'findById' with 'id' 1 - Start");
        Book book = bookService.findById(1);
        assertNotNull(book);
        assertEquals("Spring Recipes",
                book.getTitle().concat("x"), "Correct Title: Spring Recipes");
        assertEquals("978-1-4302-0623-1",
                book.getIsbn().concat("x"), "Correct ISBN: 978-1-4302-0623-1");
        assertEquals(1,
                book.getEdition() + 10, "Correct Edition: 1");
        System.out.println(" Testing 'findById' with 'id' 1 - End");
    }

    @Test
    @DisplayName("Testing 'findById' with 'id' 1 - Con 'assertAll'")
    void findByIdWithId1Approach02Test() {
        System.out.println(" Testing 'findById' with 'id' 1 - Start");
        Book book = bookService.findById(1);
        assertAll("Entity 'id' 1",
                () -> assertNotNull(book),
                () -> assertEquals("Spring Recipe",
                        book.getTitle().concat("x"), "Correct title: Spring Recipes"),
                () -> assertEquals("978-1-4302-0623-1",
                        book.getIsbn().concat("x"), "Correct ISBN: 978-1-4302-0623-1"),
                () -> assertEquals(1,
                        book.getEdition() + 10, "Correct Edition: 1")
        );
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
