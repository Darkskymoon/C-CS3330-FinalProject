package mu.edu.c.menus;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class MainController {
	
	private MainFrame mainFrame;
	private Container contentPane;
	private MainMenuView mainMenuView;
	private GameInfoView gameInfoView;
	private StartGameView startGameView;
	private CreateCharacterView createCharacterView;
	// add the new class here
	
	public MainController(MainFrame mainFrame, MainMenuView mainMenuView) {
		this.mainFrame = mainFrame;
		this.contentPane = mainFrame.getContentPane();
		this.mainMenuView = mainMenuView;
		
		refreshMainMenuView();
	}
	
	public void refreshMainMenuView() {
		this.mainMenuView = new MainMenuView();
		mainMenuView.addInfoButtonListener(new SwitchScreenToGameInfoView());
		mainMenuView.addStartGameButtonListener(new SwitchScreenToStartGameView());
	}
	
	public void refreshGameInfoView() {
		this.gameInfoView = new GameInfoView();
		gameInfoView.addBackButtonListener(new SwitchScreenToMainMenuView());
	}
	
	public void refreshStartGameView() {
		this.startGameView = new StartGameView();
		startGameView.addBackButtonListener(new SwitchScreenToMainMenuView());
		startGameView.addLoad1ButtonListener(new SwitchScreenToCreateCaracter());
	}
	
	public void refreshCreateCharacterView() {
		this.createCharacterView = new CreateCharacterView();
		createCharacterView.addBackButtonListener(new SwitchScreenToMainMenuView());
	}
    //	add refresh view and then underneath add button listeners
	
	
	public class SwitchScreenToMainMenuView implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			refreshMainMenuView();
			switchPanel(mainMenuView);
		}
		
	}
	
	public class SwitchScreenToGameInfoView implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			refreshGameInfoView();
			switchPanel(gameInfoView);
		}
		
	}
	
	public class SwitchScreenToStartGameView implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			refreshStartGameView();
			switchPanel(startGameView);
		}
		
	}
	
	public class SwitchScreenToCreateCaracter implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			refreshCreateCharacterView();
			switchPanel(createCharacterView);
		}
	
	}
	
	public void switchPanel(JPanel panel) {
		contentPane.removeAll();
		contentPane.add(panel);
		mainFrame.revalidate();
		mainFrame.repaint();
	}
	
	public void initiate() {
		switchPanel(mainMenuView);
		mainFrame.setVisible(true);
	}

}
