//SquareOfCharacters.java by Vannel 4/4/18
//Build a square of characters given an integer as the side of the square

import java.util.Scanner;

public class SquareOfCharacters
{
    public static void main (String[] args)
	{
	    Scanner input = new Scanner (System.in);
		int side;
		char fillCharacter;
		
	    do
		{
			System.out.print("Enter the value of the square side > ");
			side = input.nextInt();
			if (side <= 0)
			    System.out.println("The side should be a positive nonzero integer. Please try again!\n");
		}while (side <= 0);
		
		System.out.print("Enter the fill character > ");
		fillCharacter = input.next().charAt(0);
		
		squareOfAsterisks(side, fillCharacter);
	}
	
	private static void squareOfAsterisks(int side, char fillCharacter)
	{
	    for (int j=0; j < side; j++)
		{
			for (int i=0; i < side; i++)
			{
				System.out.print(fillCharacter);
			}
			System.out.println();
		}
	}
	
}