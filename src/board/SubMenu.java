/**
 * 
 */
package board;

import java.awt.LayoutManager;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * @author manoj
 *
 */
public class SubMenu extends JFrame implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		
		JFrame subMenu = new JFrame("Computer vs Human Selection");
		
		subMenu.setVisible(true);
		subMenu.setResizable(false);
		subMenu.setSize(400,400);
		
		subMenu.setLayout(null);
	    
	    JButton Goat = new JButton("GOAT");
	 
	   
	   subMenu.add(Goat);
	   Goat.setBounds(69, 141, 234, 57);
	   
	   JButton Tiger = new JButton("TIGER"); 
	   Tiger.setBounds(69, 53, 234, 57);
	   subMenu.add(Tiger);
	   
	   
	    
	  
	}

}
