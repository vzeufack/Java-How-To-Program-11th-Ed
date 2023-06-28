package Exercise_21_7;

// Fig. 21.3: List.java
// ListNode and List class declarations.
//package com.deitel.datastructures;

import java.util.NoSuchElementException;

// class to represent one node in a list
class ListNode<E extends Comparable> {
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
}

// class List definition
public class SortedList<E extends Comparable> {
    private ListNode<E> firstNode;
    private ListNode<E> lastNode;
    private String name; // string like "list" used in printing

    // constructor creates empty List with "list" as the name
    public SortedList() {this("list");}

    // constructor creates an empty List with a name
    public SortedList(String listName) {
        name = listName;
        firstNode = lastNode = null;
    }

    public void insert(E insertItem){
        ListNode<E> newNode = new ListNode<E>(insertItem);

        if (isEmpty()) {
            firstNode = lastNode = newNode;
        }
        else if(firstNode.data.compareTo(newNode.data) > 0) {
            firstNode = new ListNode<E>(insertItem, firstNode);
        }
        else {
            ListNode<E> current = firstNode;
            while (current.nextNode != null && current.nextNode.data.compareTo(newNode.data) <= 0) {
                current = current.nextNode;
            }
            ListNode<E> next = current.nextNode;
            current.nextNode = newNode;
            newNode.nextNode = next;
        }
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

    public void merge(SortedList<E> list){
        ListNode<E> current = list.firstNode;
        while(current != null){
            this.insert(current.data);
            current = current.nextNode;
        }
    }

    public boolean isEqual(SortedList<E> list){
        if(isEmpty() && list.isEmpty())
            return true;

        ListNode<E> current1 = this.firstNode;
        ListNode<E> current2 = list.firstNode;
        while(current1 != null && current2 != null && current1.data.compareTo(current2.data) == 0) {
            current1 = current1.nextNode;
            current2 = current2.nextNode;
        }

        return current1 == current2;
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

