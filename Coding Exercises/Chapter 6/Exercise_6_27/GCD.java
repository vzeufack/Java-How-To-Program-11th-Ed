//GCD.java by Vannel 4/20/2018
//Computes the Greatest Common Divisor of two integers

import java.util.Scanner;

public class GCD
{
    public static void main (String [] args)
	{
	    Scanner input = new Scanner (System.in);
		int a,b;
		System.out.print("Enter two integers > ");
		a = input.nextInt();
		b = input.nextInt();
		int gcd1 = gcd (a, b);
		int gcd2 = gcd2 (a, b);
		
		if ( gcd1 == 0 )
		    System.out.println("GCD(0,0) = Infinity");
		else
	        System.out.printf( "GCD(%d,%d) = %d%n", a, b, gcd (a, b) );
			
		if ( gcd2 == 0 )
		    System.out.println("GCD(0,0) = Infinity");
		else
	        System.out.printf( "GCD(%d,%d) = %d%n", a, b, gcd2 (a, b) );
	}
	
	public static int gcd (int a, int b)
	{
	    int min = a;
	    int max = b;
		
		if ( a > b )
		{
		    min = b;
			max = a;
		}
		
		if ( min == 0 && max == 0 )
		    return 0;
		else if ( min == 0)
		{
		    return Math.abs(max);	
		}
		else if ( max == 0 )
		{
		    return Math.abs(min);
		}
		else if ( min == max || max%min == 0)
		    return min;
		else
		{
		    int remainder = max%min;
		    while ( remainder > 0 )
			{
			    max = min;
				min = remainder;
				if (max%min == 0)
				    break;
				remainder = max%min;
			}
			return remainder;
		}
	}
	
	public static int gcd2 (int a, int b)
	{
	    int min = a;
	    int max = b;
		
		if ( a > b )
		{
		    min = b;
			max = a;
		}
		
		if ( min == 0 && max == 0 )
		    return 0;
		else if ( min == 0)
		{
		    return Math.abs(max);	
		}
		else if ( max == 0 )
		{
		    return Math.abs(min);
		}
		if ( min == max || max%min == 0 )
		    return min;
		else
        {		
			for (int i = min/2; i >= 2 ; i--)
			{
				if (min%i == 0 && max%i == 0)
					return i;
			}
			return 1;
		}
	}
}