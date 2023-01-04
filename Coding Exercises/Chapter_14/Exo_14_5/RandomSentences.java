import java.security.SecureRandom;

public class RandomSentences{
   public static void main (String[] args){
      SecureRandom randomNumberGenerator = new SecureRandom();
      String[] article = {"the", "a", "one", "some", "any"};
      String[] noun = {"boy", "girl", "dog", "town", "car"};
      String[] verb = {"drove", "jumped", "ran", "walked", "skipped"};
      String[] preposition = {"to", "from", "over", "under", "on"};
      StringBuilder sentence = new StringBuilder();
      
      
      for(int i = 0; i < 20; i++){
         String firstArticle = article[randomNumberGenerator.nextInt(article.length)];
         sentence.append(Character.toUpperCase(firstArticle.charAt(0)) + firstArticle.substring(1, firstArticle.length()) + " ");
         sentence.append(noun[randomNumberGenerator.nextInt(noun.length)] + " ");
         sentence.append(verb[randomNumberGenerator.nextInt(verb.length)] + " ");
         sentence.append(preposition[randomNumberGenerator.nextInt(preposition.length)] + " ");
         sentence.append(article[randomNumberGenerator.nextInt(article.length)] + " ");
         sentence.append(noun[randomNumberGenerator.nextInt(noun.length)] + ".");
         System.out.println(sentence);
         sentence.delete(0, sentence.length());
      }
   }
}