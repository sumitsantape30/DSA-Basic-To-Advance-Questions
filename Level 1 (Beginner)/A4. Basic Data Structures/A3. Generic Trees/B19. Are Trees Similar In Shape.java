Are Trees Similar In Shape

1. You are given a partially written GenericTree class.
2. You are required to complete the body of areSimilar function. The function is expected to check if the two trees passed to it are similar in shape or not.
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
24
1 2 5 -1 6 -1 -1 3 7 -1 8 11 -1 12 -1 -1 9 -1 -1 4 10 -1 -1 -1
Sample Output
true

Code:
package GenericTree;

import java.util.ArrayList;

public class AreTreesSimilar {

	public static class Node {
		int data;
		ArrayList<Node> children = new ArrayList<Node>();
	}

	public static boolean areSimilar(Node n1, Node n2) {
		
		if( n1.children.size() != n2.children.size()) { //agar n1 ke children  ka size nhi barabr hai n2 ke children ke size ke sath to return false coz similar hai hi nhi
			return false;
		}
		
		//yahatk pahuche means dono ki size same hai
		for( int i=0; i< n1.children.size(); i++) {
			// ab unke correspondig child utha lenge n1 and n2 mese
			Node c1= n1.children.get(i);
			Node c2= n2.children.get(i);
			
			if(areSimilar(c1, c2) == false) { //agar c1 and c2 shape mai similar nhi hai to return false
				return false;
			}
		}
		
		//iss line pe aane ka matlab hau number of children bhi same hai aur har corresponding child ka pair bhi same shape rakhta hai so hum yaha return true kardenge
		return true;
		
	}

	public static void main(String[] args) {

	}

}
