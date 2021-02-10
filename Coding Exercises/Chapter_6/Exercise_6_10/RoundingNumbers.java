//RoundingNumbers.java by Vannel Zeufack 3/26/18
//Round numbers

import java.util.Scanner;

public class RoundingNumbers
{
    public static void main (String[] args)
	{
	    double number;
		
		Scanner input = new Scanner (System.in);
		
		System.out.print("Enter a number > ");
		number = input.nextDouble();
		System.out.printf("Rounded to the nearest integer: %f ~ %d%n", number, roundToInteger(number));
		System.out.printf("Rounded to the nearest tenth: %f ~ %.1f%n", number, roundToTenths(number));
		System.out.printf("Rounded to the nearest hundredth: %f ~ %.2f%n", number, roundToHundredths(number));
		System.out.printf("Rounded to the nearest thousandth: %f ~ %.3f%n", number, roundToThousandths(number));		
	}
	
	public static int roundToInteger( double number )
	{
	    return (int) Math.floor(number + 0.5);
	}
	
	public static double roundToTenths( double number )
	{
	    return (Math.floor(number * 10 + 0.5) / 10);
	}
	
	public static double roundToHundredths( double number )
	{
	    return (Math.floor(number * 100 + 0.5) / 100);
	}
	
	public static double roundToThousandths( double number )
	{
	    return (Math.floor(number * 1000 + 0.5) / 1000);
	}
}