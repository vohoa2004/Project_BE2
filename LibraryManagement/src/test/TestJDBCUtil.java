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
            // Bước 1: Tạo kết nối
            Connection connection = JDBCUtil.getConnection();

            JDBCUtil.printInfo(connection);

            // Bước 2: Tạo ra đối tượng statement
            Statement st = connection.createStatement();

            // Bước 3: Thực thi một câu lệnh SQL
            String sql = "INSERT INTO user(Id, UserName, PassWord, UserType)"
                    + "VALUES (10, 'Hoa Vo', 'vohoa@gmail.com', 'READER')";

            int check = st.executeUpdate(sql);

            // Bước 4: xử lý kết quả 
            System.out.println("Số dòng thay đổi: " + check);
            if (check > 0) {
                System.out.println("Thêm dữ liệu thành công!");
            } else {
                System.out.println("Thêm dữ liệu thất bại!");
            }

            // Bước 5: ngắt kết nối
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
