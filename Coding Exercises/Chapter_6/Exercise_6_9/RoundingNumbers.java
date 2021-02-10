//RoundingNumbers.java by Vannel Zeufack 3/26/18
//Round values to the nearest integer

import java.util.Scanner;

public class RoundingNumbers
{
    public static void main (String[] args)
	{
	    double number;
		double roundedNumber;
		
		Scanner input = new Scanner (System.in);
		
	    System.out.print("Enter a number > ");
		number = input.nextDouble();
		roundedNumber = Math.floor( number + 0.5 );
		System.out.printf("%.2f ~ %.2f%n", number, roundedNumber);
	}
}