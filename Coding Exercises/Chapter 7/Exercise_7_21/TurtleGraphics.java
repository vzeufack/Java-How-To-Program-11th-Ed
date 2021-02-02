// TurtleGraphics.java by Vannel July 10, 2018
// Simulates the operation of a turtle and creates a computerized sketchpad

import java.util.Arrays;

public class TurtleGraphics{
   //instance variables
   private int[][] floor;
   private static final String[] direction = {"rightward","rightwardDown","downward","leftwardDown","leftward","leftwardUp","upward","rightwardUp"};
   private int currentDirection;
   private int currentRow;
   private int currentColumn;
   private String penPosition;
   private String turnDirection;
   
   //default Constructor
   public TurtleGraphics(){
       floor = new int[20][20];
       penPosition = "up";
       turnDirection = "";	   
   } //end default constructor
   
   //floor accessor
   private int[][] getFloor(){
       return floor;
   }//end floor accessor
   
   //floor mutator
   private void setFloor(int [][] newFloor){
       for (int i = 0; i < floor.length; i++){
	       System.arraycopy(newFloor[i], 0, floor[i], 0, floor.length);
	   }
   }
   
   //main method   
   public static void main (String[] args){
      TurtleGraphics turtleGraphics = new TurtleGraphics();
	  String[] commands = {"2","5,12","3,3","5,2","3,2","5,12","3,3","5,12","1","6","9"};
	  String[] commands3 = {"5,5", "2","3,1","5,10","3,2","5,10","1","6","9"};
	  int[] commands2 = {2,3,2,5,10,4,2,5,10,3,2,5,10,4,2,5,10,4,2,5,5,
	                     4,2,5,15,3,2,5,15,4,2,5,5,1,6,9};   
      String[] commands4 = {"2","3,12","5,10","4,2","5,10","3,2","5,10","4,2","5,10","4,2","5,5",
	                        "4,2","5,15","3,2","5,15","4,2","5,5","1","6","9"};						 
	  turtleGraphics.runCommands (commands);	  
   }//end main method   
   
   //set the values of floor array
   private void moveForward(String direction, int space){      
		  switch(direction){
			 case "rightward":
			     moveRightward(space);
				 break;
		     case "rightwardDown":
			     moveRightwardDown(space);
				 break;
			 case "downward":
			     moveDownward(space);
				 break;
		     case "leftwardDown":
			     moveLeftwardDown(space);
				 break;
			 case "leftward":
			     moveLeftward(space);
				 break;
		     case "leftwardUp":
			     moveLeftwardUp(space);
				 break;
			 case "upward":
			     moveUpward(space);
				 break;		
             case "rightwardUp":
			     moveRightwardUp(space);
				 break;				 
		  }
   }// end method moveForward
   
   //Set the current direction to moveForward
   private void setDirection (String turnDirection, int amount){
      if (turnDirection.equalsIgnoreCase("right")){
	    if (currentDirection + amount > 7){
			currentDirection =  (currentDirection + amount - 8);
		}
		else{
			currentDirection += amount;
		}
	  }
	  else if (turnDirection.equalsIgnoreCase("left")){
	    if (currentDirection - amount < 0){
			currentDirection = currentDirection + 8 - amount;
		}
		else{
			currentDirection -= amount;
		}
	  }
	  else{}
   } // end method setDirection
   
   //display the floor
   private void displayFloor(){
      for (int points[] : floor){
	     for (int point: points){
		    if (point == 1){
			   System.out.printf("*");
			}
			else{
			   System.out.printf(" ");
			}
		 }
		 System.out.println();
	  }
   } // end method displayFloor
   
   //move rightward
   private void moveRightward(int space){
       boolean reachBound = false;
	   
	   for (int i = 0; i < space && !reachBound; i++){
		   if( currentColumn + 1 >= floor[currentRow].length){
				reachBound = true;
				floor[currentRow][currentColumn] = 1;
			}
			else{
			   if (penPosition.equalsIgnoreCase("down")){
			       floor[currentRow][currentColumn] = 1;
			   }
			   if ( i != space - 1){
				   currentColumn++;
			   }
			}
		}
   }//end moveRightward
   
   //move rightward down
   private void moveRightwardDown(int space){
       boolean reachBound = false;
	   
	   for (int i = 0; i < space && !reachBound; i++){
		    if( currentColumn + 1 >= floor[currentRow].length || currentRow + 1 >= floor.length){
				reachBound = true;
				floor[currentRow][currentColumn] = 1;
			}
			else{
			   if (penPosition.equalsIgnoreCase("down")){
			       floor[currentRow][currentColumn] = 1;
			   }
			   if ( i != space - 1){
				   currentColumn++;
				   currentRow++;
			   }
			}
		}
   }//end moveRightwardDown
   
   //move downward
   private void moveDownward(int space){
       boolean reachBound = false;
	   
	   for (int i = 0; i < space && !reachBound; i++){
		   if( currentRow + 1 >= floor.length){
				   reachBound = true;
				   floor[currentRow][currentColumn] = 1;
			}
			else{
			   if (penPosition.equalsIgnoreCase("down")){
			       floor[currentRow][currentColumn] = 1;
			   }
			   if ( i != space - 1){
				   currentRow++;
			   }
			}
		}
   }//end moveDownward
   
