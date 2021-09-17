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
		for( Node child: node.children) { //har child ko bolenge ki linearize hoke aja
			linearize(child);
		}
		
		while(node.children.size() > 1) { //node ki arraylist ka size 1 nhi hojata tabtak chalega yeh kam
			Node lc= node.children.remove(node.children.size()-1); // last child ko remove kiya. lc: Last child (isse root aur last child ka connection tut gya)
			//ab jo naya last hai woh 2nd last hai idliye size-1 hi index rahega
			Node sl= node.children.get(node.children.size()-1); //second last
			//last aur second last aagye ab second last ki tail mai last ko dal denge, usse pehle second last ki tail mangayenge
			Node slt= getTail(sl);// slt: second last tail. getTail nam ke function ko second last denge to woh uski tail lake dega
			slt.children.add(lc); //second last ke children mai maine add kiya last child ko
			
		}
	}
	
	private static Node getTail( Node node) {
		while(node.children.size() == 1) { // jabtak children ka size 1 hai tabtak aap node ko niche utarde
			node= node.children.get(0);
		}
		
		//aur last mai return node karde
		return node;
		
	}
	
	//==============JBs
	
public static void linearize(Node node){
     
     for(Node child: node.children){
         linearize(child);
     }
     
     while(node.children.size() >1){
         Node slkitail= getTail(node.children.get(node.children.size()-2));// second last child ki tail
          // second last ki tail aachuki hai uske children mai hume add karna hai last child ko
          slkitail.children.add(node.children.get(node.children.size()-1)); //second last ki tail mai last ko add karwa diya ab last child ko remove kardo
          node.children.remove(node.children.size()-1); //last child ko remove kardiya
     }
     
  }
  
  public static Node getTail(Node node){

      while(node.children.size() != 0){//jabtak answer ke children ka size non zero or 1 hoga tabtak ans ko ans update kardo
        node = node.children.get(0); //woh linearise hoke aaya hai so har node ka ek hi child exist karega isliye 0 index liye
      } //har node ko check kar rhe hai ki agar iss node ka child exist krta hai to node ko uske child pe point karwate hai, jab kisi node ka child exist nhi karega matlab wahi humari tail hai
      
      return node;
  }
	
	//getTail using recursion
 public static Node getTail(Node node){
	if( node.children.size(){ //agar node ke children ka size grater than 0 hai means agar node ka child exist krta hai to usko hi bolo ki tu apna tail bta
		Node rr = getTail(node.children.get(0)); //node ke child kohi bolre ki tu apna tail bta
		return rr;
	}else{ 
		//agar uska child exist nhi krta to woh khud hi tail hai
		return node;
		//else wali case is a basecase actually, isko basecase banado or else mai rakho
	}
  }

	public static void main(String[] args) {

	}

}

