Node To Root Path In Generic Tree

1. You are given a partially written GenericTree class.
2. You are required to complete the body of nodeToRootPath function. The function is expected to return in form of linked list the path from element to root, if the element with data is found.
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
120
Sample Output
[120, 80, 30, 10]

Code:

package GenericTree;

import java.util.ArrayList;

public class NodetoRootPath {

	public static class Node {
		int data;
		ArrayList<Node> children = new ArrayList<Node>();
	}

	//iska faith yeh hai ki node aur yeh data pass kiya gya hai, so agar yeh data iske andar hi kahi mil jata hai to jaha yeh data milega wahase yeh nodetak ka rasta hum arraylist mai bharke denge
	public static ArrayList<Integer> nodeToRootPath(Node node, int data) {
		if( node.data == data) {
			//agr node ka data equal to data hai to ek arraylist banayenge aur uss list ka andar khudko hi add karenge aur return kardenge
			ArrayList<Integer> list= new ArrayList<>();
			list.add(node.data);
			return list;
		}
		
		// incase woh khud barbr nhi hai to woh apne children ko call karega
		for( Node child: node.children) {
			ArrayList<Integer> ptc = nodeToRootPath(child, data); //path till child, child tak ka path miljaye
			
			if( ptc.size() > 0) { //agar path till child ka size grater than 0 hai means path till child milgya to uske andar khudko add karo aur laut jao
				ptc.add(node.data);
				return ptc;
			}
		}
		
		// agar aisa hua ki woh na khud barbar hai aur nahi kisi children mai mila means milahi nhi so false keliye hum khali arraylist return krte hai
		return new ArrayList<>();

	}

	public static void main(String[] args) {

	}

}
