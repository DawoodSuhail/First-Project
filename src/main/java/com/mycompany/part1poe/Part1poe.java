/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.part1poe;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author Dawood
 */
public class Part1poe {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LoginClass login = new LoginClass(); // object of the class
        // Register user
        String username; String password ="";
        
        do {
            System.out.print("Enter username: ");
            username = sc.nextLine();
            if(login.checkUserName(username) && login.checkPasswordComplexity(password)){
                
            }

            if (isValidUsername(username)) {
                System.out.println("Username successfully captured.");
            } else {
                System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.");
            }
        } while (!isValidUsername(username));

       
        do {
            System.out.print("Enter password: ");
            password = sc.nextLine();

            if (isValidPassword(password)) {
                System.out.println("Password successfully captured.");
            } else {
                System.out.println("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.");
            }
        } while (!isValidPassword(password));

        // Collect additional information
        System.out.print("Enter first name: ");
        String firstName = sc.nextLine();

        System.out.print("Enter last name: ");
        String lastName = sc.nextLine();

        // Display entered information (for demo purposes)
        System.out.println("Registration complete!");
        System.out.println("Username: " + username);
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);

       // Login feature with 3 attempts
        int maxAttempts = 3;
        int attempts = 0;
        boolean loginSuccess = false;

        while (attempts < maxAttempts && !loginSuccess) {
            System.out.print("Please enter username to login: ");
            String loginUsername = sc.nextLine();
            
            System.out.print("Please enter password to login: ");
            String loginPassword = sc.nextLine();
            
            if (loginUsername.equals(username) && loginPassword.equals(password)) {
                System.out.println("Welcome " + firstName + " " + lastName + ". It is great to see you again.");
                loginSuccess = true;
                
            } else {
                attempts++;
                if (attempts < maxAttempts) {
                    System.out.println("Username or password incorrect. You have " + (maxAttempts - attempts) + " attempt(s) remaining.");
                }
            }
        }

        if (!loginSuccess) {
            System.out.println("You have been locked out due to too many failed login attempts.");
        }

        sc.close();
    }

    // Constants for validation
    private static final int MAX_USERNAME_LENGTH = 5;
    private static final int MIN_PASSWORD_LENGTH = 8;
    private static final String PASSWORD_REGEX = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,}$";

    private static boolean isValidUsername(String username) {
        return username.contains("_") && username.length() <= MAX_USERNAME_LENGTH;
    }

    private static boolean isValidPassword(String password) {
        Pattern pattern = Pattern.compile(PASSWORD_REGEX);
        return password.length() >= MIN_PASSWORD_LENGTH && pattern.matcher(password).matches();
    }
}


/*
Add Classes
Add methods 
Add functions
*/