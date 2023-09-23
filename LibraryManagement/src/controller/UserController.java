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
        String userName = MyUtils.inputString("Input username: ");
        while (!MyUtils.validateUsername(userName) || !isUsernameUnique(userName)) {
            if (!MyUtils.validateUsername(userName)) {
                System.out.println("username cannot contains space!");
            }
            if (!isUsernameUnique(userName)) {
                System.out.println("This username is existed!");
            }
            userName = MyUtils.inputString("Input user name: ");
        }

        String password = userName.substring(0,3) + "123"; // default password
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
        String userName = MyUtils.inputString("Input username: ");
        while (!MyUtils.validateUsername(userName) || !isUsernameUnique(userName)) {
            if (!MyUtils.validateUsername(userName)) {
                System.out.println("username cannot contains space!");
            }
            if (!isUsernameUnique(userName)) {
                System.out.println("This username is existed!");
            }
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

    public void updateUser(User userUpdate) {
        if (userUpdate != null) {
            int userIdToUpdate = userUpdate.getUserId();
            String newPassword = MyUtils.inputString("Enter your new password: ");
            userUpdate.setPassword(newPassword);
            int rowUpdated = userDAO.update(userUpdate, userUpdate.getUserId());
            if (rowUpdated == 1) {
                System.out.println("Password updated successfully with ID: " + userIdToUpdate);
            } else {
                System.out.println("Fail to update password!!!");
            }
        } else {
            System.out.println("User with this ID not found. Please enter again!!");
        }
    }

    public ArrayList<User> getAllUser() {
        ArrayList<User> users = userDAO.selectAll();
        return users;
    }
    
    public void showAllUser() {
        ArrayList<User> users = getAllUser();
        System.out.println("----User list----");
        for (User user : users) {
            System.out.println(user.toString());
        }
    }

    public boolean isUsernameUnique(String userName) {
        boolean result = true;
        ArrayList<User> users = getAllUser();
        for (User x : users) {
            if (x.getUsername().equalsIgnoreCase(userName)) {
                result = false;
                break;
            }
        }
        return result;

    }
    
    public User getUserByUsername(String userName) {
        User result = null;
        ArrayList<User> users = getAllUser();
        for (User x : users) {
            if (x.getUsername().equalsIgnoreCase(userName)) {
                result = x;
            }
        }
        return result;
    }

}
