package Stack;

import java.util.Stack;

public class ZeroClass {

	public static void main(String[] args) {

		Stack<Integer> st= new Stack<Integer>();
		
		st.push(10);
		st.push(20);
		st.push(30);
		st.push(40);
		st.push(50);
		
		while( st.size() != 0) {
			System.out.println(st.pop());
		}
	}
	
	//questions mai stack use karoge to Tc kafi reduce hojati hai 
	// brackets wale, infix prefix postfix wale question hojate hai isse

}
