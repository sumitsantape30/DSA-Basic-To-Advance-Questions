2 Key Keyboard

1. You are given a number N.
2. You have to print exactly N number of 'X' on a notepad by performing the minimum number of operations.
3. Operations allowed are - 
   copyAll -> You can copy all the characters present on the notepad.
   Paste -> You can paste the last copied characters.
4. You have to find the minimum number of operations to get N 'X'.

Note -> Initially, one 'X' is present on the screen.
Input Format
A number
Output Format
Check the sample output and question video.

 COMMENTConstraints
1 <= N <= 1000
Sample Input
3
Sample Output
3

Code:
import java.io.*;
import java.util.*;

public class Main {

	public static int solution(int n) {
		int ans = 0;

		for(int div = 2; div*div <= n; div++){

			while( n % div == 0){ //jabtak number divisor se divide hota hai tabtak use divide krte rho aur answer mai uss divisor kobhi add krte rho
			  ans += div;
			  n = n / 10;
			}
		}	

		//root n se bada prime factor ek hi ho skta hai so n 1 mai reduce nhi hua hai to answer mai usko bhi add krdo
		if( n != 1){
			ans += n;
		}
		return ans;	
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println(solution(n));
	}

}
