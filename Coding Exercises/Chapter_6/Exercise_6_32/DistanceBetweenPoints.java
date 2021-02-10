//DistanceBetweenPoints.java by Vannel 5/5/2018
//Computes the distance between two points

import java.util.Scanner;

public class DistanceBetweenPoints
{
    public static void main (String [] args)
	{
	    Scanner input = new Scanner (System.in);
		double x1,y1,x2,y2;
		
		System.out.print("Enter the x coordinate of the 1st point > ");
		x1 = input.nextDouble();
		System.out.print("Enter the y coordinate of the 1st point > ");
		y1 = input.nextDouble();
		System.out.print("Enter the x coordinate of the 2nd point > ");
		x2 = input.nextDouble();
		System.out.print("Enter the y coordinate of the 2nd point > ");
		y2 = input.nextDouble();
		System.out.printf("Distance = %.5f SI%n", distance(x1,y1,x2,y2) );
	}
	
	private static double distance (double x1, double y1, double x2, double y2)
	{
	    double distance = Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2));
		return distance;
	}
}