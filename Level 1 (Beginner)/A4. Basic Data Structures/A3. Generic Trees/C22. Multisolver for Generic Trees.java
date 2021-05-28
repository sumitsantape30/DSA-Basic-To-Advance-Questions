This is the new way of solving problems : Travel And Change
humne jo problems solve kari hai woh recursion use karke kari hai ki size wala function size return karte hai height wala function height return krta hai etc
so isbar hum travel karenge aur kuch return nhi karayenge, hum kuch data memebers use karenge aur unn data members ki value change krte rahenge  

Code:

package GenericTree;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class MultisolverInGenericTrees {

	private static class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	public static void display(Node node) {
		String str = node.data + " -> ";
		for (Node child : node.children) {
			str += child.data + ", ";
		}
		str += ".";
		System.out.println(str);

		for (Node child : node.children) {
			display(child);
		}
	}

	public static Node construct(int[] arr) {
		Node root = null;

		Stack<Node> st = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == -1) {
				st.pop();
			} else {
				Node t = new Node();
				t.data = arr[i];

				if (st.size() > 0) {
					st.peek().children.add(t);
				} else {
					root = t;
				}

				st.push(t);
			}
		}

		return root;
	}

	//1. yaha properties rakhenge
	static int size;
	static int min ;
	static int max ;
	static int height;
	// yaha values sirf declare kar skte ho yafir initialise bhi
	//yeh heap mai bante hai aur humesha available hote hai inko pass hi karna hota recursion mai yeh heap mai hote hai humesha available rehte hai recursion ke andar
	
	public static void multisolver(Node node, int depth) { //3. multisolver ko call lagake node pass hua isme, aur depth nam ka variable pass karenge jo stack mai ayega

		//5. so see mai pre area mai kya kr rha hu
		size++;
		min= Math.min(min, node.data);
		max= Math.max(max, node.data);
		height= Math.max(height, depth);
		
		for( Node child: node.children) { //4. sirf yeh code sare nodes ko visit kara pane mai saksham hota hai. iske upar ka pre area hai aur niche ka post area hai
			multisolver(child, depth+1); //jab bhi niche child ke pas jayenge to +1 kardenge
		}
		
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = s.nextInt();
		}

		Node root = construct(arr);
		
		//2. Multisolver call karne se pehle inki default value sat kardijiye
		size= 0;
		min= Integer.MAX_VALUE;
		max=Integer.MIN_VALUE;
		height= 0;
		multisolver(root, 0); // multisolver ko root pass krde, aur depth ki value 0 pass karenge initially
		//6. Yahase bahar aane ke bad mai 4 values print karunga
		System.out.println("size ="+size);
		System.out.println("min ="+min);
		System.out.println("max ="+max);
		System.out.println("height ="+height);

	}

}
