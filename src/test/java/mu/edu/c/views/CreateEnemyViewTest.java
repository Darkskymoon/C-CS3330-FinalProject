package mu.edu.c.views;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mu.edu.c.controller.MainControllerExtendedTester;
import mu.edu.c.logger.EnemyLoggerSingleton;

import mu.edu.c.entities.Enemy;

public class CreateEnemyViewTest {
	
	ActionListener listener;
	MainMenuView mainMenuView;
	CreateCustomContentView createCustomContentView;
	CreateEnemyView customEnemyView;
	MainControllerExtendedTester mainController;
	
    @BeforeEach
    void setUp() {
		mainController = new MainControllerExtendedTester();
		mainController.inititateInterface();
		mainMenuView = (MainMenuView) mainController.getContentPane().getComponent(0);
		mainMenuView.getBtnCustomContent().doClick();
		createCustomContentView = (CreateCustomContentView) mainController.getContentPane().getComponent(0);
		createCustomContentView.getBtnCreateNewEnemy().doClick();
		customEnemyView = (CreateEnemyView) mainController.getContentPane().getComponent(0);
    }
    
	
	@Test
	void testBtnBack() {
		customEnemyView.getBtnBack().doClick();
		JPanel newPanel = (JPanel) mainController.getContentPane().getComponent(0);
		
		assertTrue(newPanel instanceof CreateCustomContentView);
	}
    
    @Test
    void testGettersAndSetters() {
        int expectedReturn = 10;
        
        customEnemyView.setMaxHp(expectedReturn);
        customEnemyView.setStrengthStat(expectedReturn);
        customEnemyView.setDefenseStat(expectedReturn);
        customEnemyView.setBrainsStat(expectedReturn);
        customEnemyView.setName("Test Enemy");
        
        int maxHpReturn = customEnemyView.getMaxHp();
        int strengthStatReturn = customEnemyView.getStrengthStat();
        int defenseStatReturn = customEnemyView.getDefenseStat();
        int brainsStatReturn = customEnemyView.getBrainsStat();
        String nameReturn = customEnemyView.getName();
        assertEquals(maxHpReturn, expectedReturn);
        assertEquals(strengthStatReturn, expectedReturn);
        assertEquals(defenseStatReturn, expectedReturn);
        assertEquals(brainsStatReturn, expectedReturn);
        assertEquals(nameReturn, "Test Enemy");
    }
    
    @Test
    void AddCustomEnemyToGame() {
    	// variable setup
        int expectedReturn = 10;

        customEnemyView.setMaxHp(expectedReturn);
        customEnemyView.setStrengthStat(expectedReturn);
        customEnemyView.setDefenseStat(expectedReturn);
        customEnemyView.setBrainsStat(expectedReturn);
        customEnemyView.setName("Test Enemy");
        
        customEnemyView.getBtnSubmit().doClick();
        
        EnemyLoggerSingleton logger = EnemyLoggerSingleton.getInstance();
        ArrayList<Enemy> enemyList =  logger.readAllEnemyData();
        Enemy newEnemy = enemyList.getLast();
        
        assertEquals(newEnemy.getMaxHP(), expectedReturn);
        assertEquals(newEnemy.getStrength(), expectedReturn);
        assertEquals(newEnemy.getDefense(), expectedReturn);
        assertEquals(newEnemy.getBrains(), expectedReturn);
        assertEquals(newEnemy.getName(), "Test Enemy");

    }
    
    @Test
    void AddCustomEnemyToGameBadInput() {
    	// variable setup
        int expectedReturn = 10;

        customEnemyView.setMaxHp(expectedReturn);
        customEnemyView.setStrengthStat(expectedReturn);
        customEnemyView.setDefenseStat(expectedReturn);
        customEnemyView.setBrainsStat(expectedReturn);
        
        customEnemyView.getBtnSubmit().doClick();
        
        assertFalse(customEnemyView.getBtnSubmit().isEnabled());
    }
    
    
}
