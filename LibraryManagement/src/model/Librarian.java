/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author vothimaihoa
 */
public class Librarian {

    private String librarianId;
    private int userId;
    private String name;
    private String email;
    private String phone;
    private String gender;
    private double salary;

    //Constructor
    public Librarian() {
    }

    public Librarian(String librarianId, int userId, String name, String email, String phone, String gender, double salary) {
        this.librarianId = librarianId;
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.salary = salary;
    }

    public Librarian(int userId, String name, String email, String phone, String gender, double salary) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.salary = salary;
    }
    
    public String getLibrarianId() {
        return librarianId;
    }

    public void setLibrarianId(String librarianId) {
        this.librarianId = librarianId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getGender() {
        return gender;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Librarian{" + "librarianId=" + librarianId +  ", name=" + name + ", email=" + email + ", phone=" + phone + ", gender=" + gender + ", salary=" + salary + '}';
    }

}
