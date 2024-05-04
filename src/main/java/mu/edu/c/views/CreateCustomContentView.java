package mu.edu.c.views;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

public class CreateCustomContentView extends ParentView implements ActionListener{
	private static final long serialVersionUID = -7617276032050941344L;
	JButton btnCreateNewWeapon;
	JButton btnCreateNewEnemy;
	JButton btnBack;

	public CreateCustomContentView() {
		setBackground(new Color(45, 44, 65));
		setLayout(new GridLayout(3, 0));
		
		JLabel lblNewLabel = new JLabel("Custom Content Creator");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(45, 44, 65));
		lblNewLabel.setFont(new Font("Cantor", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(45, 44, 65));
		add(panel);
		initializeButtons();
		
		panel.add(btnCreateNewEnemy);		
		panel.add(btnCreateNewWeapon);
		
		JPanel backPanel = new JPanel();
		backPanel.setBackground(new Color(45, 44, 65));
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
	    
	    // Add action listeners
	    btnCreateNewWeapon.addActionListener(e -> {
	        // Handle submit button action here
	    });
	    btnCreateNewEnemy.addActionListener(e -> {
	        
	    });
	    btnBack.addActionListener(e-> {
	    	// Handle back button action here
	    });

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
    
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
    
	
}
