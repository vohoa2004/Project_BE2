package dao;

import model.IssueBook;
import database.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class IssueBookDAO {

    public IssueBookDAO() {
    }

    public void insert(IssueBook issueBook) {
        Connection connection = JDBCUtil.getConnection();

        String sql = "INSERT INTO issuebook(Quantity, Charges, Fine, "
                + "Issue_date, Due_date, Status, Book_Id, Reader_Id)"
                + "VALUES(?,?,?,?,?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, issueBook.getQuantity());
            preparedStatement.setDouble(2, issueBook.getCharges());
            preparedStatement.setDouble(3, 0.0);
            preparedStatement.setDate(4, java.sql.Date.valueOf(issueBook.getIssueDate()));
            preparedStatement.setDate(5, java.sql.Date.valueOf(issueBook.getDueDate()));
            preparedStatement.setBoolean(6, issueBook.isBorrowing());
            preparedStatement.setInt(7, issueBook.getBookId());
            preparedStatement.setString(8, issueBook.getReaderId());
            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Added new issue book transaction!");
            }

        } catch (SQLException ex) {
            System.out.println("Error SQLEx");
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error closing");
            }
        }
    }

    public int update(IssueBook issueBook) {
        Connection connection = JDBCUtil.getConnection();

        String sql = "UPDATE issuebook SET "
                + "Quantity=?, Charges=?, Fine=?, "
                + "Issue_date=?, Due_date=?, Status=?, "
                + "Book_id=?, Reader_Id=? WHERE Transaction_Id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, issueBook.getQuantity());
            preparedStatement.setDouble(2, issueBook.getCharges());
            preparedStatement.setDouble(3, issueBook.getFine());
            preparedStatement.setDate(4, java.sql.Date.valueOf(issueBook.getIssueDate()));
            preparedStatement.setDate(5, java.sql.Date.valueOf(issueBook.getDueDate()));
            preparedStatement.setBoolean(6, issueBook.isBorrowing());
            preparedStatement.setInt(7, issueBook.getBookId());
            preparedStatement.setString(8, issueBook.getReaderId());
            preparedStatement.setInt(9, issueBook.getTransactionId()); // Transaction_Id
            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated;
        } catch (SQLException ex) {
            System.out.println("SQLEx");
            return 0;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error closing");
            }
        }
    }

    public int delete(int bookIssueId) {
        Connection connection = JDBCUtil.getConnection();

        String sql = "DELETE FROM issuebook WHERE Id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, bookIssueId);
            preparedStatement.executeUpdate();
            int rowsDeleted = preparedStatement.executeUpdate();
            return rowsDeleted;
        } catch (SQLException ex) {
            return 0;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
            }
        }

    }

    public ArrayList<IssueBook> selectByReaderId(String readerId) {
        Connection connection = JDBCUtil.getConnection();

        ArrayList<IssueBook> list = new ArrayList<>();
        String sql = "SELECT * FROM issueBook WHERE Reader_Id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, readerId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int issueBookId = resultSet.getInt("Transaction_Id");
                int quantity = resultSet.getInt("Quantity");
                double charges = resultSet.getDouble("Charges");
                double fine = resultSet.getDouble("Fine");
                java.sql.Date issue_date = resultSet.getDate("Issue_date");
                java.sql.Date due_date = resultSet.getDate("Due_date");
                java.sql.Date return_date = resultSet.getDate("Return_date");
                LocalDate returnDate = (return_date != null) ? return_date.toLocalDate() : null;
                boolean status = resultSet.getBoolean("Status");
                int book_id = resultSet.getInt("Book_id");

                list.add(new IssueBook(issueBookId, charges, issue_date.toLocalDate(), due_date.toLocalDate(), returnDate,
                        fine, readerId, quantity, status, book_id));
            }
        } catch (SQLException ex) {
            return null;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
            }
        }
        return list;
    }

    public IssueBook selectById(int transactionId) {
        Connection connection = JDBCUtil.getConnection();
        IssueBook result = null;
        String sql = "SELECT * FROM issueBook WHERE transaction_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, transactionId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int quantity = resultSet.getInt("Quantity");
                double charges = resultSet.getDouble("Charges");
                double fine = resultSet.getDouble("Fine");
                java.sql.Date issue_date = resultSet.getDate("Issue_date");
                java.sql.Date due_date = resultSet.getDate("Due_date");
                java.sql.Date return_date = resultSet.getDate("Return_date");
                LocalDate returnDate = (return_date != null) ? return_date.toLocalDate() : null;
                boolean status = resultSet.getBoolean("Status");
                int book_id = resultSet.getInt("Book_Id");
                String reader_id = resultSet.getString("Reader_Id");

                result = new IssueBook(transactionId, charges,
                        issue_date.toLocalDate(), due_date.toLocalDate(),
                        returnDate, fine, reader_id, quantity, status, book_id);
            }
        } catch (SQLException ex) {
            System.out.println("SQLEX");
            return null;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
            }
        }
        return result;

    }

    public ArrayList<IssueBook> selectAll() {
        Connection connection = JDBCUtil.getConnection();

        ArrayList<IssueBook> list = new ArrayList<>();
        String sql = "SELECT * FROM IssueBook";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int issueBookId = resultSet.getInt("Transaction_Id");
                int quantity = resultSet.getInt("Quantity");
                double charges = resultSet.getDouble("Charges");
                double fine = resultSet.getDouble("Fine");
                java.sql.Date issue_date = resultSet.getDate("Issue_date");
                java.sql.Date due_date = resultSet.getDate("Due_date");
                java.sql.Date return_date = resultSet.getDate("Return_date");
                LocalDate returnDate = null;
                if (return_date != null) {
                    returnDate = return_date.toLocalDate();
                }
                boolean status = resultSet.getBoolean("Status");
                int book_id = resultSet.getInt("Book_Id");
                String readerId = resultSet.getString("Reader_Id");
                list.add(new IssueBook(issueBookId, charges, issue_date.toLocalDate(), due_date.toLocalDate(), 
                        returnDate,
                        fine, readerId, quantity, status, book_id));
            }
        } catch (SQLException e) {
            return null;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
            }
        }
        return list;
    }

}