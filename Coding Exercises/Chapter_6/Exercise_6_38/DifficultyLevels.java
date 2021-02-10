//DifficultyLevels.java by Vannel 5/9/2018
//Assess student's level at multiplication

import java.util.Scanner;
import java.security.SecureRandom;

public class DifficultyLevels
{
    private static long correctAnswer;
	private static SecureRandom randomNumberGenerator = new SecureRandom();
	private static int countTrue;
	private static int countFalse;
	private static int trials;
	private static final int maxTrialsPerStudent = 10;
	private static String question;
	private static double answer;
	private static double difficultyLevel;
	private static Scanner input = new Scanner(System.in);	
	
    public static void main (String [] args)
	{		
		inputDifficulty();
		
		while ( difficultyLevel != -1 )
		{		    
			question = generateQuestion( difficultyLevel );

            while (trials < maxTrialsPerStudent && answer != -1)
            {
			    System.out.print(question);
			    answer = input.nextDouble();
				if ( answer != -1 )
				{
					trials++;
					if ( answer == correctAnswer )
					{
						question = generateQuestion( difficultyLevel );
						System.out.println(generateResponse(1) + "\n"); // 2 -> wrong answer
						countTrue++;
					}
					else
					{				    
						System.out.println(generateResponse(2) + "\n"); // 2 -> wrong answer
						countFalse++;
					}
				}
            }            
			
			if (answer != -1)
			    monitorStudentPerformance();          
			
			inputDifficulty();			
		}
		System.out.println("\nThank you!");
	}
	
	//Outputs the success percentage of each student after 10 trials
	private static void monitorStudentPerformance()
	{
	    double successPercentage = (countTrue/(double)maxTrialsPerStudent)*100;
		System.out.printf("You got %d correct answer(s) and %d wrong answer(s)\nYour success percentage is %.2f%%%n", countTrue, countFalse, successPercentage);
		if (successPercentage < 75)
			System.out.println("Please ask your teacher for extra help.\n");
		else
			System.out.println("Congratulations, you are ready to go to the next level!\n");
		
		countTrue = 0;
		countFalse = 0;
		trials = 0;
	}
	
	//Generates a new question
	private static String generateQuestion( double difficultyLevel )
	{
	    int num1, num2; 
		
	    num1 = randomNumberGenerator.nextInt((int)Math.pow(10, difficultyLevel));
		num2 = randomNumberGenerator.nextInt((int)Math.pow(10, difficultyLevel));
		correctAnswer = num1 * num2;
		return String.format("How much is %d x %d (enter -1 to stop) > ", num1,num2);
	}
	
	//Generate response for student's answers
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
		else //wrong answer
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
	
	//Input the difficulty level
	private static void inputDifficulty()
	{
	    do
		{
			System.out.print("\nEnter a difficulty level (enter -1 to stop) > ");
			difficultyLevel = input.nextDouble();
			if ( difficultyLevel < 1 && difficultyLevel != -1 )
				System.out.println("Invalid difficulty level. Value must be an integer greater or equal to 1!");
		} while (difficultyLevel < 1 && difficultyLevel != -1);
		System.out.println();
		answer = 0;
	}
}