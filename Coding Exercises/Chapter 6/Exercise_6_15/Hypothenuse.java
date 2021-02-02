//Hypothenuse.java by Vannel 4/3/18
//Computes the Hypothenuse of a triangle given side1 and side2

import java.util.Scanner;

public class Hypothenuse
{
    public static void main (String[] args)
	{
	    Scanner input = new Scanner (System.in);
		double side1,side2;
		
		do
		{
		    System.out.print("Enter the value of side 1 > ");
		    side1 = input.nextDouble();
	    }while (side1 <= 0);
		
		do
		{
		    System.out.print("Enter the value of side 2 > ");
		    side2 = input.nextDouble();
	    }while (side2 <= 0);
		
		System.out.printf("Hypothenuse = %.2f%n", hypothenuse(side1,side2));
		System.out.printf("Using the Math class, Hypothenuse = %.2f%n", Math.hypot(side1,side2));
	}
	
	public static double hypothenuse(double side1, double side2)
	{
	    return Math.sqrt( Math.pow(side1,2) + Math.pow(side2,2) );
	}
}