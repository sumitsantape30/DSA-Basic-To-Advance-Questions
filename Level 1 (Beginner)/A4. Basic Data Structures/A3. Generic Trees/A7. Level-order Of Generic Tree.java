Level-order Of Generic Tree

1. You are given a partially written GenericTree class.
2. You are required to complete the body of levelorder function. The function is expected to visit every node in "levelorder fashion". Please check the question video for more details.
3. Input is managed for you.
Input Format
Input is managed for you
Output Format
All nodes from left to right (level by level) all separated by a space and ending in a "."

Constraints
None
Sample Input
24
10 20 50 -1 60 -1 -1 30 70 -1 80 110 -1 120 -1 -1 90 -1 -1 40 100 -1 -1 -1
Sample Output
10 20 30 40 50 60 70 80 90 100 110 120 .
  
Code:

package GenericTree;

import java.util.ArrayList;
import java.util.Stack;

public class TraversalsInGenericTree {

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
	
	public static void levelOrder(Node node) {
		
		Queue<Node> q= new ArrayDeque<>(); // yeh bhi syntax use kr skte ho
		//Queue<Node> q= new LinkedList<>(); //ek quee banayi hai
		q.add(node); //jo bhi node pass hua use queue mai dal denge
		
		while( q.size() > 0) { //jabtak queue ka size 0 nhi hota tabtak kam karenge
			Node rn = q.remove(); // queue mese node nikalenge, rn : remove node
			System.out.print(rn.data + " "); //fir node ko print kardenge
			
			//aur fir jo node remove kiya uske childrens ko add kardenge
			for( Node child: rn.children) {
				q.add(child);
			}
		}
		
		System.out.println(".");
	}
	
	public static void main(String[] args) {

	}

}

