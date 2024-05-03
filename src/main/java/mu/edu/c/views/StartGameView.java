package mu.edu.c.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
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

public class StartGameView extends ParentView{
	
	private JButton btnLoadCharacter;
	private JButton BtnNewChar;
	private JButton btnBack;
	
	public StartGameView(){
			AudioPlayer.stopAllAudio();
			
			GridBagConstraints gbc = new GridBagConstraints();
	        gbc.gridwidth = GridBagConstraints.REMAINDER;
	        gbc.anchor = GridBagConstraints.NORTH;

	        gbc.insets = new Insets(50, 0, 50, 0);
	        this.add(createTitle("Start Game"), gbc);

	        gbc.anchor = GridBagConstraints.CENTER;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        
	        //initialize Buttons (start and credits)
			initializeButtons(gbc);
			
			JPanel buttons = new JPanel(new GridBagLayout());
			buttons.setBackground(new Color(45, 44, 65));
			
			GridBagConstraints gbc2 = new GridBagConstraints();
			gbc2.insets = new Insets(30, 10, 30, 10);
			gbc2.anchor = GridBagConstraints.CENTER;
		    gbc2.fill = GridBagConstraints.BOTH;
		    
		    
		    buttons.add(btnLoadCharacter, gbc2);
		    
		    buttons.add(BtnNewChar, gbc2);
	        
	        gbc.weighty = 0;
	        add(buttons, gbc);
	        
	        add(btnBack);

			AudioPlayer.playAudio("StartGameSound");

		}
	
		private void initializeButtons(GridBagConstraints gbc) {
			
			//make button variables
			btnLoadCharacter = new JButton("Load Character");
			btnBack = new JButton("Back");
			BtnNewChar = new JButton("Create new character");
			
			////////////////////Set visuals for buttons////////////////////
			Font buttonFont= new Font("Yu Gothic Medium", Font.PLAIN, 16);
			
			double biggerSize = 1.3;
			
			SetUpButtonCustomSize(btnLoadCharacter, biggerSize);
			SetUpButtonCustomSize(btnBack, biggerSize);
			SetUpButtonCustomSize(BtnNewChar, biggerSize);
			
		}
		
		/////////////////////////////////////////////////////////////////////////
		//////////////// LISTENER SECTION ///////////////////////////////////////
		/////////////////////////////////////////////////////////////////////////
		
		public void addBackButtonListener(ActionListener listener) {
			btnBack.addActionListener(listener);
		}
		
		public void addLoadCharacterButtonListener(ActionListener listener) {
			btnLoadCharacter.addActionListener(listener);
		}
		
//		public void addLoad2Listener(ActionListener listener) {
//			btnLoad2.addActionListener(listener);
//		}
		
		public void addBtnNewCharListener(ActionListener listener) {
			BtnNewChar.addActionListener(listener);
		}
		// add button redirects here
		
		
		//////////////////////////////////////////////////////////////////////////
		//////////////// SETTER SECTION //////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////
		
		/**
		 * Sets the text on the load 1 button
		 * @param Text text to set the button to
		 */
		public void setLoadCharacterText(String Text) {
			this.btnLoadCharacter.setText(Text);
			
		}
		
		public void setNewCharHide() {
			this.BtnNewChar.setVisible(false);
			setNewCharDisable();
		}
		public void setNewCharDisable() {
			this.BtnNewChar.setEnabled(false);
		}
		public void setNewCharEnable() {
			this.BtnNewChar.setEnabled(true);
		}

		public JButton getBtnLoadCharacter() {
			return btnLoadCharacter;
		}

		public JButton getBtnNewChar() {
			return BtnNewChar;
		}

		public JButton getBtnBack() {
			return btnBack;
		}
		
		public void setLoadCharacterHide() {
			this.btnLoadCharacter.setVisible(false);
		}
		
		
}

