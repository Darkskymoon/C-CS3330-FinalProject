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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import mu.edu.c.weapons.WeaponType;

public class CreateWeaponView extends ParentView implements ChangeListener , ActionListener{
    
    Border border = BorderFactory.createLineBorder(Color.red, 5);

	//Global values that have to exported, textfields, buttons, inputs
	
	//global attributes
	
	private Font attributeHeaderFont =  new Font("Consolas", Font.PLAIN, 30);
	
	//combo boxes (drop downs)
	String[] choices = {"SWORD", "MAGIC"};
	final JComboBox<String> weaponComboBox;
	
	//labels
	JLabel attributePointsLabel = new JLabel("Set Attributes");
    JLabel simpleDamageLabel = new JLabel("Normal Damage: 0");
    JLabel specialDamageLabel = new JLabel("Special Damage: 0");
    JLabel scalerLabel = new JLabel("scaler: 0");
    JLabel weaponNameLabel = new JLabel();
    
	//sliders
	private JSlider simpleDamageSlider = new JSlider(0, 50, 0);
	private JSlider specialDamageSlider = new JSlider(0, 50, 0);
	private JSlider scalerSlider = new JSlider(0, 100, 0);
	
	//textfields
    private JTextField nameField;
    
    //buttons
    private JButton btnSubmit;
    private  JButton btnBack;

    public CreateWeaponView() {
    	AudioPlayer.stopAllAudio();

    	//////////// Page Layout Setup ////////////
    	this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 0, 0);
        this.add(createTitle("Weapon Creation"), gbc);
        
        //////////// Form elements ////////////
    	JPanel nameTypePanel = new JPanel();
    	initializeNameFields();
    	nameTypePanel.setPreferredSize(new Dimension(300, 120));
        weaponNameLabel = new JLabel();
        weaponComboBox = new JComboBox<String>(choices);
        
        nameTypePanel.setLayout(new FlowLayout(100));
        nameTypePanel.setBackground(new Color(45, 44, 65));
        weaponNameLabel.setText("Name:");
        weaponNameLabel.setForeground(Color.white);
        weaponNameLabel.setFont(attributeHeaderFont);
                        
        weaponComboBox.setPreferredSize(new Dimension(250, 50));
        
        nameTypePanel.add(weaponNameLabel);
        nameTypePanel.add(nameField);
        nameTypePanel.add(weaponComboBox);
        
        gbc.anchor = GridBagConstraints.LINE_START;
        
        gbc.insets = new Insets(0, 0, 0, 350);
        gbc.gridy = 1;
        gbc.gridx = 1;
        this.add(nameTypePanel, gbc);
        
        JPanel attributePanel = new JPanel();
        
        attributePanel.setLayout(new GridLayout(7, 1));
        attributePointsLabel.setFont(attributeHeaderFont);
        
        // slider config
        simpleDamageSlider.setPaintTicks(true);
        specialDamageSlider.setPaintTicks(true);
        scalerSlider.setPaintTicks(true);
        
        simpleDamageSlider.setMinorTickSpacing(1);
        specialDamageSlider.setMinorTickSpacing(1);
        scalerSlider.setMinorTickSpacing(1);
        
        simpleDamageSlider.setMajorTickSpacing(10);
        specialDamageSlider.setMajorTickSpacing(10);
        scalerSlider.setMajorTickSpacing(10);
        
        simpleDamageSlider.setPaintLabels(true);
        specialDamageSlider.setPaintLabels(true);
        scalerSlider.setPaintLabels(true);
        
        simpleDamageSlider.addChangeListener(this);
        specialDamageSlider.addChangeListener(this);
        scalerSlider.addChangeListener(this);
        
        attributePanel.add(attributePointsLabel);
        attributePanel.add(specialDamageLabel);
        attributePanel.add(specialDamageSlider);
        attributePanel.add(simpleDamageLabel);
        attributePanel.add(simpleDamageSlider);
        attributePanel.add(scalerLabel);
        attributePanel.add(scalerSlider);
        
        weaponComboBox.addActionListener(this);

        attributePanel.setPreferredSize(new Dimension(300, 280));
        gbc.insets = new Insets(0, 350, 0, 0);
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
        
        btnSubmit.setEnabled(false);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.gridy = 2;
        this.add(buttonsPanel, gbc);
    }
    
	@Override
	public void stateChanged(ChangeEvent e) {
		int simpleDamagePts = simpleDamageSlider.getValue();
		int specialDamagePts = specialDamageSlider.getValue();
		int scalerPts = scalerSlider.getValue();
				
        simpleDamageLabel.setText("simple damage: " + simpleDamagePts);
        specialDamageLabel.setText("special damage: " + specialDamagePts);
        scalerLabel.setText("scaler: " + scalerPts);
		}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
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
        btnSubmit = new JButton("Create Weapon");
        btnBack = new JButton("Back");
        
        // Set visuals for buttons
        SetUpButton(btnSubmit);
        SetUpButton(btnBack);
                
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
    
    public int getSimpleDamageStat() {
		int simpleDamagePts = simpleDamageSlider.getValue();
    	return simpleDamagePts;
    }
    
    public int getSpecialDamageStat() {
		int specialDamagePts = specialDamageSlider.getValue();
    	return specialDamagePts;
    }
    
    public float getScalerStat() {
		float scalerPts = scalerSlider.getValue();
    	return scalerPts;
    }
    
    // returns the selected weapon ENUM
    public WeaponType getWeaponTypeIndex() {
    	int typeIndex = weaponComboBox.getSelectedIndex();
    	return WeaponType.values()[typeIndex];
    }
    
	public JTextField getNameField() {
		return nameField;
	}

	public void setNameField(JTextField nameField) {
		this.nameField = nameField;
	}

}