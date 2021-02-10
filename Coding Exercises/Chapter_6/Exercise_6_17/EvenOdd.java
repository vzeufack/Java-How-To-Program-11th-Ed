//EvenOdd.java by Vannel 4/4/18
//Determines if an integer is even or odd

import java.util.Scanner;

public class EvenOdd
{
    public static void main (String [] args)
	{
	    Scanner input = new Scanner (System.in);
		int num;
		String sentinel = "y";
		
		while ( sentinel.equalsIgnoreCase("y") )
		{
			System.out.print("Enter an integer > ");
			num = input.nextInt();
			if ( isEven(num) )
				System.out.printf("%d is even%n", num);
			else
				System.out.printf("%d is odd%n", num);
			do
			{
				System.out.print("\nEnter 'y' to check another number, 'n' to stop > ");
				sentinel = input.next();
			}while (!sentinel.equalsIgnoreCase("y") && !sentinel.equalsIgnoreCase("n"));
		}
		System.out.println("\nThank you!");
	} 
	
	public static boolean isEven (int num)
	{
	    if (num%2 == 0)
		    return true;
		else
		    return false;
	}
	
}