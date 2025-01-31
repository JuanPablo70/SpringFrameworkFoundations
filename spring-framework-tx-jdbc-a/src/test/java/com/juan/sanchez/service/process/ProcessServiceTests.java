package com.juan.sanchez.service.process;

import com.juan.sanchez.config.AppConfig;
import com.juan.sanchez.domain.Author;
import com.juan.sanchez.domain.Book;
import com.juan.sanchez.factory.AuthorFactory;
import com.juan.sanchez.factory.BookFactory;
import com.juan.sanchez.service.ProcessService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;

@ActiveProfiles({"pre-prod","no-cache","exception-non","process-v2"})
@SpringJUnitConfig(classes={AppConfig.class})
@DisplayName("Testing All CRUD Processes Services")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProcessServiceTests {

    @Autowired
    private ProcessService processService;

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

}
