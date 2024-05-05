package mu.edu.c.views;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CreateWeaponViewTest {

    private CreateWeaponView view;
    private ActionListener listener;

    @BeforeEach
    void setUp() {
        view = new CreateWeaponView();
        listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Do nothing
            }
        };
    }
    
    @Test
    void testNameTextInput() {
    	int expectedNum = 10;
    	
    	view.setName("Test Weapon");
    	view.setWeaponTypeIndex(0);
    	view.setSimpleDamageStat(expectedNum);
    	view.setSpecialDamageStat(expectedNum);
    	view.setScalerStat(expectedNum);
    	
    	String nameResult = view.getName();
    	assertEquals(nameResult, "Test Weapon");
    	int weaponTypeIndexResult = view.getWeaponTypeIndex();
    	assertEquals(weaponTypeIndexResult, 0);
    	int simpleDamageResult = view.getSimpleDamageStat();
    	assertEquals(simpleDamageResult, expectedNum);
    	int specialDamageResult = view.getSpecialDamageStat();
    	assertEquals(specialDamageResult, expectedNum);
    	float scalerResult = view.getScalerStat();
    	assertEquals(scalerResult, 10.0);
    }
    
    @Test
    void testWeaponEquippedSuccessfully() {
    	view.setWeaponEquipedFlag(false);
    	view.displayError();
    	
    	view.setWeaponEquipedFlag(true);
    	view.displayError();
    }
}
