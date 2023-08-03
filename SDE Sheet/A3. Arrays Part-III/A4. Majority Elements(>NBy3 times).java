Problem Statement: Given an array of N integers. Find the elements that appear more than N/3 times in the array. If no such element exists, return an empty vector.

Example 1:
Input: N = 5, array[] = {1,2,2,3,2}
Ouput: 2
Explanation: Here we can see that the Count(1) = 1, Count(2) = 3 and Count(3) = 1.Therefore, the count of 2 is greater than N/3 times. Hence, 2 is the answer.
Example 2:

Input:  N = 6, array[] = {11,33,33,11,33,11}
Output: 11 33
Explanation: Here we can see that the Count(11) = 3 and Count(33) = 3. Therefore, the count of both 11 and 33 is greater than N/3 times. Hence, 11 and 33 is the answer.
  
Code:

import java.util.*;
public class Main {
  public static ArrayList < Integer > majorityElement(int[] nums) {

    int number1 = -1, number2 = -1, count1 = 0, count2 = 0, len = nums.length;
    //The reason for having variable is because there can be at most two elements that appear more than n/3 times in the array.
   // consider the case where there are more than three elements that appear more than n/3 times. In this scenario, it's not possible for each of those elements to appear strictly more than n/3 times, as that would make the total count of those elements greater than n, which is not possible in a valid array. 
    //  Hence, there can be at most two elements that appear more than n/3 times hence we take two variables.
    
    for (int i = 0; i < len; i++) {
      if (nums[i] == number1)
        count1++;
      else if (nums[i] == number2)
        count2++;
      else if (count1 == 0) {
        number1 = nums[i];
        count1 = 1;
      } else if (count2 == 0) {
        number2 = nums[i];
        count2 = 1;
      } else {
        count1--;
        count2--;
      }
    }
    ArrayList < Integer > ans = new ArrayList < Integer > ();

    // [2,2,1,3] hum donoka count decrease krhe hote hai upar to jo majority element hai uska bhi kam hojata hai isliye jo potential numbers mile hai unko firse count nikalenge aur jo > n/3 hoga unko answer mai dalenge
    count1 = 0;
    count2 = 0;
    for (int i = 0; i < len; i++) {
      if (nums[i] == number1)
        count1++;
      else if (nums[i] == number2)
        count2++;
    } 
    
    if (count1 > len / 3)
      ans.add(number1);
    if (count2 > len / 3)
      ans.add(number2);
    return ans;
  }
  public static void main(String args[]) {
    int arr[] = {1, 2, 2, 3, 2};
    ArrayList < Integer > majority = majorityElement(arr);
    System.out.print("The majority element is: ");
    HashSet < Integer > s = new HashSet < > (majority);
    for (int it: s) {
      System.out.print(it + " ");
    }
    System.out.println();
  }
}
