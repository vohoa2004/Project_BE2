package test;

import controller.BookController;
import controller.LibrarianController;
import model.Reader;
import controller.ReaderController;
import controller.UserController;
import model.Book;
import model.User;

public class Tester {

    public static void main(String[] args) {
        UserController userController = new UserController();
        ReaderController readerController = new ReaderController();
        LibrarianController librarianController = new LibrarianController();
        BookController bookController = new BookController();
        
//        //User user = userController.addReaderUser();
//        User user1 = userController.addLibrarianUser();
//        //test insert
//        //readerController.addReader(user.getUserId());
//        librarianController.addLibrarian(user1.getUserId());
//      
//
//        
//        Book newBook = bookController.getBookById(2);
//            System.out.println(newBook.toString());
//
//
//
//  
//
//        bookController.addBook(7);
//
//
//        //test select all book
//        System.out.println("Book list:");
//        for(Book book : bookController.getAllBook()){
//            System.out.println(book.toString());
//        }
//        
//        //Cập nhật thông tin sách
//        Book newBook = bookController.getBookById(2);
//        if(newBook != null){
//            newBook.setTitle("Tham tu lung danh conan");
//            boolean update = bookController.updateBook(newBook);
//            if(update){
//                    System.out.println("Update reader information successfully!");
//                } else {
//                    System.out.println("Error when updating reader.");
//                }
//            } else {
//                System.out.println("Reader not found with the specified ID.");
//            }
//            }
//        }
//        
//
//        //test select all
//        System.out.println("Reader list:");
//        for (Reader reader : readerController.getAllReaders()) {
//            System.out.println(reader.toString());
//        }
//
//        // Cập nhật thông tin đọc giả
//            Reader newReader = readerController.getReaderById("R0005");
//            //System.out.println(newReader);
//            if (newReader != null) {
//                newReader.setName("Vy Vy");
//                boolean updated = readerController.updateReader(newReader);
//                if (updated) {
//                    System.out.println("Update reader information successfully!");
//                } else {
//                    System.out.println("Error when updating reader.");
//                }
//            } else {
//                System.out.println("Reader not found with the specified ID.");
//            }     
        }

    }

