package dao;

import model.Book;
import database.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    public BookDAO() {
    }

    public void insert(Book book) {
        Connection connection = JDBCUtil.getConnection();

        String sql = "INSERT INTO book(Title, Author, Price, Category, TotalAvailable, BorrowDuration) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setDouble(3, book.getPrice());
            preparedStatement.setString(4, book.getCategory());
            preparedStatement.setInt(5, book.getTotalAvailable());
            preparedStatement.setInt(6, book.getBorrowDuration());
            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Added new book successfully!");
            }
        } catch (SQLException ex) {
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
            }
        }
    }

    public int update(Book book) {
        Connection connection = JDBCUtil.getConnection();

        String sql = "UPDATE book SET Title=?, Author=?, Price=?, Category=?, TotalAvailable=?, BorrowDuration=? WHERE Id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setDouble(3, book.getPrice());
            preparedStatement.setString(4, book.getCategory());
            preparedStatement.setInt(5, book.getTotalAvailable());
            preparedStatement.setInt(6, book.getBorrowDuration());
            preparedStatement.setInt(7, book.getId());
            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated;
        } catch (SQLException ex) {
            return 0;
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {

            }
        }

    }

    public int delete(int bookId) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "DELETE FROM book WHERE Id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, bookId);
            int rowsDeleted = preparedStatement.executeUpdate();
            return rowsDeleted;
        } catch (SQLException ex) {
            return 0;
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {

            }
        }
    }

    public Book selectById(int bookId) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "SELECT * FROM book WHERE Id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, bookId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String title = resultSet.getString("Title");
                    String author = resultSet.getString("Author");
                    double price = resultSet.getDouble("Price");
                    String category = resultSet.getString("Category");
                    int totalAvailable = resultSet.getInt("TotalAvailable");
                    int borrowDuration = resultSet.getInt("BorrowDuration");
                    return new Book(bookId, title, author, price, category, totalAvailable, borrowDuration);
                }
            }
        } catch (SQLException ex) {
            return null;
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {

            }
        }
        return null;
    }

    public List<Book> selectAll() {
        Connection connection = JDBCUtil.getConnection();
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM book";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int bookId = resultSet.getInt("Id");
                String title = resultSet.getString("Title");
                String author = resultSet.getString("Author");
                double price = resultSet.getDouble("Price");
                String category = resultSet.getString("Category");
                int totalAvailable = resultSet.getInt("TotalAvailable");
                int borrowDuration = resultSet.getInt("BorrowDuration");

                books.add(new Book(bookId, title, author, price, category, totalAvailable, borrowDuration));
            }
        } catch (SQLException ex) {
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {

            }
        }
        return books;
    }
    
    
}
