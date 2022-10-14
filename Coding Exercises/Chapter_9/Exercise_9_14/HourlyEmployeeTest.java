public class HourlyEmployeeTest{
   public static void main(String[] args){
      HourlyEmployee employee = new HourlyEmployee("Yolande", "Pangou", "404-498-6624", 25, 40);
      
      System.out.println(
         "Employee information obtained by get methods:");
      System.out.printf("%s %s%n", "First name is",
         employee.getFirstName());
      System.out.printf("%s %s%n", "Last name is", 
         employee.getLastName());
      System.out.printf("%s %s%n", "Social security number is", 
         employee.getSocialSecurityNumber());
      System.out.printf("%s %.2f%n", "Hourly wage is", 
         employee.getWage());
      System.out.printf("%s %.2f%n", "Hours worked is",
         employee.getHours());
      System.out.printf("%s %.2f%n", "Salary is",
         employee.earnings());
         
      employee.setHours(50);
      System.out.printf("%s %.2f%n", "New salary is",
         employee.earnings());
   }
}