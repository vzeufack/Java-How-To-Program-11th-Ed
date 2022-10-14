public class EmployeeTest {
   public static void main(String[] args) {
      CompensationModel model1 = new CommissionCompensationModel(50, 2);
      CompensationModel model2 = new BasePlusCommissionCompensationModel(50, 2, 100);
      Employee emp1 = new Employee("vannel", "zeufack", "0000", model1);
      Employee emp2 = new Employee("vannel", "zeufack", "0000", model2);

      System.out.println(emp1.earnings());
      System.out.println(emp2.earnings());

      emp1.setCompensationModel(model2);
      emp2.setCompensationModel(model1);

      System.out.println(emp1.earnings());
      System.out.println(emp2.earnings());
   }
}
