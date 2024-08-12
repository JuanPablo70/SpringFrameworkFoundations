package com.juan.sanchez.service.findbyid.cache;

import com.juan.sanchez.config.AppConfig;
import com.juan.sanchez.domain.Book;
import com.juan.sanchez.service.BookService;
import org.junit.jupiter.api.*;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testing FindById Cache Test Methods")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookServiceFindByIdCacheTests {

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
    @DisplayName("Testing 'findById' with 'id' 1")
    void findByIdWithId1Test() {
        System.out.println(" Testing 'findById' with 'id' 1 - Start");
        Book book = bookService.findById(1);
        assertAll("Entity 'id' 1",
                ()-> assertNotNull(book),
                ()-> assertEquals(1, book.getId())
        );
        System.out.println(" Testing 'findById' with 'id' 1 - End");
    }

    @Test
    @Order(2)
    @DisplayName("Testing 'findById' with 'id' 15")
    void findByIdWithId15Test() {
        System.out.println(" Testing 'findById' with 'id' 15 - Start");
        Book book = bookService.findById(15);
        assertAll("Entity 'id' 15",
                () -> assertNotNull(book),
                () -> assertEquals(15, book.getId())
        );
        System.out.println(" Testing 'findById' with 'id' 15 - End");
    }

    @Test
    @Order(3)
    @DisplayName("Testing 'findById' with 'id' 27")
    void findByIdWithId27Test() {
        System.out.println(" Testing 'findById' with 'id' 27 - Start");
        Book book = bookService.findById(27);
        assertAll("Entity 'id' 27",
                () -> assertNotNull(book),
                () -> assertEquals(27, book.getId())
        );
        System.out.println(" Testing 'findById' with 'id' 27 - End");
    }

    @Test
    @Order(4)
    @DisplayName("Testing 'Cache Report'")
    void reportCacheTest() {
        System.out.println(" Testing Cache Report - Start");
        bookService.report();
        System.out.println(" Testing Cache Report - Fin");
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
