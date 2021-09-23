Diameter Of Generic Tree

1. You are given a partially written GenericTree class.
2. You are required to find and print the diameter of tree. THe diameter is defined as maximum number of edges between any two nodes in the tree. Check the question video for clarity.
3. Input is managed for you.
Input Format
Input is managed for you
Output Format
diameter

Constraints
None
Sample Input
20
10 20 -50 -1 60 -1 -1 30 -70 -1 80 -1 90 -1 -1 40 -100 -1 -1 -1
Sample Output
4

Code:

package GenericTree;

import java.util.ArrayList;

public class DiameterOfGenericTree {

	private static class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	static int dia = 0; // hum isme diameter nikalenge aur return height karenge

	static int calculateDiaReturnHeight(Node node) {
		int dch= -1; //deepest child height ko -1 se set karenge
		int sdch= -1; // second deepest child  ko -1 set karenge
		
		for( Node child: node.children) {
			int ch= calculateDiaReturnHeight(child); //child ki height
			if( ch > dch) { //agar aapki child ki height deepest child ki height ko beat karde to
				// agar woh dono se jada hai to second wale mai deepest wale ki value aajayegi aur deepest wale mai yeh nayi value ajayegi
				sdch= dch;
				dch= ch;
				
			}else if( ch > sdch) { //agar second deepest child height se jada hogi to kya hoga
				// agar woh sirf second wale se jada hoga to sirf second wala update hoga
				sdch= ch;	
			}
		}
		
		// yahapr aapke pas highest aur second highest dono aa chuke honge
		
		int cand= dch + sdch + 2; //ek node pe khade sochre mere deepest child + mera second deepest child + me(2) agar yeh dia ko hara de 
		if( cand > dia) { //agar woh candidate diameter ko hara de to diameter uss chandidate ke equal hojayega
			dia= cand;
		}
		
		//return karne se pehle deepest child height mai 1 jarur add kare
		dch += 1; // kyuki humari kya hoti hai? jo deepest child ki height hoti hai usse ek jada hoti hai
		return dch; 
		// return dch hoga par impact dia pr ayega
	}

	public static void main(String[] args) {

	}

}

