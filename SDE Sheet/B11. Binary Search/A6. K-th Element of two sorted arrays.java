Problem Statement: Given two sorted arrays of size m and n respectively, you are tasked with finding the element that would be at the kth position of the final sorted array.

Examples :

Input: m = 5
       n = 4
       array1 = [2,3,6,7,9]
       array2 = [1,4,8,10]
       k = 5

Output:
 6

Explanation: Merging both arrays and sorted. Final array will be -
 [1,2,3,4,6,7,8,9,10]
We can see at k = 5 in the final array has 6. 


Input:
 m = 1
       n = 4
       array1 = [0]
       array2 = [1,4,8,10]
       k = 2

Output:
 4

Explanation:
 Merging both arrays and sorted. Final array will be -
 [1,4,8,10]
We can see at k = 2 in the final array has 4
   
Code:
