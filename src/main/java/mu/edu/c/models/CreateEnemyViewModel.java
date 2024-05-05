package mu.edu.c.models;

import mu.edu.c.entities.Enemy;
import mu.edu.c.entities.EntityFactoryMethod;
import mu.edu.c.logger.EnemyLoggerSingleton;

public class CreateEnemyViewModel {
	private String enemyName;
	private int maxHp;
	private int strength;
	private int defense;
	private int brains;
	
	private EnemyLoggerSingleton logger = EnemyLoggerSingleton.getInstance();
	private EntityFactoryMethod entityFactoryMethod = new EntityFactoryMethod();
	
	/**
	 * adds enemy to the list of possible enemies in a game
	 */
	public void addCustomEnemyToGame() {
		Enemy newEnemy = entityFactoryMethod.createEnemy(maxHp, strength, defense, brains, enemyName);
		logger.logEnemyData(newEnemy);
	}

	public void setEnemyName(String enemyName) {
		this.enemyName = enemyName;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public void setBrains(int brains) {
		this.brains = brains;
	}
}