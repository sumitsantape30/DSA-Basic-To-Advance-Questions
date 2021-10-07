Target Sum Pair In Bst

1. You are given a partially written BST class.
2. You are given a value. You are required to print all pair of nodes which add up to the given value. Make sure all pairs print the smaller value first and avoid duplicacies. Make sure to print the pairs in increasing order. Use the question video to gain clarity.
3. Input and Output is managed for you. 
Input Format
Input is managed for you
Output Format
"smaller node" "larger node"
.. all pairs that add to target on separate lines

Constraints
None
Sample Input
21
50 25 12 n n 37 30 n n n 75 62 60 n n 70 n n 87 n n
100
Sample Output
25 75
30 70

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

    Stack< Pair> st = new Stack< >();
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

  public static boolean find(Node node, int data) {
    if (node == null) {
      return false;
    }

    if (data > node.data) {
      return find(node.right, data);
    } else if (data < node.data) {
      return find(node.left, data);
    } else {
      return true;
    }
  }

  public static void targetSumPair(Node root, Node node, int tar) {
    if (node == null) {
      return;
    }

    //muje har pair increasing order mai chahiye matlab mai inorder mai kam karunga
    targetSumPair(root, node.left, tar);

    int comp = tar - node.data;
    if (comp > node.data) { //muje increasing order mai print karna hai to compliment value obviously mujse badi honi chahiye
      if (find(root, comp)) {
        System.out.println(node.data + " " + comp);
      }
    }

    targetSumPair(root, node.right, tar);
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
    targetSumPair(root, root, data);
  }

}
