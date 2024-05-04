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
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import mu.edu.c.audio.AudioPlayer;

public class CreateEnemyView extends ParentView implements ChangeListener{
	
    
    private static final long serialVersionUID = 4479215770944484503L;

	Border border = BorderFactory.createLineBorder(Color.red, 5);

	//Global values that have to exported, textfields, buttons, inputs
	
	//global attributes
	private int totalAttributePoints = 100;
	private int attributePointsLeft = 100;
	
	private Font attributeHeaderFont =  new Font("Consolas", Font.PLAIN, 30);
	
	//labels
	JLabel attributePointsLabel = new JLabel("Points Left: " + attributePointsLeft);
	JLabel maxHpPointsLabel = new JLabel("max hp: 0");
    JLabel strPointsLabel = new JLabel("strength: 0");
    JLabel defPointsLabel = new JLabel("defense: 0");
    JLabel brainsPointsLabel = new JLabel("brains: 0");
    JLabel alertLabel;
    JLabel nameLabel = new JLabel();
    
	//sliders
    private JSlider maxHpSlider = new JSlider(0, 100, 0);
	private JSlider strSlider = new JSlider(0, 50, 0);
	private JSlider defSlider = new JSlider(0, 50, 0);
	private JSlider brainsSlider = new JSlider(0, 50, 0);
	
	//textfields
    private JTextField nameField;
    
    //buttons
    private JButton btnSubmit;
    private  JButton btnBack;

    public CreateEnemyView() {
    	AudioPlayer.stopAllAudio();

    	//////////// Page Layout Setup ////////////
    	this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 0, 0);
        this.add(createTitle("Enemy Creatior"), gbc);
        
        //////////// Form elements ////////////
    	JPanel namePanel = new JPanel();
    	initializeNameFields();
        nameLabel = new JLabel();
        alertLabel = new JLabel("");
        
        namePanel.setLayout(new BorderLayout());
        nameLabel.setText("Name:");
        nameLabel.setForeground(Color.black);
        nameLabel.setFont(attributeHeaderFont);
        
        alertLabel.setForeground(Color.red);
        
        nameField.setPreferredSize(new Dimension(100, 50));
        nameField.setFont(new Font("Consolas", Font.PLAIN, 16));
        
        namePanel.add(alertLabel, BorderLayout.SOUTH);
        namePanel.add(nameLabel, BorderLayout.NORTH);
        namePanel.add(nameField);
        
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0, 0, 0, 200);
        gbc.gridy = 1;
        gbc.gridx = 1;
        this.add(namePanel, gbc);
        
        JPanel attributePanel = new JPanel();
        
        attributePanel.setLayout(new GridLayout(9, 1));
        attributePointsLabel.setFont(attributeHeaderFont);
        
        // slider config
        maxHpSlider.setPaintTicks(true);
        strSlider.setPaintTicks(true);
        defSlider.setPaintTicks(true);
        brainsSlider.setPaintTicks(true);
        
        maxHpSlider.setMinorTickSpacing(5);
        strSlider.setMinorTickSpacing(1);
        defSlider.setMinorTickSpacing(1);
        brainsSlider.setMinorTickSpacing(1);
        
        maxHpSlider.setMajorTickSpacing(20);
        strSlider.setMajorTickSpacing(10);
        defSlider.setMajorTickSpacing(10);
        brainsSlider.setMajorTickSpacing(10);
        
        maxHpSlider.setPaintLabels(true);
        strSlider.setPaintLabels(true);
        defSlider.setPaintLabels(true);
        brainsSlider.setPaintLabels(true);
        
        maxHpSlider.addChangeListener(this);
        strSlider.addChangeListener(this);
        defSlider.addChangeListener(this);
        brainsSlider.addChangeListener(this);
        
        attributePanel.add(attributePointsLabel);
        attributePanel.add(maxHpPointsLabel);
        attributePanel.add(maxHpSlider);
        attributePanel.add(defPointsLabel);
        attributePanel.add(defSlider);
        attributePanel.add(strPointsLabel);
        attributePanel.add(strSlider);
        attributePanel.add(brainsPointsLabel);
        attributePanel.add(brainsSlider);
        
        attributePanel.setPreferredSize(new Dimension(400, 350));
        gbc.insets = new Insets(0, 200, 0, 0);
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
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.gridy = 2;
        this.add(buttonsPanel, gbc);
    }
    
	@Override
	public void stateChanged(ChangeEvent e) {
		int maxHpPts = maxHpSlider.getValue();
		int strPts = strSlider.getValue();
		int defPts = defSlider.getValue();
		int braPts = brainsSlider.getValue();
		
		int pointsUsed = maxHpPts + strPts + defPts + braPts;
		attributePointsLeft = totalAttributePoints - pointsUsed;
		
		if (attributePointsLeft >= 0) {
		attributePointsLabel.setText("Points Left: " + attributePointsLeft);
		maxHpPointsLabel.setText("max hp: " + maxHpPts);
        strPointsLabel.setText("strength: " + strPts);
        defPointsLabel.setText("defense: " + defPts);
        brainsPointsLabel.setText("brains: " + braPts);
        return;
		}
	}
	private void initializeNameFields() {
		nameField = new JTextField(20);
		nameField.setPreferredSize(new Dimension(100, 50));
        nameField.setFont(new Font("Consolas", Font.PLAIN, 16));

        // add listener that reacts to changes
        // disables buttons when field is empty
        nameField.getDocument().addDocumentListener(new DocumentListener() {        	
			@Override
			public void removeUpdate(DocumentEvent e) {
				if (!nameField.getText().isEmpty()) {
					btnSubmit.setEnabled(true);
				} else {
					btnSubmit.setEnabled(false);
				}
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				if (!nameField.getText().isEmpty()) {
					btnSubmit.setEnabled(true);
				} else {
					btnSubmit.setEnabled(false);
				}
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
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
        
        // initialize button to false since name input is false
        btnSubmit.setEnabled(false);
                
        // Add action listeners
        btnSubmit.addActionListener(e -> {
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
    
    public int getMaxHp() {
    	int maxHp = maxHpSlider.getValue();
    	return maxHp;
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