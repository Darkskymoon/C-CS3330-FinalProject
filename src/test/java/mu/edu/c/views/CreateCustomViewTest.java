package mu.edu.c.views;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import javax.annotation.concurrent.NotThreadSafe;
import javax.swing.JPanel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Isolated;

import mu.edu.c.controller.MainControllerExtendedTester;

public class CreateCustomViewTest {
	MainMenuView mainMenuView;
	CreateCustomContentView createCustomContentView;
	MainControllerExtendedTester mainController;

	@BeforeEach
	void setUp() throws Exception {
		mainController = new MainControllerExtendedTester();
		mainController.inititateInterface();
		mainMenuView = (MainMenuView) mainController.getContentPane().getComponent(0);
		mainMenuView.getBtnCustomContent().doClick();
		createCustomContentView = (CreateCustomContentView) mainController.getContentPane().getComponent(0);
	}
	
	@Test
	void testBtnBack() {
		createCustomContentView.getBtnBack().doClick();
		JPanel newPanel = (JPanel) mainController.getContentPane().getComponent(0);
		
		assertTrue(newPanel instanceof MainMenuView);
	}
	
	@Test
	void testBtnNewEnemy() {
		createCustomContentView.getBtnCreateNewEnemy().doClick();
		JPanel newPanel = (JPanel) mainController.getContentPane().getComponent(0);
		
		assertTrue(newPanel instanceof CreateEnemyView);
		
	}
	
	@Test
	void testBtnNewWeapon() {
		createCustomContentView.getBtnCreateNewWeapon().doClick();
		JPanel newPanel = (JPanel) mainController.getContentPane().getComponent(0);
		
		assertTrue(newPanel instanceof CreateWeaponView);
		
	}
	
}
