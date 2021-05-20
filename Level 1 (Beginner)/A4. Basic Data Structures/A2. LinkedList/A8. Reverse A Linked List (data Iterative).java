Reverse A Linked List (data Iterative)

1. You are given a partially written LinkedList class.
2. Here is a list of existing functions:
    2.1 addLast - adds a new element with given value to the end of Linked List
    2.2. display - Prints the elements of linked list from front to end in a single line. 
    All elements are separated by space
    2.3. size - Returns the number of elements in the linked list.
    2.4. removeFirst - Removes the first element from Linked List. 
    2.5. getFirst - Returns the data of first element. 
    2.6. getLast - Returns the data of last element. 
    2.7. getAt - Returns the data of element available at the index passed. 
    2.8. addFirst - adds a new element with given value in front of linked list.
    2.9. addAt - adds a new element at a given index.
    2.10. removeLast - removes the last element of linked list.
    2.11. removeAt - remove an element at a given index.
3. You are required to complete the body of reverseDI function. The function should be an iterative function and should reverse the contents of linked list by changing the "data" property of nodes.
4. Input and Output is managed for you.
Input Format
Input is managed for you
Output Format
Output is managed for you

Constraints
None
Sample Input
addFirst 10
addFirst 20
addLast 30
addLast 40
addLast 50
addFirst 60
removeAt 2
display
reverseDI
display
quit
Sample Output
60 20 30 40 50 
50 40 30 20 60 

Code:
package LinkedList;

import java.util.Scanner;

class Node {
	int data;
	Node next;

	public Node(int data) {
		this.data = data;
		next = null;
	}

	public Node() {
         
	}
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
		while( temp != null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public void removeFirst() {
		if( size == 0) {
			System.out.println("List is Empty");
		}else if( size() == 1) { 
			head= tail= null;
			size=0;
		} else{ 
			head= head.next;
			size--;
		}
	}
	
	public int getFirst() {
		if(size == 0) { 
			System.out.println("List is Empty");
			return -1;
		}
		return head.data;
	}
	
	public int getLast() {
		if(size == 0) { 
			System.out.println("List is Empty");
			return -1;
		}
		return tail.data;
	}
	
	public int getAt(int idx) {
		if(size == 0) { 
			System.out.println("List is Empty");
			return -1;
		}else if( idx < 0 || idx >= size()) { 
			System.out.println("Invalid Argument");
			return -1;
		}else {
			Node temp = head;
			for( int i=0; i< idx ; i++) {
				temp = temp.next;
			} 
			return temp.data;
		}
	}
	
	public void addFirst(int val) {
		Node temp= new Node();
		temp.data= val;
		temp.next= head;
		head= temp; 
		
		if( size == 0) { 
			tail= temp;
		}
		size++;
	}
	
	public void addAt(int idx, int val) {
		
		if(idx < 0 || idx > size) {
			System.out.println("Invalid Arguments");
		}else if( idx == 0) {
			addFirst(val);
		}else if( idx == size) {
			addLast(val);
		}else {
			Node node= new Node();
			node.data= val;
		
			Node temp= head;
			for( int i=0; i< idx-1; i++) { 
				temp= temp.next;
			}
			
			node.next = temp.next; 
			temp.next= node;
			
			size++; 
		}
	}
	
	public void removeLast() {
		if( size == 0) { 
			System.out.println("List is Empty");
		}else if( size() == 1) {  
			head= tail= null;
			size=0;
		} else{ 
			
			Node temp= head;
			for( int i=0; i< size-2; i++) {
				temp= temp.next;
			}
			
			tail= temp;
			temp.next= null;
			size--;
		}
	}
	
	private Node getNodeAt(int idx) {
		//getAdd kisi index pe pdi hui value deta tha but yeh fucntion uss index pe pda hua node return karega, data nhi pura node hi de dega
		Node temp= head;
		for( int i=0; i< idx; i++) {
			temp= temp.next;
		}
		return temp;
	}
	
	public void reverseDI() {
		// hum private function banake call karenge

		// left and right index rakhenge
		int li = 0;
		int ri = size - 1;

		while (li > ri) {
			// private wala function use krke left and right wala node nikalunga aur un donoke data property ko swap karenge
			Node left = getNodeAt(li);
			Node right= getNodeAt(ri);
			
			int temp= left.data;
			left.data= right.data;
			right.data= temp;
			
			li++;
			ri--;
		}
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
		list1.removeFirst();

	}
}
