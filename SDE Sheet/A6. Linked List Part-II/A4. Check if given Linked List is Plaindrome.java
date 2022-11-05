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

