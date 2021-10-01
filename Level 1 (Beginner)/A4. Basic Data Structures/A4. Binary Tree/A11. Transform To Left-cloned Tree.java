Transform To Left-cloned Tree

1. You are given a partially written BinaryTree class.
2. You are required to complete the body of createLeftCloneTree function. The function is expected to create a new node for every node equal in value to it and inserted between itself and it's left child. Check question video for clarity.
3. Input and Output is managed for you.
Input Format
Input is managed for you.
Output Format
Output is managed for you. 
Question Video

Constraints
None
Sample Input
15
50 25 12 n n 37 n n 75 62 n n 87 n n
Sample Output
50 <- 50 -> 75
25 <- 50 -> .
25 <- 25 -> 37
12 <- 25 -> .
12 <- 12 -> .
. <- 12 -> .
37 <- 37 -> .
. <- 37 -> .
75 <- 75 -> 87
62 <- 75 -> .
62 <- 62 -> .
. <- 62 -> .
87 <- 87 -> .
. <- 87 -> .

Code:
