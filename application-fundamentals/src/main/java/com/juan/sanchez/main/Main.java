package com.juan.sanchez.main;

import com.juan.sanchez.factory.ApplicationFactory;
import com.juan.sanchez.service.BookService;

public class Main {

    public static void main(String[] args) {
        System.out.println("****************************************");
        System.out.println("Main - 'application-fundamentals' - Start");
        System.out.println("****************************************");
        ApplicationFactory.createApplication();
        BookService bookService = ApplicationFactory.getBookService();
        System.out.println("");
        System.out.println("--------------------");
        System.out.println("Report - 'findById'");
        System.out.println("--------------------");
        System.out.println("");
        bookService.report(bookService.findById(1));
        bookService.report(bookService.findById(15));
        bookService.report(bookService.findById(27));
        System.out.println("");
        System.out.println("-------------------");
        System.out.println("Report - 'findAll'");
        System.out.println("-------------------");
        System.out.println("");
        bookService.report(bookService.findAll());
        System.out.println("");
        System.out.println("----------------------");
        System.out.println("Report - 'count'");
        System.out.println("----------------------");
        System.out.println("");
        bookService.report(bookService.count());
        System.out.println("");
        System.out.println("*************************************");
        System.out.println("Main - 'application-fundamentals' - End");
        System.out.println("*************************************");
    }
}