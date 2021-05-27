Find In Generic Tree

1. You are given a partially written GenericTree class.
2. You are required to complete the body of find function. The function is expected to find the given data in the tree, if found it should return true or return false.
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
Sample Output
true

Code:

package GenericTree;

import java.util.ArrayList;

public class FindAnElementInGenericTree {

	public static class Node {
		int data;
		ArrayList<Node> children = new ArrayList<Node>();
	}

	public static boolean find(Node node, int data) {

		if( node.data == data) { //agar node ka data data ke barabr hai to children ko check karne ki jarurat nhi hai return true
			return true;
		}
		
		// aap yahape tabhi ayenge jab apka data node ke datake barabr nhi hai
		for( Node child : node.children) {
			boolean fic= find(child, data); // yeh pehle child keliye khbar layega ki uske yahapr mil ya nhi mila
		 //ab agar pehle child ke yaha nhi mila to dusre ko puchega, dusre mai nhi mila to teesre ko puchega but agar dusre mai milgya to tisre se nhi puchega
		
			if(fic) { //as soon as kisi child ke yaha milgya to yeh return true karega aur iske aage loop nhi chalega
				return true;
			}
		}
		
		//yahapr aaye means woh na khud barbr hai na kisi children ke pas hai to hum return karenge false
		return false;	
	}

	public static void main(String[] args) {

	}

}
