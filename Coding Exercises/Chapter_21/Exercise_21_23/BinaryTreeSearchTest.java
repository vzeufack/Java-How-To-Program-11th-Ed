package Exercise_21_23;

import com.deitel.datastructures.Tree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryTreeSearchTest {
    @Test
    public void testContainsInNonEmptyTree(){
        Tree<Integer> tree = new Tree<>();
        tree.insertNode(10);
        tree.insertNode(5);
        tree.insertNode(-6);
        tree.insertNode(100);
        tree.insertNode(3);
        tree.insertNode(1);

        assertEquals(10, tree.contains(10));
        assertEquals(5, tree.contains(5));
        assertEquals(100, tree.contains(100));
        assertEquals(-6, tree.contains(-6));
        assertEquals(null, tree.contains(1000));
    }

    @Test
    public void testContainsInEmptyTree(){
        Tree<Integer> tree = new Tree<>();
        assertEquals(null, tree.contains(1000));
    }
}
