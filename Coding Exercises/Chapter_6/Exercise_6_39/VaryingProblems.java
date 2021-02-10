//VaryingProblems.java by Vannel 5/13/2018
//Allow a student to pick a type of arithmetic problem to study

import java.util.Scanner;
import java.security.SecureRandom;

public class VaryingProblems
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
	private static int problemType;
	
    public static void main (String [] args)
	{	
	    displayMainMenu();
	    inputProblemType();
		
	    while ( problemType != -1 )
		{			
		    displayDifficultyMenu();
			inputDifficulty();	
			
			while ( difficultyLevel != -1 )
			{		    
				question = generateQuestion( difficultyLevel, problemType );
				
				while (trials < maxTrialsPerStudent)
				{
					System.out.print(question);
					answer = input.nextDouble();
					trials++;
					if ( answer == correctAnswer )
					{
						question = generateQuestion( difficultyLevel, problemType );
						System.out.println(generateResponse(1) + "\n"); // 1 -> correct answer
						countTrue++;
					}
					else
					{				    
						System.out.println(generateResponse(2) + "\n"); // 2 -> wrong answer
						countFalse++;
					}
				}				
				monitorStudentPerformance();
                displayDifficultyMenu();				
				inputDifficulty();
			}	
			displayMainMenu();
            inputProblemType();		
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
	private static String generateQuestion( double difficultyLevel, int problemType )
	{
	    int num1, num2; 
		char operator = '0';
		int problemChoice = problemType;
		
		if ( problemChoice == 5 )
		    problemChoice = 1 + randomNumberGenerator.nextInt(4);
		
	    num1 = randomNumberGenerator.nextInt((int)Math.pow(10, difficultyLevel));
		
		if ( problemChoice == 4)
		    num2 = 1 + randomNumberGenerator.nextInt((int)Math.pow(10, difficultyLevel) - 1);
		else
		    num2 = randomNumberGenerator.nextInt((int)Math.pow(10, difficultyLevel));
		
		switch ( problemChoice )
		{
		    case 1:
		        operator = '+'; correctAnswer = num1 + num2; break;
			case 2: 
			    operator = '-'; correctAnswer = num1 - num2; break;
			case 3:
			    operator = 'x'; correctAnswer = num1 * num2; break;
			case 4:
			    operator = '/'; correctAnswer = num1 / num2; break;
		}
		
		return String.format("How much is %d %c %d > ", num1, operator, num2);
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
			System.out.print("\nEnter a difficulty level (enter -1 to return to the main menu) > ");
			difficultyLevel = input.nextDouble();
			if ( difficultyLevel < 1 && difficultyLevel != -1 )
				System.out.println("Invalid difficulty level. Value must be an integer greater or equal to 1!");
		} while (difficultyLevel < 1 && difficultyLevel != -1);
		System.out.println();
		answer = 0;
	}
	
	//Input the problemType
	private static void inputProblemType()
	{
	    do
		{
			System.out.print("\nEnter the problem type (enter -1 to stop) > ");
			problemType = input.nextInt();
			if ((problemType < 1 || problemType > 5) && problemType != -1 )
			    System.out.println("Invalid problem type. Value must be 1,2,3,4 or 5. Please try again!");
		} while ((problemType < 1 || problemType > 5) && problemType != -1 );
	}
	
	private static void displayMainMenu()
	{
	    System.out.println();
	    System.out.println("\tBasic Arithmetic Evaluator\n");
		System.out.println("Please select one of the problem types below");
		System.out.println("1. Addition problems");
		System.out.println("2. Substraction problems");
		System.out.println("3. Multiplication problems");
		System.out.println("4. Division problems (Only the integer part of the answer is considered)");
		System.out.println("5. A random mixture of all the four problem types");
	}
	
	private static void displayDifficultyMenu()
	{
	    //System.out.println();
	    System.out.println("\nDifficulty Levels:");
		System.out.println("1. At most one-digit number problems");
		System.out.println("2. At most two-digit number problems");
		System.out.println("3. At most three-digit number problems");
		System.out.println("...");
		System.out.println("Note: you will be evaluated after 10 answers");
	}
}