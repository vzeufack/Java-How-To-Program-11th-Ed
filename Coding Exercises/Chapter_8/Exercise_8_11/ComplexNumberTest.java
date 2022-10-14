public class ComplexNumberTest{
   public static void main (String[] args){
      ComplexNumber n0 = new ComplexNumber();
      System.out.println("n0 = " + n0);
      
      ComplexNumber n1 = new ComplexNumber(2.5f, -10);
      ComplexNumber n2 = new ComplexNumber(-1.2f, 11.5f);
      System.out.println("n1 = " + n1);
      System.out.println("n2 = " + n2);
      System.out.println("n1 + n2 = " + ComplexNumber.add(n1, n2));
      System.out.println("n2 - n1 = " + ComplexNumber.subtract(n1, n2));
   }
}