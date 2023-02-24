Given a string s, find the length of the longest 
substring
 without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
  
Code:

//=================================== Brute Force ==================================

import java.util.*;
public class Main {
    static int solve(String str) {

        if(str.length()==0)
             return 0;
        int maxans = Integer.MIN_VALUE;
        for (int i = 0; i < str.length(); i++) // outer loop for traversing the string
        {
            Set < Character > se = new HashSet < > ();
            for (int j = i; j < str.length(); j++) // nested loop for getting different string starting with str[i]
            {
                if (se.contains(str.charAt(j))) // if element if found so mark it as ans and break from the loop
                {
                    maxans = Math.max(maxans, j - i);
                    break;
                }
                se.add(str.charAt(j));
            }
        }
        return maxans;
    }

    public static void main(String args[]) {
        String str = "takeUforward";
        System.out.println("The length of the longest substring without repeating 
        characters is " + solve(str));

    }
}
                           
//======================================== Better =========================================================
import java.util.*;
public class Main {
    static int solve(String str) {

        if(str.length()==0)
             return 0;
        int maxans = Integer.MIN_VALUE;
        Set < Character > set = new HashSet < > ();
        int l = 0;
        for (int r = 0; r < str.length(); r++) // outer loop for traversing the string
        {
            if (set.contains(str.charAt(r))) //if duplicate element is found. duplicate element hai iss range mai to l ko aage badhao, then jo new range hogi usme repeating character nhi hoga
            {
                while (l < r && set.contains(str.charAt(r))) {  //jabtak yeh r present hai set mai means duplicate hai to l ko remove krte rahenge aur l ko aage badhate rahenge
                    set.remove(str.charAt(l));
                    l++;
                }
            }
         //agar r exist nhi krta set mai means l-r ek range hai jisme character repeat nhi hai to iss character ko set mai daldo aur length update karo
            set.add(str.charAt(r));
            maxans = Math.max(maxans, r - l + 1);
        }
        return maxans;
    }

    public static void main(String args[]) {
        String str = "takeUforward";
        System.out.println("The length of the longest substring without repeating 
        characters is " + solve(str));

    }
}
                           
//=================================== Optimal ============================================== 
import java.util.*;
public class Main {
    static int solve(String s) {
        HashMap < Character, Integer > mpp = new HashMap < Character, Integer > ();
        
        //left right pointer rakhoo
        int left = 0, right = 0;
        int n = s.length();
        int len = 0;
        while (right < n) {
            if (mpp.containsKey(s.charAt(right))) // we check if our map contains the character at index right, if it contains I'm going to update my left if that's in the range [l-r] 
               left = Math.max(mpp.get(s.charAt(right)) + 1, left);//so I am doing comparison of left and whatever character I have seen at last + 1

            mpp.put(s.charAt(right), right);// here I update the last seen

            len = Math.max(len, right - left + 1);// then I compute the length
            right++;// then I'll move right pointer by one
        }
        return len;
    }

    public static void main(String args[]) {
        String str = "takeUforward";
        System.out.println("The length of the longest substring without repeating 
        characters is " + solve(str));

    }
}
                           
