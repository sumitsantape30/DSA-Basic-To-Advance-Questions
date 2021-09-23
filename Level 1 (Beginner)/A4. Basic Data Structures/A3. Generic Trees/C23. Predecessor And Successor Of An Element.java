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
		if( state == 0) { //state ek to 0 ho skti hai or 1
			if ( node.data != data){ //agar data node ke data ke equal nhi hai to apna predecessor change krte rho, coz chances hai ki yeh node predecessor ho skta hai
				predecessor= node; //isse jaha jaha apka recursion ja rha hoga, jis jis node pe pohchega woh woh predecessor banta jayega
			} else { //agar state 0 hai aur node.data data ke equal hai to, abhiabhi apko data mila hai to state ko 1 se badha do
				state= 1;
			}
		}else if( state == 1) { //agar state 1 hai to hum uss waqt Successor set kardenge aur state ko 2 kardenge
			successor = node;
			state= 2; 
			
		}

		for( Node child: node.children) { // 1. recursion call karenge
			predecessorAndSuccessor(child, data);
		}
		//travel krte hue aapko kuch vlues update karni thi, successor, predecessor, state inko values update karni thi isko travel and change strategy bolte hai 
		//state ek marker hai aap chahe to as a parameter bhi pass kar skte ho 
	}

	public static void main(String[] args) {
		
		predecessor= null;
		successor= null;
		state= 0;
		predecessorAndSuccessor()
	}

}
