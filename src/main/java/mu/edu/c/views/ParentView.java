package mu.edu.c.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ParentView extends JPanel {
	
	Color buttonColor = Color.white;
	Color buttonColorPressed = new Color(226, 221, 250);

	public ParentView() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
        setLayout(new GridBagLayout());
		
		this.setBackground(new Color(45, 44, 65));
	}
	
	protected void SetUpButton(JButton btn) {
		SetUpButtonCustomSize(btn, 1);
	}
	
	protected void SetUpButtonCustomSize(JButton btn, double scaler) {
		Font buttonFont= new Font("Yu Gothic Medium", Font.PLAIN, 16);
		
		//Start Game button
		btn.setFont(buttonFont);
		btn.setBackground(buttonColor);
		btn.setFocusPainted(false);
		btn.setPreferredSize(new Dimension((int)(200 * scaler), (int)(100 * scaler)));
		btn.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		
		applyEnteredExitedActions(btn);
	}
	
	protected void applyEnteredExitedActions(JButton button) {
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
