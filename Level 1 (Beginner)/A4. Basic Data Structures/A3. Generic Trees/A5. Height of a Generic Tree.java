Height Of A Generic Tree

1. You are given a partially written GenericTree class.
2. You are required to complete the body of height function. The function is expected to find the height of tree. Depth of a node is defined as the number of edges it is away from the root (depth of root is 0). Height of a tree is defined as depth of deepest node.
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
2

Code:
package GenericTree;

import java.util.ArrayList;
import java.util.Stack;

public class HeightOfATree {
	
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
	  
	  public static int height(Node node) {
		  
		  int ht= -1; //height name ke variable ko -1 se define kiya. Agar 0 se initialise kiya, mere pas ek hi node hai iska koi children nhi so loop skip hota aur fir height 1 return hojati 
		  //so edges bola jaye to -1 se intialise karo agar nodes ki term mai chahiye to 0 se initialise karo
		  
		  for( Node child: node.children) { //node ke children pe traverse karenge
			  int ch= height(child); //maine bola childs tum apni family ki height lake de
			  ht= Math.max(ch,  ht);
		  }
		  
		  ht += 1; //height mai ek add karlenge root ki edege
		  
		  return ht;
		  
	  }

	public static void main(String[] args) {
		
	}

}
