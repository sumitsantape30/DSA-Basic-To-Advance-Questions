Count and Say - Description of this problem on Leetcode is shit so refer gfg one

The count-and-say sequence is a sequence of digit strings defined by the recursive formula:

countAndSay(1) = "1"
countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
To determine how you "say" a digit string, split it into the minimal number of substrings such that each substring contains exactly one unique digit. Then for each substring, say the number of digits, then say the digit. Finally, concatenate every said digit.

For example, the saying and conversion for digit string "3322251":


Given a positive integer n, return the nth term of the count-and-say sequence.

 

Example 1:

Input: n = 1
Output: "1"
Explanation: This is the base case.
Example 2:

Input: n = 4
Output: "1211"
Explanation:
countAndSay(1) = "1"
countAndSay(2) = say "1" = one 1 = "11"
countAndSay(3) = say "11" = two 1's = "21"
countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"
 

Constraints:

1 <= n <= 30
  
Code:

class Solution {
    public String countAndSay(int n) {//uss sequence ki nth value print krni hai
        if( n == 1){
            return "1";
        }else if( n == 2){
            return "11";
        }

        String s = "11"; //string mai initially 11 leliye
        
        for( int i= 3; i<= n; i++){//hume nth ka data chahiye so 3 se leke n tak loop chalayenge
            String t= ""; //iss string mai next iteration ka answer ayega
            s = s + '&'; //yeh '&' kyu lagaya iska description niche hai
            int count = 1; //count ko 1 set kiya coz sabke ek to element hogahi hoga

            for( int j= 1; j < s.length(); j++){

                if(s.charAt(j) != s.charAt(j-1)){ //agar woh piche wale se barbar nhi hai means kuch new data aya hai
                  t = t + count ; //pichle wale ka count dal dennge
                  t = t + s.charAt(j-1); //pichle character add karenge
                  count = 1; //aur count ko 1 set karenge

                }else{
                    count++;
                }
            }
            s = t; //aage wala answer t mai store hochuka hai to usko simply s mai dal denge. tak is s ki helpr se next ith ki value nikal paye
        }//n khatam hota hai means humare nth term ka answer s mai hai so return it
        return s;
    }
}

/* not necessary & hi dalo, kuch bhi laga skte ho
Suppose example "1211".
Here you can not count the last '1'.

But you can in this example "1211$".
if(s[j]==s[j-1]){
      cnt++;
}
to count the last one you've to include an ending character. */
