Problem Statement: You are given an array of ‘N’ integers. You need to find the length of the longest sequence which contains the consecutive elements.

Examples:

Example 1:

Input: [100, 200, 1, 3, 2, 4]
Output: 4
Explanation: The longest consecutive subsequence is 1, 2, 3, and 4.

Input: [3, 8, 5, 7, 6]
Output: 4
Explanation: The longest consecutive subsequence is 5, 6, 7, and 8.


Code:

//============================================= Brute Force==================================================
import java.util.*;
class TUF{
public static int longestConsecutive(int[] nums) {
        if(nums.length == 0 || nums == null){
            return 0;
        }
        
        Arrays.sort(nums);
        
        int ans = 1;
        int prev = nums[0];
        int cur = 1;
        
        for(int i = 1;i < nums.length;i++){
            if(nums[i] == prev+1){
                cur++;
            }
            else if(nums[i] != prev){ //bina condition ke bhi you can set cur to 1
                cur = 1;
            }
            prev = nums[i];
            ans = Math.max(ans, cur);
        }
        return ans;
    }
    public static void main(String args[])
    {
        int arr[]={100,200,1,2,3,4};
        int lon=longestConsecutive(arr);
        System.out.println("The longest consecutive sequence is "+lon);
        
    }
}

//========================================================= Optimised ===================================

import java.util.*;
class TUF {
    public static int longestConsecutive(int[] nums) {
        Set < Integer > hashSet = new HashSet < Integer > ();
        for (int num: nums) {
            hashSet.add(num);
        }

        int longestStreak = 0;

        for (int num: nums) {
            if (!hashSet.contains(num - 1)) { //agar hashset mai piche wala number nhi hai to hi yeh operation karenge aur agar piche wala number hai present to kuch nhi karenge
                int currentNum = num; //iske piche wala number nhi hai means yahase ek new shuruwat ho skti hai
                int currentStreak = 1;

                while (hashSet.contains(currentNum + 1)) { //jabtak aage wala number exsit krta hai aagr badhte rahenge
                    currentNum += 1;
                    currentStreak += 1;
                }
                
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
    public static void main(String args[]) {
        int arr[]={100,200,1,2,3,4};
        int lon = longestConsecutive(arr);
        System.out.println("The longest consecutive sequence is " + lon);

    }
}
