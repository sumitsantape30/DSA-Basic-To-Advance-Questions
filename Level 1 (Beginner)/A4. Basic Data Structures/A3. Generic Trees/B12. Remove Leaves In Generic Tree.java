Remove Leaves In Generic Tree

1. You are given a partially written GenericTree class.
2. You are required to complete the body of removeLeaves function. The function is expected to remove all leaves from the tree. For more details, check out the question video.
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
20 -> .
30 -> 80, .
80 -> .
40 -> .

Code:

package GenericTree;

import java.util.ArrayList;

public class removeLeavesFromGenericTree {

	public static class Node {
		int data;
		ArrayList<Node> children = new ArrayList<Node>();
	}

	public static void removeLeaves(Node node) {
		
		for (int i= node.children.size()-1; i>= 0 ; i--) {
			Node child= node.children.get(i);
			if (child.children.size() == 0) { // agar child ke 0 children hai to node.children ki list se remove karde iss child ko
				node.children.remove(child);
			}
		}
		//yeh logic pehle likhe taki pehle children uda le aur fir bache hue baccho pe removeLeaves call kare 

		//faith
		for( Node child: node.children) {
			removeLeaves(child);
		}// isse children 20 30 40 ke saare leaves ud jayenge
		
//		for( Node child: node.children) {
//			if( child.children.size() == 0) { //agar child ke 0 children hai to node.children ki list se remove karde iss child ko
//				node.children.remove(child);
//			}
//		} // yeh for each loop nhi laga skte coz usime loop laga rhe hai aur usimese delete karre this doesnt work fine it gives error.
		
	}

	public static void main(String[] args) {

	}

}
