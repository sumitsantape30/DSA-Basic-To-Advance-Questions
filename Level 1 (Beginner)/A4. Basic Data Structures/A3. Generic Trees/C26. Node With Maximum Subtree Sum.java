Node With Maximum Subtree Sum
1. You are given a partially written GenericTree class.
2. You are required to find and print the node which has the subtree with largest sum. Also print the sum of the concerned subtree separated from node's value by an '@'. Refer the question video for clarity.
3. Input is managed for you.
Input Format
Input is managed for you
Output Format
@

Constraints
None
Sample Input
20
10 20 -50 -1 60 -1 -1 30 -70 -1 80 -1 90 -1 -1 40 -100 -1 -1 -1
Sample Output
30@130

Code:

package GenericTree;

import java.util.Stack;
import java.util.ArrayList;

public class NodeWithMaximumSubtreeSum {

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
	
	static int msn=0 ; //maximum sum node
	static int ms= Integer.MIN_VALUE ; //maximum sum
	
	static int retsumAndCalculateMSST(Node node) {
		int sum= 0; // sum hi return hoga, harkoi apnese niche niche ka khduko jodke sum return kardega
		
		for( Node child: node.children) {
			int csum= retsumAndCalculateMSST(child) ; //child sum
			sum += csum; //pehle child ka sum dusre child ka sum sabhi child ke sum ko add karliye
		}
		
		sum += node.data; //fir sum ke andar khudko bhi add karliya
		
		// yeh jo sum calculate hua return hone se just pehle
		if( sum > ms) { //agar yeh sum aapke maximum sum se jada hai to aapka maximum sum node iss node ko man liya jaye
			msn= node;
			ms= sum ; //aur apka maximum iss sum ke barbar ho
			
		}
		
		return sum;
	}
	
//=========================JB's
	//Approach 1
	
	 static int maxSubTreeSum = Integer.MIN_VALUE;
  static Node maxSubTreeSumNode; 
  
  public static int sum(Node node){
      int ans= node.data;
      
      for(Node child: node.children){
          ans += sum(child);
      }
      
      if(ans > maxSubTreeSum){
          maxSubTreeSum = ans;
          maxSubTreeSumNode = node;
      }
      
      return ans;
  }

	

	public static void main(String[] args) {

		Node root= construct(arr);
		retsumAndCalculateMSST(root);
		System.out.println(msn + "@");
	}

}
