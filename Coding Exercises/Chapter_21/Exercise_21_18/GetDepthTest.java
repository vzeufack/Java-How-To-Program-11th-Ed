package Exercise_21_18;

import com.deitel.datastructures.Tree;

import java.security.SecureRandom;

public class GetDepthTest {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<Integer>();
        SecureRandom randomNumber = new SecureRandom();

        System.out.println("Inserting the following values: ");

        // insert 10 random integers from 0-99 in tree
        for (int i = 1; i <= 20; i++) {
            int value = randomNumber.nextInt(100);
            System.out.printf("%d ", value);
            tree.insertNode(value);
        }

        System.out.printf("\nThe tree depth is %d\n", tree.getDepth());
    }
}
