package controller;

import dao.ReaderDAO;
import java.util.ArrayList;
import java.util.Scanner;
import model.Reader;
import utils.MyUtils;

/**
 *
 * @author vothimaihoa
 */
public class ReaderController {

    private final ReaderDAO readerDAO;

    public ReaderController() {
        readerDAO = new ReaderDAO();
    }

    public void addReader(int userId) {
        // User_Id, Name, Gender, Email, Phone
        String name = MyUtils.inputString("Input name: ");
        String gender = MyUtils.inputString("Input gender (male or female): ");
        String email;
        email = MyUtils.inputString("Input email: ");
        while (!MyUtils.validateEmail(email)) {
            email = MyUtils.inputString("Invalid format. Re-Input email: ");
        }

        String phone = MyUtils.inputString("Input phone number: ");
        while (!MyUtils.validatePhone(phone)) {
            phone = MyUtils.inputString("Input phone number: ");
        }
        Reader reader = new Reader(userId, name, email, phone, gender);
        readerDAO.insert(reader);
    }

    public void updateReader(String readerId) {
        Reader reader = getReaderById(readerId);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter new name (press Enter to keep current name): ");
        String newName = scanner.nextLine().trim();
        if (!newName.isEmpty()) {
            reader.setName(newName);
        }
        System.out.print("Enter new gender (press Enter to keep current gender): ");
        String newGender = scanner.nextLine().trim();
        if (!newGender.isEmpty()) {
            reader.setGender(newGender);
        }
        System.out.print("Enter new email (press Enter to keep current email): ");
        String newEmail = scanner.nextLine().trim();
        if (!newEmail.isEmpty()) {
            reader.setEmail(newEmail);
        }
        System.out.print("Enter new phone (press Enter to keep current phone): ");
        String newPhone = scanner.nextLine().trim();
        if (!newPhone.isEmpty()) {
            reader.setPhone(newPhone);
        }
        if(readerDAO.update(reader) > 0) {
            System.out.println("Updated successfully!");
        }
        else {
            System.out.println("Cannot update this reader!");
        };
    }

    public Reader getReaderById(String readerId) {
//        System.out.println(readerId);
        return readerDAO.selectById(readerId);
    }

    public ArrayList<Reader> getAllReaders() {
        return readerDAO.selectAll();
    }
    
    public void showAllReaders() {
        ArrayList<Reader> list = getAllReaders();
        for (Reader x : list) {
            System.out.println(x);
        }
    }
    
}
