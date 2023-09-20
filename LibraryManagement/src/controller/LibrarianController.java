/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.LibrarianDAO;
import database.JDBCUtil;
import java.sql.Connection;
import java.util.ArrayList;
import model.Librarian;
import model.Reader;
import utils.MyUtils;

/**
 *
 * @author vothimaihoa
 */
public class LibrarianController{
    private final LibrarianDAO librarianDAO;

    public LibrarianController() {
        librarianDAO = new LibrarianDAO();
    }
    
    public void addLibrarian(int userId) {
        //User_Id, Name, Gender, Email, Phone, Salary
        String name = MyUtils.inputString("Input name: ");
        String gender = MyUtils.inputString("Input gender (male or female): ");
        String email;
        email = MyUtils.inputString("Input email: ");
        while (!MyUtils.validateEmail(email)) {
             email = MyUtils.inputString("Invalid format. Re-Input email: ");
        } 

        String phone= MyUtils.inputString("Input phone number: ");
        while (!MyUtils.validatePhone(phone)){
            phone = MyUtils.inputString("Input phone number: ");
        }
        double salary = MyUtils.inputDouble("Salary: ", 0, Double.MAX_VALUE);
        Librarian librarian = new Librarian(userId, name, email, phone, gender, salary);
        librarianDAO.insert(librarian);
    }
    
    public void updateLibrarian(Librarian librarian) {
        librarianDAO.update(librarian);
    }
    
    
}
