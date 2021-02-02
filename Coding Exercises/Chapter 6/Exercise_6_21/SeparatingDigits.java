//SeparatingDigits.java by Vannel 4/5/18
//Displays separated digits of any given integer between 1 to 99999

import java.util.Scanner;

public class SeparatingDigits
{
    public static void main (String[] args)
	{
	    Scanner input = new Scanner (System.in);
		int num;
		
		do
		{
		   System.out.print("Enter an integer between 1 and 99999 > ");
		   num = input.nextInt();
		} while (num < 1 || num > 99999 );
		
        displayDigits ( num );		
	}
	
	private static int quotientIntegerPart( int a, int b)
	{
	    return a/b;
	}
	
	private static int remainder( int a, int b)
	{
	    return a%b;
	}
	
	private static void displayDigits( int num )
	{		
	    int divisor = 10000;
		
	    for ( int i = 0; i < 5; i++ )
        {
		    if ( quotientIntegerPart(num,divisor) != 0 )
			    System.out.print( remainder(quotientIntegerPart(num,divisor),10) + "  ");
			divisor /= 10;
        }		
	}
	
}