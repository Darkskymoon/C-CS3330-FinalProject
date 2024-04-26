package mu.edu.c.menus;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import mu.edu.c.battles.Battle;
import mu.edu.c.entities.Player;
import mu.edu.c.logger.BattleLoggerSingleton;
import mu.edu.c.logger.EnemyLoggerSingleton;
import mu.edu.c.logger.characterLoggerSingleton;

/**
 * Main Controller of the MVC architecture, managing interface between models and views
 */
public class MainController {
	
	//Views
	private MainFrame mainFrame;
	private Container contentPane;
	private MainMenuView mainMenuView;
	private GameInfoView gameInfoView;
	private StartGameView startGameView;
	private CreditMenuView creditMenuView;
	private BattleMenuView battleMenuView;
	private CreateCharacterView createCharacterView;
	// add the new class here
	
	//Models
	private Battle battleModel;
	//TODO- Is this right?
	private Player currentPlayer;
	
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
		
		//reads in the current save (if it exists) TODO: try catch
		characterLoggerSingleton logger = characterLoggerSingleton.getInstance();
		this.currentPlayer =logger.readCharacterData();
		
		
		//If the first player doesn't exist, just set it to create a character
		if(this.currentPlayer == null) {
			startGameView.setLoad1Text("Create a New Character");
			startGameView.addLoad1ButtonListener(new SwitchScreenToCreateCaracter());
			startGameView.setNewCharHide();
			
		}else { //Otherwise, if the first player does exist, set the load button to route to battle with that character
			//sets the button to the character's name
			startGameView.setLoad1Text(this.currentPlayer.getName());
			startGameView.addLoad1ButtonListener(new SwitchScreenToBattleMenuView());
			startGameView.addBtnNewCharListener(new SwitchScreenToCreateCaracter());
			
		}
		startGameView.addBackButtonListener(new SwitchScreenToMainMenuView());
		
//		startGameView.addLoad2Listener(new SwitchScreenToBattleMenuView());
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
	public void refreshBattleMenuView() {
		this.battleModel = new Battle(this.currentPlayer);
		this.battleMenuView = new BattleMenuView();
		
		
		//initialize enemies
		this.battleModel.initializeEnemies();
		
		//save the battle at the beginning
		BattleLoggerSingleton battleLogger = BattleLoggerSingleton.getInstance();
		battleLogger.logBattleData(this.battleModel);
		
		//set the buttons
		this.battleMenuView.setbtnCharacterHP(this.battleModel.getPlayerHP(), this.battleModel.getPlayerMaxHP());
		this.battleMenuView.setbtnCharacterName(this.battleModel.getPlayerName());
		this.battleMenuView.setbtnEnemyName(this.battleModel.getCurrentEnemyName());
		this.battleMenuView.setbtnEnemyHP(this.battleModel.getCurrentEnemyCurrentHP(), this.battleModel.getCurrentEnemyMaxHP());
		
		
		//add listeners
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
			refreshBattleMenuView();
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
	 * Writes a character to the character file. TODO: 
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
			
			refreshStartGameView();
			switchPanel(startGameView);
//			refreshBattleMenuView(characterObj);
//			switchPanel(battleMenuView);	
		}
		
	}
	
	////////////////////////////////////////////////////////////////////
	//                  BATTLE MENU LISTENERS                         //
	////////////////////////////////////////////////////////////////////
	
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
	/////////////////////////////////////////////////////////////////////
	//////////////// END OF BATTLE MENU LISTENERS ///////////////////////
	////////////////////////////////////////////////////////////////////
	
	////////////////////////////////////////////////////////////////////
	////////////////// START MENU LISTENERS ///////////////////////////
	///////////////////////////////////////////////////////////////////
	
	
	/////////////////////////////////////////////////////////////////////
	//////////////// END OF START MENU LISTENERS  ///////////////////////
	////////////////////////////////////////////////////////////////////
	
	
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
