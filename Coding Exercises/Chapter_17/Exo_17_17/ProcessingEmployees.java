import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;               
import java.util.TreeMap;           
import java.util.function.Function; 
import java.util.function.Predicate;
import java.util.stream.Collectors; 

public class ProcessingEmployees {
   public static void main(String[] args) {
      // initialize array of Employees
      Employee[] employees = {
         new Employee("Jason", "Red", 5000, "IT"),
         new Employee("Ashley", "Green", 7600, "IT"),
         new Employee("Matthew", "Indigo", 3587.5, "Sales"),
         new Employee("James", "Indigo", 4700.77, "Marketing"),
         new Employee("Luke", "Indigo", 6200, "IT"),
         new Employee("Jason", "Blue", 3200, "Sales"),
         new Employee("Wendy", "Brown", 4236.4, "Marketing")};

      // get List view of the Employees
      List<Employee> list = Arrays.asList(employees);

      // display all Employees
      System.out.println("Complete Employee list:");
      list.stream().forEach(System.out::println);
      
      System.out.println();
      
      Map<String, Double> averageSalaryByDepartment =                 
         list.stream()                                              
             .collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.averagingDouble(Employee::getSalary)));                            
      averageSalaryByDepartment.forEach(                            
         (department, average) -> System.out.printf(                  
            "Average salary in %s department is %.2f%n", department, average));    
   } 
} 
