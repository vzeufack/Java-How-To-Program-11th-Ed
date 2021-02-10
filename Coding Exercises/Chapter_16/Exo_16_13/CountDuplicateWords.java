import java.util.Scanner;
import java.util.HashMap;
import java.util.Set;

/**
  * CountDuplicateWords.java by Vannel 2/2/2021
  * Prints the number of duplicate words in a sentence
  */
public class CountDuplicateWords{
   /**
     * Main method
     */
   public static void main (String[] args){
      String continueAnswer;
      String sentence;
      Integer numOfDuplicates;
      Scanner scan = new Scanner(System.in);
      
      do{
         System.out.print("Please enter a sentence > ");
         sentence = scan.nextLine();
         numOfDuplicates = countDuplicates(sentence);
         System.out.printf("# of duplicate words = %d%n", numOfDuplicates);
         
         do{
            System.out.print("\nDo you wish you enter another sentence (y/n)? ");
            continueAnswer = scan.nextLine();
         }while (!continueAnswer.equalsIgnoreCase("y") && !continueAnswer.equalsIgnoreCase("n"));
         
      }while (continueAnswer.equalsIgnoreCase("y"));
   }
   
   /**
     * Counts the number of duplicate words within a sentence.
     *
     * @param sentence: String.
     *    The sentence from which the duplicate words are counted.
     *
     * @return duplicateCount: int.
     *    The number of duplicate words in the sentence.
     */
   public static int countDuplicates (String sentence){
      HashMap<String, Integer> wordCountMap = countWords(sentence);
            
      //count every word with more than one occurence
      int result = 0;
      Set<String> words = wordCountMap.keySet();
      for (String word: words){
         if (wordCountMap.get(word) > 1)
            result++;
      }
      
      return result;
   }
   
   /**
     * Counts the number of occurences of each word and return it in a map.
     *
     * @param sentence: String
     *    The sentence from which the words are counted.
     *
     * @return wordCountMap: HashMap<String, Integer>
     *    The mapping between each word and its number of occurences.
     */
   public static HashMap<String, Integer> countWords(String sentence){
      HashMap<String, Integer> wordCountMap = new HashMap<String, Integer>();      
      int idx = 0;
            
      while (idx < sentence.length()){
         //retrieve words sequentially
         String currentWord = "";
         while (idx < sentence.length() && sentence.charAt(idx) != ' ' && sentence.charAt(idx) != '\t'){
            if (Character.isLetter(sentence.charAt(idx)))
               currentWord = currentWord + sentence.charAt(idx);
            idx++;
         }
         
         //update the count for each word
         if (!currentWord.equals("")){
            if (wordCountMap.containsKey(currentWord)){
               wordCountMap.put(currentWord.toLowerCase(), wordCountMap.get(currentWord) + 1);
            }
            else{
               wordCountMap.put(currentWord.toLowerCase(), 1);
            }
         }
         idx++;
      }
      
      return wordCountMap;
   }
}