package board;

import java.util.Scanner;


public class Board {
	public Coin p[]=new Coin[24];
	static int[] gx=new int[23];
	static int[] gy=new int[23];
	static int[] gx1=new int[23];
	static int[] gy1=new int[23];
	
	 static boolean tigers_move = false;  //to find whether it is tiger's move or goat's move
	
	Coin[] Tiger = new Coin[3];
	Coin[] Goat  = new Coin[24];
	

	public void Coin_config(){
		// TODO Auto-generated method stub
		
		
		p[0] = new Coin(595,10,"p[0]");
	    
	    p[1] = new Coin(141, 243,"p[1]");
	    p[2] = new Coin(461, 239,"p[2]");
	    p[3] = new Coin(560, 240,"p[3]");
	    p[4] = new Coin(643, 240,"p[4]");
	    p[5] = new Coin(740, 235,"p[5]");
	    p[6] = new Coin(1077, 239,"p[6]");
	    
	    p[7] = new Coin(132, 379,"p[7]");
	    p[8] = new Coin(378, 372,"p[8]");
	    p[9] = new Coin(527, 377,"p[9]");
	    p[10] = new Coin(670, 372,"p[10]");
	    p[11] = new Coin(814, 374,"p[11]");
	    p[12] = new Coin(1065, 375,"p[12]");
	    
	    
	    p[13] = new Coin(125, 502,"p[13]");
	    p[14] = new Coin(300, 499,"p[14]");
	    p[15] = new Coin(499, 507,"p[15]");
	    p[16] = new Coin(696, 502,"p[16]");
	    p[17] = new Coin(879, 502,"p[17]");
	    p[18] = new Coin(1076, 500,"p[18]");
	    
	    
	    p[19] = new Coin(182, 697,"p[21]");
	    p[20] = new Coin(476, 705,"p[20]");
	    p[21] = new Coin(734, 696,"p[21]");
	    p[22] = new Coin(999, 704,"p[22]");
	    
	    
	    
	    
	    
	    p[0].direction(p[2],p[3],p[4],p[5]);
	    p[1].direction(null, p[2], null, p[7]);  
	    p[2].direction(p[1], p[3], p[0], p[8]);
	    p[3].direction(p[2], p[4], p[0], p[9]);
	    p[4].direction(p[3], p[5], p[0], p[10]);
	    p[5].direction(p[4], p[6], p[0], p[11]);
	    p[6].direction(p[5], null, null, p[12]);
    	p[7].direction(null, p[8], p[1], p[2]);
    	p[8].direction(p[7],p[9],p[2],p[14]);
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
    
    	p[19].direction(null,p[20],p[14],null);
    	p[20].direction(p[19], p[21], p[15], null);
    	p[21].direction(p[20], p[22], p[16], null);
    	p[22].direction(p[21],null,p[17],null);
    
				//Default tiger position
  p[0].add_tiger();
  p[3].add_tiger();
  p[4].add_tiger();
  
 
  p[22].add_goat();
  p[21].add_goat();
  for(int i=0;i<=22;i++){
		gx[i]=p[i].X;
		gy[i]=p[i].Y;
  }
      
    
	} 
	

