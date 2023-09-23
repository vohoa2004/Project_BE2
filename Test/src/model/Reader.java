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
public class Reader {

    private String ReaderId;
    private int User_Id;
    private String name;
    private String email;
    private String phone;
    private String gender;

    public Reader() {
    }

    public Reader(String readerId, int userId, String name, String email, String phone, String gender) {
        this.ReaderId = readerId;
        this.User_Id = userId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
    }

    public Reader(int userId, String name, String email, String phone, String gender) {
        this.User_Id = userId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
    }

    public String getReaderId() {
        return ReaderId;
    }

    public void setReaderId(String ReaderId) {
        this.ReaderId = ReaderId;
    }

    public int getUser_Id() {
        return User_Id;
    }

    public void setUser_Id(int User_Id) {
        this.User_Id = User_Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Reader{" + "ReaderId=" + ReaderId + ", User_Id=" + User_Id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", gender=" + gender + '}';
    }

    
    
   
    
    
}
