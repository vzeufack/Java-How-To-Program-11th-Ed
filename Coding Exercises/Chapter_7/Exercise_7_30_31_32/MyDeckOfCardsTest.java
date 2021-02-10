/**
 * Test DeckOfCards class
 */
public class MyDeckOfCardsTest{    
    /**
     * main method
     */
    public static void main (String [] args){
       String[] faces = {"Ace", "Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};    
       String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
       Card c1 = new Card(faces[0], suits[0]);
       Card c2 = new Card(faces[1], suits[1]);
       Card c3 = new Card(faces[2], suits[2]);
       Card c4 = new Card(faces[3], suits[3]);
       Card c5 = new Card(faces[4], suits[0]);
       Card [] cards = {c1, c2, c3, c4, c5};
       
       //testHandForPairTest(cards);
       //testHandForTwoPairsTest(cards);
       //testHandForThreeOfAKindTest(cards);
       //testHandForFourOfAKindTest(cards);
       //testHandForFlushTest(cards);
       //testHandForStraightTest(cards);
       testHandForFullHouseTest(cards);
   }
   
   /**
    * test method: testHandForPair
    * @param cards, a set of cards from which to build hands for testing
    */
   private static void testHandForPairTest(Card [] cards){       
       //empty hand
       Card [] emptyHand = null;
       System.out.printf("%s %s\n", DeckOfCards.printHand(emptyHand), DeckOfCards.testHandforPair(emptyHand));
       
       //hand with no pair
       Card [] invalidHand = {cards[0], cards[1], cards[2], cards[3], cards[4]};
       System.out.printf("%s %s\n", DeckOfCards.printHand(invalidHand), DeckOfCards.testHandforPair(invalidHand));       
       
       //valid hand at indexes 1 and 4
       Card [] validHand1 = {cards[0], cards[1], cards[2], cards[3], cards[1]};
       System.out.printf("%s %s\n", DeckOfCards.printHand(validHand1), DeckOfCards.testHandforPair(validHand1));
       
       //valid hand at indexes 3 and 4
       Card [] validHand2 = {cards[0], cards[1], cards[2], cards[3], cards[3]};
       System.out.printf("%s %s\n", DeckOfCards.printHand(validHand2), DeckOfCards.testHandforPair(validHand2));
   }
   
   /**
    * test method: testHandForTwoPairs
    * @param cards, a set of cards from which to build hands for testing
    */
   private static void testHandForTwoPairsTest(Card [] cards){
       //empty hand
       Card [] emptyHand = null;
       System.out.printf("%s %s\n", DeckOfCards.printHand(emptyHand), DeckOfCards.testHandForTwoPairs(emptyHand));
       
       //hand with no two pairs
       Card [] invalidHand = {cards[0], cards[1], cards[2], cards[3], cards[4]};
       System.out.printf("%s %s\n", DeckOfCards.printHand(invalidHand), DeckOfCards.testHandForTwoPairs(invalidHand));       
       
       //valid hand at indexes (0 1, 3 4)
       Card [] validHand1 = {cards[0], cards[0], cards[2], cards[3], cards[3]};
       System.out.printf("%s %s %s\n", DeckOfCards.printHand(validHand1), DeckOfCards.testHandForTwoPairs(validHand1)[0], DeckOfCards.testHandForTwoPairs(validHand1)[1]);
       
       //valid hand at indexes (0 4, 1 3)
       Card [] validHand2 = {cards[0], cards[1], cards[2], cards[1], cards[0]};
       System.out.printf("%s %s %s\n", DeckOfCards.printHand(validHand2), DeckOfCards.testHandForTwoPairs(validHand2)[0], DeckOfCards.testHandForTwoPairs(validHand2)[1]);       
   }
   
   /**
    * test method: testHandForThreeOfAKind
    * @param cards, a set of cards from which to build hands for testing
    */
   private static void testHandForThreeOfAKindTest (Card [] cards){
       //empty hand
       Card [] emptyHand = null;
       System.out.printf("%s %s\n", DeckOfCards.printHand(emptyHand), DeckOfCards.testHandForThreeOfAKind(emptyHand));
       
       //Invalid hand
       Card [] invalidHand = {cards[0], cards[1], cards[2], cards[3], cards[4]};
       System.out.printf("%s %s\n", DeckOfCards.printHand(invalidHand), DeckOfCards.testHandForThreeOfAKind(invalidHand));       
       
       //valid hand at indexes (0, 2, 4)
       Card [] validHand1 = {cards[0], cards[1], cards[0], cards[2], cards[0]};
       System.out.printf("%s %s\n", DeckOfCards.printHand(validHand1), DeckOfCards.testHandForThreeOfAKind(validHand1));
       
       //valid hand at indexes (1, 2, 4)
       Card [] validHand2 = {cards[0], cards[1], cards[1], cards[2], cards[1]};
       System.out.printf("%s %s\n", DeckOfCards.printHand(validHand2), DeckOfCards.testHandForThreeOfAKind(validHand2));       
   }
   
   /**
    * test method: testHandForFourOfAKind
    * @param cards, a set of cards from which to build hands for testing
    */
   private static void testHandForFourOfAKindTest(Card [] cards){
       //empty hand
       Card [] emptyHand = null;
       System.out.printf("%s %s\n", DeckOfCards.printHand(emptyHand), DeckOfCards.testHandForFourOfAKind(emptyHand));
       
       //Invalid hand
       Card [] invalidHand = {cards[0], cards[1], cards[2], cards[3], cards[4]};
       System.out.printf("%s %s\n", DeckOfCards.printHand(invalidHand), DeckOfCards.testHandForFourOfAKind(invalidHand));       
       
       //valid hand at indexes (0 1 3 4)
       Card [] validHand1 = {cards[0], cards[0], cards[1], cards[0], cards[0]};
       System.out.printf("%s %s\n", DeckOfCards.printHand(validHand1), DeckOfCards.testHandForFourOfAKind(validHand1));
       
       //valid hand at indexes (1 2 3 4)
       Card [] validHand2 = {cards[0], cards[1], cards[1], cards[1], cards[1]};
       System.out.printf("%s %s\n", DeckOfCards.printHand(validHand2), DeckOfCards.testHandForFourOfAKind(validHand2));
    }
    
    /**
     * test method: testHandForFlush
     * @param cards, a set of cards from which to build hands for testing
     */
    private static void testHandForFlushTest(Card [] cards){       
       //empty hand
       Card [] emptyHand = null;
       System.out.printf("%s %s\n", DeckOfCards.printHand(emptyHand), DeckOfCards.testHandForFlush(emptyHand));
       
       //Invalid hand
       Card [] invalidHand = {cards[0], cards[1], cards[2], cards[3], cards[4]};
       System.out.printf("%s %s\n", DeckOfCards.printHand(invalidHand), DeckOfCards.testHandForFlush(invalidHand));       
       
       //valid hand
       Card [] validHand = {cards[0], cards[4], cards[0], cards[4], cards[0]};
       System.out.printf("%s %s\n", DeckOfCards.printHand(validHand), DeckOfCards.testHandForFlush(validHand));
    }
    
    /**
     * test method: testHandForStraight
     * @param cards, a set of cards from which to build hands for testing
     */
    private static void testHandForStraightTest(Card [] cards){       
       //empty hand
       Card [] emptyHand = null;
       System.out.printf("%s %s\n", DeckOfCards.printHand(emptyHand), DeckOfCards.testHandForStraight(emptyHand));
       
       //Invalid hand
       Card [] invalidHand = {cards[0], cards[1], cards[2], cards[3], cards[2]};
       System.out.printf("%s %s\n", DeckOfCards.printHand(invalidHand), DeckOfCards.testHandForStraight(invalidHand));       
       
       //valid hand
       Card [] validHand = {cards[0], cards[1], cards[2], cards[3], cards[4]};
       System.out.printf("%s %s\n", DeckOfCards.printHand(validHand), DeckOfCards.testHandForStraight(validHand));
    }
    
    /**
    * test method: testHandForFullHouse
    * @param cards, a set of cards from which to build hands for testing
    */
   private static void testHandForFullHouseTest(Card [] cards){
       //empty hand
       Card [] emptyHand = null;
       System.out.printf("%s %s\n", DeckOfCards.printHand(emptyHand), DeckOfCards.testHandForFullHouse(emptyHand));
       
       //hand with no two pairs
       Card [] invalidHand = {cards[0], cards[1], cards[2], cards[3], cards[4]};
       System.out.printf("%s %s\n", DeckOfCards.printHand(invalidHand), DeckOfCards.testHandForFullHouse(invalidHand));       
       
       //valid hand at indexes (0 1 2, 3 4)
       Card [] validHand1 = {cards[0], cards[0], cards[0], cards[3], cards[3]};
       System.out.printf("%s %s %s\n", DeckOfCards.printHand(validHand1), DeckOfCards.testHandForFullHouse(validHand1)[0], DeckOfCards.testHandForFullHouse(validHand1)[1]);
       
       //valid hand at indexes (0 2 4, 1 3)
       Card [] validHand2 = {cards[0], cards[1], cards[0], cards[1], cards[0]};
       System.out.printf("%s %s %s\n", DeckOfCards.printHand(validHand2), DeckOfCards.testHandForFullHouse(validHand2)[0], DeckOfCards.testHandForFullHouse(validHand2)[1]);       
    }

}