/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.Connection;

import database.JDBCUtil;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBCUtil {

    public static void main(String[] args) {

        try {
            // B??c 1: T?o k?t n?i
            Connection connection = JDBCUtil.getConnection();

            JDBCUtil.printInfo(connection);

            // B??c 2: T?o ra ??i t??ng statement
            Statement st = connection.createStatement();

            // B??c 3: Th?c thi m?t câu l?nh SQL
            String sql = "INSERT INTO user(Id, UserName, PassWord, UserType)"
                    + "VALUES (10, 'Hoa Vo', 'vohoa@gmail.com', 'READER')";

            int check = st.executeUpdate(sql);

            // B??c 4: x? lý k?t qu? 
            System.out.println("S? dòng thay ??i: " + check);
            if (check > 0) {
                System.out.println("Thêm d? li?u thành công!");
            } else {
                System.out.println("Thêm d? li?u th?t b?i!");
            }

            // B??c 5: ng?t k?t n?i
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}