Problem Statement: Given a linked list, and a number N. Find the Nth node from the end of this linked list and delete it. Return the head of the new modified linked list.

Example 1 : 

Input: head = [1,2,3,4,5], n = 2

Output: [1,2,3,5]

Explanation: Refer Below Image

Code:

package Codes;

import java.util.*;
import java.io.*;


class Node{
	int data;
	Node next;
	
	public Node(int data) {
		this.data = data;
		next= null;
	}
}

public class ques {
	
	public static void removeNthNode(Node head, int n) {
		
		Node slow= head;
		Node fast= head;
		
		for( int i=1; i<=n; i++) {
			fast = fast.next;
		}
		
		while( fast.next != null) { //fast.next yeh condition smjhne keliye dry run 3,7,10 and n=2
			fast = fast.next;
			slow = slow.next;
		}
		
		slow.next = slow.next.next;
		
	}
	
	public static void display(Node head) {
		
		Node temp = head;
		while( temp != null) {
			System.out.print(temp.data);
			if( temp.next != null) {
				System.out.print("->");
			}
			temp = temp.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		Node node= new Node(3);
		node.next = new Node(7);
		node.next.next = new Node(10);

		removeNthNode(node, 2);
		display(node);

	}
}
