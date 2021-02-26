/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhtp.chapter21.datastructures;

import java.util.NoSuchElementException;

// class to represent one node in a list
class ListNode<E> {
   // package access members; List can access these directly
   E data; // data for this node
   ListNode<E> nextNode; // reference to the next node in the list

   // constructor creates a ListNode that refers to object
   ListNode(E object) {this(object, null);}

   // constructor creates ListNode that refers to the specified
   // object and to the next ListNode
   ListNode(E object, ListNode<E> node) {
      data = object;    
      nextNode = node;  
   } 

   // return reference to data in node
   E getData() {return data;}

   // return reference to next node in list
   ListNode<E> getNext() {return nextNode;}
   
   //compares two list nodes
   boolean equals(ListNode<E> node){      
      ListNode<E> current1 = this;
      ListNode<E> current2 = node;
      
      while (current1 != null && current2 != null){
         if (!current1.getData().toString().equals(current2.getData().toString())){
            System.out.printf("%s != %s%n", current1.getData(), current2.getData());
            return false;
         }         
         current1 = current1.nextNode;
         current2 = current2.nextNode;
      }
      
      return (current1 == null && null == current2);
   }
} 

// class List definition
public class List<E> {
   private ListNode<E> firstNode;
   private ListNode<E> lastNode; 
   private String name; // string like "list" used in printing

   // constructor creates empty List with "list" as the name
   public List() {this("list");}

   // constructor creates an empty List with a name
   public List(String listName) {
      name = listName;
      firstNode = lastNode = null;
   }
   
   //first node accessor
   public ListNode<E> getFirstNode(){
      return firstNode;
   }
   
   public void setFirstNode(ListNode<E> newFirstNode){
      this.firstNode = newFirstNode;
   }
   
   //last node accessor
   public ListNode<E> getLastNode(){
      return lastNode;
   }
   
   public void setLastNode(ListNode<E> newLastNode){
      this.lastNode = newLastNode;
   }

   // insert item at front of List
   public void insertAtFront(E insertItem) {
      if (isEmpty()) { // firstNode and lastNode refer to same object
         firstNode = lastNode = new ListNode<E>(insertItem);
      } 
      else { // firstNode refers to new node
         firstNode = new ListNode<E>(insertItem, firstNode);
      } 
   } 

   // insert item at end of List
   public void insertAtBack(E insertItem) {
      if (isEmpty()) { // firstNode and lastNode refer to same object
         firstNode = lastNode = new ListNode<E>(insertItem);
      } 
      else { // lastNode's nextNode refers to new node
         lastNode = lastNode.nextNode = new ListNode<E>(insertItem);
      } 
   } 

   // remove first node from List
   public E removeFromFront() throws NoSuchElementException {
      if (isEmpty()) { // throw exception if List is empty
         throw new NoSuchElementException(name + " is empty");
      }

      E removedItem = firstNode.data; // retrieve data being removed

      // update references firstNode and lastNode 
      if (firstNode == lastNode) {
         firstNode = lastNode = null;
      }
      else {
         firstNode = firstNode.nextNode;
      }

      return removedItem; // return removed node data
   } 

   // remove last node from List
   public E removeFromBack() throws NoSuchElementException {
      if (isEmpty()) { // throw exception if List is empty
         throw new NoSuchElementException(name + " is empty");
      }

      E removedItem = lastNode.data; // retrieve data being removed

      // update references firstNode and lastNode
      if (firstNode == lastNode) {
         firstNode = lastNode = null;
      }
      else { // locate new last node
         ListNode<E> current = firstNode;

         // loop while current node does not refer to lastNode
         while (current.nextNode != lastNode) {
            current = current.nextNode;
         }
   
         lastNode = current; // current is new lastNode
         current.nextNode = null;
      } 

      return removedItem; // return removed node data
   } 

   // determine whether list is empty; returns true if so
   public boolean isEmpty() {return firstNode == null;}

   // output list contents
   public void print() {
      if (isEmpty()) {
         System.out.printf("Empty %s%n", name);
         return;
      } 

      System.out.printf("The %s is: ", name);
      ListNode<E> current = firstNode;

      // while not at end of list, output current node's data
      while (current != null) {
         System.out.printf("%s ", current.data);
         current = current.nextNode;
      } 

      System.out.println();
   } 
   
   @Override
   public boolean equals(Object obj){
      if (!(obj instanceof List)){
         return false;
      }
      else{      
         List<E> list = (List<E>) obj;
         if (isEmpty() && list.isEmpty())
            return true;
         if (isEmpty() || list.isEmpty())
            return false;
         return this.firstNode.equals(list.firstNode);
      }
   }
   
   /**
    * Reverses a given list.
    * @param list: List
    *    The list to reverse.
    * @return The reversed list.
    */
   public static List reverseCopy(List list){
      List reversedCopy = new List();
      
      if (list.isEmpty())
         return reversedCopy;
      
      ListNode current = list.getFirstNode();
      while(current != null){
         reversedCopy.insertAtFront(current.getData());
         current = current.nextNode;
      }
      return reversedCopy;
   }
   
   //determines the number of items of a list
   public int size(){      
      if (isEmpty()){
         return 0;
      }
      else{
         int numberOfItems = 0;
         ListNode<E> current = getFirstNode();
         while(current != null){
            numberOfItems++;
            current = current.nextNode;
         }
         return numberOfItems;
      }
   }
}
