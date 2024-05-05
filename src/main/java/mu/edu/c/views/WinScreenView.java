package mu.edu.c.views;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import mu.edu.c.audio.AudioPlayer;

public class WinScreenView extends ParentView {
	
	private static final long serialVersionUID = 3752206612369621279L;
	JButton btnNewWeapon;
	JButton btnContinue;
	JLabel newWeaponLabel;
	
	public WinScreenView() {
		AudioPlayer.stopAllAudio();
		setBackground(new Color(45, 44, 65));
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("New weapon found!");
		lblNewLabel.setForeground(new Color(255, 255, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Cooper Black", Font.PLAIN, 22));
		add(lblNewLabel);
		
		newWeaponLabel = new JLabel("wa");
		newWeaponLabel.setFont(new Font("Cantor", Font.BOLD, 15));
		newWeaponLabel.setForeground(new Color(255, 255, 0));
		newWeaponLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(newWeaponLabel);
		
		initializeButtons();
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setBackground(new Color(45, 44, 65));
		buttonsPanel.add(btnNewWeapon);
		buttonsPanel.add(btnContinue);
		add(buttonsPanel);
		buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	
	}
	
    /**
     * Method that initializes common buttons found in classes
     */
    private void initializeButtons() {
        // Make button variables
    	btnNewWeapon = new JButton("Pick up new weapon");
    	btnContinue = new JButton("Keep current weapon");
        
        // Set visuals for buttons
        SetUpButton(btnNewWeapon);
        SetUpButton(btnContinue);
        
        // Add action listeners
        btnNewWeapon.addActionListener(e -> {
            // Handle submit button action here
        });
        btnContinue.addActionListener(e -> {
            // Handle back button action here
        });
    }
    
    /**
     * Action listener for game restart button
     * @param listener
     */
    public void addPickNewWeaponListener(ActionListener listener) {
    	btnNewWeapon.addActionListener(listener);
    }
    
    /**
     * Action listener for close game button
     * @param listener
     */
    public void addKeepCurrentWeaponListener(ActionListener listener) {
    	btnContinue.addActionListener(listener);
    }
    
    /**
     * Sets weapon label to given string
     * @param newWeaponLabel
     */
    public void setWeaponLabel(String newWeaponLabel) {
		this.newWeaponLabel.setText(newWeaponLabel);
	}
	
}
