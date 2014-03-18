package board;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainMenu extends JFrame {
	
	Thread threadForplayGame = new Thread(new Game());
	Thread threadForHumanVsComputer = new Thread(new SubMenu());
	
	static MainMenu menu = new MainMenu();
	
	
	
	public static void main(String args[]){
	
		
		menu.setVisible(true);
		menu.setResizable(false);
		menu.setSize(400,400);
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	
	

	/**
	 * Create the panel.
	 */
	public MainMenu() {
		super("Main Menu");
		
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Learn To Play");
		btnNewButton.setBounds(69, 53, 234, 57);
		getContentPane().add(btnNewButton);
		
		JButton btnHumanVsHuman = new JButton("Human Vs Human");
		btnHumanVsHuman.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				threadForplayGame.start();    // starts the human vs human game as a new thread
				
				menu.setVisible(false);				// to hide mainMenu when the humanVsHuman mode starts
			}
		});
		btnHumanVsHuman.setBounds(69, 141, 234, 57);
		getContentPane().add(btnHumanVsHuman);
		
		JButton btnHumanVsComputer = new JButton("Human Vs Computer");
		btnHumanVsComputer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				threadForHumanVsComputer.start();
				Game.AI = true;
				
			}
		});
		btnHumanVsComputer.setBounds(69, 231, 234, 57);
		getContentPane().add(btnHumanVsComputer);

	}
}
