Fold A Linked List

1. You are given a partially written LinkedList class.
2. You are required to complete the body of fold function. The function is expected to place last element after 1st element, 2nd last element after 2nd element and so on. For more insight check the example

Example 1
1->2->3->4->5
will fold as
1->5->2->4->3

Example 2
1->2->3->4->5->6
1->6->2->5->3->4
Input Format
Input is managed for you
Output Format
Output is managed for you

Constraints
1. Time complexity -> O(n)
2. Space complexity -> Recursion space, O(n)
Sample Input
5
1 2 3 4 5
10
20
Sample Output
1 2 3 4 5 
1 5 2 4 3 
10 1 5 2 4 3 20 
  
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
			if (node == null) {
				return;
			}

			reversePRHelper(node.next);

			if (node == tail) {

			} else {
				node.next.next = node;
			}

		}

		public void reversePR() {
			reversePRHelper(head);
			head.next = null;

			Node temp = head;
			head = tail;
			tail = temp;
		}

		private void reverseDRHelper(Node right, int floor) {

			if (right == null) {
				return;
			}
			reverseDRHelper(right.next, floor + 1);

			if (floor > size / 2) {

				int temp = right.data;
				right.data = rleft.data;
				rleft.data = temp;

				rleft = rleft.next;
			}
		}

		Node rleft;

		public void reverseDR() {
			rleft = head;
			reverseDRHelper(head, 0);
		}
		
		private boolean IsPalindromHelper( Node right) {
			if( right == null) {
				return true;
			}
			
			boolean rres= IsPalindromHelper(right.next);
			if( rres == false) { 
				return false;
			}else if(pleft.data != right.data) { 
				return false;
			}else {
				pleft= pleft.next;
				return true;
			}			
		}
		
		Node pleft;
		public boolean IsPalindrome() {
			return IsPalindromHelper(head);
		}
		
		 private void foldHelper(Node right, int counter) {
			if( right == null) { // agar right null ke eqaul hai to return
				return;
			}
			
			foldHelper(right.next, counter +1);
			//wapas aate hue hume kuch kam karna hai 
			if( counter > size/2) { //yeh hume tabtak karna hai jabtak floor size/2 se bada hai means aadhe tak hi yeh wala kam karenge
				
			Node leftkanext = left.next; // mai left ka next preserve karke rakhenge
			left.next= right ; //aur left ka next hai right
			right.next= leftkanext; //right ke next mai jo aapne preserve kiya tha woh address ayega
			left= leftkanext; //aur fir left ko ek step aage bhi badhana hai to aage badha diya
			
		  }else if(counter == size/2) { //agar flooe size/2 ke equal hogya hai to right ko tail declare krdo aur tail ka next null krdo
			  tail= right; 
			  tail.next= null; 
		  }
		}
		
		Node left; // fold keliye left
		public void fold() {
			left= head; //left ko head se intitialise kardenge
			foldHelper(fleft, 0); //hume yaha floow use karna hoga coz half ke beyond ais karna nhi hai
		}

	}

	public static void main(String[] args) {

	}
}
