import java.util.Scanner;
import java.util.TreeSet;
import java.util.Arrays;
import java.util.List;

/** 
  * WordSortingWithTreeSet.java by Vannel 2/5/2021
  * Inputs a sentence from the user, tokenize it
  * and sorts the words using a TreeSet
  */
public class WordSortingWithTreeSet{
   public static void main (String[] args){
      Scanner read = new Scanner(System.in);
      
      System.out.print("Enter a sentence > ");
      String sentence = read.nextLine();
      String[] tokens = sentence.split(" ");
      List<String> tokensList = Arrays.asList(tokens);
      
      TreeSet<String> sortedWords = new TreeSet<>(tokensList);      
      System.out.printf("Non-sorted words: %s%n", tokensList);
      System.out.printf("Sorted words: %s%n", sortedWords);
   }
}