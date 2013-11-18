package board;

import java.awt.Color;
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
   static  int  X_1=380,Y_1=20,X_2=325,Y_2=225,X_3=440,Y_3=225;
    Board[] Tiger_Game=new Board[3];
    
    static int goat_coordinate[][]=new int [15][15];
   
    static int no_of_goat;
	 
	
	BufferedImage img,tiger_1,goat;
	
	

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
	  
void move_goat(int goat_c[][],int goat_no){
	
	goat_coordinate = goat_c;
	
	 no_of_goat = goat_no;
	
}
	
	

	public Game() {
	       try {
	           img = ImageIO.read(new File("/home/manoj/Documents/Project Pictures/Adu-puli-kattam.png"));
	           tiger_1 = ImageIO.read(new File("/home/manoj/Documents/Project Pictures/tiger.jpg"));
	           goat =  ImageIO.read(new File("/home/manoj/Documents/Project Pictures/animals-gnu.png"));
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
		
		
		
		for(int l=0;l<no_of_goat;l++){
			
			g2d.drawImage(goat,goat_coordinate[l][0],goat_coordinate[l][1],null);
		}
	
		
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