package controller;

import dao.ReaderDAO;
import java.util.ArrayList;
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

        String phone= MyUtils.inputString("Input phone number: ");
        while (!MyUtils.validatePhone(phone)){
            phone = MyUtils.inputString("Input phone number: ");
        }
        Reader reader = new Reader(userId, name, email, phone, gender);
        readerDAO.insert(reader);
    }

    public boolean updateReader(Reader reader) {
        readerDAO.update(reader);
        return true;
    }

    public boolean deleteReader(String readerId) {
        readerDAO.delete(readerId);
        return true;
    }

    public Reader getReaderById(String readerId) {
        System.out.println(readerId);
        return readerDAO.selectById(readerId);
    }

    public ArrayList<Reader> getAllReaders() {
        return readerDAO.selectAll();
    }
}
