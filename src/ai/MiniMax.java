/**
 * 
 */
package ai;

import board.Board;

/**
 * @author Manoj
 *
 */
	//This class is the implementation of the miniMax algorithm
	
public class MiniMax {
	
	int maxDepth = 3;

	int finalMoveToBePerformed[] = new int[12];
	
	
	public void startMiniMax(Board b, boolean isThisTurnTiger_s){
		
	
		int generatedTigerMoveForFinal[][] = generateTigerMove(b);
	
		
		int testValue = 0;
		
		if(isThisTurnTiger_s == false)
			testValue = tigerValue(b,0); // depth =0 when first calling
		
		
		
		for(int i=0; i<12; i++){
			
			if(finalMoveToBePerformed[i] == testValue){
				System.out.println("the best move for Tiger is :"+generatedTigerMoveForFinal[i][0]+"-"+generatedTigerMoveForFinal[i][1]);
				break;
			}
			
		}
		
		System.out.println("This is Test VALUE :"+testValue);
		
	
		
		System.out.println("the current board value :"+analysis(b));
		
	}
	
	int tigerValue(Board b, int depth){
		
		if ((gameOver(b)) || depth > maxDepth)
			return analysis(b);
		
		int max = -999999999;
		int generatedTigerMoves[][] = generateTigerMove(b).clone();
		
		for(int i=0; i<generatedTigerMoves.length; i++){
			
			Board c = new Board(b);
			c.move_coin(c.p[generatedTigerMoves[i][0]], c.p[generatedTigerMoves[i][1]]);
			
			
			Board c2 = new Board(c);
			int x = goatValue((c2),depth+1);
			
			if(x > max)
				max = x;
			
			if(depth == 0){			// for selecting the move for performing in the real board
				finalMoveToBePerformed[i] = x ;
			}
			
		}
		return max;
	}	//End of tigerValue()
	
	
	
	
	
	
	
	
	private int goatValue(Board b, int depth) {
		// TODO Auto-generated method stub

		if ((gameOver(b)) || depth > maxDepth)
			return analysis(b);
		
		int min = 999999999;
		int generatedGoatMoves[][] = generateGoatMove(b).clone();
		
		for(int i=0; i<generatedGoatMoves.length; i++){
			
			Board c = new Board(b);
			c.move_coin(c.p[generatedGoatMoves[i][0]], c.p[generatedGoatMoves[i][1]]);
			
			Board c2 = new Board(c);
			int x = tigerValue(c2,depth+1);
			
			
			
			if(x < min)
				min = x;
			
		}
		return min;
		
		
		
	}








	private int analysis(Board b) {
		// TODO Auto-generated method stub
			int goatLossPoints = 3*(b.goatKilled);
			int tigerPosition[] = getTigers(b);
			
			int tigerLossPoints = 0;
			
			for(int i=0; i<3 ; i++){
				
				if(b.isGoatWinner(b.p[tigerPosition[i]]) == true)
					tigerLossPoints = tigerLossPoints + 5;
				
			}
			
			
			
		
		
		return goatLossPoints-tigerLossPoints;
	}








	static boolean gameOver(Board b){			// Checking whether won condition for MinMax algorithm 
		
		if(b.goatWon == true || b.tigerWon == true)	
				return true;
		else
				return false;
	
	}
	
	
	int[][] trimArray(int[][] toBeTrimed,int trimLength){	//trims the unused part of the array
		
	
		
		int[][] trimedArray = new int[trimLength][2];//Array to be returned
		
		for(int i=0; i< trimLength; i++){
			trimedArray[i][0] = toBeTrimed[i][0];
			trimedArray[i][1] = toBeTrimed[i][1];
		}
		
		return trimedArray;
		
	}
	
