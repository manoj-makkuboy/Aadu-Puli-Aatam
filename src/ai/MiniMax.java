/**
 * 
 */
package ai;

import board.Board;
import java.util.*;
import board.SubMenu;

/**
 * @author Manoj
 *
 */
	//This class is the implementation of the miniMax algorithm
	
public class MiniMax {
	
	public static int maxDepth = 7;


	int tiger_sFinalMoveToBePerformed[] = new int[12];
	int goat_sFinalMoveToBePerformed[] = new int [50];
	int plusInfinity = 999999999;
	int minusInfinity = -999999999;
	
	
	public void startMiniMax(Board b, boolean onTigerAI){
			
		
		
		if(onTigerAI == true && b.tigers_move == true){		// this block activates Tiger AI
			
			int i;
			
			int generatedTigerMoveForFinal[][] = generateTigerMove(b);			
		
			int testValue = 0;
			testValue = tigerValue(b,0,minusInfinity,plusInfinity);	// depth =0 when first calling
			
			for(i=0; i<generatedTigerMoveForFinal.length; i++){
				
				if(tiger_sFinalMoveToBePerformed[i] == testValue){
					System.out.println("the best move for Tiger is :"+generatedTigerMoveForFinal[i][0]+"-"+generatedTigerMoveForFinal[i][1]);
					System.out.println("The Test value is "+testValue);
					break;
				}
				
			}
			
			
			b.takeDecision(generatedTigerMoveForFinal[i][0], generatedTigerMoveForFinal[i][1]);
			
			System.out.println("This is Test VALUE :"+testValue);
			
		
			
			System.out.println("the current board value :"+analysis(b));
		
			}									 
		else if(onTigerAI == false && b.tigers_move == false){		// Activation of goat AI
			
				activateGoatAI(b);
		
			
		}		
			
		
		
		
		
		
		
	}
	
	public void activateGoatAI(Board b) {
		// TODO Auto-generated method stub
		int testValue = 0;
		
		int generatedGoatMoveForFinal[][] = generateGoatMove(b);
	
	
		testValue = goatValue(b,0,minusInfinity,plusInfinity); // depth =0 when first calling
		int i;
		
		
		for(i=0; i<generatedGoatMoveForFinal.length; i++){
			
			if(goat_sFinalMoveToBePerformed[i] == testValue){
				System.out.println("the best move for Goat is :"+generatedGoatMoveForFinal[i][0]+"-"+generatedGoatMoveForFinal[i][1]);
				System.out.println("The Test value is "+testValue);
				break;
			}
		
					
		}	
		
	
		
		
		b.takeDecision(generatedGoatMoveForFinal[i][0], generatedGoatMoveForFinal[i][1]); // array out of bound exception possible.
		
		
		System.out.println("This is Test VALUE :"+testValue);
		
	
		
		System.out.println("the current board value :"+analysis(b));
		
		
	
		
		
		
	}



	int tigerValue(Board b, int depth,int alpha, int beta){
		
		if ((gameOver(b)) || depth > maxDepth)
			return analysis(b);
		
		int max = -999999999;
		int generatedTigerMoves[][] = generateTigerMove(b).clone();
		
		for(int i=0; i<generatedTigerMoves.length; i++){
			
			Board c = new Board(b);
			c.move_coin(c.p[generatedTigerMoves[i][0]], c.p[generatedTigerMoves[i][1]]);
			
			
			Board c2 = new Board(c);
			int x = goatValue((c2),depth+1,alpha, beta);
			
			
			
			if (x>max) 
				max = x;
				
			if (x>alpha) 
				alpha = x;
					        
			if (alpha>=beta) 
				return alpha;
			
				       
		
			        		
			
			if(depth == 0){			// for selecting the move for performing in the real board
				tiger_sFinalMoveToBePerformed[i] = x ;
			}
			
		}
		return max;
	}	//End of tigerValue()
	
	
	
	
	
	
	
	
	private int goatValue(Board b, int depth,int alpha, int beta) {
		// TODO Auto-generated method stub

		if ((gameOver(b)) || depth > maxDepth)
			return analysis(b);
		
		int min = 999999999;
		int generatedGoatMoves[][] = generateGoatMove(b).clone();
		
		for(int i=0; i<generatedGoatMoves.length; i++){
			
			Board c = new Board(b);
			c.move_coin(c.p[generatedGoatMoves[i][0]], c.p[generatedGoatMoves[i][1]]);
			
			Board c2 = new Board(c);
			int x = tigerValue(c2,depth+1, alpha, beta);
			
			if(depth == 0 ){		//test code starts
				if( x<min){			// for selecting the move for performing in the real board
					goat_sFinalMoveToBePerformed[i] = x ;
				}
				else if(x<beta)
					goat_sFinalMoveToBePerformed[i] = x ;
				else if(alpha>=beta)
					goat_sFinalMoveToBePerformed[i] = beta ;
			} 						// test code ends
			
			if(x<min)
				min = x;
			if (x<beta) 
				beta = x;
	        if (alpha>=beta) 
	        	return beta;	
			
			if(depth == 0)
				goat_sFinalMoveToBePerformed[i] = x ; 	
			
			
		}
		return min;
		
		
		
	}








