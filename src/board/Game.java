package board;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;



@SuppressWarnings("serial")
public class Game extends JPanel implements MouseListener {
   static  int  X_1=380,Y_1=20,X_2=325,Y_2=225,X_3=440,Y_3=225;

    static int input_x1,input_y1,input_x2,input_y2;

 static  Game game = new Game();
 static	Board OB = new Board();
    static int goat_coordinate[][]=new int [15][2];
   
    static int no_of_goat;
	 
	
	BufferedImage img,tiger_1,goat,background;
	
	

	  protected void move_tiger_gui(int a_Game[][]) { // 'x' and 'y' are destination point co-ordinates
	    
	
		
		X_1=a_Game[0][0];
		Y_1=a_Game[0][1];
		
		X_2=a_Game[1][0];
		Y_2=a_Game[1][1];
		
		X_3=a_Game[2][0];
		Y_3=a_Game[2][1];
		
		
	}
	  
void move_goat_gui(Coin goat_c[]){
	
	
	for(int i =0;i<Coin.no_goat;i++){
		
	goat_coordinate[i][0] = goat_c[i].X;
	goat_coordinate[i][1] = goat_c[i].Y;
		
	}
	
}
	
	

public Game() {
	       try {
	    	   background = ImageIO.read(new File("Project Pictures/background.jpg"));
	           img = ImageIO.read(new File("Project Pictures/Adu-puli-kattam.png"));
	          
	           tiger_1 = ImageIO.read(new File("Project Pictures/Tiger-gnu.png"));
	           goat =  ImageIO.read(new File("Project Pictures/animals-gnu.png"));
	         
	       } 
	       catch (IOException e){
	    	System.out.println("Image not loaded");   
	       }
	       
}

	@Override
	public void paint(Graphics g) {
		
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		
		g2d.drawImage(background,0,0,null);
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
		
		
		
		frame.add(game);
		frame.setSize(800,700);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		
		OB.Coin_config();
		OB.display();
		game.repaint();
		


	MouseListener ml = new MouseAdapter() {
			
				public void mousePressed(MouseEvent evt1){
							game.testmousePressed(evt1);
							}
			  public void mouseReleased(MouseEvent evt2) {
			        game.testmouseReleased(evt2);
			    }
			    public void mouseClicked(MouseEvent evt3){
			    	game.testmouseClicked(evt3);
			    }
			};
		
			
			while(true){
				
				frame.addMouseListener(ml); 
				Thread.sleep(100);			// suspends the main thread for 100 ms
				frame.repaint();			// call paint()
			
				if(Board.goatWinning == true){	
					System.out.println("The winner is Goat");
					frame.removeMouseListener(ml);
				break;		
				}
				else if(Board.tigerWinning == true){
					System.out.println("The Winner is Tiger");
					frame.removeMouseListener(ml);
				break;
				}
				
				frame.removeMouseListener(ml); // avoid the re adding error of MouseListener
				
		}
				
}
			

	
	
	public void testmouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
	
	}

	
	public void testmouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	public void testmousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		input_x1=arg0.getX();
		input_y1 =arg0.getY();
		System.out.println(input_x1+","+input_y1);
		
	}

	
	public void testmouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		input_x2 = arg0.getX();
		input_y2 = arg0.getY();
		
		System.out.println(input_x2+","+input_y2);
		OB.getInput_and_findPoint(input_x1, input_y1, input_x2, input_y2);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	
}