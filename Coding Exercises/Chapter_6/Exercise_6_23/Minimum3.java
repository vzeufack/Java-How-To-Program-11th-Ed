//Minimum3.java By Vannel 4/8/18
//computes the minimum of 3 numbers

import java.util.Scanner;

public class Minimum3
{
    public static void main ( String [] args )
	{
	    Scanner input = new Scanner (System.in);
		double num1,num2,num3;
		
		System.out.print("Enter 3 numbers each separated by a space > ");
		num1 = input.nextDouble();
		num2 = input.nextDouble();
		num3 = input.nextDouble();
		System.out.printf("The minimum of %f %f %f is %f%n", num1,num2,num3,min(num1,num2,num3));
	}
	
	private static double min( double num1, double num2, double num3 )
	{
	    return Math.min (Math.min(num1, num2), num3);
	}
}