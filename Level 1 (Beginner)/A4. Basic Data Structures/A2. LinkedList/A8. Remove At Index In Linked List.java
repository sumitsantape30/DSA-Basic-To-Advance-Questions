Remove At Index In Linked List

1. You are given a partially written LinkedList class.
2. Here is a list of existing functions:
2.1 addLast - adds a new element with given value to the end of Linked List
   2.2. display - Prints the elements of linked list from front to end in a single line. All 
   elements are separated by space
  2.3. size - Returns the number of elements in the linked list.
  2.4. removeFirst - Removes the first element from Linked List. 
  2.5. getFirst - Returns the data of first element. 
  2.6. getLast - Returns the data of last element. 
  2.7. getAt - Returns the data of element available at the index passed. 
  2.8. addFirst - adds a new element with given value in front of linked list.
  2.9. addAt - adds a new element at a given index.
  2.10. removeLast - removes the last element of linked list.
3. You are required to complete the body of removeAt function. The function should remove the element available at the index passed as parameter. If the size is 0, should print "List is empty". If the index is inappropriate print "Invalid arguments". Also consider the case when list has a single element.
4. Input and Output is managed for you.
Input Format
Input is managed for you
Output Format
Output is managed for you

Constraints
None
Sample Input
addFirst 10
getFirst
addAt 0 20
getFirst
getLast
display
size
addAt 2 40
getLast
addAt 1 50
addFirst 30
removeAt 2
getFirst
removeAt 0
removeAt 1
addAt 2 60
display
size
removeAt 0
removeAt 1
getFirst
quit
Sample Output
10
20
10
20 10 
2
40
30
20 40 60 
3
40

Code:
