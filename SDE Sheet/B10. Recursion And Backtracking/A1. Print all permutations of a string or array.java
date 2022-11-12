Problem Statement: Given an array arr of distinct integers, print all permutations of String/Array.

Examples:

Example 1: 

Input: arr = [1, 2, 3]

Output: 
[
  [1, 2, 3],
  [1, 3, 2],
  [2, 1, 3],
  [2, 3, 1],
  [3, 1, 2],
  [3, 2, 1]
]

Explanation: Given an array, return all the possible permutations.
  
Code:

//========================================= Brute Force - Recursion ==============================================
class Solution {

    private void recurPermute(int nums[], List<Integer> ds, List<List<Integer>> ans, boolean freq[]){

        if( ds.size() == nums.length){//agar data structure ki size n ke equal hoti hai means yeh ek mujhe permutation mila hai to ise ans mai add krdo
           ans.add(new ArrayList<>(ds));
           return;
        }

        for(int i=0; i< nums.length; i++){//we iterate from 0 to n and decide to pick an element
          //now i'll check ki kya mai ith index ko as my permutation le skta hai
            if(!freq[i]){//agar yeh false hai means yeh index mere permutation ka part nhi hai to ise le skte hai
            //isko true mark krke ds mai dal denge
              freq[i] = true;
              ds.add(nums[i]);
              recurPermute(nums, ds, ans, freq);
              //wapas aate hue isko ds mese remove krdenge aur false mark karenge
              ds.remove(ds.size()-1);
              freq[i] = false;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();//this will contains all our permutations
        List<Integer> ds = new ArrayList<>();
        boolean freq[]= new boolean[nums.length]; //yeh freq array as a map karega, it will tell ki yeh element iss permutation ka part hai ya nhi hai. this is going to mark which element has been taken
        recurPermute(nums, ds, ans, freq);
        return ans;

    }
}

Output:

All Permutations are
1 2 3
1 3 2
2 1 3
2 3 1
3 1 2
3 2 1

Time Complexity:  N! x N

Space Complexity:  O(N)

//============================================================== Approach 2 - Backtracking =============================================
  
  import java.io.*;
import java.util.*;
class Solution {
    private void recurPermute(int index, int[] nums, List < List < Integer >> ans) {
        if (index == nums.length) { //whenever my index reaches at nums.length then means uss array mai sari swapping vagere hogyi hai aur ek permutation generate hogya hai so iske sare elements ko ds mai dalenge aur fir main answer mai
            // copy the ds to ans
            List < Integer > ds = new ArrayList < > ();
            for (int i = 0; i < nums.length; i++) {
                ds.add(nums[i]);
            }
            ans.add(new ArrayList < > (ds));
            return;
        }
      
        for (int i = index; i < nums.length; i++) {
            swap(i, index, nums);//swapping i with index
            recurPermute(index + 1, nums, ans);
            swap(i, index, nums);//reswap it, backtrack it
        }
    }
    private void swap(int i, int j, int[] nums) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    public List < List < Integer >> permute(int[] nums) {
        List < List < Integer >> ans = new ArrayList < > ();
        recurPermute(0, nums, ans);//calling the recursion with 0th index, passing array and ans that'll store all the permutations
        return ans;
    }
};

class TUF {
    public static void main(String[] args) {
        int nums[] = {1,2,3};
        Solution sol = new Solution();
        List < List < Integer >> ls = sol.permute(nums);
        System.out.println("All Permutations are");
        for (int i = 0; i < ls.size(); i++) {
            for (int j = 0; j < ls.get(i).size(); j++) {
                System.out.print(ls.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
Output:

All Permutations are
1 2 3
1 3 2
2 1 3
2 3 1
3 1 2
3 2 1

Time Complexity:  N! x N

Space Complexity:  O(N)
