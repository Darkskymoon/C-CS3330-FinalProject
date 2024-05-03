package mu.edu.c.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import mu.edu.c.battles.Battle;
import mu.edu.c.logger.BattleLoggerSingleton;

import javax.swing.JList;

public class PreviousBattlesView extends ParentView {

	private JButton btnBack;
	
	public PreviousBattlesView() {
		GridBagLayout gridBagLayout = (GridBagLayout) getLayout();
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0};
		gridBagLayout.columnWeights = new double[]{1.0};
        this.add(createTitle("Previous Battles"));
        
        JList battlesList = new JList();
        GridBagConstraints gbc_list = new GridBagConstraints();
        gbc_list.insets = new Insets(0, 0, 5, 0);
        gbc_list.fill = GridBagConstraints.BOTH;
        gbc_list.gridx = 0;
        gbc_list.gridy = 1;
        
        add(new JScrollPane(battlesList), gbc_list);
//        battlesList.setEnabled(false);
        ArrayList<Battle> testArray = new ArrayList<Battle>();
		BattleLoggerSingleton battleLogger = BattleLoggerSingleton.getInstance();
		testArray = battleLogger.readAllBattleData();
		Object[] array = testArray.reversed().toArray(new Object[testArray.size()]);
		DefaultListCellRenderer renderer =  (DefaultListCellRenderer)battlesList.getCellRenderer();  
	    renderer.setHorizontalAlignment(JLabel.CENTER);
	    battlesList.setListData(array);

        btnBack = new JButton("Back");
        SetUpButton(btnBack);
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.gridx = 0;
        gbc_btnNewButton.gridy = 3;
        add(btnBack, gbc_btnNewButton);
	}
	
	
	public void addBackButtonListener(ActionListener listener) {
		btnBack.addActionListener(listener);
	}


	public JButton getBtnBack() {
		return btnBack;
	}
	


}
