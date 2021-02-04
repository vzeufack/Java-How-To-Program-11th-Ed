import java.util.Arrays;
import java.util.LinkedList;
import java.util.Collections;

/**
  * ReverseLinkedList.java by Vannel 2/4/2021
  * Reverses a linkedList of 10 characters and prints it
  */
public class ReverseLinkedList{
  public static void main (String[] args){
     Character[] characterArray = {'A', 'B','C','D','E','F','G','H','I','J'};
     LinkedList<Character> originalList = new LinkedList<>(Arrays.asList(characterArray));
     System.out.printf("Original List: %s%n", originalList);
     
     LinkedList<Character> reversedList = reverse(originalList);
     System.out.printf("Reversed List: %s%n", reversedList);
  }
   
  public static LinkedList<Character> reverse(LinkedList<Character> list){
     LinkedList<Character> reversedList = new LinkedList<>(list);
     Collections.reverse(reversedList);
     return reversedList;
   }
}