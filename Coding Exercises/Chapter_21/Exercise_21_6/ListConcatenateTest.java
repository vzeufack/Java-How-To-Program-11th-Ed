package Exercise_21_6;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListConcatenateTest {
    @Test
    public void concatenateTestWithNonEmptyLists(){
        Character[] list1Array = {'a', 'b'};
        Character[] list2Array = {'c'};
        Character[] concatenatedArray = {'a', 'b', 'c'};
        List<Character> list1 = new LinkedList<>(Arrays.asList(list1Array));
        List<Character> list2 = new LinkedList<>(Arrays.asList(list2Array));
        ListConcatenate.concatenate(list1, list2);
        assertEquals(Arrays.asList(concatenatedArray), list1);
    }

    @Test
    public void concatenateTestWithList1Null(){
        Character[] list2Array = {'c'};
        Character[] concatenatedArray = {'c'};
        List<Character> list2 = new LinkedList<>(Arrays.asList(list2Array));
        ListConcatenate.concatenate(null, list2);
        assertEquals(Arrays.asList(concatenatedArray), list2);
    }

    @Test
    public void concatenateTestWithList2Null(){
        Character[] list1Array = {'a', 'b'};
        Character[] concatenatedArray = {'a', 'b'};
        List<Character> list1 = new LinkedList<>(Arrays.asList(list1Array));
        ListConcatenate.concatenate(list1, null);
        assertEquals(Arrays.asList(concatenatedArray), list1);
    }

    @Test
    public void concatenateTestWithList1Empty(){
        Character[] list1Array = {};
        Character[] list2Array = {'c'};
        Character[] concatenatedArray = {'c'};
        List<Character> list1 = new LinkedList<>(Arrays.asList(list1Array));
        List<Character> list2 = new LinkedList<>(Arrays.asList(list2Array));
        ListConcatenate.concatenate(list1, list2);
        assertEquals(Arrays.asList(concatenatedArray), list1);
    }

    @Test
    public void concatenateTestWithList2Empty(){
        Character[] list1Array = {'a', 'b'};
        Character[] list2Array = {};
        Character[] concatenatedArray = {'a', 'b'};
        List<Character> list1 = new LinkedList<>(Arrays.asList(list1Array));
        List<Character> list2 = new LinkedList<>(Arrays.asList(list2Array));
        ListConcatenate.concatenate(list1, list2);
        assertEquals(Arrays.asList(concatenatedArray), list1);
    }
}