package com.jhtp.chapter21.exo_21_19;

import java.security.SecureRandom;
import com.jhtp.chapter21.datastructures.Tree;

/**
 * uses Tree.getDepth to provide the depth of a randomly generated tree.
 */
public class BTreeDepth {
    public static void main (String[] args){
        Tree<Integer> tree = new Tree<>();
        SecureRandom randomNumberGenerator = new SecureRandom();

        for (int i = 0; i < 20; i ++){
            int number = randomNumberGenerator.nextInt(101);
            System.out.printf("%d", number);
            if (i+1 < 20)
                System.out.print(" ");
            tree.insertNode(number);
        }
        System.out.println();

        System.out.printf("Depth = %d\n", tree.getDepth());
    }
}
