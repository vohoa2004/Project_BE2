package dao;

import database.JDBCUtil;
import model.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReaderDAO {

    public ReaderDAO() {
    }

    public void insert(Reader reader) {
        Connection connection = JDBCUtil.getConnection();

        String sql = "INSERT INTO reader(User_Id, Name, Gender, Email, Phone) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, reader.getUser_Id());
            preparedStatement.setString(2, reader.getName());
            preparedStatement.setString(3, reader.getGender());
            preparedStatement.setString(4, reader.getEmail());
            preparedStatement.setString(5, reader.getPhone());
            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Added new reader!");
            }
        } catch (SQLException e) {
            System.out.println("Error adding new user");
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {

            }
        }
    }

    public int update(Reader reader) {
        Connection connection = JDBCUtil.getConnection();

        String sql = "UPDATE reader SET Name=?, Gender=?, Email=?, Phone=? WHERE ReaderId=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, reader.getName());
            preparedStatement.setString(2, reader.getGender());
            preparedStatement.setString(3, reader.getEmail());
            preparedStatement.setString(4, reader.getPhone());
            preparedStatement.setString(5, reader.getReaderId());
            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated;
        } catch (SQLException e) {
            return 0;
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {

            }
        }
    }

    public int delete(String readerId) {
        Connection connection = JDBCUtil.getConnection();

        String sql = "DELETE FROM reader WHERE readerId=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, readerId);
            int rowsDeleted = preparedStatement.executeUpdate();
            return rowsDeleted;
        } catch (SQLException e) {
            return 0;
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {

            }
        }
    }

    public Reader selectById(String readerId) {
        Connection connection = JDBCUtil.getConnection();

        System.out.println(readerId);
        String sql = "SELECT * FROM reader WHERE readerId=?";
        Reader result = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, readerId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int userId = resultSet.getInt("User_Id");
                String name = resultSet.getString("Name");
                String gender = resultSet.getString("Gender");
                String email = resultSet.getString("Email");
                String phone = resultSet.getString("Phone");

                result = new Reader(readerId, userId, name, email, phone, gender);
            }
        } catch (SQLException e) {
            System.out.println("error 1");
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                System.out.println("error 2");
            }
        }
        return result;
    }
    
    public Reader selectByUserId(int userId) {
        Connection connection = JDBCUtil.getConnection();
       
        String sql = "SELECT * FROM reader WHERE User_Id=?";
        Reader result = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String readerId = resultSet.getString("readerId");
                String name = resultSet.getString("Name");
                String gender = resultSet.getString("Gender");
                String email = resultSet.getString("Email");
                String phone = resultSet.getString("Phone");

                result = new Reader(readerId, userId, name, email, phone, gender);
            }
        } catch (SQLException e) {
            System.out.println("error 1");
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                System.out.println("error 2");
            }
        }
        return result;
    }

    public ArrayList<Reader> selectAll() {
        Connection connection = JDBCUtil.getConnection();

        ArrayList<Reader> readers = new ArrayList<>();
        String sql = "SELECT * FROM reader";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int userId = resultSet.getInt("User_Id");
                String readerId = resultSet.getString("ReaderId");
                String name = resultSet.getString("Name");
                String gender = resultSet.getString("Gender");
                String email = resultSet.getString("Email");
                String phone = resultSet.getString("Phone");

                readers.add(new Reader(readerId, userId, name, email, phone, gender));
            }
        } catch (SQLException e) {
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {

            }
        }
        return readers;
    }
}