/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Book;
import dao.BookDAO;
import utils.MyUtils;
/**
 *
 * @author vothimaihoa
 */
public class BookController {
    
    private final BookDAO bookDAO;
    
    public BookController(){
        bookDAO = new BookDAO();
    }
    //String title, String author, double price, String category, int totalAvailable, int borrowDuration
    public void addBook(int id){
        String title = MyUtils.inputString("Input title: ");
        String author = MyUtils.inputString("Input Author: ");
        Double price = MyUtils.inputBookDouble("Input price: ", 0);
        String category = MyUtils.inputString("Input category: ");
        int totalAvailable = MyUtils.inputInteger("Input total Avalable: ", 0, 50);
        int borrowDuration = MyUtils.inputInteger("Input Duration: ", 1, 30);
        
        Book book = new Book(id, title, author, price, category, totalAvailable, borrowDuration );
        bookDAO.insert(book);
    }
    
    public boolean updateBook(Book book){
        bookDAO.update(book);
        return true;
    }
    
    public boolean deleteBook(int id){
        bookDAO.delete(id);
        return true;
    }
    public Book getBookById(int id){
        System.out.println(id);
        return bookDAO.selectById(id);
    }
    
    public ArrayList<Book> getAllBook(){
        return (ArrayList<Book>) bookDAO.selectAll();
    } 
}