	void get_input(){
	
		int input_from_x,input_from_y,input_to_x,input_to_y , i , j = 0;
		
		
    System.out.println("Enter the FROM points :");
    @SuppressWarnings("resource")
	Scanner IN = new Scanner(System.in);
    for(i=0;i<=22;i++){
    	p[i].X=gx[i];
    	p[i].Y=gy[i];
		gx1[i]=gx[i];
		gy1[i]=gy[i];
    }	
    
    System.out.println("FROM x = ");
    input_from_x=IN.nextInt();
    System.out.println("FROM y = ");
    input_from_y=IN.nextInt();
    
for(i=0;i<=22;i++){
    	
    	if(p[i].X == input_from_x && p[i].Y == input_from_y){
    		break;
    	}
    	//x constant and y varies
    	else if(gx1[i] == input_from_x && (gy1[i]=gy1[i]+1)==input_from_y){
    		input_from_y--;
    		break;
    	}
    	else if(gx1[i] == input_from_x && (gy1[i]=gy1[i]+1)==input_from_y){
    		input_from_y=input_from_y-2;
    		break;
    	}
    	else if(gx1[i] == input_from_x && (gy1[i]=gy1[i]+1)==input_from_y){
    		input_from_y=input_from_y-3;
    		break;
    	}
    	else if(gx1[i] == input_from_x && (gy1[i]=gy1[i]+1)==input_from_y){
    		input_from_y=input_from_y-4;
    		break;
    	}
    	else if(gx1[i] == input_from_x && (gy1[i]=gy1[i]+1)==input_from_y){
    		input_from_y=input_from_y-5;
    		break;
    	}
    	else if(gx1[i] == input_from_x && (gy1[i]=gy1[i]-6)==input_from_y){
    		input_from_y++;
    		break;
    	}
    	else if(gx1[i] == input_from_x && (gy1[i]=gy1[i]-1)==input_from_y){
    		input_from_y=input_from_y+2;
    		break;
    	}
    	else if(gx1[i] == input_from_x && (gy1[i]=gy1[i]-1)==input_from_y){
    		input_from_y=input_from_y+3;
    		break;
    	}
		else if(gx1[i] == input_from_x && (gy1[i]=gy1[i]-1)==input_from_y){
    		input_from_y=input_from_y+4;
    		break;
    	}
		else if(gx1[i] == input_from_x && (gy1[i]=gy1[i]-1)==input_from_y){
    		input_from_y=input_from_y+5;
    		break;
    	}

    	//x varies and y constant
		else if(((gx1[i]=gx1[i]+1)==input_from_x)&&(gy1[i]==input_from_y)){
			input_from_x--;
			break;
		}
		else if(((gx1[i]=gx1[i]+1)==input_from_x)&&(gy1[i]==input_from_y)){
			input_from_x=input_from_x-2;
			break;
		}
		else if(((gx1[i]=gx1[i]+1)==input_from_x)&&(gy1[i]==input_from_y)){
			input_from_x=input_from_x-3;
			break;
		}
		else if(((gx1[i]=gx1[i]+1)==input_from_x)&&((gy1[i]==input_from_y))){
			input_from_x=input_from_x-4;
			break;
		}
		else if(((gx1[i]=gx1[i]+1)==input_from_x)&&((gy1[i]==input_from_y))){
			input_from_x=input_from_x-5;
			break;
		}
		else if(((gx1[i]=gx1[i]-6)==input_from_x)&&(gy1[i]==input_from_y)){
			input_from_x++;
			break;
		}
		else if(((gx1[i]=gx1[i]-1)==input_from_x)&&(gy1[i]==input_from_y)){
			input_from_x=input_from_x+2;
			break;
		}
		else if(((gx1[i]=gx1[i]-1)==input_from_x)&&(gy1[i]==input_from_y)){
			input_from_x=input_from_x+3;
			break;
		}
		else if(((gx1[i]=gx1[i]-1)==input_from_x)&&((gy1[i]==input_from_y))){
			input_from_x=input_from_x+4;
			break;
		}
		else if(((gx1[i]=gx1[i]-1)==input_from_x)&&((gy1[i]==input_from_y))){
			input_from_x=input_from_x+5;
			break;
		}
    	// both are varies
    	else if(((gx1[i]=gx1[i]+1)==input_from_x)&&((gy1[i]=gy1[i]+1)==input_from_y)){
    		input_from_x--;
    		input_from_y--;
    		break;
    	}
    	else if(((gx1[i]=gx1[i]+1)==input_from_x)&&((gy1[i]=gy1[i]+2)==input_from_y)){
    		input_from_x=input_from_x-2;
    		input_from_y=input_from_y-2;
    		break;
    	}
    	else if(((gx1[i]=gx1[i]+1)==input_from_x)&&((gy1[i]=gy1[i]+3)==input_from_y)){
    		input_from_x=input_from_x-3;
    		input_from_y=input_from_y-3;
    		break;
    	}
    	else if(((gx1[i]=gx1[i]+1)==input_from_x)&&((gy1[i]=gy1[i]+4)==input_from_y)){
    		input_from_x=input_from_x-4;
    		input_from_y=input_from_y-4;
    		break;
    	}
    	else if(((gx1[i]=gx1[i]+1)==input_from_x)&&((gy1[i]=gy1[i]+5)==input_from_y)){
    		input_from_x=input_from_x-5;
    		input_from_y=input_from_y-5;
    		break;
    	}
    	else if(((gx1[i]=gx1[i]-6)==input_from_x)&&((gy1[i]=gy1[i]-1)==input_from_y)){
    		input_from_x++;
    		input_from_y++;
    		break;
    	}
    	else if(((gx1[i]=gx1[i]-1)==input_from_x)&&((gy1[i]=gy1[i]-2)==input_from_y)){
    		input_from_x=input_from_x+2;
    		input_from_y=input_from_y+2;
    		break;
    	}
    	else if(((gx1[i]=gx1[i]-1)==input_from_x)&&((gy1[i]=gy1[i]-3)==input_from_y)){
    		input_from_x=input_from_x+3;
    		input_from_y=input_from_y+3;
    		break;
    	}
    	else  if(((gx1[i]=gx1[i]-1)==input_from_x)&&((gy1[i]=gy1[i]-4)==input_from_y)){
    		input_from_x=input_from_x+4;
    		input_from_y=input_from_y+4;
    		break;
    	}
    	else  if(((gx1[i]=gx1[i]-1)==input_from_x)&&((gy1[i]=gy1[i]-5)==input_from_y)){
    		input_from_x=input_from_x+5;
    		input_from_y=input_from_y+5;
    		break;
    	}	
    }
    System.out.println("i ="+i);
    
    System.out.println("Enter the TO points");
    System.out.println("TO x = ");
    input_to_x=IN.nextInt();
    System.out.println("TO y = ");
    input_to_y=IN.nextInt();
    
    for(j=0;j<=22;j++){
    	if((input_from_x==input_to_x)&&(input_from_y==input_to_y)){
    		System.out.println("your destination position is wrong choose another one" );
    		j=i;
    		break;
    	}
    	else if(p[j].X == input_to_x && p[j].Y == input_to_y){
    		break;
    	}
    	//x constant and y varies
    	else if(p[j].X == input_to_x && ((p[j].Y=p[j].Y+1) == input_to_y)){
    		input_to_y--;
    		break;
    	}
    	else if(p[j].X == input_to_x && ((p[j].Y=p[j].Y+1) == input_to_y)){
    		input_to_y=input_to_y-2;
    		break;
    	}
    	else if(p[j].X == input_to_x && ((p[j].Y=p[j].Y+1) == input_to_y)){
    		input_to_y=input_to_y-3;
    		break;
    	}
    	else if(p[j].X == input_to_x && ((p[j].Y=p[j].Y+1) == input_to_y)){
    		input_to_y=input_to_y-4;
    		break;
    	}
    	else if(p[j].X == input_to_x && ((p[j].Y=p[j].Y+1) == input_to_y)){
    		input_to_y=input_to_y-5;
    		break;
    	}
    	else if(p[j].X == input_to_x && ((p[j].Y=p[j].Y-6) == input_to_y)){
    		input_to_y++;
    		break;
    	}
    	else if(p[j].X == input_to_x && ((p[j].Y=p[j].Y-1) == input_to_y)){
    		input_to_y=input_to_y+2;
    		break;
    	}
    	else if(p[j].X == input_to_x && ((p[j].Y=p[j].Y-1) == input_to_y)){
    		input_to_y=input_to_y+3;
    		break;
    	}
    	else if(p[j].X == input_to_x && ((p[j].Y=p[j].Y-1) == input_to_y)){
    		input_to_y=input_to_y+4;
    		break;
    	}
    	else if(p[j].X == input_to_x && ((p[j].Y=p[j].Y-1) == input_to_y)){
    		input_to_y=input_to_y+5;
    		break;
    	}
    	//x varies and y constant
    	else if(((p[j].X=p[j].X+1)==input_to_x)&&(p[j].Y==input_to_y)){
    		input_to_x--;
			break;
    	}
    	else if(((p[j].X=p[j].X+1)==input_to_x)&&(p[j].Y==input_to_y)){
    		input_to_x=input_to_x-2;
			break;
    	}
    	else if(((p[j].X=p[j].X+1)==input_to_x)&&(p[j].Y==input_to_y)){
    		input_to_x=input_to_x-3;
			break;
    	}
    	else if(((p[j].X=p[j].X+1)==input_to_x)&&(p[j].Y==input_to_y)){
    		input_to_x=input_to_x-4;
			break;
    	}
    	else if(((p[j].X=p[j].X+1)==input_to_x)&&(p[j].Y==input_to_y)){
    		input_to_x=input_to_x-5;
			break;
    	}
    	else if(((p[j].X=p[j].X-6)==input_to_x)&&(p[j].Y==input_to_y)){
    		input_to_x++;
			break;
    	}
    	else if(((p[j].X=p[j].X-1)==input_to_x)&&(p[j].Y==input_to_y)){
    		input_to_x=input_to_x+2;
			break;
    	}
    	else if(((p[j].X=p[j].X-1)==input_to_x)&&(p[j].Y==input_to_y)){
    		input_to_x=input_to_x+3;
			break;
    	}
    	else if(((p[j].X=p[j].X-1)==input_to_x)&&(p[j].Y==input_to_y)){
    		input_to_x=input_to_x+4;
			break;
    	}
    	else if(((p[j].X=p[j].X-1)==input_to_x)&&(p[j].Y==input_to_y)){
    		input_to_x=input_to_x+5;
			break;
    	}
    	// both are varies
    	else if(((p[j].X=p[j].X+1)==input_to_x)&&((p[j].Y=p[j].Y+1)==input_to_y)){
    		input_to_x--;
			input_to_y--;
			break;
    	}
    	else if(((p[j].X=p[j].X+1)==input_to_x)&&(p[j].Y=p[j].Y+2)==input_to_y){
    		input_to_x=input_to_x-2;
			input_to_y=input_to_y-2;
			break;
    	}
    	else if(((p[j].X=p[j].X+1)==input_to_x)&&(p[j].Y=p[j].Y+3)==input_to_y){
    		input_to_x=input_to_x-3;
			input_to_y=input_to_y-3;
			break;
    	}
    	else if(((p[j].X=p[j].X+1)==input_to_x)&&(p[j].Y=p[j].Y+4)==input_to_y){
    		input_to_x=input_to_x-4;
			input_to_y=input_to_y-4;
			break;
    	}
    	else if(((p[j].X=p[j].X+1)==input_to_x)&&(p[j].Y=p[j].Y+5)==input_to_y){
    		input_to_x=input_to_x-5;
			input_to_y=input_to_y-5;
			break;
    	}
    	else if(((p[j].X=p[j].X-6)==input_to_x)&&(p[j].Y=p[j].Y-1)==input_to_y){
    		input_to_x++;
			input_to_y++;
			break;
    	}
    	else if(((p[j].X=p[j].X-1)==input_to_x)&&(p[j].Y=p[j].Y-2)==input_to_y){
    		input_to_x=input_to_x+2;
			input_to_y=input_to_y+2;
			break;
    	}
    	else if(((p[j].X=p[j].X-1)==input_to_x)&&(p[j].Y=p[j].Y-3)==input_to_y){
    		input_to_x=input_to_x+3;
			input_to_y=input_to_y+3;
			break;
    	}
    	else if(((p[j].X=p[j].X-1)==input_to_x)&&(p[j].Y=p[j].Y-4)==input_to_y){
    		input_to_x=input_to_x+4;
			input_to_y=input_to_y+4;
			break;	
    	}
    	else if(((p[j].X=p[j].X-1)==input_to_x)&&(p[j].Y=p[j].Y-5)==input_to_y){
    		input_to_x=input_to_x+5;
			input_to_y=input_to_y+5;
			break;
    	}
    }
    System.out.println("j ="+j);
    	
  
   if(isOverJumping(p[i],p[j])==true){
	   System.out.println("Over jumping condition caught in Board.java");
   }  
    
   else if(p[i].tiger==true && tigers_move == true){
    
    
	    try{
	    	System.out.println("Valid move for tiger");
	    	p[i].move_coin(p[j]);    //moves tiger
	    	tigers_move=false;
	    }
	    catch(NullPointerException e){ // activated when move out of range
	    	System.out.println("Move Out of Range : Invalid move");
	    }
    }
    else if(p[i].tiger==true && tigers_move == false){
    	System.out.println("this is invalid move for tiger");
    	
    }
    else if(p[i].goat==true && tigers_move == false){
    	try{
	    	System.out.println("Valid move for goat");
	    	p[i].move_coin(p[j]);    //moves tiger
	    	tigers_move=true;
	    }
	    catch(NullPointerException e){ // activated when move out of range
	    	System.out.println("Move Out of Range : Invalid move");
	    }	
    }
    else if(p[i].goat==true && tigers_move == true){
    	System.out.println("this is invalid move for goat");
    	
    }
    display();  
 }
	boolean isOverJumping(Coin FROM,Coin TO){
		if(		   (FROM.equals(TO.left))   //Checking "over jump"
		|| (FROM.equals(TO.right))
		|| (FROM.equals(TO.top))
		|| (FROM.equals(TO.bottom))){
			return false;
			
		}
		else
		return true;
	}
	void display(){
		 Game T_Game = new Game();//Testing
		 int[][] a = new int[3][3];
		 int j,i;
		   System.out.println("Tiger at");//Display
		   for(j=0,i=0;i<=22;i++){	
			   if(p[i].tiger==true)
		   	{
		      System.out.println("p["+i+"]");
		      Tiger[j]=p[i];
		      j++;		 
		   	}
		   } 
		 a[0][0] 	= 	Tiger[0].X;
		 a[0][1]	=	Tiger[0].Y;
		 
		 a[1][0] 	= 	Tiger[1].X;
		 a[1][1]	=	Tiger[1].Y;
		  
		 a[2][0] 	=	Tiger[2].X;
		 a[2][1]	=	Tiger[2].Y;
		  
		   T_Game.move_coin_gui(a);
		   	System.out.println("Goat at");
		   	j=0;
		   for(i=0;i<=22;i++)
		   {
		  	 if(p[i].goat==true)
		  	 {	
		  		 System.out.println("p["+i+"]");
		  		 Goat[j]=p[i];
		  		 j++;	
		  	 }
		   }
	 T_Game.move_goat(Goat,j-1);
	}
}
