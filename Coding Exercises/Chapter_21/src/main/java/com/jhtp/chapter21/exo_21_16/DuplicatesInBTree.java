package com.jhtp.chapter21.exo_21_16;

import java.security.SecureRandom;

import com.jhtp.chapter21.datastructures.Tree;

/**
 * Tests the insertion of duplicates in a binary tree
 */
public class DuplicatesInBTree {
    public static void main(String[] args) {
        SecureRandom randomNumber = new SecureRandom();
        Tree<Integer> tree = new Tree<Integer>();

        for (int i = 1; i <= 20; i++) {
            int value = randomNumber.nextInt(100);
            System.out.printf("%d ", value);
            tree.insertNode(value);
        }
        System.out.println();
        tree.inorderTraversal();
        System.out.println();
    }
}
