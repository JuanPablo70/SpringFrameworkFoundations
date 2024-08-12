package com.juan.sanchez.service.crud;

import com.juan.sanchez.config.AppConfig;
import com.juan.sanchez.domain.Book;
import com.juan.sanchez.exception.BookNotFoundException;
import com.juan.sanchez.service.BookService;
import org.junit.jupiter.api.*;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testing All CRUD Test Methods according with a specific order")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BookServiceCrudTests {

    private BookService bookService;

    private static ConfigurableApplicationContext ctx;

    @BeforeAll
    static void beforeAll() {
        System.out.println("******************");
        System.out.println("Creating Application");
        System.out.println("******************");
        ctx = new AnnotationConfigApplicationContext(AppConfig.class);
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("[Getting BookService]");
        bookService = ctx.getBean(BookService.class);
    }

    @Test
    @Order(1)
    @DisplayName("Testing 'findAll' - Pre Insert")
    void findAllPreInsertTest() {
        System.out.println(" Testing 'findAll' - Pre Insert - Start");
        Collection<Book> books = bookService.findAll();
        assertNotNull(books);
        assertFalse(books.isEmpty());
        assertEquals(31, books.size());
        System.out.println(" Testing 'findAll' - Pre Insert - End");
    }

    @Test
    @Order(2)
    @DisplayName("Testing 'count'- Pre Insert")
    void countPreInsertTest() {
        System.out.println(" Testing 'count'- Pre Insert- Start");
        long count = bookService.count();
        assertEquals(31, count);
        System.out.println(" Testing 'count' - Pre Insert - End");

    }

    @Test
    @Order(3)
    @DisplayName("Testing 'save' with 'id' 32")
    void saveWithId32Test() {
        System.out.println(" Testing 'save' with 'id' 32 - Start");
        Book book = new Book();
        book.setTitle("Programming in Something");
        book.setIsbn("1234567890");
        book.setEdition(1);
        book.setPublishDate(LocalDate.of(2000, 01, 01));
        book.setChapters(1000);
        book = bookService.save(book);
        assertEquals(32, book.getId());
        System.out.println(" Testing 'save' with 'id' 32 - End");
    }

    @Test
    @Order(4)
    @DisplayName("Testing 'findAll' - Post Insert")
    void findAllPostInsertTest() {
        System.out.println(" Testing 'findAll' - Post Insert - Start");
        Collection<Book> books = bookService.findAll();
        assertNotNull(books);
        assertFalse(books.isEmpty());
        assertEquals(32, books.size());
        System.out.println(" Testing 'findAll' - Post Insert - End");
    }

    @Test
    @Order(5)
    @DisplayName("Testing 'count' - Post Insert")
    void countPostInsertTest() {
        System.out.println(" Testing 'count' - Post Insert - Start");
        long count = bookService.count();
        assertEquals(32, count);
        System.out.println(" Testing 'count' - Post Insert - End");
    }

    @Test
    @Order(6)
    @DisplayName("Testing 'findById' with 'id' 32 - Pre Update")
    void findByIdWithId32PreUpdateTest() {
        System.out.println(" Testing 'findById' with 'id' 32 - Pre Update - Start");
        Book book = bookService.findById(32);
        assertAll("Entity 'id' 32",

                () -> assertNotNull(book),
                () -> assertEquals("Programming in Something", book.getTitle()),
                () -> assertEquals("1234567890", book.getIsbn()),
                () -> assertEquals(1, book.getEdition())

        );
        System.out.println(" Testing 'findById' with 'id' 32 - Pre Update - End");
    }

    @Test
    @Order(7)
    @DisplayName("Testing 'update' with 'id' 32")
    void updateWithId32Test() {
        System.out.println(" Testing 'update' with 'id' 32 - Start");
        Book book = bookService.findById(32);
        book.setTitle("Programming in Something ABC");
        book.setIsbn("1234567890AAA");
        book = bookService.update(book);
        assertNotNull(book);
        assertEquals("Programming in Something ABC", book.getTitle());
        assertEquals("1234567890AAA", book.getIsbn());
        System.out.println(" Testing 'update' with 'id' 32 - End");
    }

    @Test
    @Order(8)
    @DisplayName("Testing 'findById' with 'id' 32 - Post Update")
    void findByIdWithId32PostUpdateTest() {
        System.out.println(" Testing 'findById' with 'id' 32 - Post Update - Start");
        Book book = bookService.findById(32);
        assertAll("Entity 'id' 32",

                () -> assertNotNull(book),
                () -> assertEquals("Programming in Something ABC", book.getTitle()),
                () -> assertEquals("1234567890AAA", book.getIsbn()),
                () -> assertEquals(1, book.getEdition())

        );
        System.out.println(" Testing 'findById' with 'id' 32 - Post Update - End");
    }

    @Test
    @Order(9)
    @DisplayName("Testing 'findAll' - Pre Delete")
    void findAllPreDeleteTest() {
        System.out.println(" Testing 'findAll' - Pre Delete - Start");
        Collection<Book> books = bookService.findAll();
        assertNotNull(books);
        assertFalse(books.isEmpty());
        assertEquals(32, books.size());
        System.out.println(" Testing 'findAll' - Pre Delete - End");
    }

    @Test
    @Order(10)
    @DisplayName("Testing 'count' - Pre Delete")
    void countPreDeleteTest() {
        System.out.println(" Testing 'count' - Pre Delete - Start");
        long count = bookService.count();
        assertEquals(32, count);
        System.out.println(" Testing 'count' - Pre Delete - End");
    }

    @Test
    @Order(11)
    @DisplayName("Testing 'delete' with 'id' 32")
    void deleteWithId32Test() {
        System.out.println(" Testing 'delete' with 'id' 32 - Start");
        bookService.delete(32);
        System.out.println(" Testing 'delete' with 'id' 32 - End");
    }

    @Test
    @Order(12)
    @DisplayName("Testing 'findAll' - Post Delete")
    void findAllPostDeleteTest() {
        System.out.println(" Testing 'findAll' - Post Delete - Start");
        Collection<Book> book = bookService.findAll();
        assertNotNull(book);
        assertFalse(book.isEmpty());
        assertEquals(31, book.size());
        System.out.println(" Testing 'findAll' - Post Delete - End");
    }

    @Test
    @Order(13)
    @DisplayName("Testing 'count' - Post Delete")
    void countPostDeleteTest() {
        System.out.println(" Testing 'count' - Post Delete - Start");
        long count = bookService.count();
        assertEquals(31, count);
        System.out.println(" Testing 'count' - Post Delete - End");
    }

    @Test
    @Order(14)
    @DisplayName("Testing 'findById' with 'id' 32")
    void findByIdWithId32Test() {
        System.out.println(" Testing 'findById' with 'id' 32 - Start");
        Throwable throwable =

                assertThrows(BookNotFoundException.class, () -> bookService.findById(32));

        assertEquals("Book 'id' 32 not found", throwable.getMessage());
        System.out.println(" Testing 'findById' with 32 - End");
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
        ctx.close();
    }

}
