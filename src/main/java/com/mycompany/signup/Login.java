/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.signup;

/**
 *
 * @author Student
 */
class Login {
    
    private String storedUsername;
    private String storedPassword;
    private String storedCellPhone;
    private String firstName;
    private String lastName;
    
    public Login(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public boolean checkUserName(String username) {
        if (username == null) return false;
        return username.contains("_") && username.length() <= 5;
    }
    
    public boolean checkPasswordComplexity(String password) {
        if (password == null || password.length() < 8) return false;
        
        boolean hasUpper = false;
        boolean hasDigit = false;
        boolean hasSpecail = false;
        
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else if (!Character.isLetterOrDigit(c)) hasSpecail = true;
        }
        return hasUpper && hasSpecail;
    }
    
    public boolean checkCellPhoneNumber(String cellPhone) {
        if (cellPhone == null) return false;
        return cellPhone.matches("^\\[0-9]{9}$");
    }
    
    public String registerUser(String username, String password, String cellPhone) {
        if (!checkUserName(username)){
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        if (!checkPasswordComplexity(password)){
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number and a special character.";
        }
        if (!checkCellPhoneNumber(cellPhone)){
            return "Phone number is incorrectly formatted or does not contain an international code; please correct the number and try again.";
        }
        
        this.storedUsername = username;
        this.storedPassword = password;
        this.storedCellPhone = cellPhone;
        
        return "Username successfully captured. \n Password successfully captured. \n Cell phone number successfully captured.";   

    }
    
    public boolean loginUser(String username, String password) {
        return username.equals(storedUsername) && password.equals(storedPassword);
    }
    
    public String returnLoginStatus(boolean loginStatus) {
        if (loginStatus){
            return "Welcome " + firstName + ", " + lastName + "it is great to see you again.";
        } else {
            return "Username or password is incorrect, please try again.";    
        }
    }
}
    
    
