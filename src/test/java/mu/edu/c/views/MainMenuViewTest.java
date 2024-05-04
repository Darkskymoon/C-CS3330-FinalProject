package mu.edu.c.views;

import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.swing.JPanel;

import org.junit.jupiter.api.*;

import mu.edu.c.controller.MainControllerExtendedTester;

public class MainMenuViewTest {
	
	MainMenuView mainMenuView;
	MainControllerExtendedTester mainController;

	@BeforeEach
	void setUp() throws Exception {
		mainController = new MainControllerExtendedTester();
		mainController.inititateInterface();
		mainMenuView = (MainMenuView) mainController.getContentPane().getComponent(0);
	}
	
	@Test
	void testBtnStartGame() {
		mainMenuView.getBtnStartGame().doClick();
		JPanel newPanel = (JPanel) mainController.getContentPane().getComponent(0);
		
		assertTrue(newPanel instanceof StartGameView);
		
	}
	
	
	@Test
	void testBtnInfo() {
		mainMenuView.getBtnInfo().doClick();
		JPanel newPanel = (JPanel) mainController.getContentPane().getComponent(0);
		
		assertTrue(newPanel instanceof GameInfoView);
		
	}
	
	
	
}
