// Test the DateAndTime class
public class DateAndTimeTest{
   public static void main (String [] args){
      DateAndTime dt = new DateAndTime(2,28,2000,23,59,59);
      System.out.println(dt.toUniversalString());
      dt.tick();
      System.out.println(dt.toUniversalString());
      testDefaultConstructor();
   }
   
   //test the default constructor
   private static void testDefaultConstructor(){
       DateAndTime dateTime = new DateAndTime();
       
       int month = dateTime.getMonth();
       int day = dateTime.getDay();
       int year = dateTime.getYear();
       int hour = dateTime.getHour();
       int minute = dateTime.getMinute();
       int second = dateTime.getSecond();
       
       if (month != 1 || day != 1 || year != 1900 || hour != 0 || minute != 0 || second != 0){
           System.out.print("Failed: ");
       }
       else{
           System.out.print("Passed: ");
       } 
       System.out.printf("Testing default constructor\n");
   }
   
   //test the three argument constructor
   private static void testThreeArgsConstructor(){
       DateAndTime dateTime = new DateAndTime(3,15,1900); //valid case
       
       DateAndTime dateTime = new DateAndTime(0,15,1900); //invalid month 1
       DateAndTime dateTime = new DateAndTime(13,15,1900); //invalid month 2

       DateAndTime dateTime = new DateAndTime(2,30,1900); //invalid day 1
       DateAndTime dateTime = new DateAndTime(2,29,1980); //invalid day 1
       
       int month = dateTime.getMonth();
       int day = dateTime.getDay();
       int year = dateTime.getYear();
       int hour = dateTime.getHour();
       int minute = dateTime.getMinute();
       int second = dateTime.getSecond();
       
       if (month != 1 || day != 1 || year != 1900 || hour != 0 || minute != 0 || second != 0){
           System.out.print("Failed: ");
       }
       else{
           System.out.print("Passed: ");
       } 
       System.out.printf("Testing default constructor\n");
   }
   
}