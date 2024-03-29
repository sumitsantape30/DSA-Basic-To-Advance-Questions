Problem Statement: Given the head of a singly linked list, return the middle node of the linked list. If there are two middle nodes, return the second middle node.

Examples:

Input Format: 
( Pointer / Access to the head of a Linked list )
head = [1,2,3,4,5]

Result: [3,4,5]
( As we will return the middle of Linked list the further linked list will be still available )

Explanation: The middle node of the list is node 3 as in the below image.

Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
Code:

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
    public ListNode middleNode(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;

        while( fast != null && fast.next != null){
            slow=  slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}

//[1,2,3,4,5,6] iss case mai hum chahte hai mid 4 ho and not 3 isiliye fast.next != null use kiya 
//agar hume 3 mid chahiye hota to fast.next != null && fast.next.next != null yeh conditions dalte
