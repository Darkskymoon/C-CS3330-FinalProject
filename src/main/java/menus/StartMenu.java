package menus;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class StartMenu extends JFrame{
	
	private JPanel contentPane;
	
	public StartMenu() {
		//sets background color of startMenu screen
		setBackground(new Color(45, 44, 65));
		
		//sets the title of the startMenu window
		setTitle("Battle Simulator");
		
		//sets the default close operation
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//initialize the bounds of the startMenu window
		int startMenuXPos = 370;
		int startMenuYPos = 200;
		int startMenuWidth=800;
		int startMenuHeight=500;
		setBounds(startMenuXPos,startMenuYPos,startMenuWidth,startMenuHeight);
		
		//ContentPane initialization for where all the buttons, text, etc appears
		contentPane=new JPanel();
		contentPane.setBackground(new Color(45, 44, 65));
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		
		
		//initialize Buttons (start and credits)
		initializeButtons();
		
		
		
		//Fight simulator label initialization
		FightSimulatorTitle();

		
	}
	
	private void initializeButtons() {
		//make button variables
		JButton btnStartGame = new JButton("Start Game");
		JButton btnCredits = new JButton("Credits");
		JButton btnInfo = new JButton("Game Info");
		
		//set bounds of the buttons
		int btnXPos = 300;
		int btnYPos = 150;
		int btnWidth=200;
		int btnHeight=75;
		
		btnStartGame.setBounds(btnXPos, btnYPos, btnWidth, btnHeight);
		btnCredits.setBounds(btnXPos, btnYPos+85*2, btnWidth, btnHeight);
		btnInfo.setBounds(btnXPos, btnYPos+85, btnWidth, btnHeight);
		
		////////////////////Set visuals for buttons////////////////////
		Font buttonFont= new Font("Yu Gothic Medium", Font.PLAIN, 14);
		//Start Game button
		btnStartGame.setFont(buttonFont);
		
		//Credits Button
		btnCredits.setFont(buttonFont);
		
		//Info Button
		btnInfo.setFont(buttonFont);
		
		
		/////////////////Action Listeners/////////////////////
		//StartGame 
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		//Credits
		btnCredits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		//Info
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		/////////////////Add buttons to ContentPane////////////
		//StartGame
		contentPane.add(btnStartGame);
		//Credits
		contentPane.add(btnCredits);
		//Info
		contentPane.add(btnInfo);
		
		
		
		
	}
	

	private void FightSimulatorTitle() {
		JLabel TitleLabel = new JLabel("Fight Simulator");
		TitleLabel.setForeground(new Color(255, 255, 255));
		TitleLabel.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 24));
		
		int labelXPos = 315;
		int labelYPos = 100;
		int labelWidth=170;
		int labelHeight=40;
		TitleLabel.setBounds(labelXPos, labelYPos, labelWidth, labelHeight);
		contentPane.add(TitleLabel);
	}
	
	
}
