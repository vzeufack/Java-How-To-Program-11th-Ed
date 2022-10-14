public class SavingsAccount{
   private static double annualInterestRate;
   private double savingsBalance;
   
   public SavingsAccount(double savingsBalance){
      this.savingsBalance = savingsBalance;
   }
   
   public double getSavingsBalance(){
      return savingsBalance;
   }
   
   public void setSavingsBalance(double newSavingsBalance){
      this.savingsBalance = newSavingsBalance;
   }
   
   public void calculateMonthlyInterest(){
      this.savingsBalance += (this.savingsBalance * annualInterestRate)/12;
   }
   
   public static void modifyInterestRate(double newInterestRate){
      annualInterestRate = newInterestRate;
   }
}