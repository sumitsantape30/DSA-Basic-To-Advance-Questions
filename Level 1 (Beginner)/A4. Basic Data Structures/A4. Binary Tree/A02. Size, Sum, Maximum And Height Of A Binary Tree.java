Size, Sum, Maximum And Height Of A Binary Tree

1. You are given a partially written BinaryTree class.
2. You are required to complete the body of size, sum, max and height function. The functions are expected to
    2.1. size - return the number of nodes in BinaryTree
    2.2. sum - return the sum of nodes in BinaryTree
    2.3. max - return the highest node in BinaryTree
    2.4. height - return the height of tree in terms of edges
3. Input and Output is managed for you.
Input Format
Input is managed for you
Output Format
Output is managed for you

Constraints
None
Sample Input
19
50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n
Sample Output
9
448
87
3

Code:

import java.io.*;
import java.util.*;

public class Main {
  public static class Node {
    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

public static int size(Node node) {
      if(node == null){
          return 0;
     }
    
    int leftSize= size(node.left);
    int rightSize= size(node.right);
    
    int ans = leftSize + rightSize + 1;
    return ans;
  }

  public static int sum(Node node) {
      if( node == null){
          return 0;
      }
    int lsum= sum(node.left);
    int rsum= sum(node.right);
    
    int sum= lsum + rsum + node.data;
    
    return sum;
    
  }

  public static int max(Node node) {
      if( node == null){ //agar node null hai to, agar 0 return karoge to galat hoga agar sari values -ve rhi to isliye -infinity return karna hoga
          return Integer.MIN_VALUE;
      }
      
      int lMax= max(node.left);
      int rMax= max(node.right);
      
      int max= Math.max(node.data, Math.max(lMax, rMax));
      return max;
  }

  public static int height(Node node) { //height chahiye in terms of edges
      if( node  == null){
          return -1; //-1 return karenge
      }
    int lH= height(node.left);
    int rH= height(node.right);
    
    int height= Math.max(lH, rH) + 1;
    return height;
    
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Integer[] arr = new Integer[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      if (values[i].equals("n") == false) {
        arr[i] = Integer.parseInt(values[i]);
      } else {
        arr[i] = null;
      }
    }

    Node root = construct(arr);

    int size = size(root);
    int sum = sum(root);
    int max = max(root);
    int ht = height(root);
    System.out.println(size);
    System.out.println(sum);
    System.out.println(max);
    System.out.println(ht);
  }

}
