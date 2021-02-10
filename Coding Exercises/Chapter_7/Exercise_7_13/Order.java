/*
 * Order class
 * determines the order in which the elements of array sales are set to 0
 * By Vannel June 30, 2018
 */

public class Order
{
   /*
    * main method
	*/
   public static void main (String[] args)
   {
      int[][] sales = new int[3][5];
	  int current = 0;
	  
      for (int row = 0; row < sales.length; row++)
	  {
	     for (int col = 0; col < sales[row].length; col++){
		    System.out.printf("%2d--", current++);
		    sales[row][col] = 0;
			System.out.printf("%d |", sales[row][col]);
		 }
		 System.out.println();
	  }
   }
}
