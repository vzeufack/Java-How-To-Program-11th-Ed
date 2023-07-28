// Fig. 21.15: Tree.java
// TreeNode and Tree class declarations for a binary search tree.
package com.deitel.datastructures;

// class TreeNode definition
class TreeNode<E extends Comparable<E>> {
   // package access members
   TreeNode<E> leftNode;
   E data; // node value
   int count;
   TreeNode<E> rightNode;

   // constructor initializes data and makes this a leaf node
   public TreeNode(E nodeData) {
      data = nodeData;
      count = 1;              
      leftNode = rightNode = null; // node has no children
   } 

   // locate insertion point and insert new node; ignore duplicate values
   public void insert(E insertValue) {
      // insert in left subtree
      if (insertValue.compareTo(data) < 0) {
         // insert new TreeNode
         if (leftNode == null) {
            leftNode = new TreeNode<E>(insertValue);
         }
         else { // continue traversing left subtree recursively
            leftNode.insert(insertValue); 
         }
      } 
      // insert in right subtree
      else if (insertValue.compareTo(data) > 0) {
         // insert new TreeNode
         if (rightNode == null) {
            rightNode = new TreeNode<E>(insertValue);
         }
         else { // continue traversing right subtree recursively
            rightNode.insert(insertValue); 
         }
      } 
      else{
        this.count = this.count + 1;
      }
   }
   public static int getDepth(TreeNode root){
      if(root == null)
         return 0;

      int leftSubTreeDepth = 1 + getDepth(root.leftNode);
      int rightSubTreeDepth = 1 + getDepth(root.rightNode);
      return Math.max(leftSubTreeDepth, rightSubTreeDepth);
   }
} 

// class Tree definition
public class Tree<E extends Comparable<E>> {
   private TreeNode<E> root;

   // constructor initializes an empty Tree of integers
   public Tree() {root = null;}

   // insert a new node in the binary search tree
   public void insertNode(E insertValue) {
      if (root == null) {
         root = new TreeNode<E>(insertValue); // create root node
      }
      else {
         root.insert(insertValue); // call the insert method
      }
   } 

   // begin preorder traversal 
   public void preorderTraversal() {preorderHelper(root);}

   // recursive method to perform preorder traversal
   private void preorderHelper(TreeNode<E> node) {
      if (node == null) {
         return;
      }

      for(int i = 0; i < node.count; i++)
        System.out.printf("%s ", node.data); // output node data
      preorderHelper(node.leftNode); // traverse left subtree  
      preorderHelper(node.rightNode); // traverse right subtree
   } 

   // begin inorder traversal
   public void inorderTraversal() {inorderHelper(root);}

   // recursive method to perform inorder traversal
   private void inorderHelper(TreeNode<E> node) {
      if (node == null) {
         return;
      }

      inorderHelper(node.leftNode); // traverse left subtree
      for(int i = 0; i < node.count; i++)
        System.out.printf("%s ", node.data); // output node data
      inorderHelper(node.rightNode); // traverse right subtree
   } 

   // begin postorder traversal
   public void postorderTraversal() {postorderHelper(root);}

   // recursive method to perform postorder traversal
   private void postorderHelper(TreeNode<E> node) {
      if (node == null) {
         return;
      }
  
      postorderHelper(node.leftNode); // traverse left subtree  
      postorderHelper(node.rightNode); // traverse right subtree
      for(int i = 0; i < node.count; i++)
        System.out.printf("%s ", node.data); // output node data
   }

   public int getDepth(){
      return TreeNode.getDepth(root);
   }
}


/**************************************************************************
 * (C) Copyright 1992-2018 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/

