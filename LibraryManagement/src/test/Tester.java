package test;

import controller.IssueBookController;
import controller.LibrarianController;
import model.Reader;
import controller.ReaderController;
import controller.UserController;
import model.User;
import utils.MyUtils;

public class Tester {

    public static void main(String[] args) {
        UserController userController = new UserController();
        ReaderController readerController = new ReaderController();
        LibrarianController librarianController = new LibrarianController();
        IssueBookController issueBookController = new IssueBookController();

        // test add
//        //User user = userController.addReaderUser();
//        User user1 = userController.addLibrarianUser();

        //test insert
        //readerController.addReader(user.getUserId());
        //librarianController.addLibrarian(user1.getUserId());

        //test select all
//       

        
        // test issue book
        // add new issue book
        //issueBookController.addNewIssueTransaction(1, "R0004");
        
        //test trả sách
        //issueBookController.returnIssueBook(1);
        
        //test reader
        readerController.showAllReaders();
        String readerId = MyUtils.inputString("Enter readerId: ");
        System.out.println(readerController.getReaderById(readerId));
        readerController.updateReader("R0001");
    }

}
