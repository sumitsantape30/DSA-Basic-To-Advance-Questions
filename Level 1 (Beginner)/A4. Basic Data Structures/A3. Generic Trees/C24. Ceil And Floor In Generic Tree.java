Ceil And Floor In Generic Tree

1. You are given a partially written GenericTree class.
2. You are required to find the ceil and floor value of a given element. Use the "travel and change" strategy explained in the earlier video. The static properties - ceil and floor have been declared for you. You can declare more if you want. If the element is largest ceil will be largest integer value (32 bits), if element is smallest floor will be smallest integer value (32 bits). Watch the question video for clarity.
3. Input and Output is managed for you.
Input Format
Input is managed for you
Output Format
Output is managed for you

Constraints
None
Sample Input
24
10 20 -50 -1 60 -1 -1 30 70 -1 -80 110 -1 -120 -1 -1 90 -1 -1 40 -100 -1 -1 -1
70
Sample Output
CEIL = 90
FLOOR = 60

Code:
//isko hum karenge travel and change strategy se

package GenericTree;

import java.util.ArrayList;

public class CeilAndFloor {

	private static class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	static int ceil;
	static int floor;

	public static void ceilAndFloor(Node node, int data) {
		//2. ceil mai sirf woh log relevant hai jo bade hai data se
		if( node.data > data) {
			//and bado mai sabse chota
			if( node.data < ceil) { // agar node ka data humare ceil se chota ho to ceil ko update karde so do equal to node.data
				ceil= node.data;
			}
		}
		
		if(node.data < data) { //iss loop mai wahi ghusenge jo data se chote hai to floor keliye yahi relevant hai
			if( node.data > floor) { //ayr agae yeh floor se bde honge to floor ko updae karenge
				floor= node.data;
			}	
		}
		
		for( Node child: node.children) {
			ceilAndFloor(child, data); //1.isse sablog visit hojayenge
		}
	}

// JB's
    public static void ceilAndFloor(Node node, int data) {
                if( node.data > data && node.data < ceil){
                       ceil= node.data;
                 }
      
                if( node.data < data && node.data > floor){
                      floor= node.data;
                 }
      
                 for(Node child: node.children){
                     ceilAndFloor(child, data);
                }
        }

	public static void main(String[] args) {

		Node root = construct(arr);
		ceil = Integer.MAX_VALUE; //smallest among larger
		floor = Integer.MIN_VALUE; // largest among smaller
		ceilAndFloor(root, data);
		System.out.println("CEIL = " + ceil);
		System.out.println("FLOOR = " + floor);
	}

}

