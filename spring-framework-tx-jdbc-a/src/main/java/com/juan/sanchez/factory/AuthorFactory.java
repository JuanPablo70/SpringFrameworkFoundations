package com.juan.sanchez.factory;

import com.juan.sanchez.domain.Author;

import java.time.LocalDate;

public class AuthorFactory {

    public static Author createAuthorWithId11() {
        Author author = new Author();
        author.setId(11);
        author.setName("Charles");
        author.setLastname("Daniels");
        author.setBirthday(LocalDate.of(1997, 11, 28));
        return author;
    }

    private AuthorFactory() {}

}
