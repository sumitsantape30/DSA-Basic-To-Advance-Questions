Celebrity Problem
1. You are given a number n, representing the number of people in a party.
2. You are given n strings of n length containing 0's and 1's
3. If there is a '1' in ith row, jth spot, then person i knows about person j.
4. A celebrity is defined as somebody who knows no other person than himself but everybody else knows him.
5. If there is a celebrity print it's index otherwise print "none".

Note -> There can be only one celebrity. Think why?

                               
Input Format
Input is managed for you  
Output Format
Index of celebrity or none

Constraints
1 <= n <= 10^4
e1, e2, .. n * n elements belongs to the set (0, 1)
Sample Input
4
0000
1011
1101
1110
Sample Output
0

Code:

