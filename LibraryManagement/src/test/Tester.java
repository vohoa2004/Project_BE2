package test;

import controller.BookController;
import controller.IssueBookController;
import controller.LibrarianController;
import model.Reader;
import controller.ReaderController;
import controller.UserController;
import java.util.ArrayList;
import java.util.Iterator;
import model.Book;

import model.IssueBook;

import model.User;
import utils.MyUtils;

public class Tester {

    public static void main(String[] args) {
        UserController userController = new UserController();
        ReaderController readerController = new ReaderController();
        LibrarianController librarianController = new LibrarianController();
        IssueBook issueBook = new IssueBook();
        BookController bookController = new BookController();
        IssueBookController issuebookController = new IssueBookController();        
//        //User user = userController.addReaderUser();
//        User user1 = userController.addLibrarianUser();
//        //test insert
//        //readerController.addReader(user.getUserId());
//        librarianController.addLibrarian(user1.getUserId());
//
//    
String readerId = MyUtils.inputString("Enter the reader ID: ");

// Get the list of books borrowed by the reader
ArrayList<IssueBook> issueBooks = issuebookController.searchIssueTransctionByReaderId(readerId);

// Print the list of books borrowed by the reader
if (!issueBooks.isEmpty()) {
    System.out.println("List of books borrowed by reader " + readerId + ": ");
            for (IssueBook issuebook : issueBooks) {
                System.out.println(issueBook);
            }
} else {
    System.out.println("This reader has not borrowed any books yet!");
}
//
//        Book newBook = bookController.getBookById(2);
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
//        bookController.addBook(8);
//                bookController.addBook(9);
//                        bookController.addBook(10);
//
//
////        test select all book
//        System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------------+");
//        System.out.println("|  ID  |                 Title                   |           Author          |    Price    |    Category    | TotalAvailable | BorrowDuration |");
//        System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------------+");
//        bookController.getAllBook();
//       //In bảng thủ thư
//        System.out.println("+---------------------------------------------------------------------------------------------------------------------+");
//        System.out.println("|    ID    |                Name                |            Email          |    Phone    |  Gender  |     Salary     |");
//        System.out.println("+---------------------------------------------------------------------------------------------------------------------+");
//        for(Librarian librarian: librarianController.getAllLibrarian()){
//            System.out.println(librarian.toString());
//        }
////      In bảng người đọc
//        System.out.println("+--------------------------------------------------------------------------------------------------------------+");
//        System.out.println("|    ID    | User ID |                Name                |            Email          |    Phone    |  Gender  |");
//        System.out.println("+--------------------------------------------------------------------------------------------------------------+");
//        for(Reader reader: readerController.getAllReaders()){
//            System.out.println(reader.toString());
//        }
//

////       In bảng user
//        System.out.println("+-----------------------------------------------------------------------------------------+");
//        System.out.println("| User ID |              Username              |         Password        |    User Type   |");
//        System.out.println("+-----------------------------------------------------------------------------------------+");
//        for(User user: userController.getAllUser()){
//            System.out.println(user.toString());
//        }
//        //Cập nhật thông tin sách
//        Book newBook = bookController.getBookById(2);
//        if(newBook != null){
//            newBook.setTitle("Tham tu lung danh conan");
//            boolean update = bookController.updateBook(newBook);
//            if(update){
//                    System.out.println("Update reader information successfully!");
//                } else {
//                    System.out.println("Error when updating reader.");
//                }
//            } else {
//                System.out.println("Reader not found with the specified ID.");
//            }
//            }
//        }
//
//
//        //test select all
//        System.out.println("Reader list:");
//        for (Reader reader : readerController.getAllReaders()) {
//            System.out.println(reader.toString());
//        }
//
//        // Cập nhật thông tin đọc giả
//            Reader newReader = readerController.getReaderById("R0005");
//            //System.out.println(newReader);
//            if (newReader != null) {
//                newReader.setName("Vy Vy");
//                boolean updated = readerController.updateReader(newReader);
//                if (updated) {
//                    System.out.println("Update reader information successfully!");
//                } else {
//                    System.out.println("Error when updating reader.");
//                }
//            } else {
//                System.out.println("Reader not found with the specified ID.");
//            }     
        } //test select all book
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
//        User user1 = userController.addLibrarianUser();
//        librarianController.addLibrarian(user1.getUserId());
//        //test getAllUser
//        userController.getAllUser();
//        //test updateUser
//        userController.updateUser();
//        //test gestAllLibrarian
//        librarianController.getAllLibrarians();
//        //test getLibrarianById
//        librarianController.getLibrarianById();

    void printBooksBorrowedByReader(String readerId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    
    }

