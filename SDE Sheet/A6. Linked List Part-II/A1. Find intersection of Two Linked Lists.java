Problem Statement: Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. 
  If the two linked lists have no intersection at all, return null.

 Example 1:
Input:
List 1 = [1,3,1,2,4], List 2 = [3,2,4]
Output:
2
Explanation: Here, both lists intersecting nodes start from node 2.
  
Code:

//============================= Brute Force =================================

//utility function to check presence of intersection
static Node intersectionPresent(Node head1,Node head2) {
    while(head2 != null) {
        Node temp = head1;
        while(temp != null) {
            //if both nodes are same
            if(temp == head2) return head2;
            temp = temp.next;
        }
        head2 = head2.next;
    }
    //intersection is not present between the lists return null
    return null;
}

//============================= better ====================================

//utility function to check presence of intersection
static Node intersectionPresent(Node head1,Node head2) {
     HashSet<Node> st=new HashSet<>();
    while(head1 != null) {
       st.add(head1);
       head1 = head1.next;
    }
    while(head2 != null) {
        if(st.contains(head2)) return head2;
        head2 = head2.next;
    }
    return null;

}

//================================= optimal 1 =============================

static Node intersectionPresent(Node head1,Node head2) {
  if( head1 == null || head2 == null){
    return null;
  }
  //take two pointers and point to the head of both the LL
    Node d1 = head1;
    Node d2 = head2;
    
    while(d1 != d2) { //i'll keep traversing until they become equal
        d1 = d1 == null? head2:d1.next; //if d1 became null then it directly moves to the head of the other LL and if d1 is not null it'll move to the next node
        d2 = d2 == null? head1:d2.next; //if d2 became null then it directly move to the head of opposite LL or if d2 is not null it'll move to the next node
    }
    
    return d1;
}

//=============================== Optimal 2 =============================================

public static int size(Node head) {
		Node temp = head;
		int size= 0;
		while( temp != null) {
			size++;
			temp = temp.next;
		}
		return size;
	}
	
	public static Node intersectionOptimised(Node head1, Node head2) {
		
		int size1 = size(head1);
		int size2 = size(head2);
		
		int delta = Math.abs(size2- size1);
		
		Node d1= head1;
		Node d2= head2;
		
		if( size1 > size2) {
			
			for( int i=0; i< size1; i++) {
				d1 = d1.next;
			}
			
		}else {
			
			for( int i=0; i< size2; i++) {
				d2 = d2.next;
			}
			
		}
		
		while( d1 != d2) {
			d1 = d1.next;
			d2 = d2.next;
		}
		
		return d1;
		
	}
