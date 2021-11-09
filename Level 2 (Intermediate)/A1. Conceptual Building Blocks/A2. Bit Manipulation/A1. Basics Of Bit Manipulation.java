Basics Of Bit Manipulation

1. You are given a number n.
2. Print the number produced on setting its i-th bit.
3. Print the number produced on unsetting its j-th bit.
4. Print the number produced on toggling its k-th bit.
5. Also, Check if its m-th bit is on or off. Print 'true' if it is on, otherwise print 'false'.
Input Format
A number
Four numbers i,j,k,m.
Output Format
Check the sample ouput and question video.

 Constraints
1 <= n <= 10^9
1 <= i <= 9
1 <= j <= 9
1 <= k <= 9
1 <= m <= 9
Sample Input
57
3 
3 
3 
3
Sample Output
57
49
49
true

COde:
import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int i = scn.nextInt();
    int j = scn.nextInt();
    int k = scn.nextInt();
    int m = scn.nextInt();
    
    int onmask= (1 << i); // on karne ka mask, its actually 00000001, muje yaha n ki ith bit on karni hai. inki precedence = se kam hoti hai so brackets lagaye
    int offmask= ~(1 << j); // muje jth bit off karni hai to fir 1 goes to goes to j fir mai uska 1's compliment lunga
    
    // toggling keliye regular mask chahiye hota hai
    int tmask= (1 << k); // toggle mask
    int cmask= (1 << m); // check 
    
    System.out.println(n | onmask); // bit on karnekeliye onmask use hota hai aur or operator use hota hai 
    System.out.println(n & offmask);
    System.out.println(n ^ tmask);
    System.out.println((n & cmask) == 0 ? false: true); // pehle check mask ke sath & kiya agar woh 0 bangya to woh bit off thi. agar 0 nhi bana to woh bit on thi
  }

}
