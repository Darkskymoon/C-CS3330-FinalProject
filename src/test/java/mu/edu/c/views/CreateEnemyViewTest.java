package mu.edu.c.views;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreateEnemyViewTest {
	
	CreateEnemyView view;
	ActionListener listener;
	
    @BeforeEach
    void setUp() {
        view = new CreateEnemyView();
        listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Do nothing
            }
        };
    }
    
    @Test
    public void testGettersAndSetters() {
        int expectedReturn = 10;
        
        view.setMaxHp(expectedReturn);
        view.setStrengthStat(expectedReturn);
        view.setDefenseStat(expectedReturn);
        view.setBrainsStat(expectedReturn);
        view.setName("Test Enemy");
        
        int maxHpReturn = view.getMaxHp();
        int strengthStatReturn = view.getStrengthStat();
        int defenseStatReturn = view.getDefenseStat();
        int brainsStatReturn = view.getBrainsStat();
        String nameReturn = view.getName();
        assertEquals(maxHpReturn, expectedReturn);
        assertEquals(strengthStatReturn, expectedReturn);
        assertEquals(defenseStatReturn, expectedReturn);
        assertEquals(brainsStatReturn, expectedReturn);
        assertEquals(nameReturn, "Test Enemy");
    }
    
    
}
