public class DateTest{
   public static void main (String[] args){
      Date date = new Date(12, 31, 2021);
      System.out.println(date);
      date.nextDay();
      System.out.println(date);
      
      Date date2 = new Date(2, 28, 2020);
      System.out.println(date2);
      date2.nextDay();
      System.out.println(date2);
      
      Date date3 = new Date(2, 28, 2021);
      System.out.println(date3);
      date3.nextDay();
      System.out.println(date3);
   }
}