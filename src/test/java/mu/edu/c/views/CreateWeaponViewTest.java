package mu.edu.c.views;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mu.edu.c.controller.MainControllerExtendedTester;
import mu.edu.c.entities.Enemy;
import mu.edu.c.entities.Player;
import mu.edu.c.logger.CharacterLoggerSingleton;
import mu.edu.c.logger.EnemyLoggerSingleton;
import mu.edu.c.weapons.IWeapon;
import mu.edu.c.weapons.SwordWeapon;

class CreateWeaponViewTest {

	ActionListener listener;
	MainMenuView mainMenuView;
	CreateCustomContentView createCustomContentView;
	CreateWeaponView customWeaponView;
	MainControllerExtendedTester mainController;

	@BeforeEach
	void setUp() {
		mainController = new MainControllerExtendedTester();
		mainController.inititateInterface();
		mainMenuView = (MainMenuView) mainController.getContentPane().getComponent(0);
		mainMenuView.getBtnCustomContent().doClick();
		createCustomContentView = (CreateCustomContentView) mainController.getContentPane().getComponent(0);
		createCustomContentView.getBtnCreateNewWeapon().doClick();
		customWeaponView = (CreateWeaponView) mainController.getContentPane().getComponent(0);

	}

	@Test
	void testNameTextInput() {
		int expectedNum = 10;

		customWeaponView.setName("Test Weapon");
		customWeaponView.setWeaponTypeIndex(0);
		customWeaponView.setSimpleDamageStat(expectedNum);
		customWeaponView.setSpecialDamageStat(expectedNum);
		customWeaponView.setScalerStat(expectedNum);

		String nameResult = customWeaponView.getName();
		assertEquals(nameResult, "Test Weapon");
		int weaponTypeIndexResult = customWeaponView.getWeaponTypeIndex();
		assertEquals(weaponTypeIndexResult, 0);
		int simpleDamageResult = customWeaponView.getSimpleDamageStat();
		assertEquals(simpleDamageResult, expectedNum);
		int specialDamageResult = customWeaponView.getSpecialDamageStat();
		assertEquals(specialDamageResult, expectedNum);
		float scalerResult = customWeaponView.getScalerStat();
		assertEquals(scalerResult, 10.0);
	}

    @Test
    void AddCustomWeaponToCharacter() {
    	// variable setup
        int expectedReturn = 10;

        customWeaponView.setSimpleDamageStat(expectedReturn);
        customWeaponView.setSpecialDamageStat(expectedReturn);
        customWeaponView.setScalerStat(expectedReturn);
        customWeaponView.setName("Test Weapon");
        
        customWeaponView.getBtnSubmit().doClick();
        
        CharacterLoggerSingleton logger = CharacterLoggerSingleton.getInstance();
        Player newCharacter = logger.readCharacterData();
        
        SwordWeapon newWeapon = (SwordWeapon) newCharacter.getWeaponStrategy();
        
        assertEquals(newWeapon.getName(), "Test Weapon");
        assertEquals(newWeapon.getScaler(), expectedReturn);
        assertEquals(newWeapon.getSimpleDamage(), expectedReturn);
        assertEquals(newWeapon.getSpecialDamage(), expectedReturn);
    }
    
    @Test
    void AddCustomWeaponToCharacterBadInput() {
    	// variable setup
        int expectedReturn = 10;

        customWeaponView.setSimpleDamageStat(expectedReturn);
        customWeaponView.setSpecialDamageStat(expectedReturn);
        customWeaponView.setScalerStat(expectedReturn);
        
        customWeaponView.getBtnSubmit().doClick();
        
        assertFalse(customWeaponView.getBtnSubmit().isEnabled());
    }

}
