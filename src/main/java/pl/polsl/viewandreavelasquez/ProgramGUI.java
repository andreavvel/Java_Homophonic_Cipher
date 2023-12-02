/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.viewandreavelasquez;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * This is the View Class of the HomophonicCipher
 * @author Andrea Velasquez
 * @version 1.0
 */
public class ProgramGUI extends JPanel implements ActionListener{
    /**
    * Variables for the encode and decode buttons
    *
    */
    protected JButton encodeButton, decodeButton;
    /**
    * Variables for the labels in the view
    *
    */
    protected JLabel firstLabel, encodedText, secondLabel;
    /**
    * Variable for the tabbed pane
    *
    */
    protected JTabbedPane tabbedPane;
    /**
    * Variable for the text area
    *
    */
    protected JTextArea historyTextArea;
    /**
    * Variable for the og text field
    *
    */
    protected JTextField originalTextField;
    
    /**
    * Constructs a ProgramGUI object, initializing the user interface components.
    * Creates buttons for encoding and decoding, text fields for input and output,
    * and a history panel to display conversion history.
    */
    public ProgramGUI() {
        // Create buttons for encode and decode
        encodeButton = new JButton("Encode");
        encodeButton.setActionCommand("Encode");
        encodeButton.addActionListener(this);

        decodeButton = new JButton("Decode");
        decodeButton.setActionCommand("Decode");
        decodeButton.addActionListener(this);

        // Create text components for input and output
        firstLabel = new JLabel("Input text: ");
        
        originalTextField = new JTextField(25); // Initialize the text field

        secondLabel = new JLabel("Result: ");
        encodedText = new JLabel("XXX");

        // Main panel for input, output, and buttons
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 1));
        mainPanel.add(firstLabel);
        mainPanel.add(originalTextField);
        mainPanel.add(secondLabel);
        mainPanel.add(encodedText);
        mainPanel.add(encodeButton);
        mainPanel.add(decodeButton);

        // Create a history tab with a text area to display conversion history
        historyTextArea = new JTextArea(15, 30);
        historyTextArea.setEditable(false);
        JScrollPane historyScrollPane = new JScrollPane(historyTextArea);

        // History panel with scrollable text area
        JPanel historyPanel = new JPanel();
        historyPanel.add(historyScrollPane);

        // Create a tabbed pane and add tabs for the main functionality and history
        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Homophonic Cipher", null, mainPanel, "Encode/Decode");
        tabbedPane.addTab("History", null, historyPanel, "Conversion History");

        // Add components to the main panel
        add(tabbedPane);
        setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        
}

    @Override
    public void actionPerformed(ActionEvent e) {
    }
    /**
    * Creates a menu bar for the application.
    *
    * @param view The ProgramGUI instance used to set the menu bar.
    * @return The constructed JMenuBar containing the "File" menu with an "Exit" option.
    */
    public static JMenuBar createMenuBar(ProgramGUI view) {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);

        return menuBar;
    }
    
    
    /**
     * Update the displayed text with the provided output.
     *
     * @param output The output text to display.
     */
    public void updateText(String output) {
        encodedText.setText(output);
    }
    /**
     * Update the history text area with the conversion log.
     *
     * @param conversion The conversion log to append to the history.
     */
    public void updateHistory(String conversion) {
        SwingUtilities.invokeLater(() -> {
            historyTextArea.append(conversion + "\n");
        });
    }
    
    /**
     * Retrieve the original text from the input field.
     *
     * @return The text entered in the input field.
     */
    public String getOriginalText() {
        return originalTextField.getText(); // Get text from the text field
    }
    /**
     * Add an ActionListener for the Encode button.
     *
     * @param listener The ActionListener to be added.
     */
    public void addEncodeListener(ActionListener listener) {
        encodeButton.addActionListener(listener);
    }

    /**
     * Add an ActionListener for the Decode button.
     *
     * @param listener The ActionListener to be added.
     */
    public void addDecodeListener(ActionListener listener) {
        decodeButton.addActionListener(listener);
    }
    
     /**
     * Display an error message in a JOptionPane.
     *
     * @param errorMessage The error message to be displayed.
     * @param title        The title of the error message dialog.
     */
    public void displayErrorMessage(String errorMessage, String title) {
        JOptionPane.showMessageDialog(this, errorMessage, title, JOptionPane.ERROR_MESSAGE);
    }
}