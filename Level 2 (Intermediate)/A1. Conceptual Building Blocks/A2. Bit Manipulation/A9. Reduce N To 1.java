Reduce N To 1

1. You are given a positive number N.
2. You have to find the minimum number of operations required to convert N into 1.
3. Operations allowed :
     (i)  If n is even, you have to replace n with n/2.
     (ii) If n is odd, you can replace n with either n-1 or n+1.
Input Format
A number N
Output Format
Check the sample ouput and question video.

  COMMENTConstraints
1 <= N <= 2147483647
Sample Input
8
Sample Output
3

Code:

import java.io.*;
import java.util.*;

public class Main {

    public static int solution(long n) { //boht bada number aya to integer seh nhi payega range ke bahar jayega isliye long lo 
        int res = 0;
        
        while( n != 1){
            
            if( n % 2 == 0){ // n agar even hua to 
              n = n / 2;
                
            }else if(n == 3){ // agar n 3 hua to woh special case hai
              //n = n - 1; // minus karna advantageous hoga
              res = 2; // special case hai to res ko sidha 2 karke break kr skte hai
              break;
                
            }else if((n & 3) == 1){ // n & 3 ==1 hai to 4x+1 nature ka hai. n % 4 == 1 bhi use kr skte ho but tle dega
              n = n - 1; // isme bhi minus karna advantageous hota hai
                
            }else if( (n & 3) == 3){ // n & 3 agar 3 hai to woh 4x+3 nature ka hai to isme addition karna advantageous hota hai
              n = n + 1;
            }
            
            res++; // res ko ++ karenge coz harbar ek step lag rha hai
        }
        return res;
    }
    
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
        System.out.println(solution(n));
    }
	
	
}
