package mu.edu.c;

import javax.swing.SwingUtilities;
import mu.edu.c.menus.MainController;
import mu.edu.c.menus.MainFrame;
import mu.edu.c.menus.MainMenuView;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				
				MainFrame mainFrame = new MainFrame();
				MainMenuView mainMenuView = new MainMenuView();
				MainController mainController = new MainController(mainFrame, mainMenuView);
				mainController.initiate();
			}
		});
		

	}

}
