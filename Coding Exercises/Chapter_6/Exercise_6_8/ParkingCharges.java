//ParkingCharges By Vannel 3/21/2018
//Computes the parking charge for each customer

import java.util.Scanner;

public class ParkingCharges{
   public static void main( String[] args ){
	   Scanner input = new Scanner( System.in );
		double parkingHours;
		double charge;
		
		do{
	      System.out.print( "Enter the parking hours of the customer > " );
	      parkingHours = input.nextDouble();	
		
		   if( parkingHours <= 0 || parkingHours > 24 )
		      System.out.println( "The parking hours for a customer cannot be negative or be zero or exceed 24 hours. Please try again! " );	
				
	   } while( parkingHours <= 0 || parkingHours > 24 );
		
		charge = calculateCharges( parkingHours );
		displayRunningTotal( parkingHours );
	}
	
	private static double calculateCharges ( double parkingHours ){		
	    if ( parkingHours > 0 && parkingHours <= 3 )
		    return 2.0;
		else
		    return (2 + 0.5 * ( Math.ceil( parkingHours ) - 3 )) ;
	}
	
	private static void displayRunningTotal ( double parkingHours ){
	   int additionalHours = (int) Math.ceil( parkingHours - 3.0 );
		double totalCharges = calculateCharges ( parkingHours );
		
	   System.out.println("\nParking charges for the customer\n");
		System.out.println("- Total parking hours: " + parkingHours);
		System.out.println("- Charges for the first 3 hours or less: $2");
		if ( parkingHours > 3 )
		{    
		    if ( parkingHours == (int) parkingHours )
			{
		        System.out.printf( "- Hours in excess of the first 3h: %d%n", (int)(parkingHours - 3 ) );
			    System.out.printf( "- Charges for the additional hours: %d * 0.5 = $%.1f%n", (int)( parkingHours - 3.0 ) ,( additionalHours * 0.5 ) );
			}
			else
			{
			    System.out.printf( "- Hours in excess of the first 3h: %.1f hour(s) Counted as %d hour(s)%n", (parkingHours - 3 ),  additionalHours);
			    System.out.printf( "- Charges for the additional hours: %d * 0.5 = $%.1f%n", additionalHours ,( additionalHours * 0.5 ) );
			}
			System.out.println( "\nTotal Charges: $2 + $" + ( additionalHours * 0.5 ) + " = $" + totalCharges );
			
			if ( totalCharges > 10 )
			{
			    System.out.println("\nAs a customer reward, we do not charge more than $10 per day.\n");
				System.out.println("Final Total Charges: $10");
			}
		} 
		else
		{
		    System.out.println( "\nTotal Charges: $2" );
		}
		System.out.println("\nThank you!");
	}	
}