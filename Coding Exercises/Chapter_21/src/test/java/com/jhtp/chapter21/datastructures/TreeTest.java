package com.jhtp.chapter21.datastructures;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TreeTest {
    @Test
    public void testGetDepthOfNullTree(){
        Tree<Integer> tree1 = new Tree<>();
        assertEquals(-1, tree1.getDepth());
    }
    
    @Test
    public void testGetDepthOfOneNodeTree(){
        Tree<Integer> tree = new Tree<>();
        tree.insertNode(0);
        assertEquals(0, tree.getDepth());
    }

    @Test
    public void testGetDepthOfTwoNodeTree(){
        Tree<Integer> tree = new Tree<>();
        tree.insertNode(2);
        tree.insertNode(1);
        assertEquals(1, tree.getDepth());
    }
    
    @Test
    public void testGetDepthWithComplexTree(){
        Tree<Integer> tree = new Tree<>();
        Integer[] array = {10,8,50,7,9,100,150,200};
        for (Integer element: array){
            tree.insertNode(element);
        }
        assertEquals(4, tree.getDepth());
    }
}
