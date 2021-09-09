Merge Two Sorted Linked Lists

1. You are given a partially written LinkedList class.
2. You are required to complete the body of mergeTwoSortedLists function. The function is static and is passed two lists which are sorted. The function is expected to return a new sorted list containing elements of both lists. Original lists must stay as they were.
3. Input and Output is managed for you.
Input Format
Input is managed for you
Output Format
Output is managed for you

Constraints
1. O(n) time complexity and constant space complexity expected.
Sample Input
5
10 20 30 40 50
10
7 9 12 15 37 43 44 48 52 56
Sample Output
7 9 10 12 15 20 30 37 40 43 44 48 50 52 56 
10 20 30 40 50 
7 9 12 15 37 43 44 48 52 56 

Code:

package LinkedList;

import java.util.LinkedList;
import java.util.Scanner;

public class KthEleFromEnd {

	public static class Node {
		int data;
		Node next;
	}

	public static class LinkedList {
		Node head;
		Node tail;
		int size;

		void addLast(int val) {
			Node temp = new Node();
			temp.data = val;
			temp.next = null;

			if (size == 0) {
				head = tail = temp;
			} else {
				tail.next = temp;
				tail = temp;
			}

			size++;
		}

		public int size() {
			return size;
		}

		public void display() {
			for (Node temp = head; temp != null; temp = temp.next) {
				System.out.print(temp.data + " ");
			}
			System.out.println();
		}

		public void removeFirst() {
			if (size == 0) {
				System.out.println("List is empty");
			} else if (size == 1) {
				head = tail = null;
				size = 0;
			} else {
				head = head.next;
				size--;
			}
		}

		public int getFirst() {
			if (size == 0) {
				System.out.println("List is empty");
				return -1;
			} else {
				return head.data;
			}
		}

		public int getLast() {
			if (size == 0) {
				System.out.println("List is empty");
				return -1;
			} else {
				return tail.data;
			}
		}

		public int getAt(int idx) {
			if (size == 0) {
				System.out.println("List is empty");
				return -1;
			} else if (idx < 0 || idx >= size) {
				System.out.println("Invalid arguments");
				return -1;
			} else {
				Node temp = head;
				for (int i = 0; i < idx; i++) {
					temp = temp.next;
				}
				return temp.data;
			}
		}

		public void addFirst(int val) {
			Node temp = new Node();
			temp.data = val;
			temp.next = head;
			head = temp;

			if (size == 0) {
				tail = temp;
			}

			size++;
		}

		public void addAt(int idx, int val) {
			if (idx < 0 || idx > size) {
				System.out.println("Invalid arguments");
			} else if (idx == 0) {
				addFirst(val);
			} else if (idx == size) {
				addLast(val);
			} else {
				Node node = new Node();
				node.data = val;

				Node temp = head;
				for (int i = 0; i < idx - 1; i++) {
					temp = temp.next;
				}
				node.next = temp.next;

				temp.next = node;
				size++;
			}
		}

		public void removeLast() {
			if (size == 0) {
				System.out.println("List is empty");
			} else if (size == 1) {
				head = tail = null;
				size = 0;
			} else {
				Node temp = head;
				for (int i = 0; i < size - 2; i++) {
					temp = temp.next;
				}

				tail = temp;
				tail.next = null;
				size--;
			}
		}

		public void removeAt(int idx) {
			if (idx < 0 || idx >= size) {
				System.out.println("Invalid arguments");
			} else if (idx == 0) {
				removeFirst();
			} else if (idx == size - 1) {
				removeLast();
			} else {
				Node temp = head;
				for (int i = 0; i < idx - 1; i++) {
					temp = temp.next;
				}

				temp.next = temp.next.next;
				size--;
			}
		}

		private Node getNodeAt(int idx) {
			Node temp = head;
			for (int i = 0; i < idx; i++) {
				temp = temp.next;
			}
			return temp;
		}

		public void reverseDI() {
			int li = 0;
			int ri = size - 1;
			while (li < ri) {
				Node left = getNodeAt(li);
				Node right = getNodeAt(ri);

				int temp = left.data;
				left.data = right.data;
				right.data = temp;

				li++;
				ri--;
			}
		}

		public void reversePI() {
			if (size <= 1) {
				return;
			}

			Node prev = null;
			Node curr = head;
			while (curr != null) {
				Node next = curr.next;

				curr.next = prev;
				prev = curr;
				curr = next;
			}

			Node temp = head;
			head = tail;
			tail = temp;
		}

		public int kthFromLast(int k) {
			Node s= head;
			Node f= head;
			
			for( int i=0; i< k; i++) {
				f= f.next;
			}
			
			while( f != tail) {
				s= s.next;
				f=f.next;
			}
			
			return s.data;
		}
		
		public int mid() {
			Node s= head;
			Node f= head;
			
			while( f.next != null && f.next.next != null) { 
				s= s.next;
				f= f.next.next;
			}
			return s.data;
		}
		
		public static LinkedList mergeTwoSortedLists(LinkedList l1, LinkedList l2 ) {
			Node one= l1.head;  // node 1 ko list 1 ke head pe bitha diya
			Node two= l2.head; // node 2 ko list 2 ke head pe bitha diya
			
			LinkedList res= new LinkedList(); //yeh woh new linkedlist hai jo hume return karni hai
			
			while( one != null && two != null) {
				//jabtak dono mai kuch stuff hai tabtak comparison hoke use hoga
				if(one.data < two.data) {
					//agar 1 ka data chota hai 2 ke data se to hum result mai add last karenge one ke data ko aur one= one.next karenge
					res.addLast(one.data);
					one= one.next;
				}else {
					res.addLast(two.data); //else hum 2 ke data ko addlast karenge aur two ko two.next karenge
					two= two.next;
				}
			}
			
			//bahar aane ke bad 2 bate ho skti hai ya to one khatam hgya yafir two khatam hogya ho
			//agar two khatam hogya aur one bacha hai to bina comparison ke ones ko consume karenge
			while( one != null ) {
					res.addLast(one.data); 
					one = one.next;
			}
			
			//ho skta hai ki one khatam hogya ho aur two abhibhi bacha hua ho two ko cosume karenge
			while( two != null) {
				res.addLast(two.data);
				two = two.next;
			}
			
			return res;
		}
	}

	public static void main(String[] args) {
	
	}
}


