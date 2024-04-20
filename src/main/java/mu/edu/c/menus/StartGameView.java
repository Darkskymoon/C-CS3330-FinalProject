package mu.edu.c.menus;

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

public class StartGameView extends JPanel{
	
	JButton btnSave1;
	JButton btnSave2;
	JButton btnSave3;
	JButton btnLoad1;
	JButton btnLoad2;
	JButton btnLoad3;
	JButton btnDelete1;
	JButton btnDelete2;
	JButton btnDelete3;
	JButton btnBack;
	Color buttonColor = Color.white;
	Color buttonColorPressed = new Color(226, 221, 250);
	
	public StartGameView(){
			
			setBorder(new EmptyBorder(10, 10, 10, 10));
	        setLayout(new GridBagLayout());
			
			this.setBackground(new Color(45, 44, 65));
			
			GridBagConstraints gbc = new GridBagConstraints();
	        gbc.gridwidth = GridBagConstraints.REMAINDER;
	        gbc.anchor = GridBagConstraints.NORTH;

	        gbc.insets = new Insets(50, 30, 0, 30);
	        this.add(startGameTitle(), gbc);

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
	        buttons.add(btnSave1);
	        buttons.add(btnDelete1, gbc2);
	        buttons.add(btnLoad2);
	        buttons.add(btnSave2);
	        buttons.add(btnDelete2, gbc2);
	        buttons.add(btnLoad3);
	        buttons.add(btnSave3);
	        buttons.add(btnDelete3, gbc2);
	        
	        gbc.weighty = 1;
	        add(buttons, gbc);
	        
	        add(btnBack);
			
			
			
			
			
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
			btnSave1 = new JButton("Save 1");
			btnSave2 = new JButton("Save 2");
			btnSave3 = new JButton("Save 3");
			btnLoad1 = new JButton("Load 1");
			btnLoad2 = new JButton("Load 2");
			btnLoad3 = new JButton("Load 3");
			btnDelete1 = new JButton("Delete 1");
			btnDelete2 = new JButton("Delete 2");
			btnDelete3 = new JButton("Delete 3");
			btnBack = new JButton("Back");
			
			////////////////////Set visuals for buttons////////////////////
			Font buttonFont= new Font("Yu Gothic Medium", Font.PLAIN, 16);
			
			SetUpButton(btnSave1);
			SetUpButton(btnSave2);
			SetUpButton(btnSave3);
			
			SetUpButton(btnLoad1);
			SetUpButton(btnLoad2);
			SetUpButton(btnLoad3);
			
			SetUpButton(btnDelete1);
			SetUpButton(btnDelete2);
			SetUpButton(btnDelete3);
			
			SetUpButton(btnBack);
			
			
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
			btn.setPreferredSize(new Dimension(200, 100));
			btn.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		}
		

		private JLabel startGameTitle() {
			JLabel TitleLabel = new JLabel("Start Game");
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
