package test;

import controller.BookController;
import controller.IssueBookController;
import controller.LibrarianController;
import model.Reader;
import controller.ReaderController;
import controller.UserController;
import model.Book;
import model.User;
import utils.MyUtils;

public class Tester {

    public static void main(String[] args) {
        UserController userController = new UserController();
        ReaderController readerController = new ReaderController();
        LibrarianController librarianController = new LibrarianController();
        IssueBookController issueBookController = new IssueBookController();
        BookController bookController = new BookController();

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
//        readerController.showAllReaders();
//        String readerId = MyUtils.inputString("Enter readerId: ");
//        System.out.println(readerController.getReaderById(readerId));
//        readerController.updateReader("R0001");
// test add new book
        // bookController.addBook();
//            System.out.println(newBook.toString());
//
//
//
//  
//
//test select all book
//        System.out.println("Book list:");
//        for (Book book : bookController.getAllBook()) {
//            System.out.println(book.toString());
//        }
//
//        //Cập nhật thông tin sách
//        Integer id = MyUtils.inputInteger("input id of book to update: ", 1, Integer.MAX_VALUE);
//        Book newBook = bookController.getBookById(id);
//
//        if (newBook != null) {
//            boolean update = bookController.updateBook(newBook);
//            if (update) {
//                System.out.println("Update reader information successfully!");
//            } else {
//                System.out.println("Error when updating reader.");
//            }
//        } else {
//            System.out.println("Reader not found with the specified ID.");
//        }
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
