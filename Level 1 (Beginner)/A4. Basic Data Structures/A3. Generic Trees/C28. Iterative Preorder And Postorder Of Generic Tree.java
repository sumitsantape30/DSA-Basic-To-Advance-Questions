Iterative Preorder And Postorder Of Generic Tree

1. You are given a partially written GenericTree class.
2. You are require to complete the body of function IterativePreandPostOrder. The function does not use recursion and prints preorder and postorder of the tree. Both orders are printed in separate lines (preorder first, followed by post order in next line). Elements in an order are separated by space.
3. Input and Output is managed for you.
Input Format
Input is managed for you
Output Format
Elements in preorder separated by a space
Elements in postorder separated by a space

Constraints
None
Sample Input
24
10 20 -50 -1 60 -1 -1 30 70 -1 -80 110 -1 -120 -1 -1 90 -1 -1 40 -100 -1 -1 -1
Sample Output
10 20 -50 60 30 70 -80 110 -120 90 40 -100 
-50 60 20 70 110 -120 -80 90 30 -100 40 10 

Code:

package GenericTree;

import java.util.ArrayList;
import java.util.Stack;

public class IterativePreAndPostOrder {

	private static class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}
	
	//mai ek class banata hu
	static class Pair {
		
		Node node;
		int state;
		
		Pair(Node node, int state){
			this.node= node;
			this.state= state;
		}
		
	}

	public static void IterativePreandPostOrder(Node node) {
		
		Stack<Pair> st= new Stack<>(); //stack banayi, aur ab root dalenge
		st.push(new Pair(node, -1));
		
		String pre= ""; // pre and post bana lenge
		String post= "";
		
		while( st.size() > 0) { //jabtak stack mai kuch na kch rahega
			Pair top= st.peek(); //iska top wala dekhenge
			//ab top wale mai 3 bate ho skti hai
			if( top.state == -1) { // ya to uski state -1 ho skti hai
				// yeh hume preorder btata tha so preorder mai add karenge aur top ki state badhane yad rakhenge
				pre += top.node.data + " ";
				top.state++;
			}else if( top.state == top.node.children.size()) { //yafir saare child ho chuke hai
				// post order mi hote hai to post order mai add karenge and isbar state nhi badhayenge isbar pop karenge
				post += top.node.data;
				st.pop();
			}else { // else bichme kahi hai
				// ab kuch child bache hai hum unn child pe jayenge
				Pair cp= new Pair(top.node.children.get(top.state), -1); //jo top ki state hai woh number(th) wala children get karenge, and initial state mai state -1 hongi
				//so yeh cp child pair banaya and isko stack mai push kare denge
				st.push(cp);
				//aur iske bad bhi mai top ki state badhaunga 
				top.state++; //0th child push kardiya to top ki state isliye badhayi taki agli bar 1th child push ho
			}
		}
		
		System.out.println(pre);
		System.out.println(post);
	}

	public static void main(String[] args) {

	}

}

