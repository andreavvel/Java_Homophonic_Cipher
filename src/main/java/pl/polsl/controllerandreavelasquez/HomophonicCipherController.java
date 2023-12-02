/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package pl.polsl.controllerandreavelasquez;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import pl.polsl.modelandreavelasquez.HomophonicCipherModel;
import pl.polsl.viewandreavelasquez.ProgramGUI;
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
     private final ProgramGUI view;
    

    /**
     * This is the constructor for the Controller Class.
     * * @param model The HomophonicCipherModel object representing the model part of MVC.
     * @param view The ProgramGUI object representing the view part of MVC.
     */
    private HomophonicCipherController(HomophonicCipherModel model, ProgramGUI view) {
        this.model = model;
        this.view = view;
        this.view.addEncodeListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String plaintext = view.getOriginalText(); // Implement getOriginalText() in ProgramGUI
                encoding(plaintext);
            }
        });

        this.view.addDecodeListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String ciphertext = view.getOriginalText(); // Implement getOriginalText() in ProgramGUI
                decoding(ciphertext);
            }
        });

    }

    /**
     * This is our program's main method
     * @param args are the command line arguments that our program receives when executed
     */
    public static void main(String[] args) {
      HomophonicCipherModel model = new HomophonicCipherModel();
        ProgramGUI view = new ProgramGUI();

        HomophonicCipherController controller = new HomophonicCipherController(model, view);

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(view);
            }
        });
    }
    
    /**
     * Creates and displays the GUI for the application.
     *
     * @param view The ProgramGUI object representing the view part of MVC.
     */
   private static void createAndShowGUI(ProgramGUI view) {
        JFrame.setDefaultLookAndFeelDecorated(true);

        JFrame frame = new JFrame("Homophonic Cipher");

        frame.setJMenuBar(view.createMenuBar(view));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(view);
        frame.pack();
        frame.setVisible(true);
        
    }
    /**
     * Performs encoding based on the plaintext provided and updates the view.
     *
     * @param plaintext The plaintext to be encoded.
     */
    public void encoding(String plaintext){
        try {
            String encryptedtxt = model.encrypt(plaintext);
            view.updateText(encryptedtxt);
            updateHistory("Encode: Input: " + plaintext + ", Output: " + encryptedtxt + "\n");
        } catch (HomophonicCipherModel.InvalidInputError e) {
             view.displayErrorMessage("Error: " + e.getMessage(), "Encryption Error");
        }
    }
    
    /**
     * Performs decoding based on the ciphertext provided and updates the view.
     *
     * @param ciphertext The ciphertext to be decoded.
     */
    public void decoding(String ciphertext){
          try {
            String decryptedtxt = model.decrypt(ciphertext);
            view.updateText(decryptedtxt);
            updateHistory("Decode: Input: " + ciphertext + ", Output: " + decryptedtxt + "\n");
        } catch (HomophonicCipherModel.InvalidInputError e) {
            view.displayErrorMessage("Error: " + e.getMessage(), "Decryption Error");
        }
    /**
     * Updates the history in the view.
     *
     * @param conversion The conversion details to be added to the history.
     */
    }
      private void updateHistory(String conversion) {
        view.updateHistory(conversion); // Update the history in the view
    }
}
