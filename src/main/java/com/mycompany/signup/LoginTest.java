/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.signup;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Student
 */
public class LoginTest {
    
    @Test
    public void testUsernameCorrectlyFormatted_ReturnsWelcomeMessage() {
        Login login = new Login("Lebohang", "Noni");
        String result = login.registerUser("noni_21", "Lebononi@199", "+27838968976");

        boolean loginSuccess = login.loginUser("noni_21", "Lebononi@1991");
        assertEquals("Welcome Lebohang Noni, it is great to see you again.", login.returnLoginStatus(loginSuccess));
    }

    @Test
    public void testUsernameIncorrectlyFormatted_ReturnsErrorMessage() {
        Login login = new Login("Lebohang", "Noni");
        String result = login.registerUser("lebohang!!!!!!", "Lebononi@1991", "+27838968976");
        assertEquals("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.", result);
    }

    @Test
    public void testPasswordMeetsComplexity_ReturnsCapturedMessage() {
        Login login = new Login("Lebohang", "Noni");
        String result = login.registerUser("noni_21", "Lebononi@1991", "+27838968976");
        assertTrue(result.contains("Password successfully captured."));
    }

    @Test
    public void testPasswordDoesNotMeetComplexity_ReturnsErrorMessage() {
        Login login = new Login("Lebohang", "Noni");
        String result = login.registerUser("noni_21", "password", "+27838968976");
        assertEquals("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.", result);
    }

    @Test
    public void testCellPhoneCorrectlyFormatted_ReturnsCapturedMessage() {
        Login login = new Login("Lebohang", "Noni");
        String result = login.registerUser("noni_21", "Lebononi@1991", "+27838968976");
        assertTrue(result.contains("Cell phone number successfully added."));
    }

    @Test
    public void testCellPhoneIncorrectlyFormatted_ReturnsErrorMessage() {
        Login login = new Login("Lebohang", "Noni");
        String result = login.registerUser("noni_21", "Lebononi@1991", "08966553");
        assertEquals("Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.", result);
    }

    @Test
    public void testLoginSuccessful_ReturnsTrue() {
        Login login = new Login("Lebohang", "Noni");
        login.registerUser("noni_21", "Lebononi@1991", "+27838968976");
        assertTrue(login.loginUser("noni_21", "Lebononi@1991"));
    }

    @Test
    public void testLoginFailed_ReturnsFalse() {
        Login login = new Login("Lebohang", "Noni");
        login.registerUser("noni_21", "Lebononi@1991", "+27838968976");
        assertFalse(login.loginUser("noni_21", "wrongpassword"));
    }

    @Test
    public void testUsernameCorrectlyFormatted_ReturnsTrue() {
        Login login = new Login("Lebohang", "Noni");
        assertTrue(login.checkUserName("noni_21"));
    }

    @Test
    public void testUsernameIncorrectlyFormatted_ReturnsFalse() {
        Login login = new Login("Lebohang", "Noni");
        assertFalse(login.checkUserName("noni!!!!!!"));
    }

    @Test
    public void testPasswordMeetsComplexity_ReturnsTrue() {
        Login login = new Login("Lebohang", "Noni");
        assertTrue(login.checkPasswordComplexity("Lebononi@1991"));
    }

    @Test
    public void testPasswordDoesNotMeetComplexity_ReturnsFalse() {
        Login login = new Login("Lebohang", "Noni");
        assertFalse(login.checkPasswordComplexity("password"));
    }

    @Test
    public void testCellPhoneCorrectlyFormatted_ReturnsTrue() {
        Login login = new Login("Lebohang", "Noni");
        assertTrue(login.checkCellPhoneNumber("+27838968976"));
    }

    @Test
    public void testCellPhoneIncorrectlyFormatted_ReturnsFalse() {
        Login login = new Login("Lebohang", "Noni");
        assertFalse(login.checkCellPhoneNumber("08966553"));
    }
}
    
    

