Linearize A Generic Tree
1. You are given a partially written GenericTree class.
2. You are required to complete the body of linearize function. The function is expected to create a linear tree i.e. every node will have a single child only. For details check the question video.
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
10 -> 20, .
20 -> 50, .
50 -> 60, .
60 -> 30, .
30 -> 70, .
70 -> 80, .
80 -> 110, .
110 -> 120, .
120 -> 90, .
90 -> 40, .
40 -> 100, .
100 -> .

Code:

package GenericTree;

import java.util.ArrayList;

public class LinearizeAGenericTree {

	public static class Node {
		int data;
		ArrayList<Node> children = new ArrayList<Node>();
	}

	public static void linearize(Node node) {
		
		// faith rakkhe sabpe linearize call kare
		for( Node child: node.children) {
			linearize(child);
		}
		
		while(node.children.size() > 1) {
			Node lc= node.children.remove(node.children.size()-1); // last child ko remove kare. lc: Last child
			//ab jo naya last hai woh 2nd last hai
			Node sl= node.children.get(node.children.size()-1); //second last
			// fir mangayenge 2nd last ki tail
			Node slt= getTail(sl);// slt: second last tail. getTail nam ke function ko second last denge to woh uski tail lake dega
			slt.children.add(lc); //second last ke children mai maine add kiya last child ko
			
		}
	}
	
	private static Node getTail( Node node) {
		while(node.children.size() == 1) { // jabtak children ka size 1 nhi hojata tabtak aap node ko niche utarde
			node= node.children.get(0);
		}
		
		//aur last mai return node karde
		return node;
		
	}

	public static void main(String[] args) {

	}

}

