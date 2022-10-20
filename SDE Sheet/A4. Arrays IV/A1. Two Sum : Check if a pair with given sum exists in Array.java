Problem Statement: Given an array of integers nums[] and an integer target, return indices of the two numbers such that their sum is equal to the target.

Note: Assume that there is exactly one solution, and you are not allowed to use the same element twice. Example: If target is equal to 6 and num[1] = 3, then nums[1] + nums[1] = target is not a solution.

Example 1:

Input: nums = [2,7,11,15], target = 9

Output: [0,1]

Explanation: Because nums[0] + nums[1] == 9, 
which is the required target, we return 
indexes [0,1]. (0-based indexing)
  
Code:

class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int result[]= new int[2];//2 indexes return krne hai
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for( int i=0; i< nums.length; i++){
            if( map.containsKey(target - nums[i])){
                result[1] = i;
                result[0] = map.get(target - nums[i]);
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }
}
