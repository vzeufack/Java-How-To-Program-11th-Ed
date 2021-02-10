package com.jhtp.chapter21.datastructures;

/**
 *
 * @author vannel
 */
public class ListConcatenate {
   /**
    * Concatenates two linked lists of characters. 
    * The second list is appended to the first.
    * @param list1: List
    * @param list2: List
    */
   public static void concatenate(List<Character> list1, List<Character> list2){     
      if (!list1.isEmpty() || !list2.isEmpty()){
         if (list2.isEmpty()){}
         else if (list1.isEmpty()){
            ListNode<Character> current = list2.getFirstNode();
            while(current != null){
               list1.insertAtBack(current.getData());
               current = current.nextNode;
            }
         }
         else{
            list1.getLastNode().nextNode = list2.getFirstNode();            
         }
      }
   }
}
