package mu.edu.c.views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import mu.edu.c.audio.AudioPlayer;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;

public class LoseScreenView extends ParentView{
	
	private static final long serialVersionUID = 1152872396771568015L;
	JButton btnRestart;
	JButton btnGiveUp;
	
	public LoseScreenView() {
		AudioPlayer.stopAllAudio();
		setBackground(backgroundColor);
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("GAME OVER");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Cooper Black", Font.PLAIN, 22));
		add(lblNewLabel);
		
		initializeButtons();
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setBackground(backgroundColor);
		buttonsPanel.add(btnRestart);
		buttonsPanel.add(btnGiveUp);
		add(buttonsPanel);
		buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
	}
	
    /**
     * Method that initializes common buttons found in classes
     */
    private void initializeButtons() {
        // Make button variables
    	btnRestart = new JButton("Start Again");
    	btnGiveUp = new JButton("Give Up");
        
        // Set visuals for buttons
        SetUpButton(btnRestart);
        SetUpButton(btnGiveUp);
        
        // Add action listeners
        btnRestart.addActionListener(e -> {
            // Handle submit button action here
        });
        btnGiveUp.addActionListener(e -> {
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
     * Action listener for give up button
     * @param listener
     */
    public void addGiveUpButtonListener(ActionListener listener) {
    	btnGiveUp.addActionListener(listener);
    }
}
