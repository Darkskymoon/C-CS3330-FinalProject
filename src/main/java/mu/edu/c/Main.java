package mu.edu.c;

import javax.swing.SwingUtilities;

import mu.edu.c.menus.MainFrame;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainFrame mainMenu = new MainFrame();
				mainMenu.setVisible(true);
			}
		});
		

	}

}
