package mu.edu.c.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mu.edu.c.entities.Enemy;
import mu.edu.c.entities.EntityFactoryMethod;
import mu.edu.c.logger.EnemyLoggerSingleton;
public class CreateEnemyViewModelTest {

    private CreateEnemyViewModel viewModel;
    private EnemyLoggerSingleton logger;

    @BeforeEach
    void setUp() {
        viewModel = new CreateEnemyViewModel();
        logger = EnemyLoggerSingleton.getInstance();
    }

    @Test
    void testAddCustomEnemyToGame() {
        // Arrange
        String enemyName = "Goblin";
        int maxHp = 50;
        int strength = 10;
        int defense = 5;
        int brains = 3;

        viewModel.setEnemyName(enemyName);
        viewModel.setMaxHp(maxHp);
        viewModel.setStrength(strength);
        viewModel.setDefense(defense);
        viewModel.setBrains(brains);

        // Act
        viewModel.addCustomEnemyToGame();

        // Assert
        EntityFactoryMethod entityFactoryMethod = new EntityFactoryMethod();
        Enemy createdEnemy = entityFactoryMethod.createEnemy(maxHp, strength, defense, brains, enemyName);
        assertNotNull(createdEnemy);
    }
}
