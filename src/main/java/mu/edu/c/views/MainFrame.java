package mu.edu.c.views;

import javax.swing.JFrame;
import java.awt.Dimension;



public class MainFrame extends JFrame {
	

	private static final long serialVersionUID = -7399613379589107925L;
	public MainFrame() {
		//sets the title of the startMenu window
		setTitle("Battle Simulator");
		
		//sets the default close operation
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setBounds(0, 0, 1000, 1000);
		this.setMinimumSize(new Dimension(1200, 1000));
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
	
	
}
