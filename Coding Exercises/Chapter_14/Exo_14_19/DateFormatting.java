public class DateFormatting{
   public static void main (String[] args){
      System.out.println(isValidFormat("04/25/1995"));
   }
   
   
   public static String format(String date){
      if(!isValidFormat(date))
         throw new IllegalArgumentException("Invalid date format! Valid format is mm/dd/yyyy.");
         
      String[] months = {"January", "February", "Mars", "April", "May", "June", "July",
                         "August", "September", "October", "November", "December"};
      String[] splittedDate = date.split("/");
      return String.format("%s %s, %s", months[Integer.parseInt(splittedDate[0]) - 1], splittedDate[1], splittedDate[2]);
   }
   
   public static boolean isValidFormat(String date){
      if(!date.matches("\\d{2}/\\d{2}/\\d{4,6}")){
         return false;
      }
      else{
         String[] splittedDate = date.split("/");
         int days = Integer.parseInt(splittedDate[1]);
         int month = Integer.parseInt(splittedDate[0]);
         int year = Integer.parseInt(splittedDate[2]);
         int[] daysPerMonth = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
         
         if(month < 1 || month > 12 || days < 1 || days > daysPerMonth[month-1]){
            return false;   
         }
         
         if(month == 2 && isLeapYear(year) && days == 29)
            return false;
      }
      return true;
   }
   
   private static boolean isLeapYear(int year)
   {
     if (year % 400 == 0)
         return true;
         
     if (year % 100 == 0)
         return false;
  
     if (year % 4 == 0)
         return true;
         
     return false;
   }
}