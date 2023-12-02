/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.view;
//import javax.swing.JOptionPane;
import java.util.Scanner;
/**
 * This is the View Class of the HomophonicCipher
 * @author Andrea Velasquez
 * @version 1.0
 */
public class HomophonicCipherView {
    /**
     * This field represents a scanner object to receive input
     */
    private Scanner scanner;

    /**
     * This is the constructor for the View Class, it also initializes a scanner to parse user input
     */
    public HomophonicCipherView() {
        scanner = new Scanner(System.in);
    }
    /**
     * This method displays the result of the encryption to the user
     * @param result is the encrypted text that will be shown to the user
     */
    public void displayResult(String result) {
        System.out.println("Encrypted text: " + result);
    }

    /**
     * This method displays the result of the encryption to the user
     * @param prompt is the instruction that the program gives to the user to place their input
     * @return the scanner to get the user input
     */
    public String getUserInput(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }
}
