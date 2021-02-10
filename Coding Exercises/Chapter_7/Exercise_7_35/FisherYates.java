//Implements the Fisher Yates shuffling algorithm
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;

public class FisherYates{
    static SecureRandom random = new SecureRandom();
    
    //main method
    public static void main (String [] args){
        //number list to shuffle
        ArrayList <Integer> numList = new ArrayList<Integer>( 
            Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)); 
        
        System.out.print("Original list: " + numList);
        
        //shuffle
        fisherYatesShuffle(numList, 1);
        
        //display shuffled list
        System.out.print("\nShuffled list: " + numList);
    }
    
    //fisherYatesShuffle
    private static void fisherYatesShuffle (ArrayList <Integer> numList, int method){
        if (method == 1)
            origninalFisherYatesShuffle(numList);
        else if (method == 2)
            modernFisherYatesShuffle(numList);
        else{}
    }
    
    //OrigninalFisherYatesShuffle
    private static void origninalFisherYatesShuffle (ArrayList <Integer> numList){
        ArrayList <Integer> shuffledList = new ArrayList <Integer> (numList.size());
        int randomIndex;
        
        for (int i = numList.size(); i > 0; i--){
           randomIndex = random.nextInt(i);
           shuffledList.add(numList.get(randomIndex));
           numList.remove(randomIndex);
        }
        
        numList.addAll(shuffledList);
    }
    
    //modernFisherYatesShuffle
    private static void modernFisherYatesShuffle (ArrayList <Integer> numList){
        int randomIndex;
        int temp;
        
        for (int i = numList.size(); i > 0; i--){
           randomIndex = random.nextInt(i);
           temp = numList.get(randomIndex);
           numList.set(randomIndex, numList.get(i-1));
           numList.set(i-1, temp);
        }
    }
}