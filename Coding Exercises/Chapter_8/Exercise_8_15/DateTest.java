public class DateTest{
   public static void main (String[] args){
      //02/28/2022
      //02/29/2022
      
      Date d1 = new Date(2,28,2022);
      Date d2 = new Date("February",28,2022);
      Date d3 = new Date(58, 2022);
      
      System.out.println(d1);
      System.out.println(d2);
      System.out.println(d3);
   }
}