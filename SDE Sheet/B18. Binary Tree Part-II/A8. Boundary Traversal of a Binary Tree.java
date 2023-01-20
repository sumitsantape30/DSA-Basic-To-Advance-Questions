Boundary Traversal of a Binary Tree
Problem Statement: BoundaryTraversal of a binary tree. Write a program for the Anti-Clockwise Boundary traversal of a binary tree.

Code:
import java.util.*;
class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
public class Main {
    static Boolean isLeaf(Node root) {
        return (root.left == null) && (root.right == null);
    }

    static void addLeftBoundary(Node root, ArrayList < Integer > res) {
        Node cur = root.left;
        while (cur != null) {//jabtak curr null nhi hota 
        
            if (isLeaf(cur) == false) res.add(cur.data);//agar yeh node leaf node nhi hai to res mai dalenge
            
            if (cur.left != null) cur = cur.left; //agar iss node ka left exist krta hai to left mai jao
            else cur = cur.right; //agar left exist nhi krta to right mai jao
        }
    }
    
    static void addRightBoundary(Node root, ArrayList < Integer > res) {
        Node cur = root.right;
        ArrayList < Integer > tmp = new ArrayList < Integer > (); //hume reverse order mai chahiye isliye ek arraylist lenge
        while (cur != null) {
            if (isLeaf(cur) == false) tmp.add(cur.data);
            if (cur.right != null) cur = cur.right;
            else cur = cur.left;
        }
        
        int i;
        for (i = tmp.size() - 1; i >= 0; --i) {
            res.add(tmp.get(i));
        }
    }

    static void addLeaves(Node root, ArrayList < Integer > res) {
        if (isLeaf(root)) {//agar yeh node leaf node hai to ans mai daldo
            res.add(root.data);
            return;
        }
        
        if (root.left != null) addLeaves(root.left, res); //agar left node exist krta hai to left mai jao
        if (root.right != null) addLeaves(root.right, res); //
    }
    
    static ArrayList < Integer > printBoundary(Node node) {
        ArrayList < Integer > ans = new ArrayList < Integer > (); //ek answer arralist banayenge
        if (isLeaf(node) == false) ans.add(node.data); //agar current node leaf nhi hai to ans mai dalenge
        
        addLeftBoundary(node, ans);//fir left mai jayenge
        addLeaves(node, ans); //then leaf nodes add karenge ans mai
        addRightBoundary(node, ans); //then right nodes add karenge ans mai
        return ans;
    }

    public static void main(String args[]) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.left.right = new Node(4);
        root.left.left.right.left = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(7);
        root.right.right = new Node(8);
        root.right.right.left = new Node(9);
        root.right.right.left.left = new Node(10);
        root.right.right.left.right = new Node(11);

        ArrayList < Integer > boundaryTraversal;
        boundaryTraversal = printBoundary(root);

        System.out.println("The Boundary Traversal is : ");
        for (int i = 0; i < boundaryTraversal.size(); i++) {
            System.out.print(boundaryTraversal.get(i) + " ");
        }

    }
}
