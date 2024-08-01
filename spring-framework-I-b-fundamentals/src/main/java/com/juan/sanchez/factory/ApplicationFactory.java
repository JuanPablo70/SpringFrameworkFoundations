package com.juan.sanchez.factory;

import com.juan.sanchez.repository.BookRepository;
import com.juan.sanchez.repository.jdbc.BookJdbcRepository;
import com.juan.sanchez.service.BookService;
import com.juan.sanchez.service.impl.BookServiceImpl;

/**
 * @deprecated AppConfig
 */
@Deprecated
public class ApplicationFactory {

//    private static BookService bookService;
//
//    private static InfrastructureConfig createInfrastructureConfig() {
//        return new InfrastructureConfig();
//    }
//
//    private static BookRepository createBookRepository() {
//        return new BookJdbcRepository(createInfrastructureConfig().createDataSourceMysql());
//    }
//
//    private static void createBookService() {
//        if (bookService == null) {
//            bookService = new BookServiceImpl(createBookRepository());
//        }
//    }
//
//    public static void createApplication() {
//        createBookService();
//    }
//
//    public static BookService getBookService() {
//        return bookService;
//    }
//
//    private ApplicationFactory() {
//    }

}
