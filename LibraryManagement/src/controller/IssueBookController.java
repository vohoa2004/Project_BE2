package controller;

import dao.IssueBookDAO;
import java.time.LocalDate;
import java.util.ArrayList;
import model.IssueBook;
import utils.MyUtils;

/**
 *
 * @author vothimaihoa
 */
public class IssueBookController {

    private final IssueBookDAO issueDAO;

    public IssueBookController() {
        issueDAO = new IssueBookDAO();
    }

    public void addNewIssueTransaction(int bookId, String readerId) {
        // Quantity, Charges, Fine, Issue_date, Due_date, Status, Book_Id, Reader_Id
        int quantity = MyUtils.inputInteger("Input quantity: ", 1, Integer.MAX_VALUE);
        double charges = MyUtils.inputDouble("Input charges: ", 0, Double.MAX_VALUE);
        double fines = MyUtils.inputDouble("Input fines: ", 0, Double.MAX_VALUE);
        LocalDate issueDate = LocalDate.now();
        LocalDate dueDate;
        do {
            dueDate = MyUtils.inputLocalDate("Input due date: ");
            if (dueDate.isBefore(issueDate)) {
                System.out.println("Invalid issue date (cannot before borrowing)! ");
            }
        } while (dueDate.isBefore(issueDate));
        boolean status = true;
        IssueBook newIssueBook = new IssueBook(charges, issueDate, dueDate, fines, readerId, quantity, status, bookId);
        issueDAO.insert(newIssueBook);
    }

    // xem danh sach muon sach cua 1 nguoi nao do
    public ArrayList<IssueBook> searchIssueTransctionByReaderId(String readerId) {
        return issueDAO.selectByReaderId(readerId);
    }

    public IssueBook searchIssueById(int id) {
        return issueDAO.selectById(id);
    }

    // hoi tu nhma ph nho id transaction ms update dc :V
    public void returnIssueBook(int issueId) {
        // Quantity, Charges, Fine, Issue_date, Due_date, Status, Book_Id, Reader_Id
        IssueBook book = searchIssueById(issueId);
        System.out.println(book);
        if (book != null) {
            boolean newStatus = false;
            book.setBorrowing(newStatus);
            System.out.println(book);
            int result = issueDAO.update(book);
            if (result > 0) {
                System.out.println("Return book successfully!");
            }else {
                System.out.println("Failed to return book");
            }
        } else {
            System.out.println("This issue transaction is not exist!");

        }
    }

}
