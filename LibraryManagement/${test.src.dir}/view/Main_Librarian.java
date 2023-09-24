package view;

import controller.BookController;
import controller.IssueBookController;
import controller.LibrarianController;
import controller.ReaderController;
import controller.UserController;
import java.util.ArrayList;
import java.util.Scanner;
import model.Book;
import model.IssueBook;
import model.Librarian;
import model.Reader;
import model.User;
import utils.MyUtils;

/**
 *
 * @author vothimaihoa
 */
public class Main_Librarian {

    public static void mainLibrarian(String userName2) {

        UserController userController = new UserController();
        ReaderController readerController = new ReaderController();
        BookController bookController = new BookController();
        IssueBookController issueBookController = new IssueBookController();
        LibrarianController librarianController = new LibrarianController();
        User user = userController.getUserByUsername(userName2);
        Librarian librarian = librarianController.getLibrarianByUserId(user.getUserId());
        System.out.println();
        String header2 = "LIBRARIAN";
        String[] options2 = {"View your information", "Update your information", "Manage books",
            "Manage readers", "Manage transactions", "Logout"};
        int selection;
        do {
            selection = Menu.getChoice(options2, header2);
            switch (selection) {
                case 1: {

                    if (librarian != null) {
                        System.out.println(librarian);
                    } else {
                        System.out.println("Not found your information!");
                    }
                    break;
                }
                case 2: {

                    if (librarian != null) {
                        librarianController.updateLibrarian(librarian.getLibrarianId());
                    } else {
                        System.out.println("Not found your information!");
                    }
                    break;
                }
                case 3: {
                    System.out.println();
                    String header2a = "BOOK";
                    String[] options2a = {"Add new book",
                        "Find book by title", "Find book by author",
                        "Update book information", "Show book list"};
                    int option;
                    //do {
                    option = Menu.getChoice(options2a, header2a);
                    switch (option) {
                        case 1: {
                            bookController.addBook();
                            break;
                        }
                        case 2: {
                            String name = MyUtils.inputString("Enter book title: ");
                            ArrayList<Book> list = bookController.getBookByName(name);
                            bookController.showList(list);
                            break;
                        }
                        case 3: {
                            String name = MyUtils.inputString("Enter book author: ");
                            ArrayList<Book> list = bookController.getBookByAuthor(name);
                            bookController.showList(list);
                            break;
                        }
                        case 4: {
                            int id = MyUtils.inputInteger("Enter book id: ", 1, Integer.MAX_VALUE);
                            Book book = bookController.getBookById(id);
                            bookController.updateBook(book);
                            break;
                        }
                        case 5: {
                            ArrayList<Book> books = bookController.getAllBook();
                            bookController.showList(books);
                        }

                    }
                    break;
                }
                case 4: {
                    System.out.println();
                    String header2a = "READER";
                    String[] options2a = {"Add new reader user",
                        "Search reader by reader id",
                        "Show reader list"};
                    int option;
                    //do {
                    option = Menu.getChoice(options2a, header2a);
                    switch (option) {
                        case 1: {
                            //reader den thu vien dang ky tai khoan, thu thu tao tai khoan cho reader, voi mat khau default
                            User newUser = userController.addReaderUser();
                            readerController.addReader(newUser.getUserId());
                            break;
                        }
                        case 2: {
                            String id = MyUtils.inputString("Enter reader id: ");
                            Reader reader = readerController.getReaderById(id);
                            System.out.println(reader);
                            break;
                        }
                        case 3: {

                            ArrayList<Reader> list = readerController.getAllReaders();
                            for (Reader x : list) {
                                System.out.println(x.toString());
                            }
                            break;
                        }

                    }
                    break;
                }
                case 5: {
                    System.out.println();
                    String header2a = "ISSUE TRANSACTION";
                    String[] options2a = {"Create issue book transaction",
                        "See all issue book transaction", "Search issue book transaction by reader id",
                        "Return book for a reader"};
                    int option;
                    //do {
                    option = Menu.getChoice(options2a, header2a);
                    switch (option) {
                        case 1: {
                            int bookId = MyUtils.inputInteger("Enter book ID: ", 1, Integer.MAX_VALUE);
                            String readerId = MyUtils.inputString("Enter reader id: ");
                            issueBookController.addNewIssueTransaction(bookId, readerId);
                            break;
                        }
                        case 2: {
                            issueBookController.showAllIssueBookTransaction();
                            break;
                        }
                        case 3: {
                            String readerId = MyUtils.inputString("Enter reader id: ");
                            ArrayList<IssueBook> list = issueBookController.searchIssueTransactionByReaderId(readerId);
                            if (list.isEmpty()) {
                                System.out.println("This reader hasn't made any transactions!");
                            } else {
                                for (IssueBook i : list) {
                                    System.out.println(i.toString());
                                }
                            }

                            break;
                        }
                        case 4: {
                            int id = MyUtils.inputInteger("Enter transaction id: ", 1, Integer.MAX_VALUE);
                            issueBookController.returnIssueBook(id);
                            break;

                        }

                    }
                    break;
                }
                case 6: {
                    System.out.println("Logout successfully!");
                    return;
                }
            }

        } while (selection != 6);

    }
}
