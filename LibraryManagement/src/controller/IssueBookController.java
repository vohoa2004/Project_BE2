package controller;

import dao.IssueBookDAO;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import model.Book;
import model.IssueBook;
import utils.MyUtils;
import view.Menu;

/**
 *
 * @author vothimaihoa
 */
public class IssueBookController {

    private BookController bookController = new BookController();

    private final IssueBookDAO issueDAO;

    public IssueBookController() {
        issueDAO = new IssueBookDAO();
    }

    // for librarian
    public void addNewIssueTransaction(int bookId, String readerId) {
        Book book = bookController.getBookById(bookId);
        int availableQuantity = book.getTotalAvailable();

        if (availableQuantity <= 0) {
            System.out.println("Sorry! This book is currently not available for borrowing.");
            return;
        } else {
            int quantity = MyUtils.inputInteger("Input quantity: ", 1, availableQuantity);

            double charges = book.getPrice() * 0.06 * quantity;
            LocalDate issueDate = LocalDate.now();
            LocalDate dueDate = LocalDate.now().plusDays(book.getBorrowDuration());
            double fines = 0;
            boolean status = true;

            IssueBook newIssueBook = new IssueBook(charges, issueDate, dueDate, fines, readerId, quantity, status, bookId);

            bookController.update(book, availableQuantity - quantity);
            issueDAO.insert(newIssueBook);

        }
    }

    private double calculateFine(LocalDate dueDate) {
        LocalDate today = LocalDate.now();
        if (dueDate.isBefore(today)) {
            long daysLate = ChronoUnit.DAYS.between(dueDate, today);
            return daysLate * 10000;
        }
        return 0;
    }

    //for reader
    public void borrowBook(int bookId, String readerId) {
        Book book = bookController.getBookById(bookId);
        // Quantity, Charges, Fine, Issue_date, Due_date, Status, Book_Id, Reader_Id
        int availableQuantity = book.getTotalAvailable();
        if (availableQuantity <= 0) {
            System.out.println("Sorry! This book is currently not available for borrowing.");
            return;
        } else {
            int quantity = MyUtils.inputInteger("Input quantity: ", 1, availableQuantity);
            double charges = book.getPrice() * 0.06 * quantity;
            LocalDate issueDate = LocalDate.now();
            LocalDate dueDate = LocalDate.now().plusDays(book.getBorrowDuration());
            double fines = 0;
            boolean status = true;
            IssueBook newIssueBook = new IssueBook(charges, issueDate, dueDate, fines, readerId, quantity, status, bookId);

            bookController.update(book, availableQuantity - quantity);
            issueDAO.insert(newIssueBook);

        }
    }

    // xem danh sach muon sach cua 1 nguoi nao do
    public ArrayList<IssueBook> searchIssueTransactionByReaderId(String readerId) {
        return issueDAO.selectByReaderId(readerId);
    }

    public void showIssueTransactionByReaderId(String readerId) {
        ArrayList<IssueBook> list = searchIssueTransactionByReaderId(readerId);

        if (list.isEmpty()) {
            System.out.println("The list is empty!");
        } else {
            for (IssueBook x : list) {
                System.out.println(x.toString());
            }
        }
    }

    public IssueBook searchIssueById(int id) {
        return issueDAO.selectById(id);
    }

    public void returnIssueBook(int issueId) {
        // Quantity, Charges, Fine, Issue_date, Due_date, Status, Book_Id, Reader_Id
        IssueBook issuebook = searchIssueById(issueId);
        Book book = bookController.getBookById(issuebook.getBookId());

        if (issuebook != null) {
            if (issuebook.isBorrowing() == false) {
                System.out.println("You returned the book(s) of this transaction!");
            } else {
                boolean newStatus = false;
                issuebook.setBorrowing(newStatus);
                issuebook.setFine(calculateFine(issuebook.getDueDate()));

                int result = issueDAO.update(issuebook);
                if (result > 0) {
                    bookController.update(book, book.getTotalAvailable() + issuebook.getQuantity());
                    System.out.println("Return book successfully!");
                    System.out.println(Menu.getTableIssueHeader());
                    System.out.println(searchIssueById(issueId));
                } else {
                    System.out.println("Failed to return book");
                }
            }
        } else {
            System.out.println("This issue transaction is not exist!");

        }

    }

    public ArrayList<IssueBook> getAllIssueBookTransaction() {
        return issueDAO.selectAll();
    }

    public void showAllIssueBookTransaction() {
        ArrayList<IssueBook> list = getAllIssueBookTransaction();
        if (!list.isEmpty()) {
            for (IssueBook x : list) {
                System.out.println(x.toString());
            }
        } else {
            System.out.println("List is empty");
        }
    }

}
