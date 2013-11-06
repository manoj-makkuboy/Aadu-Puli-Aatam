package board;


public class Test {
	static Board p[]=new Board[24];
	 

	public static void main(String args[])throws NullPointerException {
		// TODO Auto-generated method stub
     
     
   Test t = new Test();
		 
     
    p[0] = new Board(10,6,"p[0]");
    p[1] = new Board(0,7,"p[1]");
    p[2] = new Board(4,7,"p[2]");
    p[3] = new Board(5,7,"p[3]");
    p[4] = new Board(7,7,"p[4]");
    p[5] = new Board(8,7,"p[5]");
    p[6] = new Board(12,7,"p[6]");
    p[7] = new Board(0,5,"p[7]");
    p[8] = new Board(3,5,"p[8]");
    p[9] = new Board(4.5,5,"p[9]");
    p[10] = new Board(7.5,5,"p[10]");
    p[11] = new Board(9,5,"p[11]");
    p[12] = new Board(12,5,"p[12]");
    p[13] = new Board(0,3,"p[13]");
    p[14] = new Board(2,3,"p[14]");
    p[15] = new Board(4,3,"p[15]");
    p[16] = new Board(8,3,"p[16]");
    p[17] = new Board(10,3,"p[17]");
    p[18] = new Board(12,3,"p[18]");
    p[19] = new Board(1,1,"p[21]");
    p[20] = new Board(3.5,1,"p[20]");
    p[21] = new Board(8.5,1,"p[21]");
    p[22] = new Board(11,1,"p[22]");    
     
    p[1].direction(null, p[2], null, p[7]);  
    p[2].direction(p[1], p[3], p[0], p[8]);
    p[3].direction(p[2], p[4], p[0], p[9]);
    p[4].direction(p[3], p[5], p[0], p[10]);
    p[5].direction(p[4], p[6], p[0], p[11]);
    p[6].direction(p[5], null, null, p[12]);
    p[7].direction(null, p[8], p[1], p[2]);
    p[8].direction(p[4],p[9],p[2],p[14]);
    p[9].direction(p[8], p[10], p[3], p[15]);
    p[10].direction(p[9], p[11], p[4], p[16]);
    p[11].direction(p[10],p[12],p[5],p[17]);
    p[12].direction(p[11], null, p[6], p[18]);
    p[13].direction(null, p[14], p[7], null);
    p[14].direction(p[13], p[15], p[8], p[21]);
    p[15].direction(p[14], p[16], p[9], p[20]);
    p[16].direction(p[15], p[17], p[10], p[21]);
    p[17].direction(p[16], p[18], p[11], p[22]);
    p[18].direction(p[17],null,p[12],null);
    p[21].direction(null,p[20],p[14],null);
    p[20].direction(p[21], p[21], p[15], null);
    p[21].direction(p[20], p[22], p[16], null);
    p[22].direction(p[21],null,p[17],null);
    
    p[2].add_tiger();   //Default tiger position
    p[0].add_tiger();
    
    p[3].add_goat();
   // p[4].add_goat();
    
    try{
    p[2].move_tiger(p[3]);  //moves tiger from p[3] to left of p[3] i.e. p[2] 
    }
    catch(NullPointerException e){ // activated when move out of range
    	System.out.println("Move Out of Range : Invalid move");
    }
    t.display();
    
    
    
    
 
 	
 }
	void display(){
		   System.out.println("Tiger at");//Display
		   for(int i=0;i<22;i++) 
		   {	if(p[i].tiger==true)
		   	{
		      System.out.println("p["+i+"]");
		   	}
		   }
		   	System.out.println("Goat at");
		   for(int i=0;i<22;i++)
		   {
		  	 if(p[i].goat==true)
		  	 {
		  		 System.out.println("p["+i+"]");
		  	 }
	}
	
    
	}
}


