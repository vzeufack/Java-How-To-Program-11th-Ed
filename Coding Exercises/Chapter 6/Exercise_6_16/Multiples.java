//Multiples.java by Vannel 4/3/18
//Check if an integer is a multiple of another one

import java.util.Scanner;

public class Multiples
{
    public static void main (String[] args)
	{
	    Scanner input = new Scanner (System.in);
		int num1, num2;
		String sentinel = "y";
		
		while ( sentinel.equalsIgnoreCase("y") )
		{
			System.out.print("Enter the 1st number > ");
			num1 = input.nextInt();
			
			do
			{
				System.out.print("Enter the 2nd number > ");
				num2 = input.nextInt();
				if (num2 == 0)
					System.out.println("No number is divisible by 0. Please try again!");
			}while (num2 == 0);
			
			if ( isMultiple(num1,num2) )
				System.out.printf("%d is a multiple of %d%n", num1, num2);
			else
				System.out.printf("%d is not a multiple of %d%n", num1, num2);
			
			do
			{
				System.out.print("\nDo you want to check two others numbers? (Enter 'y' for yes or 'n' to stop) > ");
				sentinel = input.next();
			}while (!sentinel.equalsIgnoreCase("y") && !sentinel.equalsIgnoreCase("n") );
		}
		
		System.out.println("\nThank you!");
	}
	
	//returns true if num1 is a multiple of num2, false otherwise
	public static boolean isMultiple( int num1, int num2 )
    {
	   if (num1%num2 == 0)
	       return true;
	   else
	       return false;
    }	
}
