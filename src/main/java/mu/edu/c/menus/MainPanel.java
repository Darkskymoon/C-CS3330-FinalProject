package mu.edu.c.menus;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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

public class MainPanel extends JPanel{
	
	JButton btnStartGame;
	JButton btnCredits;
	JButton btnInfo;
	Color buttonColor = Color.white;
	Color buttonColorPressed = new Color(226, 221, 250);
	
	public MainPanel(){
			
			setBorder(new EmptyBorder(10, 10, 10, 10));
	        setLayout(new GridBagLayout());
			
			
			this.setBackground(new Color(45, 44, 65));
			
			GridBagConstraints gbc = new GridBagConstraints();
	        gbc.gridwidth = GridBagConstraints.REMAINDER;
	        gbc.anchor = GridBagConstraints.NORTH;

	        add(FightSimulatorTitle(), gbc);

	        gbc.anchor = GridBagConstraints.CENTER;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        
	        //initialize Buttons (start and credits)
			initializeButtons(gbc);
			
			JPanel buttons = new JPanel(new GridBagLayout());
			buttons.setBackground(new Color(45, 44, 65));
	        buttons.add(btnStartGame, gbc);
	        buttons.add(btnCredits, gbc);
	        buttons.add(btnInfo, gbc);

	        gbc.weighty = 1;
	        add(buttons, gbc);
			
			
			btnStartGame.addMouseListener(new MouseAdapter() {
				//change button when mouse is hovered over it
				@Override
				public void mouseEntered(MouseEvent e) {
					btnStartGame.setBackground(buttonColorPressed);
					btnStartGame.setBorder(BorderFactory.createLoweredSoftBevelBorder());
					
					Font buttonFont= new Font("Yu Gothic Medium", Font.PLAIN, 16);
					btnStartGame.setFont(buttonFont);
				}
				//reset button after mouse leaves
				public void mouseExited(MouseEvent e) {
					btnStartGame.setBackground(buttonColor);
					Font buttonFont= new Font("Yu Gothic Medium", Font.PLAIN, 14);
					btnStartGame.setFont(buttonFont);
				}
			});
			
			btnInfo.addMouseListener(new MouseAdapter() {
				
				@Override
				public void mouseEntered(MouseEvent e) {
					btnInfo.setBackground(buttonColorPressed);
					btnInfo.setBorder(BorderFactory.createLoweredSoftBevelBorder());
					
					Font buttonFont= new Font("Yu Gothic Medium", Font.PLAIN, 16);
					btnInfo.setFont(buttonFont);
				}
				public void mouseExited(MouseEvent e) {
					btnInfo.setBackground(buttonColor);
					Font buttonFont= new Font("Yu Gothic Medium", Font.PLAIN, 14);
					btnInfo.setFont(buttonFont);
				}
			});
			
			btnCredits.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					btnCredits.setBackground(buttonColorPressed);
					btnCredits.setBorder(BorderFactory.createLoweredSoftBevelBorder());
					
					Font buttonFont= new Font("Yu Gothic Medium", Font.PLAIN, 16);
					btnCredits.setFont(buttonFont);
				}
				public void mouseExited(MouseEvent e) {
					btnCredits.setBackground(buttonColor);
					Font buttonFont= new Font("Yu Gothic Medium", Font.PLAIN, 14);
					btnCredits.setFont(buttonFont);
				}
			});
			
		}

		private void initializeButtons(GridBagConstraints gbc) {
			//make button variables
			btnStartGame = new JButton("Start Game");

			btnCredits = new JButton("Credits");
			btnInfo = new JButton("Game Info");
			
			//set bounds of the buttons
			int btnXPos = 300;
			int btnYPos = 150;
			int btnWidth=200;
			int btnHeight=75;
			
			btnStartGame.setBounds(btnXPos, btnYPos, btnWidth, btnHeight);
			btnCredits.setBounds(btnXPos, btnYPos+85*2, btnWidth, btnHeight);
			btnInfo.setBounds(btnXPos, btnYPos+85, btnWidth, btnHeight);
			
			////////////////////Set visuals for buttons////////////////////
			Font buttonFont= new Font("Yu Gothic Medium", Font.PLAIN, 14);
			//Start Game button
			btnStartGame.setFont(buttonFont);
			btnStartGame.setBackground(buttonColor);
			btnStartGame.setFocusPainted(false);
			btnStartGame.setBorder(BorderFactory.createLoweredSoftBevelBorder());
			
			//Credits Button
			btnCredits.setFont(buttonFont);
			btnCredits.setBackground(buttonColor);
			btnCredits.setFocusPainted(false);
			btnCredits.setBorder(BorderFactory.createLoweredSoftBevelBorder());
			
			//Info Button
			btnInfo.setFont(buttonFont);
			btnInfo.setBackground(buttonColor);
			btnInfo.setFocusPainted(false);
			btnCredits.setBorder(BorderFactory.createLoweredSoftBevelBorder());
			
			
			/////////////////Action Listeners/////////////////////
			//StartGame 
			btnStartGame.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			
			//Credits
			btnCredits.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			
			//Info
			btnInfo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			
			
			
			
		}
		

		private JLabel FightSimulatorTitle() {
			JLabel TitleLabel = new JLabel("Fight Simulator");
			TitleLabel.setForeground(new Color(255, 255, 255));
			TitleLabel.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 24));
			
			return TitleLabel;
		}
}
