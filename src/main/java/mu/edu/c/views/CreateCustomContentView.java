package mu.edu.c.views;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import mu.edu.c.logger.CharacterLoggerSingleton;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

public class CreateCustomContentView extends ParentView {
	private static final long serialVersionUID = -7617276032050941344L;
	JButton btnCreateNewWeapon;

	JButton btnCreateNewEnemy;
	JButton btnBack;

	public CreateCustomContentView() {
		setBackground(backgroundColor);
		setLayout(new GridLayout(3, 0));
		
		JLabel lblNewLabel = new JLabel("Custom Content Creator");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(backgroundColor);
		lblNewLabel.setFont(new Font("Cantor", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(backgroundColor);
		add(panel);
		initializeButtons();
		
		panel.add(btnCreateNewEnemy);		
		panel.add(btnCreateNewWeapon);
		
		JPanel backPanel = new JPanel();
		backPanel.setBackground(backgroundColor);
		add(backPanel);
		
		backPanel.add(btnBack);
	}
    /**
     * Method that initializes common buttons found in classes
     */
	private void initializeButtons() {
	    // Make button variables
		btnCreateNewWeapon = new JButton("Custom Weapon");
		btnCreateNewEnemy = new JButton("Custom Enemy");
		btnBack = new JButton("Back");
	    
	    // Set visuals for buttons
	    SetUpButton(btnCreateNewWeapon);
	    SetUpButton(btnCreateNewEnemy);
	    SetUpButton(btnBack);
	    
	    CharacterLoggerSingleton logger = CharacterLoggerSingleton.getInstance();
	    if (logger.readCharacterData() == null) {
	    	btnCreateNewWeapon.setEnabled(false);
	    }
	}
	
	public void addCreateNewWeaponListener(ActionListener listener) {
		btnCreateNewWeapon.addActionListener(listener);
	}
	
	public void addCreateNewEnemyListener(ActionListener listener) {
		btnCreateNewEnemy.addActionListener(listener);
	}

    public void addBackButtonListener(ActionListener listener) {
        btnBack.addActionListener(listener);
    }
    
	public JButton getBtnCreateNewWeapon() {
		return btnCreateNewWeapon;
	}
	public JButton getBtnCreateNewEnemy() {
		return btnCreateNewEnemy;
	}
	public JButton getBtnBack() {
		return btnBack;
	}
    
}
