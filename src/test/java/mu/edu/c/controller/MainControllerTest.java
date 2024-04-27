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
	
	MainController mainController;

	@BeforeEach
	void setUp() throws Exception {
		mainController = new MainController();
	}
	
	@Test
	void testRefreshMainMenuView() throws NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		String methodString = "refreshMainMenuView"; 
        Class[] parameterType = null; 
        
		Method refreshMainMenuViewMethod = mainController.getClass().getDeclaredMethod(methodString, parameterType);
		Field mainMenuViewField = mainController.getClass().getDeclaredField("mainMenuView");
		
		refreshMainMenuViewMethod.setAccessible(true);
		mainMenuViewField.setAccessible(true);
		
		MainMenuView view = (MainMenuView) mainMenuViewField.get(mainController);
		refreshMainMenuViewMethod.invoke(mainController);
		
		MainMenuView view2 = (MainMenuView) mainMenuViewField.get(mainController);
		
		assertNotEquals(view, view2);
		
	}
	
	@Test
	void testRefreshGameInfoView() throws NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		String methodString = "refreshGameInfoView"; 
        Class[] parameterType = null; 
        
		Method refreshGameInfoViewMethod = mainController.getClass().getDeclaredMethod(methodString, parameterType);
		Field mainGameInfoField = mainController.getClass().getDeclaredField("gameInfoView");
		
		refreshGameInfoViewMethod.setAccessible(true);
		mainGameInfoField.setAccessible(true);
		
		GameInfoView view = (GameInfoView) mainGameInfoField.get(mainController);
		refreshGameInfoViewMethod.invoke(mainController);
		
		GameInfoView view2 = (GameInfoView) mainGameInfoField.get(mainController);
		
		assertNotEquals(view, view2);
		
	}
	
	@Test
	void testRefreshStartGameView() throws NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		String methodString = "refreshStartGameView"; 
        Class[] parameterType = null; 
        
		Method refreshStartGameViewMethod = mainController.getClass().getDeclaredMethod(methodString, parameterType);
		Field mainStartGameField = mainController.getClass().getDeclaredField("startGameView");
		
		refreshStartGameViewMethod.setAccessible(true);
		mainStartGameField.setAccessible(true);
		
		StartGameView view = (StartGameView) mainStartGameField.get(mainController);
		refreshStartGameViewMethod.invoke(mainController);
		
		StartGameView view2 = (StartGameView) mainStartGameField.get(mainController);
		
		assertNotEquals(view, view2);
		
	}
	
	@Test
	void testRefreshCreditMenuView() throws NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		String methodString = "refreshCreditMenuView"; 
        Class[] parameterType = null; 
        
		Method refreshCreditMenuViewMethod = mainController.getClass().getDeclaredMethod(methodString, parameterType);
		Field mainCreditMenuField = mainController.getClass().getDeclaredField("creditMenuView");
		
		refreshCreditMenuViewMethod.setAccessible(true);
		mainCreditMenuField.setAccessible(true);
		
		CreditMenuView view = (CreditMenuView) mainCreditMenuField.get(mainController);
		refreshCreditMenuViewMethod.invoke(mainController);
		
		CreditMenuView view2 = (CreditMenuView) mainCreditMenuField.get(mainController);
		
		assertNotEquals(view, view2);
		
	}
	
	@Test
	void testRefreshBattleMenuView() throws NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		String methodString = "refreshBattleMenuView"; 
        Class[] parameterType = null; 
        
		Method refreshBattleMenuViewMethod = mainController.getClass().getDeclaredMethod(methodString, parameterType);
		Field mainBattleMenuField = mainController.getClass().getDeclaredField("battleMenuView");
		Field playerField = mainController.getClass().getDeclaredField("currentPlayer");
		
		refreshBattleMenuViewMethod.setAccessible(true);
		mainBattleMenuField.setAccessible(true);
		playerField.setAccessible(true);
		
		playerField.set(mainController, new Player(1, 2, 3, 4, "Ryan"));
		
		BattleMenuView view = (BattleMenuView) mainBattleMenuField.get(mainController);
		refreshBattleMenuViewMethod.invoke(mainController);
		
		BattleMenuView view2 = (BattleMenuView) mainBattleMenuField.get(mainController);
		
		assertNotEquals(view, view2);
		
	}
	
	@Test
	void testRefreshCreateCharacterView() throws NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		String methodString = "refreshCreateCharacterView"; 
        Class[] parameterType = null; 
        
		Method refreshCreateCharacterViewMethod = mainController.getClass().getDeclaredMethod(methodString, parameterType);
		Field mainCreateCharacterField = mainController.getClass().getDeclaredField("createCharacterView");
		
		refreshCreateCharacterViewMethod.setAccessible(true);
		mainCreateCharacterField.setAccessible(true);
		
		CreateCharacterView view = (CreateCharacterView) mainCreateCharacterField.get(mainController);
		refreshCreateCharacterViewMethod.invoke(mainController);
		
		CreateCharacterView view2 = (CreateCharacterView) mainCreateCharacterField.get(mainController);
		
		assertNotEquals(view, view2);
		
	}

}
