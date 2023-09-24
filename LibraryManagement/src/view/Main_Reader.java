package view;

import controller.BookController;
import controller.IssueBookController;
import controller.ReaderController;
import controller.UserController;
import java.util.ArrayList;
import model.Book;
import model.Reader;
import model.User;
import utils.MyUtils;

/**
 *
 * @author vothimaihoa
 */
public class Main_Reader {

    public static void mainReader(String userName) {

        UserController userController = new UserController();
        ReaderController readerController = new ReaderController();
        BookController bookController = new BookController();
        IssueBookController issueBookController = new IssueBookController();
        User user = userController.getUserByUsername(userName);
        Reader reader = readerController.getReaderByUserId(user.getUserId());
        System.out.println();
        String header1 = "READER";
        String[] options1 = {"View your information", "Update your information",
            "Find book by title", "Find book by author", "Borrow book",
            "View borrowed book", "Return book", "Logout"};
        int selection;
        do {
            selection = Menu.getChoice(options1, header1);
            switch (selection) {
                case 1: {
                    // show reader information
                    System.out.println("+--------------------------------------------------------------------------------------------------------------+");
                    System.out.println("|    ID    | User ID |                Name                |            Email          |    Phone    |  Gender  |");
                    System.out.println("+--------------------------------------------------------------------------------------------------------------+");
                    System.out.println(readerController.getReaderByUserId(user.getUserId()));
                    System.out.println("+--------------------------------------------------------------------------------------------------------------+");
                    break;
                }
                case 2: {
                    String confirm = MyUtils.inputString("Do you want to update your password? (Y/y - Yes, Other - No)");
                    if (confirm.equalsIgnoreCase("y")) {
                        userController.updateUser(user);
                    }
                    System.out.println("Update other information: ");
                    readerController.updateReader(reader.getReaderId());
                    break;
                }
                case 3: {
                    // find book
                    String name = MyUtils.inputString("Enter book title: ");
                    ArrayList<Book> list = bookController.getBookByName(name);
                    System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------------+");
                    System.out.println("|  ID  |                 Title                   |           Author          |    Price    |    Category    | TotalAvailable | BorrowDuration |");
                    System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------------+");
                    bookController.showList(list);
                    System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------------+");
                    break;
                }
                case 4: {
                    String name = MyUtils.inputString("Enter book author: ");
                    System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------------+");
                    System.out.println("|  ID  |                 Title                   |           Author          |    Price    |    Category    | TotalAvailable | BorrowDuration |");
                    System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------------+");
                    ArrayList<Book> list = bookController.getBookByAuthor(name);
                    System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------------+");
                    bookController.showList(list);
                    break;
                }
                case 5: {
                    // nguoi dung tim sach, lay id roi dung id de muon
                    int bookId = MyUtils.inputInteger("Enter book id you want to borrow: ", 1, Integer.MAX_VALUE);
                    issueBookController.addNewIssueTransaction(bookId, reader.getReaderId());
                    break;
                }
                case 6: {
                    issueBookController.showIssueTransactionByReaderId(reader.getReaderId());
                    break;
                }
                case 7: {
                    if (issueBookController.searchIssueTransactionByReaderId(reader.getReaderId()).isEmpty()) {
                        System.out.println("You haven't made any issue book transactions!");
                    } else {
                        int id = MyUtils.inputInteger("Enter transaction id you want to return book: ", 1, Integer.MAX_VALUE);
                        if (issueBookController.searchIssueById(id).getReaderId().equals(reader.getReaderId())) {
                            issueBookController.returnIssueBook(id);
                        } else {
                            System.out.println("This transaction is not yours!");
                        }
                    }
                    break;
                }
                case 8: {
                    // LOGOUT
                    System.out.println("Bye Bye!");
                    System.exit(0);
                }
            }

        } while (selection != 8);

    }

}
