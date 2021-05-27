Mirror A Generic Tree

1. You are given a partially written GenericTree class.
2. You are required to complete the body of mirror function. The function is expected to create a mirror image of the tree. For more details, check out the question video.
3. Input and Output is managed for you. 

Input Format
Input is managed for you
Output Format
Output is managed for you

Constraints
None
Sample Input
24
10 20 50 -1 60 -1 -1 30 70 -1 80 110 -1 120 -1 -1 90 -1 -1 40 100 -1 -1 -1
Sample Output
10 -> 20, 30, 40, .
20 -> 50, 60, .
50 -> .
60 -> .
30 -> 70, 80, 90, .
70 -> .
80 -> 110, 120, .
110 -> .
120 -> .
90 -> .
40 -> 100, .
100 -> .
10 -> 40, 30, 20, .
40 -> 100, .
100 -> .
30 -> 90, 80, 70, .
90 -> .
80 -> 120, 110, .
120 -> .
110 -> .
70 -> .
20 -> 60, 50, .
60 -> .
50 -> .

Code:

package GenericTree;

import java.util.ArrayList;
import java.util.Collections;

public class MirrorAGenericTree {

	public static class Node {
		int data;
		ArrayList<Node> children = new ArrayList<Node>();
	}

	public static void mirror(Node node) {

		for (Node child : node.children) { //humar faith hai ki yeh children ka mirror banake de dega
			mirror(child);
		}
		
		//children to apn kam krlega but root ne abhitak nhi kiya so 10 ka mirror karayenge
		Collections.reverse(node.children); //node ki jo children nam ki arraylist hai usko reverse krdenge
	}

	public static void main(String[] args) {

	}

}
