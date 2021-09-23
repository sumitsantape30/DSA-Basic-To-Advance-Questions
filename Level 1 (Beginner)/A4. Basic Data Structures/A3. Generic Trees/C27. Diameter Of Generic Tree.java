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

//==================== Approach 1 (n^2) hai yeh ======
//function likhenge jo height calculate krta hai aue uski help se ek diameter nam ka static variable lenge aur uski value update kar denge
	
	static int dia; // hum isme diameter nikalenge aur return height karenge isliye dia ko static liye
	//by default 0 se initialise hojayega
	
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
	
//============================JB's============================
//Approach 1 = O(n^2)
   static int diameter; //by default 0 se intialise hoga, sabse pehle jab code ek leaf node pe pohchega tab diameter compare hogi tab diameter 0 rahegi initially
   public static int height(Node node){
       
       int maxh= -1;
       int smaxh= -1;
       
       for(Node child: node.children){
           int ch= height(child); // hum child ko call karenge ki apni height btao
           if(ch > maxh){ //agar child ki height max hoti hai max height se so ch ko max hieght banado aur purane wali max hieght ko second max height mark kardo
               smaxh= maxh;
               maxh= ch;
           }else if(ch > smaxh){ //agar sirf second max height sehi jada hai to bas use update krdo
               smaxh= ch;
           }
       }
       
       diameter= Math.max(diameter, maxh + smaxh + 2); //diameter ko nikalke previous diameter ke sath compare karenge
       
       return maxh+ 1; //har node pe maxh aur smaxh nikalte hai isliye+1, hum height return krte hai ki meri subtree ki height yeh hai 
       
   }

//===========================================================================
// Approach 2 = Pair Approach	
	
	
	
	public static void main(String[] args) {

	}

}

