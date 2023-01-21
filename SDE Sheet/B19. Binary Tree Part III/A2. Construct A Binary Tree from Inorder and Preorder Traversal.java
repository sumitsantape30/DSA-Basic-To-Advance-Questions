Construct A Binary Tree from Inorder and Preorder Traversal
In this article we will solve the most asked coding interview problem: Construct A Binary Tree from Inorder and Preorder Traversal.

Construct A Binary Tree from Inorder and Preorder Traversal

Given the Inorder and Preorder Traversal of a binary tree, we need to construct the unique binary tree represented by them.

Code:

import java.util.*;
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int val) {
    this.val = val;
    left = null;
    right = null;
  }
}

//utility function to insert node in the list
class TUF {
  static TreeNode buildTree(int[] preorder, int[] inorder) {
    Map < Integer, Integer > inMap = new HashMap < Integer, Integer > ();

//put all the inorder values in hashmap
    for (int i = 0; i < inorder.length; i++) {
      inMap.put(inorder[i], i);
    }

  //then i pass preorder and its 2 pointers. then i pass inorder and its 2 pointers and then i pass map
    TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
    return root;
  }

  static TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map < Integer, Integer > inMap) {
  
    if (preStart > preEnd || inStart > inEnd) return null;//if my start and end crosses of preorder or inorder crosses i'll return null

    TreeNode root = new TreeNode(preorder[preStart]); //preorder ka start is my root
    
    int inRoot = inMap.get(root.val);//then mai dekhta hu ki yeh root inorder mai kahape hai us index pe mera inRoot point karega
    int numsLeft = inRoot - inStart; //fir mai dekhunga how many numbers are there on left of root in order

    root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, inMap);//then i say root.left why dont you build yourself, this time preStart stars from 1 pointer next. aur inorder ka start rahega inStart and end rahega inRoot -1. this is i'm passing to build a tree on left
   
    root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inMap); //start hoga 2th index se till end, this is going to be my preorder of next. 

    return root;
  }
  public static void main(String args[]) {

    int preorder[] = {10,20,40,50,30,60};
    int inorder[] = {40,20,50,10,60,30};
    TreeNode root = buildTree(preorder, inorder);
  }

}
