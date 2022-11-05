Detect a Cycle in a Linked List

Problem Statement: Given head, the head of a linked list, determine if the linked list has a cycle in it. There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.

Return true if there is a cycle in the linked list. Otherwise, return false.

Code:

//============================== Brute Force- Hashing===============================================
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
    public boolean hasCycle(ListNode head) {
        
        HashSet<ListNode> set = new HashSet<>();
        ListNode temp = head;
        while( temp != null){

            if( set.contains(temp) == false){
                set.add(temp);
                temp = temp.next;
            }else{
                return true;
            }
        }
        return false;

    }
}

//========================= Optimal- Slow and Fast pointer=============================

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
    public boolean hasCycle(ListNode head) {
        
        ListNode fast = head;
        ListNode slow = head;

        while( fast != null && fast.next != null){
            fast = fast.next.next;
            slow  = slow.next;
            if( slow == fast){
                return true;
            }
        }
        return false;

    }
}
