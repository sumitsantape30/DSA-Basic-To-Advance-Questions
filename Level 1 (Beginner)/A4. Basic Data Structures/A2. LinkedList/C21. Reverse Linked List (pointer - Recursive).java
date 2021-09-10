Reverse Linked List (pointer - Recursive)

1. You are given a partially written LinkedList class.
2. You are required to complete the body of reversePR and reversePRHelper functions. The functions are expected to reverse the linked list by using recursion and changing the "next" data member of nodes.
3. Input and Output is managed for you. 

Note -> The online judge can't force you to write recursive function, nor can it check if you changed the "next" data member or not. But that is what the expectation is, the intention in to help you learn.
Input Format
Input is managed for you
Output Format
Output is managed for you

Constraints
1. Time complexity -> O(n)
2. Space complexity -> O(n)
Sample Input
11
1 2 3 4 5 6 7 8 9 10 11
100
200
Sample Output
1 2 3 4 5 6 7 8 9 10 11 
200 11 10 9 8 7 6 5 4 3 2 1 100

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
			Node s = head;
			Node f = head;

			for (int i = 0; i < k; i++) {
				f = f.next;
			}

			while (f != tail) {
				s = s.next;
				f = f.next;
			}

			return s.data;
		}

		public int mid() {
			Node s = head;
			Node f = head;

			while (f.next != null && f.next.next != null) {
				s = s.next;
				f = f.next.next;
			}
			return s.data;
		}

		public static LinkedList mergeTwoSortedLists(LinkedList l1, LinkedList l2) {
			Node one = l1.head;
			Node two = l2.head;

			LinkedList res = new LinkedList();

			while (one != null && two != null) {
				if (one.data < two.data) {

					res.addLast(one.data);
					one = one.next;
				} else {
					res.addLast(two.data);
					two = two.next;
				}
			}

			while (one != null) {
				res.addLast(one.data);
				two = two.next;
			}

			while (two != null) {
				res.addLast(two.data);
				two = two.next;
			}

			return res;
		}

		private static Node midNode(Node head, Node tail) {
			Node f = head;
			Node s = head;

			while (f != tail && f.next != tail) {
				f = f.next.next;
				s = s.next;
			}

			return s;
		}

		public static LinkedList mergeSort(Node head, Node tail) {

			if (head == tail) {
				LinkedList br = new LinkedList();
				br.addLast(head.data);
				return br;
			}

			Node mid = midNode(head, tail);

			LinkedList fsh = mergeSort(head, mid);
			LinkedList ssh = mergeSort(mid.next, tail);

			LinkedList cl = LinkedList.mergeTwoSortedLists(fsh, ssh); // complete list
			return cl;
		}

		public void removeDuplicates() {
			LinkedList res = new LinkedList();

			while (this.size() > 0) {
				int val = getFirst();
				this.removeFirst();

				if (res.size() == 0 || res.tail.data != val) {
					res.addLast(val);
				}
			}

			this.head = res.head;
			this.tail = res.tail;
			this.size = res.size;
		}

		public void oddEven() {

			LinkedList odd = new LinkedList();
			LinkedList even = new LinkedList();

			while (this.size() > 0) {
				int val = this.getFirst();
				this.removeFirst();

				if (val % 2 == 0) {
					even.addLast(val);
				} else {
					odd.addLast(val);
				}
			}

			if (odd.size > 0 && even.size > 0) {

				odd.tail.next = even.head;
				this.head = odd.head;
				this.tail = even.tail;
				this.size = odd.size + even.size;

			} else if (odd.size > 0) {
				odd.tail.next = odd.head;
				this.head = odd.head;
				this.tail = odd.tail;
				this.size = odd.size;
			} else if (even.size > 0) {
				odd.tail.next = even.head;
				this.head = even.head;
				this.tail = even.tail;
				this.size = even.size;
			}
		}

		public void kReverse(int k) {
			LinkedList prev = null;

			while (this.size > 0) {
				LinkedList curr = new LinkedList();

				if (this.size >= k) {
					for (int i = 0; i < k; i++) {
						int val = this.getFirst();
						this.removeFirst();
						curr.addFirst(val);
					}
				} else {
					int sz = this.size;
					for (int i = 0; i < sz; i++) {
						int val = this.getFirst();
						this.removeFirst();
						curr.addLast(val);
					}
				}

				if (prev == null) {
					prev = curr;
				} else {
					prev.tail.next = curr.head;
					prev.tail = curr.tail;
					prev.size += curr.size;
				}
			}

			this.head = prev.head;
			this.tail = prev.tail;
			this.size = prev.size;
		}

		private void displayReverseHelper(Node node) {
			if (node == null) {
				return;
			}

			displayReverseHelper(node.next);
			System.out.println(node.data + " ");
		}

		public void displayReverse() {
			displayReverseHelper(head);
			System.out.println();
		}

		private void reversePRHelper(Node node) {
			if( node == tail) {  //agar node tail ke barbar hota hai to waha basecase bana lenge
				return; // tail pe pohoch gye to wahise return
			}
			
			reversePRHelper(node.next); // faith rakhenge, maine bola ki node.next se aage ka part reverse hoke ajao iske pointers reverse karwado
			node.next.next= node; // node bolega mere next ka next mai khud hi hu, node ke next ke next khudpe point karwa diya
			
		}

		public void reversePR() {
			reversePRHelper(head);
			
			//fir function pura chalne ke bad we have to swap head and tail
			Node temp= this.head;
			this.head= this.tail;
			this.tail= temp;
			
			this.tail.next= null; //aur tail ka next kardiya null
			// yeh kam hume ek hi bar karna hota hai jabr pura recursive kam hojaye, ek hi bar karna hota hai harbar nhi karna hota isliye yaha kr rhe hai
		} //this likhna compulsory nhi hai
	}

	public static void main(String[] args) {

	}
}
