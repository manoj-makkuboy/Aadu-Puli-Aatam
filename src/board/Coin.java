package board;

public class Coin {
	
	
	public int X,Y;
	public String point_name; 
	public boolean tiger=false;
	public boolean goat=false;
	public boolean vacant=true;
	public Coin left,right,top,bottom;
	
	
	Coin(Coin toBeCloned){
		
		this.X =toBeCloned.X;
		this.Y = toBeCloned.Y;
		this.point_name = toBeCloned.point_name; 
		this.tiger = toBeCloned.tiger;
		this.goat= toBeCloned.goat;
		this.vacant = toBeCloned.vacant;
		
		
		
		
		
	}
    
	Coin(int x,int y,String name){// Constructor
		
			X = x;
			Y = y;
			point_name = name;
		
		}
	
	public void direction(Coin L,Coin R,Coin T,Coin B){
	  			
	  		left = L;
	  		right = R;
		    top = T;
		    bottom = B;
			
	}
  
 
 

}