   //move leftward
   private void moveLeftward(int space){
       boolean reachBound = false;
	   
	   for (int i = 0; i < space && !reachBound; i++){
		    if( currentColumn - 1 < 0){
				   reachBound = true;
				   floor[currentRow][currentColumn] = 1;
			}
			else{
			   if (penPosition.equalsIgnoreCase("down")){
			       floor[currentRow][currentColumn] = 1;
			   }
			   if ( i != space - 1){
				   currentColumn--;
			   }
			}
		}
   }//end moveLefward
   
   //move leftward up
   private void moveLeftwardUp(int space){
       boolean reachBound = false;
	   
	   for (int i = 0; i < space && !reachBound; i++){
		   if( currentColumn - 1 < 0 || currentRow - 1 < 0){
				   reachBound = true;
				   floor[currentRow][currentColumn] = 1;
			}
			else{
			   if (penPosition.equalsIgnoreCase("down")){
			       floor[currentRow][currentColumn] = 1;
			   }
			   if ( i != space - 1){
				   currentColumn--;
				   currentRow--;
			   }
			}
		}
   }// moveLeftwardUp
   
   //move leftward down
   private void moveLeftwardDown(int space){
       boolean reachBound = false;
	   
	   for (int i = 0; i < space && !reachBound; i++){
		    if( currentColumn - 1 < 0 || currentRow + 1 >= floor.length){
				   reachBound = true;
				   floor[currentRow][currentColumn] = 1;
			}
			else{
			   if (penPosition.equalsIgnoreCase("down")){
			       floor[currentRow][currentColumn] = 1;
			   }
			   if ( i != space - 1){
				   currentColumn--;
				   currentRow++;
			   }
			}
		}
   }// end moveLeftwardDown
   
   //move upward
   private void moveUpward(int space){
       boolean reachBound = false;
	   
	   for (int i = 0; i < space && !reachBound; i++){
		   if( currentRow - 1 < 0){
				   reachBound = true;
				   floor[currentRow][currentColumn] = 1;
			}
			else{
				if (penPosition.equalsIgnoreCase("down")){
			       floor[currentRow][currentColumn] = 1;
			   }
				if ( i != space - 1){
				   currentRow--;
			   }
			}
		}
   }// moveUpward
   
   //move rightward up
   private void moveRightwardUp(int space){
       boolean reachBound = false;
	   
	   for (int i = 0; i < space && !reachBound; i++){
		   if( currentColumn + 1 >= floor[currentRow].length || currentRow - 1 < 0){
				reachBound = true;
				floor[currentRow][currentColumn] = 1;
			}
			else{
			   if (penPosition.equalsIgnoreCase("down")){
			       floor[currentRow][currentColumn] = 1;
			   }
			   if ( i != space - 1){
				   currentColumn++;
				   currentRow--;
			   }
			}
		}
   }//end moveRightwardUp
   
   //run commands
   public void runCommands (String[] commands){
       int amount = 0;
	   String [] stringSplitted;
	   String sentinel = "9";
	   
       for (int i = 0; i < commands.length && !commands[i].equals(sentinel); i++){
	     stringSplitted = commands[i].split(",");
	     switch(stringSplitted.length){		 
		    case 1:
				handleSingleValueCommands(stringSplitted[0]);
				break;
			case 2:
				handleDoubleValueCommands(stringSplitted);
				break;
			default:
			    System.out.println("Invalid command. Command will be skipped!");
		}
	 }
   } //end method runCommands 
   
   //handleSingleValueCommands
   private void handleSingleValueCommands ( String caseValue ){
	   switch (caseValue){
	       case "1":
		       penPosition = "up"; 
			   break;
		   case "2":
			   penPosition = "down";
			   break;
		   case "6":
			   displayFloor();
			   break;
		    default:
			   System.out.println("Invalid command. Command will be skipped!");
	   }
   }// end method handleSingleValueCommands
   
   //handleDoubleValueCommands
   private void handleDoubleValueCommands ( String[] caseValue ){
	   int param1 = Integer.parseInt(caseValue[0]);
	   int param2 = Integer.parseInt(caseValue[1]);
	   switch (param1){
	       case 3:
		       turnDirection = "right";
			   if (param2 != 1 && param2 != 2 && param2 != 3){
			       System.out.println("Invalid second parameter for turning right. Direction won't change");
			   }
			   else
			       setDirection(turnDirection, param2);
			   break;
		   case 4:
			   turnDirection = "left";
			   if (param2 != 1 && param2 != 2 && param2 != 3)
			       System.out.println("Invalid second parameter for turning left. Direction won't change");
			   else
			       setDirection(turnDirection, param2);
			   break;
		   case 5:
		       if (param2 > 0)
		           moveForward(direction[currentDirection], param2);
			   else
			       System.out.println("Move forward second parameter must be strictly positive");
			   break;
		   default:
		       System.out.println("Invalid first parameter. Command will be skipped");
		       break;
	   }
   }// end method handleDoubleValueCommands
   
}//end class TurtleGraphics

// Handle possible input errors
// sentinel check when null

/*
1- pen up
2- pen down
3- right
4- left
5,num- moveforward num times
6- display
9- end of data
*/