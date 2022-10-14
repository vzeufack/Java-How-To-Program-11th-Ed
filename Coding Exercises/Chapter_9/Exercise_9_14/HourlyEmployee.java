public class HourlyEmployee extends Employee{
   private double hours;
   private double wage;
   
   public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber, double hours, double wage) {
      super(firstName, lastName, socialSecurityNumber);
      
      // if hours is invalid throw exception
      if (hours <= 0.0 || hours >= 168.0) {
         throw new IllegalArgumentException(
            "Hours must be > 0.0 and < 168.0");
      }
      
      // if wage is invalid throw exception
      if (wage < 0.0) {
         throw new IllegalArgumentException("Wage must be >= 0.0");
      }         
             
      this.hours = hours;
      this.wage = wage;
   }
   
   public double getHours(){
      return hours;
   }
   
   public void setHours(double hours){
      if (hours <= 0.0 || hours >= 168.0) {
         throw new IllegalArgumentException(
            "Hours must be > 0.0 and < 168.0");
      }
      this.hours = hours;
   }
   
   public double getWage(){
      return wage;
   }
   
   public void setWage(double wage){
      if (wage < 0.0) {
         throw new IllegalArgumentException("Wage must be >= 0.0");
      }
      this.wage = wage;
   }
   
   public double earnings(){
      double h = getHours();
      double w = getWage();
      
      if(h <= 40){
         return w * h;
      }
      else{
         return 40*w + 1.5*w*(h-40); 
      }
   }
   
   @Override 
   public String toString() {
      return String.format("%s%s: %.2f%n%s: %.2f", 
         super.toString(), 
         "hourly wage", getWage(), 
         "hours worked", getHours());
   }
}