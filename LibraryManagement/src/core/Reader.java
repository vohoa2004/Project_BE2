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
public class Reader extends User{
        private String id;
        private String name;
        private String email;
        private String phone;
        private String gender;
        private List<Book> issueBookList;
        
        //Constructor
        public Reader(){
        }
        
        public Reader( String id, String name, String email, String phone, String gender){
            this.id = id;
            this.name = name;
            this.email = email;
            this.phone = phone;
            this.gender = gender;
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
       
         public List<Book> getIssueBookList() {
        return issueBookList;
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

        public void setIssueBookList(List<Book> issueBookList) {
        this.issueBookList = issueBookList;
        }
 
        // to String 
         @Override
        public String toString() {
        return "Reader{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", gender='" + gender + '\'' +
                ", issueBookList=" + issueBookList +
                '}';
    }
        
}
