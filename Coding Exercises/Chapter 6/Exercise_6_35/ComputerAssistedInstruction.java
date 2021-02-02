//ComputerAssistedInstruction.java by Vannel 5/7/2018
//This program generated two random one-digit integer and request the user to enter the result of their multiplication

import java.util.Scanner;
import java.security.SecureRandom;

public class ComputerAssistedInstruction
{
	private static int correctAnswer;
	private static SecureRandom randomNumberGenerator = new SecureRandom();
	
    public static void main (String [] args)
	{	    
		Scanner input = new Scanner(System.in);
		
		int answer;
		String question;
		
		question = generateQuestion();
		
		do
		{				
			do
			{
				System.out.print(question);
				answer = input.nextInt();
				if ( answer != correctAnswer && answer != -1 )
					System.out.println(generateResponse(2));
			}while ( answer != correctAnswer && answer != -1 );
			
			if ( answer == correctAnswer )
			{
			    System.out.println(generateResponse(1));
				question = generateQuestion();
			}
		} while ( answer != -1 );
		
		System.out.println("\nThank you!");
	}
	
	private static String generateQuestion()
	{
	    int num1 = randomNumberGenerator.nextInt(10);
		int num2 = randomNumberGenerator.nextInt(10);
		correctAnswer = num1 * num2;
		return String.format("How much is %d x %d (enter -1 to stop) > ", num1,num2);
	}
	
	private static String generateResponse( int answerType )
	{
	    int randomAnswer = 1 + randomNumberGenerator.nextInt(4);
		
	    if (answerType == 1) //correct answer
		{
		    switch(randomAnswer)
			{
			    case 1: return "Very good!";
				case 2: return "Excellent!";
				case 3: return "Nice work!";
				case 4: return "Keep up the good work!";
			}
		}
		else
		{
		    switch(randomAnswer)
			{
			    case 1: return "No. Please Try again.";
				case 2: return "Wrong. Try once more.";
				case 3: return "Don't give up!";
				case 4: return "No. Keep trying.";
			}
		}
		return "";
	}
}