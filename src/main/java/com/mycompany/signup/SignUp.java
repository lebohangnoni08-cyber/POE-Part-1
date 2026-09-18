/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.signup;

import java.util.Scanner;
/**
 *
 * @author Student
 */
public class SignUp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("===Welcome to the Registration System===");
        
        System.out.println("Please enter your first name: ");
        String firstName = scanner.nextLine();
        System.out.println("Please enter your last name: ");
        String lastName = scanner.nextLine();
        
        Login loginSystem = new Login(firstName, lastName);
        
        System.out.println("\n--- Register Account ---");
        System.out.println("Please enter your username (must contain '_' and max 5 chars): ");
        String regUsername = scanner.nextLine();
        
        System.out.println("Please enter your password (min 8 chars, 1 capital, 1 number, 1 special): ");
        String regPassword = scanner.nextLine();
        
        System.out.println("Please enter phone number (e.g., +27838968520) :");
        String regCellPhone = scanner.nextLine();
        
        String registrationMessage = loginSystem.registerUser(regUsername, regPassword, regCellPhone);
        System.out.println("\n" + registrationMessage);
        
        if (registrationMessage.contains("successfully")){
            System.out.println("\n--- Login Phase ---");
            System.out.println("Please enter Username: ");
            String loginUsername = scanner.nextLine();
            
            System.out.println("Please enter password: ");
            String loginPassword = scanner.nextLine();
            
            boolean isLoggedIn = loginSystem.loginUser(loginUsername, loginPassword);
            
            System.out.println("\n" + loginSystem.returnLoginStatus(isLoggedIn));
        } else {
            System.out.println("\n Registration failed. Please restart the application and try again.");
        }
        
        scanner.close();   
    }
}
