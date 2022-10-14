public class BasePlusCommissionCompensationModel implements CompensationModel{
   private double grossSales;
   private double commissionRate;
   private double baseSalary;

   public BasePlusCommissionCompensationModel(double grossSales, double commissionRate, double baseSalary){
      this.grossSales = grossSales;
      this.commissionRate = commissionRate;
      this.baseSalary = baseSalary;
   }
   
   public double getGrossSales(){
      return grossSales;
   }
   
   public double getCommissionRae(){
      return commissionRate;
   }

   public double getBaseSalary(){
      return baseSalary;
   }
   
   @Override
   public double earnings(){
      return baseSalary + grossSales * commissionRate;
   }
   
   @Override
   public String toString(){
      return String.format("Base Plus Commission Compensation Model: gross sales = %.2f | commission rate = %.2f | base salary = %.2f", 
                           getGrossSales(), getCommissionRae(), getBaseSalary());
   }
}
