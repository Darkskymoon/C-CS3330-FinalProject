package mu.edu.c.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mu.edu.c.entities.Player;
import mu.edu.c.views.BattleMenuView;
import mu.edu.c.views.CreateCharacterView;
import mu.edu.c.views.CreditMenuView;
import mu.edu.c.views.GameInfoView;
import mu.edu.c.views.MainMenuView;
import mu.edu.c.views.StartGameView;

class MainControllerTest {
	
	MainControllerExtendedTester mainController;

	@BeforeEach
	void setUp() throws Exception {
		mainController = new MainControllerExtendedTester();
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
	void testRefreshBattleMenuView() throws NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		mainController.setCurrentPlayer(new Player(1, 2, 3, 4, "Ryan"));
		
		BattleMenuView view = mainController.getBattleMenuView();
		mainController.refreshBattleMenuView();
		
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

}
