package mu.edu.c;

import javax.swing.SwingUtilities;

import com.google.gson.Gson;
import mu.edu.c.audio.AudioPlayer;
import mu.edu.c.controller.MainController;
import mu.edu.c.entities.Enemy;
import mu.edu.c.views.MainFrame;
import mu.edu.c.views.MainMenuView;

public class Main {

	public static void main(String[] args) {
		MainController mainController = new MainController();
		mainController.initiate();
	}

}
