import java.util.ArrayList;
import java.util.Scanner;

public class IntegerGradesToLetterGrades{
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
      
      grades.stream()
            .forEach(x -> System.out.printf("%d => %c\n", x, getLetterGrade(x)));
   }
   
   private static char getLetterGrade(int grade){
      if(grade < 60)
         return 'F';
      else if(grade < 70)
         return 'D';
      else if (grade < 80)
         return 'C';
      else if (grade < 90)
         return 'B';
      else
         return 'A';
   }
}