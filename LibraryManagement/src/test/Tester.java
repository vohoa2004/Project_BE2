package test;

import controller.LibrarianController;
import model.Reader;
import controller.ReaderController;
import controller.UserController;
import model.User;

public class Tester {

    public static void main(String[] args) {
        UserController userController = new UserController();
        ReaderController readerController = new ReaderController();
        LibrarianController librarianController = new LibrarianController();
        
        //User user = userController.addReaderUser();
        User user1 = userController.addLibrarianUser();
        //test insert
        //readerController.addReader(user.getUserId());
        librarianController.addLibrarian(user1.getUserId());
        
        //test select all
        System.out.println("Reader list:");
        for (Reader reader : readerController.getAllReaders()) {
            System.out.println(reader.toString());
        }

        // Cập nhật thông tin đọc giả
            Reader newReader = readerController.getReaderById("R0005");
            //System.out.println(newReader);
            if (newReader != null) {
                newReader.setName("Vy Vy");
                boolean updated = readerController.updateReader(newReader);
                if (updated) {
                    System.out.println("Update reader information successfully!");
                } else {
                    System.out.println("Error when updating reader.");
                }
            } else {
                System.out.println("Reader not found with the specified ID.");
            }
        }

    }

