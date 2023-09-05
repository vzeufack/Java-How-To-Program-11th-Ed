package com.deitel.datastructures;

public class IndexEntry implements Comparable<IndexEntry> {
    private Character letter;
    private int count;
    private IndexedListNode firstItemOfList;

    public IndexEntry(char c){
        this.letter = c;
        this.firstItemOfList = null;
        count = 1;
    }

    public IndexEntry(char c, IndexedListNode firstElementOfList){
        this.letter = c;
        this.firstItemOfList = firstElementOfList;
        count = 1;
    }

    public Character getLetter(){
        return letter;
    }

    public IndexedListNode getFirstElementOfList(){
        return firstItemOfList;
    }

    public int getCount(){
        return count;
    }

    public void setCount(int count){
        this.count = count;
    }

    public void setFirstItemOfList(IndexedListNode firstItemOfList){
        this.firstItemOfList = firstItemOfList;
    }

    @Override
    public int compareTo(IndexEntry o) {
        return letter.compareTo(o.letter);
    }
}
