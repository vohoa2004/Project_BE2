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
            "Manage readers", "Manage transactions", "Manage other librarians (only for head librarian)", "Logout",};
        int selection;
        do {
            selection = Menu.getChoice(options2, header2);
            switch (selection) {
                case 1: {

                    if (librarian != null) {
                        System.out.println("+---------------------------------------------------------------------------------------------------------------------+");
                        System.out.println("|Reader ID |                Name                |            Email          |    Phone    |  Gender  |     Salary     |");
                        System.out.println("+---------------------------------------------------------------------------------------------------------------------+");
                        System.out.println(librarianController.getLibrarianByUserId(user.getUserId()));
                        System.out.println("+---------------------------------------------------------------------------------------------------------------------+");
                    } else {
                        System.out.println("Not found your information!");
                    }
                    break;
                }
                case 2: {
                    if (librarian != null) {
                        String confirm = MyUtils.inputString("Do you want to update your password? (Y/y - Yes, Other - No)");
                        if (confirm.equalsIgnoreCase("y")) {
                            userController.updateUser(user);
                        }
                        System.out.println("Update other information: ");
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
                        "Update book information", "Show book list", "Back to Main Menu"};
                    int option;
                    do {
                        option = Menu.getChoice(options2a, header2a);
                        switch (option) {
                            case 1: {
                                bookController.addBook();
                                break;
                            }
                            case 2: {
                                String name = MyUtils.inputString("Enter book title: ");

                                ArrayList<Book> list = bookController.getBookByName(name);
                                System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------------+");
                                System.out.println("|  ID  |                 Title                   |           Author          |    Price    |    Category    | TotalAvailable | BorrowDuration |");
                                System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------------+");
                                bookController.showList(list);
                                System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------------+");
                                break;
                            }
                            case 3: {
                                String name = MyUtils.inputString("Enter book author: ");
                                ArrayList<Book> list = bookController.getBookByAuthor(name);
                                System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------------+");
                                System.out.println("|  ID  |                 Title                   |           Author          |    Price    |    Category    | TotalAvailable | BorrowDuration |");
                                System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------------+");
                                bookController.showList(list);
                                System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------------+");
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
                                System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------------+");
                                System.out.println("|  ID  |                 Title                   |           Author          |    Price    |    Category    | TotalAvailable | BorrowDuration |");
                                System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------------+");
                                bookController.showList(books);
                                System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------------+");
                                break;
                            }
                            case 6: {
                                option = 0;
                                break;
                            }

                        }
                    } while (option != 0);
                    break;
                }
                case 4: {
                    System.out.println();
                    String header2a = "READER";
                    String[] options2a = {"Add new reader user",
                        "Search reader by reader id",
                        "Show reader list", "Back to Main Menu"};
                    int option;
                    do {
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
                                if (reader!= null){
                                System.out.println("+--------------------------------------------------------------------------------------------------------------+");
                                System.out.println("|Reader ID | User ID |                Name                |            Email          |    Phone    |  Gender  |");
                                System.out.println("+--------------------------------------------------------------------------------------------------------------+");
                                System.out.println(reader);
                                System.out.println("+--------------------------------------------------------------------------------------------------------------+");
                                }
                                else{
                                    System.out.println("Not found this reader!");
                                }
                                 break;
                            }
                            case 3: {

                                ArrayList<Reader> list = readerController.getAllReaders();
                                System.out.println("+--------------------------------------------------------------------------------------------------------------+");
                                System.out.println("|Reader ID | User ID |                Name                |            Email          |    Phone    |  Gender  |");
                                System.out.println("+--------------------------------------------------------------------------------------------------------------+");
                                for (Reader x : list) {
                                    System.out.println(x.toString());
                                }
                                System.out.println("+--------------------------------------------------------------------------------------------------------------+");
                                break;
                            }
                            case 4: {
                                option = 0;
                                break;
                            }

                        }
                    } while (option != 0);
                    break;
                }
                case 5: {
                    System.out.println();
                    String header2a = "ISSUE TRANSACTION";
                    String[] options2a = {"Create issue book transaction",
                        "See all issue book transaction", "Search issue book transaction by reader id",
                        "Return book for a reader", "Back to Main Menu"};
                    int option;
                    do {
                        option = Menu.getChoice(options2a, header2a);
                        switch (option) {
                            case 1: {
                                int bookId = MyUtils.inputInteger("Enter book ID: ", 1, Integer.MAX_VALUE);
                                String readerId = MyUtils.inputString("Enter reader id: ");
                                issueBookController.addNewIssueTransaction(bookId, readerId);
                                break;
                            }
                            case 2: {
                                System.out.println(Menu.getTableIssueFooter());
                                System.out.println(Menu.getTableIssueHeader());
                                System.out.println(Menu.getTableIssueFooter());
                                issueBookController.showAllIssueBookTransaction();
                                System.out.println(Menu.getTableIssueFooter());
                                break;
                            }
                            case 3: {
                                String readerId = MyUtils.inputString("Enter reader id: ");
                                ArrayList<IssueBook> list = issueBookController.searchIssueTransactionByReaderId(readerId);
                                if (list.isEmpty()) {
                                    System.out.println("This reader hasn't made any transactions!");
                                } else {
                                    System.out.println(Menu.getTableIssueFooter());
                                    System.out.println(Menu.getTableIssueHeader());
                                    System.out.println(Menu.getTableIssueFooter());
                                    for (IssueBook i : list) {
                                        System.out.println(i.toString());
                                    }
                                    System.out.println(Menu.getTableIssueFooter());
                                }

                                break;
                            }
                            case 4: {
                                int id = MyUtils.inputInteger("Enter transaction id: ", 1, Integer.MAX_VALUE);
                                if (issueBookController.searchIssueById(id) == null) {
                                    System.out.println("This transaction is not existed!");
                                } else {
                                    issueBookController.returnIssueBook(id);
                                }
                                break;

                            }
                            case 5: {
                                option = 0;
                                break;
                            }

                        }
                    } while (option != 0);
                    break;
                }
                case 6: {
                    System.out.println();
                    if (!librarian.getLibrarianId().equals("L0001")) {
                        System.out.println("Sorry! this feature is not available for you!");
                    } else {
                        String header2a = "MANAGE OTHER LIBRARIAN";
                        String[] options2a = {"Add new librarian", "See list of all librarians",
                            "Search librarian by librarian id",
                            "Update salary for a librarian", "Back to Main Menu"};
                        int option;
                        do {
                            option = Menu.getChoice(options2a, header2a);
                            switch (option) {
                                case 1: {
                                    User newUser = userController.addLibrarianUser();
                                    librarianController.addLibrarian(newUser.getUserId());
                                    break;
                                }
                                case 2: {
                                    ArrayList<Librarian> list = librarianController.findAllLibrarians();
                                    if (!list.isEmpty()) {
                                        System.out.println("+---------------------------------------------------------------------------------------------------------------------+");
                                        System.out.println("|    ID    |                Name                |            Email          |    Phone    |  Gender  |     Salary     |");
                                        System.out.println("+---------------------------------------------------------------------------------------------------------------------+");
                                        for (Librarian x : list) {
                                            System.out.println(x.toString());
                                        }
                                        System.out.println("+---------------------------------------------------------------------------------------------------------------------+");
                                    } else {
                                        System.out.println("There is no librarian!");
                                    }
                                    break;
                                }
                                case 3: {
                                    String id = MyUtils.inputString("Enter librarian id: ");
                                    Librarian librarianToFind = librarianController.searchLibrarian(id);
                                    if (librarianToFind == null) {
                                        System.out.println("This librarian is not exist!");
                                    } else {
                                        System.out.println("Found the librarian!");
                                        System.out.println("+---------------------------------------------------------------------------------------------------------------------+");
                                        System.out.println("|    ID    |                Name                |            Email          |    Phone    |  Gender  |     Salary     |");
                                        System.out.println("+---------------------------------------------------------------------------------------------------------------------+");
                                        System.out.println(librarianToFind);
                                        System.out.println("+---------------------------------------------------------------------------------------------------------------------+");
                                    }
                                    break;
                                }
                                case 4: {
                                    String id = MyUtils.inputString("Enter librarian id: ");
                                    Librarian librarianToFind = librarianController.searchLibrarian(id);
                                    if (librarianToFind == null) {
                                        System.out.println("This librarian is not exist!");
                                    } else {
                                        System.out.println("Found the librarian!");
                                        System.out.println(librarianToFind);
                                        librarianController.updateLibrarianByHeadLibrarian(id);
                                    }
                                    break;
                                }
                                case 5: {
                                    option = 0;
                                    break;
                                }
                            }
                        } while (option != 0);
                    }
                    break;

                }
                case 0: {
                    break;
                }
                case 7: {
                    System.out.println("Logout successfully!");
                    return;
                }
            }

        } while (selection != 7);

    }

}
