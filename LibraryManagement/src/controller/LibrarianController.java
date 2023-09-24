package controller;

import dao.LibrarianDAO;
import java.util.ArrayList;
import java.util.Scanner;
import model.Librarian;
import utils.MyUtils;

/**
 *
 * @author vothimaihoa
 */
public class LibrarianController {

    private final LibrarianDAO librarianDAO;

    public LibrarianController() {
        librarianDAO = new LibrarianDAO();
    }

    public void addLibrarian(int userId) {
        //User_Id, Name, Gender, Email, Phone, Salary
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
        double salary = MyUtils.inputDouble("Salary: ", 0, Double.MAX_VALUE);
        Librarian librarian = new Librarian(userId, name, email, phone, gender, salary);
        librarianDAO.insert(librarian);
    }

    public Librarian searchLibrarian(String librarianId) {
        return librarianDAO.selectById(librarianId);
    }

    public void updateLibrarian(String librarianId) {
        Librarian librarian = searchLibrarian(librarianId);
        Scanner scanner = new Scanner(System.in);

        // Yêu cầu người dùng nhập thông tin cần cập nhật
        System.out.print("Enter new name (press Enter to keep current name): ");
        String newName = scanner.nextLine().trim();
        if (!newName.isEmpty()) {
            librarian.setName(newName);
        }

        System.out.print("Enter new gender (press Enter to keep current gender): ");
        String newGender = scanner.nextLine().trim();
        if (!newGender.isEmpty()) {
            librarian.setGender(newGender);
        }

        System.out.print("Enter new email (press Enter to keep current email): ");
        String newEmail = scanner.nextLine().trim();
        if (!newEmail.isEmpty()) {
            librarian.setEmail(newEmail);
        }

        System.out.print("Enter new phone (press Enter to keep current phone): ");
        String newPhone = scanner.nextLine().trim();
        if (!newPhone.isEmpty()) {
            librarian.setPhone(newPhone);
        }

        System.out.print("Enter new salary (press Enter to keep current salary): ");
        String newSalaryStr = scanner.nextLine().trim();
        if (!newSalaryStr.isEmpty()) {
            try {
                double newSalary = Double.parseDouble(newSalaryStr);
                librarian.setSalary(newSalary);
            } catch (NumberFormatException e) {
                System.out.println("Invalid salary format. Keeping current salary.");
            }
        }

        librarianDAO.update(librarian);
        System.out.println("Librarian information updated successfully!");
    }

    public ArrayList<Librarian> getAllLibrarians() {
        ArrayList<Librarian> librarians = librarianDAO.selectAll();
        System.out.println("----Librarian list----");
        for (Librarian librarian : librarians) {
            System.out.println(librarian.toString());
        }
        return librarians;
    }

    public Librarian getLibrarianById() {
        String librarianId;
        do {
            librarianId = MyUtils.inputString("Enter the Librarian ID you want to find: ");
        } while (!MyUtils.validateLibrarianId(librarianId));
        Librarian librarian = librarianDAO.selectById(librarianId);
        if (librarian != null) {
            System.out.println("Found librarian by ID: " + librarian.toString());
        } else {
            System.out.println("Librarian not found with the ID.");
        }
        return librarian;

    }

}