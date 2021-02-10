//CaiStudentPerformance.java by Vannel 5/8/2018
//Assesses the student's performance on one-digit number multiplication

import java.util.Scanner;
import java.security.SecureRandom;

public class CaiStudentPerformance
{
    private static int correctAnswer;
	private static SecureRandom randomNumberGenerator = new SecureRandom();
	private static int countTrue = 0;
	private static int countFalse = 0;
	private static int trials = 0;
	private static final int maxTrialsPerStudent = 10;
	
    public static void main (String [] args)
	{	    
		Scanner input = new Scanner(System.in);
		
		int answer;
		String question;
		
		question = generateQuestion();
		System.out.println();
		
		do
		{				
			do
			{
				System.out.print(question);
				answer = input.nextInt();
				if ( answer != correctAnswer && answer != -1 )
				{
					System.out.println(generateResponse(2) + "\n");
					countFalse++;
					trials++;
				}
			}while ( answer != correctAnswer && answer != -1 && trials != maxTrialsPerStudent  );
			
			if ( answer == correctAnswer )
			{
			    System.out.println(generateResponse(1) + "\n");
				question = generateQuestion();
				countTrue++;
				trials++;
			}
			
			if ( trials == maxTrialsPerStudent )
			{
				monitorStudentPerformance();
			}
		} while ( answer != -1 );
		
		System.out.println("\nThank you!");
	}
	
	//Outputs the success percentage of each student after 10 trials
	private static void monitorStudentPerformance()
	{
	    double successPercentage = (countTrue/(double)maxTrialsPerStudent)*100;
		System.out.printf("You got %d correct answer(s) and %d wrong answer(s)\nYour success percentage is %.2f%%%n%n", countTrue, countFalse, successPercentage);
		if (successPercentage < 75)
			System.out.println("Please ask your teacher for extra help.");
		else
			System.out.println("Congratulations, you are ready to go to the next level!\n");
		
		System.out.println("\nGenerating a new set of questions ...\n");
		countTrue = 0;
		countFalse = 0;
		trials = 0;
	}
	
	//Generates a new question
	private static String generateQuestion()
	{
	    int num1 = randomNumberGenerator.nextInt(10);
		int num2 = randomNumberGenerator.nextInt(10);
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