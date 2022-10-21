Problem Statement: Given an array containing both positive and negative integers, we have to find the length of the longest subarray with the sum of all elements equal to zero.

Example 1:

Input Format: N = 6, array[] = {9, -3, 3, -1, 6, -5}

Result: 5

Explanation: The following subarrays sum to zero:
{-3, 3} , {-1, 6, -5}, {-3, 3, -1, 6, -5}
Since we require the length of the longest subarray, our answer is 5!
  
Code:

//===================================== Brute Force=============================================
import java.util.*;

public class Solution {
static int solve(int[] a){
	int  max = 0;
	for(int i = 0; i < a.length; ++i){
		int sum = 0;
		for(int j = i; j < a.length; ++j){
			sum += a[j];
			if(sum == 0){
				max = Math.max(max, j-i+1);
			}
		}
	}
	return max;
   }

    public static void main(String args[]) 
    { 
        int a[] = {9, -3, 3, -1, 6, -5};
        System.out.println(solve(a));
    } 
}

//============================================ optimised================================
class GfG
{
    int maxLen(int A[], int n)
    {
    HashMap<Integer, Integer> mpp = new HashMap<Integer, Integer>();
    //first integer is going to store prefix sum and second Integer is going to store the index

        int maxi = 0;//it will store maximum length of subarray that'll give sum as 0
        int sum = 0; //

        for(int i = 0;i<n;i++) {

            sum += A[i]; 

            if(sum == 0) {//if sum is 0 I can say that subarray from starting index to current index is giving you sum 0. so if you are currently stading at i the length is going to be i+1
                maxi = i + 1; 
            }
            else { //if sum is not 0
                if(mpp.get(sum) != null) { // checking if sum exists in hashmap or not

                    maxi = Math.max(maxi, i - mpp.get(sum)); //if it does exsit I'll get the index where it is existing and substract it with current index to get the length and I simply compare it with previous maximum and if it is excceeds I'll update maximum
                }
                else {//if not present i'll put it in hashmap

                    mpp.put(sum, i); 
                }
            }
        }
        return maxi; 
    }
}
