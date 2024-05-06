package mu.edu.c.views;

import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.swing.JPanel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mu.edu.c.controller.MainControllerExtendedTester;

public class PreviousBattlesViewTest {

	MainMenuView mainMenuView;
	GameInfoView gameInfoView;
	PreviousBattlesView previousBattlesView;
	MainControllerExtendedTester mainController;
	
	@BeforeEach
	void setUp() throws Exception {
		mainController = new MainControllerExtendedTester();
		mainController.inititateInterface();
		mainMenuView = (MainMenuView) mainController.getContentPane().getComponent(0);
		mainMenuView.getBtnInfo().doClick();
		gameInfoView = (GameInfoView) mainController.getContentPane().getComponent(0);
		gameInfoView.getBtnViewPreviousBattles().doClick();
		previousBattlesView = (PreviousBattlesView) mainController.getContentPane().getComponent(0);
	}
	
	@Test
	void testBtnBack() {
		previousBattlesView.getBtnBack().doClick();
		JPanel newPanel = (JPanel) mainController.getContentPane().getComponent(0);
		
		assertTrue(newPanel instanceof GameInfoView);
	}
	
	@Test
	void testReplayPreviousBattle() {
		previousBattlesView.getBattlesList().setSelectedIndex(0);
		previousBattlesView.getBtnReplay().doClick();
		JPanel newPanel = (JPanel) mainController.getContentPane().getComponent(0);
		
		assertTrue(newPanel instanceof BattleMenuView);
	}
	
	@Test
	void testReplayPreviousBattleNoSelection() {
		previousBattlesView.getBtnReplay().doClick();
		JPanel newPanel = (JPanel) mainController.getContentPane().getComponent(0);
		
		assertTrue(newPanel instanceof PreviousBattlesView);
	}

}
