Gray Code

1. The gray code is a binary numeral system where two successive numbers differ in only one bit.
2. Given a non-negative integer n representing the total number of bits in the code, print the 
     sequence of gray code. A gray code sequence must begin with 0.
 
 Example:
 Input: 2
 Output: [0,1,3,2]
 Explanation:
 00 - 0
 01 - 1
 11 - 3
 10 - 2
 [0,2,3,1] is also a valid gray code sequence.
 00 - 0
 10 - 2
 11 - 3
 01 - 1
Input Format
First line contains n(number of digits).
Output Format
Return the list of numbers in any valid order.

Constraints
0<=n<=20
Sample Input
2
Sample Output
[0, 1, 2, 3]


Code:

import java.util.*;
 
 public class Main {
 
     public static ArrayList<String> grayCode(int n) {
         
         if( n == 1){
             // hum isme 2 log banakr arraylist mai add karenge
             ArrayList<String> bres = new ArrayList<>();
             //ekbar 0 aur ekbar 1 add karenge
             bres.add("0");
             bres.add("1");
             return bres;
         }
         
          ArrayList<String> rres= grayCode(n-1); // recursion pe faith hai ki woh n-1 bit ke gray codes lake dega
         
         //my result banayenge
         ArrayList<String> mres= new ArrayList<>();
         
         for( int i=0; i < rres.size(); i++){
             String rstr = rres.get(i);
             mres.add("0" + rstr); // 0 add karenge aur fir rstr lagayenge
         }
         
         //ab mai ulta loop lagaunga
         for( int i= rres.size() - 1; i >= 0; i--){
             String rstr = rres.get(i);
             mres.add("1" + rstr); // ulta lagkr add ho rha hai to inke samne 1 lagega
         }
         
         return mres;
     }
 
     public static void main(String[] args) {
         Scanner scn = new Scanner(System.in);
         ArrayList<String> ans= grayCode(scn.nextInt());
         Collections.sort(ans);
         System.out.println(ans);
     }
 }
