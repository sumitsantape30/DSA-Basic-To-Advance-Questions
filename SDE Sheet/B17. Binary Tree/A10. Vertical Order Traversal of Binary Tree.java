Vertical Order Traversal of Binary Tree
Problem Statement: Vertical Order Traversal Of A Binary Tree. Write a program for Vertical Order Traversal order of a Binary Tree.

Example:

Problem Description:

Vertical Order Traversal, as the name suggests is a traversal in which we divide the binary tree in verticals from left to right, and in every vertical, we print the nodes from top to bottom.

Note:
There can be duplicate values among the nodes (here 10 is repeated twice).
If two or more nodes are overlapping at the same position(here 10 and 9), then they will be printed in ascending order. 
  
Code:

import java.util.*;
class TreeNode {
    int data;
    TreeNode left, right;
    TreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
class Tuple {
    TreeNode node;
    int row;
    int col;
    public Tuple(TreeNode _node, int _row, int _col) {
        node = _node;
        row = _row;
        col = _col;
    }
}
public class TUF {
    public static List < List < Integer >> findVertical(TreeNode root) {
        TreeMap < Integer, TreeMap < Integer, PriorityQueue < Integer >>> map = new TreeMap < > ();
        Queue < Tuple > q = new LinkedList < Tuple > ();
        q.offer(new Tuple(root, 0, 0));//we're adding in queue-> node, vertical,level
      
        while (!q.isEmpty()) {
            Tuple tuple = q.poll();
            TreeNode node = tuple.node;
            int x = tuple.row; //vertical 
            int y = tuple.col; // level 

            if (!map.containsKey(x)) { //if it doesnt exists we are creating a treeMap
                map.put(x, new TreeMap < > ());
            }
          
            if (!map.get(x).containsKey(y)) { //if priority queue doesnt exists we are creating pq
                map.get(x).put(y, new PriorityQueue < > ());
            }
          
            map.get(x).get(y).offer(node.data);//then we're getting vertical, treemap of level, and then in pq we're inserting node.data

            if (node.left != null) { //if node.left exists we'll add new tuple
                q.offer(new Tuple(node.left, x - 1, y + 1));
            }
            if (node.right != null) {  //right
                q.offer(new Tuple(node.right, x + 1, y + 1));
            }
        }
      
        List < List < Integer >> list = new ArrayList < > ();
        for (TreeMap < Integer, PriorityQueue < Integer >> ys: map.values()) { //for every vertical i'll iterate. map.values() means for every vertical
            list.add(new ArrayList < > ());//i'm adding empty list for every vertical
            for (PriorityQueue < Integer > nodes: ys.values()) { //and on that list i'm iterating in the PQ
                while (!nodes.isEmpty()) { 
                    list.get(list.size() - 1).add(nodes.poll()); //i'm taking values and adding to the end of the list
                }
            }
        }
        return list;
    }

    public static void main(String args[]) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(10);
        root.left.left.right = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(10);

        List < List < Integer >> list = new ArrayList < > ();
        list = findVertical(root);

        System.out.println("The Vertical Traversal is : ");
        for (List < Integer > it: list) {
            for (int nodeVal: it) {
                System.out.print(nodeVal + " ");
            }
            System.out.println();
        }

    }
}
