//BinaryOctalHexTable.java by Vannel 5/5/2018
//Displays the a table of binary, octal and hexadecimal equivalents of the decimal numbers
//in the range 1 - 256

public class BinaryOctalHexTable
{
    public static void main (String[] args)
	{		
	    System.out.println("Format -> Value: binary | Octal | Hexadecimal");
	    for (int i = 1; i <= 256; i++)
		{
		    System.out.printf("%d: %s | %s | %s%n", i, convertIntoBinary(i), convertIntoOctal(i), convertIntoHexadecimal(i));
		}
	}
	
	//Convert a decimal number into binary
	public static String convertIntoBinary (int number)
	{
	    String result = "";
	    int quotient = number/2;
		int remainder = number%2;
		
		result += remainder;
				
	    while (quotient > 1)
		{
		    remainder = quotient%2;
			result += remainder;
		    quotient = quotient/2;            			
		}
		
		if (quotient == 1)
		    result += quotient;
			
		return reverse(result);
	}
	
	//Convert a decimal number into octal
	public static String convertIntoOctal (int number)
	{
	    String result = "";
	    int quotient = number/8;
		int remainder = number%8;
		
		result += remainder;
				
	    while (quotient > 1)
		{
		    remainder = quotient%8;
			result += remainder;
		    quotient = quotient/8;            			
		}
		
		if (quotient == 1)
		    result += quotient;
			
		return reverse(result);
	}
	
	//Convert a decimal number into hexadecimal
	public static String convertIntoHexadecimal (int number)
	{
	    String result = "";
	    int quotient = number/16;
		int remainder = number%16;
		
		result += hexadecimalCharacter(remainder);
				
	    while (quotient > 1)
		{
		    remainder = quotient%16;
			result += hexadecimalCharacter(remainder);
		    quotient = quotient/16;            			
		}
		
		if (quotient == 1)
		    result += quotient;
			
		return reverse(result);
	}
	
	//Reverse a word
	public static String reverse ( String word )
	{
	    String reversedString = "";
	    for (int i = word.length() - 1; i >= 0; i--)
		{
		    reversedString += word.charAt(i);
		}
		return reversedString;
	}
	
	//returns the hexadecimal character value of a number
	private static String hexadecimalCharacter (int value)
	{
	    switch (value)
		{
		    case 10: return "A";
			case 11: return "B";
			case 12: return "C";
			case 13: return "D";
			case 14: return "E";
			case 15: return "F";
			default: return String.valueOf(value);			
		}
	}
}