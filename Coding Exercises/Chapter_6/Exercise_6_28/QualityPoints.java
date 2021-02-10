//QualityPoints.java By Vannel 5/3/18
//Returns 1,2,3 or 4 depending on the range of the student's grade

import java.util.Scanner;

public class QualityPoints
{
    public static void main (String [] args)
	{
	    double grade;
	    Scanner input = new Scanner (System.in);
		
		do
		{
		    System.out.print("Enter a student's grade (0 - 100) > ");
		    grade = input.nextDouble();
		} while (grade < 0 || grade > 100 );
		
		System.out.printf("His quality points is %d%n", qualityPoints(grade) );
		
	}
	
	private static int qualityPoints ( double grade )
	{
	    if ( grade >= 90 && grade <= 100 )
		    return 4;
		else if ( grade >= 80 )
		    return 3;
		else if ( grade >= 70 )
		    return 2;
		else if ( grade >= 60 )
		    return 1;
		else 
		    return 0;
		
	}
}
