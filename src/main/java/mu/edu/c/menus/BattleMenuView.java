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

public class BattleMenuView extends JPanel {
	
	JButton btnCharacterName;
	JButton btnBattleText;
	JButton btnEnemyName;
	JButton btnCharacterHP;
	JButton btnEnemyHP;
	JButton btnRoll;
	JButton btnNormalAttack;
	JButton btnSpecialAttack;
	
	Color buttonColor = Color.white;
	Color buttonColorPressed = new Color(226, 221, 250);
	
	public BattleMenuView(){
			
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
			initializeButtons(gbc);
			
			JPanel buttons = new JPanel(new GridBagLayout());
			buttons.setBackground(new Color(45, 44, 65));
			
			GridBagConstraints gbc2 = new GridBagConstraints();
			gbc2.gridwidth = GridBagConstraints.REMAINDER;
			gbc2.insets = new Insets(10, 10, 10, 10);
			gbc2.anchor = GridBagConstraints.CENTER;
		    gbc2.fill = GridBagConstraints.BOTH;
		    
		    GridBagConstraints gbc4 = new GridBagConstraints();
		    gbc4.insets = new Insets(10, 10, 10, 10);
		    
		    buttons.add(btnCharacterName, gbc4);
	        buttons.add(btnBattleText, gbc4);
	        buttons.add(btnEnemyName, gbc2);
	        buttons.add(btnCharacterHP, gbc4);
	        buttons.add(btnRoll, gbc4);
	        buttons.add(btnEnemyHP, gbc2);
	        
	        gbc.weighty = 1;
	        add(buttons, gbc);
	        
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

		private void initializeButtons(GridBagConstraints gbc) {
			
			//make button variables
			btnCharacterName = new JButton("Character");
			btnBattleText = new JButton("END OF DAYS");
			btnEnemyName = new JButton("Enemy");
			btnCharacterHP = new JButton("HP: 100");
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
			btn.setPreferredSize(new Dimension(200, 150));
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

}
