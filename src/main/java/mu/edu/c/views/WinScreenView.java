package mu.edu.c.views;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import mu.edu.c.audio.AudioPlayer;

public class WinScreenView extends ParentView implements ActionListener {
	
	JButton btnRestart;
	JButton btnRetire;
	
	public WinScreenView() {
		AudioPlayer.stopAllAudio();
		setBackground(new Color(45, 44, 65));
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("VICTORY!");
		lblNewLabel.setForeground(new Color(255, 255, 0));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Cooper Black", Font.PLAIN, 22));
		add(lblNewLabel);
		
		initializeButtons();
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setBackground(new Color(45, 44, 65));
		buttonsPanel.add(btnRestart);
		buttonsPanel.add(btnRetire);
		add(buttonsPanel);
		buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	
	}
	
    /**
     * Method that initializes common buttons found in classes
     */
    private void initializeButtons() {
        // Make button variables
    	btnRestart = new JButton("Start Again");
    	btnRetire = new JButton("Retire");
        
        // Set visuals for buttons
        SetUpButton(btnRestart);
        SetUpButton(btnRetire);
        
        // Add action listeners
        btnRestart.addActionListener(e -> {
            // Handle submit button action here
        });
        btnRetire.addActionListener(e -> {
            // Handle back button action here
        });
    }
    
    /**
     * Action listener for game restart button
     * @param listener
     */
    public void addRestartButtonListener(ActionListener listener) {
    	btnRestart.addActionListener(listener);
    }
    
    /**
     * Action listener for close game button
     * @param listener
     */
    public void addRetireButtonListener(ActionListener listener) {
    	btnRetire.addActionListener(listener);
    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
