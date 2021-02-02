//TemperatureConversions.java by Vannel 4/5/18
//Allow conversion from degree to Farenheit and vice versa

import java.util.Scanner;

public class TemperatureConversions
{
    public static void main (String[] args)
	{
	    Scanner input = new Scanner (System.in);
		int choice;
		double temperature;
		
		System.out.println("\n1. Convert from celcius to fahrenheit");
		System.out.println("2. Convert from fahrenheit to celcius");
		System.out.println("3. Terminate\n");
		do
		{
		    System.out.print("Enter 1,2 or 3 > ");
		    choice = input.nextInt();
		} while ( choice < 1 || choice > 3 );
		
		switch ( choice )
		{
		    case 1:
                System.out.print("Enter the tempature value in celcius > ");
                temperature = input.nextDouble();	
                System.out.printf("%.2f\u00b0C = %.2f\u00b0F%n", temperature, fahrenheit(temperature));				
			    break;
			case 2:
                System.out.print("Enter the tempature value in fahrenheit > ");
                temperature = input.nextDouble();	
                System.out.printf("%.2f\u00b0F = %.2f\u00b0C%n", temperature, celcius(temperature));				
			    break;
		}
		System.out.println("\nThank you!");	    
	}
	
	private static double fahrenheit ( double celcius )
	{
	    return 9.0 / 5.0 * celcius + 32;
	}
	
	private static double celcius ( double fahrenheit )
	{
	    return (5.0 / 9.0) * ( fahrenheit - 32 );
	}
}