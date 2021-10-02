Print Nodes K Distance Away

1. You are given a partially written BinaryTree class.
2. You are given a value data and a value k.
3. You are required to complete the body of printKNodesFar function. The function is expected to print all nodes which are k distance away in any direction from node with value equal to data.
4. Input is managed for you.
Input Format
Input is managed for you
Output Format
All nodes which are k distance away in any direction from node with value equal to data, each in a separate line

Constraints
None
Sample Input
19
50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n
37
2
Sample Output
12
50

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

  public static void printKNodesFar(Node node, int data, int k) {
      path= new ArrayList<>();
      find(node, data); //node to root path humare pas aagya
      
      for( int i=0; i< path.size() && i <=k ; i++){
          printKLevelsDown(path.get(i), k-1, i==0 ? null: path.get(i-1)); //path.get(i) se k-i ki duri wale print kardo 
      }
  }
  
  // purane wale mai yeh path Integer ki terms mai deta tha but hume Nodes ki terms mai chahiye. aur hum path mai bhi node.data nhi add karenge sirf node add karenge
  static ArrayList<Node> path; 
  public static boolean find(Node node, int data){
      if( node == null){
          return false;
      }
      
     if( node.data == data){ 
         path.add(node);
         return true;
     }
     
     boolean filc = find(node.left ,data); 
     if(filc){ 
         path.add(node);
         return true;
     }
     
     boolean firc= find(node.right, data);
     if( firc){
         path.add(node);
         return true;
     }
     
     return false;
  }
  
  public static void printKLevelsDown(Node node, int k, int blocker){
      if( node == null || k < 0 || node == blocker){  //so maine bola node agar null hai to return aur agar node blocker node hai tobhi return
        return;
      }
      
      if( k == 0){
          System.out.println(node.data); 
          return;
      }
    
     printKLevelsDown(node.left, k-1, blocker); 
     printKLevelsDown(node.right, k-1, blocker); 
     
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
    int k = Integer.parseInt(br.readLine());

    Node root = construct(arr);
    printKNodesFar(root, data, k);
  }

}

///=====================================================JB's====================================

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

  public static void printKNodesFar(Node node, int data, int k) {
      ArrayList<Integer> al= nodeToRootPath(node, data); //data ka root to root path ajayega
      
      for( int i=0; i< al.size(); i++){
          Node cr = al.get(i); // current node
          Node blocker = i == 0 ? null : al.get(i-1) ; // current node keliye yeh blocker node banegi. jab i ==0 rahegi tab ustime blocker indexoutofbound dega isliye jab i ==0 hoga to blocker null lelo.

          printKLevelsDown(cr, k - i , blocker);
      }
  }
  
   public static ArrayList<Node> nodeToRootPath(Node node, int data){
      
      if( node == null){ 
          return new ArrayList<Node>();
      }
      
      if(node.data == data){
          ArrayList<Node> bans= new ArrayList<Node>();
          bans.add(node);
          return bans;
      }
      
      ArrayList<Node> lans= nodeToRootPath(node.left, data);
      if(lans.size()> 0){ 
         lans.add(node);
         return lans;
      }
      
      ArrayList<Integer> rans= nodeToRootPath(node.right, data);
      if(rans.size()> 0){
          rans.add(node);
          return rans;
      }
      
      return new ArrayList<>();
  }
  
  public static void printKLevelsDown(Node node, int k, Node blocker){
      if( node == null || node == blocker){ 
        return;
      }
      
      if( k == 0){
          System.out.println(node.data); 
          return;
      }
    
     printKLevelsDown(node.left, k-1, blocker); 
     printKLevelsDown(node.right, k-1, blocker); 
     
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
    int k = Integer.parseInt(br.readLine());

    Node root = construct(arr);
    printKNodesFar(root, data, k);
  }

}
