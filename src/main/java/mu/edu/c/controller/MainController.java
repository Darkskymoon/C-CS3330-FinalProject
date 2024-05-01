package mu.edu.c.controller;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import mu.edu.c.audio.AudioPlayer;
import mu.edu.c.battles.Battle;
import mu.edu.c.entities.Enemy;
import mu.edu.c.entities.Player;
import mu.edu.c.logger.BattleLoggerSingleton;
import mu.edu.c.logger.EnemyLoggerSingleton;
import mu.edu.c.views.BattleMenuView;
import mu.edu.c.views.CreateCharacterView;
import mu.edu.c.views.CreditMenuView;
import mu.edu.c.views.GameInfoView;
import mu.edu.c.views.LoseScreenView;
import mu.edu.c.views.MainFrame;
import mu.edu.c.views.MainMenuView;
import mu.edu.c.views.StartGameView;
import mu.edu.c.views.WinScreenView;
import mu.edu.c.logger.CharacterLoggerSingleton;

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
	private WinScreenView winScreenView;
	private LoseScreenView loseScreenView;
	// add the new class here
	
	//Models
	private Battle battleModel;
	//TODO- Is this right?
	private Player currentPlayer;
	private Enemy currentEnemy;
	
	//TODO
	//implement event triggers that cause the screen to switch to win/lose screen
	
	/**
	 * Constructer which requires MainFrame and MainMenuView objects. 
	 * @param mainFrame
	 * @param mainMenuView
	 */
	public MainController() {
		new AudioPlayer();
		mainFrame = new MainFrame();
		mainMenuView = new MainMenuView();
		this.contentPane = mainFrame.getContentPane();
		
		refreshMainMenuView();
	}
	
	/**
	 * Refreshes MainMenuView by recreating object and adding button listeners to view
	 */
	private void refreshMainMenuView() {
		this.mainMenuView = new MainMenuView();
		mainMenuView.addInfoButtonListener(new SwitchScreenToGameInfoView());
		mainMenuView.addStartGameButtonListener(new SwitchScreenToStartGameView());
		mainMenuView.addCreditButtonListener(new SwitchScreenToCreditMenuView());
	}
	
	/**
	 * Refreshes GameInfoView by recreating object and adding button listeners to view
	 */
	private void refreshGameInfoView() {
		this.gameInfoView = new GameInfoView();
		gameInfoView.addBackButtonListener(new SwitchScreenToMainMenuView());
	}
	
	/**
	 * Refreshes StartGameView by recreating object and adding button listeners to view
	 */
	private void refreshStartGameView() {
		this.startGameView = new StartGameView();
		
		//reads in the current save (if it exists) TODO: try catch
		CharacterLoggerSingleton logger = CharacterLoggerSingleton.getInstance();
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
	private void refreshCreditMenuView() {
		this.creditMenuView = new CreditMenuView();
		creditMenuView.addBackButtonListener(new SwitchScreenToMainMenuView());
	}
	
	/**
	 * Refreshes BattleMenuView by recreating object and adding button listeners to view
	 */
	private void refreshBattleMenuView() {
		this.battleModel = new Battle(this.currentPlayer);
		this.battleMenuView = new BattleMenuView();
		
		//initialize enemies
		this.battleModel.initializeEnemies();
		this.currentEnemy = this.battleModel.getCurrentEnemy();

		//save the battle at the beginning
		BattleLoggerSingleton battleLogger = BattleLoggerSingleton.getInstance();
		battleLogger.logBattleData(this.battleModel);
		
		//set the buttons
		this.battleMenuView.setbtnCharacterName(this.battleModel.getPlayerName());
		this.battleMenuView.setbtnEnemyName(this.battleModel.getCurrentEnemyName());
		this.battleMenuView.setbtnCharacterHP(this.battleModel.getPlayerHP(), this.battleModel.getPlayerMaxHP());
		this.battleMenuView.setbtnEnemyHP(this.battleModel.getCurrentEnemyCurrentHP(), this.battleModel.getCurrentEnemyMaxHP());
		
		
		//add listeners
		battleMenuView.addSurrenderButtonListener(new BattleMenuSurrenderButtonListener());
		battleMenuView.addbtnNormalAttackListener(new BattleMenuNormalAttackButtonListener());
		battleMenuView.addbtnSpecialAttackListener(new BattleMenuSpecialAttackButtonListener());
	}
	
	/**
	 * Refreshes CreateCharacterView by recreating object and adding button listeners to view
	 */
	private void refreshCreateCharacterView() {
		this.createCharacterView = new CreateCharacterView();
		createCharacterView.addBackButtonListener(new SwitchScreenToMainMenuView());
		createCharacterView.addSubmitButtonListener(new CreateCharacterSubmit());
	}
    //	add refresh view and then underneath add button listeners
	
	/**
	 * Refreshes WinScreenView by recreating object and adding button listeners to view
	 */
	private void refreshWinScreenView() {
		this.winScreenView = new WinScreenView();
		winScreenView.addRestartButtonListener(new SwitchScreenToCreateCaracter());
		winScreenView.addRetireButtonListener(new SwitchScreenToMainMenuView());
	}
	
	/**
	 * Refreshes LoseScreenView by recreating object and adding button listeners to view
	 */
	private void refreshLoseScreenView() {
		this.loseScreenView = new LoseScreenView();
		loseScreenView.addRestartButtonListener(new SwitchScreenToCreateCaracter());
		loseScreenView.addGiveUpButtonListener(new CreateCharacterSubmit());
	}
	/**
	 * Refreshes MainMenuView and switches current panel to it
	 */
	private class SwitchScreenToMainMenuView implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			refreshMainMenuView();
			switchPanel(mainMenuView);
		}
		
	}
	
	/**
	 * Refreshes GameInfoView and switches current panel to it
	 */
	private class SwitchScreenToGameInfoView implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			refreshGameInfoView();
			switchPanel(gameInfoView);
		}
		
	}
	
	/**
	 * Refreshes StartGameView and switches current panel to it
	 */
	private class SwitchScreenToStartGameView implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			refreshStartGameView();
			switchPanel(startGameView);
		}
		
	}
	
	/**
	 * Refreshes CreditMenuView and switches current panel to it
	 */
	private class SwitchScreenToCreditMenuView implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			refreshCreditMenuView();
			switchPanel(creditMenuView);
		}
		
	}
	
	/**
	 * Refreshes BattleMenuView and switches current panel to it
	 */
	private class SwitchScreenToBattleMenuView implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			refreshBattleMenuView();
			switchPanel(battleMenuView);
		}
		
	}
	
	/**
	 * Refreshes CreateCharacterView and switches current panel to it
	 */
	private class SwitchScreenToCreateCaracter implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			refreshCreateCharacterView();
			switchPanel(createCharacterView);
		}
	
	}
	
	/**
	 * Refreshes MainMenuView and switches current panel to it
	 */
	private class SwitchScreenToLoseScreenView implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			refreshMainMenuView();
			switchPanel(loseScreenView);
		}
		
	}
	
	/**
	 * Refreshes MainMenuView and switches current panel to it
	 */
	private class SwitchScreenToWinScreenView implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			refreshMainMenuView();
			switchPanel(winScreenView);
		}
		
	}
	
	/**
	 * Writes a character to the character file. TODO: 
	 */
	private class CreateCharacterSubmit implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			//Gets the character name TODO create getter for this
			String name = createCharacterView.getNameField().getText();
			
			//creates the character/player object
			//TODO: temporarily sets the other stats to placeholder values
			Player characterObj = new Player(1, 2, 3, 4, name);
			//gets the logger instance and writes the characterObj to the file.
			CharacterLoggerSingleton logger =CharacterLoggerSingleton.getInstance();
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
	
	private class BattleMenuSurrenderButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			refreshMainMenuView();
			switchPanel(mainMenuView);
		}
	}
	
	/**
	 * the action listener for the Normal attack button listener
	 */
	private class BattleMenuNormalAttackButtonListener implements ActionListener{
		/**
		 * Rolls a number then sets the roll Label equal to that result
		 */
		public void actionPerformed(ActionEvent e) {
			//Roll for current battle
			int roll = battleModel.roll();
			battleMenuView.setRollLabel(roll);
			currentPlayer.simpleAttack(currentEnemy);
			battleMenuView.setbtnCharacterHP(currentPlayer.getHp(), currentPlayer.getMaxHP());
			battleMenuView.setbtnEnemyHP(currentEnemy.getHp(), currentEnemy.getMaxHP());
		}
	}
	
	/**
	 * the action listener for the special attack button listener
	 */
	private class BattleMenuSpecialAttackButtonListener implements ActionListener{
		/**
		 * Rolls a number then sets the roll Label equal to that result
		 */
		public void actionPerformed(ActionEvent e) {
			//Roll for current battle
			int roll = battleModel.roll();
			battleMenuView.setRollLabel(roll);
			currentPlayer.specialAttack(currentEnemy);
			battleMenuView.setbtnCharacterHP(currentPlayer.getHp(), currentPlayer.getMaxHP());
			battleMenuView.setbtnEnemyHP(currentEnemy.getHp(), currentEnemy.getMaxHP());
			
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
	private void switchPanel(JPanel panel) {
		contentPane.removeAll();
		contentPane.add(panel);
		mainFrame.revalidate();
		mainFrame.repaint();
	}
	
	/**
	 * Initiates the controller by switching the panel to the mainMenuView and setting the mainFrame visible
	 */
	public void initiate() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {	
				switchPanel(mainMenuView);
				mainFrame.setVisible(true);
			}
		});
	}
	



}
