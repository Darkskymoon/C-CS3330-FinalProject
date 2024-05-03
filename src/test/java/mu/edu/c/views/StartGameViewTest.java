package mu.edu.c.views;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JPanel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mu.edu.c.controller.MainControllerExtendedTester;

class StartGameViewTest {

	MainMenuView mainMenuView;
	StartGameView startGameView;
	MainControllerExtendedTester mainController;

	@BeforeEach
	void setUp() throws Exception {
		mainController = new MainControllerExtendedTester();
		mainController.Inititate();
		mainMenuView = (MainMenuView) mainController.getContentPane().getComponent(0);
		mainMenuView.getBtnStartGame().doClick();
		startGameView = (StartGameView) mainController.getContentPane().getComponent(0);
	}
	
	@Test
	void testBtnBack() {
		startGameView.getBtnBack().doClick();
		JPanel newPanel = (JPanel) mainController.getContentPane().getComponent(0);
		
		assertTrue(newPanel instanceof MainMenuView);
	}
	
	@Test
	void testBtnNewChar() {
		startGameView.getBtnNewChar().doClick();
		JPanel newPanel = (JPanel) mainController.getContentPane().getComponent(0);
		
		assertTrue(newPanel instanceof CreateCharacterView);
	}
	
	@Test
	void testBtnLoad1() {
		startGameView.getBtnLoadCharacter().doClick();
		JPanel newPanel = (JPanel) mainController.getContentPane().getComponent(0);
		
		assertTrue(newPanel instanceof BattleMenuView);
	}

}
