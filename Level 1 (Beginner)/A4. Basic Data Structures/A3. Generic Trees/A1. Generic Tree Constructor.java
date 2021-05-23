
package GenericTree;

import java.util.ArrayList;
import java.util.Stack;

public class GenericTreeConstructor {

	private class Node {
		int data;
		ArrayList<Node> children = new ArrayList<Node>();

	}

	public static void main(String[] args) {

		int arr[] = { 10, 20, 50, -1, 60, -1, 60, -1, -1, 30, 70, -1, 30, 70, -1, 80, 110, -1, 80, 110, -1, 120, -1, -1,
				90, -1, -1, 40, 100, -1, -1, -1 };

		Node root; //intially root hi rahega badme root milega then update karenge
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
