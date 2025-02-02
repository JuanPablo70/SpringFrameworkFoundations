package com.juan.sanchez.service.process;

import com.juan.sanchez.config.AppConfig;
import com.juan.sanchez.domain.Author;
import com.juan.sanchez.domain.Book;
import com.juan.sanchez.factory.AuthorFactory;
import com.juan.sanchez.factory.BookFactory;
import com.juan.sanchez.service.AuthorService;
import com.juan.sanchez.service.BookService;
import com.juan.sanchez.service.ProcessService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;

@Transactional
@ActiveProfiles({"pre-prod","no-cache","exception-non","process-v2"})
@SpringJUnitConfig(classes={AppConfig.class})
@DisplayName("Testing All CRUD Processes Services")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProcessServiceTests {

    @Autowired
    private ProcessService processService;

    @Autowired
    private ApplicationContext applicationContext;

    @BeforeAll
    static void beforeAll(@Autowired ApplicationContext ctx) throws SQLException {
        try(Connection conn = ctx.getBean(DataSource.class).getConnection()){
            String[] profiles = ctx.getEnvironment().getActiveProfiles();
            System.out.printf(" Active Profiles: %s%n", Arrays.asList(profiles));
            if(Arrays.asList(profiles).contains("pre-prod")) {
                ScriptUtils.executeSqlScript(conn, new ClassPathResource("/com/juan/sanchez/mysql/v2/schema.sql"));
                ScriptUtils.executeSqlScript(conn, new ClassPathResource("/com/juan/sanchez/mysql/v2/data.sql"));
            } else if(Arrays.asList(profiles).contains("dev")) {
                ScriptUtils.executeSqlScript(conn, new ClassPathResource("/com/juan/sanchez/h2/v2/schema.sql"));
                ScriptUtils.executeSqlScript(conn, new ClassPathResource("/com/juan/sanchez/h2/v2/data.sql"));
            } else {
                throw new RuntimeException("There are NO neither 'pre-prod' nor 'dev' profiles declared");
            }
        }
    }

    @BeforeTransaction
    void beforeTransaction() {
        AuthorService authorService = applicationContext.getBean(AuthorService.class);
        BookService bookService = applicationContext.getBean(BookService.class);
        System.out.printf("[BeforeTransaction] %n");
        System.out.printf(" Authors size: %s%n", authorService.count());
        System.out.printf(" Books   size: %s%n", bookService.count());
    }

    @BeforeEach
    void beforeEach(@Autowired AuthorService authorService,
                    @Autowired BookService bookService) {
        System.out.printf("[BeforeEach] %n");
        System.out.printf(" Authors size: %s%n", authorService.count());
        System.out.printf(" Books   size: %s%n", bookService.count());
    }

    @Test
    @Order(1)
    @DisplayName("Testing 'Create' Process Service")
    void processServiceCreateTest() {
        System.out.printf("[ProcessServiceCreateTest] Starting %n");
        try {
            Author author = AuthorFactory.createAuthorWithId11();
            Book book = BookFactory.createBookWithId19(author);
            processService.createProcess(author, book);
        }
        catch(Throwable t) {
            System.out.println(" [ProcessServiceCreateTest] Catching and Handling Throwable");
            System.out.println("  Type   : " + t.getClass());
            System.out.println("  Message: " + t.getMessage());
        }
        System.out.printf("[ProcessServiceCreateTest] Ending %n");
    }

    @Test
    @Order(2)
    @DisplayName("Testing 'Read' Process Service")
    void processServiceReadTest() {
        System.out.printf("[ProcessServiceReadTest] Starting %n");
        try {
            processService.readProcess(4);
        }
        catch(Throwable t) {
            System.out.println(" [ProcessServiceReadTest] Catching and Handling Throwable");
            System.out.println("  Type   : " + t.getClass());
            System.out.println("  Message: " + t.getMessage());
        }
        System.out.printf("[ProcessServiceReadTest] Ending %n");
    }

    @Test
    @Order(3)
    @DisplayName("Testing 'Update' Process Service")
    void processServiceUpdateTest() {
        System.out.printf("[ProcessServiceUpdateTest] Starting %n");
        try {
            processService.updateProcess(4);
        }
        catch(Throwable t) {
            System.out.println(" [ProcessServiceUpdateTest] Catching and Handling Throwable");
            System.out.println("  Type   : " + t.getClass());
            System.out.println("  Message: " + t.getMessage());
        }
        System.out.printf("[ProcessServiceUpdateTest] Ending %n");
    }

    @Test
    @Order(4)
    @DisplayName("Testing 'Delete' Process Service")
    void processServiceDeleteTest() {
        System.out.printf("[ProcessServiceDeleteTest] Starting %n");
        try {
            processService.deleteProcess(4);
        }
        catch(Throwable t) {
            System.out.println(" [ProcessServiceDeleteTest] Catching and Handling Throwable");
            System.out.println("  Type   : " + t.getClass());
            System.out.println("  Message: " + t.getMessage());
        }
        System.out.printf("[ProcessServiceDeleteTest] Ending %n");
    }

    @AfterTransaction
    void afterTransaction() {
        AuthorService authorService = applicationContext.getBean(AuthorService.class);
        BookService bookService = applicationContext.getBean(BookService.class);
        System.out.printf("[AfterTransaction] %n");
        System.out.printf(" Authors size: %s%n", authorService.count());
        System.out.printf(" Books   size: %s%n", bookService.count());
    }

    @AfterEach
    void afterEach(@Autowired AuthorService authorService,
                    @Autowired BookService bookService) {
        System.out.printf("[AfterEach] %n");
        System.out.printf(" Authors size: %s%n", authorService.count());
        System.out.printf(" Books   size: %s%n", bookService.count());
    }

}
