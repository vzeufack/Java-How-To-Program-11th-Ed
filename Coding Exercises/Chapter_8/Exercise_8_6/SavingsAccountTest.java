public class SavingsAccountTest{
   public static void main (String[] args){
      SavingsAccount saver1 = new SavingsAccount(2000);
      SavingsAccount saver2 = new SavingsAccount(3000);
      SavingsAccount.modifyInterestRate(0.04);
      
      for(int i = 1; i <= 12; i++){
         saver1.calculateMonthlyInterest();
         System.out.printf("saver 1 balance after month %2d = %f\n", i, saver1.getSavingsBalance());
         saver2.calculateMonthlyInterest();
         System.out.printf("saver 2 balance after month %2d = %f\n", i, saver2.getSavingsBalance());
      }
      
      SavingsAccount.modifyInterestRate(0.05);
      saver1.calculateMonthlyInterest();
      System.out.printf("saver 1 balance after month %2d = %f\n", 13, saver1.getSavingsBalance());
      saver2.calculateMonthlyInterest();
      System.out.printf("saver 2 balance after month %2d = %f\n", 13, saver2.getSavingsBalance());
   }
}