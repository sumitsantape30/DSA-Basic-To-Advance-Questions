Is A Power Of 4

https://leetcode.com/problems/power-of-four/
Input Format
.
Output Format
.
Question Video

  COMMENTConstraints
.
Sample Input
4
Sample Output
true

Code:

class Solution {
    public boolean isPowerOfFour(int n) {
        int fac = 0b01010101010101010101010101010101; // so total yahapr 32 bits hai 
      return n>0 && (n&(n-1))==0 && (fac&n) > 0;// mai yahase return kardunga ki n grater than 0 hona chahiye(positive number)
    }
}
