Kth Largest Element In Tree

1. You are given a partially written GenericTree class.
2. You are given a number k. You are required to find and print the kth largest value in the tree.
3. Input and Output is managed for you.
Input Format
Input is managed for you
Output Format
Output is managed for you

Constraints
None
Sample Input
24
10 20 -50 -1 60 -1 -1 30 70 -1 -80 110 -1 -120 -1 -1 90 -1 -1 40 -100 -1 -1 -1
8
Sample Output
10

Code:
package GenericTree;

import java.util.ArrayList;
import java.util.Stack;

public class kthLargest {
	
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

	  
	  static int ceil;
	  static int floor;
	  public static void ceilAndFloor(Node node, int data) {
	    if(node.data > data){
	      if(node.data < ceil){
	        ceil = node.data;
	      }
	    }

	    if(node.data < data){
	      if(node.data > floor){
	        floor = node.data;
	      }
	    }

	    for (Node child : node.children) {
	      ceilAndFloor(child, data);
	    }
	  }

	  public static int kthLargest(Node node, int k){

		  floor= Integer.MIN_VALUE; //floor ki value set kardi
		  int factor= Integer.MIN_VALUE ;// kiska nikalna hai , factor bola mai infinity ka floor nikal lo
		  
		  for( int i=0; i< k ;i++) { //yeh kam k times kiya jaye
			  //ceilandfloor wale function ko k times call karenge
			  ceilAndFloor(node, factor); //node pass kiya aur factor ke sath pass kiya, infinity ke sath pass kiya Infinty ke sath pass karunga to floor largest value ke barbar set hoke ayega
			  // so agli bar ka factor yeh floor hi hojayega
			  factor= floor;
			  //aur agli bar call lagane se phele floor ko dubarase reset krde 
			  floor= Integer.MIN_VALUE;
			  
		  }
		  
		  //last mai finally yeh factor return kardo
		  return factor;
	  
	  }

	public static void main(String[] args) {

		
	}

}
