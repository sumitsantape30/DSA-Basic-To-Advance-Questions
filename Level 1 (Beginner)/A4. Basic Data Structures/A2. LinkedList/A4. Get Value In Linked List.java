Get Value In Linked List

1. You are given a partially written LinkedList class.
2. Here is a list of existing functions:
    2.1 addLast - adds a new element with given value to the end of Linked List
    2.2. display - Prints the elements of linked list from front to end in a single line. 
     All elements are separated by space.
2.3. size - Returns the number of elements in the linked list.
2.4. removeFirst - Removes the first element from Linked List. 
3. You are required to complete the body of getFirst, getLast and getAt function 
3.1. getFirst - Should return the data of first element. If empty should return -1 and print "List is empty".
3.2. getLast - Should return the data of last element. If empty should return -1 and print "List is empty".
3.3. getAt - Should return the data of element available at the index passed. If empty should return -1 and print "List is empty". If invalid index is passed, should return -1 and print "Invalid arguments".
4. Input and Output is managed for you.
Input Format
Input is managed for you
Output Format
Output is managed for you

Constraints
None
Sample Input
addLast 10
getFirst
addLast 20
addLast 30
getFirst
getLast
getAt 1
addLast 40
getLast
addLast 50
removeFirst
getFirst
removeFirst
removeFirst
getAt 3
removeFirst
removeFirst
getFirst
quit
Sample Output
10
10
30
20
40
20
Invalid arguments
List is empty

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
		if(size == 0) { //size 0 hai to return -1 aur print bhi karna hai
			System.out.println("List is Empty");
			return -1;
		}
		return head.data;
	}
	
	public int getLast() {
		if(size == 0) { //size 0 hai to return -1 aur print bhi karna hai
			System.out.println("List is Empty");
			return -1;
		}
		return tail.data;
	}
	
	public int getAt(int idx) {
		if(size == 0) { //size 0 hai to return -1 aur print bhi karna hai
			System.out.println("List is Empty");
			return -1;
		}else if( idx < 0 || idx >= size) { //agar index negative or index size ke barabr or usse bada pass karde to iss case mai return -1
			System.out.println("Invalid arguments");
			return -1;
		}else {
			//woh index tak loop lagayenge bas
			Node temp = head;
			for( int i=0; i< idx ; i++) {
				temp = temp.next;
			} //hum ab loop ke bad uss index pe pohoch gye honge so uska data print kardegne
			return temp.data;
		}
	}
	
	public int getAt(int idx) {
		if( idx < 0 || idx >= size) { 
			System.out.println("Invalid arguments");
			return -1;
		}if(size == 0) { 
			System.out.println("List is Empty");
			return -1;
		}else if( idx == 0){
			return getFirst();
		}else if( idx == size -1){
			return getLast();
		}else{ 
			Node temp = head;
			for( int i=0; i< idx ; i++) { // index times yeh loop chalna chahiye
				temp = temp.next;
			} 
			return temp.data;
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
