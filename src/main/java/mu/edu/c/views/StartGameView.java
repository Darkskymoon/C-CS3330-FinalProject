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
	
	private JButton btnLoad1;
	private JButton BtnNewChar;
	private JButton btnBack;
	
	public StartGameView(){
			AudioPlayer.stopAllAudio();
			
			GridBagConstraints gbc = new GridBagConstraints();
	        gbc.gridwidth = GridBagConstraints.REMAINDER;
	        gbc.anchor = GridBagConstraints.NORTH;

	        gbc.insets = new Insets(50, 30, 0, 30);
	        this.add(createTitle("Start Game"), gbc);

	        gbc.anchor = GridBagConstraints.CENTER;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        
	        //initialize Buttons (start and credits)
			initializeButtons(gbc);
			
			JPanel buttons = new JPanel(new GridBagLayout());
			buttons.setBackground(new Color(45, 44, 65));
			
			GridBagConstraints gbc2 = new GridBagConstraints();
			gbc2.gridwidth = GridBagConstraints.REMAINDER;
			gbc2.insets = new Insets(0, 0, 0, 0);
			gbc2.anchor = GridBagConstraints.CENTER;
		    gbc2.fill = GridBagConstraints.BOTH;
		    
		    
		    buttons.add(btnLoad1);
		    
		    buttons.add(BtnNewChar);
	        
	        gbc.weighty = 1;
	        add(buttons, gbc);
	        
	        add(btnBack);

			AudioPlayer.playAudio("StartGameSound");

		}
	
		private void initializeButtons(GridBagConstraints gbc) {
			
			//make button variables
			btnLoad1 = new JButton("Load 1");
			btnBack = new JButton("Back");
			BtnNewChar = new JButton("Create another character");
			
			////////////////////Set visuals for buttons////////////////////
			Font buttonFont= new Font("Yu Gothic Medium", Font.PLAIN, 16);
			
			
			SetUpButton(btnLoad1);
			SetUpButton(btnBack);
			SetUpButton(BtnNewChar);
			
		}
		
		private void SetUpLabel(JLabel label) {
			Font LabelFont= new Font("Yu Gothic Medium", Font.PLAIN, 16);
			
			//Start Game button
			label.setFont(LabelFont);
			label.setBackground(buttonColor);
			label.setPreferredSize(new Dimension(200, 100));
			label.setBorder(BorderFactory.createLoweredSoftBevelBorder());
			
			label.setBackground(buttonColor);
			Font buttonFont= new Font("Yu Gothic Medium", Font.PLAIN, 16);
			label.setFont(buttonFont);
		}
		
		
		/////////////////////////////////////////////////////////////////////////
		//////////////// LISTENER SECTION ///////////////////////////////////////
		/////////////////////////////////////////////////////////////////////////
		
		public void addBackButtonListener(ActionListener listener) {
			btnBack.addActionListener(listener);
		}
		
		public void addLoad1ButtonListener(ActionListener listener) {
			btnLoad1.addActionListener(listener);
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
		public void setLoad1Text(String Text) {
			this.btnLoad1.setText(Text);
			
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
}

