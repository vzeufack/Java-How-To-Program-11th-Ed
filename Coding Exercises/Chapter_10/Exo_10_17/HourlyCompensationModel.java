public class HourlyCompensationModel implements CompensationModel{
   private double wage;
   private double hours;
   
   public HourlyCompensationModel(double wage, double hours){
      this.wage = wage;
      this.hours = hours;
   }
   
   public double getWage(){
      return wage;
   }
   
   public double getHours(){
      return hours;
   }
   
   @Override
   public double earnings(){
      if (getHours() <= 40) { // no overtime                           
         return getWage() * getHours();                                
      }                                                                
      else {                                                           
         return 40 * getWage() + (getHours() - 40) * getWage() * 1.5;  
      } 
   }
   
   @Override
   public String toString(){
      return String.format("Hourly Compensation Model: wage = %.2f | hours = %.2f", getWage(), getHours());
   }
}