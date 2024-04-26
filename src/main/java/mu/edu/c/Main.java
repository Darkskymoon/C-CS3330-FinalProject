package mu.edu.c;

import javax.swing.SwingUtilities;

import com.google.gson.Gson;
import mu.edu.c.audio.AudioPlayer;
import mu.edu.c.entities.Enemy;


import mu.edu.c.menus.MainController;
import mu.edu.c.menus.MainFrame;
import mu.edu.c.menus.MainMenuView;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {		
				new AudioPlayer();
				MainFrame mainFrame = new MainFrame();
				MainMenuView mainMenuView = new MainMenuView();
				MainController mainController = new MainController(mainFrame, mainMenuView);
				mainController.initiate();
			}
			
			
		});


	}

}
