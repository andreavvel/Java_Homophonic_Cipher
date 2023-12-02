/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package pl.polsl.homophoniccipherandy;
import pl.polsl.view.HomophonicCipherView;
import pl.polsl.model.HomophonicCipherModel;
/**
 * This is the Controller Class of the HomophonicCipher
 * @author Andrea Velasquez
 * @version 1.0
 */
public class HomophonicCipherController {
    /**
     * This field represents a Model Class object.
     */
     private final HomophonicCipherModel model;
    /**
     * This field represents a View Class object.
     */
    private final HomophonicCipherView view;

    /**
     * This is the constructor for the Controller Class.
     */
    private HomophonicCipherController(HomophonicCipherModel model, HomophonicCipherView view) {
        this.model = model;
        this.view = view;
    }

    /**
     * This is our program's main method
     * @param args are the command line arguments that our program receives when executed
     */
    public static void main(String[] args) {
      HomophonicCipherModel model = new HomophonicCipherModel(); // Create model
        HomophonicCipherView view = new HomophonicCipherView(); // Create view
    HomophonicCipherController controller = new HomophonicCipherController(model, view); //Create a controller
        //if there are command line arguments then execute the program with those
        if (args.length > 0) {

            try {
                String encryptedText = model.encrypt(args[0]);
                view.displayResult("Result using command line arguments: "+encryptedText);
            } catch (HomophonicCipherModel.EncryptionError e) {
                System.err.println("An exception occurred: " + e.getMessage());
                controller.run();
            }
        }
        else {
            controller.run();
        }
    }
    /**
     * This method combines the model and view in the controller, in order to encrypt the message
     */
    public void run() {
        try {
            String plaintext = view.getUserInput("Enter plaintext: ");
            String encryptedText = model.encrypt(plaintext);
            view.displayResult(encryptedText);
        } catch (HomophonicCipherModel.EncryptionError e) {
            System.err.println("An exception occurred: " + e.getMessage());
            run();
        }
    }
}
