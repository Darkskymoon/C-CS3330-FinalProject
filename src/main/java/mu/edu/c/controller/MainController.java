package mu.edu.c.controller;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

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
	protected MainFrame mainFrame;
	protected Container contentPane;
	protected MainMenuView mainMenuView;
	protected GameInfoView gameInfoView;
	protected StartGameView startGameView;
	protected CreditMenuView creditMenuView;
	protected BattleMenuView battleMenuView;
	protected CreateCharacterView createCharacterView;
	protected LoseScreenView loseScreenView;
	protected WinScreenView winScreenView;
	// add the new class here
	
	//Models
	protected Battle battleModel;
	//TODO- Is this right?
	protected Player currentPlayer;
	protected Enemy currentEnemy;
	
	/**
	 * Constructer which requires MainFrame and MainMenuView objects. 
	 * @param mainFrame
	 * @param startGameView
	 */
	public MainController() {
		new AudioPlayer();
		mainFrame = new MainFrame();
		mainMenuView = new MainMenuView();
		this.contentPane = mainFrame.getContentPane();
	}
	
	/**
	 * Refreshes MainMenuView by recreating object and adding button listeners to view
	 */
	protected void refreshMainMenuView() {
		this.mainMenuView = new MainMenuView();
		mainMenuView.addInfoButtonListener(new SwitchScreenToGameInfoView());
		mainMenuView.addStartGameButtonListener(new SwitchScreenToStartGameView());
		mainMenuView.addCreditButtonListener(new SwitchScreenToCreditMenuView());
	}
	
	/**
	 * Refreshes GameInfoView by recreating object and adding button listeners to view
	 */
	protected void refreshGameInfoView() {
		this.gameInfoView = new GameInfoView();
		gameInfoView.addBackButtonListener(new SwitchScreenToMainMenuView());
	}
	
	/**
	 * Refreshes StartGameView by recreating object and adding button listeners to view
	 */
	protected void refreshStartGameView() {
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
	protected void refreshCreditMenuView() {
		this.creditMenuView = new CreditMenuView();
		creditMenuView.addBackButtonListener(new SwitchScreenToMainMenuView());
	}
	
	/**
	 * Refreshes BattleMenuView by recreating object and adding button listeners to view
	 */
	protected void refreshBattleMenuView() {
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
	
	protected void refreshLoseScreenView() {
		this.loseScreenView = new LoseScreenView();
		loseScreenView.addGiveUpButtonListener(new SwitchScreenToMainMenuView());
		loseScreenView.addRestartButtonListener(new SwitchScreenToMainMenuView());
	}
	
	protected void refreshWinScreenView() {
		this.winScreenView = new WinScreenView();
		winScreenView.addRetireButtonListener(new SwitchScreenToMainMenuView());
		winScreenView.addRestartButtonListener(new SwitchScreenToMainMenuView());
	}
	
	/**
	 * Refreshes CreateCharacterView by recreating object and adding button listeners to view
	 */
	protected void refreshCreateCharacterView() {
		this.createCharacterView = new CreateCharacterView();
		createCharacterView.addBackButtonListener(new SwitchScreenToMainMenuView());
		createCharacterView.addSubmitButtonListener(new CreateCharacterSubmit());
	}
    //	add refresh view and then underneath add button listeners
	
	/**
	 * Refreshes MainMenuView and switches current panel to it
	 */
	protected class SwitchScreenToMainMenuView implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			refreshMainMenuView();
			switchPanel(mainMenuView);
		}
		
	}
	
	/**
	 * Refreshes GameInfoView and switches current panel to it
	 */
	protected class SwitchScreenToGameInfoView implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			refreshGameInfoView();
			switchPanel(gameInfoView);
		}
		
	}
	
	/**
	 * Refreshes StartGameView and switches current panel to it
	 */
	protected class SwitchScreenToStartGameView implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			refreshStartGameView();
			switchPanel(startGameView);
		}
		
	}
	
	/**
	 * Refreshes CreditMenuView and switches current panel to it
	 */
	protected class SwitchScreenToCreditMenuView implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			refreshCreditMenuView();
			switchPanel(creditMenuView);
		}
		
	}
	
	/**
	 * Refreshes BattleMenuView and switches current panel to it
	 */
	protected class SwitchScreenToBattleMenuView implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			refreshBattleMenuView();
			switchPanel(battleMenuView);
		}
		
	}
	
	/**
	 * Refreshes CreateCharacterView and switches current panel to it
	 */
	protected class SwitchScreenToCreateCaracter implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			refreshCreateCharacterView();
			switchPanel(createCharacterView);
		}
	
	}
	
	/**
	 * Writes a character to the character file. TODO: 
	 */
	protected class CreateCharacterSubmit implements ActionListener{
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
	
	protected class BattleMenuSurrenderButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			refreshMainMenuView();
			switchPanel(mainMenuView);
		}
	}
	
	protected class AttackButtonListener {
		
		private float oldPlayerHealth;
		private float oldEnemyHealth;
		
		protected void roll() {
			int roll = battleModel.roll();
			battleMenuView.setRollLabel(roll);
		}
		
		protected void updateHealth() {
	        if(currentEnemy.getHp() == 0) {
				refreshWinScreenView();
				switchPanel(winScreenView);
			} else if(currentPlayer.getHp() == 0) {
				refreshLoseScreenView();
				switchPanel(loseScreenView);
			}
	        
			battleMenuView.setbtnCharacterHP(currentPlayer.getHp(), currentPlayer.getMaxHP());
			battleMenuView.setbtnEnemyHP(currentEnemy.getHp(), currentEnemy.getMaxHP());
		}
		
		protected void updateBattleText() {
			float playerDamageDealt = oldEnemyHealth - currentEnemy.getHp();
			float enemyDamageDealt = oldPlayerHealth - currentPlayer.getHp();
			battleMenuView.setBtnBattleText("Player dealt " + playerDamageDealt + " damage!\n"
										  + "Enemy dealt " + enemyDamageDealt + " damage!");
			
		}
		
		protected void enemyAttack() {
			Random rand = new Random();
			if(rand.nextInt(2) == 0) {
				currentEnemy.simpleAttack(currentPlayer);
			} else {
				currentEnemy.specialAttack(currentPlayer);
			}
		}

		protected void saveOldHealth() {
			this.oldPlayerHealth = currentPlayer.getHp();
			this.oldEnemyHealth = currentEnemy.getHp();
		}
	}
	
	/**
	 * the action listener for the Normal attack button listener
	 */
	protected class BattleMenuNormalAttackButtonListener extends AttackButtonListener implements ActionListener{
		/**
		 * Rolls a number then sets the roll Label equal to that result
		 */
		public void actionPerformed(ActionEvent e) {
			//Roll for current battle
			roll();
			saveOldHealth();
			currentPlayer.simpleAttack(currentEnemy);
			enemyAttack();
			updateHealth();
			updateBattleText();
			
		}
	}
	
	/**
	 * the action listener for the special attack button listener
	 */
	protected class BattleMenuSpecialAttackButtonListener extends AttackButtonListener implements ActionListener{
		/**
		 * Rolls a number then sets the roll Label equal to that result
		 */
		public void actionPerformed(ActionEvent e) {
			//Roll for current battle
			roll();
			saveOldHealth();
			currentPlayer.specialAttack(currentEnemy);
			enemyAttack();
			updateHealth();
			updateBattleText();
			
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
	protected void switchPanel(JPanel panel) {
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
				refreshMainMenuView();
				switchPanel(mainMenuView);
				mainFrame.setVisible(true);
			}
		});
	}

}
