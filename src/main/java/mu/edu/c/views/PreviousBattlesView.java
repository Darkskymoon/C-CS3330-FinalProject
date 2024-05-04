package mu.edu.c.views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import mu.edu.c.battles.Battle;
import mu.edu.c.logger.BattleLoggerSingleton;

import javax.swing.JList;

public class PreviousBattlesView extends ParentView {

	private static final long serialVersionUID = -894881519175756841L;
	private JButton btnBack;
	private JButton replayButton;
	private JList<Battle> battlesList;
	
	public JList<Battle> getBattlesList() {
		return battlesList;
	}


	public PreviousBattlesView() {
		GridBagLayout gridBagLayout = (GridBagLayout) getLayout();
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0};
		gridBagLayout.columnWeights = new double[]{1.0};
        this.add(createTitle("Previous Battles"));
        
        battlesList = new JList<Battle>();
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
		if(testArray != null) {
		Battle[] array = testArray.reversed().toArray(new Battle[testArray.size()]);
		DefaultListCellRenderer renderer =  (DefaultListCellRenderer)battlesList.getCellRenderer();  
	    renderer.setHorizontalAlignment(JLabel.CENTER);
	    battlesList.setListData(array);
		}
        
        replayButton = new JButton("Replay Selected Battle");
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
        gbc_btnNewButton.gridx = 0;
        gbc_btnNewButton.gridy = 2;
        SetUpButtonCustomSize(replayButton, 1);
        add(replayButton, gbc_btnNewButton);

        btnBack = new JButton("Back");
        SetUpButton(btnBack);
        GridBagConstraints gbc_btnNewButton2 = new GridBagConstraints();
        gbc_btnNewButton2.gridx = 0;
        gbc_btnNewButton2.gridy = 3;
        add(btnBack, gbc_btnNewButton2);
	}
	
	
	public void addBackButtonListener(ActionListener listener) {
		btnBack.addActionListener(listener);
	}
	
	public void addPlayPreviousBattleButtonListener(ActionListener listener) {
		replayButton.addActionListener(listener);
	}


	public JButton getBtnBack() {
		return btnBack;
	}
	


}
