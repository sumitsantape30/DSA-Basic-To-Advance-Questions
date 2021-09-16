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

//========================================JB's==============================================

package GenericTree;

import java.util.ArrayList;
import java.util.Stack;

public class GenericTreeConstructor {

	private static class Node { //constructor
		int data;
		ArrayList<Node> children;
		
		public Node(int data){
			this.data= data;
			children= new ArrayList<Node>();
		}
	}
	
	//yeh root of the generic tree return karega
	public static Node construct(int arr[]) {
		
		Stack<Node> st = new Stack<>();
		Node root = new Node(arr[0]); //ek root node banalo, aur jo 0th element hai array ka woh humara root hoga
        st.push(root) ; // aur root ko pehlehi daldo stack mai

		for (int i = 1; i < arr.length; i++) {
			if( arr[i] == -1) { //agar 
				st.pop();
			}else {//otherwise ek new node banayenge aur uska data set kardenge
				Node n= new Node(arr[i]); //new Node banayenge aur uska data set karenge
				//t.data = arr[i]; agar humne constructo nhi banaya hota to default constructor mai data ko aise set krte
				
				st.peek().children.add(n); //stack ki peek pe jo hai uske children arraylist mai dal diya
				st.push(n); //aur stack mai bhi uska address push kardiya
			}
		}
		
		return root; //last mai root ko return
	}
	
	
	//iss function ki help dekhenge ki aapne sahi likha ya nhi
	public static void display(Node node) {
		
		String str= node.data + "->";
		for(Node child: node.children) {
			str += child.data + ","; //child ka data separated with a comma
		}
		str += '.' ; // aur last mai full stop
		System.out.println(str);
		
		for(Node child: node.children) { //muje pura faith hai ki node ke jitne children woh khud aur unki family print hojayegi
			display(child); //ek child pass karenge aur apni family print karke de dega
		}
		
//		for( int i=0; i< node.children.size(); i++) {
//			Node child= node.children.get(i);
//			display(child);
//		}
		
	}

	public static void main(String[] args) {

		int arr[] = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1 };

		Node root= construct(arr); //array pass karenge aur hume yeh ek root lake de dega
		
		display(root);
	}

}
