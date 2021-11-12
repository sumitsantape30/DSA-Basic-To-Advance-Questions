Print All Paths With Minimum Jumps

1. You are given a number N representing number of elements.
2. You are given N space separated numbers (ELE : elements).
3. Your task is to find & print  
    3.1) "MINIMUM JUMPS" need from 0th step to (n-1)th step.
    3.2) all configurations of "MINIMUM JUMPS".
NOTE: Checkout sample question/solution video inorder to have more insight.
Input Format
A number N (representing "NUMBER OF ELEMENTS").
ELE1 ,ELE2 ,ELE3 ,ELE4 .... ELEn (N space separated numbers represnting numbers).
Output Format
1) A number representing "MINIMUM JUMPS" need from 0th step to (n-1)th step.
2) Strings representing configurations of "MINIMUM JUMPS".
Check the sample ouput and question video.

Constraints
1 <= N <= 100
1 <= ELE <= 1000
Sample Input
10
3
3
0
2
1
2
4
2
0
0
Sample Output
4
0 -> 3 -> 5 -> 6 -> 9 .
0 -> 3 -> 5 -> 7 -> 9 .

Code:

