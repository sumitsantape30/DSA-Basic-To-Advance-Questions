Generic Tree - Traversals (pre-order, Post-order)

1. You are given a partially written GenericTree class.
2. You are required to complete the body of traversals function. The function is expected to visit every node. While traversing the function must print following content in different situations.
   2.1. When the control reaches the node for the first time -> "Node Pre" node.data.
   2.2. Before the control leaves for a child node from a node -> "Edge Pre" 
   node.data--child.data.
   2.3. After the control comes back to a node from a child -> "Edge Post" node.data- 
   -child.data.
    2.4. When the control is about to leave node, after the children have been visited 
    -> "Node Post" node.data.
3. Input is managed for you.
Input Format
Input is managed for you
Output Format
As suggested in Sample Output

Constraints
None
Sample Input
12
10 20 -1 30 50 -1 60 -1 -1 40 -1 -1
Sample Output
Node Pre 10
Edge Pre 10--20
Node Pre 20
Node Post 20
Edge Post 10--20
Edge Pre 10--30
Node Pre 30
Edge Pre 30--50
Node Pre 50
Node Post 50
Edge Post 30--50
Edge Pre 30--60
Node Pre 60
Node Post 60
Edge Post 30--60
Node Post 30
Edge Post 10--30
Edge Pre 10--40
Node Pre 40
Node Post 40
Edge Post 10--40
Node Post 10


Code:

package GenericTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderInGenericTree {
	
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
	
	public static void traversals(Node node) {
		//area 1
		// area 1 node ka pre area kaha jata hai 
		System.out.println("Node Pre"+ node.data); // yahi euler ka left hai. Eulers left, On the way deep in recursion, node's pre area
		for( Node child : node.children) {
			// edge pre
			System.out.println("Edge Pre"+ node.data+"--"+child.data);
			traversals(child);
			System.out.println("Edge Post"+ node.data+"--"+child.data); //iss child ke pass se jab node pr wapas aa rhe honge to use bolenge edge post
			// edge post
		}
		
		//now eulers right, on the way out of recursion, node's post area
		System.out.println("Node Post"+ node.data);
	}

	public static void main(String[] args) {
	
	}
}
