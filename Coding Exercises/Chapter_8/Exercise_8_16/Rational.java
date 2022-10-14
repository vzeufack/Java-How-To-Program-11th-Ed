import java.text.DecimalFormat;

public class Rational{
   private int numerator;
   private int denominator;
   
   public Rational(){
      numerator = 0;
      denominator = 1;
   }
   
   public Rational(int numerator, int denominator){
      if(denominator == 0)
         throw new IllegalArgumentException("Denominator cannot be 0!");
      
      int[] reducedForm = reduce(numerator, denominator);
      this.numerator = reducedForm[0];
      this.denominator = reducedForm[1];
   }
   
   //reduces the fraction to its irreductible form
   private static int[] reduce(int numerator, int denominator){
      int min, max;
      
      if(numerator > denominator){
         min = denominator;
         max = numerator;
      }
      else{
         min = numerator;
         max = denominator;
      }
      
      int gcd = 1;
      for(int i = 2; i <= min; i++){
         if(min%i == 0 && max%i == 0)
            gcd = i;
      } 
      
      int[] result = {numerator/gcd, denominator/gcd}; 
      return result;
   }
     
   //adds two rational numbers
   public static Rational add(Rational n1, Rational n2){
      int numerator = n1.numerator * n2.denominator + n1.denominator * n2.numerator;
      int denominator = n1.denominator * n2.denominator;
      Rational result = new Rational(numerator, denominator);
      return result;
   }
   
   //subtracts two rational numbers
   public static Rational subtract(Rational n1, Rational n2){
      int numerator = n1.numerator * n2.denominator - n1.denominator * n2.numerator;
      int denominator = n1.denominator * n2.denominator;
      Rational result = new Rational(numerator, denominator);
      return result;
   }
   
   //multiplies two rational numbers
   public static Rational multiply(Rational n1, Rational n2){
      int numerator = n1.numerator * n2.numerator;
      int denominator = n1.denominator * n2.denominator;
      Rational result = new Rational(numerator, denominator);
      return result;
   }
   
   //divides two rational numbers
   public static Rational divide(Rational n1, Rational n2){
      int numerator = n1.numerator * n2.denominator;
      int denominator = n1.denominator * n2.numerator;
      Rational result = new Rational(numerator, denominator);
      return result;
   }
   
   //returns a string representation of the Rational number in the format a/b
   public String toString(){
      return String.format("%d/%d", numerator, denominator);
   }
   
   //returns a decimal representation of the Rational number with the number of decimals passed as parameter
   public String toString(int decimalPlaces){
      String pattern = "####################.";
      for(int i = 0; i < decimalPlaces; i++)
         pattern += "0";
      DecimalFormat formatter = new DecimalFormat(pattern);
      return formatter.format((double)numerator/denominator);
   }
}