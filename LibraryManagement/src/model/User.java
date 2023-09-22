package model;

/**
 *
 * @author vothimaihoa
 */
public class User {

    private int userId;
    private String username;
    private String password;

    public enum UserType {
        READER,
        LIBRARIAN
    }
    private UserType userType;

    //Constructor
    public User() {
    }

    public User(String username, String password, UserType userType) {
        this.username = username;
        this.password = password;
        this.userType = userType;
    }

    public User(int userId, String username, String password, UserType userType) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.userType = userType;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
//        System.out.println("+-----------------------------------------------------------------------------------------+");
//        System.out.println("| User ID |              Username              |         Password        |    User Type   |");
//        System.out.println("+-----------------------------------------------------------------------------------------+");
        return String.format("|    %-2d   | %-35s| %-24s| %-15s|",
                userId, username, password, userType);
    }
}
