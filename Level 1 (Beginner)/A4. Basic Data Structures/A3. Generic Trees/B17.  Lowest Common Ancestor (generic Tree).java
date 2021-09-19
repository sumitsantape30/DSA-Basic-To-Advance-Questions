Lowest Common Ancestor (generic Tree)

1. You are given a partially written GenericTree class.
2. You are required to complete the body of lca function. The function is expected to return the lowest common ancestor of two data values that are passed to it. 
Please watch the question video to understand what lca is.
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
120
80
Sample Output
80

Code:

package GenericTree;

import java.util.ArrayList;

import GenericTree.NodetoRootPath.Node;

public class LowestCommonAncestor {

	public static class Node {
		int data;
		ArrayList<Node> children = new ArrayList<Node>();
	}

	public static int lca(Node node, int d1, int d2) {
		
		ArrayList<Integer> p1= nodeToRootPath(node, d1); //path 1, d1 pass kiya
		ArrayList<Integer> p2= nodeToRootPath(node, d2); //path 2, d2 pass kiya
		
		//ab do loop chalayenge
		int i= p1.size()-1;
		int j= p2.size()-1;
		
		while( i >= 0 && j >= 0 && p1.get(i) == p2.get(j)) { //jabtak i and j greater than 0 hai and p1 and p2 same hai
		     i--;
		     j--;
		     // i and j ko -- krte rahenge
		}
		
		// iss loop ke bahar agye honge to hume pehle unequal banda mil chuka hoga so akhri bande keliye i++ aur j++ kr skte hai
		i++;
		j++;
		
		//aakhri milne ke bad ya to p1.get(i) return karo ya fir p2.get(j)
		return p1.get(i);
		
	}
	
		public static ArrayList<Integer> nodeToRootPath(Node node, int data) {
			if( node.data == data) {
				ArrayList<Integer> list= new ArrayList<>();
				list.add(node.data);
				return list;
			}
			
			for( Node child: node.children) {
				ArrayList<Integer> ptc = nodeToRootPath(child, data); 
				if( ptc.size() > 0) { 
					ptc.add(node.data);
					return ptc;
				}
			}
			
			return new ArrayList<>();

		}

	public static void main(String[] args) {

	}

}
