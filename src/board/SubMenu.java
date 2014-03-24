package board;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JSlider;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class SubMenu extends JDialog implements Runnable{

	private final JPanel contentPanel = new JPanel();
	
	Thread threadForplayGame = new Thread(new Game());
	int optionSelected;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	@Override
	public void run() {
		try {
			SubMenu dialog = new SubMenu();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SubMenu() {
		setBounds(100, 100, 213, 189);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Play as Tiger");
		rdbtnNewRadioButton.setBounds(27, 44, 149, 23);
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				optionSelected = 1;
			}
		});
		contentPanel.setLayout(null);
		contentPanel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Play as Goat");
		rdbtnNewRadioButton_1.setBounds(27, 71, 149, 23);
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				optionSelected = 2;
			}
		});
		contentPanel.add(rdbtnNewRadioButton_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						if(optionSelected == 1){
							Game.AI = true;
							Game.tigerAIOn = false;
							threadForplayGame.start(); 
							
						}
						else if(optionSelected == 2){
							Game.AI = true;
							Game.tigerAIOn = true;
							threadForplayGame.start();
						}
							
							
					}
				});
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
