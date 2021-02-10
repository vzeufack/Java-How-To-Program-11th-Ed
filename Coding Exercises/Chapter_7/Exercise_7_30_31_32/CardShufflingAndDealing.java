/**
 * Simulates card shuffling and dealing
 */
 import java.security.SecureRandom;

public class CardShufflingAndDealing{
    private static final int HAND_SIZE = 5;
    private static DeckOfCards myDeckOfCards = new DeckOfCards();
    private static final SecureRandom randomNumbers = new SecureRandom();
    
    public static void main (String [] args){
        myDeckOfCards.shuffle(); // place Cards in random order
        Card [] dealerHand = new Card [HAND_SIZE];
        int dealerHandValue;
                 
        for (int i = 0; i < HAND_SIZE; i++){
            dealerHand[i] = myDeckOfCards.dealCard();
        }
        
        System.out.print("Dealer's hand: ");
        System.out.println(DeckOfCards.printHand(dealerHand));        
        
        dealerHandValue = getHandValue(dealerHand);
        System.out.printf("Value: %d => %s\n", dealerHandValue,  getHandValueAsString(dealerHand)); 
        System.out.printf("Dealear should draw: %d cards\n", getAmountOfCardsTobeDrawn(dealerHandValue));
        
        /**
         Dealear's hand: <Nine of Clubs - Three of Clubs - Deuce of Diamonds - King of Clubs - Nine of Spades>
         Value: pair => 14
         Number of cards to be drawn: 3
         Cards to replace: Three of Clubs - Deuce of Diamonds - King of Clubs          
         **/  
    }
    
    /**
     * Determines the hand's value
     * @param the hand
     * @return the hand value
     */
    private static int getHandValue(Card [] hand){
        if (DeckOfCards.testHandForFourOfAKind(hand) != null)
            return 20;
        else if (DeckOfCards.testHandForFullHouse(hand) != null)
            return 19;
        else if (DeckOfCards.testHandForFlush(hand))
            return 18;
        else if (DeckOfCards.testHandForStraight(hand))
            return 17;        
        else if (DeckOfCards.testHandForThreeOfAKind(hand) != null)
            return 16;
        else if (DeckOfCards.testHandForTwoPairs(hand) != null)
            return 15;
        else if (DeckOfCards.testHandforPair(hand) != null)
            return 14;
        else
            return DeckOfCards.getFaceValue(getBestCard(hand).getFace());
    }
    
    /**
     * 
     */
    private static void compareHands (Card [] hand1, Card [] hand2){
        int hand1Value = getHandValue(hand1);
        int hand2Value = getHandValue(hand2);
        System.out.printf("Hand 1: %d | hand 2: %d\n", hand1Value, hand2Value);
        if (hand1Value > hand2Value)
            System.out.println("Hand 1 is better than hand 2");
        else if (hand1Value < hand2Value)
            System.out.println("Hand 2 is better than hand 1");
        else
            System.out.println("Both hands have same value");
    }
    
    //returns the best card in the hand
    private static Card getBestCard (Card [] hand){
        int maxValue = DeckOfCards.getFaceValue(hand[0].getFace());
        int currentValue;
        int maxIndex = 0;
        for (int i = 1; i < hand.length; i++){
            currentValue = DeckOfCards.getFaceValue(hand[i].getFace());
            if (currentValue > maxValue){
                maxValue = currentValue;
                maxIndex = i;
            }
        }
        return hand[maxIndex];
    }
    
    //drawCards
    private static void drawCards (Card [] hand){
        if (getHandValue(hand) < 14){
            //sort(hand);
            for (int i = 0; i < 3; i++){
            
            }
        }
    }
    
   // shuffle deck of Cards with one-pass algorithm
   private static void shuffle(Card [] hand) {
      
      int currentCard = 0; 
      for (int first = 0; first < hand.length; first++) {
         int second = randomNumbers.nextInt(hand.length);
         Card temp = hand[first];   
         hand[first] = hand[second];
         hand[second] = temp;       
      } 
   }
}