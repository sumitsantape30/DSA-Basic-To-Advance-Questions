Kth Node From End Of Linked List

1. You are given a partially written LinkedList class.
2. Here is a list of existing functions:
     2.1 addLast - adds a new element with given value to the end of Linked List
     2.2. display - Prints the elements of linked list from front to end in a single line. 
     All elements are separated by space.
    2.3. size - Returns the number of elements in the linked list.
    2.4. removeFirst - Removes the first element from Linked List. 
    2.5. getFirst - Returns the data of first element. 
    2.6. getLast - Returns the data of last element. 
    2.7. getAt - Returns the data of element available at the index passed. 
    2.8. addFirst - adds a new element with given value in front of linked list.
    2.9. addAt - adds a new element at a given index.
    2.10. removeLast - removes the last element of linked list.
    2.11. removeAt - remove an element at a given index
3. You are required to complete the body of kthFromLast function. The function should be an iterative function and should return the kth node from end of linked list. Also, make sure to not use size data member directly or indirectly (by calculating size via making a traversal). k is a 0-based index. Assume that valid values of k will be passed.
4. Input and Output is managed for you.
Input Format
Input is managed for you
Output Format
Output is managed for you

Constraints
1. Size property should not be used directly or indirectly
2. Constant time, single traversal is expected
3. Iterative solution, (not recursion) is expected
Sample Input
addLast 10
getFirst
addLast 20
addLast 30
getFirst
getLast
getAt 1
addLast 40
kthFromEnd 3
getLast
addLast 50
removeFirst
getFirst
removeFirst
removeFirst
kthFromEnd 0
removeFirst
removeFirst
getFirst
quit
Sample Output
10
10
30
20
10
40
20
50
List is empty

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
			//slow and fast rakhenge and woh starting mai head pe rahenge
			Node slow = head;
			Node fast= head;
			
			//ab shuruwat mai fast ka extra chalna jaruri hai taki slow aur fast mai thoda gap hojaye
			for( int i=0; i< k; i++) {
				fast= fast.next;
			}
			
			while( fast != tail) {
				// ab jabtak fast tail pe nhi pahuch jata tabtak dono ek ek chalenge to unn dono mai wog gap barkarar rahega
				slow = slow.next;
				fast = fast.next;
			} //jab fast tail pe pahuchega tab to slow apne sahi position pe pahucha hua hoga
			
			return slow.data;
		}
	}

	public static void main(String[] args) {
  
	}

}

