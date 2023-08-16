package Exercise_21_22;

import com.deitel.datastructures.Tree;

import java.security.SecureRandom;
import java.util.Scanner;

public class BinaryTreeDeleteTest {
    public static void main(String[] args) {
        testDeleteFromEmptyTree();
        testDeleteRootWithNoChildren();
        testDeleteRootWithLeftChildOnly();
        testDeleteRootWithRightChildOnly();
        testDeleteRootTwoChildren();
        testDeleteRootTwoChildrenAndReplacementHasLeft();
        testDeleteNodeWhichIsLeafButNotRoot();
        testDeleteNodeWhichHasLeftChildAndIsNotRoot();
        testDeleteNodeWhichHasRightChildAndIsNotRoot();
        testDeleteNodeWhichHasTwoChildrenAndIsNotRoot();
        testDeleteValueNotInTree();
        testDeleteValueNotInTree();
    }


    private static void testDeleteFromEmptyTree(){
        System.out.println("Case - Delete from empty tree");

        Tree<Integer> tree = new Tree<Integer>();
        System.out.println("Before deletion:");
        tree.print();
        System.out.println("\n");

        tree.deleteNode(10);

        System.out.println("After deleting 10:");
        tree.print();
        System.out.println("\n");
    }

    private static void testDeleteRootWithNoChildren(){
        System.out.println("Case - Delete root with no children");

        Tree<Integer> tree = new Tree<Integer>();
        tree.insertNode(10);

        System.out.println("Before deletion:");
        tree.print();
        System.out.println("\n");

        tree.deleteNode(10);
        System.out.println("After deleting 10:");
        tree.print();
        System.out.println("\n");
    }

    private static void testDeleteRootWithLeftChildOnly(){
        System.out.println("Case - Delete root with left child only");

        Tree<Integer> tree = new Tree<Integer>();
        tree.insertNode(10);
        tree.insertNode(5);

        System.out.println("Before deletion:");
        tree.print();
        System.out.println("\n");

        tree.deleteNode(10);
        System.out.println("After deleting 10:");
        tree.print();
        System.out.println("\n");
    }

    private static void testDeleteRootWithRightChildOnly(){
        System.out.println("Case - Delete root with right child only");

        Tree<Integer> tree = new Tree<Integer>();
        tree.insertNode(10);
        tree.insertNode(20);

        System.out.println("Before deletion:");
        tree.print();
        System.out.println("\n");

        tree.deleteNode(10);
        System.out.println("After deleting 10:");
        tree.print();
        System.out.println("\n");
    }

    private static void testDeleteRootTwoChildren(){
        System.out.println("Case - Delete root with two children");

        Tree<Integer> tree = new Tree<Integer>();
        tree.insertNode(10);
        tree.insertNode(5);
        tree.insertNode(20);

        System.out.println("Before deletion:");
        tree.print();
        System.out.println("\n");

        tree.deleteNode(10);
        System.out.println("After deleting 10:");
        tree.print();
        System.out.println("\n");
    }

    private static void testDeleteRootTwoChildrenAndReplacementHasLeft(){
        System.out.println("Case - Delete root with two children and replacement has left");

        Tree<Integer> tree = new Tree<Integer>();
        tree.insertNode(10);
        tree.insertNode(5);
        tree.insertNode(20);
        tree.insertNode(15);

        System.out.println("Before deletion:");
        tree.print();
        System.out.println("\n");

        tree.deleteNode(10);
        System.out.println("After deleting 10:");
        tree.print();
        System.out.println("\n");
    }

    private static void testDeleteNodeWhichIsLeafButNotRoot(){
        System.out.println("Case - Delete node which is leaf but not root");

        Tree<Integer> tree = new Tree<Integer>();
        tree.insertNode(5);
        tree.insertNode(2);
        tree.insertNode(10);

        System.out.println("Before deletion:");
        tree.print();
        System.out.println("\n");

        tree.deleteNode(10);

        System.out.println("After deleting 10:");
        tree.print();
        System.out.println("\n");
    }

    private static void testDeleteNodeWhichHasLeftChildAndIsNotRoot(){
        System.out.println("Case - Delete node which has left child and is not root");

        Tree<Integer> tree = new Tree<Integer>();
        tree.insertNode(5);
        tree.insertNode(2);
        tree.insertNode(10);
        tree.insertNode(7);

        System.out.println("Before deletion:");
        tree.print();
        System.out.println("\n");

        tree.deleteNode(10);

        System.out.println("After deleting 10:");
        tree.print();
        System.out.println("\n");
    }

    private static void testDeleteNodeWhichHasRightChildAndIsNotRoot(){
        System.out.println("Case - Delete node which has right child and is not root");

        Tree<Integer> tree = new Tree<Integer>();
        tree.insertNode(5);
        tree.insertNode(2);
        tree.insertNode(10);
        tree.insertNode(15);

        System.out.println("Before deletion:");
        tree.print();
        System.out.println("\n");

        tree.deleteNode(10);

        System.out.println("After deleting 10:");
        tree.print();
        System.out.println("\n");
    }

    private static void testDeleteNodeWhichHasTwoChildrenAndIsNotRoot(){
        System.out.println("Case - Delete node which has two children and is not root");

        Tree<Integer> tree = new Tree<Integer>();
        tree.insertNode(5);
        tree.insertNode(2);
        tree.insertNode(10);
        tree.insertNode(7);
        tree.insertNode(15);

        System.out.println("Before deletion:");
        tree.print();
        System.out.println("\n");

        tree.deleteNode(10);

        System.out.println("After deleting 10:");
        tree.print();
        System.out.println("\n");
    }

    private static void testDeleteValueNotInTree(){
        System.out.println("Case - Value not in tree");

        Tree<Integer> tree = new Tree<Integer>();
        tree.insertNode(5);
        tree.insertNode(2);
        tree.insertNode(10);
        tree.insertNode(7);
        tree.insertNode(15);

        System.out.println("Before deletion:");
        tree.print();
        System.out.println("\n");

        tree.deleteNode(100);

        System.out.println("After deleting 100:");
        tree.print();
        System.out.println("\n");
    }
}
