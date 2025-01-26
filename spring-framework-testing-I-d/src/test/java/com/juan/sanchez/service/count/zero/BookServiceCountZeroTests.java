package com.juan.sanchez.service.count.zero;

import com.juan.sanchez.config.AppConfig;
import com.juan.sanchez.service.BookService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles({"dev","cache"})
@SpringJUnitConfig(classes={AppConfig.class})
@Disabled("Disabled until table 'book' has no data")
@DisplayName("Testing Single 'count' Test Method")
class BookServiceCountZeroTests {

    @Autowired
    private BookService bookService;

    @Test
    @DisplayName("Testing 'count'")
    void countTest() {
        System.out.println(" Testing 'count' - Start");
        long count = bookService.count();
        assertEquals(0, count);
        System.out.println(" Testing 'count' - End");
    }

}
