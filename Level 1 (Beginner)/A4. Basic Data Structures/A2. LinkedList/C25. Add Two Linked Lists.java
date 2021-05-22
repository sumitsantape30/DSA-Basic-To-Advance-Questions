Add Two Linked Lists

1. You are given a partially written LinkedList class.
2. You are required to complete the body of addLinkedLists function. The function is passed two linked lists which represent two numbers - the first element is the most significant digit and the last element is the least significant digit. The function is expected to add the two linked list and return a new linked list.

The following approaches are not allowed :
    1. Don't reverse the linked lists in order to access them from least significant digit 
     to most significant.
     2. Don't use arrays or explicit extra memory.
     3. Don't convert linked lists to number, add them up and convert the result back 
     to a linked list.

Hint - You are expected to take help of recursion to access digits from least significant to most significant. You have to tackle the challenge of unequal size of lists and manage carry where required.

3. Input and Output is managed for you. 

Note-> Make sure to set head and tail appropriately because addFirst and addLast has been used to test their values in the input-output code.
Input Format
Input is managed for you
Output Format
Output is managed for you

Constraints
1. Time complexity -> O(n)
2. Space complexity -> Recursion space, O(n)
Sample Input
1
1
3
9 9 9
10
20
Sample Output
1 
9 9 9 
1 0 0 0 
10 1 0 0 0 20 

Code:
