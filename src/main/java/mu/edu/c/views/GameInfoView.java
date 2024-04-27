package mu.edu.c.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GameInfoView extends JPanel{
	
	JButton btnViewWeapons;
	JButton btnViewEnemies;
	JButton btnViewCharacters;
	JButton btnBack;
	Color buttonColor = Color.white;
	Color buttonColorPressed = new Color(226, 221, 250);
	
	public GameInfoView(){
			
			setBorder(new EmptyBorder(10, 10, 10, 10));
	        setLayout(new GridBagLayout());
			
			this.setBackground(new Color(45, 44, 65));
			
			GridBagConstraints gbc = new GridBagConstraints();
	        gbc.gridwidth = GridBagConstraints.REMAINDER;
	        gbc.anchor = GridBagConstraints.NORTH;

	        gbc.insets = new Insets(50, 30, 0, 30);
	        this.add(GameInfoTitle(), gbc);

	        gbc.anchor = GridBagConstraints.CENTER;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        
	        //initialize Buttons (start and credits)
			initializeButtons(gbc);
			
			JPanel buttons = new JPanel(new GridBagLayout());
			buttons.setBackground(new Color(45, 44, 65));
			
			GridBagConstraints gbc2 = new GridBagConstraints();
			gbc2.gridwidth = GridBagConstraints.REMAINDER;
			gbc2.insets = new Insets(0, 0, 20, 0);
			gbc2.anchor = GridBagConstraints.CENTER;
		    gbc2.fill = GridBagConstraints.HORIZONTAL;
	        buttons.add(btnViewWeapons, gbc2);
	        buttons.add(btnViewEnemies, gbc2);
	        buttons.add(btnViewCharacters, gbc2);
	        buttons.add(btnBack, gbc2);
	        
	        gbc.weighty = 1;
	        add(buttons, gbc);
			
	        applyEnteredExitedActions(btnViewCharacters);
	        applyEnteredExitedActions(btnViewEnemies);
	        applyEnteredExitedActions(btnViewWeapons);
			applyEnteredExitedActions(btnBack);
			
			
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

		private void initializeButtons(GridBagConstraints gbc) {
			
			//make button variables
			btnViewWeapons = new JButton("View All Weapons");
			btnViewEnemies = new JButton("View All Enemies");
			btnViewCharacters = new JButton("View All Characters");
			btnBack = new JButton("Back");
			
			////////////////////Set visuals for buttons////////////////////
			Font buttonFont= new Font("Yu Gothic Medium", Font.PLAIN, 16);
			
			SetUpButton(btnViewWeapons);
			SetUpButton(btnViewCharacters);
			SetUpButton(btnViewEnemies);
			SetUpButton(btnBack);
			
		}
		
		private void SetUpButton(JButton btn) {
			Font buttonFont= new Font("Yu Gothic Medium", Font.PLAIN, 16);
			
			//Start Game button
			btn.setFont(buttonFont);
			btn.setBackground(buttonColor);
			btn.setFocusPainted(false);
			btn.setPreferredSize(new Dimension(200, 100));
			btn.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		}
		

		private JLabel GameInfoTitle() {
			JLabel TitleLabel = new JLabel("Game Info");
			TitleLabel.setForeground(new Color(255, 255, 255));
			TitleLabel.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 70));
			
			return TitleLabel;
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
}

