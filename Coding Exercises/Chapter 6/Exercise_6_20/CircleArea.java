//CircleArea.java by Vannel 4/4/18
//Computes the area of a circle

import java.util.Scanner;

public class CircleArea
{
    public static void main (String[] args)
	{
	    Scanner input = new Scanner (System.in);
		
		System.out.print("Enter the radius > ");
		double radius = input.nextDouble();
		System.out.printf("The area of the circle of radius %.2f is %.2f%n", radius, circleArea(radius));
	}
	
	public static double circleArea (double radius)
	{
	    return (Math.PI * Math.pow(radius,2));
	}
}
