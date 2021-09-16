Maximum In A Generic Tree

1. You are given a partially written GenericTree class.
2. You are required to complete the body of max function. The function is expected to find the node with maximum value and return it.
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
60

Code:

package GenericTree;

import java.util.ArrayList;
import java.util.Stack;


public class MaxInAGenericTree {
	
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
	  
	  public static int max(Node node) {
		  int max= Integer.MIN_VALUE; //max ko initialise karenge
		  
		  for( Node child: node.children) {
			  int cm = max(child); // muje ispe pura faith hai ki yeh child mese max lakde de dega
			  //ab mai jo overall max hai uske sath child ke max ka fight karunga
			  max= Math.max(max, cm);
		  } //jab yeh loop chal chuka hoga to sare children ke max ki apas mai fight ho chuki hai aur unka overall max max mai aa chuka hai
		  
		  //ab finally ladhayi root ke data se hogi
		  max= Math.max(node.data, max);
			  
		  return max;
	  }

	public static void main(String[] args) {
	
	}
}
