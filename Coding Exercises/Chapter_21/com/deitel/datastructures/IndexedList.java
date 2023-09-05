package com.deitel.datastructures;

import java.util.NoSuchElementException;

class IndexedListNode {
    String data;
    IndexedListNode nextNode;

    IndexedListNode(String str) {this(str, null);}

    IndexedListNode(String str, IndexedListNode node) {
        data = str;
        nextNode = node;
    }

    String getData() {return data;}

    IndexedListNode getNext() {return nextNode;}
}
public class IndexedList {
    private IndexedListNode firstNode;
    private String name;
    private Tree<IndexEntry> index = new Tree<>();

    public IndexedList() {this("list");}

    public IndexedList(String listName) {
        name = listName;
        firstNode = null;
    }

    public void insertInIndexedList(String s){
        IndexedListNode newNode = new IndexedListNode(s);
        IndexEntry indexEntry = index.contains(new IndexEntry(Character.toLowerCase(s.charAt(0))));
        if(indexEntry != null){
            indexEntry.setCount(indexEntry.getCount() + 1);
            IndexedListNode firstElement = indexEntry.getFirstElementOfList();
            IndexedListNode nextOfFirst = firstElement.nextNode;
            firstElement.nextNode = newNode;
            newNode.nextNode = nextOfFirst;
        }
        else{
            indexEntry = new IndexEntry(Character.toLowerCase(s.charAt(0)), newNode);
            index.insertNode(indexEntry);

            if(!isEmpty())
                newNode.nextNode = firstNode;

            firstNode = newNode;
        }
    }

    public String searchInIndexedList(String key){
        Character firstLetter = Character.toLowerCase(key.charAt(0));
        IndexEntry indexEntry = index.contains(new IndexEntry(firstLetter));
        if(indexEntry != null) {
            IndexedListNode current = indexEntry.getFirstElementOfList();
            while(current != null && !current.data.equalsIgnoreCase(key) && firstLetter.compareTo(current.data.charAt(0)) == 0){
                current = current.nextNode;
            }

            if(current != null && current.data.equalsIgnoreCase(key))
                return current.data;
        }

        return null;
    }

    public String deleteInIndexedList(String itemToRemove) throws NoSuchElementException{
        if (isEmpty()) {
            throw new NoSuchElementException(name + " is empty");
        }
        else if (firstNode.data.compareTo(itemToRemove) == 0){
            String removedItem = firstNode.data;

            if (firstNode.nextNode == null) {
                firstNode = null;
            }
            else {
                firstNode = firstNode.nextNode;
            }
            return removedItem;
        }
        else {
            Character firstLetter = Character.toLowerCase(itemToRemove.charAt(0));
            IndexEntry indexEntry = index.contains(new IndexEntry(firstLetter));
            if(indexEntry == null){
                throw new NoSuchElementException(String.format("%s is not in the list!", itemToRemove));
            }
            else{
                IndexedListNode current = indexEntry.getFirstElementOfList();
                if(current.data.equalsIgnoreCase(itemToRemove)){
                    current = firstNode;
                }
                IndexedListNode previous = null;

                while (current != null && current.data.compareToIgnoreCase(itemToRemove) != 0) {
                    previous = current;
                    current = current.nextNode;
                }
                if (current == null)
                    throw new NoSuchElementException(String.format("%s is not in the list!", itemToRemove));
                else{
                    if(indexEntry.getCount() == 1)
                        index.deleteNode(indexEntry);
                    else
                        indexEntry.setCount(indexEntry.getCount() - 1);

                    String removedItem = current.data;
                    previous.nextNode = current.nextNode;
                    return removedItem;
                }
            }
        }
    }

    public boolean isEmpty() {return firstNode == null;}

    public void print() {
        if (isEmpty()) {
            System.out.printf("Empty %s%n", name);
            return;
        }

        System.out.printf("The %s is: ", name);
        IndexedListNode current = firstNode;

        while (current != null) {
            System.out.printf("%s ", current.data);
            current = current.nextNode;
        }

        System.out.println();
    }
}
