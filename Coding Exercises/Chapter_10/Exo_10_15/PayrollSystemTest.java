// Fig. 10.9: PayrollSystemTest.java
// Employee hierarchy test program.

public class PayrollSystemTest {
   public static void main(String[] args) {
      // create subclass objects                                          
      SalariedEmployee salariedEmployee =                                 
         new SalariedEmployee("John", "Smith", "111-11-1111", new Date(01,01,2022), 800.00);    
      HourlyEmployee hourlyEmployee =                                     
         new HourlyEmployee("Karen", "Price", "222-22-2222", new Date(02,01,2022), 16.75, 40);  
      CommissionEmployee commissionEmployee =                             
         new CommissionEmployee(                                          
         "Sue", "Jones", "333-33-3333", new Date(03,01,2022), 10000, .06);                      
      BasePlusCommissionEmployee basePlusCommissionEmployee =             
         new BasePlusCommissionEmployee(                                  
         "Bob", "Lewis", "444-44-4444", new Date(04,01,2022), 5000, .04, 300);
      PieceWorker pieceWorker =                                     
         new PieceWorker("Jacob", "Rod", "555-55-5555", new Date(05,01,2022), 10, 50);         

      // create four-element Employee array
      Employee[] employees = new Employee[5]; 

      // initialize array with Employees        
      employees[0] = salariedEmployee;          
      employees[1] = hourlyEmployee;            
      employees[2] = commissionEmployee;        
      employees[3] = basePlusCommissionEmployee;
      employees[4] = pieceWorker;

      // generically process each element in array employees
      for (Employee currentEmployee : employees) {
         System.out.println(currentEmployee);
         System.out.printf("earned $%,.2f%n%n", currentEmployee.earnings());
      } 
      System.out.println();                                             
   } 
} 
