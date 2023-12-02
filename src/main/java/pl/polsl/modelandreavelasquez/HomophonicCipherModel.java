/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.modelandreavelasquez;

import java.util.*;
import org.apache.commons.lang3.StringUtils;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


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
     * Enumerates the error messages, which are constants.
     * @author Andrea Velasquez
     * @version 1.0
     *
     */
    private enum ErrorType {
        INVALID_INPUT("Invalid encryption input, please use only letters and spaces."),
        NUMERIC_INPUT("Decryption input has to be numeric and an even number of digits."),
        NULL_ENCRYPTION("Encryption input can't be null"),
        INVALID_FORMAT("This is not contained on the dictionary, insert valid numbers");

       /**
       * Variable for the errorMessage string.
       *
       */
        private final String errorMessage;

        /**
        * Method that receives the desired error message
        *
        */
        ErrorType(String errorMessage) {
            this.errorMessage = errorMessage;
        }
        /**
        * Gets the message for the error.
        * @return the message that contains the error
        */
        public String getErrorMessage() {
            return errorMessage;
        }
    }
    /**
     * This method encrypts the user's plain text using the Homophonic Cipher dictionary as a reference.
     *
     * @param plaintext The text inputted by the user.
     * @return The encrypted text
     * @throws InvalidInputError this is an exception for when the user types invalid values
     */
    public String encrypt(String plaintext) throws InvalidInputError {
        //initialize a variable to build the result
        StringBuilder encryptedText = new StringBuilder(); 
        
        if(plaintext.length() !=0){
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
                throw new InvalidInputError(ErrorType.INVALID_INPUT);
            }
        }

        return encryptedText.toString();
            
        }
        else{
            throw new InvalidInputError(ErrorType.NULL_ENCRYPTION);
        }
        
    }
    
    /**
     * This method decrypts the user's encripted text using the Homophonic Cipher dictionary as a reference.
     *
     * @param ciphertext The text inputted by the user.
     * @return The decripted text
     * @throws InvalidInputError this is an exception for when the user types invalid values
     */
    public String decrypt(String ciphertext) throws InvalidInputError {
    //initialize a variable to build the result
    StringBuilder decryptedText = new StringBuilder();
 
        //check if ciphertext is numeric and it has an even number of digits
        if (StringUtils.isNumeric(ciphertext) && ciphertext.length() % 2 == 0) {
            //the range of the stream is divided into the pairs of digits that the ciphertext 
            List<Character> characters = IntStream.range(0, ciphertext.length() / 2)
                    .mapToObj(i -> {
                            int encryptedPair = Integer.parseInt(ciphertext.substring(i * 2, i * 2 + 2));
                            return dictionary.homophones.entrySet().stream()
                                    .filter(entry -> entry.getValue().contains(encryptedPair))
                                    .map(Map.Entry::getKey)
                                    .findFirst()
                                    .orElse(Character.MIN_VALUE);
                    })
                    .collect(Collectors.toList());

            characters.forEach(decryptedText::append); //We append to the string each character that is found on dictionary
        } 
        else {
            throw new InvalidInputError(ErrorType.NUMERIC_INPUT);
        }
        if (ciphertext.length()/2 != decryptedText.toString().trim().length()) {
            throw new InvalidInputError(ErrorType.INVALID_FORMAT);
        }
        else{
            return decryptedText.toString();
        }

}
/**
 * Exception thrown to indicate that the input provided is invalid.
 * <p>
 * This class extends {@link Exception}, and its constructor allows specifying
 * a custom error message that can provide more details about the nature of the
 * invalid input.
 * </p>
 * @author Andrea Velasquez
 * @version 1.2
 */
    public class InvalidInputError extends Exception {
    /**
    * Variable for the ErrorType enum.
    *
    */
    private final ErrorType errorType;

    /**
     * Constructs a new InvalidInputError with the specified detail message.
     *
     * @param errorType a detailed error message describing the invalid input
     */
        private InvalidInputError(ErrorType errorType) {
            super(errorType.getErrorMessage());
            this.errorType = errorType;
        }    
    }
}
