Problem Statement: Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that the tail’s next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.

Do not modify the linked list.

Examples:

Example 1:
Input:
 head = [1,2,3,4,3,6,10]
Output:
 tail connects to node index 2
   
Code:

//============================= Brute Force - Hashing ==========================

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        
        HashSet<ListNode> set = new HashSet<>();

        while( head != null){
            
            if( set.contains(head)){
                return head;
            }else{
                set.add(head);
                head = head.next;
            }

        }
        return null;

    }
}

//======================= Optimised - slow and fast pointer =======================================

static Node detectCycle(Node head) {
    if(head == null||head.next == null) return null;
        
    Node fast = head;
    Node slow = head;
    Node entry = head;
        
    while(fast.next != null&&fast.next.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        //jabtak slow and fast collide nhi hote tabtak aage badhate rahenge
        if(slow == fast) { //jab collide honge to slow and entry ko ekek se badhayenge
            while(slow != entry) { //jabtak woh equal nhi hai tabtak aage badhayenge
                slow = slow.next;
                entry = entry.next;
            }//jab dono ek hi node pe hai to wahi humara answer hai so return it
            return slow;
        }
    }
    return null;
}
