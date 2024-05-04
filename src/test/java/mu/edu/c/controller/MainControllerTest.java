package mu.edu.c.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
import mu.edu.c.views.WinScreenView;
import mu.edu.c.views.MainMenuView;
import mu.edu.c.views.PreviousBattlesView;
import mu.edu.c.views.StartGameView;

class MainControllerTest {
	
	MainControllerExtendedTester mainController;

	@BeforeEach
	void setUp() throws Exception {
		mainController = new MainControllerExtendedTester();
		mainController.setCurrentEnemy(new Enemy(1, 2, 3, 4, "Ryan"));
		mainController.setCurrentPlayer(new Player(1, 2, 3, 4, "Ryan"));
	}
	
	@Test
	void testRefreshMainMenuView() {
		MainMenuView view = mainController.getMainMenuView();
		mainController.refreshMainMenuView();
		
		MainMenuView view2 =  mainController.getMainMenuView();
		
		assertNotEquals(view, view2);
		
	}
	
	@Test
	void testRefreshGameInfoView() {
		GameInfoView view = mainController.getGameInfoView();
		mainController.refreshGameInfoView();
		
		GameInfoView view2 =  mainController.getGameInfoView();
		
		assertNotEquals(view, view2);
		
	}
	
	@Test
	void testRefreshStartGameView() {
		StartGameView view = mainController.getStartGameView();
		mainController.refreshStartGameView();
		
		StartGameView view2 =  mainController.getStartGameView();
		
		assertNotEquals(view, view2);
		
	}
	
	@Test
	void testRefreshCreditMenuView() {
		CreditMenuView view = mainController.getCreditMenuView();
		mainController.refreshCreditMenuView();
		
		CreditMenuView view2 =  mainController.getCreditMenuView();
		
		assertNotEquals(view, view2);
		
	}
	
	@Test
	void testRefreshBattleMenuView() {
		
		BattleMenuView view = mainController.getBattleMenuView();
		mainController.refreshBattleMenuView();
		
		BattleMenuView view2 =  mainController.getBattleMenuView();
		
		assertNotEquals(view, view2);
		
	}
	
	@Test
	void testRefreshBattleMenuViewParametereized() {
		Battle battle = new Battle(mainController.getCurrentPlayer(), mainController.getCurrentEnemy());
		
		BattleMenuView view = mainController.getBattleMenuView();
		mainController.refreshBattleMenuView(battle);
		
		BattleMenuView view2 =  mainController.getBattleMenuView();
		
		assertNotEquals(view, view2);
		
	}
	
	@Test
	void testRefreshCreateCharacterView() {
		CreateCharacterView view = mainController.getCreateCharacterView();
		mainController.refreshCreateCharacterView();
		
		CreateCharacterView view2 =  mainController.getCreateCharacterView();
		
		assertNotEquals(view, view2);
		
	}
	
	@Test
	void testRefreshPreviousBattlesView() {
		PreviousBattlesView view = mainController.getPreviousBattlesView();
		mainController.refreshPreviousBattlesView();
		
		PreviousBattlesView view2 =  mainController.getPreviousBattlesView();
		
		assertNotEquals(view, view2);
		
	}
	
	@Test
	void testRefreshLoseScreenView() {
		LoseScreenView view = mainController.getLoseScreenView();
		mainController.refreshLoseScreenView();
		
		LoseScreenView view2 =  mainController.getLoseScreenView();
		
		assertNotEquals(view, view2);
		
	}
	
	@Test
	void testRefreshWinScreenView() 
	{
		
		WinScreenView view = mainController.getWinScreenView();
		mainController.refreshWinScreenView();
		
		WinScreenView view2 =  mainController.getWinScreenView();
		
		assertNotEquals(view, view2);
		
	}
	
	@Test
	void testRefreshCreateCustomContentView() {
		CreateCustomContentView view = mainController.getCreateCustomContentView();
		mainController.refreshCreateCustomContentView();
		
		CreateCustomContentView view2 =  mainController.getCreateCustomContentView();
		
		assertNotEquals(view, view2);
		
	}
	
	@Test
	void testRefreshCreateWeaponView() {
		CreateWeaponView view = mainController.getCreateWeaponView();
		mainController.refreshCreateWeaponView();
		
		CreateWeaponView view2 =  mainController.getCreateWeaponView();
		
		assertNotEquals(view, view2);
		
	}
	
	@Test
	void testRefreshCreateEnemyView() {
		CreateEnemyView view = mainController.getCreateEnemyView();
		mainController.refreshCreateEnemyView();
		
		CreateEnemyView view2 =  mainController.getCreateEnemyView();
		
		assertNotEquals(view, view2);
		
	}
	
	
	
	@Test 
	void testSwitchPanel(){
		
		try {
			mainController.getMainFrame().getContentPane().getComponent(0);
			fail("MainFrame contentPane should have no components yet");
		} catch(Exception e) {}
		
		mainController.switchPanelInterface(new MainMenuView());
		
		try {
			mainController.getMainFrame().getContentPane().getComponent(0);
			assertTrue(true);
		} catch(Exception e) {
			fail("MainMenuView not added after switchPanel call");
		}

	}
	

}
