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

  public static int height(Node node) {
    if (node == null) {
      return -1;
    }

    int lh = height(node.left);
    int rh = height(node.right);

    int th = Math.max(lh, rh) + 1;
    return th;
  }

  public static class BSTPair { //muje har node se muje uska subtree ka min, max aur woh subtree hai ya nhi yeh chahiye
    int min;
    int max;
    boolean isBST;
  }

  public static BSTPair isBST(Node node) {
    if (node == null) { //null pe pohoch gye to null pe pohochke muje ek pair return karna hai 
      BSTPair bp = new BSTPair();
      bp.min = Integer.MAX_VALUE; // default value of min is infinity
      bp.max = Integer.MIN_VALUE; // max ki default value
      bp.isBST = true; 
      return bp;
    }

    BSTPair lp = isBST(node.left); //mai left subtree ko boulnga ki tu apna min max de aur tu bst hai ya nhi yeh btade
    BSTPair rp = isBST(node.right); // right subtree pe bhi same kam

    BSTPair mp = new BSTPair(); //fir my pair banayenge
    mp.min = Math.min(node.data, Math.min(lp.min, rp.min)); //mera minimum hoga, minimum of (node.data, minimum of left and right pair )
    mp.max = Math.max(node.data, Math.max(lp.max, rp.max));
    mp.isBST = lp.isBST && rp.isBST && node.data >= lp.max && node.data <= rp.min; 

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
    BSTPair p = isBST(root);
    System.out.println(p.isBST);
  }

}
