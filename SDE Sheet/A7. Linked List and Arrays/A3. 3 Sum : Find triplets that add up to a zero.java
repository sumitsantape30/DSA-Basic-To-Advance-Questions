Problem Statement: Given an array of N integers, your task is to find unique triplets that add up to give a sum of zero. In short, you need to return an array of all the unique triplets [arr[a], arr[b], arr[c]] such that i!=j, j!=k, k!=i, and their sum is equal to zero.

Examples:
Example 1: 
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: Out of all possible unique triplets possible, [-1,-1,2] and [-1,0,1] satisfy the condition of summing up to zero with i!=j!=k

Example 2:
Input: nums=[-1,0,1,0]
Output: Output: [[-1,0,1],[-1,1,0]]
Explanation: Out of all possible unique triplets possible, [-1,0,1] and [-1,1,0] satisfy the condition of summing up to zero with i!=j!=k

Code:

//============================== Brute Force- 3 loops =====================
import java.util.*;
class TUF {
    static ArrayList < ArrayList < Integer >> threeSum(int nums[]) {
        ArrayList < ArrayList < Integer >> ans = new ArrayList < > ();

        int i, j, k;
        for (i = 0; i < nums.length - 2; i++) {
            for (j = i + 1; j < nums.length - 1; j++) {
                for (k = j + 1; k < nums.length; k++) {
                    ArrayList < Integer > temp = new ArrayList < > ();
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                    }
                    if (temp.size() != 0)
                        ans.add(temp);
                }
            }
        }

        return ans;
    }

    public static void main(String args[]) {
       int arr[]={-1,0,1,2,-1,-4};
        ArrayList < ArrayList < Integer >> ans;
        ans = threeSum(arr);
        System.out.println("The triplets are as follows: ");
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.println();
        }

    }
}

//===================================== Better - Hashing ========================


//======================================= Optimised - two pointer approach =======================

import java.util.*;
class TUF {
    static ArrayList < ArrayList < Integer >> threeSum(int[] num) {

        Arrays.sort(num);//firstly sort the num array

        ArrayList < ArrayList < Integer >> res = new ArrayList < > ();//creating a list of list so that we can have all the triplets stored

        for (int i = 0; i < num.length - 2; i++) { //this loop moves for our 'a'

            if (i == 0 || (i > 0 && num[i] != num[i - 1])) { // I need to make sure the duplicates are avoided. agar i== 0 nhi hai to dekhunga ki kahi pichle element ke sath same to nhi hai
                
                //we'll keep two pointers lo and hi
                int lo = i + 1, hi = num.length - 1, sum = 0 - num[i];// and I am looking for b+c = -a

                //two pointer run till lo pointer doesnt crosses the hi pointer
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        ArrayList < Integer > temp = new ArrayList < > ();
                        temp.add(num[i]);
                        temp.add(num[lo]);
                        temp.add(num[hi]);
                        res.add(temp);

                        //ignoring all the duplicates, jabtak aage wala element current element ke equal hai pointers ko aage badhate rho
                        while (lo < hi && num[lo] == num[lo + 1]) lo++;
                        while (lo < hi && num[hi] == num[hi - 1]) hi--;
                        
                        //fir ekbar dono pointers ko badhao coz lo abhi sabse last wale duplicate pe hai so ek step aage badhao to non duplicate wale pe ajayega
                        lo++;
                        hi--;
                        //lo and hi will be standing at two different values now
                        
                    } else if (num[lo] + num[hi] < sum) lo++;//if after adding up they are giving the value lesser than -(-a) then move lo ahead

                    else hi--;
                }
            }
        }
        return res;
    }
    public static void main(String args[]) {
       int arr[]={-1,0,1,2,-1,-4};
        ArrayList < ArrayList < Integer >> ans;
        ans = threeSum(arr);
        System.out.println("The triplets are as follows: ");
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
