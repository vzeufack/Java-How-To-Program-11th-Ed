public class CommissionCompensationModel implements CompensationModel{
   private double grossSales;
   private double commissionRate;

   public CommissionCompensationModel(double grossSales, double commissionRate){
      this.grossSales = grossSales;
      this.commissionRate = commissionRate;
   }
   
   public double getGrossSales(){
      return grossSales;
   }
   
   public double getCommissionRae(){
      return commissionRate;
   }

   @Override
   public double earnings(){
      return grossSales * commissionRate;
   }
   
   @Override
   public String toString(){
      return String.format("Commission Compensation Model: gross sales = %.2f | commission rate = %.2f", getGrossSales(), getCommissionRae());
   }
}
