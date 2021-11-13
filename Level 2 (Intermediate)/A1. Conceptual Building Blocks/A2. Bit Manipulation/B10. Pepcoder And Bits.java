Pepcoder And Bits

1. Pepcoder is feeling confident after solving many problems on Bit Manipulation.
2. So, his teacher ask him to find out the count of positive integers strictly less than N, having same 
     number of set bits as that of N.
3. Let us see that if pepcoder can solve it or not.
Input Format
A number N
Output Format
Check the sample ouput and question video.

Constraints
1 <= N <= 10^12
Sample Input
1024
Sample Output
10

Code:

//===========================================SS's============================

import java.io.*;
import java.util.*;

public class Main {
    public static long ncr(long n, long r){
        if(n < r){
            return 0L;    
        }
        
        long res = 1L;
        
        for(long i = 0L; i < r; i++){ //factorial se karenge to tle ayega 
            res = res * (n - i);
            res = res / (i + 1);
        }
        
        return res;
    }
    
    public static long solution(long n, int k, int i) {
        if( i == 0){ //i chalte chalte 0 pr aagya hai means akhri bit aagyi hai to hum kardenge return 0
          return 0;
        }
        
      // ab mai ith bit ko analyse karne wala hu
      long mask = 1L << i;
      
      long res=0;
      
      //ab mai check karunga yeh bit on hai ya nhi
      if((n & mask) == 0){ // agar yeh 0 aya to woh bit off hai 
          res = solution(n, k, i-1);//agar bit off hai to ek hi option hai aage chaliye
          //i-1 means, aagr humne pehle pass kiya tha 8 bit onwards to bolega 7 bits onwards btado
          
      }else{ // agar woh bit on hai
          //to apne pas 2 options hai ki isko 1 ki tarah hi rakhlo, agar total set bits 4 thi to bache hue number mai 3 set bits wale number dhundke laao.
          long res1 = solution(n, k - 1, i -1);
          // agar uss bit ko 0 rakhlu 
          long res0 = ncr(i , k);
          res = res1 + res0;
      }
      
      return res;
    }
    
    //csb: count set bits
    public static int csb(long n){
        int res = 0;
        
        while(n > 0){
            long rsb = n & -n;
            n -= rsb;
            res++;
        }
        
        return res;
    }
    
   public static void main(String[] args) {
	Scanner scn = new Scanner(System.in);
        long n = scn.nextLong();
        // n input le rhe, humko iske andar number of set bits chahiye, coz ncr karne keliye number of set bits chahiye so karnighan algorithm ke thorugh no of set bits nikalenge 
        
        int k = csb(n);// so humne yeh count of set bits mangayi
        System.out.println(solution(n, k, 63)); // solution ke andar humne n pass kiya hai count of set bits pass kiya hai, aur sathme 63. long mai 64 bits hoti hai 0 to 63 means sara long consider hoga
    }
	
}

//================================================ JB's=============================================
import java.io.*;
import java.util.*;

public class Main {
    public static long ncr(long n, long r){
        if(n < r){
            return 0L;    
        }
        
        long res = 1L;
        
        for(long i = 0L; i < r; i++){ //factorial se karenge to tle ayega 
            res = res * (n - i);
            res = res / (i + 1);
        }
        
        return res;
    }
    
    public static long solution(long n) {
       int count= csb(n); // pehle set bits ka count nikal lo, ki n ke andar kitni set bits hai
       
       long ans= 0; // apna ans 0 se initialise kardiya
       
       //right ke taraf se loop lagayenge
       for( int i= 62; i>=0; i--){ // 62 se start hoga, highest number hota hai 2^63-1. agar 63 se loop chalaye to 2^63 loop ke bahar jayega. 40 sebhi loop chala skte ho
           // check if the ith bit is on or off uske liye mask chahiye hoga
           long mask = (long)Math.pow(2, i); // yeh 1 >> i hi hai jisko hum mask bolte hai. hune bas long mai banaya
           
        // agar ith bit on hoti hai
        if((n & mask) != 0 && count > 0){ // count bhi negative nhi hona chahiye
            // agar woh bit on hoti hai to mai answer mai 
            ans += ncr(i, count); // i mese count jitne select karenge
            count--;
        }
      }
       
      return ans;
      
    }
    
    //csb: count set bits
    public static int csb(long n){
        int res = 0;
        
        while(n > 0){
            long rsb = n & -n;
            n -= rsb;
            res++;
        }
        
        return res;
    }
    
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        long n = scn.nextLong(); // long number input liya hai to 64 bit ka number hoga means 0 to 63
        // n input le rhe, humko iske andar number of set bits chahiye, coz ncr karne keliye number of set bits chahiye so karnighan algorithm ke thorugh no of set bits nikalenge 
        
        System.out.println(solution(n)); 
    }
	
	
}

// loop 40 se start kiya to kyu chalega? contrainst de rakha hai ki N ki max value 10^12 ho skti hai fir yeh assumption lagaya ki 2^10 hota hai 1024 means this is nearly equal to 10^3, 2^10 ~= 10^3.
// so agar mai 10 ki power 12 banane keliye 10^3 ko power 4 se multiply karna padega to 2^10 kobhi 4 multiply karna padega, (2^10)^4 ~= (10^3)^4 => 2^40 ~= 10^12 isliye(2^40) loop 40 start kiya to chalta

