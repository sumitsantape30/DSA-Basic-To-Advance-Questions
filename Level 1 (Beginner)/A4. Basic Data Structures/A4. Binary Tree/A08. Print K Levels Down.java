Print K Levels Down

1. You are given a partially written BinaryTree class.
2. You are given a value k.
3. You are required to complete the body of printKLevelsDown function. The function is expected to print in different lines all nodes which are k level deep. Use preorder for printing.
4. Input is managed for you.
Input Format
Input is managed for you
Output Format
All nodes k-level deep printed in separated lines and visited in preorder
Question Video

Constraints
None
Sample Input
19
50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n
3
Sample Output
30
70

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

    Stack<Pair> st = new Stack<>();
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

  public static void printKLevelsDown(Node node, int k){
      if( node == null || k < 0){ //agar node null hojaye or k negative ho to return. kisika left right exist hi nhi krta ho to return
        return;
      }
      
      if( k == 0){
          System.out.println(node.data); //agar k==0 hai to 0th level pe root hi hai to usko print kardenge aur return
      }
    
    //mai apne left child ko bola ki apnese k-1 levels down jitne bhi nodes hai unko print karde
    printKLevelsDown(node.left, k-1); //root se k levels deep hai to left wale node se k-1 levels deep hoga
    //aur mai apne right child ko call laga dunga ki apnese k-1 level down jitne bhi nodes hai aap unko print karado
    printKLevelsDown(node.right, k-1); //similarly right wale node sebhi k-1 levels deep hoga
  }
  
//=============JB's===========================
  
   public static void printKLevelsDown(Node node, int k){
      if( node == null){ 
        return;
      }
      
      if( k == 0){
          System.out.println(node.data); 
          return; //yahipe return krdenge to k negative hogahi nhi kabhi
      }
    
    printKLevelsDown(node.left, k-1); 
    printKLevelsDown(node.right, k-1); 
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

    int k = Integer.parseInt(br.readLine());

    Node root = construct(arr);
    printKLevelsDown(root, k);
  }

}
