Remove Duplicates In A Sorted Linked List

1. You are given a partially written LinkedList class.
2. You are required to complete the body of removeDuplicates function. The function is called on a sorted list. The function must remove all duplicates from the list in linear time and constant space
3. Input and Output is managed for you. 
Input Format
Input is managed for you
Output Format
Output is managed for you

Constraints
1. Time complexity -> O(n)
2. Space complexity -> constant
Sample Input
10
2 2 2 3 3 5 5 5 5 5
Sample Output
2 2 2 3 3 5 5 5 5 5 
2 3 5 

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

		// oops ke concepts ke basis pe solve karenge
		// yeh removeDuplicates jis linkedlist pe call hua uska address 'this' mai rahega. (l1.removeDuplicates() : yahape l1 pe call hua to 'this' mai l1 ka address rahega )
		public void removeDuplicates() {
			LinkedList res= new LinkedList();
			
			while( this.size() > 0) { // this kon hai? jis list pe yeh code call hua hai jo sorted list hai jisme duplicates hai
				//so jabtak uska size grater than 0 hai 
				int val= getFirst();
				this.removeFirst();
				
				if( res.size() == 0 || res.tail.data != val) { //agar result ka size 0 hai yafir result ki tail ke data se different hai yeh val to result mai addLat kare
					res.addLast(val);
				} //so n bar chalke yeh loop apne non dupicates result ke andar dal dega
				
			}
			
			this.head= res.head; // this.head ko hume result.head karna hai aur tail and size ke sath bhi same
			this.tail= res.tail;
			this.size= res.size;
			//directly this= res nhi kr skte coz this read only hota hai, this ko nh change kr skte this ki properties ko change kr skte hai so humne this ki teeno properties change krdi
		}
		
	/* JB's Method=====================
	
		public void removeDuplicates() {
			
			LinkedList ans= new LinkedList();
			ans.addLast(this.getFirst()); //first wala element maine this wali linkedlist se nikal liya aur ans mai dal diya
			this.removeFirst(); //badme usko this wali list se remove kardiya
			
			while(this.size() > 0) {
				int val= this.getFirst(); //ab next value nikali
				this.removeFirst();
				
				if( ans.getLast() != val) { //agar yeh ans ki tail se different hai tabhi ans mai dalenge
					ans.addLast(val);
				}
			}
			// yahape aaye means this wali linkedlist khali hogyi hai, head bhi null, tail bhi null aur size bhi 0
			// this= ans ; //this keyword is read only usko hum change nhi kr skte, so this = ans kiya means ans ka address uthake this mai store karneki koshish kr rhe ho means this ki value change karneki koshish kr rhe ho but woh to read only hai 
			//but hum this ki properties ko change kr skte hai
			this.head= ans.head;
			this.tail= ans.tail;
			this.size= ans.size;
			
		}   */
	}

	public static void main(String[] args) {

	}

}
