/* 
 * By Vannel June, 28 2018
 * SalesCommission.java
 * Determines the number of salespersons in each salary range
 */
 
 public class SalesCommission
 {
     /*
	  * main method
	  */
     public static void main (String[] args)
	 {
	     int [] salaries = {200,315,412,599,650,720,100,804,299,100185,500,125,877,4169,321};
		 System.out.println();
		 displaySalaryTable(salaries);		 
	 }
	 
	 /*
	  * getSalaryRangeCounts method
	  * Counts and store the number of salesperson who earn a salary in a certain range.
	  * @param salaries - the array of salaries
	  * @return an array of counters
	  */
	 private static int[] getSalaryRangeCounts (int [] salaries)
	 {
	     int[] salaryRangeCounters = new int [11];
		 int truncatedSalary;
		 
		 for (int i = 0; i < salaries.length; i++)
		 {
		     truncatedSalary = salaries[i]/100;	
		     if (truncatedSalary < 2)
			 {
			     System.out.printf("Invalid salary value \"$%d\". Value will be skipped!%n", salaries[i]);
		     }
			 else if (truncatedSalary >= 10)
		     {
				    salaryRangeCounters[10]++;
			 }				 
			 else
			 {
				 for (int j = 2; j < salaryRangeCounters.length; j++)
				 {
					if (truncatedSalary == j)
					{
					  salaryRangeCounters[j]++;
					  break;
					}
				 }
			 }				 
		 }
		 return salaryRangeCounters;
	 }
	 
	 /*
	  * displaySalaryTable method
	  * Display the number of salesperson who earn a salary in a certain range.
	  * @param salaries - the array of salaries
	  */
	 private static void displaySalaryTable (int [] salaries)
	 {
	     int [] salaryRangeCounts = getSalaryRangeCounts (salaries);
		 
		 System.out.printf("%n         Range   Count%n");
		 
		 for (int i = 2; i < salaryRangeCounts.length - 1; i++)
		 {
		    System.out.printf("      $%3d-%3d   %5d%n", i*100, ((i+1)*100)-1,  salaryRangeCounts[i]);
		 }
		 System.out.printf("$1000 and over   %5d%n", salaryRangeCounts[10]);
	 }
 }
