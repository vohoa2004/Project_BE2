package dao;

import model.Librarian;
import database.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LibrarianDAO{

    public LibrarianDAO() {
    }

    public void insert(Librarian librarian) {
        Connection con = JDBCUtil.getConnection();
        String sql = "INSERT INTO Librarian (User_Id, Name, Gender, Email, Phone, Salary) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setInt(1, librarian.getUserId());
            preparedStatement.setString(2, librarian.getName());
            preparedStatement.setString(3, librarian.getGender());
            preparedStatement.setString(4, librarian.getEmail());
            preparedStatement.setString(5, librarian.getPhone());
            preparedStatement.setDouble(6, librarian.getSalary());

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Added librarian successfully!");
            }
        } catch (SQLException e) {
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }
    }

    public int update(Librarian librarian) {
        Connection con = JDBCUtil.getConnection();
        String sql = "UPDATE Librarian SET Name=?, Gender=?, Email=?, Phone=?, Salary=? WHERE LibrarianId=?";

        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, librarian.getName());
            preparedStatement.setString(2, librarian.getGender());
            preparedStatement.setString(3, librarian.getEmail());
            preparedStatement.setString(4, librarian.getPhone());
            preparedStatement.setDouble(5, librarian.getSalary());
            preparedStatement.setString(6, librarian.getLibrarianId());

            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated;
        } catch (SQLException e) {
            return 0;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }
    }

    public int delete(String librarianId) {
        Connection con = JDBCUtil.getConnection();
        String sql = "DELETE FROM Librarian WHERE LibrarianId=?";

        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, librarianId);

            int rowsDeleted = preparedStatement.executeUpdate();
            return rowsDeleted;
        } catch (SQLException e) {
            return 0;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }
    }

    public ArrayList<Librarian> selectAll() {
        ArrayList<Librarian> librarianList = new ArrayList<>();
        Connection con = JDBCUtil.getConnection();
        String sql = "SELECT * FROM Librarian";

        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int userId = resultSet.getInt("User_Id");
                String librarianId = resultSet.getString("LibrarianId");
                String name = resultSet.getString("Name");
                String gender = resultSet.getString("Gender");
                String email = resultSet.getString("Email");
                String phone = resultSet.getString("Phone");
                double salary = resultSet.getDouble("Salary");

                Librarian librarian = new Librarian(librarianId, userId, name, email, phone, gender, salary);
                librarianList.add(librarian);
            }
        } catch (SQLException e) {
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }

        return librarianList;
    }

    public Librarian selectById(int librarianId) {
        Connection con = JDBCUtil.getConnection();
        String sql = "SELECT * FROM Librarian WHERE LibrarianId=?";

        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, librarianId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int userId = resultSet.getInt("User_Id");
                String name = resultSet.getString("Name");
                String gender = resultSet.getString("Gender");
                String email = resultSet.getString("Email");
                String phone = resultSet.getString("Phone");
                double salary = resultSet.getDouble("Salary");

                return new Librarian(Integer.toString(librarianId), userId, name, email, phone, gender, salary);
            }
        } catch (SQLException e) {
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }

        return null;
    }

}
