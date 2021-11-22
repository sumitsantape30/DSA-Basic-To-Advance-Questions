N Queens Using Bit

1. You are given a number n, the size of a chess board.
2. You are required to place n number of queens in the n * n cells of board such that no queen can kill another.
     Note - Queens kill at distance in all 8 directions
3. Complete the body of printNQueens function - without changing signature - to calculate and print all safe configurations of n-queens
     Use sample input and output to get more idea.

Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is.
               Write recursive and not iterative logic. The purpose of the question is to aid learning recursion, branch and bound technique, bit manipulation 
               and not test you.
Input Format
A number n
Output Format
Safe configurations of queens as suggested in sample output

  COMMENTConstraints
1 <= n <= 10
Sample Input
4
Sample Output
0-1, 1-3, 2-0, 3-2, .
0-2, 1-0, 2-3, 3-1, .

Code:
