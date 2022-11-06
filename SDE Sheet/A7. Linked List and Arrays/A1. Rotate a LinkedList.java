Problem Statement: Given the head of a linked list, rotate the list to the right by k places.

Example 1:
Input:
	head = [1,2,3,4,5] 
	k = 2
Output:
 head = [4,5,1,2,3]
Explanation:
 We have to rotate the list to the right twice.
   
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
    public ListNode rotateRight(ListNode head, int k) {
        if( head == null || head.next == null || k == 0){
            return head;
        }
        
        ListNode temp = head;
        int len = 1;
        while( temp.next != null){
            len++;
            temp = temp.next;
        }

        temp.next = head;//last node ko first node se link karo, ab yeh circular ban gya hai
        k = k % len;
        int end = len - k;//itne times LL mai aage jake iske next ko head mai dal deng aur iska next null karedenge
        while( end != 0){
            temp = temp.next;
            end--;
        }

        head = temp.next;
        temp.next = null;
        
        return head;
    }
}
