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
	
	// Button Colors
	Color buttonColor = Color.white;
	Color buttonColorPressed = new Color(226, 221, 250);

	/**
	 * Sets up Parent View with border, layout, and custom background color
	 */
	public ParentView() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
        setLayout(new GridBagLayout());
		
		this.setBackground(new Color(45, 44, 65));
	}
	
	/**
	 * Wrapper that sets ups button with scaler of size 1
	 * @param btn
	 */
	protected void SetUpButton(JButton btn) {
		SetUpButtonCustomSize(btn, 1);
	}
	
	/**
	 * Sets up default button and scales it to different size using scaler argument.
	 * @param btn
	 * @param scaler
	 */
	protected void SetUpButtonCustomSize(JButton btn, double scaler) {
		Font buttonFont= new Font("Yu Gothic Medium", Font.PLAIN, (int)(16 * scaler));
		
		//Start Game button
		btn.setFont(buttonFont);
		btn.setBackground(buttonColor);
		btn.setFocusPainted(false);
		btn.setPreferredSize(new Dimension((int)(200 * scaler), (int)(100 * scaler)));
		btn.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		
		applyEnteredExitedActions(btn);
	}
	
	/**
	 * Applies entered and exited actions to button 
	 * @param button
	 */
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
	
	/**
	 * Applies styling to button when cursor enters it
	 * @param button
	 */
	private void buttonEntered(JButton button) {
		button.setBackground(buttonColorPressed);
		
		Font buttonFont = new Font("Yu Gothic Medium", Font.BOLD, button.getFont().getSize());
		button.setFont(buttonFont);
	}
	
	/**
	 * Applies styling to button when cursor exits it
	 * @param button
	 */
	private void buttonExited(JButton button) {
		button.setBackground(buttonColor);
		Font buttonFont= new Font("Yu Gothic Medium", Font.PLAIN, button.getFont().getSize());
		button.setFont(buttonFont);
	}
}
