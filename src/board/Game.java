package board;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.lwjgl.input.Mouse;

@SuppressWarnings("serial")
public class Game extends Component {
   static  int  X_1,Y_1,X_2,Y_2,X_3,Y_3;
    Board[] Tiger_Game=new Board[2];
    
	
	 
	
	BufferedImage img,tiger_1,tiger_2,tiger_3;
	
	

	protected void move_coin(int a_Game[][]) { // 'x' and 'y' are destination point co-ordinates
	    
	for(int i=0;i<3;i++){
		
		X_1=a_Game[0][0];
		Y_1=a_Game[0][1];
		
		X_2=a_Game[1][0];
		Y_2=a_Game[1][1];
		
		X_3=a_Game[2][0];
		Y_3=a_Game[2][1];
		
		
		
		
		
	}	//here 'X' and 'Y' are co-ordinates in which image has to  be draw
		
	//	this.repaint();
		
		
	}
	protected void move_coin(Board FROM){
		
	}
	

	public Game() {
	       try {
	           img = ImageIO.read(new File("/home/manoj/Documents/Project Pictures/Adu-puli-kattam.png"));
	           tiger_1 = ImageIO.read(new File("/home/manoj/Documents/Project Pictures/tiger.jpeg"));
	           tiger_2 = ImageIO.read(new File("/home/manoj/Documents/Project Pictures/tiger.jpeg"));
	           tiger_3 = ImageIO.read(new File("/home/manoj/Documents/Project Pictures/tiger.jpeg"));
	       } catch (IOException e){
	    	System.out.println("Image not loaded");   
	       }
	       
	       }

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		
		g2d.drawImage(img,0,20,null);
		g2d.drawImage(tiger_1,X_1,Y_1,null);
		g2d.drawImage(tiger_1,X_2,Y_2,null);
		g2d.drawImage(tiger_1,X_3,Y_3,null);
		
		
	}
	
	

	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Aadu Puli Aatam");
		
		Game game = new Game();
		
		
		frame.add(game);
		frame.setSize(800,700);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		Test OB = new Test();
		
		OB.Board_config();
		
		game.repaint();
		
		
		while (true) {
			
			
			OB.get_input();
			game.repaint();
		
			
			
		Thread.sleep(10);
			
			
			
			
		}
	}

	
}