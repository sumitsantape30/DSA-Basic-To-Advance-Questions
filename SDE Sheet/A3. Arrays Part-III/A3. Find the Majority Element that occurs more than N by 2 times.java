Find the Majority Element that occurs more than N/2 times
Problem Statement: Given an array of N integers, write a program to return an element that occurs more than N/2 times in the given array. You may consider that such an element always exists in the array.

Example 1:

Input Format: N = 3, nums[] = {3,2,3}
Result: 3
Explanation: When we just count the occurrences of each number and compare with half of the size of the array, you will get 3 for the above solution. 

Example 2:

Input Format:  N = 7, nums[] = {2,2,1,1,1,2,2}
Result: 2
Explanation: After counting the number of times each element appears and comparing it with half of array size, we get 2 as result.

Code:

class Solution {
    public int majorityElement(int[] nums) {

        int count =0;
        int ele=0;

        for( int elem: nums){

            if( count == 0){
                ele  = elem;
            }

            if(ele == elem){
                count++;
            }else{
                count--;
            }
        }

        return ele;
    }
}
