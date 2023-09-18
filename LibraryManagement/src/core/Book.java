/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

/**
 *
 * @author vothimaihoa
 */
public class Book {
         // fields
    private int id;
    private String title;
    private String author;
    private double price;
    private String category;
    private int totalAvailable;
    private int borrowDuration;

    // Constructor

    public Book() {
    }

    public Book(int id, String title, String author, double price, String category, int totalAvailable, int borrowDuration) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.category = category;
        this.totalAvailable = totalAvailable;
        this.borrowDuration = borrowDuration;
    }

    // Getter

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public int getTotalAvailable() {
        return totalAvailable;
    }

    public int getBorrowDuration() {
        return borrowDuration;
    }

    // Setter

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setTotalAvailable(int totalAvailable) {
        this.totalAvailable = totalAvailable;
    }

    public void setBorrowDuration(int borrowDuration) {
        this.borrowDuration = borrowDuration;
    }

    // toString()

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", totalAvailable=" + totalAvailable +
                ", borrowDuration=" + borrowDuration +
                '}';
    }

}
