// DiceRolling.java by Vannel July 1st 2018
// Simulates dice rolling

import java.util.Random;

public class DiceRolling{
   //instance variables
   private static int[] rollSums = new int[13];

   //main method
   public static void main (String[] args){
      Random random = new Random();
	  int roll1, roll2, sum = 0;
	  
	  for (int i=0; i<36_000_000; i++){
	     roll1 = 1 + random.nextInt(6);
		 roll2 = 1 + random.nextInt(6);
		 sum = roll1 + roll2;		 
		 for (int j=2; j<=12; j++){
		    if (sum == j){
			   rollSums[j]++;
			   break;
			}
		 }
	  }
	  displayResult();
   } //end main
   
   //display the sums' frequency
   public static void displayResult(){
      System.out.printf("Sums   Frequency%n");
	  for (int i = 2; i <= 12; i++){
	     System.out.printf("%3d     %5d%n", i, rollSums[i]);
	  }
   }//end displayResult()
} //end class