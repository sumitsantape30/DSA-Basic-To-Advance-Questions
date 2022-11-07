Problem Statement: Given an array of non-negative integers representation elevation of ground. Your task is to find the water that can be trapped after rain.

Examples:

Example 1:

Input: height= [0,1,0,2,1,0,1,3,2,1,2,1]

Output: 6

Explanation: As seen from the diagram 1+1+2+1+1=6 unit of water can be trapped

Code:

//======================================= Brute Force - maths =====================================

class Solution {
    public int trap(int[] arr) {
        int n = arr.length;
        int waterTrapped = 0;
        for (int i = 0; i < n; i++) {
            int j = i;
            int leftMax = 0, rightMax = 0;
            //left side ka max nikalo for current index
            while (j >= 0) {
                leftMax = Math.max(leftMax, arr[j]);
                j--;
            }
            j = i;
            //right side ka max nikalo for current index
            while (j < n) {
                rightMax = Math.max(rightMax, arr[j]);
                j++;
            }
            //donomese jo kam hoga - arr[i] itna pani current index trap kr skta hai
            waterTrapped += Math.min(leftMax, rightMax) - arr[i];
        }
        return waterTrapped;
    }
}

//===================================== better - prefix and suffix arrays =================================

import java.util.*;
class TUF {
    static int trap(int[] arr) {
        int n = arr.length;
        int prefix[] = new int[n];
        int suffix[] = new int[n];
        prefix[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = Math.max(prefix[i - 1], arr[i]);
        }
        suffix[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = Math.max(suffix[i + 1], arr[i]);
        }
        int waterTrapped = 0;
        for (int i = 0; i < n; i++) {
            waterTrapped += Math.min(prefix[i], suffix[i]) - arr[i];
        }
        return waterTrapped;
    }

    public static void main(String args[]) {
        int arr[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("The duplicate element is " + trap(arr));
    }
}

//=========================================== Optimised- two pointers ===========================================

import java.util.*;
class TUF {
    static int trap(int[] height) {
        int n = height.length;
        //take left and right pointer
        int left = 0, right = n - 1;
        int res = 0;//amout of water stored is 0 initially
        
        int maxLeft = 0, maxRight = 0; //leftmax and rightmax is 0 initially
        
        while (left <= right) {
            
            if (height[left] <= height[right]) {//if height of left is lesses than height of right
                
                if (height[left] >= maxLeft) {//then we check if current height is grater than maxleft then uodate maxleft
                    maxLeft = height[left];
                } else { //if height is lesser than I can say it stores water so add in result
                    res += maxLeft - height[left];
                }
                //and move the left pointer by 1
                left++;
                
            } else {//left height is greater than right
                
                if (height[right] >= maxRight) {
                    maxRight = height[right];
                } else {
                    res += maxRight - height[right];
                }
                right--;
            }
        }
        return res;
    }


    public static void main(String args[]) {
        int arr[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("The duplicate element is " + trap(arr));
    }
}
