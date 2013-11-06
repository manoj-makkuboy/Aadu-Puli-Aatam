package board;

public class Board {
	double X,Y;
	String point_name; 
	boolean tiger,goat,vacant=true,p0;
    Board left,right,top,bottom;
	Board(double x,double y,String name){// Constructor
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
  	}
  
  
  void move_tiger(Board destination){
	  
if(		   (this.equals(destination.left))   //Checking "over jump"
		|| (this.equals(destination.right))
		|| (this.equals(destination.top))
		|| (this.equals(destination.bottom))  )
 {
		
		
	  if(destination.point_name.equalsIgnoreCase("p[0]")){
		  p0 = true;
	  }
		  
	  
	  if(destination.tiger==false && destination.goat==false){
		  this.tiger = false;
		  destination.tiger = true;
		  this.vacant = true;
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
		            	 this.move_tiger(destination);//moving by 2 step while eating
		            	 destination.move_tiger(destination.left);
		            	
		             }
		             else if((this.equals(destination.top)
		            		 && destination.bottom.tiger==false
		            		 && destination.bottom.goat==false)){
		            	 destination.goat = false;
		            	 System.out.println("EatCondition satisfied");
		            	 this.move_tiger(destination);//Moving by 2 step 
		            	 destination.move_tiger(destination.bottom);
		            	     
		             }
		             else if((this.equals(destination.bottom)
		            		 && destination.top.tiger==false
		            		 && destination.top.goat == false)){
		            	 destination.goat = false;
		            	 System.out.println("EatCondition satisfied");
		            	 this.move_tiger(destination);//Moving by 2 step
		            	 destination.move_tiger(destination.top);
		             }
		             else if((this.equals(destination.left)
		            		 && destination.right.tiger==false
		            		 && destination.right.goat==false)){
		            	 destination.goat = false;
		            	 System.out.println("EatCondition satisfied");
		            	 this.move_tiger(destination);//Moving by 2 step
		            	 destination.move_tiger(destination.right);
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
