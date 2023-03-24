import java.util.Scanner;
import java.util.ArrayList;

public class AverageGrades{
   public static void main(String[] args){
      Scanner input = new Scanner(System.in);
      ArrayList<Integer> grades = new ArrayList<>();
      int grade;
      
      do{
         System.out.print("Enter a grade or -1 to quit: ");
         grade = input.nextInt();
         
         if(grade != -1)
            grades.add(grade);
      }while(grade != -1);
      
      System.out.printf(
         "The average of the grades is %.2f\n",
         grades.stream()
               .mapToDouble(Double::valueOf)
               .average()
               .getAsDouble());
   }
}