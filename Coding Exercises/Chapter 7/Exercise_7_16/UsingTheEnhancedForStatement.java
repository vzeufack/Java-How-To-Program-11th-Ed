// UsingTheEnhancedForStatement.java By Vannel June 30, 2018
// Uses the enhanced for statement to sum double values passed by the command-line arguments

public class UsingTheEnhancedForStatement{
   // main method
   public static void main( String[] args){
      double sum = 0.0;
	  
	  if (args.length != 0){
		  for (String num: args){
			sum += Double.parseDouble(num);
		  }
		  System.out.printf("Sum = %f%n", sum);
	  }
	  else{
	      System.out.printf("No arguments entered!%n", sum);
	  }
   }
}