package mu.edu.c;

import javax.swing.SwingUtilities;

import mu.edu.c.menus.StartMenu;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				StartMenu mainMenu = new StartMenu();
				mainMenu.setVisible(true);
			}
		});
		

	}

}
