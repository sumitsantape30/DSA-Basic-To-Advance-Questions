package GenericTree;

import java.util.ArrayList;
import java.util.Stack;

public class GenericTreeConstructor {

	public static class Node {
		int data;
		ArrayList<Node> children = new ArrayList<Node>();

	}
	
	// Excpectation from 10 ki display(10): 10 will print itself and its family
	// faith front 20 30 40 ki yeh khudko aur apni family ko print karenge
	// d(10) = s(10) + d(20) + d(30) + d(40)
	public static void display(Node node) {
		
		String str= node.data + "-->"; //ek string banyenge
		for( Node child : node.children) { //10 ke children 3 hi hai so yeh loop 20 30 40 yahi 3 logo mai ghumega
			str += child.data+ ",";
		}
		//bahar aake yahi string mai full stop add karenge
		str += ".";
		System.out.println(str);
		
		// ab mai apne children pe believe rakhunga ki display call kardu to woh khudko aur apni puri family ko print karne ki ability rakhte hai
		for( Node child: node.children) {
			display(child);
		}
		
	}

	public static void main(String[] args) {

		int arr[] = { 10, 20, 50, -1, 60, -1, 60, -1, -1, 30, 70, -1, 30, 70, -1, 80, 110, -1, 80, 110, -1, 120, -1, -1,
				90, -1, -1, 40, 100, -1, -1, -1 };

		Node root = null;
		Stack<Node> st = new Stack<>(); 

		for (int i = 0; i < arr.length; i++) {
			if( arr[i] == -1) {
				st.pop();
			}else {
				Node t= new Node();
				t.data = arr[i];
				
				if( st.size() > 0) {
				st.peek().children.add(t); 
				
				}else {

					root= t;
				}

				st.push(t);
			}
		}
		
		display(root);
	}

}

