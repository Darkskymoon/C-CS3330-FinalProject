package mu.edu.c;

import javax.swing.SwingUtilities;

import menus.StartMenu;

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
