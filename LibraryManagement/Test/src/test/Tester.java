package test;

import controller.LibrarianController;

import controller.UserController;
import model.User;

public class Tester {

    public static void main(String[] args) {
        UserController userController = new UserController();
        LibrarianController librarianController = new LibrarianController();
        

        User user1 = userController.addLibrarianUser();
        librarianController.addLibrarian(user1.getUserId());
        //test getAllUser
        userController.getAllUser();
        //test updateUser
        userController.updateUser();
        //test gestAllLibrarian
        librarianController.getAllLibrarians();
        //test getLibrarianById
        librarianController.getLibrarianById();

    }

}