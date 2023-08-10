Problem Statement: Given the head of a singly linked list, return true if it is a palindrome.

Examples:

Example 1:
Input: head = [1,2,3,3,2,1] 
Output:
 true
Explanation: If we read elements from left to right, we get [1,2,3,3,2,1]. When we read elements from right to left, we get [1,2,3,3,2,1]. 
  Both ways list remains same and hence, the given linked list is palindrome.
  
Code:

//=============================== Brute Force ============================================================
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
 
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        while( head != null){
            list.add(head.val);
            head = head.next;
        }

        for( int i=0; i< list.size()/2; i++){

            if( list.get(i) != list.get(list.size()-i-1)){
                return false;
            }
        }
        return true;
    }
}


//===================================== Optimal Approach ==================================

public static Node reverse(Node curr) { // pointer iterative

		Node pre = null; // This will store the previous node in the reversed list
		Node nex = null; // This will temporarily store the next node of the current node
		while (curr != null) {
			nex = curr.next; // Store the next node of the current node
			curr.next = pre; // Update the next pointer of the current node to point to the previous node
			pre = curr; // Move the 'pre' pointer to the current node
			curr = nex; // Move the 'ptr' pointer to the next node
		}
		return pre;
	}

static boolean isPalindrome(Node head) {
    if(head==null||head.next==null) return true; //if LL is null or if its consisting of single element
        
    Node slow = head;
    Node fast = head;
    
   //finding the middle of LL
    while(fast.next!=null&&fast.next.next!=null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    
 //then reverse the right half
    slow.next = reverse(slow.next);
 
 //then move slow to right half
    slow = slow.next; // slow is standing at the starting position of right half
 
 //then create a dummy node to check the left half and right half is equal or not
    Node dummy = head;
        
    while(slow!=null) {
        if(dummy.num != slow.num) return false;
     
        dummy = dummy.next;
        slow = slow.next;
    }
    return true;
}
