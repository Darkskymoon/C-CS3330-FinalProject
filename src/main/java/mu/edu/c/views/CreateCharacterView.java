package mu.edu.c.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import mu.edu.c.audio.AudioPlayer;

public class CreateCharacterView extends ParentView implements ChangeListener{
	
    //TODO
    // attribute points remaining 
    // str, def, brains incrementor, decrements attr points
    
    Border border = BorderFactory.createLineBorder(Color.red, 5);

	//Global values that have to exported, textfields, buttons, inputs
	
	//global attributes
	private int totalAttributePoints = 50;
	private int attributePointsLeft = 50;
	
	private Font attributeHeaderFont =  new Font("Consolas", Font.PLAIN, 30);
	
	//labels
	JLabel attributePointsLabel = new JLabel("Points Left: " + attributePointsLeft);
    JLabel strPointsLabel = new JLabel("strength: 0");
    JLabel defPointsLabel = new JLabel("defense: 0");
    JLabel brainsPointsLabel = new JLabel("brains: 0");
    
	//sliders
	private JSlider strSlider = new JSlider(0, 50, 0);
	private JSlider defSlider = new JSlider(0, 50, 0);
	private JSlider brainsSlider = new JSlider(0, 50, 0);
	
	//textfields
    private JTextField nameField = new JTextField(20);
    
    //buttons
    private JButton btnSubmit;
    private  JButton btnBack;

    public CreateCharacterView() {
    	AudioPlayer.stopAllAudio();

    	//////////// Page Layout Setup ////////////
    	this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 100, 0);
        this.add(createTitle("Character Creation"), gbc);
        
        //////////// Form elements ////////////
        JPanel namePanel = new JPanel();
        JLabel nameLabel = new JLabel();
        namePanel.setLayout(new BorderLayout());
        nameLabel.setText("Name:");
        nameLabel.setForeground(Color.black);
        nameLabel.setFont(attributeHeaderFont);
        
        nameField.setPreferredSize(new Dimension(100, 50));
        nameField.setFont(new Font("Consolas", Font.PLAIN, 16));
        
        namePanel.add(nameLabel, BorderLayout.NORTH);
        namePanel.add(nameField);
        gbc.anchor = GridBagConstraints.LINE_START;
        
        gbc.insets = new Insets(0, 0, 50, 0);
        gbc.gridy = 1;
        gbc.gridx = 1;
        this.add(namePanel, gbc);
        
        JPanel attributePanel = new JPanel();
        
        attributePanel.setLayout(new GridLayout(7, 1));
        attributePointsLabel.setFont(attributeHeaderFont);
        
        // slider config
        strSlider.setPaintTicks(true);
        defSlider.setPaintTicks(true);
        brainsSlider.setPaintTicks(true);
        
        strSlider.setMinorTickSpacing(1);
        defSlider.setMinorTickSpacing(1);
        brainsSlider.setMinorTickSpacing(1);
        
        strSlider.setMajorTickSpacing(10);
        defSlider.setMajorTickSpacing(10);
        brainsSlider.setMajorTickSpacing(10);
        
        strSlider.setPaintLabels(true);
        defSlider.setPaintLabels(true);
        brainsSlider.setPaintLabels(true);
        
        strSlider.addChangeListener(this);
        defSlider.addChangeListener(this);
        brainsSlider.addChangeListener(this);
        
        attributePanel.add(attributePointsLabel);
        attributePanel.add(defPointsLabel);
        attributePanel.add(defSlider);
        attributePanel.add(strPointsLabel);
        attributePanel.add(strSlider);
        attributePanel.add(brainsPointsLabel);
        attributePanel.add(brainsSlider);
        
        attributePanel.setPreferredSize(new Dimension(400, 300));
        gbc.gridy = 1;
        gbc.gridx = 2;
        gbc.anchor = GridBagConstraints.LINE_END;
        this.add(attributePanel, gbc);
        

        //////////// Create and back buttons ////////////
        initializeButtons();

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout());
        buttonsPanel.setBackground(new Color(45, 44, 65));

        buttonsPanel.add(btnSubmit);
        buttonsPanel.add(btnBack);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridy = 2;
        this.add(buttonsPanel, gbc);
    }
    
	@Override
	public void stateChanged(ChangeEvent e) {
		int strPts = strSlider.getValue();
		int defPts = defSlider.getValue();
		int braPts = brainsSlider.getValue();
		
		int pointsUsed = strPts + defPts + braPts;
		attributePointsLeft = totalAttributePoints - pointsUsed;
		
		if (attributePointsLeft >= 0) {
		attributePointsLabel.setText("Points Left: " + attributePointsLeft);
        strPointsLabel.setText("strength: " + strPts);
        defPointsLabel.setText("defense: " + defPts);
        brainsPointsLabel.setText("brains: " + braPts);
        
        return ;
		}
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
    
    public int getStrengthStat() {
		int strPts = strSlider.getValue();
    	return strPts;
    }
    public int getDefenseStat() {
		int defPts = defSlider.getValue();
    	return defPts;
    }
    public int getBrainsStat() {
		int braPts = brainsSlider.getValue();
    	return braPts;
    }
	public JTextField getNameField() {
		return nameField;
	}

	public void setNameField(JTextField nameField) {
		this.nameField = nameField;
	}

}