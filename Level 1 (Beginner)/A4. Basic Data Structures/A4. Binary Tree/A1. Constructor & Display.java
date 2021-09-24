package BinaryTree;

import java.util.Stack;

public class Constructor {
	
	public static class Node{
		int data;
		Node left;
		Node right;
		
		public Node( int data) {
			this.data= data;
		} //left and right ko set nhi kiya tabhi woh null se set hojayene
	}
	
	public static class Pair{
		Node node;
		int state;
		
		public Pair(Node node, int state) {
			this.node= node;
			this.state= state;
		}
	}
	
	public static Node construct(Integer arr[]) {
		
		Stack<Pair> st= new Stack<Pair>(); //sase pehle aatehi stack of pair class banaunga
		Node root= new Node(arr[0]) ; //0th element ko root bana diya
		
		st.push(new Pair(root, 0)); //so stack mai iss root ki pair banake dal diya
		
		for(int i=1; i< arr.length; i++) {
			Pair tos= st.peek();
			if( arr[i] == null) { //agar arr[i] pe null pda hai to top of the stack nikalenge aur uski state ko badha denge
				tos.state++;
				
				if( tos.state == 2) { //agar woh state badhke 2 ho chuki hai to pop krdo usko
					st.pop();
				}
			}else {//agar koi number present hota hai, new node banayenge aur left and right set karenge
				//agar null nhi hai to ek new node banayenge aur uska data set karenge woh ya to left or right child ho skta hai
				Node n= new Node(arr[i]);
				if( tos.state == 0) { //agar top of the stack ki state 0 hai to top of the stack ki node ka left set krdo aur new node with state 0 push krdo
					tos.node.left= n;
					tos.state++;					
				}else {
					//agar top of the stack ki state 1 rhi hogi to uska right child set krenge
					tos.node.right = n;
					//agar state badhayi to state 2 hojayegi aur state 2 pe muje pop karna tha isliye directly pop hi krdo
					st.pop();
				}
				st.push(new Pair(n, 0)); //aur fir stack mai naya pair push krdo

			}
		}
		
		return root;
	}
	
	public static void display(Node node) {
		if(node == null) {
			return;
		}
		
		String str = "";
		
		str += node.left == null ? "." : node.left.data + " " ; //agar node ka left null hai to . dalenge otherwise mai dalunga node ke left ka data
		str += "<-" + node.data + "->";
		str += node.right == null ? ".": node.right.data + " ";
		System.out.println(str);
		
		display(node.left); //left subtree ko call lagadi ki print hojao
		display(node.right); //right subtree ko call lagadi ki print hojao
		
	}
	//yaha basecase lagegi ya nhi?? agar left ko call lag gyi (as hum left pass kr rhe hai display function mai) aur left null hai,
	//null pass hogya fir str banate waqt  null ka left nikaloge to null pointer exception aayegi isliye basecase chahiye hume yaha

	public static void main(String[] args) {
		Integer[] arr= {10, 20, 40, null, null, 30, 70, null, 80, null, null, 90, null, null};
		Node root= construct(arr);
		display(root);
		
	}

}

Output:

20 <-10->.
40 <-20->30 
.<-40->.
70 <-30->90 
.<-70->80 
.<-80->.
.<-90->.
