import java.util.Arrays;

public class Date{
   private int month;
   private int day;
   private int year;
   private final int[] daysPerMonth = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
   private final String [] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
   
   //construct date given integer values of month, day and year
   public Date(int month, int day, int year){
      if(month < 1 || month > 12)
         throw new IllegalArgumentException("Month must be a value in [1 - 12]. " + month + " is out of range!");
      
      if(year <= 0)
         throw new IllegalArgumentException("Year must be a strictly positive integer. " + year + " is invalid!");
      
      if(day < 1 || day > daysPerMonth[month] || (month == 2 && isLeapYear(year) && day == 29))
         throw new IllegalArgumentException("Invalid day for month " + month);
      
      this.month = month;
      this.day = day;
      this.year = year;
   }
   
   //constructs date given String value of month and integer values of day and year
   public Date(String month, int day, int year){
      int monthValue = 0;
      
      while(monthValue < months.length && months[monthValue] != month)
         monthValue++;
      
      if(monthValue == 0)
         throw new IllegalArgumentException("Month must be a value in " + Arrays.asList(months) + ". " + month + " is invalid!");
      
      this.month = ++monthValue;
      this.day = day;
      this.year = year;
   }
   
   //constructs date given number of days in the year and the year
   public Date(int dayInYear, int year){
      int totalNumberOfDaysInYear;
      
      if(isLeapYear(year))
         totalNumberOfDaysInYear = 366;
      else
         totalNumberOfDaysInYear = 365;
         
      int month = ((dayInYear * 12)/totalNumberOfDaysInYear) + 1;
      
      int daysOverMonths = 0;
      for(int i = 0; i < month-1; i++){
         if(!isLeapYear(year) && i == 1)
            daysOverMonths += 28;
         else
            daysOverMonths += daysPerMonth[i];
      }
      
      int day = dayInYear - daysOverMonths + 1;
      
      this.month = month;
      this.day = day;
      this.year = year;
   }
   
   private boolean isLeapYear(int year){
      return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
   }
   
   public String toString(){
      return String.format("%d/%d/%d", month, day, year);
   }
}