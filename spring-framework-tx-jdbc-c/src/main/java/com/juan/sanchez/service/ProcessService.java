package com.juan.sanchez.service;

import com.juan.sanchez.domain.Author;
import com.juan.sanchez.domain.Book;

public interface ProcessService {

    void createProcess(Author author, Book book) throws Exception;
    void readProcess(int idAuthor) throws Exception;
    void updateProcess(int idAuthor) throws Exception;
    void deleteProcess(int idAuthor) throws Exception;

}
