package mu.edu.c.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class CreditMenuView extends ParentView {
	
	private static final long serialVersionUID = 8243554326763832136L;
	private JButton btnBack;
	private JTextPane textPane;
	
	public CreditMenuView(){
			
			
			this.setBackground(backgroundColor);
			
			GridBagConstraints gbc = new GridBagConstraints();
	        gbc.gridwidth = GridBagConstraints.REMAINDER;
	        gbc.anchor = GridBagConstraints.NORTH;

	        gbc.insets = new Insets(50, 30, 0, 30);
	        this.add(createTitle("Credits"), gbc);

	        gbc.anchor = GridBagConstraints.CENTER;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        
	        //initialize Buttons (start and credits)
			initializeButtons(gbc);
			
			add(textPane, gbc);
	        add(btnBack, gbc);
				
		}
	

		private void initializeButtons(GridBagConstraints gbc) {
			
			btnBack = new JButton("Back");
			textPane = new JTextPane();
			
			////////////////////Set visuals for buttons////////////////////
			
			SetUpButton(btnBack);
			SetUpTextPane(textPane);
			
		}
		
		private void SetUpTextPane(JTextPane textPane) {
			StyledDocument doc = textPane.getStyledDocument();
			SimpleAttributeSet center = new SimpleAttributeSet();
			StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
			doc.setParagraphAttributes(0, doc.getLength(), center, false);
			
			textPane.setText("John Lin\nAndo Pepe\nZoe Strassner\nRyan Wahle");
			textPane.setBackground(backgroundColor);
			textPane.setBorder(BorderFactory.createEmptyBorder());
			
			Font textPaneFont= new Font("Yu Gothic Medium", Font.PLAIN, 26);
			textPane.setFont(textPaneFont);
			
			textPane.setForeground(Color.white);
		}
		
		
		public void addBackButtonListener(ActionListener listener) {
			btnBack.addActionListener(listener);
		}


		public JButton getBtnBack() {
			return btnBack;
		}
		
		
}
