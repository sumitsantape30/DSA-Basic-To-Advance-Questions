Size Of Generic Tree

1. You are given a partially written GenericTree class.
2. You are required to complete the body of size function. The function is expected to count the number of nodes in the tree and return it.
3. Input and Output is managed for you.
Input Format
Input is managed for you
Output Format
Output is managed for you

Constraints
None
Sample Input
12
10 20 -1 30 50 -1 60 -1 -1 40 -1 -1
Sample Output
6

Code:
package GenericTree;

import java.util.ArrayList;
import java.util.Stack;

public class SizeOfGenericTree {
	
	 private static class Node {
		    int data;
		    ArrayList<Node> children = new ArrayList<>();
		  }

		  public static void display(Node node) {
		    String str = node.data + " -> ";
		    for (Node child : node.children) {
		      str += child.data + ", ";
		    }
		    str += ".";
		    System.out.println(str);

		    for (Node child : node.children) {
		      display(child);
		    }
		  }

		  public static Node construct(int[] arr) {
		    Node root = null;

		    Stack<Node> st = new Stack<>();
		    for (int i = 0; i < arr.length; i++) {
		      if (arr[i] == -1) {
		        st.pop();
		      } else {
		        Node t = new Node();
		        t.data = arr[i];

		        if (st.size() > 0) {
		          st.peek().children.add(t);
		        } else {
		          root = t;
		        }

		        st.push(t);
		      }
		    }

		    return root;
		  }

		  public static int size(Node node){
			  int s= 0;// size ==0;
			  
			  for( Node child: node.children) {
				  int cs= size(child); //child size, size() hi call kiya aur child ko pass kardia
				  //aur size ke andar yeh child size add karenge
				  s += cs;
			  }
			  
			  //bahar nikalke size ke andar 1 add karenge
			  s += 1; // 10 wale root node ke liye khudke liye 1 add kiya
			  return s;
		  }

	public static void main(String[] args) {
		
	}

}
