Add Two Linked Lists

1. You are given a partially written LinkedList class.
2. You are required to complete the body of addLinkedLists function. The function is passed two linked lists which represent two numbers - the first element is the most significant digit and the last element is the least significant digit. The function is expected to add the two linked list and return a new linked list.

The following approaches are not allowed :
    1. Don't reverse the linked lists in order to access them from least significant digit 
     to most significant.
     2. Don't use arrays or explicit extra memory.
     3. Don't convert linked lists to number, add them up and convert the result back 
     to a linked list.

Hint - You are expected to take help of recursion to access digits from least significant to most significant. You have to tackle the challenge of unequal size of lists and manage carry where required.

3. Input and Output is managed for you. 

Note-> Make sure to set head and tail appropriately because addFirst and addLast has been used to test their values in the input-output code.
Input Format
Input is managed for you
Output Format
Output is managed for you

Constraints
1. Time complexity -> O(n)
2. Space complexity -> Recursion space, O(n)
Sample Input
1
1
3
9 9 9
10
20
Sample Output
1 
9 9 9 
1 0 0 0 
10 1 0 0 0 20 

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

		private boolean IsPalindromHelper(Node right) {
			if (right == null) {
				return true;
			}

			boolean rres = IsPalindromHelper(right.next);
			if (rres == false) {
				return false;
			} else if (pleft.data != right.data) {
				return false;
			} else {
				pleft = pleft.next;
				return true;
			}
		}

		Node pleft;

		public boolean IsPalindrome() {
			return IsPalindromHelper(head);
		}

		private void foldHelper(Node right, int floor) {
			if (right == null) {
				return;
			}

			foldHelper(right.next, floor + 1);

			if (floor > size / 2) {

				Node temp = fleft.next;
				fleft.next = right;
				right.next = temp;
				fleft = temp;
			} else if (floor == size / 2) {
				tail = right;
				tail.next = null;
			}
		}

		Node fleft;

		public void fold() {
			fleft = head;
			foldHelper(fleft, 0);
		}
		
		public static int addListHelper(Node one, int pv1, Node two, int pv2, LinkedList res) { //pv1 is place value of 1 and pv2 is place value of 2. Aur linkedlist bhi pass karenge jisme hume result jama karna hai
			if( one == null && two == null) {
				//basecase: aisa krte krte one and two bhi null ho skta hai
				return 0; // yeh jo zero hum return karre woh carry hai
			}
			
			int data=0; //bahar hi data ko 0 pe set karre
			
			if( pv1 > pv2) { //ab dekhenge place value 1 ka jada hai kya
				int oc= addListHelper(one.next, pv1 - 1, two, pv2, res);
				 data= one.data +  oc; //humara data set hua
				
			}else if( pv1 < pv2){ //yafir place value 1 wale ka kam ho skta hai
				int oc= addListHelper(one, pv1, two.next, pv2-1, res);
				data= two.data +  oc;
				
			}else {
				//ya dono ka place value same ho skta hai to dono aage badhenge
				int oc= addListHelper(one.next, pv1 - 1, two.next, pv2 - 1, res); //isme upar se old carry aya
			
				 data= one.data + two.data + oc; //humara data set hua
			}
			//sabme data banke aagya
			
			//ab isse humara new data banega
			int nd= data % 10; //nd= newData
			int nc= data/10; //new carry
			
			//ab hum inko use karenge
			res.addFirst(nd); //result mai new data ko addfirst karenge
			//aur new carry ko return karenge
			return nc;
			
		}

		public static LinkedList addTwoLists(LinkedList one, LinkedList two) {

			LinkedList res= new LinkedList(); //yahi list hume return karni hai
			
			int oc= addListHelper(one.head, one.size, two.head, two.size, res); //old carry. one ka head pass kiya aur uska size pass kiya placevalue1 ke form mai and same with two
			
			//bilukl last mai yaha old carry aa rha hai 
			if( oc > 0) { //greater than 0 hai to addFirst() kare
				res.addFirst(oc);
				
			}
			return res;
		}

	}

	public static void main(String[] args) {

	}
}
