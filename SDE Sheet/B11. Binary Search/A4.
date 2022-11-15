Problem Statement: There is an integer array nums sorted in ascending order (with distinct values). Given the array nums after the possible clockwise rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums. We need to search a given element in a rotated sorted array.

Example 1:
Input: nums = [4,5,6,7,0,1,2,3], target = 0

Output: 4
Explanation: Here, the target is 0. We can see that 0 is present in the given rotated sorted array, nums. Thus, we get output as 4, which is the index at which 0 is present in the array.

Code:

import java.util.*;
public class Main {
    static int search(int arr[], int target) {
        int low = 0, high = arr.length - 1; //<---step 1

        while (low <= high) { //<--- step 2
            int mid = (low + high) >> 1; //<----step 3
            
            //agar mid target ke equal hai to yahi answer hai
            if (arr[mid] == target)
                return mid; // <---step 4

            //agar upar wali condition false hai to ab yaha aye. agar lo mid se chota hai means left half sorted hai
            if (arr[low] <= arr[mid]) { //<---step 5
                if (arr[low] <= target && arr[mid] >= target) //agar mera target lo aur mid ke bichme hai to mai high ko update krdunge
                    high = mid - 1; //<---step 6 
                else //agar mera target lo to mid ke range mai nhi hai to low ko update kardenge
                    low = mid + 1; //<---step 7
            } else { //<---step 7 //agar left half sorted nhi hai 
                if (arr[mid] <= target && target <= arr[high]) //to hum check krte hai humara target mid to high ki range mai means right half mai exist krta hai ya nhi
                    low = mid + 1; //agar right half mai exist krta hai to lo ko update krdo
                else //agar right half mai nhi hai to high ko update krdo
                    high = mid - 1;
            }
        }
        return -1; //<---step 8
    }
    public static void main(String args[]) {
        int arr[] = {4,5,6,7,0,1,2,3};
        int target = 3;
        System.out.println("The index in which the number is present is " + search(arr, target));
    }
}

Output: The index in which the target is present is 7

Time Complexity: O(log(N))

Reason: We are performing a binary search, this turns time complexity to O(log(N)) where N is the size of the array.

Space Complexity: O(1)

Reason: We do not use any extra data structure, this turns space complexity to O(1).
