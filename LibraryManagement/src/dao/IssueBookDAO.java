package dao;

import model.IssueBook;
import database.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class IssueBookDAO {

    public IssueBookDAO() {
    }

    public void insert(IssueBook issueBook) {
        Connection connection = JDBCUtil.getConnection();

        String sql = "INSERT INTO issuebook(Quantity, Charges, Fine, "
                + "Issue_date, Due_date, Status, Book_Id, Reader_Id)"
                + "VALUES(?,?,?,?,?,?,?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, issueBook.getQuantity());
            preparedStatement.setDouble(2, issueBook.getCharges());
            preparedStatement.setDouble(3, issueBook.getFine());
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
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
            }
        }
    }

    public int update(IssueBook issueBook) {
        Connection connection = JDBCUtil.getConnection();

        String sql = "UPDATE issuebook SET "
                + "Quantity=?, Charges=?, Fine=?"
                + "Issue_date=?, Due_date=?, Status=?, "
                + "Book_id=?, Reader_Id WHERE Id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, issueBook.getQuantity());
            preparedStatement.setDouble(2, issueBook.getCharges());
            preparedStatement.setDouble(3, issueBook.getFine());
            preparedStatement.setDate(4, java.sql.Date.valueOf(issueBook.getIssueDate()));
            preparedStatement.setDate(5, java.sql.Date.valueOf(issueBook.getDueDate()));
            preparedStatement.setBoolean(6, issueBook.isBorrowing());
            preparedStatement.setInt(7, issueBook.getBookId());
            preparedStatement.setString(8, issueBook.getReaderId());
            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated;
        } catch (SQLException ex) {
            return 0;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
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
        String sql = "SELECT * FROM issueBook WHERE ReaderId=?";
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
                boolean status = resultSet.getBoolean("status");
                int book_id = resultSet.getInt("Book_id");

                list.add(new IssueBook(issueBookId, charges, issue_date.toLocalDate(), due_date.toLocalDate(), return_date.toLocalDate(),
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
                boolean status = resultSet.getBoolean("status");
                int book_id = resultSet.getInt("Book_id");
                String readerId = resultSet.getString("Reder_id");
                list.add(new IssueBook(issueBookId, charges, issue_date.toLocalDate(), due_date.toLocalDate(), return_date.toLocalDate(),
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
