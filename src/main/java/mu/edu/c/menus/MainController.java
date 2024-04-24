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

/**
 * Main Controller of the MVC architecture, managing interface between models and views
 */
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
	
	private Battle battleModel;
	
	/**
	 * Constructer which requires MainFrame and MainMenuView objects. 
	 * @param mainFrame
	 * @param mainMenuView
	 */
	public MainController(MainFrame mainFrame, MainMenuView mainMenuView) {
		this.mainFrame = mainFrame;
		this.contentPane = mainFrame.getContentPane();
		this.mainMenuView = mainMenuView;
		
		refreshMainMenuView();
	}
	
	/**
	 * Refreshes MainMenuView by recreating object and adding button listeners to view
	 */
	public void refreshMainMenuView() {
		this.mainMenuView = new MainMenuView();
		mainMenuView.addInfoButtonListener(new SwitchScreenToGameInfoView());
		mainMenuView.addStartGameButtonListener(new SwitchScreenToStartGameView());
		mainMenuView.addCreditButtonListener(new SwitchScreenToCreditMenuView());
	}
	
	/**
	 * Refreshes GameInfoView by recreating object and adding button listeners to view
	 */
	public void refreshGameInfoView() {
		this.gameInfoView = new GameInfoView();
		gameInfoView.addBackButtonListener(new SwitchScreenToMainMenuView());
	}
	
	/**
	 * Refreshes StartGameView by recreating object and adding button listeners to view
	 */
	public void refreshStartGameView() {
		this.startGameView = new StartGameView();
		startGameView.addBackButtonListener(new SwitchScreenToMainMenuView());
		startGameView.addLoad1ButtonListener(new SwitchScreenToCreateCaracter());
		startGameView.addLoad2Listener(new SwitchScreenToBattleMenuView());
	}
	
	/**
	 * Refreshes CreditMenuView by recreating object and adding button listeners to view
	 */
	public void refreshCreditMenuView() {
		this.creditMenuView = new CreditMenuView();
		creditMenuView.addBackButtonListener(new SwitchScreenToMainMenuView());
	}
	
	/**
	 * Refreshes BattleMenuView by recreating object and adding button listeners to view
	 */
	public void refreshBattleMenuView(Player player) {
		this.battleModel = new Battle(player);
		this.battleMenuView = new BattleMenuView(player.getName(), player.getHp(), player.getMaxHP());
		battleMenuView.addRollButtonListener(new BattleMenuRollButtonListener());
		battleMenuView.addbtnNormalAttackListener(new BattleMenuNormalAttackButtonListener());
		battleMenuView.addbtnSpecialAttackListener(new BattleMenuSpecialAttackButtonListener());
	}
	
	/**
	 * Refreshes CreateCharacterView by recreating object and adding button listeners to view
	 */
	public void refreshCreateCharacterView() {
		this.createCharacterView = new CreateCharacterView();
		createCharacterView.addBackButtonListener(new SwitchScreenToMainMenuView());
		createCharacterView.addSubmitButtonListener(new CreateCharacterSubmit());
	}
    //	add refresh view and then underneath add button listeners
	
	/**
	 * Refreshes MainMenuView and switches current panel to it
	 */
	public class SwitchScreenToMainMenuView implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			refreshMainMenuView();
			switchPanel(mainMenuView);
		}
		
	}
	
	/**
	 * Refreshes GameInfoView and switches current panel to it
	 */
	public class SwitchScreenToGameInfoView implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			refreshGameInfoView();
			switchPanel(gameInfoView);
		}
		
	}
	
	/**
	 * Refreshes StartGameView and switches current panel to it
	 */
	public class SwitchScreenToStartGameView implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			refreshStartGameView();
			switchPanel(startGameView);
		}
		
	}
	
	/**
	 * Refreshes CreditMenuView and switches current panel to it
	 */
	public class SwitchScreenToCreditMenuView implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			refreshCreditMenuView();
			switchPanel(creditMenuView);
		}
		
	}
	
	/**
	 * Refreshes BattleMenuView and switches current panel to it
	 */
	public class SwitchScreenToBattleMenuView implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			refreshBattleMenuView(null);
			switchPanel(battleMenuView);
		}
		
	}
	
	/**
	 * Refreshes CreateCharacterView and switches current panel to it
	 */
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
		}
		
	}
	
	public class BattleMenuRollButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			//Roll for current battle
			int roll = battleModel.roll();
			battleMenuView.setRollLabel(roll);
			
		}
	}
	
	/**
	 * the action listener for the Normal attack button listener
	 */
	public class BattleMenuNormalAttackButtonListener implements ActionListener{
		/**
		 * Rolls a number then sets the roll Label equal to that result
		 */
		public void actionPerformed(ActionEvent e) {
			//Roll for current battle
			int roll = battleModel.roll();
			battleMenuView.setRollLabel(roll);
			
		}
	}
	
	/**
	 * the action listener for the special attack button listener
	 */
	public class BattleMenuSpecialAttackButtonListener implements ActionListener{
		/**
		 * Rolls a number then sets the roll Label equal to that result
		 */
		public void actionPerformed(ActionEvent e) {
			//Roll for current battle
			int roll = battleModel.roll();
			battleMenuView.setRollLabel(roll);
			
		}
	}
	/**
	 * Takes a JPanel object and switches the Main JFrame to the panel.
	 * @param panel
	 */
	public void switchPanel(JPanel panel) {
		contentPane.removeAll();
		contentPane.add(panel);
		mainFrame.revalidate();
		mainFrame.repaint();
	}
	
	/**
	 * Initiates the controller by switching the panel to the mainMenuView and setting the mainFrame visible
	 */
	public void initiate() {
		switchPanel(mainMenuView);
		mainFrame.setVisible(true);
	}
	



}
