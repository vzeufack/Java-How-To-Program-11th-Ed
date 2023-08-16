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

   public void print(){
      if (root == null){
         System.out.println("Tree is empty!");
      }
      else {
         System.out.printf("Preorder traversal%n");
         this.preorderTraversal();

         System.out.printf("%nInorder traversal%n");
         this.inorderTraversal();

         System.out.printf("%nPostorder traversal%n");
         this.postorderTraversal();
      }
   }

   public void deleteNode(E valueToDelete){
      if(root == null)
         System.out.println("Value is not in the tree!");
      else if (root.data.compareTo(valueToDelete) == 0){
         if(isLeaf(root))
            root = null;
         else if (root.leftNode != null && root.rightNode == null)
            root = root.leftNode;
         else if (root.leftNode == null && root.rightNode != null)
            root = root.rightNode;
         else{
            TreeNode parentOfReplacementNode = getParentOfReplacementNode(root);
            TreeNode temp = root;
            if(parentOfReplacementNode == root){
               root = root.leftNode;
               root.rightNode = temp.rightNode;
            }
            else {
               TreeNode replacementNode = parentOfReplacementNode.rightNode;
               root = replacementNode;

               if (isLeaf(replacementNode)) {
                  parentOfReplacementNode.rightNode = null;
               } else {
                  parentOfReplacementNode.rightNode = replacementNode.leftNode;
               }
               replacementNode.rightNode = temp.rightNode;
               replacementNode.leftNode = temp.leftNode;
            }
         }
      }
      else{
         TreeNode parentOfNodeToDelete = getParentOfNodeToDelete(valueToDelete, root);
         if(parentOfNodeToDelete != null){
            boolean isLeftChild = parentOfNodeToDelete.leftNode.data.compareTo(valueToDelete) == 0;
            TreeNode nodeToDelete =  isLeftChild ? parentOfNodeToDelete.leftNode : parentOfNodeToDelete.rightNode;
            if(isLeaf(nodeToDelete)){
               if(isLeftChild)
                  parentOfNodeToDelete.leftNode = null;
               else
                  parentOfNodeToDelete.rightNode = null;
            }
            else if (nodeToDelete.leftNode != null && nodeToDelete.rightNode == null){
               if(isLeftChild)
                  parentOfNodeToDelete.leftNode = nodeToDelete.leftNode;
               else
                  parentOfNodeToDelete.rightNode = nodeToDelete.leftNode;
            }
            else if (nodeToDelete.leftNode == null && nodeToDelete.rightNode != null){
               if(isLeftChild)
                  parentOfNodeToDelete.leftNode = nodeToDelete.rightNode;
               else
                  parentOfNodeToDelete.rightNode = nodeToDelete.rightNode;
            }
            else{
               TreeNode parentOfReplacementNode = getParentOfReplacementNode(nodeToDelete);
               TreeNode replacementNode = parentOfReplacementNode.rightNode;
               TreeNode temp = nodeToDelete;

               if(isLeftChild)
                  parentOfNodeToDelete.leftNode = replacementNode;
               else
                  parentOfNodeToDelete.rightNode = replacementNode;

               if(isLeaf(replacementNode)){
                  parentOfReplacementNode.rightNode = null;
               }
               else{
                  parentOfReplacementNode.rightNode = replacementNode.leftNode;
               }
               replacementNode.rightNode = temp.rightNode;
               replacementNode.leftNode = temp.leftNode;
            }
         }
         else{
            System.out.println("Value is not in the tree!");
         }
      }
   }

   private TreeNode getParentOfReplacementNode(TreeNode nodeToDelete){
      TreeNode current = nodeToDelete.leftNode;
      TreeNode parent = nodeToDelete;

      while(current.rightNode != null){
         parent = current;
         current = current.rightNode;
      }

      return parent;
   }

   private TreeNode getParentOfNodeToDelete(E key, TreeNode parent){
      if (parent == null)
         return null;

      if (parent.leftNode != null && parent.leftNode.data.compareTo(key) == 0)
         return parent;

      if (parent.rightNode != null && parent.rightNode.data.compareTo(key) == 0)
         return parent;

      if (parent.data.compareTo(key) > 0)
         return getParentOfNodeToDelete(key, parent.leftNode);
      else
         return getParentOfNodeToDelete(key, parent.rightNode);
   }

   private boolean isLeaf(TreeNode node){
      return node.leftNode == null && node.rightNode == null;
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

