Predecessor And Successor Of An Element

1. You are given a partially written GenericTree class.
2. You are required to find the preorder predecessor and successor of a given element. Use the "travel and change" strategy explained in the earlier video. The static properties have been declared for you. You can declare more if you want.
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
-120
Sample Output
Predecessor = 110
Successor = 90

Code:

package GenericTree;

import java.util.ArrayList;

public class PredecessorAndSuccessor {

	private static class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	static Node predecessor;
	static Node successor;
	static int state;

	public static void predecessorAndSuccessor(Node node, int data) {
		
		//2.ab iske preorder mai dekhiye
		if( state == 0) {
			//agar state 0 hai 
			if( node.data == data) { //fir hum check karenge kya node ka data data ke equal hai, agar equal hai to state ko change karke 0 se 1 kardo
				state= 1;
			}else { //else apna predecessor change krte rho
				predecessor= node; //isse jaha jaha apka recursion ja rha hoga, jis jis node pe pohchega woh woh predecessor banta jayega
			}
		}else if( state == 1) { //agar state 1 hai to hum uss waqt Successor set kardenge aur state ko 2 kardenge
			successor = node;
			state= 2; 
			
		}

		for( Node child: node.children) { // 1. recursion call karenge
			predecessorAndSuccessor(node, data);
		}
	}

	public static void main(String[] args) {
		
		predecessor= null;
		successor= null;
		state= 0;
		predecessorAndSuccessor()
	}

}
