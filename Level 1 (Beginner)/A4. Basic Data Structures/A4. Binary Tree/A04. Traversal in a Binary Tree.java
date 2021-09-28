package BinaryTree;

public class Traversals {
	
	public static class Node{
		int data;
		Node left;
		Node right;
		
		
		public Node(int data) {
			this.data= data;
		}
	}
	
	public static void traversal(Node node) {
		if( node == null) {
			return;
		}
		
		System.out.println(node.data+" in pre"); //euler left mai means pre
		traversal(node.left); //node ke left ko call lagaya
		System.out.println(node.data+" in inorder"); // euler between -> in
		traversal(node.right); // node ke right ko call lagaya
		System.out.println(node.data+ " in postorder"); //euler right -> post
	}

	public static void main(String[] args) {

		
	}

}

