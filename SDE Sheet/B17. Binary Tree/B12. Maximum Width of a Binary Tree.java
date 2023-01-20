Leetcode: https://leetcode.com/problems/maximum-width-of-binary-tree/

Problem Statement: Write a program to find the Maximum Width of A Binary Tree.

Examples:


Problem Description: 

The maximum width of a binary tree is the maximum of all the level widths. Width for a level is defined as the maximum number of nodes between the leftmost and rightmost node of the level(including the end nodes and the null nodes between the end nodes). 

Pre-req: Level Order Traversal

Disclaimer: Don’t jump directly to the solution, try it out yourself first.
  
Code:

import java.util.*;
class TreeNode {
  int data;
  TreeNode  left,  right;
  TreeNode(int data)
  {
      this.data=data;
      left=null;
      right=null;
  }
}

class Pair {
    TreeNode node; 
    int num; 
    Pair(TreeNode _node, int _num) {
        num = _num;
        node = _node; 
    }
}

class Solution {
    public static int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0; //if root is null there'll be no width so returning 0
      
        int ans = 0;
        Queue<Pair> q = new LinkedList<>();  //we'll have queue of Pair
      
        q.offer(new Pair(root, 0)); //we're adding node and index
      
        while(!q.isEmpty()){
          
            int size = q.size();//now currently whatever maybe the size of queue we'll iterate on all the elements
            int mmin = q.peek().num; //whichever is the first guy i took that index so i have minimum index possible on that level  
            int first = 0,last = 0;
            for(int i=0; i<size; i++){
                int cur_id = q.peek().num- mmin; //the current index will always be substracted by min
                TreeNode node = q.peek().node;
                q.poll();
                
              //store the first guy and the last guy
                if(i==0) first = cur_id;
                if(i==size-1) last = cur_id;
              
                if(node.left != null) //if there's left you take the left node
                    q.offer(new Pair(node.left, cur_id*2+1)); //after substraction index*2 + 1
                if(node.right != null) //if right exists
                    q.offer(new Pair(node.right, cur_id*2+2));
            }
            ans = Math.max(ans, last-first+1);
        }
        return ans;
    }

public static void main(String args[]) {

  TreeNode  root = new TreeNode(1);
  root . left = new TreeNode(3);
  root . left . left = new TreeNode(5);
  root . left . left . left = new TreeNode(7);
  root . right = new TreeNode(2);
  root . right . right = new TreeNode(4);
  root . right . right . right = new TreeNode(6);

  int maxWidth = widthOfBinaryTree(root);
  System.out.println("The maximum width of the Binary Tree is "+maxWidth);

   }
}
