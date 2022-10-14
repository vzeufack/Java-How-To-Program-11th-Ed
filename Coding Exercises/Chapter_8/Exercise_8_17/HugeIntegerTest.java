public class HugeIntegerTest{
   public static void main (String[] args){
      HugeInteger n1 = new HugeInteger();
      String n1Str = "123";
      n1.parse(n1Str);
      System.out.println(n1);
      
      HugeInteger n2 = new HugeInteger("987");
      System.out.println(n2);
      System.out.println(HugeInteger.add(n1,n2));
      System.out.println(HugeInteger.subtract(n2,n1));
      System.out.println(HugeInteger.subtract(n1,n2));
      
      System.out.println(n1.isEqualTo(n2));
      System.out.println(n1.isNotEqualTo(n2));
      System.out.println(n1.isGreaterThan(n2));
      System.out.println(n1.isLessThan(n2));
      System.out.println(n1.isGreaterThanOrEqualTo(n2));
      System.out.println(n1.isLessThanOrEqualTo(n2));
   }
}