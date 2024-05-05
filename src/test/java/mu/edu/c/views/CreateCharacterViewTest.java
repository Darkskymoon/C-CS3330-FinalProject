package mu.edu.c.views;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreateCharacterViewTest {
	private CreateCharacterView view;
    private ActionListener listener;

	@BeforeEach 
    void setUp() {
        view = new CreateCharacterView();
        listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Do nothing
            }
        };
    }
	
	@Test
	void testAccessors() {
		int expectedResult = 10;
		view.setName("Test Character");
		view.setBrainsStat(expectedResult);
		view.setDefenseStat(expectedResult);
		view.setStrengthStat(expectedResult);
		
		String nameResult = view.getName();
		int brainsResult = view.getBrainsStat();
		int defResult = view.getDefenseStat();
		int strResult = view.getStrengthStat();
		
		assertEquals(nameResult, "Test Character");
		assertEquals(brainsResult, expectedResult);
		assertEquals(defResult, expectedResult);
		assertEquals(strResult, expectedResult);
}
}
