Delete given node in a Linked List : O(1) approach
Problem Statement: Write a function to delete a node in a singly-linked list. You will not be given access to the head of the list instead, 
you will be given access to the node to be deleted directly. It is guaranteed that the node to be deleted is not a tail node in the list.

Code:

//======================= Leetcode ===================================

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        
        node.val = node.next.val;//jo node delete krna hai uss node ki value change krdo bas, aur diya hai ki yeh node kabhi tail nhi hoga so node.next.val kam karega
        node.next = node.next.next; // aur fir link todne ke liye next ke next node pe point karo
    //agar question mai diya hota ki tail bhi ho skti to if else use krkr dekhte ki yeh node tail hai kya agar tail hai to isko null set krdete
    }
}

//============================ TUF ==============================

import java.util.*;
class Node {
        int num;
        Node next;
        Node(int a) {
            num = a;
            next = null;
        }
}
class TUF{
//function to insert node at the end of the list
static Node insertNode(Node head,int val) {
    Node newNode = new Node(val);
    if(head == null) {
        head = newNode;
        return head;
    }
    Node temp = head;
    while(temp.next != null) temp = temp.next;
    temp.next = newNode;
    return head;
}
//function to get reference of the node to delete
static Node getNode(Node head,int val) {
    if(head==null)
    return null;
    while(head.num != val) head = head.next;
    
    return head;
}
//delete function as per the question
static void deleteNode(Node t) {
    if(t==null)
    return;
    t.num = t.next.num;
    t.next = t.next.next;
    return;
}
//printing the list function
static void printList(Node head) {
    if(head==null)
    return;
    while(head.next!=null ) {
        System.out.print(head.num+"->");
        head = head.next;
    }
    System.out.println(head.num);
}

public static void main(String args[]) {
    Node head = null;
    //inserting node
    head=insertNode(head,1);
    head=insertNode(head,4);
    head=insertNode(head,2);
    head=insertNode(head,3);
    //printing given list
    System.out.println("Given Linked List: ");
    printList(head);
    Node t = getNode(head,2);
    //delete node
    deleteNode(t);
    //list after deletion operation
    System.out.println("Linked List after deletion: ");
    printList(head);
}
}
