Problem Statement: Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target. Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

Examples:

Example 1:
Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]]

Explanation: These are the unique combinations whose sum is equal to target.
  
Code:

//==================================== Optimised =======================================
import java.util.*;
class TUF {
    static void findCombinations(int ind, int[] arr, int target, List < List < Integer >> ans, List < Integer > ds) {
        if (target == 0) { //target 0 hogya matlab ek valid combination milgya to we'll add that in answer. array khatam hone ke pehle bhi hume combination mil skta hai so no need to i== arr.length
            ans.add(new ArrayList < > (ds));
            return;
        }

        for (int i = ind; i < arr.length; i++) {
          //we try to check if this guy can be pickep up as the next element of your combination
          
            if (i > ind && arr[i] == arr[i - 1]) continue;//if its a repeated element i'll not pick it up
            if (arr[i] > target) break; //is so we'll break the loop

          //yahatk pohoch means this can be part of our combination so isko ds mai add karo aur next element keliye call lagao.
            ds.add(arr[i]);
            findCombinations(i + 1, arr, target - arr[i], ans, ds);
            ds.remove(ds.size() - 1);//wapas aate hue return karege
        }
    }
    public static List < List < Integer >> combinationSum2(int[] candidates, int target) {
        List < List < Integer >> ans = new ArrayList < > ();//this will be our final answer
        Arrays.sort(candidates);//we'll sort the given array as we need sorted combinations
        findCombinations(0, candidates, target, ans, new ArrayList < > ());
        return ans;
    }

    public static void main(String args[]) {
        int v[]={10,1,2,7,6,1,5};
        List < List < Integer >> comb = combinationSum2(v, 8);
        System.out.println(comb.toString().replace(",", " "));
    }
}
Output:

[ [ 1 1 6 ][ 1 2 5 ][ 1 7 ][ 2 6 ] ]

Time Complexity:O(2^n*k)

Reason: Assume if all the elements in the array are unique then the no. of subsequence you will get will be O(2^n). we also add the ds to our ans when we reach the base case that will take “k”//average space for the ds.

Space Complexity:O(k*x)

Reason: if we have x combinations then space will be x*k where k is the average length of the combination.
