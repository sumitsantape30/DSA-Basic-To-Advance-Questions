Print All Paths With Maximum Gold

1. You are given a number n, representing the number of rows.
2. You are given a number m, representing the number of columns.
3. You are given n*m numbers, representing elements of 2d array a, which represents a gold mine.
4. You are standing in front of left wall and are supposed to dig to the right wall. You can start from any row in the left wall.
5. You are allowed to move 1 cell right-up (d1), 1 cell right (d2) or 1 cell right-down(d3).
6. Each cell has a value that is the amount of gold available in the cell.
7. You are required to identify the maximum amount of gold that can be dug out from the mine.
8. Also, you have to print all paths with maximum gold.
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
33
4 d3 d1 d2 d3 d1 

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
      
      //yeh column by column solve hota hai, j pehle extreme pe hoga then i niche ki taraf increase hoga
      for( int j = arr[0].length - 1; j >= 0; j--){
          for( int i = 0; i < arr.length; i++){
              if( j == arr[0].length - 1){ //aap extreme column pe ho to jo values hai wahi ayegi coz aage kuch nhi hai dig krne keliye
               dp[i][j] = arr[i][j];
                  
              }else if(i == 0){ //yeh apki first row hai to agle column mai jane keliye 2 options hai apke pas. app d2 yafir d3 ke taraf ja skte ho, donomese jo maximum hoga uss taraf jayenge
               dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], dp[i + 1][j + 1]); // aap same row mai aage ja skte ho or apnese niche wali row mai diagonally ja skte ho
                  
              }else if( i == arr.length - 1){ //ya apki last row hai tabbhi aap 2 direction mai ja skte ho, samne or upar ki taraf
              
               dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], dp[i - 1][j + 1]);
                  
              }else{//yafir aap bichme kahipe ho to 3 direction mai ja skte ho
              
               dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], Math.max(dp[i - 1][j + 1], dp[i + 1][j + 1]));
               
              }
          }
      }
      
      int max = Integer.MIN_VALUE;
      //first column mai jo max hoga woh mere answer hoga
      for( int i = 0; i< dp.length; i++){
          if( dp[i][0] > max){ //row badal rhi hai column 0 hi rahega
            max = dp[i][0];
          }
      }
      
      System.out.println(max);
      
      //agar first column mai yeh max jitni bar milega means agar same value first column mai multiple rows mai hongi to shuruwat mai apni arraydeque mai yeh dono dal denge
      
      ArrayDeque<Pair> que = new ArrayDeque<>();
      for( int i = 0; i< dp.length; i++){
          if( dp[i][0] == max){ //jaha jaha max ke equal value milegi mai usko pair banake queue mai add karlunga
            que.add(new Pair(i + "", i, 0)); //psf mai shuruwat mai row(i) number bhi dalunga. aur j 0 hai sabka
          }
      }
      
      while( que.size() > 0){ //ab jabtak meri queue khali nhi hojati 
          Pair rem = que.removeFirst(); //remove karenge
          
          if( rem.j == arr[0].length - 1){ //agar yeh last column hai to kuch nhi karenge simply print karenge
            System.out.println(rem.psf);
          }
          //agar yeh last column nhi hai to iske children dalenge agle teeno ko check karke unn teen mai jo ke equal hai usko dalenge. ho skta hai yeh first or last row mai bhi ho
          else if( rem.i == 0){ // agar hum first row mai hai to 2 hi jagah ja skte hai, to jaha jaha ja skte hai uska max nikal lo
            
            int g = Math.max(dp[rem.i][rem.j + 1], dp[rem.i + 1][rem.j + 1]); //donoka greater(g)
            
            //sare child mese jo g ke equal hai unko dal do agar dono same hai to dono daldo
            
            if( g == dp[rem.i][rem.j + 1]){ //agar row same hai matlab d2 wala motion
                que.add(new Pair(rem.psf + " d2", rem.i, rem.j + 1));// naya pair dalenge. samne gye ho to yeh d2 hai 
            }
            
            if( g == dp[rem.i + 1][rem.j + 1]){ //agar row same hai matlab d2 wala motion
                que.add(new Pair(rem.psf + " d3", rem.i + 1, rem.j + 1)); //isme tum niche gye to yeh d3 hai
            }
            
          }else if(rem.i == arr.length - 1){ //hum last row mai hai, upar jaisa hi logic ayega so copy n paste
            
            int g = Math.max(dp[rem.i][rem.j + 1], dp[rem.i - 1][rem.j + 1]); 
            
            if( g == dp[rem.i - 1][rem.j + 1]){ 
                que.add(new Pair(rem.psf + " d1", rem.i - 1, rem.j + 1));  //d1 hoga ab yaha
            }

            if( g == dp[rem.i][rem.j + 1]){ 
                que.add(new Pair(rem.psf + " d2", rem.i, rem.j + 1)); 
            }
            
          }else{ //bicheme kahipe hai to 3 options hote hai
              
            int g = Math.max(dp[rem.i][rem.j + 1], Math.max(dp[rem.i - 1][rem.j + 1], dp[rem.i + 1][rem.j + 1])); 
            
            if( g == dp[rem.i - 1][rem.j + 1]){ 
                que.add(new Pair(rem.psf + " d1", rem.i + 1, rem.j + 1)); 
            }

            if( g == dp[rem.i][rem.j + 1]){ 
                que.add(new Pair(rem.psf + " d2", rem.i, rem.j + 1));
            }
            
            if( g == dp[rem.i + 1][rem.j + 1]){ 
                que.add(new Pair(rem.psf + " d3", rem.i + 1, rem.j + 1)); 
            }

          }
      }  
   }
}
