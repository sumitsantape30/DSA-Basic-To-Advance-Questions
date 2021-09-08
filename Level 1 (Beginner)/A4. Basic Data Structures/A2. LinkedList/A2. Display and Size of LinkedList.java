Display A Linkedlist

1. You are given a partially written LinkedList class.
2. Here is a list of existing functions:
   2.1 addLast - adds a new element with given value to the end of Linked List
3. You are required to complete the body of display function and size function
   3.1. display - Should print the elements of linked list from front to end in a single line. Elements should be separated by space.
   3.2. size - Should return the number of elements in the linked list.
4. Input and Output is managed for you.
Input Format
Input is managed for you
Output Format
Output is managed for you

Constraints
None
Sample Input
addLast 10
addLast 20
addLast 30
display
size
addLast 40
addLast 50
display
size
quit
Sample Output
10 20 30 
3
10 20 30 40 50 
5
  
Code:

package LinkedList;

import java.util.Scanner;

class Node {
	int data;
	Node next;

// 	public Node(int data) {
// 		this.data = data;
// 		next = null;
// 	}

// 	public Node() {
         
// 	}
	
}

class LinkedList {
	Node head;
	Node tail;
	int size;
	
	public LinkedList(){
		head= null;
		tail= null;
		size=0;
	}

	void addLast(int val) {
		Node temp= new Node();
		temp.data= val;
		temp.next= null;
		
		if( size == 0) {
			head= tail= temp; 
		}else { 
			tail.next= temp;
			tail= tail.next;
		}
		size++;
	}
	
	public int size() {
		return size;
	}
	
	public void display() {
		
		Node temp= head;
		while( temp != null) { //jabtak temp null nhi hojata tabtak kam chalega
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();
	}
}

public class LLQues {

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int val= s.nextInt();
		LinkedList list1= new LinkedList();
		list1.addLast(10);
		list1.addLast(20);
		list1.addLast(30);
		list1.addLast(40);
		list1.display();
		
	}
}
