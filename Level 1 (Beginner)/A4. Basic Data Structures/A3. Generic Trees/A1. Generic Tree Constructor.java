We will be given an array of integers and we have to construct a tree using the values in that array.

	
package GenericTree;

import java.util.ArrayList;
import java.util.Stack;

public class GenericTreeConstructor {

	private static class Node { //constructor
		int data;
		ArrayList<Node> children = new ArrayList<Node>();
	}

	public static void main(String[] args) {

		int arr[] = { 10, 20, 50, -1, 60, -1, 60, -1, -1, 30, 70, -1, 30, 70, -1, 80, 110, -1, 80, 110, -1, 120, -1, -1,
				90, -1, -1, 40, 100, -1, -1, -1 };

		Node root= null; //intially root mai null hi rahega badme root milega then update karenge
		Stack<Node> st = new Stack<>(); // nodes ki stack banayengee

		for (int i = 0; i < arr.length; i++) {
			//so isme dohi bate hongi, arr[i] -1 hoga yafir nhi hoga
			if( arr[i] == -1) {
				// -1 hai to hum pop kr rhe hai
				st.pop();
			}else {
				// jab non -1 hai to hum node banate hai then uska data set krte hai
				Node t= new Node();
				t.data = arr[i];
				
				if( st.size() > 0) { //agar stack mai kuch hai 
					
				// fir isko stack mai push karne jate hai aur stack ke jo top pe pda hota hai uska child banake stack mai push krte hai
				st.peek().children.add(t); //stack ke jo top pe pda hai uske children mai add krlo t ki
				
				}else {
					//jad sabse pehla node ayega, jab stack ke andar size hi nhi hoga to hum stack mai peek hi nhi kr skte uss waqt ko pehla node hota hai usko root decare krte hai
					root= t;
				}

				// agar stack mai kuch pda hai to uske top pe children mai add kardo warna usko root declare krdo coz root kisika chid nhi hota
				st.push(t);
			}

		}
	}

}

//==================================JB's=============================

package GenericTree;

import java.util.ArrayList;
import java.util.Stack;

public class GenericTreeConstructor {

	private static class Node { //constructor
		int data;
		ArrayList<Node> children;
		
		public Node(int data){
			this.data= data;
			children= new ArrayList<Node>();
		}
	}
	
	//yeh root of the generic tree return karega
	public static Node construct(int arr[]) {
		
		Stack<Node> st = new Stack<>();
		Node root = new Node(arr[0]); //ek root node banalo, aur jo 0th element hai array ka woh humara root hoga
                st.push(root) ; // aur root ko pehlehi daldo stack mai

		for (int i = 1; i < arr.length; i++) {
			if( arr[i] == -1) { //agar 
				st.pop();
			}else {//otherwise ek new node banayenge aur uska data set kardenge
				Node n= new Node(arr[i]); //new Node banayenge aur uska data set karenge
				//t.data = arr[i]; agar humne constructo nhi banaya hota to default constructor mai data ko aise set krte
				
				st.peek().children.add(n); //stack ki peek pe jo hai uske children arraylist mai dal diya
				st.push(n); //aur stack mai bhi uska address push kardiya
			}
		}
		
		return root; //last mai root ko return
	}
	
	
	//iss function ki help dekhenge ki aapne sahi likha ya nhi
	public static void display(Node node) {
		
		String str= node.data + "->";
		for(Node child: node.children) {
			str += child.data + ","; //child ka data separated with a comma
		}
		str += '.' ; // aur last mai full stop
		System.out.println(str);
		
		for(Node child: node.children) { //muje pura faith hai ki node ke jitne children woh khud aur unki family print hojayegi
			display(child); //ek child pass karenge aur apni family print karke de dega
		}
		
//		for( int i=0; i< node.children.size(); i++) {
//			Node child= node.children.get(i);
//			display(child);
//		}
		
	}

	public static void main(String[] args) {

		int arr[] = { 10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1 };

		Node root= construct(arr); //array pass karenge aur hume yeh ek root lake de dega
		
		display(root);
	}

}

Analysis:
Time Complexity:
The time complexity of the above solution is O(n) as we are traversing the array which is filled with data of the nodes of the generic tree.

Space Complexity:
The space complexity of the above code is also O(n) as we have used a stack to create the tree. But, you may wonder why O(n). 
	Can the stack have n elements in it at a time? Yes, it can. How? Think about this yourself!!!. (We will study this when we will study skewed trees)
