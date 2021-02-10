import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.LinkedList;


public class OrderedLinkedListTest {
   LinkedList<Integer> expectedList1, expectedList2, expectedList3;

   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {      
      expectedList1 = new LinkedList<>();
      
      expectedList2 = new LinkedList<>();
      expectedList2.add(1);
      expectedList2.add(2);
      expectedList2.add(3);
      
      expectedList3 = new LinkedList<>();
      expectedList3.add(-100);
      expectedList3.add(4);
      expectedList3.add(87);
      expectedList3.add(299);
      expectedList3.add(1000);
   }
   
   /**
     * Tests buildSortedLinkedList
     */
   @Test public void buildSortedLinkedListTest(){
      Integer[] testCase1 = new Integer[25];
      Integer[] testCase2 = {3,2,1};
      Integer[] testCase3 = {-100,1000,87,299,4};
      
      Assert.assertEquals(expectedList1, OrderedLinkedList.buildSortedLinkedList(testCase1));
      Assert.assertEquals(expectedList2, OrderedLinkedList.buildSortedLinkedList(testCase2));
      Assert.assertEquals(expectedList3, OrderedLinkedList.buildSortedLinkedList(testCase3));
   }
   
   /**
    * Tests sum
    */
   @Test public void sumTest(){
      Assert.assertEquals(null, OrderedLinkedList.sum(expectedList1));
      Assert.assertTrue(6 == OrderedLinkedList.sum(expectedList2));
      Assert.assertTrue(1290 == OrderedLinkedList.sum(expectedList3));
   }
   
   /**
    * Tests sum
    */
   @Test public void averageTest(){
      Assert.assertEquals(null, OrderedLinkedList.average(expectedList1));
      Assert.assertTrue(2f == OrderedLinkedList.average(expectedList2));
      Assert.assertTrue(258f == OrderedLinkedList.average(expectedList3));
   }
}
