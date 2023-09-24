package controller;

import dao.UserDAO;
import java.util.ArrayList;
import model.User;
import utils.MyUtils;

/**
 *
 * @author vothimaihoa
 */
public class UserController {

    private final UserDAO userDAO;

    public UserController() {
        userDAO = new UserDAO();
    }

    public User addReaderUser() {
        String userName = MyUtils.inputString("Input user name: ");
        while(!MyUtils.validateUsername(userName)) {
            userName = MyUtils.inputString("Input user name: ");
        }
                
        String password = MyUtils.inputString("Input password: ");
        User.UserType userType = User.UserType.READER;

        User user = new User(userName, password, userType);
        int insertedRows = userDAO.insert(user);

        if (insertedRows == 1) {
            System.out.println("Added new user with ID: " + user.getUserId());
        } else {
            System.out.println("Error when adding user.");
        }
        return user;
    }
    
    public User addLibrarianUser() {
        String userName = MyUtils.inputString("Input user name: ");
        while(!MyUtils.validateUsername(userName)) {
            userName = MyUtils.inputString("Input user name: ");
        }
                
        String password = MyUtils.inputString("Input password: ");
        User.UserType userType = User.UserType.LIBRARIAN;

        User user = new User(userName, password, userType);
        int insertedRows = userDAO.insert(user);

        if (insertedRows == 1) {
            System.out.println("Added new user with ID: " + user.getUserId());
        } else {
            System.out.println("Error when adding user.");
        }
        return user;
    }
    
    public void updateUser() {      
    int userIdToUpdate = MyUtils.inputPositiveNumber("Enter the User ID you want to update: ");
    User userUpdate = userDAO.selectById(userIdToUpdate);
    
    if (userUpdate != null) {
        String newPassword = MyUtils.inputString("Enter your new password: ");
        userUpdate.setPassword(newPassword);
        int rowUpdated = userDAO.update(userUpdate, userIdToUpdate);
        if (rowUpdated == 1) {
            System.out.println("Password updated successfully with ID: " + userIdToUpdate);
        } else {
            System.out.println("Fail to update password!!!");
        }
    } else {
        System.out.println("User with ID " + userIdToUpdate + " not found. Please enter again!!");
    }
    }
    
    public ArrayList<User> getAllUser(){
        ArrayList<User> users = userDAO.selectAll();
        System.out.println("----User list----");
        for (User user : users) {
            System.out.println(user.toString());
        }
        return users;
    }

}