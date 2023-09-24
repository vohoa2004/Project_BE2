/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Scanner;

/**
 *
 * @author vothimaihoa
 */
public class Menu {

    public static void displayMenu(String[] options, String header) {
        int maxLength = header.length();
        for (String option : options) {
            if (option.length() > maxLength) {
                maxLength = option.length();
            }
        }

        String horizontalLine = "+---" + repeat("-", maxLength) + "---+";
        System.out.println(horizontalLine);

        System.out.printf("|   %-" + maxLength + "s   |\n", header);
        System.out.println(horizontalLine);

        for (int i = 0; i < options.length; i++) {
            String option = options[i];
            System.out.printf("| %2d. %-" + (maxLength) + "s |\n", i + 1, option);
        }

        System.out.println(horizontalLine);

    }
    
    public static int getChoice(String[] options, String header) {
    displayMenu(options, header);

    while (true) {
        System.out.print("Your choice (1-" + options.length + "): ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        try {
            int choice = Integer.parseInt(input);
            if (choice >= 1 && choice <= options.length) {
                return choice;
            } else {
                System.out.println("Invalid choice. Please enter a number between 1 and " + options.length + ".");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
    }
}


    private static String repeat(String str, int n) {
        // dung StringBuilder
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append(str);
        }
        return result.toString();
    }
}