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

//------------------------------------------------SS's (Isme Arraylist ke return type String hai----------------------------------------------
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

//========================================================JB's (isme ArrayList ke return type Integer hai) ====================================================

import java.util.*;
 
 public class Main {
 
     public static List<Integer> grayCode(int n) {
         List<Integer> ans = new ArrayList<Integer>(); //jaise hum likhte the queue = ArrayDeque waisehi yahape list ek interface hai, so yaha woh list ArrayList hai woh linkedlist etc bhi ho skti hai

         fun(n, ans); // yeh funtion iss arraylist ko bharke de dega aur hum return krdenge
         return ans;

     }

     public static void fun(int n, List<Integer> ans){
         //aise call krte krte basecase hit hoga, jab hum 0 pe pohoch jayenge
         if( n == 0){
             ans.add(0); // answer mai add karenge 0 aur return krdenge
             return;
         }

         fun(n-1, ans);
         //ab wapis aate hue jawab banana hai 
         //0 ka jawab aagya hai list mai hume ab 1 ka jawab banana hai
         //jitne elements hai unke upar ulta loop chalana hoga aur unn elements ko one by one OR krte hue add krdo
         for( int i = ans.size()-1; i>=0; i--){
             //ek ek element uthao aur bitmask ke sath uska OR karo aur answer mai simply add karo
             ans.add(ans.get(i) | (1<<(n-1)));
         }

     }
 
     public static void main(String[] args) {
         Scanner scn = new Scanner(System.in);
         List<Integer> ans=grayCode(scn.nextInt());
         Collections.sort(ans);
         System.out.println(ans);
     }
 }
