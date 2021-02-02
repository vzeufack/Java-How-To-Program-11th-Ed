//SquareOfAsterisks.java by Vannel 4/4/18
//Build a square of asterisks given an integer as the side of the square

import java.util.Scanner;

public class SquareOfAsterisks
{
    public static void main (String[] args)
	{
	    Scanner input = new Scanner (System.in);
		int side;
		
	    do
		{
			System.out.print("Enter the value of the square side > ");
			side = input.nextInt();
			if (side <= 0)
			    System.out.println("The side should be a positive nonzero integer. Please try again!\n");
		}while (side <= 0);
		
		squareOfAsterisks(side);
	}
	
	private static void squareOfAsterisks(int side)
	{
	    for (int j=0; j < side; j++)
		{
			for (int i=0; i < side; i++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}	
}