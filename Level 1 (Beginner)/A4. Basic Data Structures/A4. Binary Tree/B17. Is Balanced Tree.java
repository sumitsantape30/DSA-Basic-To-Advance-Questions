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

  public static class BalPair { //ek pair mai height rakhenge aur balance hai ya nhi
    int ht;
    boolean isBal;
  }

  public static BalPair isBalanced(Node node) {
    if (node == null) { //agar node null hai 
      BalPair bp = new BalPair();
      bp.ht = -1;
      bp.isBal = true; // null ka is bal true hota hai 
      return bp;
    }

    // left aur right ka answer mangwa lo
    BalPair lp = isBalanced(node.left); //left pair mai left subtree ki height aur woh isBal hai ki nhi yeh ayega
    BalPair rp = isBalanced(node.right); // right pair mai right subtree ki height aur woh isBal hai ki nhi yeh ayega

    BalPair mp = new BalPair();  //ab mai apna pair banaunga
    mp.ht = Math.max(lp.ht, rp.ht) + 1;  // meri height hogi, left or right ki max height + 1
    mp.isBal = lp.isBal && rp.isBal && Math.abs(lp.ht - rp.ht) <= 1; //my pair balance tabhi hogi jab left aur right pair balanaced ho aur unki height ka absolute difference <= 1 ho

    return mp;
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
    BalPair bp = isBalanced(root);
    System.out.println(bp.isBal);
  }

}
