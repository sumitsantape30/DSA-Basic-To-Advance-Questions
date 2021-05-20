Add Last In Linked List

1. You are given a partially written LinkedList class.
2. You are required to complete the body of addLast function. This function is supposed to add an element to the end of LinkedList. You are required to update head, tail and size as required.
3. Input and Output is managed for you. Just update the code in addLast function.
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
addLast 40
addLast 50
quit
Sample Output
10
20
30
40
50
5
50

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
		
		if( size == 0) {
			// agar size 0 hai to new node banaiye aur uska data hoga jo val pass ki gyi hai aur uska next null hoga
			Node temp= new Node();
			temp.data= val;
			temp.next= null;
			head= tail= temp; //pehla node hai to wahi head tail hoga aur size bhi badhega
			size++;
		}else { //agar first node nhi hai
			Node temp= new Node();
			temp.data= val;
			temp.next= null;
			tail.next= temp;
			tail= tail.next;
			size++;
			// starting ke 3 lines ko common bhi kr skte ho cox woh dono mai hai 
			// aur size++ kobhi bahar rakh skte ho coz node add ho rha hai to size obviosuy badhega
		}
	}
}

public class LLQues {

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int val= s.nextInt();
		LinkedList list1= new LinkedList();
		list1.addLast(10);
		
	}
}
