package Exercise_21_17;

import com.deitel.datastructures.Tree;

import java.security.SecureRandom;
import java.util.Scanner;

public class TreeOfStrings {
    public static void main(String[] args) {
        Tree<String> tree = new Tree<>();
        Scanner input = new Scanner(System.in);
        System.out.printf("Enter a sentence > ");
        String sentence = input.nextLine();
        String[] words = sentence.split(" ");

        for(String word: words){
            tree.insertNode(word);
        }

        System.out.printf("%n%nPreorder traversal%n");
        tree.preorderTraversal();

        System.out.printf("%n%nInorder traversal%n");
        tree.inorderTraversal();

        System.out.printf("%n%nPostorder traversal%n");
        tree.postorderTraversal();
        System.out.println();
    }
}
