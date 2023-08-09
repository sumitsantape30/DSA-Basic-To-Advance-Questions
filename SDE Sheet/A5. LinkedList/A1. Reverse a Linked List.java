Problem Statement: Given the head of a singly linked list, write a program to reverse the linked list, and return the head pointer to the reversed list.

Examples:

Input Format: 
head = [3,6,8,10]
This means the given linked list is 3->6->8->10 with head pointer at node 3.

Result:
Output = [10,6,8,3]
This means, after reversal, the list should be 10->6->8->3 with the head pointer at node 10.


Code:

class Solution {

    //pointer iterative
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;  
        ListNode current = head;
    
        
        while(current != null) { 
            ListNode next = current.next; 
            current.next = prev;
            prev = current;
            current = next;
        }
       return prev; 
    }

    //pointer recursive
    
}

//===============================All 4 codes ===========================================================

package Codes;

import java.util.*;
import java.io.*;


class Node{
	int data;
	Node next;
}

public class ques {
	
	//1. pointer recursive-  pointers se reverse krta hai using recursion
	public static Node reverse(Node head) {
		if(head == null || head.next == null) {
			return head;
		}
		
		Node rnode = reverse(head.next);
		head.next.next = head; //LL reverse hogyi to jo pehle head.next pr tha woh last mai chala gya to uss last ke next mai head dal denge
		head.next = null;
		return rnode;
	}
	
	
	//2. data iterative - bas data exchange krta hai but pointers wahi rehte hai
	public static void reverse2(Node head) {
		//The reverse2 function might swap values within the nodes, 
		//but it won't reverse the linked list structure itself. 
		//If you want to reverse the linked list using a two-pointer approach, you need to manipulate 
		//the next pointers of the nodes to change their order in memory.
		
		int size=0;
		Node current = head;
		while( current != null) {
			size++;
			current = current.next;
		}
		
		int li = 0;
		int ri = size-1;
		
		while(li <= ri) { // li<=ri hoga coz swapping logic should work for the middle element as well if the list has an odd number of nodes.
			
			Node left = getNodeAt(head, li, size);
			Node right = getNodeAt(head, ri, size);
			
			int temp = left.data;
			left.data = right.data;
			right.data = temp;
			
			li++;
			ri--;
			
		}
	}
	
	public static Node getNodeAt(Node head, int idx, int size) {
		if( idx < 0 || idx >= size) { //the index should be within the bounds of the list (0 to size-1). so agar idx ==size hai to bhi null return karenge
			System.out.println("Invalid Index");
			return null;
		}
		
		Node temp = head;
		for( int i=0; i< idx && temp.next != null; i++) {
			temp = temp.next;
		}
		return temp;
	}
	
	//3. pointer iterative - 2 pointer use krke iteratively reverse krta hai LL ko. node ke next pointers ko manupulate krke reverse krte hai
	public static Node reverse3(Node head) {
		
		// initially current ko head pe bithayenge aur previous ko null pe
		Node prev = null;
		Node curr = head;

		while (curr != null) { // jabtak current null nhi hojata tabtak kam hoga
			Node next = curr.next; // originally current ka next save karke rakhlo

			curr.next = prev; // current ka next previous ko point karwayenge

			// uske bad prev aur curr ek step aage jump kare
			prev = curr; // previous ko current pe leke aaye
			curr = next; 
		}
		
		return prev; //pre mere tail pe rahega
		
	}
	
	//4. Data Recursive - sirf data ko reverse krhe
	public static Node left; //now this is data memeber of class linkedlist
	public static void reverse4(Node head) {//initially right and left dono bhi head pehi rahenge
		left = head;
		int size= 0;
		
		Node temp = head;
		while( temp != null) {
			size++;
			temp = temp.next;
		}
		reverseHelper(head, 0, size);// counter is 0 initially
	}
	
	public static void reverseHelper( Node right, int counter, int size) {
		if( right == null) { //jab right null ka barbar hojayega wahase hum return kar jayenge
			return;
		}
		
		reverseHelper(right.next, counter+1, size );// right ka next pass kardenge
		
		if( counter >= size/2) {
			//yeh swap wala kam left aadhe tak jayega tabtak hi hoga coz agar pura kiya to list jaiseki ki waisi hojayegi
			// wapas aate hue dono ka data swap karna hai
			int temp= left.data;
			left.data= right.data;
			right.data= temp;
			
			left= left.next; // ab left ko aage badhaye, so ab jo left (data memeber) bana hoga woh heap mai bana hai. jab LinkedList ka instance bana hoga wahape head, tail, size hoga aur uske hi sath sath left bhi hoga.
		    //left function ke andar rehta to function pura hone ke bad woh wipeout hojata so isliye heap mai dala data memeber banake
		    
		}
	}
// 1. left ko local nhi rakh skte the, uska scope function ke andar nhi reh skta coz function pura chalta hai to wobhi wipeout hojata hai to usko heap mai rakhna padega 
//2. fir woh swap karne wala kam aur left ko badhane wala kam yeh harbar nhi chalna chahiye yeh aadhe tak chalega

	
	public static void printLinkedList(Node head) {
		 Node temp = head;
		    while (temp != null) {
		        System.out.print(temp.data);
		        if (temp.next != null) {
		            System.out.print("->");
		        }
		        temp = temp.next;
		    }
		    System.out.println();
	}
	

	public static void main(String[] args) {
		
		 Node head = new Node();
	        head.data = 1;
	        head.next = new Node();
	        head.next.data = 2;
	        head.next.next = new Node();
	        head.next.next.data = 3;
	        head.next.next.next = new Node();
	        head.next.next.next.data = 4;
	        head.next.next.next.next = new Node();
	        head.next.next.next.next.data = 5;
	        head.next.next.next.next.next = null;

	        System.out.println("Original Linked List:");
	        printLinkedList(head);

	        Node rnode = reverse(head);
	        System.out.println();

	        System.out.println("Reversed Linked List:");
	        printLinkedList(rnode);
		

	}
}
