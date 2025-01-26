package com.juan.sanchez.service.crud.sql;

import com.juan.sanchez.config.AppConfig;
import com.juan.sanchez.domain.Book;
import com.juan.sanchez.exception.BookNotFoundException;
import com.juan.sanchez.service.BookService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlMergeMode;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.LocalDate;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles({"pre-prod","cache"})
@SpringJUnitConfig(classes={AppConfig.class})
@Sql(scripts={"classpath:/com/juan/sanchez/mysql/v1/schema.sql",
        "classpath:/com/juan/sanchez/mysql/v1/data.sql"},
        executionPhase= Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@DisplayName("Testing All CRUD Test Methods according with a specific order")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BookServiceCrudTests {

    @Autowired
    private BookService bookService;

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
    @Sql(scripts={"classpath:/com/juan/sanchez/mysql/v1/insert.sql"},
            executionPhase= Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(statements={"DELETE FROM book WHERE id = 32"},
            executionPhase= Sql.ExecutionPhase.AFTER_TEST_METHOD)
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
    @Order(4)
    @SqlMergeMode(SqlMergeMode.MergeMode.MERGE)
    @Sql(scripts={"classpath:/com/juan/sanchez/mysql/v1/insert.sql"},
            executionPhase= Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @DisplayName("Testing 'count' - Post Insert")
    void countPostInsertTest() {
        System.out.println(" Testing 'count' - Post Insert - Start");
        long count = bookService.count();
        assertEquals(32, count);
        System.out.println(" Testing 'count' - Post Insert - End");
    }

}
