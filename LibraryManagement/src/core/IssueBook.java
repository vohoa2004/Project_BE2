/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;


import java.time.LocalDate;

/**
 *
 * @author vothimaihoa
 */
public class IssueBook extends Book{
    
    //fields
     private int transactionId;
     private double charges;
     private LocalDate issueDate;
     private int duration;
     private LocalDate dueDate;
     private double fine;
    private int readerId;
    private int quantity;
    private String status; 
     
     //Constructor
     public IssueBook(){
     }
     
     public IssueBook(int transactionId, double charges, LocalDate issueDate, int duration, LocalDate dueDate, double fine, int readerId, int quantity, String status){
        this.transactionId = transactionId;
        this.charges = charges;
        this.issueDate = issueDate;
        this.duration = duration;
        this.dueDate = calculateDueDate(issueDate, duration);
        this.fine = calculateFine(dueDate);
        this.readerId = readerId;
        this.quantity = quantity;
        this.status = status;
     }
     
     //getter
     public int getTransactionId() {
        return transactionId;
    }

    public double getCharges() {
        return charges;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public int getDuration() {
        return duration;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public double getFine() {
        return fine;
    }

    public int getReaderId() {
        return readerId;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getStatus() {
        return status;
    }

    // Setter

// Setter

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public void setCharges(double charges) {
        this.charges = charges;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }

    public void setReaderId(int readerId) {
        this.readerId = readerId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    // toString()

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", charges=" + charges +
                ", issueDate=" + issueDate +
                ", duration=" + duration +
                ", dueDate=" + dueDate +
                ", fine=" + fine +
                ", readerId=" + readerId +
                ", quantity=" + quantity +
                ", status='" + status + '\'' +
                '}';
    }

    // Phương thức tính toán dueDate

    private LocalDate calculateDueDate(LocalDate issueDate, int duration) {
        return issueDate.plusDays(duration);
    }

    // Phương thức tính toán fine

    private double calculateFine(LocalDate dueDate) {
        LocalDate today = LocalDate.now();
        if (dueDate.isBefore(today)) {
            return duration * 10000;
        }
        return 0;
    }
}
