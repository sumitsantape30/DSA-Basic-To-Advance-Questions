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

====================================SS's==================================================
	
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

==========================================JB's-1====================
import java.io.*;
import java.util.*;

public class Main {

    public static int solution(int n) { //boht bada number aya to integer seh nhi kr payega range ke bahar jayega isliye long lo. kyuki input number ki range 2147483647 tak joki integer ka end hai so long mai convert karo isko
        int count = 0; // minimum number of operations 0 lo pehle 
        long m = (long)n ; // n ko long mai convert krlo
        
        while( m != 1){ // jabtak yeh number 1 nhi hojata tabtak kam karenge
            
            if( m % 2 == 0){ // n agar even hua to to simply number ko 2 se divide krdo
              m = m / 2;
              count++;
                
            }else if(m == 3){ // agar n 3 hua to woh special case hai, 3 ko reduce karne mai 2 hi step lagte hai 
              count += 2; // special case hai to res ko sidha 2 karke break kr skte hai
              m = 1 ; // 2 step lagenge aur m 1 ban jayega
                
            }//agar n odd hai to aap n-1 sebhi replace kr skte ho or n+1 se bhi replace kr skte ho 
            else if((m & 3) == 1){ // n & 3 ==1 hai to 4x+1 nature ka hai. n % 4 == 1 bhi use kr skte ho but tle dega
              m -= 1; // isme bhi minus karna advantageous hota hai
              count++;
              
            }else if( (m & 3) == 3){ // n & 3 agar 3 hai to woh 4x+3 nature ka hai to isme addition karna advantageous hota hai
              m += 1;
              count++;
            }
            
        }
        return count;
    }
    
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
        System.out.println(solution(n));
    }

}

============================================================JB's 2===================================
	import java.io.*;
import java.util.*;

public class Main {

    public static int solution(int n) { 
        int count = 0;  
        long m = (long)n ; 
        
        while( m != 1){
            
            if( m % 2 == 0){ 
              m = m / 2;
              count++;
                
            }else{
               if(m == 3){ 
                 count += 2; 
                 m = 1 ; 
                
               }else{
                count++;
                if(m % 4 == 1){ 
                   m -= 1; 
                }else{ 
                   m += 1;
                }
              }
           }
        }
        return count;
    }
    
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
        System.out.println(solution(n));
    }

}

==============================================================JB's 3=======================================================
	
