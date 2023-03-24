import java.util.stream.Stream;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.List;

public class GradesAveragePerStudent {
   public static void main(String[] args){
      int[][] gradesArray = {{87, 96, 70},      
                             {68, 87, 90},      
                             {94, 100, 90},     
                             {100, 81, 82},     
                             {83, 65, 85},      
                             {78, 87, 65},      
                             {85, 75, 83},      
                             {91, 94, 100},     
                             {76, 72, 84},      
                             {87, 93, 73}};
      
      List<Double> averages = Stream.of(gradesArray)
                                    .map(x -> Arrays.stream(x).average().getAsDouble())
                                    .collect(Collectors.toList());
      
      System.out.println(averages);
   }
}