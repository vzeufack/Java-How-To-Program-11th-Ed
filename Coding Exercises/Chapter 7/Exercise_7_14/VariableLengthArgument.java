/*
 * VariableLengthArgument.java
 * Test variable argument lists
 * By Vannel June 30th, 2018
 */

public class VariableLengthArgument{

   public static void main (String[] args){
      int n1 = 1;
	  int n2 = 2;
	  int n3 = 3;
	  int n4 = 4;
	  
	  System.out.printf("n1 = %d%nn2 = %d%nn3 = %d%nn4 = %d%n%n", n1, n2, n3, n4);
	  System.out.printf("n1 * n2 = %d%n", product(n1,n2));
	  System.out.printf("n1 * n2 * n3 = %d%n", product(n1,n2,n3));
	  System.out.printf("n1 * n2 * n3 * n4 = %d%n", product(n1,n2,n3,n4));
	  System.out.printf("n1 * n3 * n4 = %d%n", product(n1,n3,n4));
	  System.out.printf("n2 * n3 * n4 = %d%n", product(n2,n3,n4));
	  System.out.printf("n2 * n4 = %d%n", product(n2,n4));
   }
   
   /*
    * product method
    * performs the product of an undertermined numbers of numbers
	*/
   public static int product (int... numbers){
      int result = 1;
	  
	  for (int p: numbers){
	     result *= p;
	  }
	  
	  return result;
   }
}