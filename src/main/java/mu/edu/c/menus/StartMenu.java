package mu.edu.c.menus;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StartMenu extends JFrame{
	
	private JPanel contentPane;
	JButton btnStartGame;
	JButton btnCredits;
	JButton btnInfo;
	Color buttonColor = Color.white;
	Color buttonColorPressed = new Color(226, 221, 250);
	
	public StartMenu() {
		//sets the title of the startMenu window
		setTitle("Battle Simulator");
		
		//sets the default close operation
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setBounds(0, 0, 1000, 1000);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		this.add(new MainPanel());
	}
	
	/*

	
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

		
		btnStartGame.addMouseListener(new MouseAdapter() {
			//change button when mouse is hovered over it
			@Override
			public void mouseEntered(MouseEvent e) {
				btnStartGame.setBackground(buttonColorPressed);
				btnStartGame.setBorder(BorderFactory.createLoweredSoftBevelBorder());
				
				Font buttonFont= new Font("Yu Gothic Medium", Font.PLAIN, 16);
				btnStartGame.setFont(buttonFont);
			}
			//reset button after mouse leaves
			public void mouseExited(MouseEvent e) {
				btnStartGame.setBackground(buttonColor);
				Font buttonFont= new Font("Yu Gothic Medium", Font.PLAIN, 14);
				btnStartGame.setFont(buttonFont);
			}
		});
		
		btnInfo.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btnInfo.setBackground(buttonColorPressed);
				btnInfo.setBorder(BorderFactory.createLoweredSoftBevelBorder());
				
				Font buttonFont= new Font("Yu Gothic Medium", Font.PLAIN, 16);
				btnInfo.setFont(buttonFont);
			}
			public void mouseExited(MouseEvent e) {
				btnInfo.setBackground(buttonColor);
				Font buttonFont= new Font("Yu Gothic Medium", Font.PLAIN, 14);
				btnInfo.setFont(buttonFont);
			}
		});
		
		btnCredits.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCredits.setBackground(buttonColorPressed);
				btnCredits.setBorder(BorderFactory.createLoweredSoftBevelBorder());
				
				Font buttonFont= new Font("Yu Gothic Medium", Font.PLAIN, 16);
				btnCredits.setFont(buttonFont);
			}
			public void mouseExited(MouseEvent e) {
				btnCredits.setBackground(buttonColor);
				Font buttonFont= new Font("Yu Gothic Medium", Font.PLAIN, 14);
				btnCredits.setFont(buttonFont);
			}
		});
		
	}

	private void initializeButtons() {
		//make button variables
		btnStartGame = new JButton("Start Game");

		btnCredits = new JButton("Credits");
		btnInfo = new JButton("Game Info");
		
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
		btnStartGame.setBackground(buttonColor);
		btnStartGame.setFocusPainted(false);
		btnStartGame.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		
		//Credits Button
		btnCredits.setFont(buttonFont);
		btnCredits.setBackground(buttonColor);
		btnCredits.setFocusPainted(false);
		btnCredits.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		
		//Info Button
		btnInfo.setFont(buttonFont);
		btnInfo.setBackground(buttonColor);
		btnInfo.setFocusPainted(false);
		btnCredits.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		
		
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
	*/
	
	
}
