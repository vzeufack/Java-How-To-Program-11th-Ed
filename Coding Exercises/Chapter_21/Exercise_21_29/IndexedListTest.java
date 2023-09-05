package Exercise_21_29;

import com.deitel.datastructures.IndexedList;

public class IndexedListTest {
    public static void main(String[] args) {

        IndexedList indexedList = new IndexedList();

        //insertion test
        indexedList.insertInIndexedList("test");
        indexedList.insertInIndexedList("michael");
        indexedList.insertInIndexedList("zebra");
        indexedList.insertInIndexedList("maxwell");
        indexedList.print();
        System.out.println();

        //search test
        System.out.println("result after searching: Maxwell");
        System.out.println(indexedList.searchInIndexedList("Maxwell"));
        System.out.println("result after searching: testing");
        System.out.println(indexedList.searchInIndexedList("testing"));
        System.out.println();

        //delete test
        indexedList.deleteInIndexedList("maxwell");
        System.out.println("After deleting: maxwell");
        indexedList.print();
        indexedList.deleteInIndexedList("test");
        System.out.println("After deleting: test");
        indexedList.print();
        System.out.println("After deleting: zebra");
        indexedList.deleteInIndexedList("zebra");
        indexedList.print();
    }
}
