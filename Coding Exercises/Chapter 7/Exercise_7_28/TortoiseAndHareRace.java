/**
 * TortoiseAndHareRace by Vannel 6/11/2019
 * Simulates a Tortoise and Hare race
 */
 
 import java.security.SecureRandom;
 import java.util.Arrays;
 import java.util.ArrayList;

public class TortoiseAndHareRace{
    private static final int NUMBER_OF_SQUARES = 70;
    private static String [] squares = new String[NUMBER_OF_SQUARES];

    public static void main (String [] args){
        SecureRandom random = new SecureRandom();        
        int randNum;
        boolean lastSquareReached = false;
        Tortoise t = new Tortoise(1);
        Hare h = new Hare(1);
            
        while (lastSquareReached == false){
            randNum = 1 + random.nextInt(10);
            t.move(randNum);
            h.move(randNum);
            System.out.printf("%2d ", randNum);
            displayRaceState(t.getPosition(), h.getPosition());
            lastSquareReached = rewardWinner(t.getPosition(), h.getPosition());
        }
    }
           
    //rewardWinner
    private static boolean rewardWinner(int t, int h){
        if (t >= NUMBER_OF_SQUARES && h < NUMBER_OF_SQUARES){
            System.out.println( "Tortoise WINS!!! YAY!!!" );
            return true;
        }
        else if (h >= NUMBER_OF_SQUARES && t < NUMBER_OF_SQUARES){
            System.out.println("Hare wins. Yuch.");
            return true;
        }
        else if (h >= NUMBER_OF_SQUARES && t >= NUMBER_OF_SQUARES){
            System.out.println("It's a tie.");
            return true;
        }
        else {return false;} 
    }
    
    //Display's the runner's positions
    private static void displayRaceState(int t, int h){
        Arrays.fill(squares, null);
        
        if (t > NUMBER_OF_SQUARES)
           t = NUMBER_OF_SQUARES;
        if (h > NUMBER_OF_SQUARES)
           h = NUMBER_OF_SQUARES;
           
        if (t == h){            
            squares[t-1] = "OUCH!!!";
        }
        else{
            squares[t-1] = "T";
            squares[h-1] = "H";
        }
        
        for (int i = 0; i < squares.length; i++){
            if (squares[i] == null)
                System.out.printf("%2s ", "*");
            else
                System.out.printf("%2s ", squares[i]);
        }
        System.out.println();
    }
    
    //test
    private static void test(){        
        /*test reward winner
        int [] t = {1,70, 3, 71, 75, 15, 80};
        int [] h = {1,25,70, 71, 30, 90, 80};
        for (int i = 0; i < t.length; i++){
            System.out.printf("T: %2d - H: %2d - Ouptut: %s\n", t[i], h[i], rewardWinner(t[i], h[i]));
        }
        
        //test display race state
        int [] t = {10, 3, 23};
        int [] h = {10, 4, 70};
        for (int i = 0; i < t.length; i++){
            displayRaceState(t[i], h[i]);
        }*/
    }
}