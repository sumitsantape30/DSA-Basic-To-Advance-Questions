Are Trees Mirror In Shape

1. You are given a partially written GenericTree class.
2. You are required to complete the body of areMirror function. The function is expected to check if the two trees passed to it are mirror images of each other in shape (data not to be checked, just the shape of tree).
Note -> Watch the question video for clarity.
3. Input and Output is managed for you.
Input Format
Input is managed for you
Output Format
Output is managed for you

Constraints
None
Sample Input
12
10 20 -1 30 50 -1 60 -1 -1 40 -1 -1
12
100 200 -1 300 500 -1 600 -1 -1 400 -1 -1
Sample Output
true

Code:

package GenericTree;

import java.util.ArrayList;

public class AreTreesMirrorInShape {

	public static class Node {
		int data;
		ArrayList<Node> children = new ArrayList<Node>();
	}

	public static boolean areMirror(Node n1, Node n2) {
		
		//pehli galti yeh ho skti hai ki n1 and n2 ke children hi same na ho to koi mirror image nhi hone wala
		if( n1.children.size() != n2.children.size()) {
			return false;
		}
		
		//ab yahapr pahuche means number of childrens same hai
		// ab dekhna hai mirror image, lets say two faces hai left and right mai aur dekhna hai ki left wala right ki mirror image hai ya nhi to iske left eye uske right eye ki mirror image honi chahiye
		for( int i=0; i< n1.children.size(); i++) {
			// andar aatehi ek j nikalenge hum, j hoga dusre extreme se
			int j= n1.children.size() -1 -i; // means agar i left se hai to j right se
			Node c1= n1.children.get(i); //left se child uthaya n1 ka
			Node c2= n2.children.get(j); //aur right se child uthaya n2 ka
			if(areMirror(c1, c2) == false) { //aur fir pucha kya n1 ke left wale child aur kya n2 ke right wale child mirror nhi hai
				// agar tum uske mirror nhi ho, n1 ke left wale child agar tum n2 ke right wale child ke mirror image nhi ho to n1 bhi n2 ka mirror image nhi hai
				return false;
			}
			
		}
		
		//aur agar left wala right wale ke sath mirror hai, usse agla iska agle ka mirror image hai aisa sare ek dusre ke image hai aur number of children same the to n1 n2 ka mirror hoga
		return true;
	}

	public static void main(String[] args) {

	}

}

