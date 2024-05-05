package mu.edu.c.views;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JPanel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mu.edu.c.controller.MainControllerExtendedTester;
import mu.edu.c.entities.EntityFactoryMethod;
import mu.edu.c.weapons.IWeapon;

class LoseScreenViewTest {

	MainMenuView mainMenuView;
	StartGameView startGameView;
	BattleMenuView battleMenuView;
	LoseScreenView loseScreenView;
	MainControllerExtendedTester mainController;
	
	EntityFactoryMethod entityFactory;
	
	@BeforeEach
	void setUp() throws Exception {
		entityFactory = new EntityFactoryMethod();
		
		mainController = new MainControllerExtendedTester();
		mainController.inititateInterface();
		mainMenuView = (MainMenuView) mainController.getContentPane().getComponent(0);
		mainMenuView.getBtnStartGame().doClick();
		startGameView = (StartGameView) mainController.getContentPane().getComponent(0);
		startGameView.getBtnLoadCharacter().doClick();
		battleMenuView = (BattleMenuView) mainController.getContentPane().getComponent(0);
		mainController.getCurrentEnemy().setHp(10000);
		mainController.getCurrentPlayer().setHp(0);
		battleMenuView.getBtnNormalAttack().doClick();
		
		loseScreenView = (LoseScreenView) mainController.getContentPane().getComponent(0);
	}
	
	@Test
	public void testBtnRestart() {
		loseScreenView.btnRestart.doClick();
		JPanel newPanel = (JPanel) mainController.getContentPane().getComponent(0);
		
		assertTrue(newPanel instanceof BattleMenuView);
	}
	
	@Test
	public void testBtnGiveUp() {
		loseScreenView.btnGiveUp.doClick();
		JPanel newPanel = (JPanel) mainController.getContentPane().getComponent(0);
		
		assertTrue(newPanel instanceof MainMenuView);
	}

}

