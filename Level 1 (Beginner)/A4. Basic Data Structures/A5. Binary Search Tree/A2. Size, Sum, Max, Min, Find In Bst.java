Size, Sum, Max, Min, Find In Bst

1. You are given a partially written BST class.
2. You are required to complete the body of size, sum, max, min and find function. The functions are expected to:
    2.1. size - return the number of nodes in BST
    2.2. sum - return the sum of nodes in BST
    2.3. max - return the value of node with greatest value in BST
    2.4. min - return the value of node with smallest value in BST
    2.5. find - return true if there is node in the tree equal to "data"
3. Input and Output is managed for you.
Input Format
Input is managed for you
Output Format
Output is managed for you
Question Video

Constraints
None
Sample Input
19
50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n
70
Sample Output
9
448
87
12
true

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

  public static class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
      this.node = node;
      this.state = state;
    }
  }

  public static Node construct(Integer[] arr) {
    Node root = new Node(arr[0], null, null);
    Pair rtp = new Pair(root, 1);

    Stack< Pair> st = new Stack<>();
    st.push(rtp);

    int idx = 0;
    while (st.size() > 0) {
      Pair top = st.peek();
      if (top.state == 1) {
        idx++;
        if (arr[idx] != null) {
          top.node.left = new Node(arr[idx], null, null);
          Pair lp = new Pair(top.node.left, 1);
          st.push(lp);
        } else {
          top.node.left = null;
        }

        top.state++;
      } else if (top.state == 2) {
        idx++;
        if (arr[idx] != null) {
          top.node.right = new Node(arr[idx], null, null);
          Pair rp = new Pair(top.node.right, 1);
          st.push(rp);
        } else {
          top.node.right = null;
        }

        top.state++;
      } else {
        st.pop();
      }
    }

    return root;
  }

  public static void display(Node node) {
    if (node == null) {
      return;
    }

    String str = "";
    str += node.left == null ? "." : node.left.data + "";
    str += " <- " + node.data + " -> ";
    str += node.right == null ? "." : node.right.data + "";
    System.out.println(str);

    display(node.left);
    display(node.right);
  }

  public static int size(Node node) {
    if (node == null) {
      return 0;
    }

    int ls = size(node.left); //left subtree ko bola ki tum apna size dedo
    int rs = size(node.right); //right subtree ko bola tum apna size dedo
    int ts = ls + rs + 1; //aur apna size banayenge
    return ts;
  }

  public static int sum(Node node) {
    if (node == null) {
      return 0;
    }

    int ls = sum(node.left);
    int rs = sum(node.right);
    int ts = ls + rs + node.data;
    return ts;
  }

 //TC of min and max: ek to root ka data return hota hai ya fir ek size call lagti hai : O(h)== O(n), h= height of the tree
  public static int max(Node node) { 
    if (node.right == null) { //agar mere node ka right child exist nhi krta to node.data hi maximum hai
      return node.data;
    } else { //agar right child exist krta hai to muje faith hai ki right pe call kiya to apna max lake dedega
      return max(node.right);
    }
  }

  public static int min(Node node) {
    if (node.left == null) {
      return node.data;
    } else {
      return min(node.left);
    }
  }

  public static boolean find(Node node, int data) {
    if (node == null) {
      return false;
    }

    if (data > node.data) { //aisa hua to yeh chota banda hume left mai milega 
      return find(node.right, data); 
    } else if (data < node.data) {
      return find(node.left, data);
    } else {
      return true;
    }
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

    int data = Integer.parseInt(br.readLine());

    Node root = construct(arr);

    int size = size(root);
    int sum = sum(root);
    int max = max(root);
    int min = min(root);
    boolean found = find(root, data);

    System.out.println(size);
    System.out.println(sum);
    System.out.println(max);
    System.out.println(min);
    System.out.println(found);
  }

}
