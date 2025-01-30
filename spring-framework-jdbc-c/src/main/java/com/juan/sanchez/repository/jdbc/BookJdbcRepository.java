package com.juan.sanchez.repository.jdbc;

import com.juan.sanchez.domain.Book;
import com.juan.sanchez.repository.BookRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.Collection;

@Repository
class BookJdbcRepository implements BookRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    BookJdbcRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Book save(Book book) {
        String sql = "INSERT INTO book (title, isbn, edition, publish_date, chapters, pages, author_id)" +
                "VALUES(:title,:isbn,:edition,:publish_date,:chapters,:pages,:author_id)";

        SqlParameterSource sps = new MapSqlParameterSource()
                .addValue("title", book.getTitle())
                .addValue("isbn", book.getIsbn())
                .addValue("edition", book.getEdition())
                .addValue("publish_date", Date.valueOf(book.getPublishDate()))
                .addValue("chapters", book.getChapters())
                .addValue("pages", book.getPages())
                .addValue("author_id", book.getAuthorId());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql, sps, keyHolder);
        book.setId(keyHolder.getKey().intValue());
        return book;
    }

    @Override
    public Book findById(int id) {
        try {
            return namedParameterJdbcTemplate.queryForObject("SELECT * FROM book WHERE id=:id",
                    new MapSqlParameterSource().addValue("id", id), bookRowMapper);
        }
        catch(EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public Collection<Book> findAll() {
        return namedParameterJdbcTemplate.query("SELECT * FROM book", bookRowMapper);
    }

    @Override
    public long count() {
        return namedParameterJdbcTemplate.queryForObject("SELECT COUNT(*) FROM book", new MapSqlParameterSource(), Long.class);
    }

    @Override
    public Book update(Book book) {
        SqlParameterSource sps = new MapSqlParameterSource()
                .addValue("title", book.getTitle())
                .addValue("isbn", book.getIsbn())
                .addValue("edition", book.getEdition());
        namedParameterJdbcTemplate.update("UPDATE book SET title=:title, isbn=:isbn WHERE id=:id", sps);
        return book;
    }

    @Override
    public void delete(int id) {
        namedParameterJdbcTemplate.update("DELETE FROM book WHERE id=:id",
                new MapSqlParameterSource().addValue("id", id));
    }

    private boolean isResultSetEmpty(ResultSet rs) throws SQLException {
        return (!rs.isBeforeFirst() && rs.getRow()==0);
    }

    /**
     * Maps data from a `ResultSet` to a `Book` object.
     */
    RowMapper<Book> bookRowMapper = (rs, rowNum) -> {
        Book book = null;
        if(!isResultSetEmpty(rs)) {
            book = new Book();
            book.setId(rs.getInt("id"));
            book.setTitle(rs.getString("title"));
            book.setIsbn(rs.getString("isbn"));
            book.setEdition(rs.getInt("edition"));
            book.setPublishDate(rs.getDate("publish_date").toLocalDate());
            book.setChapters(rs.getInt("chapters"));
            book.setPages(rs.getInt("pages"));
            return book;
        } else {
            return book;
        }
    };

}
