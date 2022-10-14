public class EmployeeTest {
   public static void main(String[] args) {
      CompensationModel model1 = new CommissionCompensationModel(50, 2);
      CompensationModel model2 = new BasePlusCommissionCompensationModel(50, 2, 100);
      CompensationModel model3 = new SalariedCompensationModel(200);
      CompensationModel model4 = new HourlyCompensationModel(25, 45);
      
      Employee[] employees = {new Employee("vannel", "zeufack", "0001", model1),
                              new Employee("yolande", "pangou", "0002", model2),
                              new Employee("keltis", "nemaga", "0003", model3),
                              new Employee("hidocie", "tchousse", "0004", model4)};
                              
      for(Employee employee: employees){
         System.out.println(employee);
         System.out.println("earnings: $" + employee.earnings());
         System.out.println();
      }
      
      employees[0].setCompensationModel(model2);
      employees[1].setCompensationModel(model1);
      employees[2].setCompensationModel(model4);
      employees[3].setCompensationModel(model3);
      
      System.out.println("### After changing the compensation models ###\n");

      for(Employee employee: employees){
         System.out.println(employee);
         System.out.println("earnings: $" + employee.earnings());
         System.out.println();
      }
   }
}
