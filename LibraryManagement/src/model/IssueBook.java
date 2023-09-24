package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class IssueBook {

    private int transactionId;
    private double charges;
    private LocalDate issueDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private double fine;
    private String readerId;
    private int quantity;
    private boolean borrowing;
    private int bookId;
    

    public IssueBook() {
    }

    public IssueBook(int transactionId, double charges, LocalDate issueDate, LocalDate dueDate, LocalDate returnDate, double fine, String readerId, int quantity, boolean borrowing, int bookId) {
        this.transactionId = transactionId;
        this.charges = charges;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.fine = fine;
        this.readerId = readerId;
        this.quantity = quantity;
        this.borrowing = borrowing;
        this.bookId = bookId;
    }

    public IssueBook(double charges, LocalDate issueDate, LocalDate dueDate, double fine, String readerId, int quantity, boolean borrowing, int bookId) {
        this.charges = charges;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.fine = fine;
        this.readerId = readerId;
        this.quantity = quantity;
        this.borrowing = borrowing;
        this.bookId = bookId;
    }
    
    

    public String getReaderId() {
        return readerId;
    }

    public void setReaderId(String readerId) {
        this.readerId = readerId;
    }
    
    

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public double getCharges() {
        return charges;
    }

    public void setCharges(double charges) {
        this.charges = charges;
    }

    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isBorrowing() {
        return borrowing;
    }

    public void setBorrowing(boolean borrowing) {
        this.borrowing = borrowing;
    }
    
    

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

  @Override
public String toString() {
String statusString = borrowing ? "Borrowing" : "Returned";
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
String issueDateString = formatter.format(issueDate);
String returnDateString = formatter.format(returnDate);
String dueDateString = formatter.format(dueDate);
return String.format("|  %-2d  | %-12.0f|%-40s|%-40s| %-40s|%-12.0f| %-26s| %-12d| %-15s|",
transactionId, charges, issueDate, dueDate, returnDate, fine, readerId, quantity, statusString);
}

    private LocalDate calculateDueDate(LocalDate issueDate, int duration) {
        return issueDate.plusDays(duration);
    }

    private double calculateFine(LocalDate dueDate) {
        LocalDate today = LocalDate.now();
        if (dueDate.isBefore(today)) {
            long daysLate = ChronoUnit.DAYS.between(dueDate, today);
            return daysLate * 10000;
        }
        return 0;
    }
}
