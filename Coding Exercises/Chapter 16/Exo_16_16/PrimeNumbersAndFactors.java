import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;

/**
  * PrimeNumbersAndFactors.java by Vannel 2/4/2021
  * Determines if a whole number entered by the user is prime.
  * If not, all the prime factors of the number are printed
  */
public class PrimeNumbersAndFactors{
   private static Scanner read = new Scanner(System.in);
   
   public static void main (String[] args){      
      Integer number;
      
      do{
         
         number = readInput();
         if (number != -1){
            Set<Integer> primeFactors = getPrimeFactors(number);
            if (primeFactors == null){
               System.out.printf("%d is not prime and has no prime factors.%n", number);
            }   
            else if (primeFactors.size() > 0){
               System.out.printf("%d is not prime and its prime factors are %s.%n", number, primeFactors);
            }
            else{
               System.out.printf("%d is prime.%n", number);
            }
         }
      }while(number != -1);
   }
   
   public static Set<Integer> getPrimeFactors(Integer number){
      if (number == 0 || number == 1)
         return null;
      
      Set<Integer> primeFactors = new HashSet<Integer>();
      Integer num = number;
            
      for (int i = 2; i <= number/2; i++){
         if (num%i == 0){
            primeFactors.add(i);
            num = num/i;
            i = 1;
         }
      }
      
      return primeFactors;
   }
   
   public static boolean isPrime(Integer number){
      if (number == 2 || number == 3)
         return true;
      if (number <= 1 || number%2 == 0 || number%3 == 0)
         return false;
         
      //All prime numbers starting from 5 can be written as 6k +/- 1?
      //we divide the number by all prime numbers from 5 to squareRoot(n)
      //if any divides the number, then it is not prime. Otherwise, it is prime
      int i = 5;
      while(i*i <= number){
         if (number%i==0 || number%(i+2) == 0)
            return false;
         i += 6;
      }
      return true;
   }
   
   public static Integer readInput(){
      String input;
      boolean isInteger;
      Integer number = -2;
      
      do{
         System.out.print("\nPlease enter a whole number (or -1 to stop) > ");
         input = read.nextLine();
         try{
            number = Integer.parseInt(input);
            isInteger = true;
         }
         catch (NumberFormatException e){
            isInteger = false;
         }
         if(!isInteger || number < -1){
            System.out.println("Invalid input! Valid inputs are {-1, 0, 1, 2 ...}");
         }
      }while (!isInteger || number < -1);
      
      return number;
   }
}