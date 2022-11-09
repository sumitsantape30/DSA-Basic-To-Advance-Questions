Given an integer array nums that may contain duplicates, return all possible 
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

Code:

//====================================================== Brute Force - pick and not pick. This takes extra steps for removing deplicates =========================================
import java.util.*;
class TUF {
    static void printAns(List < String > ans) {
        System.out.println("The unique subsets are ");
        System.out.println(ans.toString().replace(",", " "));
    }
    public static void fun(int[] nums, int index, List < Integer > ds, HashSet < String > res) {
        if (index == nums.length) {
            Collections.sort(ds);
            res.add(ds.toString());
            return;
        }
        ds.add(nums[index]);
        fun(nums, index + 1, ds, res);
        ds.remove(ds.size() - 1);
        fun(nums, index + 1, ds, res);
    }
    public static List < String > subsetsWithDup(int[] nums) {
        List < String > ans = new ArrayList < > ();
        HashSet < String > res = new HashSet < > ();
        List < Integer > ds = new ArrayList < > ();
        fun(nums, 0, ds, res);
        for (String it: res) {
            ans.add(it);
        }
        return ans;
    }

    public static void main(String args[]) {
        int nums[]={1,2,2};
        List < String > ans = subsetsWithDup(nums);
        printAns(ans);

    }

}
Output:

The unique subsets are
[ [ ][ 1 ][ 1 2 ][ 1 2 2 ][ 2 ][ 2 2 ] ]

Time Complexity: O( 2^n *(k log (x) )). 2^n  for generating every subset and k* log( x)  to insert every combination of average length k in a set of size x. After this, we have to convert the set of combinations back into a list of list /vector of vectors which takes more time.

Space Complexity:  O(2^n * k) to store every subset of average length k. Since we are initially using a set to store the answer another O(2^n *k) is also used.
 
 
//======================================================== Optimised Approach ============================================
 
 import java.util.*;
class TUF{
static void printAns(List <List<Integer>>  ans) {
    System.out.println("The unique subsets are ");
    System.out.println(ans.toString().replace(","," "));
}
 public static void findSubsets(int ind, int[] nums, List<Integer> ds, List<List<Integer>> ansList) { 
        ansList.add(new ArrayList<>(ds)); //sabse pehle empty list ayegi usme empty element bhi subset hai to usko bhi final answer mai add krhe
  
        for(int i = ind; i<nums.length; i++) {
         
            if(i!=ind && nums[i] == nums[i-1]) continue; //duplicate avoid krne keliye 
         
            //if you cross this if statement that means you can take the current element
            ds.add(nums[i]); 
            findSubsets(i+1, nums, ds, ansList); 
            ds.remove(ds.size() - 1); //please remove the element while coming back from recursion. because for next recursion call those elements should not be there
        }
    }
 
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); //sort the nums array, inorder to have all these duplicates side by side we need to sort it
        List<List<Integer>> ansList = new ArrayList<>(); //this is our answer which is going to store all the list ( our all elements of one subset will be in one list)
        findSubsets(0, nums, new ArrayList<>(), ansList); 
        return ansList; 
    }

public static void main(String args[]) {
   int nums[]={1,2,2};
   
   List < List<Integer>> ans = subsetsWithDup(nums);
   printAns(ans);
   
}
  
}
