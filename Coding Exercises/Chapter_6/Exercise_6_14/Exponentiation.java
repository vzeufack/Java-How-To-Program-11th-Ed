//Exponentiation.java by Vannel 4/3/18
//Returns the value of base power exponent

import java.util.Scanner;

public class Exponentiation
{
    public static void main(String[] args)
	{
	    Scanner input = new Scanner (System.in);
		int base, exponent;
		
		System.out.print("Enter the base value > ");
		base = input.nextInt();
		do
		{
		    System.out.print("Enter the exponent value > ");
			exponent = input.nextInt();
			if (exponent <= 0)
			    System.out.println("Exponent should be a strictly positive integer. Please try again!");
		}while (exponent <= 0);
		System.out.printf("%d power %d = %d%n", base, exponent, integerPower(base, exponent));
	}
	
	public static int integerPower (int base, int exponent)
	{
	    if (base == 0)
		    return 0;
	    else
		{
			int result = 1;
			for (int i = 0; i < exponent; i++)
			{
			   result *= base;
			}
			return result;
		}
	}
}