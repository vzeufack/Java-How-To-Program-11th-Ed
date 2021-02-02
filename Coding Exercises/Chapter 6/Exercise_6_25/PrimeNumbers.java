//PrimeNumbers.java by Vannel 4/19/2018
//Determines whether a number is prime or not

public class PrimeNumbers
{
    public static void main (String [] args)
	{
	    //I would test 9997 - 2 + 1 = 9996 numbers
	    for (int i = 2; i <= 200; i++)
		{
		    if ( isPrime(i) )
			    System.out.print( i + " " );
		}
		System.out.println("\n");
		for (int i = 2; i <= 200; i++)
		{
		    if ( isPrime2(i) )
			    System.out.print( i + " " );
		}
    }
	
	public static boolean isPrime (int number)
	{
		for (int i = 2; i <= Math.sqrt(number); i++)
		{
		    if (number%i == 0)
			    return false;
		}
		return true;
	}
	
	public static boolean isPrime2 (int number)
	{
	    for (int i = 2; i <= number/2; i++)
		{
		    if (number%i == 0)
			    return false;
		}
		return true;
	}
}