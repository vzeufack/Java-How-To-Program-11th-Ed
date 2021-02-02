//GuessTheNumber.java by Vannel 5/5/2018
//A player guess a number randomly generated

import java.util.Scanner;
import java.security.SecureRandom;

public class GuessTheNumber
{
    public static void main (String [] args)
	{
	    int guess, numberToBeGuessed, countGuesses = 0;
	    SecureRandom randomNumberGenerator = new SecureRandom();
		Scanner input = new Scanner (System.in);
		
		System.out.println("\nGenerating a random number between 1 - 1000 ...");
		numberToBeGuessed = 1 + randomNumberGenerator.nextInt(1000);		
		System.out.println("Number generated!\n");		
		
		do
		{
			System.out.print("Guess the number (1 - 1000) > ");
			guess = input.nextInt();
		} while (guess < 1 || guess > 1000 );
		
		countGuesses++;
			
		while ( guess != numberToBeGuessed )
		{
			if ( guess > numberToBeGuessed )
				System.out.print("Too high. Try again > ");
			else
				System.out.print("Too low. Try again > ");
			
			do
			{
			    System.out.print("Guess the number (1 - 1000) > ");
				guess = input.nextInt();
			} while (guess < 1 || guess > 1000 );
			
			countGuesses++;
		}
		
		System.out.println("\nCongratulations. You guessed the number!");
		//System.out.println();
		displayNumberOfGuesses( countGuesses );
	}
	
	private static void displayNumberOfGuesses (int numberOfGuesses )
	{
	    if (numberOfGuesses == 10)
		    System.out.printf("Aha! you know the secret! You found the number after %d guesses%n", numberOfGuesses);
		else if (numberOfGuesses < 10)
		    System.out.printf("You found the number after %d guesses. Either you know the secret or you got lucky!%n", numberOfGuesses);
		else
		    System.out.printf("You found the number after %d guesses. You should be able to do better%n", numberOfGuesses);
	}
}