Problem Statement: Given the head of a singly linked list, write a program to reverse the linked list, and return the head pointer to the reversed list.

Examples:

Input Format: 
head = [3,6,8,10]
This means the given linked list is 3->6->8->10 with head pointer at node 3.

Result:
Output = [10,6,8,3]
This means, after reversal, the list should be 10->6->8->3 with the head pointer at node 10.


Code:

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;  
        ListNode current = head;
    
        
        while(current != null) { 
            ListNode next = current.next; 
            current.next = prev;
            prev = current;
            current = next;
        }
       return prev; 
    }
}
