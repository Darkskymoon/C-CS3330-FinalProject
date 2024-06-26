package mu.edu.c.views;

import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.swing.JPanel;

import org.junit.jupiter.api.*;

import mu.edu.c.controller.MainControllerExtendedTester;

public class CreditMenuViewTest {
	
	MainMenuView mainMenuView;
	GameInfoView gameInfoView;
	CreditMenuView creditMenuView;
	MainControllerExtendedTester mainController;

	@BeforeEach
	void setUp() throws Exception {
		mainController = new MainControllerExtendedTester();
		mainController.inititateInterface();
		mainMenuView = (MainMenuView) mainController.getContentPane().getComponent(0);
		mainMenuView.getBtnInfo().doClick();
		gameInfoView = (GameInfoView) mainController.getContentPane().getComponent(0);
		gameInfoView.getBtnCredits().doClick();
		creditMenuView = (CreditMenuView) mainController.getContentPane().getComponent(0);
	}
	
	@Test
	void testBtnBack() {
		creditMenuView.getBtnBack().doClick();
		JPanel newPanel = (JPanel) mainController.getContentPane().getComponent(0);
		
		assertTrue(newPanel instanceof GameInfoView);
	}
	
	
	
}