	 int[][] generateGoatMove(Board b){
		
		 int trimLength = 0;
		
		int[] tigerPositions = new int[3];
		
		int[][] generatedGoatMoves = new int[60][2];
		
		
		
		
		tigerPositions = getTigers(b);
		
		if(b.noOfGoatsInserted < 15){
			
			for(int i=0,j=0; i<=22; i++){
				if( i != tigerPositions[0] && i != tigerPositions[1] && i!= tigerPositions[2] ){
					
					generatedGoatMoves[j][0]= i;		// when origin and destination are same the 
														// fn() to be called will insert a goat into the board
					generatedGoatMoves[j][1] = i;
					trimLength = j++;

				}
			
			}
			
			
			
			
		return trimArray(generatedGoatMoves,trimLength+1); //take care										
			
		}
		
		else{
			
			int[] goatPositions = new int[b.totalNoOfGoat];
			goatPositions = getGoats(b);
			
			for(int i=0,j=0 ; i< b.totalNoOfGoat ; i++){
				
				if(b.p[goatPositions[i]].left != null){
					if(isThisMoveValidForGoat(Integer.parseInt(b.p[goatPositions[i]].point_name)
												,Integer.parseInt(b.p[goatPositions[i]].left.point_name),b)){
						
						generatedGoatMoves[j][0] = Integer.parseInt(b.p[goatPositions[i]].point_name);
						generatedGoatMoves[j][1] = Integer.parseInt(b.p[goatPositions[i]].left.point_name);
						
						j++;  				//this increments the generatedGoatMoves[]
						
					}	// End of Left Check
				}
				
				if(b.p[goatPositions[i]].right != null){
					if(isThisMoveValidForGoat(Integer.parseInt(b.p[goatPositions[i]].point_name)
												,Integer.parseInt(b.p[goatPositions[i]].right.point_name),b)){
						
						generatedGoatMoves[j][0] = Integer.parseInt(b.p[goatPositions[i]].point_name);
						generatedGoatMoves[j][1] = Integer.parseInt(b.p[goatPositions[i]].right.point_name);
						
						j++;  
					}
				
				}		//End of Right check
				
				if(b.p[goatPositions[i]].top != null){
					if(isThisMoveValidForGoat(Integer.parseInt(b.p[goatPositions[i]].point_name)
												,Integer.parseInt(b.p[goatPositions[i]].top.point_name),b)){
						
						generatedGoatMoves[j][0] = Integer.parseInt(b.p[goatPositions[i]].point_name);
						generatedGoatMoves[j][1] = Integer.parseInt(b.p[goatPositions[i]].top.point_name);
						
						j++;  
					}
				
				}
				
				if(b.p[goatPositions[i]].bottom!= null){
					if(isThisMoveValidForGoat(Integer.parseInt(b.p[goatPositions[i]].point_name)
												,Integer.parseInt(b.p[goatPositions[i]].bottom.point_name),b)){
						
						generatedGoatMoves[j][0] = Integer.parseInt(b.p[goatPositions[i]].point_name);
						generatedGoatMoves[j][1] = Integer.parseInt(b.p[goatPositions[i]].bottom.point_name);
						
						j++;  
					}	// End of bottom check
				
				}
				
				
				
			trimLength = j;	
				
				
			}
			
			return trimArray(generatedGoatMoves,trimLength);
			
			
			
			
		}
		
		
		
	}
	 
	 
	int[][] generateTigerMove(Board b){   // fn() tested
		
		int[] tigerPositions = new int[3];
		int trimLength = 0;
		
		tigerPositions = getTigers(b);
		int generatedTigerMoves[][] = new int[12][2];
		
		for(int i=0,j=0; i<3; i++){
			
			if(b.p[tigerPositions[i]].left != null){
				if(isThisMoveValidForTiger(Integer.parseInt(b.p[tigerPositions[i]].point_name)
											,Integer.parseInt(b.p[tigerPositions[i]].left.point_name),b)){
					
					generatedTigerMoves[j][0] = Integer.parseInt(b.p[tigerPositions[i]].point_name);
					generatedTigerMoves[j][1] = Integer.parseInt(b.p[tigerPositions[i]].left.point_name);
					
					j++;  				//this increments the generatedGoatMoves[]
					
				}	// End of Left Check
			}
			
			if(b.p[tigerPositions[i]].right != null){
				if(isThisMoveValidForTiger(Integer.parseInt(b.p[tigerPositions[i]].point_name)
											,Integer.parseInt(b.p[tigerPositions[i]].right.point_name),b)){
					
					generatedTigerMoves[j][0] = Integer.parseInt(b.p[tigerPositions[i]].point_name);
					generatedTigerMoves[j][1] = Integer.parseInt(b.p[tigerPositions[i]].right.point_name);
					
					j++;  
				}
			
			}		//End of Right check
			
			if(b.p[tigerPositions[i]].top != null){
				if(isThisMoveValidForTiger(Integer.parseInt(b.p[tigerPositions[i]].point_name)
											,Integer.parseInt(b.p[tigerPositions[i]].top.point_name),b)){
					
					generatedTigerMoves[j][0] = Integer.parseInt(b.p[tigerPositions[i]].point_name);
					generatedTigerMoves[j][1] = Integer.parseInt(b.p[tigerPositions[i]].top.point_name);
					
					j++;  
				}
			
			}
			
			if(b.p[tigerPositions[i]].bottom!= null){
				if(isThisMoveValidForTiger(Integer.parseInt(b.p[tigerPositions[i]].point_name)
											,Integer.parseInt(b.p[tigerPositions[i]].bottom.point_name),b)){
					
					generatedTigerMoves[j][0] = Integer.parseInt(b.p[tigerPositions[i]].point_name);
					generatedTigerMoves[j][1] = Integer.parseInt(b.p[tigerPositions[i]].bottom.point_name);
					
					j++;
					  
				}	// End of bottom check
			
			}
			
			
			trimLength = j;	
			
			
			
		}
		
			
		return trimArray(generatedTigerMoves,trimLength);
		
		
	}
	
	
	boolean isThisMoveValidForGoat(int origin, int destination, Board b){
		
		if(b.p[origin].goat == true && b.p[destination].vacant == true)
			return true;
		else
			return false;
		
		
		
	}
	
