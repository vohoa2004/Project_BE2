package controller;

import dao.UserDAO;
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

}
