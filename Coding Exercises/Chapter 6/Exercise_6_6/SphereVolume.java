//Exercise_6_6
//Computes the volume of a sphere given the radius

import java.util.Scanner;

public class SphereVolume{
   public static void main( String[] args ){
	   Scanner scan = new Scanner( System.in );
		double radius = 0.0;
		
	   System.out.print("Enter the radius > ");
		radius = scan.nextDouble();
		System.out.printf( "The volume of the sphere of radius %.2f = %.2f%n", radius, sphereVolume(radius) );
	}
	
	public static double sphereVolume( double radius ){
	   double volume = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
		return volume;
	}
}