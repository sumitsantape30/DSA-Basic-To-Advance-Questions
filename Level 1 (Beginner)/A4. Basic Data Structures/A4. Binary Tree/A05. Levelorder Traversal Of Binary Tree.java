Levelorder Traversal Of Binary Tree

1. You are given a partially written BinaryTree class.
2. You are required to complete the body of levelorder function. The function is expected to print tree level by level, left to right. Each level must be on a separate line and elements of same level should be separated by space
3. Input is managed for you.
Input Format
Input is managed for you
Output Format
Each level must be on a separate line and elements of same level should be separated by space

Constraints
None
Sample Input
19
50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n
Sample Output
50 
25 75 
12 37 62 87 
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

  public static void levelOrder(Node node) {
    Queue<Node> mq= new ArrayDeque<>(); //maine ek main queue bnaya
    
    mq.add(node); //aur root ko add kardia
    
    while(mq.size() > 0){ //jabtak main queue ka size grater thn 0 hai hum kam krte rahenge
        
        int count= mq.size(); // sabse pehle mai iss level mai kitne bande hai yeh count karunga aur fir utna loop chalayenge
        
        for( int i=0; i< count; i++){
            //ab hum count itne rpa karenge
            Node rn= mq.remove(); // ek node ko remove karenge fir uss node ko print karenge
            System.out.print(rn.data+" ");
            //fir uske childrens ko qeueue mai add kardenge
            
            if( node.left != null){ //agar node ka left child null nhi hai to main queue ke andar add hojayega
            mq.add(node.left); // left child add hojayega
                
            }
            
            if( node.right != null){ //agar right child null nhi hai to right child ko queue mai dal denge
            mq.add(node.right);
                
            }
        }
        //iss loop se bahar aaye means ek level hogyi hai to enter lagayenge
        System.out.println();
        
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

    Node root = construct(arr);
    levelOrder(root);
  }

}
