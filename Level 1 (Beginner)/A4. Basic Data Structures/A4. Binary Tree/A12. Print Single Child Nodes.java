Print Single Child Nodes

1. You are given a partially written BinaryTree class.
2. You are required to complete the body of printSingleChildNodes function. The function is expected to print in separate lines, all such nodes which are only child of their parent. Use preorder for traversal.
3. Input and Output is managed for you.
Input Format
Input is managed for you.
Output Format
Output is managed for you. 

Constraints
None
Sample Input
19
50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n
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

   public static void printSingleChildNodes(Node node, Node parent) { //root ka koi parent nhi hota hai isliye Parent mai null pass kiya hai input mai
    if (node == null) {
      return;
    }

     //fir mai khudke liye check karunga kya mai apne parent ka single child hu, agar hu to print hojaounga
    if (parent != null && parent.left == null && parent.right == node) { //agar parent right humara node hai aur parent ke pas left hai hi nhi. inut mai humne parent null pass kiya hai so woh parent not null hona chahiye nhito parent.left chala direct to exception dega
      System.out.println(node.data);
    } else if (parent != null && parent.right == null && parent.left == node) {//parent ka left agar humara node hai aur parent ko right child hai hi nhi
      System.out.println(node.data);
    }

    //muje apne child pe faith hai, mai unko bolunga yr check karo kya tum khud mere(root) means parent ke single child ho aur agar ho to print hojao. 
    printSingleChildNodes(node.left, node); //agar mai node.left pe jau to uska parent node hoga
    printSingleChildNodes(node.right, node); // agar mai node.right pe jau to uska parent bhi node hoga
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
    printSingleChildNodes(root, null);
  }

}
