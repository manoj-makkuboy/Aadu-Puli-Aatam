package board;

@SuppressWarnings("serial")
public class Board extends Game{
	static int no_goat,no_tiger;
	
	
	
	
	
	
	public int X,Y;
	String point_name; 
	boolean tiger,goat,vacant=true;
    Board left,right,top,bottom;
	Board(int x,int y,String name){// Constructor
		X = x;
		Y = y;
		point_name = name;
		}
  public void direction(Board L,Board R,Board T,Board B){
	  	
	  		
	  			
	  		left = L;
	  		right = R;
		    top = T;
		    bottom = B;
		    
	  		
	}
  
 
  void add_tiger(){
	  this.tiger = true;
	  this.vacant = false;
	  
	  
	 
	  
	  
	  
  	}
  void add_goat(){
	  this.goat = true; 
	  this.vacant = false;
	  no_goat++;
  	}
  
  
  void move_tiger(Board destination){
	  boolean p0=false;
	  
	  if(this.vacant == true){  //Checking FROM point for coin
		  System.out.println("The FROM point has no coin");
		  return;
	  }
	  
if(		   (this.equals(destination.left))   //Checking "over jump"
		|| (this.equals(destination.right))
		|| (this.equals(destination.top))
		|| (this.equals(destination.bottom)) )
 {
		
		
	  if(destination.point_name.equalsIgnoreCase("p[0]")){//Checking whether destination is p0
		  p0 = true;
	  }
		  
	  
	  if(destination.tiger==false && destination.goat==false){  //change of coin position if destination is vacant
		  this.tiger = false;
		  destination.tiger = true;
		  this.vacant = true;								//changes the states of this and destination for moving
		  destination.vacant = false;
		  
		
		  
	  }
	  else if(destination.tiger==true){
		  System.out.println("Invalid move 'Tiger exists'");
	  }
	  else if(destination.goat==true){//checking eat condition
		  
		  	if(p0==true){//if destination is p0 no need to continue checking conditions
		  		System.out.println("Can't move 'goat exists'");
		  		return;
		  	}
		  	
		  
		  
		  				if((this.equals(destination.right) 		
		            		 && destination.left.tiger==false
		            		 && destination.left.goat==false)){
		            	 
		            	 destination.goat = false;
		            	 System.out.println("EatCondition satisfied");
		            	 this.move_tiger(destination);	
		            	 	//needs change while creating gui													//moving by 2 step while eating
		            	 destination.move_tiger(destination.left);
		            	 
		            	 no_goat--;										//static int for number of goat 
		            	
		             }
		             else if((this.equals(destination.top)
		            		 && destination.bottom.tiger==false
		            		 && destination.bottom.goat==false)){
		            	 destination.goat = false;
		            	 System.out.println("EatCondition satisfied");
		            	 this.move_tiger(destination);//Moving by 2 step 
		      
		            	 destination.move_tiger(destination.bottom);
		            	
		            	 no_goat--;										//static int for number of goat	   
		             }
		             else if((this.equals(destination.bottom)
		            		 && destination.top.tiger==false
		            		 && destination.top.goat == false)){
		            	 destination.goat = false;
		            	 System.out.println("EatCondition satisfied");
		            	 this.move_tiger(destination);//Moving by 2 step
		            	 
		            	 destination.move_tiger(destination.top);
		            	
		            	 no_goat--;										//staic int for number of goat
		             }
		             else if((this.equals(destination.left)
		            		 && destination.right.tiger==false
		            		 && destination.right.goat==false)){
		            	 destination.goat = false;
		            	 System.out.println("EatCondition satisfied");
		            	 this.move_tiger(destination);					//Moving by 2 step
		            	
		            	 destination.move_tiger(destination.right);
		            
		            	 no_goat--;
		             }
		             else {
		            	 System.out.println("Eat condition Not satisfied");
		             }
	  }
 }//end of "over jump" if
else
{
	System.out.println("Over jump not valid");
	}
   
  

  }
  

}
