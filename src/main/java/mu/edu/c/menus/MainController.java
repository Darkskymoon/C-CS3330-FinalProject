package mu.edu.c.menus;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import mu.edu.c.battles.Battle;
import mu.edu.c.entities.Player;
import mu.edu.c.logger.characterLoggerSingleton;

public class MainController {
	
	private MainFrame mainFrame;
	private Container contentPane;
	private MainMenuView mainMenuView;
	private GameInfoView gameInfoView;
	private StartGameView startGameView;
	private CreditMenuView creditMenuView;
	private BattleMenuView battleMenuView;
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
		mainMenuView.addCreditButtonListener(new SwitchScreenToCreditMenuView());
	}
	
	public void refreshGameInfoView() {
		this.gameInfoView = new GameInfoView();
		gameInfoView.addBackButtonListener(new SwitchScreenToMainMenuView());
	}
	
	public void refreshStartGameView() {
		this.startGameView = new StartGameView();
		startGameView.addBackButtonListener(new SwitchScreenToMainMenuView());
		startGameView.addLoad1ButtonListener(new SwitchScreenToCreateCaracter());
		startGameView.addLoad2Listener(new SwitchScreenToBattleMenuView());
	}
	
	public void refreshCreditMenuView() {
		this.creditMenuView = new CreditMenuView();
		creditMenuView.addBackButtonListener(new SwitchScreenToMainMenuView());
	}
	
	public void refreshBattleMenuView(Player player) {
		Battle battle = new Battle(player);
		this.battleMenuView = new BattleMenuView(battle);
	}
	
	public void refreshCreateCharacterView() {
		this.createCharacterView = new CreateCharacterView();
		createCharacterView.addBackButtonListener(new SwitchScreenToMainMenuView());
		createCharacterView.addSubmitButtonListener(new CreateCharacterSubmit());
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
	
	public class SwitchScreenToCreditMenuView implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			refreshCreditMenuView();
			switchPanel(creditMenuView);
		}
		
	}
	
	public class SwitchScreenToBattleMenuView implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			refreshBattleMenuView(null);
			switchPanel(battleMenuView);
		}
		
	}
	
	public class SwitchScreenToCreateCaracter implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			refreshCreateCharacterView();
			switchPanel(createCharacterView);
		}
	
	}
	
	/**
	 * Writes a character to the character file.
	 */
	public class CreateCharacterSubmit implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			//Gets the character name
			String name = createCharacterView.nameField.getText();
			
			//creates the character/player object
			//TODO: temporarily sets the other stats to placeholder values
			Player characterObj = new Player(1, 2, 3, 4, name);
			//gets the logger instance and writes the characterObj to the file.
			characterLoggerSingleton logger =characterLoggerSingleton.getInstance();
			logger.logCharacterData(characterObj);
			
			//Switch to battle screen and use character just created
			refreshBattleMenuView(characterObj);
			switchPanel(battleMenuView);
			
			
			
//			
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
