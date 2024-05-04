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

import mu.edu.c.audio.AudioPlayer;

public class MainMenuView extends ParentView {
	
	protected JButton btnStartGame;
	protected JButton btnCredits;
	protected JButton btnInfo;
	protected JButton btnCustomContent;
	
	public MainMenuView(){
			AudioPlayer.stopAudio();
			
			GridBagConstraints gbc = new GridBagConstraints();
	        gbc.gridwidth = GridBagConstraints.REMAINDER;
	        gbc.anchor = GridBagConstraints.NORTH;

	        gbc.insets = new Insets(100, 30, 0, 30);
	        this.add(createTitle("Fight Simulator"), gbc);

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
	        buttons.add(btnStartGame, gbc2);
	        buttons.add(btnCustomContent, gbc2);
	        buttons.add(btnCredits, gbc2);
	        buttons.add(btnInfo, gbc2);

	        gbc.weighty = 1;
	        add(buttons, gbc);
			
			AudioPlayer.setTrack("MainGameSound");
		}

		private void initializeButtons(GridBagConstraints gbc) {
			
			//make button variables
			btnStartGame = new JButton("Start Game");
			btnCredits = new JButton("Credits");
			btnInfo = new JButton("Game Info");
			btnCustomContent = new JButton("Custom Content");
			
			////////////////////Set visuals for buttons////////////////////
			Font buttonFont= new Font("Yu Gothic Medium", Font.PLAIN, 16);
			
			SetUpButton(btnStartGame);
			SetUpButton(btnInfo);
			SetUpButton(btnCredits);
			SetUpButton(btnCustomContent);
			
		}
		
		public void addInfoButtonListener(ActionListener listener) {
			btnInfo.addActionListener(listener);
		}
		
		public void addStartGameButtonListener(ActionListener listener) {
			btnStartGame.addActionListener(listener);
		}
		
		public void addCreditButtonListener(ActionListener listener) {
			btnCredits.addActionListener(listener);
		}
		
		public void addCreateCustomContentButtonListener(ActionListener listener) {
			btnCustomContent.addActionListener(listener);
		}
		
		public JButton getBtnStartGame() {
			return btnStartGame;
		}

		public JButton getBtnCredits() {
			return btnCredits;
		}

		public JButton getBtnInfo() {
			return btnInfo;
		}
		
		public JButton getBtnCustomContent() {
			return btnCustomContent;
		}
		
		
}
