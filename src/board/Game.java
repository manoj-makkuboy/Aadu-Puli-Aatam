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



@SuppressWarnings("serial")
public class Game extends Component {
   static  int  X_1=380,Y_1=20,X_2=325,Y_2=225,X_3=440,Y_3=225;

    

    
    static int goat_coordinate[][]=new int [15][2];
   
    static int no_of_goat;
	 
	
	BufferedImage img,tiger_1,goat;
	
	

	  protected void move_tiger_gui(int a_Game[][]) { // 'x' and 'y' are destination point co-ordinates
	    
	
		
		X_1=a_Game[0][0];
		Y_1=a_Game[0][1];
		
		X_2=a_Game[1][0];
		Y_2=a_Game[1][1];
		
		X_3=a_Game[2][0];
		Y_3=a_Game[2][1];
		
		
		
		
		
		//here 'X' and 'Y' are co-ordinates in which image has to  be draw
		
	
		
		
	}
	  
void move_goat_gui(Coin goat_c[]){
	
	
	for(int i =0;i<Coin.no_goat;i++){
		
		
	goat_coordinate[i][0] = goat_c[i].X;
	goat_coordinate[i][1] = goat_c[i].Y;//	this.repaint();
	
	
		
		
	}
	
	 
	
}
	
	

	public Game() {
	       try {
	           img = ImageIO.read(new File("Project Pictures/Adu-puli-kattam.png"));
	           tiger_1 = ImageIO.read(new File("Project Pictures/tiger.jpg"));
	           goat =  ImageIO.read(new File("Project Pictures/animals-gnu.png"));
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
		
		
		
		for(int l=0;l<Coin.no_goat;l++){
			
			g2d.drawImage(goat,goat_coordinate[l][0],goat_coordinate[l][1],null);
		}
	
		
	}
	
	
	
	

	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Aadu Puli Aatam");
		
		Game game = new Game();
		Board OB = new Board();
		
		frame.add(game);
		frame.setSize(800,700);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
	    
		
		OB.Coin_config();
		OB.display();
		game.repaint();
		
		
		while (true) {
			
			
			OB.getInput_and_findPoint();
			game.repaint();
			
			if(Board.goatWinning == true){
				System.out.println("The winner is Goat");
				break;
			}
			else if(Board.tigerWinning == true){
				System.out.println("The Winner is Tiger");
				break;
			}
			
			
			

			
			
			
			
		}
	}

	
}