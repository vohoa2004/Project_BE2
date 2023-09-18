/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.List;

/**
 *
 * @author vothimaihoa
 */
public class Librarian extends User {
      private String id;
        private String name;
        private String email;
        private String phone;
        private String gender;
        private double salary;
        
        //Constructor
        public Librarian(){
        }
        
        public Librarian(String id, String name, String email, String phone, String gender, double salary){
            this.id = id;
            this.name = name;
            this.email = email;
            this.phone = phone;
            this.gender = gender;
            this.salary = salary;
        }
        
        //Getter
        public String getID(){
            return id;
        }
        
        public String getName(){
            return name;
        }
        
        public String getEmail(){
            return email;
        }
        
        public String getPhone(){
            return phone;
        }
        
        public String getGender(){
            return gender;
        }
       
        public double getSalary() {
        return salary;
            }
         
        //setter
         public void setID(String id){
             this.id = id;
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
 
        // to String 
         @Override
        public String toString() {
        return "Librarian{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", gender='" + gender + '\'' +
                ", Salary=" + salary +
                '}';
        
    }  
}
