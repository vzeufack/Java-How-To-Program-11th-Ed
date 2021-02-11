package com.jhtp.chapter21.datastructures;

/**
 *
 * @author vannel
 */
public class SortedList extends List{   
   /**
    * Insert an item while maintaining order.
    * @param item: E
    */
   public void insert(Integer item){
      ListNode<Integer> nodeToInsert = new ListNode<>(item);
      if (this.isEmpty()){
         this.setFirstNode(nodeToInsert);
         this.setLastNode(nodeToInsert);
      }
      else{         
         ListNode<Integer> previous = null;
         ListNode<Integer> current = this.getFirstNode();
         
         while (current != null && current.getData() <= item){
            previous = current;
            current = current.nextNode;
         }
         
         if (previous == null){
            nodeToInsert.nextNode = this.getFirstNode();
            this.setFirstNode(nodeToInsert);
         }
         else{
            previous.nextNode = nodeToInsert;
            nodeToInsert.nextNode = current;
         }
      }
   }
   
   /**
    * Merges the given list into this list.
    * @param list:SortedList
    */
   public void merge(SortedList list){
      if (!list.isEmpty()){
         if (isEmpty()){
            this.setFirstNode(list.getFirstNode());
         }
         else{
            ListNode<Integer> current = list.getFirstNode();
            while (current != null){
               insert(current.getData());
               current = current.nextNode;
            }
         }
      }
   }
}
