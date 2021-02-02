// Fig. 7.10: DeckOfCards.java
// DeckOfCards class represents a deck of playing cards.
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;

public class DeckOfCards {
   // random number generator
   private static final SecureRandom randomNumbers = new SecureRandom();
   private static final int NUMBER_OF_CARDS = 52; // constant # of Cards

   private Card[] deck = new Card[NUMBER_OF_CARDS]; // Card references
   private int currentCard = 0; // index of next Card to be dealt (0-51)

   // constructor fills deck of Cards
   public DeckOfCards() {
      String[] faces = {"Ace", "Deuce", "Three", "Four", "Five", "Six",
         "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};    
      String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};      

      // populate deck with Card objects                   
      for (int count = 0; count < deck.length; count++) {  
         deck[count] =                                     
            new Card(faces[count % 13], suits[count / 13]);
      }                                                    
   } 

   // shuffle deck of Cards with one-pass algorithm
   public void shuffle() {
      // next call to method dealCard should start at deck[0] again
      currentCard = 0; 

      // for each Card, pick another random Card (0-51) and swap them
      for (int first = 0; first < deck.length; first++) {
         // select a random number between 0 and 51 
         int second = randomNumbers.nextInt(NUMBER_OF_CARDS);

         // swap current Card with randomly selected Card
         Card temp = deck[first];   
         deck[first] = deck[second];
         deck[second] = temp;       
      } 
   } 
   
    // shuffle deck of Cards using the fisher yates algorithm
    public void fisherYateShuffle (){
        int randomIndex;
        currentCard = 0;
        //Card temp;
        
        for (int i = deck.length; i > 0; i--){
           randomIndex = randomNumbers.nextInt(i);
           Card temp = deck[randomIndex];
           deck[randomIndex] = deck[i-1];
           deck[i-1] = temp;
        }
    }

   // deal one Card
   public Card dealCard() {
      // determine whether Cards remain to be dealt
      if (currentCard < deck.length) {
         return deck[currentCard++]; // return current Card in array
      } 
      else {
         return null; // return null to indicate that all Cards were dealt
      } 
   }
   
   /**
    * test if a hand contains a pair
    * @param hand, the hand to test
    * return the indexes of the cards in the pair
    * or null if no pair is found
    */
   public static ArrayList <Integer> testHandforPair (Card [] hand){
      Card currentCard;  
      ArrayList <Integer> pairIndexes = new ArrayList <Integer> (2);  
      
      if (hand != null){
         ArrayList <Card> handAsList = new ArrayList <Card> (); 
         handAsList.addAll(Arrays.asList(hand));
         for (int i = 0; i < handAsList.size() - 1; i++){
             currentCard = handAsList.get(i);
             for (int j = i+1; j < handAsList.size() && currentCard != null; j++){
                 if (handAsList.get(j) != null && currentCard.getFace().equals(handAsList.get(j).getFace())){
                     pairIndexes.add(i);  
                     pairIndexes.add(j);                    
                     return pairIndexes;
                 }
             }
         }
      }      
      return null;
   }
      
   /**
    * test if hand contains two pairs
    * @param hand, the hand to test
    * @return the indexes of each card in each pair
    * or null if no pair is found
    */
   public static ArrayList <Integer>[] testHandForTwoPairs (Card [] hand){
       if (hand != null){
          Card [] handCopy = new Card [hand.length];
          System.arraycopy(hand, 0, handCopy, 0, hand.length);
          
          //look for a pair
          ArrayList <Integer> pair1 = testHandforPair(handCopy);
          
          if (pair1 == null)
              return null;
          else{
              handCopy[(int)pair1.get(0)] = null;
              handCopy[(int)pair1.get(1)] = null;
              
              //look for the second pair              
              ArrayList <Integer> pair2 = testHandforPair(handCopy);
              if (pair2 == null)
                  return null;
              else{
                  ArrayList <Integer> [] pairs = new ArrayList [2];
                  pairs[0] = pair1;
                  pairs[1] = pair2;
                  return pairs;
              }
          } 
       } 
       return null;                    
   }
   
   /**
    * test if hand contains three of a kind
    * @param hand, the hand to test
    * @return the indexes of each card in the trio found
    * or null if no trio is found
    */
   public static ArrayList <Integer> testHandForThreeOfAKind (Card [] hand){
      Card currentCard1;
      Card currentCard2;
      
      ArrayList <Integer> cardIndexes = new ArrayList <Integer>(3);
      if (hand != null){
         for (int i = 0; i < hand.length - 2; i++){
             currentCard1 = hand[i];
             for (int j = i+1; j < hand.length - 1; j++){
                 currentCard2 = hand[j];
                 if (currentCard2.getFace().equals(currentCard1.getFace())){
                    for (int k = j+1; k < hand.length; k++){
                        if (hand[k].getFace().equals(currentCard2.getFace())){
                            cardIndexes.add(i);
                            cardIndexes.add(j);
                            cardIndexes.add(k);
                            return cardIndexes;
                        }
                    }
                 }
             }
         } 
      }         
      return null;
   }
   
