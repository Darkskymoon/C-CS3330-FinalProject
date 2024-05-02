package mu.edu.c.views;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JPanel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mu.edu.c.controller.MainControllerExtendedTester;

class GameInfoViewTest {

	MainMenuView mainMenuView;
	GameInfoView gameInfoView;
	MainControllerExtendedTester mainController;

	@BeforeEach
	void setUp() throws Exception {
		mainController = new MainControllerExtendedTester();
		mainController.Inititate();
		mainMenuView = (MainMenuView) mainController.getContentPane().getComponent(0);
		mainMenuView.getBtnInfo().doClick();
		gameInfoView = (GameInfoView) mainController.getContentPane().getComponent(0);
	}
	
	@Test
	void testBtnStartGame() {
		gameInfoView.getBtnBack().doClick();
		JPanel newPanel = (JPanel) mainController.getContentPane().getComponent(0);
		
		assertTrue(newPanel instanceof MainMenuView);
	}
}
