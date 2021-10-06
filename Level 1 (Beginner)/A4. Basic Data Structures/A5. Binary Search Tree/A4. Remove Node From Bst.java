Remove Node From Bst

1. You are given a partially written BST class.
2. You are required to complete the body of remove function. "remove" function is expected to remove a new node with given data to the tree and return the new root.
3. Input and Output is managed for you. 

Note -> Please watch the question video to figure out the algorithm required for deletion. It specifies some requirements of the question as well.
Input Format
Input is managed for you
Output Format
Output is managed for you
Question Video

Constraints
None
Sample Input
15
50 25 12 n n 37 n n 75 62 n n 87 n n
62
Sample Output
25 <- 50 -> 75
12 <- 25 -> 37
. <- 12 -> .
. <- 37 -> .
. <- 75 -> 87
. <- 87 -> .

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
  
  public static int max(Node node){
      if(node.right == null){
          return node.data;
      }else{
          return max(node.right);
      }
  }

  public static Node remove(Node node, int data) {
      if( node == null){
          return null;
      }
      
    if( node.data == data){ //node data data ke equal hai means isi node ko remove karna hai to check karo
        //agar node ka data data ke equal hai to hume yahape check karna hoga ki woh leaf node hai, ki node with single child and node with both children
        
        if( node.left == null && node.right == null){ //agar yeh leaf node hai to return null
            return null;
        }else if(node.left != null && node.right == null){
            //kya node ka left null nhi hai aur node ka right null hai to left hi return kardo
            return node.left;
        }else if(node.left == null && node.right != null){
            //node ke left null hai aur right null nhi hai  to right child ko return kiya
            return node.right;
        }else{
            //otherwise agar donohi null nhi hai means mere dono child hai to hume mangwana padega left ka max, so max function se max ajayega
            int lmax= max(node.left);
            node.data= lmax; //node ka data left ke max se replace karwa diya aur fir mai call lagaunga
            node.left= remove(node.left, lmax); //left ko call lagayi ki left mese lmax hatado
        }
        
    }else if( node.data < data){
        //root ka data agar data se chota hai to mai right ko call laga dunga aur jobhi jawab ayega usko node ke right mai chipka denge
        node.right= remove(node.right, data);
        
    }else{
        //means node ka data bada hai data se jo remove karna hai woh chota hai so chota left mai milega
        node.left= remove(node.left, data); //so left subtree ko call lagayi ki isko remove karado
        
    }
    return node;
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
    root = remove(root, data);

    display(root);
  }

}
