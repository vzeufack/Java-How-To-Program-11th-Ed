// Vannel 10/26/2018
// Craps class simulates the dice game craps and answer probability questions
import java.security.SecureRandom;

public class Craps {
   // create secure random number generator for use in method rollDice
   private static final SecureRandom randomNumbers = new SecureRandom();

   // enum type with constants that represent the game status
   private enum Status {CONTINUE, WON, LOST};              

   // constants that represent common rolls of the dice
   private static final int SNAKE_EYES = 2;
   private static final int TREY = 3;      
   private static final int SEVEN = 7;     
   private static final int YO_LEVEN = 11; 
   private static final int BOX_CARS = 12; 

   // plays one game of craps
   public static void main(String[] args) {
      int myPoint = 0; // point if no win or loss on first roll
      Status gameStatus; // can contain CONTINUE, WON or LOST
	  int sumOfDice;
	  int [] numberOfWins = new int [21];
	  int [] numberOfLosses = new int [21];
	  
      
	  for (int i = 0; i < 1000000; i++){
		  sumOfDice = rollDice(); // first roll of the dice

		  // determine game status and point based on first roll 
		  switch (sumOfDice) {
			 case SEVEN: // win with 7 on first roll    
			 case YO_LEVEN: // win with 11 on first roll
				gameStatus = Status.WON;
				numberOfWins[0]++;
				break;
			 case SNAKE_EYES: // lose with 2 on first roll
			 case TREY: // lose with 3 on first roll      
			 case BOX_CARS: // lose with 12 on first roll 
				gameStatus = Status.LOST;
				numberOfLosses[0]++;
				break;
			 default: // did not win or lose, so remember point  
				gameStatus = Status.CONTINUE; // game is not over
				myPoint = sumOfDice; // remember the point       
				System.out.printf("Point is %d%n", myPoint);
				break; 
		  }
          
		  int currentRoll = 0;
		  // while game is not complete
		  while (gameStatus == Status.CONTINUE) { // not WON or LOST
			 sumOfDice = rollDice(); // roll dice again
             currentRoll++;
			 // determine game status
			 if (sumOfDice == myPoint) { // win by making point
				gameStatus = Status.WON;
				if (currentRoll <= 19)
				    numberOfWins[currentRoll]++;
				else
				    numberOfWins[20]++;
			 } 
			 else { 
				if (sumOfDice == SEVEN) { // lose by rolling 7 before point
				   gameStatus = Status.LOST;
				   if (currentRoll <= 19)
				       numberOfLosses[currentRoll]++;
				   else
				       numberOfLosses[20]++;
				} 
			 } 
		  } 

		  // display won or lost message
		  if (gameStatus == Status.WON) {
			 System.out.println("Player wins");
		  } 
		  else {
			 System.out.println("Player loses");
		  }
		  System.out.println("-------------------------------------");
        }
        displayWinsPerRoll(numberOfWins, numberOfLosses);		
   } 

   // roll dice, calculate sum and display results
   public static int rollDice() {
      // pick random die values
      int die1 = 1 + randomNumbers.nextInt(6); // first die roll
      int die2 = 1 + randomNumbers.nextInt(6); // second die roll

      int sum = die1 + die2; // sum of die values

      // display results of this roll
      System.out.printf("Player rolled %d + %d = %d%n", die1, die2, sum);

      return sum; 
   }
   
   private static void displayWinsPerRoll(int [] numberOfWins, int [] numberOfLosses){
       int [] amountOfGamesPerRoll = new int [21];
       for (int i = 0; i < numberOfWins.length-1; i++){
	       if (i < 10)
	           System.out.printf("Roll%3d: %3d games won | %3d games lost | %.2f%% wins\n", i+1, numberOfWins[i], numberOfLosses[i], 
			                                             ((double)numberOfWins[i]/(numberOfWins[i] + numberOfLosses[i])*100));
		   else
		       System.out.printf("Roll%3d: %3d games won | %3d games lost | %.2f%% wins \n", i+1, numberOfWins[i], numberOfLosses[i], 
			                               ((double)numberOfWins[i]/(numberOfWins[i] + numberOfLosses[i])*100));
	   }
	   System.out.printf("Roll>20: %3d games won | %3d games lost | %.2f%% wins\n", numberOfWins[20], numberOfLosses[20], 
	                                       ((double)numberOfWins[20]/(numberOfWins[20] + numberOfLosses[20])*100));
	   
	   int sumWins = 0, sumLosses = 0;
	   for (int i = 0; i < numberOfWins.length; i++){
	       sumWins += numberOfWins[i];
		   sumLosses += numberOfLosses[i];
		   amountOfGamesPerRoll[i] = numberOfWins[i] + numberOfLosses[i];
	   }
	   
	   int sum = 0;
	   for (int i = 0; i < amountOfGamesPerRoll.length; i++){
	       sum += (i+1)*amountOfGamesPerRoll[i];
	   }
	   double avLength = (double)sum/(sumWins+sumLosses);
	   System.out.printf("\nTotal wins: %d | Total Losses: %d\nTotal games played: %d | Game average length: %.2f\n", sumWins, sumLosses, sumWins+sumLosses, avLength);
   }
} 


/**************************************************************************
 * (C) Copyright 1992-2018 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
