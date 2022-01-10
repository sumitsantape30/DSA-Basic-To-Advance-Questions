Maximum Non-overlapping Bridges

1. You are given a number n, representing the number of bridges on a river.
2. You are given n pair of numbers, representing the north bank and south bank co-ordinates of each bridge.
3. You are required to print the count of maximum number of non-overlapping bridges.
Input Format
A number n
.. n pair of number each on a separate line (and pair separated by space)
Output Format
A number representing the count of maximum number of non-overlapping bridges.

Constraints
0 <= n <= 20
0 <= n1n, n1s, n2n, n2s, .. <= 100
Sample Input
10
10 20
2 7
8 15
17 3
21 40
50 4
41 57
60 80
80 90
1 30
Sample Output
7

Code:

import java.io.*;
import java.util.*;

public class Main {
    
    public static class Bridge implements Comparable<Bridge>{ //2. ek class lenge usme hoga north bank aur south bank aur kyuki mai isko sort karna chahta hu to muje comparable interace implement karna hoga taki Arrays.sort yeh decide kr ske ki kon chota aur kon bada 
        int n;
        int s;
        
        public Bridge(int n, int s){
            this.n = n;
            this.s = s;
        }
        
        public int compareTo(Bridge o){
           // return this.n - o.n; //isse north ke basis pe sorting hojayegi
           
          if( this.n != o.n){ //agar north equal nhi hai to north ke basis pe sorting hojaye
              return this.n - o.n;
              //north equal nhi hai to chote north wala pehle ayega bade north wala badme
          }else{
              //agar 2 aisi values ajaye jiska north equal hai to unme chote south wala pehle ajayega. bade south wala badme
              return this.s - o.s;
          }
        }
    }

    public static void main(String[] args) throws Exception {
        
        Scanner scn = new Scanner(System.in);
        //hume dono input string form mai lena hoga coz bridges ke dono end bhi input lene hai to string mai hi dono input le skte hai 
        int n = Integer.parseInt(scn.nextLine()); //1. kitne bridges hai, string ko input liya usko integer mai convert kiya
        
        //3. bridges ka array
        Bridge bdgs[]= new Bridge[n]; // n size ka bridge array banaya
        
        for( int i=0; i< n; i++){
            String line = scn.nextLine(); //nextLine lete hai to ek bridge ke dono numbers input ajate hai
            String parts[] = line.split(" "); //space ki basis pe split kardliya
            int nr = Integer.parseInt(parts[0]); // north
            int s = Integer.parseInt(parts[1]); //south
            
            //muje north south milgya ab mai bdgs[i] banane mai saksham mehsus kr rha hu
            bdgs[i] = new Bridge(nr, s);
        }
        
        Arrays.sort(bdgs); // maine pehlehi comparable laga rakha hai north ke basis pr to mai Arrays.sort ko bolunga ki mere brdiges ke array ko sort karde to woh compareTo function ko call karega har pair keliye aur pta karlega kon chota kon bada 
        //so ab north pe yeh sort ho chuka hai 
        
        //ab south pe LIS nikalna hai
        int dp[] = new int[n];
        int omax =0;
        for( int i=0; i< dp.length; i++){
            int max = 0;
            
            for( int j=0; j< i; j++){
                if(bdgs[j].s <= bdgs[i].s){ // bdgs[j].s yeh bta btati hai ki hum south ke basis pe LIS laga rhe hai 
                    
                    if( dp[j] > max){
                        max = dp[j];
                    }
                }
            }
            dp[i] = max + 1; //uparse jo max aya tha usme +1 krke dp[i] mai dal de
            
            if( dp[i] > omax){ //agar apka dp[i] overall max se bada hojaye  to overall max ko update krde
              omax = dp[i];
            }
        }
       
        System.out.println(omax);
    }
}
