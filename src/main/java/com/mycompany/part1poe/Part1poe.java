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
        String firstName;
        String lastName;
        String username; 
        String password = "";

        // Collect first name
        do {
            System.out.print("Enter first name: ");
            firstName = sc.nextLine();
            if (firstName.isEmpty()) {
                System.out.println("First name cannot be empty. Please enter your first name.");
            } else {
                System.out.println("First name successfully captured.");
            }
        } while (firstName.isEmpty());

        // Collect last name
        do {
            System.out.print("Enter last name: ");
            lastName = sc.nextLine();
            if (lastName.isEmpty()) {
                System.out.println("Last name cannot be empty. Please enter your last name.");
            } else {
                System.out.println("Last name successfully captured.");
            }
        } while (lastName.isEmpty());

        // Get username
        do {
            System.out.print("Enter username: ");
            username = sc.nextLine();
            if (!login.checkUserName(username)) {
                System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.");
            } else {
                System.out.println("Username successfully captured.");
            }
        } while (!login.checkUserName(username));
        
        // Get password
        do {
            System.out.println("Enter password:");
            password = sc.nextLine();
            if (!login.checkPasswordComplexity(password)) {
                System.out.println("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.");
            } else {
                System.out.println("Password successfully captured.");
            }
        } while (!login.checkPasswordComplexity(password));

        

// Confirmation of captured information
        String confirmation;
        do {
            System.out.println("\nPlease confirm your details:");
            System.out.println("Username: " + username);
            System.out.println("Password: " + password.replaceAll(".", "*")); // Hide password
            System.out.println("First Name: " + firstName);
            System.out.println("Last Name: " + lastName);
            System.out.print("Are these details correct? (yes/no): ");
            confirmation = sc.nextLine().trim().toLowerCase();

            if (confirmation.equals("no")) {
                System.out.println("Let's re-enter your details.");
                
                // Reset values to capture new details
                firstName = "";
                lastName = "";
                username = "";
                password = "";
                
                // Repeat capturing details
                // Collect first name
                do {
                    System.out.print("Enter first name: ");
                    firstName = sc.nextLine();
                } while (firstName.isEmpty());

                // Collect last name
                do {
                    System.out.print("Enter last name: ");
                    lastName = sc.nextLine();
                } while (lastName.isEmpty());

                // Get username
                do {
                    System.out.print("Enter username: ");
                    username = sc.nextLine();
                } while (!login.checkUserName(username));

                // Get password
                do {
                    System.out.println("Enter password:");
                    password = sc.nextLine();
                } while (!login.checkPasswordComplexity(password));
            }
        } while (!confirmation.equals("yes"));

        // Display entered information (final confirmation)
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
}








