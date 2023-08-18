package Exercise_21_24;

import com.deitel.datastructures.Tree;

public class LevelOrderBinaryTreeTraversal {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        tree.insertNode(100);
        tree.insertNode(50);
        tree.insertNode(150);
        tree.insertNode(25);
        tree.insertNode(75);
        tree.insertNode(125);
        tree.insertNode(175);
        tree.insertNode(10);
        tree.levelOrderTraversal();
    }
}
