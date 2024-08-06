package com.juan.sanchez.repository.jdbc;

import com.juan.sanchez.domain.Book;
import com.juan.sanchez.repository.BookRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Collection;
import java.util.LinkedHashSet;

@Profile("repoB")
@Repository("bookRepositoryB")
class BookPBJdbcRepository implements BookRepository {

    private final DataSource dataSource;

    BookPBJdbcRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public String getBeanName() {
        return "bookRepositoryB";
    }

    @Override
    public Book save(Book book) {
        String sql = "INSERT INTO book (title, isbn, edition, publish_date, chapters, pages)" +
                "VALUES(?,?,?,?,?,?)";

        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);){
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getIsbn());
            ps.setInt(3, book.getEdition());
            ps.setDate(4, Date.valueOf(book.getPublishDate()));
            ps.setInt(5, book.getChapters());
            ps.setInt(6, book.getPages());
            int rowCount = ps.executeUpdate();
            if(rowCount == 1) {
                try(ResultSet rs = ps.getGeneratedKeys();){
                    while(rs.next()) {
                        book.setId(rs.getInt(1));
                    }
                }
            }
            else {
                throw new SQLException("Insert not success, value of: " + rowCount);
            }
        }
        catch(SQLException ex) {
            System.err.println("ERROR:" + ex.getMessage());
        }
        return book;

    }

    @Override
    public Book findById(int id) {
        Book book = null;
        String sql = "SELECT * FROM book l WHERE id=?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);){
            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()){
                if(isResultSetEmpty(rs)) {
                    while(rs.next()) {
                        book = mapBook(rs);
                    }
                }
                else {
                    return null;
                }
            }
        }
        catch(SQLException ex) {
            System.err.println("ERROR:" + ex.getMessage());
        }
        return book;
    }

    @Override
    public Collection<Book> findAll() {
        Collection<Book> books = new LinkedHashSet<>();
        String sql = "SELECT * FROM book";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();){
            if(isResultSetEmpty(rs)) {
                while(rs.next()) {
                    books.add(mapBook(rs));
                }
            }
            else {
                return null;
            }
        }
        catch(SQLException ex) {
            System.err.println("ERROR:" + ex.getMessage());
        }
        return books;
    }

    @Override
    public long count() {
        long count = 0;
        String sql = "SELECT COUNT(*) FROM book";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();){
            while(rs.next()) {
                count = rs.getLong(1);
            }
        }catch(SQLException ex) {
            System.err.println("ERROR:" + ex.getMessage());
        }
        return count;
    }

    @Override
    public Book update(Book book) {
        String sql = "UPDATE book SET title=?, isbn=? WHERE id=?";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);){
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getIsbn());
            ps.setInt(3, book.getId());
            int rowCount = ps.executeUpdate();
            if(rowCount != 1) {
                throw new SQLException("Update not success, value of: " + rowCount);
            }
        }
        catch(SQLException ex) {
            System.err.println("ERROR:" + ex.getMessage());
        }
        return book;
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM book WHERE id=?";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);){
            ps.setInt(1, id);
            int rowCount = ps.executeUpdate();
            if(rowCount != 1) {
                throw new SQLException("Delete not success, vlue of: " + rowCount);
            }
        }
        catch(SQLException ex) {
            System.err.println("ERROR:" + ex.getMessage());
        }
    }

    private boolean isResultSetEmpty(ResultSet rs) throws SQLException {
        return (rs.isBeforeFirst() || rs.getRow() != 0);
    }

    private Book mapBook(ResultSet rs) throws SQLException {
        Book book = new Book();
        book.setId(rs.getInt("id"));
        book.setTitle(rs.getString("title"));
        book.setIsbn(rs.getString("isbn"));
        book.setEdition(rs.getInt("edition"));
        book.setPublishDate(rs.getDate("publish_date").toLocalDate());
        book.setChapters(rs.getInt("chapters"));
        book.setPages(rs.getInt("pages"));
        return book;
    }

}
