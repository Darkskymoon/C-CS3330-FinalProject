package mu.edu.c.menus;

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

public class BattleMenuView extends JPanel {
	
	private JButton btnCharacterName;
	private JButton btnBattleText;
	private JButton btnEnemyName;
	private JButton btnCharacterHP;
	private JButton btnEnemyHP;
	private JButton btnRoll;
	private JButton btnNormalAttack;
	private JButton btnSpecialAttack;
	
	private JLabel LabelRoll;
	
	Color buttonColor = Color.white;
	Color buttonColorPressed = new Color(226, 221, 250);
	
	
	public BattleMenuView(String CharacterName, float characterCurrentHP,float characterMaxHP){
			
			
			setBorder(new EmptyBorder(10, 10, 10, 10));
	        setLayout(new GridBagLayout());
			
			this.setBackground(new Color(45, 44, 65));
			
			GridBagConstraints gbc = new GridBagConstraints();
	        gbc.gridwidth = GridBagConstraints.REMAINDER;
	        gbc.anchor = GridBagConstraints.NORTH;

	        gbc.insets = new Insets(50, 30, 0, 30);

	        gbc.anchor = GridBagConstraints.CENTER;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        
	        //initialize Buttons (start and credits)
			initializeButtons(gbc, CharacterName, characterCurrentHP, characterMaxHP);
			
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
	        buttons.add(btnRoll, gbc4);
	        buttons.add(btnEnemyHP, gbc2);
	        
	        add(buttons, gbc);
	        
	        JPanel LabelContainer = new JPanel(new GridBagLayout());
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

		private void initializeButtons(GridBagConstraints gbc, String charName, float charHP, float charMaxHP) {
			
			//make button variables
			btnCharacterName = new JButton(charName);
			btnBattleText = new JButton("END OF DAYS");
			btnEnemyName = new JButton("Enemy");
			btnCharacterHP = new JButton(charHP+ "/"+charMaxHP);
			btnEnemyHP = new JButton("HP: 97");
			btnRoll = new JButton("Roll");
			btnNormalAttack = new JButton("Normal Attack");
			btnSpecialAttack = new JButton("Special Attack");
			
			
			////////////////////Set visuals for buttons////////////////////
			Font buttonFont= new Font("Yu Gothic Medium", Font.PLAIN, 16);
			
			SetUpButton(btnCharacterName);
			SetUpButton(btnBattleText);
			SetUpButton(btnEnemyName);
			
			SetUpButton(btnCharacterHP);
			SetUpButton(btnEnemyHP);
			SetUpButton(btnRoll);
			
			SetUpButton(btnNormalAttack);
			SetUpButton(btnSpecialAttack);
			
			
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
		
		private void SetUpButton(JButton btn) {
			Font buttonFont= new Font("Yu Gothic Medium", Font.PLAIN, 16);
			applyEnteredExitedActions(btn);
			
			//Start Game button
			btn.setFont(buttonFont);
			btn.setBackground(buttonColor);
			btn.setFocusPainted(false);
			btn.setPreferredSize(new Dimension(300, 150));
			btn.setBorder(BorderFactory.createLoweredSoftBevelBorder());
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
		
		public void setRollLabel(int roll) {
			this.LabelRoll.setText(String.valueOf(roll));
		}
		
		
		//TODO remove roll button
	    public void addRollButtonListener(ActionListener listener) {
	        btnRoll.addActionListener(listener);
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


}
