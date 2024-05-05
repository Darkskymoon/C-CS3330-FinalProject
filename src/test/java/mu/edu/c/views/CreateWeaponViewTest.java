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
}
