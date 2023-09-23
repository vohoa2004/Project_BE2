package utils;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author vothimaihoa
 */
public class MyUtils {

    public static String inputString(String message) {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print(message);
            String value = sc.nextLine().trim();
            if (!value.isEmpty()) {
                return value;
            }
            System.out.println("Value can not be empty!");
        } while (true);
    }

    public static Integer inputInteger(String message, int min, int max) {
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.print(message);
                Integer number = Integer.parseInt(sc.nextLine());
                if (number >= min && number <= max) {
                    return number;
                }
                System.out.println("Value is only in [" + min + ", " + max + "]");
            } catch (Exception e) {
                System.out.println("Required number");
            }
        } while (true);
    }

    public static Double inputDouble(String message, double min, double max) {
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.print(message);
                Double number = Double.parseDouble(sc.nextLine());
                if (number >= min && number <= max) {
                    return number;
                }
                System.out.println("Value is only in [" + min + ", " + max + "]");
            } catch (Exception e) {
                System.out.println("Required number");
            }
        } while (true);
    }

    //regex for username
    public static final Pattern VALID_READER_ID_REGEX = Pattern.compile("^(R)\\d{4}$");
    public static final Pattern VALID_LIBRARIAN_ID_REGEX = Pattern.compile("^(L)\\d{4}$");

    public static final Pattern VALID_USERNAME_REGEX = Pattern.compile("^[a-zA-Z][a-zA-Z0-9]*$");

    public static boolean validateUsername(String username) {
        Matcher matcher = VALID_USERNAME_REGEX.matcher(username);
        return matcher.matches();
    }

    public static boolean validateReaderId(String id) {
        Matcher matcher = VALID_READER_ID_REGEX.matcher(id);
        return matcher.matches();
    }
    
    public static boolean validateLibrarianId(String id) {
        Matcher matcher = VALID_READER_ID_REGEX.matcher(id);
        return matcher.matches();
    }

    // regex for email
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validateEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.matches();
    }

    // regex for password
    public static final Pattern VALID_PASSWORD_REGEX = Pattern.compile("^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$");

    public static boolean validatePass(String password) {
        Matcher matcher = VALID_PASSWORD_REGEX.matcher(password);
        return matcher.matches();
    }

    public static final Pattern VALID_STUDENTID_REGEX = Pattern.compile("SE\\d{6}");

    public static boolean validateID(String ID) {
        Matcher id = VALID_STUDENTID_REGEX.matcher(ID);
        return id.matches();
    }
    public static final Pattern VALID_PHONE_REGEX = Pattern.compile("\\d{10}");

    public static boolean validatePhone(String phone) {
        Matcher p = VALID_PHONE_REGEX.matcher(phone);
        return p.matches();
    }

    public static String inputGender(String message) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println(message);
            String gender = sc.nextLine().trim(); // Loại bỏ khoảng trắng ở đầu và cuối chuỗi
            if (gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female")) {
                return gender.toLowerCase(); // Trả về giới tính ở dạng chữ thường
            }
            System.out.println("Gender must be 'male' or 'female' (case insensitive)!");
        } while (true);
    }

    // check enter number > 0
    public static Integer inputPositiveNumber(String message) {
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.print(message);
                Integer number = Integer.parseInt(sc.nextLine());
                if (number > 0) {
                    return number;
                }
                System.out.println("Value need to be >0 ");
            } catch (NumberFormatException e) {
                System.out.println("Required number");
            }
        } while (true);

    }

}
