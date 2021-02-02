// Fig. 8.7: Date.java 
// Date class declaration.

public class Date {
   private int month; // 1-12
   private int day; // 1-31 based on month
   private int year; // any year

   private static final int[] daysPerMonth = 
      {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
   
   // constructor: confirm proper value for month and day given the year
   public Date(int month, int day, int year) {
      // check if month in range
      if (month <= 0 || month > 12) {
         throw new IllegalArgumentException(
            "month (" + month + ") must be 1-12");
      }

      // check if day in range for month
      if (day <= 0 || 
         (day > daysPerMonth[month] && !(month == 2 && day == 29))) {
         throw new IllegalArgumentException("day (" + day + 
            ") out-of-range for the specified month and year");
      }
      
      // check if year is valid
      if (year < 1900 || year > 9999){
          throw new IllegalArgumentException("year (" + year + ") must be in range 1000-9999");
      }

      // check for leap year if month is 2 and day is 29
      if (month == 2 && day == 29 && !(year % 400 == 0 || 
           (year % 4 == 0 && year % 100 != 0))) {
         throw new IllegalArgumentException("day (" + day +
            ") out-of-range for the specified month and year");
      }
   
      this.month = month;
      this.day = day;
      this.year = year;

      System.out.printf("Date object constructor for date %s%n", this);
   } 
   
   //accessor for day
   public int getDay(){ return day;}
   
   //accessor for month
   public int getMonth(){ return month;}
   
   //accessor for year
   public int getYear(){ return year;}
   
   //mutator for day
   public void setDay( int day ){
      int month = getMonth();
      
      // check if day in range for month
      if (day <= 0 || 
         (day > daysPerMonth[month] && !(month == 2 && day == 29))) {
         throw new IllegalArgumentException("day (" + day + 
            ") out-of-range for the specified month and year");
      }
      
      // check for leap year if month is 2 and day is 29
      if (month == 2 && day == 29 && !(year % 400 == 0 || 
           (year % 4 == 0 && year % 100 != 0))) {
         throw new IllegalArgumentException("day (" + day +
            ") out-of-range for the specified month and year");
      }
      
      this.day = day;
   } 
   
   //mutator for month
   public void setMonth(int month){
       // check if month in range
       if (month <= 0 || month > 12) {
          throw new IllegalArgumentException("month (" + month + ") must be 1-12");
       }
       else{
           this.month = month;
       }
   } 
   
   //mutator for year
   public void setYear(int year){
       // check if year is valid
       if (year < 1900 || year > 9999){
           throw new IllegalArgumentException("year (" + year + ") must be in range 1900-9999");
       }
       
       this.year = year;
   } 
   
   //increments the day by 1
   public void nextDay(){
       int newDay = getDay() + 1;
       if (newDay <= daysPerMonth[getMonth()]){
           setDay(newDay);
       }
       else if (getMonth() == 2 && getDay() == 28 && isLeapYear(getYear())){
           setDay(29);
       }
       else{
           setDay(1);
           nextMonth();
       }
   }
   
   //increments the month by 1
   private void nextMonth(){
       int newMonth = getMonth() + 1;
       if (newMonth <= 12){
           setMonth(newMonth);
       } 
       else{
           setMonth(1);
           nextYear();
       }
   }
   
   //increments the year by 1
   private void nextYear(){
       int newYear = getYear() + 1;
       
       if (getMonth() == 2 && getDay() == 29){           
           setDay(28);
       }
       
       setYear(newYear);
   }
   
   //determines if a year is a leap year
   private boolean isLeapYear (int year){
       if (year % 400 == 0 ||  (year % 4 == 0 && year % 100 != 0)){
           return true;
       }
       else{
           return false;
       }
   }
   
   // return a String of the form month/day/year
   public String toString() {
      return String.format("%d/%d/%d", month, day, year); 
   } 
} 



/**************************************************************************
 * (C) Copyright 1992-2018 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
