package dao;

import model.User;
import database.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class UserDAO {

    public UserDAO() {
    }

    public int insert(User user) {
        Connection con = JDBCUtil.getConnection();
        String sql = "INSERT INTO user(UserName, PassWord, UserType) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getUserType().toString());
            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted == 1) {
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1);
                    user.setUserId(generatedId);
                }
            }
            return rowsInserted;
        } catch (SQLException e) {
            return 0;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }
    }

    public int update(User t, int id) {
        Connection con = JDBCUtil.getConnection();
        String sql = "UPDATE user SET UserName=?, PassWord=?, UserType=? WHERE Id=?";

        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, t.getUsername());
            preparedStatement.setString(2, t.getPassword());
            preparedStatement.setString(3, t.getUserType().toString());
            preparedStatement.setInt(4, id); // id nhap vao

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

    public int delete(int id) {
        Connection con = JDBCUtil.getConnection();
        String sql = "DELETE FROM user WHERE Id=?";

        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setInt(1, id);

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

    public ArrayList<User> selectAll() {
        ArrayList<User> userList = new ArrayList<>();
        Connection con = JDBCUtil.getConnection();
        String sql = "SELECT * FROM user";

        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("Id");
                String username = resultSet.getString("UserName");
                String password = resultSet.getString("PassWord");
                String userTypeStr = resultSet.getString("UserType");
                User.UserType userType = User.UserType.valueOf(userTypeStr);

                User user = new User(id, username, password, userType);
                userList.add(user);
            }
        } catch (SQLException e) {
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }

        return userList;
    }

    public User selectById(int userId) {
        Connection con = JDBCUtil.getConnection();
        String sql = "SELECT * FROM user WHERE Id=?";

        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, userId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("Id");
                String username = resultSet.getString("UserName");
                String password = resultSet.getString("PassWord");
                String userTypeStr = resultSet.getString("UserType");
                User.UserType userType = User.UserType.valueOf(userTypeStr);

                return new User(userId, username, password, userType);
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

    public ArrayList<User> selectByCondition(String condition) {

        return new ArrayList<>();
    }

    public int getLastInsertedUserId() {
        int lastInsertedUserId = -1;
        String query = "SELECT LAST_INSERT_ID()";

        try (Connection connection = JDBCUtil.getConnection();
                Statement stmt = connection.createStatement();
                ResultSet resultSet = stmt.executeQuery(query)) {

            if (resultSet.next()) {
                lastInsertedUserId = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Error");
        }

        return lastInsertedUserId;
    }

}
