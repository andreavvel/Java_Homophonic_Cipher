/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.model;

import java.util.*;

/**
 * This is the Model Class of the HomophonicCipher
 * @author Andrea Velasquez
 * @version 1.0
 */
public class HomophonicCipherModel {
    /**
     * This field represents a HomophonicDictionary class object
     */
    private final HomophonicDictionary dictionary = new HomophonicDictionary();
    /**
     * This field represents a randomly generated number
     */
    private final Random random = new Random();
    /**
     * This method encrypts the user's plaintext using the Homophonic Cipher dictionary as a reference.
     *
     * @param plaintext The text inputted by the user.
     * @return The encrypted text
     * @throws EncryptionError this is an exception for when the user types invalid values
     */
    public String encrypt(String plaintext) throws EncryptionError {
        //initialize a variable to build the result
        StringBuilder encryptedText = new StringBuilder(); 
        
        //for loop checks every char in input
        for (char c : plaintext.toCharArray()) {
            //if checks if the homophones hashmap contains the characters the user has inputted
            if (dictionary.homophones.containsKey(c)) {
                //with homophone set we get the string homophone set based on the char key
                List<Integer> homophoneSet = dictionary.homophones.get(c);
                //we get a random value number based on the length of the homophone set
                int randomIndex = random.nextInt(homophoneSet.size());
                //we select one of the characters in the homophone set to substitute the og
                encryptedText.append(homophoneSet.get(randomIndex));
            } else {
                //encryptedText.append(c);
                throw new EncryptionError("Invalid input, only use letters and spaces.");
            }
        }

        return encryptedText.toString();
    }
    /**
     * This Exception class represents an EncryptionError, when the user writes integers and symbols
     */
    public class EncryptionError extends Exception {
        public EncryptionError(String message) {
            super(message);
        }
    }

}