	boolean isThisMoveValidForTiger(int origin, int destination, Board b){
		
		  boolean p0 = false;
		  boolean moveStatus = false;
		  
		if(b.p[destination] == null)		// avoids going into null pointer exception
			return false;
		  

			
			
		  if(b.p[destination].point_name.equalsIgnoreCase("0")){//Checking whether destination is p0
			  p0 = true;
		  }
			  
		  
		  if(b.p[destination].tiger==false && b.p[destination].goat==false){//change of coin position if destination is vacant
			 	  
				  moveStatus = true;
				  return moveStatus;
				  
		  }
			   
		  
		  else if(b.p[destination].tiger==true){
			  System.out.println("Invalid move 'Tiger exists'");
			  return moveStatus;
		  }
		  else if(b.p[destination].goat==true){//checking eat condition
			  
			  	if(p0 == true){//if destination is p0 no need to continue checking conditions
			  		System.out.println("Can't move 'goat exists'");
			  		return moveStatus;
			  	}
			  	
			  
			  	
			  				if((b.p[origin].equals(b.p[destination].right) 		
			            		 && b.p[destination].left != null
			            		 && b.p[destination].left.tiger==false
			            		 && b.p[destination].left.goat==false  )){
			            	 
			  
			            	 moveStatus=true;
			             }
			             else if((b.p[origin].equals(b.p[destination].top)
			            		 && b.p[destination].bottom != null
			            		 && b.p[destination].bottom.tiger==false
			            		 && b.p[destination].bottom.goat==false)){
			            	
			            	 moveStatus=true;
			             }
			             else if((b.p[origin].equals(b.p[destination].bottom)
			            		 && b.p[destination].top != null
			            		 && b.p[destination].top.tiger==false
			            		 && b.p[destination].top.goat == false)){
			            	 
			            	 moveStatus=true;
			             }
			             else if((b.p[origin].equals(b.p[destination].left)
			              		 && b.p[destination].right != null
			              		 &&b.p[destination].right.tiger==false
			            		 && b.p[destination].right.goat==false)){
			            	
			            
			            	 moveStatus=true;
			             }
			             else {
			            	 System.out.println("Eat condition Not satisfied");
			            	 moveStatus=false;
			             }
		  }

	  
		  				return moveStatus;
		
		
	}
	
	
	int[] getTigers(Board b){
		
		
		int[] Tiger = new int[3];
		 
		 int j,i;
		
		   for(j=0,i=0; i<=22 && !(j==3) ;i++){	
			   
			   if(b.p[i].tiger==true){
				   
			      System.out.println("p["+i+"]");
			      Tiger[j]=Integer.parseInt(b.p[i].point_name);
			      j++;		 
			   	}
			  
		   }
		   
		  return Tiger;
	}
	
	int[] getGoats(Board b){
		int[] goat = new int[b.totalNoOfGoat];
		 
		 int j,i;
		
		   for(j=0,i=0;i<=22 ;i++){	
			   
			   if(b.p[i].goat==true){
				   
			      System.out.println("p["+i+"]");
			      goat[j]=Integer.parseInt(b.p[i].point_name);
			      j++;		 
			   	}
			  
		   }
		   
		  return goat;
		
	}
	

	
	
	

	
	
	
	
}

