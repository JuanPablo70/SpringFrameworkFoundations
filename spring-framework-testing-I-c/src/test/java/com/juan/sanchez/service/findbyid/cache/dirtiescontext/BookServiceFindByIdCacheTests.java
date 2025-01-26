package com.juan.sanchez.service.findbyid.cache.dirtiescontext;

import com.juan.sanchez.config.AppConfig;
import com.juan.sanchez.domain.Book;
import com.juan.sanchez.service.BookService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles({"dev","cache"})
@SpringJUnitConfig(classes={AppConfig.class})
@DirtiesContext(classMode= DirtiesContext.ClassMode.AFTER_CLASS)
@DisplayName("Testing FindById Cache Test Methods")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookServiceFindByIdCacheTests {

    @Autowired
    private BookService bookService;

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
    @DisplayName("Testing 'findById' with 'id' 2")
    void findByIdWithId2Test() {
        System.out.println(" Testing 'findById' with 'id' 2 - Start");
        Book book = bookService.findById(2);
        assertAll("Entity 'id' 2",
                ()-> assertNotNull(book),
                ()-> assertEquals(2, book.getId())
        );
        System.out.println(" Testing 'findById' with 'id' 2 - End");
    }

    @Test
    @Order(3)
    @DisplayName("Testing 'findById' with 'id' 3")
    void findByIdWithId3Test() {
        System.out.println(" Testing 'findById' with 'id' 3 - Start");
        Book book = bookService.findById(3);
        assertAll("Entity 'id' 3",
                ()-> assertNotNull(book),
                ()-> assertEquals(3, book.getId())
        );
        System.out.println(" Testing 'findById' with 'id' 3 - End");
    }

    @Test
    @Order(4)
    @DirtiesContext(methodMode= DirtiesContext.MethodMode.AFTER_METHOD)
    @DisplayName("Testing 'Cache Report' - Group 1")
    void cacheReportGroup1Test() {
        System.out.println(" Testing 'Cache Report' - Group 1 - Start");
        bookService.report();
        System.out.println(" Testing 'Cache Report' - Group 1 - End");
    }

    @Test
    @Order(5)
    @DisplayName("Testing 'findById' with 'id' 4")
    void findByIdWithId4Test() {
        System.out.println(" Testing 'findById' with 'id' 4 - Start");
        Book book = bookService.findById(4);
        assertAll("Entity 'id' 4",
                ()-> assertNotNull(book),
                ()-> assertEquals(4, book.getId())
        );
        System.out.println(" Testing 'findById' with 'id' 4 - End");
    }

    @Test
    @Order(6)
    @DisplayName("Testing 'findById' with 'id' 5")
    void findByIdWithId5Test() {
        System.out.println(" Testing 'findById' with 'id' 5 - Start");
        Book book = bookService.findById(5);
        assertAll("Entity 'id' 5",
                ()-> assertNotNull(book),
                ()-> assertEquals(5, book.getId())
        );
        System.out.println(" Testing 'findById' with 'id' 5 - End");
    }

    @Test
    @Order(7)
    @DisplayName("Testing 'findById' with 'id' 6")
    void findByIdWithId6Test() {
        System.out.println(" Testing 'findById' with 'id' 6 - Start");
        Book book = bookService.findById(6);
        assertAll("Entity 'id' 6",
                ()-> assertNotNull(book),
                ()-> assertEquals(6, book.getId())
        );
        System.out.println(" Testing 'findById' with 'id' 6 - End");
    }

    @Test
    @Order(8)
    @DisplayName("Testing 'findById' with 'id' 7")
    void findByIdWithId7Test() {
        System.out.println(" Testing 'findById' with 'id' 7 - Start");
        Book book = bookService.findById(7);
        assertAll("Entity 'id' 7",
                ()-> assertNotNull(book),
                ()-> assertEquals(7, book.getId())
        );
        System.out.println(" Testing 'findById' with 'id' 7 - End");
    }

    @Test
    @Order(9)
    @DisplayName("Testing 'Cache Report' - Group 2")
    void cacheReportGroup2Test() {
        System.out.println(" Testing 'Cache Report' - Group 2 - Start");
        bookService.report();
        System.out.println(" Testing 'Cache Report' - Group 2 - End");
    }

    @Test
    @Order(10)
    @DirtiesContext(methodMode= DirtiesContext.MethodMode.BEFORE_METHOD)
    @DisplayName("Testing 'findById' with 'id' 8")
    void findByIdWithId8Test() {
        System.out.println(" Testing 'findById' with 'id' 8 - Start");
        Book book = bookService.findById(8);
        assertAll("Entity 'id' 8",
                ()-> assertNotNull(book),
                ()-> assertEquals(8, book.getId())
        );
        System.out.println(" Testing 'findById' with 'id' 8 - End");
    }

    @Test
    @Order(11)
    @DisplayName("Testing 'findById' with 'id' 9")
    void findByIdWithId9Test() {
        System.out.println(" Testing 'findById' with 'id' 9 - Start");
        Book book = bookService.findById(9);
        assertAll("Entity 'id' 9",
                ()-> assertNotNull(book),
                ()-> assertEquals(9, book.getId())
        );
        System.out.println(" Testing 'findById' with 'id' 9 - End");
    }

    @Test
    @Order(12)
    @DisplayName("Testing 'findById' with 'id' 10")
    void findByIdWithId10Test() {
        System.out.println(" Testing 'findById' with 'id' 10 - Start");
        Book book = bookService.findById(10);
        assertAll("Entity 'id' 10",
                ()-> assertNotNull(book),
                ()-> assertEquals(10, book.getId())
        );
        System.out.println(" Testing 'findById' with 'id' 10 - End");
    }

    @Test
    @Order(13)
    @DisplayName("Testing 'findById' with 'id' 11")
    void findByIdWithId11Test() {
        System.out.println(" Testing 'findById' with 'id' 11 - Start");
        Book book = bookService.findById(11);
        assertAll("Entity 'id' 11",
                ()-> assertNotNull(book),
                ()-> assertEquals(11, book.getId())
        );
        System.out.println(" Testing 'findById' with 'id' 11 - End");
    }

    @Test
    @Order(14)
    @DisplayName("Testing 'findById' with 'id' 12")
    void findByIdWithId12Test() {
        System.out.println(" Testing 'findById' with 'id' 12 - Start");
        Book book = bookService.findById(12);
        assertAll("Entity 'id' 12",
                ()-> assertNotNull(book),
                ()-> assertEquals(12, book.getId())
        );
        System.out.println(" Testing 'findById' with 'id' 12 - End");
    }

    @Test
    @Order(15)
    @DisplayName("Testing 'Cache Report' - Group 3")
    void cacheReportGroup3Test() {
        System.out.println(" Testing 'Cache Report' - Group 3 - Start");
        bookService.report();
        System.out.println(" Testing 'Cache Report' - Group 3 - End");
    }

}
