/*
 * DuplicateElimination.java
 * Removes duplicates from an array of five integers between 10 - 100
 * By Vannel June 29, 2018
 */
 
 import java.util.Scanner;
 
 public class DuplicateElimination
 {
    private static int availablePosition = 1;
	
	/*
	 * main method
	 */
    public static void main (String [] args)
	{
		int[] numbers = new int[5];
		int input;
		
		input = inputNumber();
		numbers[0] = input;
		System.out.printf("Current state of array: %d%n", numbers[0]);
		
		for (int i = 1; i < 5; i++)
		{ 
		   input = inputNumber();       
		   fillArray(input, numbers);
		   printArrayStateMessage (i,numbers);
			  
		   for (int k = 0; k < availablePosition && numbers[k] != 0; k++)
		   {
			   System.out.printf("%d ", numbers[k]);
		   }			
	   
		   System.out.println();
		}
	} 
	
	/*
	 * inputNumber method
	 * inputs a number from the CMD
	 */	 
	private static int inputNumber()
	{
	   Scanner scan = new Scanner(System.in);
	   int input;
	   do
	   {
		  System.out.print("Enter an integer between 10 - 100 > ");
		  input = scan.nextInt();
	   }while (input < 10 || input > 100);
	   return input;
	}
	
	/*
	 * fillArray method
	 * insert input into array avoiding duplicates
	 * @param input - the input
	 * @param int[] numbers - the array of numbers
	 */
	private static void fillArray(int input, int [] numbers)
	{
	   boolean duplicated = false;
	   for (int j = availablePosition; j >= 0 && !duplicated; j--)
	   {
		   if (numbers[j] == input)
		   {
			  System.out.printf("Duplicate entry%n");
			  duplicated = true;
		   }
	   } 
	   
	   if (duplicated)
	   {
		  duplicated = false;
	   }
	   else
	   {
		   numbers[availablePosition] = input;
		   availablePosition++;
	   }
	}
	
	/*
	 * arrayStateMessage method
	 * prints intro message for the state of the array
	 * @param i - the current iteration
	 * @param int[] numbers - the array of numbers
	 */
	private static void printArrayStateMessage( int i, int[] numbers)
	{
	   if (i != numbers.length-1)
	   {
		  System.out.printf("Current state of array: ");
	   }
	   else
	   {
		  System.out.printf("%nFinal state of array: ");
	   }
	}
 }