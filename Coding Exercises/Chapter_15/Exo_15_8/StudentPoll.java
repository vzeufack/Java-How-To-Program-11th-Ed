import java.util.Formatter;
import java.util.FormatterClosedException;
import java.lang.SecurityException;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.NoSuchElementException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.io.IOException;

public class StudentPoll{
   private static String inputFile = "numbers.txt";
   
   public static void main(String[] args){
      createResponses();
      ArrayList<Integer> responses = readResponses();
      int[] frequency = new int[6];
      writeFrequencies(getFrequencies(responses));
   }
   
   private static void createResponses(){
      try(Formatter output = new Formatter(inputFile)){
         Scanner input = new Scanner(System.in);
         System.out.printf("%s%n%s%n> ", "Enter a rating between 1 and 5", "Enter a letter to end input");
         
         while(input.hasNextInt()){
            try{
               int val = input.nextInt();
               if(val < 1 || val > 5)
                  throw new NoSuchElementException();
                  
               output.format("%d%n", val);
            }
            catch(NoSuchElementException e){
               System.err.println("invalid input. Please try again");
               input.nextLine();
            }
            System.out.print("> ");
         }
      }
      catch(SecurityException | FileNotFoundException | FormatterClosedException e){
         e.printStackTrace();
      }
   }
   
   private static ArrayList<Integer> readResponses(){
      ArrayList<Integer> ratings = new ArrayList<>();
      
      try(Scanner input = new Scanner(Paths.get(inputFile))){
          while(input.hasNext()){
            ratings.add(input.nextInt());
          }
      }
      catch(IOException | NoSuchElementException | IllegalStateException e){
         e.printStackTrace();
      }
      
      return ratings;
   }
   
   private static int[] getFrequencies(ArrayList<Integer> ratings){
      int[] frequencies = new int[6];
      for(Integer rating: ratings){
         frequencies[rating]++;
      }
      return frequencies;
   }
   
   private static void writeFrequencies(int[] frequencies){
      try(Formatter output = new Formatter("output.txt")){
         for(int i = 1; i < frequencies.length; i++){
            output.format("%d %d%n", i, frequencies[i]);
         }
      }
      catch(SecurityException | FileNotFoundException | FormatterClosedException e){
         e.printStackTrace();
      }
   }
}