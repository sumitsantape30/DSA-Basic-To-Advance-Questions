Add At Index In Linked List

1. You are given a partially written LinkedList class.
2. Here is a list of existing functions:
   2.1 addLast - adds a new element with given value to the end of Linked List
   2.2. display - Prints the elements of linked list from front to end in a single line. All 
   elements are separated by space
  2.3. size - Returns the number of elements in the linked list.
  2.4. removeFirst - Removes the first element from Linked List. 
  2.5. getFirst - Returns the data of first element. 
  2.6. getLast - Returns the data of last element. 
  2.7. getAt - Returns the data of element available at the index passed. 
  2.8. addFirst - adds a new element with given value in front of linked list.
3. You are required to complete the body of addAt function. This function should add the element at the index mentioned as parameter. If the idx is inappropriate print "Invalid arguments".
4. Input and Output is managed for you.
Input Format
Input is managed for you
Output Format
Output is managed for you

Constraints
None
Sample Input
addFirst 10
getFirst
addAt 0 20
getFirst
getLast
display
size
addAt 2 40
getLast
addAt 1 50
addFirst 30
removeFirst
getFirst
removeFirst
removeFirst
addAt 2 60
display
size
removeFirst
removeFirst
getFirst
quit
Sample Output
10
20
10
20 10 
2
40
20
  
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
		
		//pehle special case handle karenge
		if(idx < 0 || idx > size) { 
			System.out.println("Invalid Arguments");
		}else if( idx == 0) {
			//agar index 0 hai to mai addFirst() ka fayda uthaunga
			addFirst(val);
		}else if( idx == size) {
			//agar muje koi size mean last pe add karne bolega to addLast() ka dayda lenge
			addLast(val);
		}else {
			// agar bichme kahi add karna hai
			Node node= new Node();
			node.data= val;
		
			Node temp= head;
			for( int i=0; i< idx-1; i++) { //woh index ke ek piche tak gye
				temp= temp.next;
			}//so isse muje index-1 th banda mil jayega
			
			//mai pehle node ka next waha dal dunga jaha temp point krta hai
			node.next = temp.next; //abhi temp hata nhi hai
			//ab bolenge temp ki tum ab node ko point karo
			temp.next= node;
			
			size++; //aur size ko jarur badhaye
		}
	}
	
	/* 
	 public void addAt(int idx, int val){
      if (idx < 0 || idx > size) {
			System.out.println("Invalid arguments");

	     } else if (idx == 0) {

			addFirst(val);
            } else if(idx == size) {
			addLast(val);
	     } else {
			Node temp = head;
			int len = 0;
			while (len < idx - 1) {

			    temp = temp.next;
			    len++;
			}
				
		    	Node newNode = new Node();
	                newNode.data = val;
			newNode.next = temp.next;
			temp.next = newNode;
			size++;
			}
    }
	*/
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
