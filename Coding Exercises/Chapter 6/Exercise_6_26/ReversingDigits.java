//ReversingDigits.java by Vannel 4/20/2018
//Reverse digits of a given integer

import java.util.Scanner;

public class ReversingDigits
{
    public static void main (String [] args)
	{
	    Scanner input = new Scanner (System.in);
		int number;
		
		System.out.print("Enter an integer > ");
		
		number = input.nextInt();
		System.out.println( reverse(number) );
		
	}
	
	public static int reverse (int number)
	{
	    int n;
		String reversedString;
		
	    if ( number < 0 )
		{
		    n = Math.abs(number);
			reversedString = "-";
		}
		else
		{
		    n = number;
			reversedString = "";
		}
	    
		reversedString += n%10;
		int divisor = 10;
		
		while ( n/divisor != 0 )
		{
		    reversedString += (n/divisor)%10;
			divisor *= 10;
		}
		
		return Integer.parseInt(reversedString);
	}
}