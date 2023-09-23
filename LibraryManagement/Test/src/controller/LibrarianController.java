/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.LibrarianDAO;
import java.util.ArrayList;
import model.Librarian;
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
    
    public ArrayList<Librarian> getAllLibrarians(){
        ArrayList<Librarian> librarians = librarianDAO.selectAll();
        System.out.println("----Librarian list----");
        for (Librarian librarian : librarians) {
            System.out.println(librarian.toString());
        }
        return librarians;
    }
    
    public Librarian getLibrarianById() {
        
    int librarianId = MyUtils.inputPositiveNumber("Enter the Librarian ID you want to find: ");
    Librarian librarian = librarianDAO.selectById(librarianId);
    if (librarian != null) {
        System.out.println("Found librarian by ID: " + librarian.toString());
    } else {
        System.out.println("Librarian not found with the ID.");
    }
    return librarian;
}

}
