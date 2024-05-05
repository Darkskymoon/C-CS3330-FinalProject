package mu.edu.c.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mu.edu.c.entities.Player;
import mu.edu.c.logger.CharacterLoggerSingleton;
import mu.edu.c.weapons.IWeapon;
import mu.edu.c.weapons.WeaponFactoryMethod;
import mu.edu.c.weapons.WeaponType;
public class CreateWeaponViewModelTest {
    private CreateWeaponViewModel viewModel;
    private CharacterLoggerSingleton logger;
    
    @BeforeEach
    void setUp() {
        viewModel = new CreateWeaponViewModel();
        logger = CharacterLoggerSingleton.getInstance();
        
        // set up initial values that are reset every test
        viewModel.setWeaponTypeIndex(0);
        viewModel.setWeaponName("Sword");
        viewModel.setWeaponSimpleDamage(10);
        viewModel.setWeaponSpecialDamage(5);
        viewModel.setWeaponScaler(1.2f);
    }

    @Test
    void testEquipCharacterWithWeaponSuccess() {
        // Act
        Boolean result = viewModel.equipCharacterWithWeapon();

        // Assert
        assertTrue(result);
        Player currentPlayer = logger.readCharacterData();
        assertNotNull(currentPlayer);
        assertNotNull(currentPlayer.getWeaponStrategy());
    }
    
    @Test
    void testEquipCharacterWithWeaponEmptyCharacter() {
    	viewModel.setCurrentPlayer(null);
        Boolean result = viewModel.equipCharacterWithWeapon();
        assertFalse(result);
    }
    
    @Test
	void testSetPopulated() {
    	viewModel.setPopulated(true);
		assertTrue(viewModel.getPopulated());
	}

}
