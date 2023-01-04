import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class TextAnalysis{
   public static void main(String[] args){
      Scanner scan = new Scanner(System.in);
      System.out.print("Enter a sentence > ");
      String sentence = scan.nextLine();
      
      System.out.println("Characters count:");
      displayCharacterCount(sentence);
      
      System.out.println("\nCount per word length:");
      displayCountPerWordLength(sentence);
      
      System.out.println("\nCount per words:");
      displayCountPerWord(sentence);
   }
   
   private static void displayCharacterCount(String sentence){
      int[] counts = new int[26];
      
      for(int i = 0; i < sentence.length(); i++){
         int currentChar = sentence.charAt(i);
         if(currentChar >= 65 && currentChar <= 90)
            counts[currentChar - 65] = counts[currentChar - 65] + 1;
         else if (currentChar >= 97 && currentChar <= 122)
            counts[currentChar - 97] = counts[currentChar - 97] + 1;
         else{}
      }
      
      for(int i = 97; i <= 122; i++){
         System.out.printf("\'%c\' => %d\n", i, counts[i-97]);
      }
   }
   
   private static void displayCountPerWordLength(String sentence){
      String[] splittedSentence = sentence.split(" ");
      int maxLength = 0;
      
      for(int i = 0; i < splittedSentence.length; i++){
         if(splittedSentence[i].length() > maxLength)
            maxLength = splittedSentence[i].length();
      }
      
      int[] wordCount = new int[maxLength];
      for(int i = 0; i < splittedSentence.length; i++){
         wordCount[splittedSentence[i].length()-1]++;
      }
      
      for(int i = 0; i < wordCount.length; i++){
         System.out.printf("%d => %d\n", i+1, wordCount[i]);
      }
   }
   
   private static void displayCountPerWord(String sentence){
      String cleanSentence = sentence.replaceAll("[^a-zA-Z0-9\\s]", " ");
      String[] splittedSentence = cleanSentence.toLowerCase().split("\\s+");
      ArrayList<String> words = new ArrayList<>();
      
      for(int i = 0; i < splittedSentence.length; i++){
         if(!words.contains(splittedSentence[i]))
            words.add(splittedSentence[i]);
      }
      
      Arrays.sort(splittedSentence);
      for(String word: words){
         System.out.printf("%s => %d\n", word, countWord(word, splittedSentence));
      }      
   }
   
   private static int countWord(String word, String[] sortedWords){
      int i = getFirstIndex(word, sortedWords);
      int count = 0;
      
      while(i < sortedWords.length && word.equals(sortedWords[i])){
         count++;
         i++;
      }
      
      return count;
   }
   
   private static int getFirstIndex(String word, String[] sortedWords){
      int i = 0;
      int j = sortedWords.length-1;
      
      while(i <= j){
         int mid = (i+j)/2;
         int k = sortedWords[mid].compareTo(word);
         if(k >= 0){
            j = mid-1;
         }
         else{
            i = mid+1;
         }   
      }
      
      return i;
   }
}