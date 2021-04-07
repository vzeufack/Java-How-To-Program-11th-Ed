// TreeNode and Tree class declarations for a binary search tree.
package com.jhtp.chapter21.datastructures;

// class TreeNode definition
class TreeNode<E extends Comparable<E>> {
   // package access members
   TreeNode<E> leftNode;
   List<E> dataList;
   TreeNode<E> rightNode;

   // constructor initializes data and makes this a leaf node
   public TreeNode(E nodeData) { 
      dataList = new List<E>();
      dataList.insertAtBack(nodeData);         
      leftNode = rightNode = null; // node has no children
   } 

   // locate insertion point and insert new node; ignore duplicate values
   public void insert(E insertValue) {
      // insert in left subtree
      if (insertValue.compareTo(dataList.getFirstNode().getData()) < 0) {
         // insert new TreeNode
         if (leftNode == null) {
            leftNode = new TreeNode<E>(insertValue);
         }
         else { // continue traversing left subtree recursively
            leftNode.insert(insertValue); 
         }
      } 
      // insert in right subtree
      else if (insertValue.compareTo(dataList.getFirstNode().getData()) > 0) {
         // insert new TreeNode
         if (rightNode == null) {
            rightNode = new TreeNode<E>(insertValue);
         }
         else { // continue traversing right subtree recursively
            rightNode.insert(insertValue); 
         }
      } 
      else{
         dataList.insertAtBack(insertValue);
      }
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

      System.out.printf("%s", node.dataList); // output node data
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
      System.out.printf("%s", node.dataList); // output node data
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
      System.out.printf("%s", node.dataList); // output node data
   } 

   //begin depth computation
   public int getDepth(){
      return getDepthRecursively(root);
   }
   
   //recursevely computes tree's depth
   private int getDepthRecursively(TreeNode<E> node){
      if (node == null)
         return -1;
      else{
         int leftTreeHeight = 1 + getDepthRecursively(node.leftNode);
         int rightTreeHeight = 1 + getDepthRecursively(node.rightNode);
         return Math.max(leftTreeHeight, rightTreeHeight);
      }
   }
}
