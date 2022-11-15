Problem Statement: Given a sorted array of N integers, where every element except one appears exactly twice and one element appears only once. Search Single Element in a sorted array.

Example 1:

Input: N = 9, array[] = {1,1,2,3,3,4,4,8,8} 

Output: 2

Explanation: Every element in this sorted array except 2 
appears twice, therefore the answer returned will be 2.
  
Code:

//================================================= Brute Force ==================================================
import java.util.*;
class TUF {
    public static int findSingleElement(int nums[]) {
            int n = nums.length;
            int elem = 0;
            for (int i = 0; i < n; i++) {
                elem = elem ^ nums[i];
        }
        
        return elem;
    }

    public static void main(String args[]) {

        int arr[] = {1,1,2,3,3,4,4,8,8};
        
        int elem = findSingleElement(arr);
        System.out.println("The single occurring"
         +" element is " + elem);

    }
}
Output: 

The single occurring element is 2

Time Complexity: O(N)

Space Complexity: O(1)
  
//============================================== Optimised- Binary Search ===================================================
  
  import java.util.*;
class TUF {
    static int findSingleElement(int nums[]) {
        
      //initialising lo to 0 and hi to second last index
        int low = 0;
        int high = nums.length - 2;
        
        while (low <= high) {
            int mid = (low + high) / 2;
          
            if (mid % 2 == 0) {
                // Checking whether we are in right half
                if (nums[mid] != nums[mid + 1]) 
                    //Shrinking the right half
                    high = mid - 1; 
                else
                    // Shrinking the left half
                    low = mid + 1; 
            } else {
                // Checking whether we are in right half
                if (nums[mid] == nums[mid + 1])
                    //Shrinking the right half
                    high = mid - 1; 
                else
                    // Shrinking the left half
                    low = mid + 1; 
            }
        }
        return nums[low];
    }
  
  //inorder to check for the left half
  //1st instance - even index
  // 2nd instance - odd index, i need to check on the left if the 1st instance of that number is there or not

    public static void main(String args[]) {

        int arr[] = {1,1,2,3,3,4,4,8,8};
        
        int elem = findSingleElement(arr);
        
        System.out.println("The single occurring" + 
         " element is " + elem);

    }
}

Output: 

The single occurring element is 2

Time Complexity: O(log(N))

Space Complexity: O(1)
