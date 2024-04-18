package mu.edu.c.menus;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame extends JFrame{
	
	private JPanel contentPane;
	JButton btnStartGame;
	JButton btnCredits;
	JButton btnInfo;
	Color buttonColor = Color.white;
	Color buttonColorPressed = new Color(226, 221, 250);
	
	public MainFrame() {
		//sets the title of the startMenu window
		setTitle("Battle Simulator");
		
		//sets the default close operation
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setBounds(0, 0, 1000, 1000);
		this.setMinimumSize(new Dimension(1000, 1000));
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		this.add(new MainMenuView());
	}
	
	
}
