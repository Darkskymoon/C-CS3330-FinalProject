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
import mu.edu.c.views.CreateCustomContentView;
import mu.edu.c.views.CreateEnemyView;
import mu.edu.c.views.CreateWeaponView;
import mu.edu.c.views.CreditMenuView;
import mu.edu.c.views.GameInfoView;
import mu.edu.c.views.LoseScreenView;
import mu.edu.c.views.MainFrame;
import mu.edu.c.views.MainMenuView;
import mu.edu.c.views.PreviousBattlesView;
import mu.edu.c.views.StartGameView;
import mu.edu.c.views.WinScreenView;
import mu.edu.c.weapons.AbstractWeapon;
import mu.edu.c.weapons.IWeapon;
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
	protected PreviousBattlesView previousBattlesView;
	protected StartGameView startGameView;
	protected CreditMenuView creditMenuView;
	protected BattleMenuView battleMenuView;
	protected CreateCharacterView createCharacterView;
	protected CreateWeaponView createWeaponView;
	protected CreateEnemyView createEnemyView;
	protected CreateCustomContentView createCustomContentView;
	protected LoseScreenView loseScreenView;
	protected WinScreenView winScreenView;
	// add the new class here
	
	//Models
	protected Battle battleModel;
	//TODO- Is this right?
	protected Player currentPlayer;
	protected Enemy currentEnemy;
	protected boolean isPreviousBattle;
	
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
		this.isPreviousBattle = false;
	}
	
	/**
	 * Refreshes MainMenuView by recreating object and adding button listeners to view
	 */
	protected void refreshMainMenuView() {
		this.mainMenuView = new MainMenuView();
		mainMenuView.addInfoButtonListener(new SwitchScreenToGameInfoView());
		mainMenuView.addCreateCustomContentButtonListener(new SwitchScreenToCreateCustomContentView());
		mainMenuView.addStartGameButtonListener(new SwitchScreenToStartGameView());
		mainMenuView.addCreditButtonListener(new SwitchScreenToCreditMenuView());
	}
	
	/**
	 * Refreshes GameInfoView by recreating object and adding button listeners to view
	 */
	protected void refreshGameInfoView() {
		this.gameInfoView = new GameInfoView();
		gameInfoView.addBackButtonListener(new SwitchScreenToMainMenuView());
		gameInfoView.addPreviousBattlesButtonListener(new SwitchScreenToPreviousBattlesView());

	}
	
	/**
	 * Refreshes PreviousBattlesView by recreating object and adding button listeners to view
	 */
	protected void refreshPreviousBattlesView() {
		this.isPreviousBattle = false;
		this.previousBattlesView = new PreviousBattlesView();
		previousBattlesView.addBackButtonListener(new SwitchScreenToGameInfoView());
		previousBattlesView.addPlayPreviousBattleButtonListener(new replayPreviousBattle());
	}
	
	protected class replayPreviousBattle implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Battle battle = previousBattlesView.getBattlesList().getSelectedValue();
			if(battle != null) {
				refreshBattleMenuView(battle);
				switchPanel(battleMenuView);
			}
		}
		
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
			startGameView.setLoadCharacterText("Create a New Character");
			startGameView.addLoadCharacterButtonListener(new SwitchScreenToCreateCaracterView());
			startGameView.setLoadCharacterHide();
			
		}else { //Otherwise, if the first player does exist, set the load button to route to battle with that character
			//sets the button to the character's name
			startGameView.setLoadCharacterText(this.currentPlayer.getName());
			startGameView.addLoadCharacterButtonListener(new SwitchScreenToBattleMenuView());
			startGameView.addBtnNewCharListener(new SwitchScreenToCreateCaracterView());
			
		}
		startGameView.addBackButtonListener(new SwitchScreenToMainMenuView());
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
		currentPlayer.setHp(currentPlayer.getMaxHP());
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
	 * Refreshes BattleMenuView with a previous battle
	 */
	protected void refreshBattleMenuView(Battle battle) {
		this.isPreviousBattle = true;
		currentPlayer = battle.getPlayer();

		this.battleModel = battle;
		currentPlayer.setHp(currentPlayer.getMaxHP());
		this.battleMenuView = new BattleMenuView();
		
		//initialize enemies
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
	 * Refreshes LoseScreenView by recreating object and adding button listeners to view
	 */
	protected void refreshLoseScreenView() {
		this.loseScreenView = new LoseScreenView();
		loseScreenView.addGiveUpButtonListener(new SwitchScreenToMainMenuView());
		loseScreenView.addRestartButtonListener(new SwitchScreenToBattleMenuView());
	}
	
	/**
	 * Refreshes WinScreenView by recreating object and adding button listeners to view
	 */
	protected void refreshWinScreenView() {
		this.winScreenView = new WinScreenView();
		winScreenView.addKeepCurrentWeaponListener(new SwitchScreenToBattleMenuView());
		winScreenView.addPickNewWeaponListener(new setNewCharacterWeapon());
		AbstractWeapon droppedWeapon = (AbstractWeapon) currentEnemy.getWeaponStrategy();
		AbstractWeapon currentWeapon = (AbstractWeapon) currentPlayer.getWeaponStrategy();
		String oldWeapon = ("<html>" + "Current Weapon<br>Name: " + currentWeapon.getName()+ " " + "<br>Simple DMG: " + currentWeapon.getSimpleDamage() + "<br>Special DMG: " + currentWeapon.getSpecialDamage() + "<br><br><html/>");
		winScreenView.setWeaponLabel(oldWeapon + "<html>" +"New Weapon<br>Name: " + droppedWeapon.getName()+ " " + "<br>Simple DMG: " + droppedWeapon.getSimpleDamage() + "<br>Special DMG: " + droppedWeapon.getSpecialDamage() + "<html/>");
	}
	
	/**
	 * Refreshes CreateCustomContentView by recreating object and adding button listeners to view
	 */
	protected void refreshCreateCustomContentView() {
		this.createCustomContentView = new CreateCustomContentView();
		createCustomContentView.addBackButtonListener(new SwitchScreenToMainMenuView());
		//TODO
		// create switchscreen to create enemy
		createCustomContentView.addCreateNewEnemyListener(new SwitchScreenToCreateEnemyView());
		createCustomContentView.addCreateNewWeaponListener(new SwitchScreenToCreateWeaponView());
	}
	/**
	 * Refreshes CreateCharacterView by recreating object and adding button listeners to view
	 */
	protected void refreshCreateCharacterView() {
		this.createCharacterView = new CreateCharacterView();
		createCharacterView.addBackButtonListener(new SwitchScreenToStartGameView());
		createCharacterView.addSubmitButtonListener(new CreateCharacterSubmit());
	}
	
	/**
	 * Refreshes CreateEnemyView by recreating object and adding button listeners to view
	 */
	protected void refreshCreateEnemyView() {
		this.createEnemyView = new CreateEnemyView();
		createEnemyView.addBackButtonListener(new SwitchScreenToCreateCustomContentView());
		//TODO
		// add new enemy to the database
		createEnemyView.addSubmitButtonListener(null);
	}
	
	/**
	 * Refreshes CreateWeapon by recreating object and adding button listeners to view
	 */
	protected void refreshCreateWeaponView() {
		this.createWeaponView = new CreateWeaponView();
		createWeaponView.addBackButtonListener(new SwitchScreenToCreateCustomContentView());
		// TODO 
		// add method to append new weapons
		createWeaponView.addSubmitButtonListener(null);
	}
	
    //	add refresh view and then underneath add button listeners
	
	
	/**
	 * sets character weapon to defeated enemies' weapons, then starts a new battle
	 */
	protected class setNewCharacterWeapon implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			AbstractWeapon droppedWeapon = (AbstractWeapon) currentEnemy.getWeaponStrategy();
			currentPlayer.setWeaponStrategy(droppedWeapon);
			refreshBattleMenuView();
			switchPanel(battleMenuView);
			if(!isPreviousBattle) {
				CharacterLoggerSingleton characterLogger = CharacterLoggerSingleton.getInstance();
				characterLogger.logCharacterData(currentPlayer);
			}
		 }
	}
	
	
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
	 * Refreshes PreviousBattlesView and switches current panel to it
	 */
	protected class SwitchScreenToPreviousBattlesView implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			refreshPreviousBattlesView();
			switchPanel(previousBattlesView);
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
	protected class SwitchScreenToCreateCaracterView implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			refreshCreateCharacterView();
			switchPanel(createCharacterView);
		}
	
	}
	
	/**
	 * Refreshes CreateWeaponView and switches current panel to it
	 */
	protected class SwitchScreenToCreateEnemyView implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			refreshCreateEnemyView();
			switchPanel(createEnemyView);
		}
	
	}
	
	/**
	 * Refreshes CreateWeaponView and switches current panel to it
	 */
	protected class SwitchScreenToCreateWeaponView implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			refreshCreateWeaponView();
			switchPanel(createWeaponView);
		}
	
	}
	
	/**
	 * Refreshes CreateCharacterView and switches current panel to it
	 */
	protected class SwitchScreenToCreateCustomContentView implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			refreshCreateCustomContentView();
			switchPanel(createCustomContentView);
		}
	
	}
	
	/**
	 * Writes a character to the character file.
	 */
	protected class CreateCharacterSubmit implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			//Gets the character name TODO create getter for this
			String name = createCharacterView.getNameField().getText();
			if (name.equals("")) {
				name = "Ekin";
			}
			//creates the character/player object
			//TODO: temporarily sets the other stats to placeholder values
			Player characterObj = new Player(10, createCharacterView.getStrengthStat(), createCharacterView.getDefenseStat(), createCharacterView.getBrainsStat(), name);
			//gets the logger instance and writes the characterObj to the file.
			CharacterLoggerSingleton logger =CharacterLoggerSingleton.getInstance();
			logger.logCharacterData(characterObj);
			
			//Switch to battle screen and use character just created
			refreshStartGameView();
			switchPanel(startGameView);	
		}
		
	}
	
	////////////////////////////////////////////////////////////////////
	//                  BATTLE MENU LISTENERS                         //
	////////////////////////////////////////////////////////////////////
	
	/**
	 * Refreshes and switches screen to MainMenuView
	 */
	protected class BattleMenuSurrenderButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			refreshMainMenuView();
			switchPanel(mainMenuView);
		}
	}
	
	/**
	 * Superclass with controller attack logic
	 */
	protected class AttackButtonListener {
		
		private float oldPlayerHealth;
		private float oldEnemyHealth;
		
		/**
		 * uses the battle model to calculate a roll and set the roll value
		 * @return
		 */
		protected int roll() {
			int roll = battleModel.roll();
			battleMenuView.setRollLabel(roll);
			return roll;
		}
		
		/**
		 *  checks to see if the screen should be changed to another screen or if the hp should be changed
		 */
		protected void updateHealth() {
	        if(battleModel.getCurrentEnemyCurrentHP() == 0) {
				refreshWinScreenView();
				switchPanel(winScreenView);
			} else if(battleModel.getPlayerHP()== 0) {
				refreshLoseScreenView();
				switchPanel(loseScreenView);
			}
	        
			battleMenuView.setbtnCharacterHP(battleModel.getPlayerHP(), battleModel.getPlayerMaxHP());
			battleMenuView.setbtnEnemyHP(battleModel.getCurrentEnemyCurrentHP(), battleModel.getCurrentEnemyMaxHP());
		}
		
		/**
		 * Updates the battleText()
		 */
		protected void updateBattleText() {
			float playerDamageDealt = oldEnemyHealth - battleModel.getCurrentEnemyCurrentHP();
			float enemyDamageDealt = oldPlayerHealth - battleModel.getPlayerHP();
			battleMenuView.setBtnBattleText("Player dealt " + playerDamageDealt + " damage!\n"
										  + "Enemy dealt " + enemyDamageDealt + " damage!");
			
		}
		
		/**
		 * temporarily saves the old hit points so that the text on the screen can be updated
		 * 
		 */
		protected void saveOldHealth() {
			this.oldPlayerHealth = battleModel.getPlayerHP();
			this.oldEnemyHealth = battleModel.getCurrentEnemyCurrentHP();
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
			int rollResults = roll();
			saveOldHealth();
			//TODO moved to battle
			battleModel.characterSimpleAttack(rollResults, battleModel.getCurrentEnemy());
			battleModel.enemyAttack();
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
			int rollResult = roll();
			saveOldHealth();
			//character performs special attack followed by enemy attack
			battleModel.characterSpecialAttack(rollResult,battleModel.getCurrentEnemy());
			battleModel.enemyAttack();
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
