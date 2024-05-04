package mu.edu.c.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GameInfoView extends ParentView {
	
	private static final long serialVersionUID = 175114423651489364L;
	private JButton btnViewPreviousBattles;
	protected JButton btnCredits;
	private JButton btnBack;
	
	public GameInfoView(){
			
			GridBagConstraints gbc = new GridBagConstraints();
	        gbc.gridwidth = GridBagConstraints.REMAINDER;
	        gbc.anchor = GridBagConstraints.NORTH;

	        gbc.insets = new Insets(50, 30, 0, 30);
	        this.add(createTitle("Game Info"), gbc);

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
	        buttons.add(btnViewPreviousBattles, gbc2);
	        buttons.add(btnCredits, gbc2);
	        buttons.add(btnBack, gbc2);
	        
	        
	        gbc.weighty = 1;
	        add(buttons, gbc);
			
			applyEnteredExitedActions(btnBack);
			
			
		}
	

		private void initializeButtons(GridBagConstraints gbc) {
			
			//make button variables
			btnViewPreviousBattles = new JButton("Previous Battles");
			btnBack = new JButton("Back");
			btnCredits = new JButton("Credits");

			////////////////////Set visuals for buttons////////////////////
			Font buttonFont= new Font("Yu Gothic Medium", Font.PLAIN, 16);
			
			SetUpButton(btnViewPreviousBattles);
			SetUpButton(btnCredits);
			SetUpButton(btnBack);
			
		}
		
		public void addCreditButtonListener(ActionListener listener) {
			btnCredits.addActionListener(listener);
		}
		public void addBackButtonListener(ActionListener listener) {
			btnBack.addActionListener(listener);
		}

		public void addPreviousBattlesButtonListener(ActionListener listener) {
			btnViewPreviousBattles.addActionListener(listener);
		}
		
		public JButton getBtnBack() {
			return btnBack;
		}
		
		public JButton getBtnCredits() {
			return btnCredits;
		}
		
		
}

