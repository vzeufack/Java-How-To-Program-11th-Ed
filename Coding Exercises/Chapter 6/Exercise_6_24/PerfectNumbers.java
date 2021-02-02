//PerfectNumbers.java by Vannel 4/11/2018
//Determine if a number is perfect or not

import java.util.Scanner;

public class PerfectNumbers
{
    public static void main (String [] args)
	{
	    for (int i = 2; i <= 10000; i++)
		{
		    isPerfect (i);
		}
	}
	
	private static void isPerfect (int number)
	{
		int sum = 1;
		String stringSum = "1";
		
	    for (int i = 2; i <= number/2; i++)
		{
		    if (number%i == 0)
			{
			    sum += i;
				stringSum += " + " + i;
			}
		}
		if ( sum == number )
		{
		    System.out.printf("%d is perfect: %s = %d%n", number, stringSum, sum);
		}		    
	}
}