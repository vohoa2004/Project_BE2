package view;

import controller.UserController;
import model.User;
import utils.MyUtils;

/**
 *
 * @author vothimaihoa
 */
public class Main {

    public static void main(String[] args) {
        String header = "Library Management Program";
        String[] options = {
            "Login",
            "Close app"};

        UserController userController = new UserController();
        int choice;
        do{
        choice = Menu.getChoice(options, header);

        switch (choice) {
            case 1: {
                String userName = MyUtils.inputString("Enter username: ");
                String password = MyUtils.inputString("Enter password: ");
                User user = userController.getUserByUsername(userName);
                if (user == null) {
                    System.out.println("User not found!");
                } else if (!password.equals(user.getPassword())) {
                    int count = 0;
                    while (count <= 3) {
                        if (!password.equals(user.getPassword())) {
                            System.out.println("Incorrect password!");
                            password = MyUtils.inputString("Re-Enter password: ");
                            count++;
                        } else {
                            System.out.println("Login successfully!");
                            if (user.getUserType() == User.UserType.LIBRARIAN) {
                                Main_Librarian.mainLibrarian(userName);
                            } else {
                                Main_Reader.mainReader(userName);
                            }
                        }
                        if (count == 3) {
                            System.out.println("You enter wrong password 4 times! Sorry, bye bye!");
                            break;
                        }
                    }
                } else {
                    System.out.println("Login successfully!");
                    if (user.getUserType() == User.UserType.LIBRARIAN) {
                        Main_Librarian.mainLibrarian(userName);
                    } else {
                        Main_Reader.mainReader(userName);
                    }
                }
                break;
            }
            case 2: {
                System.out.println("Bye bye!");
                System.exit(0);
            }

        }
    }while(true);
        
    }
}
