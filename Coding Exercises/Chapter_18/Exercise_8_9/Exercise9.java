/**
  * Recursive implementation of the power function
  */
public class Exercise9{
  public static void main (String [] args){
//    System.out.println(power(2,3));
//    System.out.println(power(3,4));
    solveTowers(3, 1, 3, 2);
  }

  private static void solveTowers(int disks, int sourcePeg, int destinationPeg, int tempPeg){
    if(disks == 1){
      System.out.printf("%d --> %d\n", sourcePeg, destinationPeg);
      return;
    }

    solveTowers(disks - 1, sourcePeg, tempPeg, destinationPeg);
    System.out.printf("%d --> %d\n", sourcePeg, destinationPeg);
    solveTowers(disks - 1, tempPeg, destinationPeg, sourcePeg);
  }
  
  /**
    * computes a power b recursively
    *
    * @param base: double
    *   the base
    *
    * @param exponent: int
    *   the exponent
    *
    * @return base^exponent: double
    */
   private static double power(double base, int exponent){
     if (exponent == 1)
       return base;
     else
       return base * power(base, exponent - 1);
   }
}