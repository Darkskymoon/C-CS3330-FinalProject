package mu.edu.c.controller;

import java.awt.Container;

import javax.swing.JPanel;

import mu.edu.c.battles.Battle;
import mu.edu.c.entities.Enemy;
import mu.edu.c.entities.Player;
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

public class MainControllerExtendedTester extends MainController {

	public MainControllerExtendedTester() {
		super();
	}
	
	public MainFrame getMainFrame() {
		return mainFrame;
	}

	public void setMainFrame(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	public Container getContentPane() {
		return contentPane;
	}

	public void setContentPane(Container contentPane) {
		this.contentPane = contentPane;
	}

	public MainMenuView getMainMenuView() {
		return mainMenuView;
	}

	public void setMainMenuView(MainMenuView mainMenuView) {
		this.mainMenuView = mainMenuView;
	}

	public GameInfoView getGameInfoView() {
		return gameInfoView;
	}

	public void setGameInfoView(GameInfoView gameInfoView) {
		this.gameInfoView = gameInfoView;
	}

	public PreviousBattlesView getPreviousBattlesView() {
		return previousBattlesView;
	}

	public void setPreviousBattlesView(PreviousBattlesView previousBattlesView) {
		this.previousBattlesView = previousBattlesView;
	}

	public StartGameView getStartGameView() {
		return startGameView;
	}

	public void setStartGameView(StartGameView startGameView) {
		this.startGameView = startGameView;
	}

	public CreditMenuView getCreditMenuView() {
		return creditMenuView;
	}

	public void setCreditMenuView(CreditMenuView creditMenuView) {
		this.creditMenuView = creditMenuView;
	}

	public BattleMenuView getBattleMenuView() {
		return battleMenuView;
	}

	public void setBattleMenuView(BattleMenuView battleMenuView) {
		this.battleMenuView = battleMenuView;
	}

	public CreateCharacterView getCreateCharacterView() {
		return createCharacterView;
	}

	public void setCreateCharacterView(CreateCharacterView createCharacterView) {
		this.createCharacterView = createCharacterView;
	}

	public CreateWeaponView getCreateWeaponView() {
		return createWeaponView;
	}

	public void setCreateWeaponView(CreateWeaponView createWeaponView) {
		this.createWeaponView = createWeaponView;
	}

	public CreateEnemyView getCreateEnemyView() {
		return createEnemyView;
	}

	public void setCreateEnemyView(CreateEnemyView createEnemyView) {
		this.createEnemyView = createEnemyView;
	}

	public CreateCustomContentView getCreateCustomContentView() {
		return createCustomContentView;
	}

	public void setCreateCustomContentView(CreateCustomContentView createCustomContentView) {
		this.createCustomContentView = createCustomContentView;
	}

	public LoseScreenView getLoseScreenView() {
		return loseScreenView;
	}

	public void setLoseScreenView(LoseScreenView loseScreenView) {
		this.loseScreenView = loseScreenView;
	}

	public WinScreenView getWinScreenView() {
		return winScreenView;
	}

	public void setWinScreenView(WinScreenView winScreenView) {
		this.winScreenView = winScreenView;
	}

	public Battle getBattleModel() {
		return battleModel;
	}

	public void setBattleModel(Battle battleModel) {
		this.battleModel = battleModel;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

	public Enemy getCurrentEnemy() {
		return currentEnemy;
	}

	public void setCurrentEnemy(Enemy currentEnemy) {
		this.currentEnemy = currentEnemy;
	}

	public boolean isPreviousBattle() {
		return isPreviousBattle;
	}

	public void setPreviousBattle(boolean isPreviousBattle) {
		this.isPreviousBattle = isPreviousBattle;
	}
	
	public void Inititate() {
		refreshMainMenuView();
		switchPanel(mainMenuView);
	}
	
	
	
	
	
}
