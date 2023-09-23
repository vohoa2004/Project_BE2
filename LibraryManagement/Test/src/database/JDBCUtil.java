/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class JDBCUtil {
        public static Connection getConnection(){
        Connection c = null;
        try {
            // đăng ký MySQL Driver vs DriverManager
            // thông qua drivermanager lấy ra dc 1 connection
            com.mysql.cj.jdbc.Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
            // các thông số
            String url = "jdbc:mysql://localhost:3306/Librarymanagement";
            String username = "root";
            String password ="tien3101";
            // tạo kết nối
            c = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }
	
	
	public static void closeConnection(Connection c) {
		try {
			if(c!=null) {
				c.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void printInfo(Connection c) {
		try {
			if(c!=null) {
				DatabaseMetaData mtdt = c.getMetaData();
				System.out.println(mtdt.getDatabaseProductName());
				System.out.println(mtdt.getDatabaseProductVersion());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}