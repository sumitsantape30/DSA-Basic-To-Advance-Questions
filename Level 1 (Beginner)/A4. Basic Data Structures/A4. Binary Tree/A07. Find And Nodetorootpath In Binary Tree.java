Find And Nodetorootpath In Binary Tree

1. You are given a partially written BinaryTree class.
2. You are given an element.
3. You are required to complete the body of find and nodeToRoot function. The functions are expected to 
    3.1. find -> return true or false depending on if the data is found in binary tree.
    3.2. nodeToRoot -> returns the path from node (correspoding to data) to root in 
    form of an arraylist (root being the last element)
4. Input iand Output is managed for you.
Input Format
Input is managed for you
Output Format
Output is managed for you

Constraints
None
Sample Input
19
50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n
30
Sample Output
true
[30, 37, 25, 50]

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
  
  
   static ArrayList<Integer> path; //humne ek path arraylist banali so jaha jaha true milega uss node ko hum arraylist mai dal denge
  public static boolean find(Node node, int data){
      if( node == null){
          //agar khali node pass hojaye to usme kuch mil hi nhi skta
          return false;
      }
      
     if( node.data == data){ //agar node ka data data ke eqaul hai to aage dhundna hi nhi hai return true krdo
         path.add(node.data);
         return true;
     }
     
     //agar root ke barabr nhi hai to left child pe dekhenge
     boolean filc = find(node.left ,data); // filc: find in left child. yeh sirf left child ko nhi left ke sare subtree ko dekkhe btata hai kahi usme mila ya nhi
     if(filc){ //agar left side mai milgya to true return karedenge aage dhundne ki jarurat nhi hai
         path.add(node.data); //root ka data add kardenge
         return true;
     }
     
     //yahape pohoche means data root ke barbr nhi hai aur left side mai bhi nhi mila
     boolean firc= find(node.right, data);
     if( firc){ //agar right child mai milgya to return true
         path.add(node.data); //root ka data add kardenge
         return true;
     }
     
     //agar code yahatk pahucha means woh data root kebhi equal nhi hai aur left and right side mai bhi nhi hai to return false
     return false;
     
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
    path = new ArrayList<Integer>();
    boolean found = find(root, data);
    System.out.println(found);
    System.out.println(path);
  }

}
