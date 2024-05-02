package mu.edu.c.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mu.edu.c.battles.Battle;
import mu.edu.c.entities.Player;

public class BattleMenuView extends ParentView {
	
	private JButton btnCharacterName;
	private JButton btnBattleText;
	private JButton btnEnemyName;
	private JButton btnCharacterHP;
	private JButton btnEnemyHP;
	private JButton btnSurrender;
	private JButton btnNormalAttack;
	private JButton btnSpecialAttack;
	
	private JLabel LabelRoll;
	
	
	public BattleMenuView(){
			
			
			GridBagConstraints gbc = new GridBagConstraints();
	        gbc.gridwidth = GridBagConstraints.REMAINDER;
	        gbc.anchor = GridBagConstraints.NORTH;

	        gbc.insets = new Insets(50, 30, 0, 30);

	        gbc.anchor = GridBagConstraints.CENTER;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        
	        //initialize Buttons (start and credits)
			initializeButtons(gbc);
			
			JPanel buttons = new JPanel(new GridBagLayout());
			buttons.setBackground(new Color(45, 44, 65));
			
			GridBagConstraints gbc2 = new GridBagConstraints();
			gbc2.gridwidth = GridBagConstraints.REMAINDER;
			gbc2.insets = new Insets(10, 10, 10, 10);
			gbc2.anchor = GridBagConstraints.CENTER;
		    gbc2.fill = GridBagConstraints.HORIZONTAL;
		    
		    GridBagConstraints gbc4 = new GridBagConstraints();
		    gbc4.insets = new Insets(10, 10, 10, 10);
		    
		    buttons.add(btnCharacterName, gbc4);
	        buttons.add(btnBattleText, gbc4);
	        buttons.add(btnEnemyName, gbc2);
	        buttons.add(btnCharacterHP, gbc4);
	        buttons.add(btnSurrender, gbc4);
	        buttons.add(btnEnemyHP, gbc2);
	        
	        add(buttons, gbc);
	        
	        JPanel LabelContainer = new JPanel(new GridBagLayout());
	        LabelContainer.setVisible(false);
	        LabelRoll=new JLabel("roll to hit");
	        LabelRoll.setForeground(Color.black);
	        LabelContainer.add(LabelRoll, gbc2);
	        add(LabelContainer, gbc);
	        
	        JPanel buttons2 = new JPanel(new GridBagLayout());
			buttons2.setBackground(new Color(45, 44, 65));
			
			buttons2.add(btnNormalAttack, gbc4);
			buttons2.add(btnSpecialAttack, gbc4);
			add(buttons2, gbc);
			
			
		}
	

		private void initializeButtons(GridBagConstraints gbc) {
			
			//make button variables
			btnCharacterName = new JButton("charName");
			btnBattleText = new JButton("END OF DAYS");
			btnEnemyName = new JButton("Enemy");
			btnCharacterHP = new JButton("TEMPHP");
			btnEnemyHP = new JButton("HP: 97");
			btnSurrender = new JButton("Surrender");
			btnNormalAttack = new JButton("Normal Attack");
			btnSpecialAttack = new JButton("Special Attack");
			
			
			////////////////////Set visuals for buttons////////////////////
			Font buttonFont= new Font("Yu Gothic Medium", Font.PLAIN, 16);
			
			double displayScaler = 1.4;
			double attackScaler = 1.6;
			
			SetUpButtonCustomSize(btnCharacterName, displayScaler);
			SetUpButtonCustomSize(btnBattleText, displayScaler);
			SetUpButtonCustomSize(btnEnemyName, displayScaler);
			
			SetUpButtonCustomSize(btnCharacterHP, displayScaler);
			SetUpButtonCustomSize(btnEnemyHP, displayScaler);
			SetUpButtonCustomSize(btnSurrender, displayScaler);
			
			SetUpButtonCustomSize(btnNormalAttack, attackScaler);
			SetUpButtonCustomSize(btnSpecialAttack, attackScaler);
			
			
		}
		
		

		
		//TODO remove roll button
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
			this.btnEnemyName.setText(String.valueOf(name));
		}
		
		public void setbtnEnemyHP(float hp, float max) {
			this.btnEnemyHP.setText(String.valueOf(hp+ "/"+max));
		}
		
		public void setbtnCharacterName(String name) {
			this.btnCharacterName.setText(String.valueOf(name));
		}
		
		public void setbtnCharacterHP(float charHP, float charMaxHP) {
			this.btnCharacterHP.setText(String.valueOf(charHP+ "/"+charMaxHP));
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
