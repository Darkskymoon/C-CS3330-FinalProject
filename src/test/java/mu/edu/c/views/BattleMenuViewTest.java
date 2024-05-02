package mu.edu.c.views;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JPanel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mu.edu.c.controller.MainControllerExtendedTester;
import mu.edu.c.entities.Enemy;

class BattleMenuViewTest {

	MainMenuView mainMenuView;
	StartGameView startGameView;
	BattleMenuView battleMenuView;
	MainControllerExtendedTester mainController;

	@BeforeEach
	void setUp() throws Exception {
		mainController = new MainControllerExtendedTester();
		mainController.Inititate();
		mainMenuView = (MainMenuView) mainController.getContentPane().getComponent(0);
		mainMenuView.getBtnStartGame().doClick();
		startGameView = (StartGameView) mainController.getContentPane().getComponent(0);
		startGameView.getBtnLoad1().doClick();
		battleMenuView = (BattleMenuView) mainController.getContentPane().getComponent(0);
	}
	
	@Test
	void testBtnBack() {
		battleMenuView.getBtnSurrender().doClick();
		JPanel newPanel = (JPanel) mainController.getContentPane().getComponent(0);
		
		assertTrue(newPanel instanceof MainMenuView);
	}
	

	@Test
	void testBtnNormalAttack() {
		Enemy enemy = mainController.getCurrentEnemy();
		double startingHealth = enemy.getHp();
		
		battleMenuView.getBtnNormalAttack().doClick();
		double newHealth = enemy.getHp();
		
		assertTrue(startingHealth > newHealth);
	}
	
	@Test
	void testBtnSpecialAttack() {
		Enemy enemy = mainController.getCurrentEnemy();
		double startingHealth = enemy.getHp();
		
		battleMenuView.getBtnSpecialAttack().doClick();
		double newHealth = enemy.getHp();
		
		assertTrue(startingHealth > newHealth);
	}
	
	

}
