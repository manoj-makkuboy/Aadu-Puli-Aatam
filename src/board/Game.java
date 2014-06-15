package board;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import ai.MiniMax;



@SuppressWarnings("serial")
public class Game extends JPanel implements MouseListener, Runnable, ActionListener{
   static  int  X_1=380,Y_1=20,X_2=325,Y_2=225,X_3=440,Y_3=225;
   
  public  static boolean tigerAIOn = false;
  public static boolean AI = false;

    static int input_x1,input_y1,input_x2,input_y2;

    static MiniMax MX_onGame = new MiniMax();
    static  Game game = new Game();
    static	Board REAL = new Board(0);
    static int goat_coordinate[][]=new int [15][2];
	
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
	
	
	for(int i =0;i<REAL.totalNoOfGoatOnTheBoard;i++){
		
		goat_coordinate[i][0] = goat_c[i].X;
		goat_coordinate[i][1] = goat_c[i].Y;
		
	}
	
}

	

public Game() {
	       try {
	    	   background = ImageIO.read(new File("Project Pictures/background.jpg"));
	           img = ImageIO.read(new File("Project Pictures/Adu-puli-attam.png"));
	          
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
		
		
		
		for(int l=0;l<REAL.totalNoOfGoatOnTheBoard;l++){
			
			g2d.drawImage(goat,goat_coordinate[l][0],goat_coordinate[l][1],null);
		}
	
		this.displayWhoMoves(g2d);
		this.displayNoOfGoats(g2d);
		this.displayWhoWins(g2d);
		
	}

	
	//new Function
	
	public void displayWhoMoves(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.red);
		Font f=new Font("purisa",Font.CENTER_BASELINE,25);
		setFont(f);
		
		if(REAL.tigers_move == true){
			g2d.drawString("This is Tiger's Move",50,100);
		}
		else{
			g2d.drawString("This is Goat's Move",50,100);
		}
	}
	
	//new function 
	
	public void displayNoOfGoats(Graphics g){
		
			Graphics2D g2d = (Graphics2D) g;
			Font f=new Font("purisa",Font.CENTER_BASELINE,25);
			setFont(f);
			
			g2d.drawString("Goats Killed : "+REAL.goatKilled, 450, 100);
			
			g2d.drawString("Goats Remaining : "+(15-REAL.noOfGoatsInserted),240,650 );
		
	}
	
	public void displayWhoWins(Graphics g){
		
		Graphics2D g2d = (Graphics2D) g;
		Font f=new Font("purisa",Font.CENTER_BASELINE,25);
		setFont(f);
		if(REAL.goatWon){
			g2d.setColor(Color.blue);
			g2d.fillRoundRect(170, 120, 430, 100, 140, 100);
			g2d.setColor(Color.white);
			g2d.drawString("The Winner Is GOAT", 200, 180);
		}
		else if(REAL.tigerWon){
			
			g2d.setColor(Color.blue);
			g2d.fillRoundRect(170, 120, 430, 100, 140, 100);
			g2d.setColor(Color.white);
			g2d.drawString("The Winner Is TIGER", 200, 180);
		}
	}

	public static void playGame() {    // Called by run() from the bottom of this class
		
		JFrame frame = new JFrame("Aadu Puli Aatam");
		MenuBar MB = new MenuBar();
		
		Menu helpMenu = new Menu("Help");
		Menu gameMenu = new Menu("Game");
		
		
		
		MenuItem about = new MenuItem("About"); 	//items for help menu
		MenuItem quit = new MenuItem("Quit");
		
		MenuItem newGame = new MenuItem("New Game");
		
		
		helpMenu.add(about);
		
		gameMenu.add(newGame);
		gameMenu.add(quit);
		
		newGame.addActionListener(game);
		
		
		
		
		MB.add(gameMenu);
		MB.add(helpMenu);
		
		
		
		
		frame.add(game);
		
		
		frame.setMenuBar(MB);
		frame.setSize(800,700);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
	
		REAL.display();
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
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			// suspends the main thread for 100 ms
				frame.repaint();			// call paint()
				
				if( AI==true){
						MX_onGame.startMiniMax(REAL,tigerAIOn);	// This "false" refers to onTigerAI
					
						REAL.display();
				}
			
				if(REAL.goatWon == true){
					System.out.println("The winner is Goat");
					frame.removeMouseListener(ml);
					game.repaint();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				break;		
				}
				else if(REAL.tigerWon == true){
					
					System.out.println("The Winner is Tiger");
					frame.removeMouseListener(ml);
					game.repaint();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
		game.getInput_and_findPoint(input_x1, input_y1, input_x2, input_y2);
	    System.out.println("No. of goat = "+REAL.totalNoOfGoatOnTheBoard);
	    System.out.println("goat killed = "+REAL.goatKilled);
			// should be replaced by tiger_move
		
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

	@Override
	public void run() {					// Main method of this thread
		// TODO Auto-generated method stub
		playGame();
		
	}
	
void getInput_and_findPoint(int input_from_x,int input_from_y,int input_to_x, int input_to_y ){
		
		int i , j;
		
	    
	   i = gravity(input_from_x, input_from_y);
	   j = gravity(input_to_x, input_to_y);
	   
	   System.out.println("i="+i);
	   System.out.println("j="+j);
	   
	   if(i != 777 && j != 777){
		   REAL.takeDecision(i,j);
		   REAL.display();
		  
	   }
	   else{
		   System.out.println("Invalid input points");
		   return;
	   }
	    
	    
	}  				// End of getInput_and_findPoint()
	  
	int gravity(int x, int y){
		
		for(int i=0;i<23;i++){
			if((((REAL.p[i].X)-10) < x) && (x < (((REAL.p[i].X)+90))) && ((((REAL.p[i].Y)-10)) < y) 
					&& (y < ((((REAL.p[i].Y)+90))))){
				return i;
			}
		}
			
				System.out.println("The inputed co-ordinates are invalid");
				return 777;		// default error value stating invalid position
	
	}


	public void actionPerformed(ActionEvent arg0) {		// Action in response to new game menuitem
		// TODO Auto-generated method stub
			
			REAL = null;
			REAL = new Board(0);
			
			REAL.display();
			
		
		
		
	}



	
}