   /**
    * test if hand contains four of a kind
    * @param hand, the hand to test
    * @return the indexes of each card if four cards of a kind are found
    * or null otherwise
    */   
    public static ArrayList <Integer> testHandForFourOfAKind (Card [] hand){
      Card currentCard1;
      Card currentCard2;
      Card currentCard3;
      ArrayList <Integer> cardIndexes = new ArrayList <Integer>(4);
      
      if (hand != null){
         for (int i = 0; i < hand.length - 3; i++){
             currentCard1 = hand[i];
             for (int j = i+1; j < hand.length - 2; j++){
                 currentCard2 = hand[j];
                 if (currentCard2.getFace().equals(currentCard1.getFace())){
                    for (int k = j+1; k < hand.length - 1; k++){
                        currentCard3 = hand[k];
                        if (currentCard3.getFace().equals(currentCard2.getFace())){
                            for (int l = k+1; l < hand.length; l++){
                                  if (hand[l].getFace().equals(currentCard3.getFace())){
                                     cardIndexes.add(i);
                                     cardIndexes.add(j);
                                     cardIndexes.add(k);
                                     cardIndexes.add(l);
                                     return cardIndexes;
                                  }
                            }
                        }
                    }
                 }
             }
         } 
      }         
      return null;
   }
   
   /**
    * test if hand contains flush (five cards of the same suit)
    * @param hand, the hand to test
    * @return true if hand contains flush, false otherwise
    */
   public static boolean testHandForFlush (Card [] hand){       
       if (hand == null){
           return false;
       }
       else{
           String firstCardSuit = hand[0].getSuit();
           for (int i = 1; i < hand.length; i++){
               if (!firstCardSuit.equals(hand[i].getSuit()))
                   return false;
           }
       }
       return true;
   }
   
   /**
    * test if hand is a straight (five cards with consecutive faces)
    * @param hand, the hand to test
    * @return true if hand is straight, false otherwise
    */
   public static boolean testHandForStraight (Card [] hand){
       if (hand == null)
           return false;
       
       int [] faces = new int [hand.length];
       
       //convert faces to numbers
       for (int i = 0; i < hand.length; i++){
           faces[i] = getFaceValue(hand[i].getFace());
       }
       
       //order the faces
       Arrays.sort(faces);
       
       //look for broadway
       int broadway [] = {2,3,4,5,14};
       boolean isBroadway = true;
       for (int i = 0; i < broadway.length; i++){
           if (faces[i] != broadway[i]){
               isBroadway = false;
               break;
           }
       }
       
       if (isBroadway == true)
           return true;
       
       //test if consecutive
       for (int i = 0; i < faces.length - 1; i++){
           if (faces[i] + 1 != faces[i+1]){
               return false;
           }
       }       
       return true;
   }
   
   /**
    * determines the integer value of a card's face
    * @param the face
    * @return the integer value of the card's face
    */
   public static int getFaceValue(String face){
       String[] faces = {"Ace", "Deuce", "Three", "Four", "Five", "Six",
         "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
       
       if (face == faces[0])
           return 14;
           
       for (int i = 1; i < faces.length; i++){
           if (face.equals(faces[i]))
               return i+1;
       }
       
       return 0;
   }
   
   /**
    * test if hand contains a full house
    * That is 2 cards of same face and 3 of another face
    * @param hand, the hand to test
    * @return the indexes of each card in the full house
    * if a full house is found or null otherwise
    */
   public static ArrayList <Integer>[] testHandForFullHouse(Card [] hand){
       if (hand == null)
           return null;
       
       ArrayList <Integer> pairIndexes;
       ArrayList <Integer> trioIndexes;
       
       //look for triad       
       trioIndexes = testHandForThreeOfAKind(hand);
       if (trioIndexes == null)
           return null;
       else{
           Card [] handCopy = new Card [hand.length];
           System.arraycopy(hand, 0, handCopy, 0, hand.length);
           for (int i = 0; i < 3; i++)
               handCopy[trioIndexes.get(i)] = null;
           //look for pair    
           pairIndexes = testHandforPair(handCopy);
           if (pairIndexes == null)
               return null;
       }
       ArrayList <Integer> [] indexes = new ArrayList [2];
       indexes[0] = pairIndexes;
       indexes[1] = trioIndexes; 
       return indexes;     
   }
   
   /**
    * displays the hand
    * @param the hand to reveal
    * @return the hand's cards as a string
    */
   public static String printHand (Card [] hand){
       String handString = "<";
       if (hand != null){
          for (int i = 0; i < hand.length; i++) {
              if (i == hand.length - 1)
                  handString += String.format("%s>", hand[i]);
              else
                  handString += String.format("%s - ", hand[i]);
          }
       }
       else{
           handString = "<Empty hand>";
       }
       return handString;
   }    
} 



/**************************************************************************
 * (C) Copyright 1992-2018 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
