import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Collections;

/**
  DuplicateElimination.java
  by Vannel Zeufack
  01 21 2021
  
  Reads in a series of first names and eliminates duplicates.
  The program also allow the user to search for a first name.
  */
public class DuplicateElimination{
   public static void main (String[] args){
      //read first names
      SortedSet<String> firstNames = new TreeSet<String>();
      Scanner scan = new Scanner(System.in);
      String firstName;
      
      do{
         System.out.print("Enter a first name or 0 (zero) to stop > ");
         firstName = scan.next();
         if(!firstName.equals("0"))
 	         firstNames.add(firstName.toUpperCase());
      }while(!firstName.equals("0")); 
      
      System.out.println(firstNames);
      
      //search for a first name
      String key;
      do{
         System.out.print("Enter a first name to search or 0 (zero) to stop > ");
         key = scan.next();
         if(!key.equals("0"))
	    if (firstNames.contains(key.toUpperCase())){
	       System.out.printf("\"%s\" is in the set%n", key);
	    }
	    else{
	       System.out.printf("\"%s\" is not in the set%n", key);
	    }
      }while (!key.equals("0"));
   }
}
