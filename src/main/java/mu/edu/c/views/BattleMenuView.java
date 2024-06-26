package mu.edu.c.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import mu.edu.c.audio.AudioPlayer;

public class BattleMenuView extends ParentView {
	
	private static final long serialVersionUID = -1797587602595723843L;
	private JLabel labelCharacterName;
	private JLabel labelBattleText;
	private JLabel labelEnemyName;
	private JLabel labelCharacterHP;
	private JButton btnSurrender;
	private JLabel labelEnemyHP;
	private JButton btnNormalAttack;
	private JButton btnSpecialAttack;
	
	private JLabel LabelRoll;
	
	
	public BattleMenuView(){
			AudioPlayer.stopAudio();
			AudioPlayer.setTrack("414214__sirkoto51__anime-fight-music-loop-1");

			GridBagConstraints gbc = new GridBagConstraints();
	        gbc.gridwidth = GridBagConstraints.REMAINDER;
	        gbc.anchor = GridBagConstraints.NORTH;

	        gbc.insets = new Insets(50, 30, 30, 30);

	        gbc.anchor = GridBagConstraints.CENTER;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        
	        labelCharacterName = new JLabel("", SwingConstants.CENTER);
	        labelBattleText = new JLabel("", SwingConstants.CENTER);
	        labelEnemyName = new JLabel("", SwingConstants.CENTER);
	        labelCharacterHP = new JLabel("", SwingConstants.CENTER);
	        labelEnemyHP = new JLabel("", SwingConstants.CENTER);
	        
	        
	        //initialize Buttons (start and credits)
			initializeButtons(gbc);
			SetUpLabel(labelCharacterName);
			SetUpLabel(labelBattleText);
			SetUpLabel(labelEnemyName);
			SetUpLabel(labelCharacterHP);
			SetUpLabel(labelEnemyHP);
			
			labelBattleText.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 20));
			
			JPanel buttons = new JPanel(new GridBagLayout());
			buttons.setBackground(backgroundColor);
			
			GridBagConstraints gbc2 = new GridBagConstraints();
			gbc2.gridwidth = GridBagConstraints.REMAINDER;
			gbc2.insets = new Insets(20, 20, 20, 20);
			gbc2.anchor = GridBagConstraints.CENTER;
		    gbc2.fill = GridBagConstraints.HORIZONTAL;
		    
		    GridBagConstraints gbc4 = new GridBagConstraints();
		    gbc4.insets = new Insets(20, 30, 30, 20);
		    
		    buttons.add(labelCharacterName, gbc4);
	        buttons.add(labelBattleText);
	        buttons.add(labelEnemyName, gbc2);
	        buttons.add(labelCharacterHP);
	        buttons.add(btnSurrender);
	        buttons.add(labelEnemyHP);
	        
	        add(buttons, gbc);
	        
	        JPanel LabelContainer = new JPanel(new GridBagLayout());
	        LabelContainer.setVisible(false);
	        LabelRoll=new JLabel("roll to hit");
	        LabelRoll.setForeground(Color.black);
	        LabelContainer.add(LabelRoll);
	        add(LabelContainer);
	        
	        
	        GridBagConstraints gbc3 = new GridBagConstraints();
			gbc3.gridwidth = GridBagConstraints.REMAINDER;
			gbc3.insets = new Insets(0, 20, 0,20);
			gbc3.anchor = GridBagConstraints.CENTER;
		    gbc3.fill = GridBagConstraints.HORIZONTAL;
		    
	        JPanel buttons2 = new JPanel(new GridBagLayout());
			buttons2.setBackground(backgroundColor);
			
			buttons2.add(btnNormalAttack);
			buttons2.add(btnSpecialAttack, gbc3);
			add(buttons2);
			
			
		}
	

		private void initializeButtons(GridBagConstraints gbc) {
			
			//make button variables
			btnSurrender = new JButton("Surrender");
			btnNormalAttack = new JButton("Normal Attack");
			btnSpecialAttack = new JButton("Special Attack");
			
			
			////////////////////Set visuals for buttons////////////////////
			
			double displayScaler = 1.4;
			double attackScaler = 1.4;
			
			SetUpButtonCustomSize(btnSurrender, displayScaler);
			
			SetUpButtonCustomSize(btnNormalAttack, attackScaler);
			SetUpButtonCustomSize(btnSpecialAttack, attackScaler);
			
			
		}
		
		private void SetUpLabel(JLabel label) {
			
			
		    label.setPreferredSize(new Dimension(280, 140));
			
		    String myString = new String("A fierce enemy\napproaches...");
		    label.setText("<html>" + myString.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
		    label.setBackground(backgroundColor);
		    label.setBorder(BorderFactory.createBevelBorder(1));
			
			Font textPaneFont= new Font("Yu Gothic Medium", Font.PLAIN, 32);
			label.setFont(textPaneFont);
			
			label.setForeground(Color.white);
		}
		
		

		
	    public void addSurrenderButtonListener(ActionListener listener) {
	        btnSurrender.addActionListener(listener);
	    }
	    
	    /**
	     * Adds an action listener for normalAttackListener
	     * @param listener
	     */
	    public void addbtnNormalAttackListener(ActionListener listener) {
	        btnNormalAttack.addActionListener(listener);
	    }
	    /**
	     * Adds an action listener for specialAttackListener
	     * @param listener
	     */
	    public void addbtnSpecialAttackListener(ActionListener listener) {
	        btnSpecialAttack.addActionListener(listener);
	    }

	    /////////////////////////////////////////////////////////////////
	    // Getters and Setters
	    /////////////////////////////////////////////////////////////////
	    
		public void setRollLabel(int roll) {
			this.LabelRoll.setText(String.valueOf(roll));
		}
		public void setbtnEnemyName(String name) {
			this.labelEnemyName.setText(String.valueOf(name));
		}
		
		public void setbtnEnemyHP(float hp, float max) {
			this.labelEnemyHP.setText(String.valueOf(hp+ "/"+max));
		}
		
		public void setBtnBattleText(String myString) {
			labelBattleText.setText("<html>" + myString.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
		}


		public void setbtnCharacterName(String name) {
			this.labelCharacterName.setText(String.valueOf(name));
		}
		
		public void setbtnCharacterHP(float charHP, float charMaxHP) {
			this.labelCharacterHP.setText(String.valueOf(charHP+ "/"+charMaxHP));
		}


		public JButton getBtnSurrender() {
			return btnSurrender;
		}


		public JButton getBtnNormalAttack() {
			return btnNormalAttack;
		}


		public JButton getBtnSpecialAttack() {
			return btnSpecialAttack;
		}
		
		

}
