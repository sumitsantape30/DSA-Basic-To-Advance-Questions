package practice;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Coding {
	
	public static class Node{
		int data;
		Node left;
		Node right;
		
		public Node(int data, Node left, Node right) {
			this.data = data;
			this.left =left;
			this.right = right;
		}
	}
	
	public static Node construct(int arr[], int lo, int hi) { //sorted array hai
		if( lo > hi) {
			return null;
		}
		
		int mid = (lo + hi)/2;
		
		int data = arr[mid];
		
		Node lc = construct(arr, lo, mid-1);
		Node rc = construct(arr, mid+1, hi);
		//isse left child aur right child banke ajayega
		
		Node node = new Node(data, lc, rc);
		
		return node;
		
	}
	
	public static void display(Node root) {
		if( root == null) {
			return;
		}
		
		String str = "";
		str += root.left == null? "." : root.left.data;
		str +="<--"+root.data+"-->";
		str += root.right == null ? ".": root.right.data;
		
		System.out.println(str);
		
		display(root.left);
		display(root.right);
	}
	
	
	public static void main(String[] args) {

		int arr[]= {12,25,37,50,62,75,87};
		Node root = construct(arr, 0, arr.length-1);
		display(root);
		
	}

}

