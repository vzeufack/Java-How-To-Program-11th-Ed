//combines Date and Time2 classes
public class DateAndTime{
   private int month; // 1-12
   private int day; // 1-31 based on month
   private int year; // any year
   private int hour; // 0 - 23
   private int minute; // 0 - 59
   private int second; // 0 - 59
    
   private static final int[] daysPerMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
   // initializes date with default date and time  
   public DateAndTime() {                                             
      this(1, 1, 1900, 0, 0, 0);
   }
     
   // initializes date with default time  
   public DateAndTime(int month, int day, int year) {                                             
      this(month, day, year, 0, 0, 0);
   } 

   // Date and hour supplied, minute and second defaulted to 0
   public DateAndTime(int month, int day, int year, int hour) {                                               
      this(month, day, year, hour, 0, 0);
   } 

   // Date, hour and minute supplied, second defaulted to 0
   public DateAndTime(int month, int day, int year, int hour, int minute) {
      this(month, day, year, hour, minute, 0); // invoke constructor with three arguments 
   }
   
   // constructor: confirm proper value for month and day given the year
   public DateAndTime(int month, int day, int year, int hour, int minute, int second){
      // check if month in range
      if (month <= 0 || month > 12) {
         throw new IllegalArgumentException("month (" + month + ") must be 1-12");
      }

      // check if day in range for month
      if (day <= 0 || 
         (day > daysPerMonth[month] && !(month == 2 && day == 29))) {
         throw new IllegalArgumentException("day (" + day + 
             ") out-of-range for the specified month and year");
      }
      
      // check if year is valid
      if (year < 1000 || year > 9999){
          throw new IllegalArgumentException("year (" + year + ") must be in range 1000-9999");
      }
 
      // check for leap year if month is 2 and day is 29
      if (month == 2 && day == 29 && !(year % 400 == 0 || 
           (year % 4 == 0 && year % 100 != 0))) {
         throw new IllegalArgumentException("day (" + day +
            ") out-of-range for the specified month and year");
      }
       
      if (hour < 0 || hour >= 24) {
         throw new IllegalArgumentException("hour must be 0-23");
      } 

      if (minute < 0 || minute >= 60) {
         throw new IllegalArgumentException("minute must be 0-59");
      } 

      if (second < 0 || second >= 60) {
         throw new IllegalArgumentException("second must be 0-59");
      }
   
      this.month = month;
      this.day = day;
      this.year = year;
      this.hour = hour;
      this.minute = minute; 
      this.second = second;

      //System.out.printf("DateAndTime object constructor for date and time %s%n", this);
   }
   
   //another Time2 object supplied           
   public DateAndTime(int month, int day, int year, Time2 time) {                                   
      // invoke constructor with three arguments
      this(month, day, year, time.getHour(), time.getMinute(), time.getSecond());
   }
   
   // get day value
   public int getDay(){ return day;}
   
   // get month value
   public int getMonth(){ return month;}
   
   //get year value
   public int getYear(){ return year;}
           
   // get hour value      
   public int getHour() {return hour;}

   // get minute value      
   public int getMinute() {return minute;} 

   // get second value      
   public int getSecond() {return second;}
   
   //validate and set day
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
   
   //validate and set month
   public void setMonth(int month){
       // check if month in range
       if (month <= 0 || month > 12) {
          throw new IllegalArgumentException("month (" + month + ") must be 1-12");
       }
       else{
           this.month = month;
       }
   } 
   
   //validate and set year
   public void setYear(int year){
       // check if year is valid
       if (year < 1900 || year > 9999){
           throw new IllegalArgumentException("year (" + year + ") must be in range 1900-9999");
       }
       
       this.year = year;
   }
   
   // set a new time value using universal time;  
   // validate the data
   public void setTime(int hour, int minute, int second) {
      if (hour < 0 || hour >= 24) {
         throw new IllegalArgumentException("hour must be 0-23");
      } 

      if (minute < 0 || minute >= 60) {
         throw new IllegalArgumentException("minute must be 0-59");
      } 

      if (second < 0 || second >= 60) {
         throw new IllegalArgumentException("second must be 0-59");
      } 

      this.hour = hour;
      this.minute = minute; 
      this.second = second; 
   } 

   // validate and set hour 
   public void setHour(int hour) {
      if (hour < 0 || hour >= 24) {
         throw new IllegalArgumentException("hour must be 0-23");
      }

      this.hour = hour;
   } 

   // validate and set minute 
   public void setMinute(int minute) {
      if (minute < 0 || minute >= 60) {
         throw new IllegalArgumentException("minute must be 0-59");
      }

      this.minute = minute; 
   } 

   // validate and set second 
   public void setSecond(int second) {
      if (second < 0 || second >= 60) {
         throw new IllegalArgumentException("second must be 0-59");
      }

      this.second = second;
   }
   
   // convert to String in universal date and time format (month/day/year HH:MM:SS)
   public String toUniversalString() {
      return String.format(
         "%d/%d/%d %02d:%02d:%02d", getMonth(), getDay(), getYear(), getHour(), getMinute(), getSecond());
   } 

   // convert to String in standard date and time format (month/day/year H:MM:SS AM or PM)
   public String toString() {
      return String.format("%d/%d/%d %d:%02d:%02d %s", getMonth(), getDay(), getYear(), 
         ((getHour() == 0 || getHour() == 12) ? 12 : getHour() % 12),
         getMinute(), getSecond(), (getHour() < 12 ? "AM" : "PM"));
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
   
   //increments the seconds by one
   public void tick(){
       int newSecond = getSecond() + 1;
       if (newSecond != 60){
           setSecond(newSecond);
       }
       else{
           setSecond(0);
           incrementMinute();
       }
   }
   
   //increments the minutes by one
   public void incrementMinute(){
       int newMinute = getMinute() + 1;
       if (newMinute != 60){
           setMinute(newMinute);
       }
       else{
           setMinute(0);
           incrementHour();
       }
   }
   
   //increments the hours by one
   public void incrementHour(){
       int newHour = getHour() + 1;
       if (newHour != 24){
           setHour(newHour);
       }
       else{
           setHour(0);
           nextDay();
       }
   }
}