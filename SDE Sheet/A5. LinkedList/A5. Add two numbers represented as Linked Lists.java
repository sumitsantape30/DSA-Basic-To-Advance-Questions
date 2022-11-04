Problem Statement: Given the heads of two non-empty linked lists representing two non-negative integers. 
The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

Examples:

Input Format: 
(Pointer/Access to the head of the two linked lists)

num1  = 243, num2 = 564

l1 = [2,4,3]
l2 = [5,6,4]

Result: sum = 807; L = [7,0,8]

Explanation: Since the digits are stored in reverse order, reverse the numbers first to get the or 
original number and then add them as → 342 + 465 = 807. Refer to the image below.

Code:

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(); //dummy node banaya hai
        ListNode temp = dummy; //yeh temp dummy node ko point kr rha hai, yeh temp actually head ko point kr rha hai, operation krte waqt temp ko hi aage badhayenge aur last mai dummy node ka next return karenge coz wahise humare elements hai
        int carry = 0;
        
        while( l1 != null || l2 != null || carry >0  ){

            int sum = 0;
            if( l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }

            if( l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry;
            int r = sum % 10;
            int q = sum / 10;

            ListNode n= new ListNode(r);
            temp.next = n;
            temp = temp.next;
            carry = q;

        }
        return dummy.next;
    }
}
