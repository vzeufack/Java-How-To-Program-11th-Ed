public class RationalTest{
   public static void main(String[] args){
      Rational n0 = new Rational();
      System.out.println(n0);
      
      Rational n1 = new Rational(2,4);
      System.out.println(n1);
      System.out.println(n1.toString(1));
      System.out.println(n1.toString(2));
      System.out.println(n1.toString(0));
      
      Rational n2 = new Rational(1,4);
      
      System.out.println(Rational.add(n1, n2));
      System.out.println(Rational.subtract(n1, n2));
      System.out.println(Rational.multiply(n1, n2));
      System.out.println(Rational.divide(n1, n2).toString(2));
   }
}