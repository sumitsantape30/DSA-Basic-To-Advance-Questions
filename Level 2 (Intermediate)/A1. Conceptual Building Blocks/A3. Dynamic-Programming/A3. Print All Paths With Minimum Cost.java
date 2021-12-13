Print All Paths With Minimum Cost

1. You are given a number n, representing the number of rows.
2. You are given a number m, representing the number of columns.
3. You are given n*m numbers, representing elements of 2d array a, which represents a maze.
4. You are standing in top-left cell and are required to move to bottom-right cell.
5. You are allowed to move 1 cell right (h move) or 1 cell down (v move) in 1 motion.
6. Each cell has a value that will have to be paid to enter that cell (even for the top-left and bottom-right cell).
7. You are required to traverse through the matrix and print the cost of the path which is least costly.
8. Also, you have to print all the paths with minimum cost.
Input Format
A number n
A number m
e11
e12..
e21
e22..
.. n * m number of elements
Output Format
Check the sample output and question video.

Constraints
1 <= n <= 10^2
1 <= m <= 10^2
0 <= e1, e2, .. n * m elements <= 1000
Sample Input
6
6
0 1 4 2 8 2
4 3 6 5 0 4
1 2 4 1 4 6
2 0 7 3 2 2
3 1 5 9 2 4
2 7 0 8 5 1
Sample Output
23
HVVHHVHVHV
HVVHHVHHVV

Code:

import java.io.*;
import java.util.*;

public class Main {

   private static class Pair {
      String psf;
      int i;
      int j;

      public Pair(String psf, int i, int j) {
         this.psf = psf;
         this.i = i;
         this.j = j;
      }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int m = Integer.parseInt(br.readLine());
      int[][] arr = new int[n][m];

      for (int i = 0; i < n; i++) {
         String str = br.readLine();
         for (int j = 0; j < m; j++) {
            arr[i][j] = Integer.parseInt(str.split(" ")[j]);
         }
      }
        
      int dp[][] = new int[arr.length][arr[0].length];
      
      //choti problem se badi ke taraf loop chaayenge
      for( int i= dp.length - 1; i >= 0; i--){
          for( int j= dp[0].length - 1; j >= 0; j--){
              if( i == dp.length - 1 && j == dp[0].length - 1 ){ //last cell hai kya
                dp[i][j] = arr[i][j];// aakhri cell se kahi ja nhi skte jaha hai wahipe rahenge
                  
              }else if( i == dp.length - 1){ //agar last row hai to ek hi option hai vertically ja skte hai
                dp[i][j] = arr[i][j] + dp[i][j + 1];
                  
              }else if( j == dp[0].length - 1){ //akhri column hai to ek hi option hai ki horizontally ja skte hai
                dp[i][j] = arr[i][j] + dp[i + 1][j];
                  
              }else{ //agar bichka area hai to unke pas 2-2 options hoti hai
                //dono options mese jo minimum hoga uske taraf ja skte hai, agar value same hi hai to dono taraf jane ki jaurat nhi hai coz hume 0,0 pe jana hai iss psrt mai sare paths nhi chahiye bas 0,0 pe pohochna hai. 0,0 se reverse engineering krte waqt hume sare paths chahiye
                dp[i][j] = arr[i][j] + Math.min(dp[i][j + 1], dp[i + 1][j]);
              }
          }
      }//so abhi dp bhar gyi hai to min cost print kardenge
      
      System.out.println(dp[0][0]);
      
      //ab hume bfs ka algorithm lagana hai jisse humara answer banega
      ArrayDeque<Pair> queue = new ArrayDeque<>(); //pairs ki queue banayi
      queue.add( new Pair("", 0, 0) ); //queue mai maine new pair add kari usme hai i,j aur psf. shuruwat mai psf hai emtpy, aur reverse engineering kr rhe hai to pura dp bharke hum (0,0) pe honge to i,j is 0,0
      
      //ab woh niklega aur uske neighbours dalenge
      while(queue.size() > 0){ //jabtak queue ka size grater than 0 hai tabtak kam karenge
      
        Pair rem = queue.removeFirst(); //sabse pehle remove kiya pehlewala
        
        //pair aaya apne pas ab dekhenge kya yeh already pohoch gya kya destination pe
        
        //ab yahase bhi 4 case banenge
        
        if(rem.i == dp.length - 1 && rem.j == dp[0].length - 1){ //rem pair ka jo i hai kya woh dp.length-1 aur rem ka j dp[0].length-1 pe hai matlab destination pe pohoch gye kya 
        //last cell mai you dont move at all, you print
           System.out.println(rem.psf);
            
        }else if( rem.i == dp.length - 1){ //kya hum last row mai hai to sirf horizontally move kr skte ho
           queue.add(new Pair(rem.psf + "H", rem.i, rem.j + 1));
            
        }else if( rem.j == dp[0].length - 1){ //kya hum last column mai hai to sirf vertically ja skte ho
           queue.add(new Pair(rem.psf + "V", rem.i + 1, rem.j));
            
        }else{ //rest of it mai hai 
        //rest of it mai apke pas 2 options hote hai ya to aap vertical ja skte ho or horiontal ja skte ho, agar dono jagah equal value pdi hai to dono jagah jayenge kyuki hume ab sare paths chahiye reverse engineering kr rhe hai 
         
         if( dp[rem.i][rem.j + 1] < dp[rem.i + 1][rem.j]){ // dp of jo remove hua hai (rem.i) aur jo remove hai (rem.j) + 1 matlab usne horizontally move kiya, agar woh chota hai. matlab horizontal wala chota hai vertical wale se
            queue.add(new Pair(rem.psf + "H", rem.i, rem.j + 1)); // ab queue mai add karenge, jo remove hua tha uska psf + H. fir jo remove hua tha uska i aur j
         }else if( dp[rem.i][rem.j + 1] > dp[rem.i + 1][rem.j]){ // yafir vertical wala chota hai aur horizontal wala bada hai
             queue.add(new Pair(rem.psf + "V", rem.i + 1, rem.j));
             
         }else{ //yafir dono barabr hai to dono add honge, pehle vertical wala child add krde
           queue.add(new Pair(rem.psf + "V", rem.i + 1, rem.j));
           queue.add(new Pair(rem.psf + "H", rem.i, rem.j + 1));
         }
            
        }
      }
   }
}
