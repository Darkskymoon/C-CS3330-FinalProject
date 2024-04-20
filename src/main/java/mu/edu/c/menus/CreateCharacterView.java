package mu.edu.c.menus;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class CreateCharacterView extends JPanel {
    // Labels
    JLabel nameLabel = new JLabel("Name:");
    
    // Text Fields
    JTextField nameField = new JTextField(20);
    
    //TODO
    // attribute points remaining 
    // str, def, brains incrementor, decrements attr points
    
    JButton newBtn;    
    // Buttons for submission and navigation
    JButton btnSubmit;
    JButton btnBack;
    
    // Color styling
    Color buttonColor = Color.white;
    Color buttonColorPressed = new Color(226, 221, 250);

    public CreateCharacterView() {
        // Set panel boundaries
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setLayout(new GridBagLayout());

        // Set panel color
        this.setBackground(new Color(45, 44, 65));

        // Set up panel layout 
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 50, 0);
        this.add(CreateCharacterTitle(), gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // Initialize Buttons (submit and back)
        initializeButtons();

        JPanel buttonsPanel = new JPanel(new GridBagLayout());
        buttonsPanel.setBackground(new Color(45, 44, 65));

        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridwidth = GridBagConstraints.REMAINDER;
        gbc2.insets = new Insets(0, 0, 20, 0);
        gbc2.anchor = GridBagConstraints.CENTER;
        gbc2.fill = GridBagConstraints.HORIZONTAL;

        buttonsPanel.add(nameField, gbc2);
        buttonsPanel.add(btnSubmit, gbc2);
        buttonsPanel.add(btnBack, gbc2);
        
        // Decrease the size of the nameField
        nameField.setPreferredSize(new Dimension(100, 50));

        // Set layout
        setLayout(new GridLayout(3, 1));
        add(buttonsPanel);
    }
    
    private void applyEnteredExitedActions(JButton button) {
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                buttonEntered(button);
            }
            public void mouseExited(MouseEvent e) {
                buttonExited(button);
            }
        });
    }

    private void initializeButtons() {
        // Make button variables
        btnSubmit = new JButton("Create character");
        btnBack = new JButton("Back");
        
        // Set visuals for buttons
        SetUpButton(btnSubmit);
        SetUpButton(btnBack);
        
        // Add action listeners
        btnSubmit.addActionListener(e -> {
            // Handle submit button action here
        });
        btnBack.addActionListener(e -> {
            // Handle back button action here
        });
    }
    
    private void SetUpButton(JButton btn) {
        Font buttonFont= new Font("Yu Gothic Medium", Font.PLAIN, 16);
        
        // Customize button appearance
        btn.setFont(buttonFont);
        btn.setBackground(buttonColor);
        btn.setFocusPainted(false);
        btn.setPreferredSize(new Dimension(200, 50)); // Adjust button size as needed
        btn.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        
        // Apply mouse hover effects
        applyEnteredExitedActions(btn);
    }
    
    private JLabel CreateCharacterTitle() {
        JLabel titleLabel = new JLabel("Character Creation");
        titleLabel.setForeground(new Color(255, 255, 255));
        titleLabel.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 70)); // Adjust font size as needed
        return titleLabel;
    }
    
    private void buttonEntered(JButton button) {
        button.setBackground(buttonColorPressed);
        
        Font buttonFont = new Font("Yu Gothic Medium", Font.BOLD, 16);
        button.setFont(buttonFont);
    }
    
    private void buttonExited(JButton button) {
        button.setBackground(buttonColor);
        Font buttonFont= new Font("Yu Gothic Medium", Font.PLAIN, 16);
        button.setFont(buttonFont);
    }
    
    public void addBackButtonListener(ActionListener listener) {
        btnBack.addActionListener(listener);
    }
    
    
    /**
     * Action listener for when the submit button gets pressed.
     * @param listener
     */
    public void addSubmitButtonListener(ActionListener listener) {
    	btnSubmit.addActionListener(listener);
    }
}