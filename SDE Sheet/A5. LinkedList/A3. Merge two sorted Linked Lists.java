Problem Statement: Given two singly linked lists that are sorted in increasing order of node values, merge two sorted linked lists and return them as a sorted list. The list should be made by splicing together the nodes of the first two lists.

Example 1:

Input Format :
l1 = {3,7,10}, l2 = {1,2,5,8,10}

Output :
{1,2,3,5,7,8,10,10}

Input Format :
l1 = {}, l2 = {3,6}

Output :
{3,6}

Explanation :
l1 is an empty list. l2 has two nodes. So, when we merge them, we will have the same list as l2.

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
	Node head; //print krne keliye
	
	//1. Using an extra LinkedList
	public static LinkedList mergeSortedLL(Node head1, Node head2) {
		
		Node one = head1;
		Node two = head2;
		
		LinkedList res= new LinkedList();
		
		while( head1 != null && head2 != null) {
			
			if( head1.data < head2.data) {
				
				res.addLast(head1);
				head1 = head1.next;
				
			}else {
				
				res.addLast(head2);
				head2 = head2.next;
			}
			
		}
		
		while( head1 != null) {
			res.addLast(head1);
			head1= head1.next;
		}
		
		while( head2 != null) {
			res.addLast(head2);
			head2 = head2.next;
		}
		
		return res;
		
	}
	
	//2. without using extra space
	public static Node mergeSortedWithoutSpace(Node head1, Node head2) {
		
		if(head1 == null)return head2;
		if(head2 == null)return head1;
		
		//mere pas 2 list hai to head1 uss list ko point karega jiski value choti hai dono heads mere
		if( head1.data > head2.data){
			
			int temp = head1.data;
			head1.data = head2.data;
			head2.data= temp;
		}
		
		Node res = head1; //head1 mai humari choti value hai to ussi list mai humara answer rahega 
		
		while( head1 != null && head2 != null) { //jabtak dono list mai elements hai tabtak chalte rahenge
			
			Node temp = null;
			
			while( head1 != null && head1.data < head2.data) { //list1 mai jabtak list2 se choti values hai aage badhte rahenge
				temp = head1;
				head1 = head1.next;	//jab mera head1 badi value pe gya to loop se bahar ayenge, uss time mera temp mere piche wali choti value pe hoga
			}
			
			//temp choti value pe hai to uske next mai list2 append krdenge
			temp.next = head2; 
			
			//l1 ko l1 pe layenge aur firse loop aage badhega
			Node tempswap = head1;
			head1= head2;
			head2= tempswap;
			
		}
		
		return res;
		
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
		
		Node node2 = new Node(1);

		node.next = new Node(2);
		node.next.next = new Node(5);
		node.next.next.next = new Node(8);
		node.next.next.next.next = new Node(10);
		
		Node res =  mergeSortedWithoutSpace(node, node2);
		
		display(res);
		

	}
}
