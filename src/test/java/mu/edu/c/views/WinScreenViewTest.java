package mu.edu.c.views;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JPanel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mu.edu.c.controller.MainControllerExtendedTester;
import mu.edu.c.entities.EntityFactoryMethod;
import mu.edu.c.weapons.IWeapon;
import mu.edu.c.weapons.SwordWeapon;

class WinScreenViewTest {

	MainMenuView mainMenuView;
	StartGameView startGameView;
	BattleMenuView battleMenuView;
	WinScreenView winScreenView;
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
		mainController.getCurrentEnemy().setHp(0);
		battleMenuView.getBtnNormalAttack().doClick();
		
		winScreenView = (WinScreenView) mainController.getContentPane().getComponent(0);
	}
	
	@Test
	public void testBtnContinue() {
		IWeapon weapon1 = mainController.getCurrentPlayer().getWeaponStrategy();
		winScreenView.btnContinue.doClick();
		JPanel newPanel = (JPanel) mainController.getContentPane().getComponent(0);
		IWeapon weapon2 = mainController.getCurrentPlayer().getWeaponStrategy();
		
		assertTrue(newPanel instanceof BattleMenuView && (weapon1 == weapon2));
	}
	
	@Test
	public void testBtnNewWeapon() {
		IWeapon weapon1 = mainController.getCurrentPlayer().getWeaponStrategy();
		winScreenView.btnNewWeapon.doClick();
		JPanel newPanel = (JPanel) mainController.getContentPane().getComponent(0);
		IWeapon weapon2 = mainController.getCurrentPlayer().getWeaponStrategy();
		
		assertTrue((newPanel instanceof BattleMenuView) && (weapon1 != weapon2));
	}

}
