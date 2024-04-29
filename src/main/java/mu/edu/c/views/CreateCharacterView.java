package mu.edu.c.views;

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

public class CreateCharacterView extends ParentView {
    // Labels
    JLabel nameLabel = new JLabel("Name:");
    
    // Text Fields
    private JTextField nameField = new JTextField(20);
    
    //TODO
    // attribute points remaining 
    // str, def, brains incrementor, decrements attr points
    
    private JButton newBtn;    
    // Buttons for submission and navigation
    private JButton btnSubmit;
    private  JButton btnBack;

    public CreateCharacterView() {

        // Set up panel layout 
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 50, 0);
        this.add(createTitle("Character Creation"), gbc);

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

        buttonsPanel.add(getNameField(), gbc2);
        buttonsPanel.add(btnSubmit, gbc2);
        buttonsPanel.add(btnBack, gbc2);
        
        // Decrease the size of the nameField
        getNameField().setPreferredSize(new Dimension(100, 50));

        add(buttonsPanel);
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

	public JTextField getNameField() {
		return nameField;
	}

	public void setNameField(JTextField nameField) {
		this.nameField = nameField;
	}
}