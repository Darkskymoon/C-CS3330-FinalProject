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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class CreditMenuView extends JPanel{
	
	JButton btnBack;
	JTextPane textPane;
	Color buttonColor = Color.white;
	Color buttonColorPressed = new Color(226, 221, 250);
	
	public CreditMenuView(){
			
			setBorder(new EmptyBorder(10, 10, 10, 10));
	        setLayout(new GridBagLayout());
			
			this.setBackground(new Color(45, 44, 65));
			
			GridBagConstraints gbc = new GridBagConstraints();
	        gbc.gridwidth = GridBagConstraints.REMAINDER;
	        gbc.anchor = GridBagConstraints.NORTH;

	        gbc.insets = new Insets(50, 30, 0, 30);
	        this.add(CreditTitle(), gbc);

	        gbc.anchor = GridBagConstraints.CENTER;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        
	        //initialize Buttons (start and credits)
			initializeButtons(gbc);
			
			add(textPane, gbc);
	        add(btnBack, gbc);
			
			
	        applyEnteredExitedActions(btnBack);
	        
				
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
			
			btnBack = new JButton("Back");
			textPane = new JTextPane();
			
			////////////////////Set visuals for buttons////////////////////
			Font buttonFont= new Font("Yu Gothic Medium", Font.PLAIN, 16);
			
			SetUpButton(btnBack);
			SetUpTextPane(textPane);
			
		}
		
		private void SetUpTextPane(JTextPane textPane) {
			StyledDocument doc = textPane.getStyledDocument();
			SimpleAttributeSet center = new SimpleAttributeSet();
			StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
			doc.setParagraphAttributes(0, doc.getLength(), center, false);
			
			
			textPane.setText("John Lin\nAndo Pepe\nZoe Strassner\nRyan Wahle");
			textPane.setBackground(new Color(45, 44, 65));
			textPane.setBorder(BorderFactory.createEmptyBorder());
			
			Font textPaneFont= new Font("Yu Gothic Medium", Font.PLAIN, 26);
			textPane.setFont(textPaneFont);
			
			textPane.setForeground(Color.white);
		}
		
		private void SetUpButton(JButton btn) {
			Font buttonFont= new Font("Yu Gothic Medium", Font.PLAIN, 16);
			
			//Start Game button
			btn.setFont(buttonFont);
			btn.setBackground(buttonColor);
			btn.setFocusPainted(false);
			btn.setPreferredSize(new Dimension(200, 100));
			btn.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		}
		

		private JLabel CreditTitle() {
			JLabel TitleLabel = new JLabel("Credit");
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
