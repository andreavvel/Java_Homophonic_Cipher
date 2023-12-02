/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TestingModel;

import pl.polsl.modelandreavelasquez.HomophonicCipherModel;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
/**
 * This class contains unit tests for the HomophoniCipherModel class.
 * @author Andrea Velasquez
 * @version 1.0
 */
public class ModelTest {
    
    private HomophonicCipherModel model;
 /**
 * Setting up our model to try the tests on
 */
    @BeforeEach
    public void setUp() {
        model = new HomophonicCipherModel();
    }
    /**
 * Test case for the {@link HomophonicCipherModel#encrypt()} method.
 * <p>
 * Testing if the program encrypts texts correctly according to the dictionary.
 * </p>
 *
 * @throws InvalidInputError if something unexpected happens
 */
@ParameterizedTest
@CsvSource({
        "fgh,571714",
        "vwxyz,2313119877",
        "123,InvalidInputError", // Invalid input (contains digits)
        "!@#,InvalidInputError" // Invalid input (contains special characters)
})
void shouldGenerateExpectedEncryption(String input, String expected) {
    if ("InvalidInputError".equals(expected)) {
        assertThrows(HomophonicCipherModel.InvalidInputError.class, () -> model.encrypt(input));
    } else {
        try {
            String actualValue = model.encrypt(input);
            assertEquals(expected, actualValue, "");
            // asserting if the encryption is successful
        } catch (HomophonicCipherModel.InvalidInputError e) {
            fail("Unexpected InvalidInputError thrown");
            //catching if it throws invalid when it is not
        }
    }
}

/**
 * Test case for the {@link HomophonicCipherModel#decrypt()} method.
 * <p>
 * Testing if the program decrypts texts correctly according to the dictionary.
 * </p>
 *
 * @throws InvalidInputError if something unexpected happens
 */
@ParameterizedTest
@CsvSource({
        "571714,fgh",
        "2313119877,vwxyz",
        "123,InvalidInputError", // Invalid input (contains 3 digits, so one has no pair)
        "!@#,InvalidInputError" // Invalid input (contains special characters)
})
void shouldGenerateExpectedDecryption(String input, String expected) {
    if ("InvalidInputError".equals(expected)) {
        assertThrows(HomophonicCipherModel.InvalidInputError.class, () -> model.encrypt(input));
    } else {
        try {
            String actualValue = model.decrypt(input);
            assertEquals(expected, actualValue, "");
            // asserting if the decryption is successful
        } catch (HomophonicCipherModel.InvalidInputError e) {
            fail("Unexpected InvalidInputError thrown");
            //catching if it throws invalid when it is not
        }
    }
}
    
    
}
