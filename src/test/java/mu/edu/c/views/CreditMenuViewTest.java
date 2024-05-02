package mu.edu.c.views;

import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.swing.JPanel;

import org.junit.jupiter.api.*;

import mu.edu.c.controller.MainControllerExtendedTester;

public class CreditMenuViewTest {
	
	MainMenuView mainMenuView;
	CreditMenuView creditMenuView;
	MainControllerExtendedTester mainController;

	@BeforeEach
	void setUp() throws Exception {
		mainController = new MainControllerExtendedTester();
		mainController.Inititate();
		mainMenuView = (MainMenuView) mainController.getContentPane().getComponent(0);
		mainMenuView.getBtnCredits().doClick();
		creditMenuView = (CreditMenuView) mainController.getContentPane().getComponent(0);
	}
	
	@Test
	void testBtnBack() {
		creditMenuView.getBtnBack().doClick();
		JPanel newPanel = (JPanel) mainController.getContentPane().getComponent(0);
		
		assertTrue(newPanel instanceof MainMenuView);
	}
	
	
	
}

