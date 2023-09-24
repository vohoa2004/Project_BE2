/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
    private int borrowDuration; // so ngay toi da duoc phep muon loai sach nay

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

    public Book(String title, String author, double price, String category, int totalAvailable, int borrowDuration) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.category = category;
        this.totalAvailable = totalAvailable;
        this.borrowDuration = borrowDuration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getTotalAvailable() {
        return totalAvailable;
    }

    public void setTotalAvailable(int totalAvailable) {
        this.totalAvailable = totalAvailable;
    }

    public int getBorrowDuration() {
        return borrowDuration;
    }

    public void setBorrowDuration(int borrowDuration) {
        this.borrowDuration = borrowDuration;
    }

    // toString()

    @Override
    
    
    
    
    
//        System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------------+");
//        System.out.println("|  ID  |                 Title                   |           Author          |    Price    |    Category    | TotalAvailable | BorrowDuration |");
//        System.out.println("+---------------------------------------------------------------------------------------------------------------------------------------------+");
    public String toString() {
        return String.format("|  %-2d  | %-40s| %-26s| %-12.0f| %-15s|       %-9d|       %-9d|",

                id, title, author, price, category, totalAvailable, borrowDuration);              

    }

}