	private int analysis(Board b) {
		// TODO Auto-generated method stub
			int goatLossPoints = 3*(b.goatKilled);
			int tigerPosition[] = getTigers(b);
			
			int tigerLossPoints = 0;
			
			
		for (int i=0; i<3 ; i++){
				
				int tempLossPoint = 0;
				
				if(b.p[tigerPosition[0]].right != null)
					if(b.p[tigerPosition[0]].right.vacant == false)
						tempLossPoint++;
				if(b.p[tigerPosition[0]].left != null)
					if(b.p[tigerPosition[0]].left.vacant == false)
						tempLossPoint++;
				if(b.p[tigerPosition[0]].top != null)
					if(b.p[tigerPosition[0]].top.vacant == false)
						tempLossPoint++;
				if(b.p[tigerPosition[0]].bottom != null)
					if(b.p[tigerPosition[0]].bottom.vacant == false)
						tempLossPoint++;
					
				if(tempLossPoint == 3)
					tigerLossPoints = tigerLossPoints+tempLossPoint;
			}	
			
			
				
			for(int i=0; i<3 ; i++){
				
				if(b.isGoatWinner(b.p[tigerPosition[i]]) == true)
					tigerLossPoints = tigerLossPoints + 5;
				
			}
			
			
			
			
			
		
		
		return goatLossPoints-tigerLossPoints;
	}








	public static boolean gameOver(Board b){			// Checking whether won condition for MinMax algorithm 
		
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
		
		if(b.goatInsertionEnded == false){
			
			for(int i=0,j=0; i<=22; i++){
				if( isThisMoveValidForGoat(i, i, b) ){
					
					generatedGoatMoves[j][0]= i;		// when origin and destination are same the 
														// fn() to be called will insert a goat into the board
					generatedGoatMoves[j][1] = i;
					j++;

				}
			trimLength =j;
			}
			
		return trimArray(generatedGoatMoves,trimLength); //take care										
			
		}
		
		else {
			
			int[] goatPositions = new int[b.totalNoOfGoatOnTheBoard];
			goatPositions = getGoats(b);
			
			for(int i=0,j=0 ; i< b.totalNoOfGoatOnTheBoard ; i++){
				
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
		
		if(b.goatInsertionEnded == false){
			if(origin == destination && b.p[origin].vacant == true)
				return true;
			else
				return false;
		}
		else{
			if(b.p[origin].goat == true && b.p[destination].vacant == true)
				return true;
			else
				return false;
		}
		
		
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
			  
			  return moveStatus;
		  }
		  else if(b.p[destination].goat==true){//checking eat condition
			  
			  	if(p0 == true){//if destination is p0 no need to continue checking conditions
			  	
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
			            	
			            	 moveStatus=false;
			             }
		  }

	  
		  				return moveStatus;
		
		
	}
	
	
	public int[] getTigers(Board b){
		
		
		int[] Tiger = new int[3];
		 
		 int j,i;
		
		   for(j=0,i=0; i<=22 && !(j==3) ;i++){	
			   
			   if(b.p[i].tiger==true){
				   
			   
			      Tiger[j]=Integer.parseInt(b.p[i].point_name);
			      j++;		 
			   	}
			  
		   }
		   
		  return Tiger;
	}
	
	int[] getGoats(Board b){
		int[] goat = new int[b.totalNoOfGoatOnTheBoard];
		 
		 int j,i;
		
		   for(j=0,i=0;i<=22 ;i++){	
			   
			   if(b.p[i].goat==true){
				   
			      
			      goat[j]=Integer.parseInt(b.p[i].point_name);
			      j++;		 
			   	}
			  
		   }
		   
		  return goat;
		
	}
	

	
	
		
	
	
}

