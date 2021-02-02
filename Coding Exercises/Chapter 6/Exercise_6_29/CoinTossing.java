//CoinTossing.java by Vannel 5/5/18
//Simulates coin tossing

import java.util.Scanner;
import java.security.SecureRandom;

public class CoinTossing
{
    private static final SecureRandom randomNumbers = new SecureRandom();
	
	private enum Sides {HEADS, TAILS};
	
    public static void main ( String[] args )
	{
	    byte choice;
		Sides side;
		int countHead = 0, countTail = 0;
	    Scanner input = new Scanner (System.in);
		
		System.out.println("\nMenu");
		System.out.println("1) Toss Coin");
		System.out.println("2) Quit");
		
		do
		{
		    System.out.print("\nSelect an option (1 or 2) > ");
		    choice = input.nextByte();
		} while ( choice != 1 && choice != 2 );
		
		while ( choice == 1 )
		{		
		    side = flip();
			System.out.printf("Output: %s%n", side);
			
			if ( side == Sides.HEADS )
			    countHead++;
			else
			    countTail++;
		    
			System.out.println("\nMenu");
			System.out.println("1) Toss Coin");
			System.out.println("2) Quit");
			
			do
			{
				System.out.print("\nSelect an option (1 or 2) > ");
				choice = input.nextByte();
			} while ( choice != 1 && choice != 2 );
        }
		
		if ( countHead != 0 || countTail != 0 )
		    System.out.printf("%nResult > HEADS: %d | TAILS: %d%n", countHead, countTail);
        
		System.out.println("\nThank you!");		
	}
	
	private static Sides flip()
	{
	    int side = 1 + randomNumbers.nextInt(2);
		if ( side == 1 )
		    return Sides.HEADS;
		else
		    return Sides.TAILS;
	}	
}