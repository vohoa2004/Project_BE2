/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Book;
import dao.BookDAO;
import java.util.Scanner;
import utils.MyUtils;

/**
 *
 * @author vothimaihoa
 */
public class BookController {
    private final BookDAO bookDAO;

    public BookController() {
        bookDAO = new BookDAO();
    }

    //String title, String author, double price, String category, int totalAvailable, int borrowDuration
    public void addBook() {
        String title = MyUtils.inputString("Input title: ");
        String author = MyUtils.inputString("Input Author: ");
        Double price = MyUtils.inputBookDouble("Input price: ", 0);
        String category = MyUtils.inputString("Input category: ");
        int totalAvailable = MyUtils.inputInteger("Input total Avalable: ", 0, 200);
        int borrowDuration = MyUtils.inputInteger("Input Duration: ", 1, 60);

        Book book = new Book(title, author, price, category, totalAvailable, borrowDuration);
        bookDAO.insert(book);
    }

    public boolean updateBook(Book book) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter new title (press Enter to keep current title): ");
        String newTitle = scanner.nextLine().trim();
        if (!newTitle.isEmpty()) {
            book.setTitle(newTitle);
        }

        System.out.print("Enter new author (press Enter to keep current author): ");
        String newAuthor = scanner.nextLine().trim();
        if (!newAuthor.isEmpty()) {
            book.setAuthor(newAuthor);
        }

        System.out.print("Enter new price (press Enter to keep current price): ");
        String newPriceStr = scanner.nextLine().trim();
        if (!newPriceStr.isEmpty()) {
            double newPrice = Double.parseDouble(newPriceStr);
            book.setPrice(newPrice);
        }

        System.out.print("Enter new category (press Enter to keep current category): ");
        String newCat = scanner.nextLine().trim();
        if (!newCat.isEmpty()) {
            book.setCategory(newCat);
        }

        System.out.print("Enter new valid borrow duration(press Enter to keep current durtion): ");
        String newDurationStr = scanner.nextLine().trim();
        if (!newDurationStr.isEmpty()) {
            int newDuration = Integer.parseInt(newDurationStr);
            book.setBorrowDuration(newDuration);
        }

        if (bookDAO.update(book) > 0) {
            System.out.println("Updated successfully!");
        } else {
            System.out.println("Cannot update this book!");
        }

        return true;
    }
    
    public void update(Book book, int newQuantity) {
        book.setTotalAvailable(newQuantity);
        if (bookDAO.update(book) > 0) {
            System.out.println("Updated successfully!");
        } else {
            System.out.println("Cannot update this book!");
        }
    }

    public boolean deleteBook(int id) {
        bookDAO.delete(id);
        return true;
    }

    public Book getBookById(int id) {
        return bookDAO.selectById(id);
    }

    public ArrayList<Book> getAllBook() {
        return (ArrayList<Book>) bookDAO.selectAll();
    }

    public ArrayList<Book> getBookByName(String name) {
        ArrayList<Book> books = getAllBook();
        ArrayList<Book> list = new ArrayList<>();
        for (Book x : books) {
            if (x.getTitle().toLowerCase().contains(name.toLowerCase())) {
                list.add(x);
            }
        }
        return list;
    }

    public ArrayList<Book> getBookByAuthor(String author) {
        ArrayList<Book> books = getAllBook();
        ArrayList<Book> list = new ArrayList<>();
        for (Book x : books) {
            if (x.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                list.add(x);
            }
        }
        return list;
    }

    public void showList(ArrayList<Book> books) {
        if (books.isEmpty()) {
            System.out.println("Book not found!");
        }
        for (Book x : books) {
            System.out.println(x.toString());
        }

    }
}
