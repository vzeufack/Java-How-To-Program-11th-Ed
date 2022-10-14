public class SalariedCompensationModel implements CompensationModel {
   private double weeklySalary;

   public SalariedCompensationModel(double weeklySalary){
      this.weeklySalary = weeklySalary;
   }
   
   public double getWeeklySalary(){
      return weeklySalary;
   }
   
   @Override
   public double earnings(){
      return weeklySalary;
   }
   
   @Override
   public String toString(){
      return String.format("Salaried Compensation Model: weekly salary = %.2f", getWeeklySalary());
   }
} 