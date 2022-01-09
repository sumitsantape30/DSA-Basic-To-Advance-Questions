Print All Longest Increasing Subsequences

1. You are given a number N representing number of elements.
2. You are given N space separated numbers (ELE : elements).
3. Your task is to find & print  
    3.1) Length of "Longest Increasing Subsequence"(LIS).
    3.2) All "Longest Increasing Subsequence(s)"(LIS).
NOTE: Checkout sample question/solution video inorder to have more insight.
Input Format
A number N (representing "NUMBER OF ELEMENTS").
ELE1 ,ELE2 ,ELE3 ,ELE4 .... ELEn (N space separated numbers represnting numbers).
Output Format
1) A number representing Length of "Longest Increasing Subsequence"(LIS).
2) Strings representing "Longest Increasing Subsequence(s)"(LIS).
Check the sample ouput and question video.

Constraints
1 <= N <= 100
1 <= ELE <= 1000
Sample Input
10
10 22 9 33 21 50 41 60 80 1
Sample Output
6
10 -> 22 -> 33 -> 41 -> 60 -> 80
10 -> 22 -> 33 -> 50 -> 60 -> 80

Code:

//========================= One test case is failing===============================================

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

  public static class Pair {
    int l;
    int i;
    int v;
    String psf;

    Pair(int l, int i, int v, String psf) {
      this.l = l;
      this.i = i;
      this.v = v;
      this.psf = psf;
    }
  }

  public static void solution(int []arr) {
    int dp[] = new int[arr.length];
    int omax = 0;
    int omi = 0; //overall max ka index

    for( int i = 0; i < dp.length; i++) {
      int max = 0;

      for( int j = 0; j < i; j++) {
        if( arr[j] <= arr[i]) { //hums sirf increasing keliye man rhe hai strictly increasing keliye nhi man rhe, agar equal value aati hai to usko lenge. agar 10 20 hai to uske piche 10 20 20 jod skte hai
          if(dp[j] > max) {
            max = dp[j];
          }
        }
      }
      
      dp[i] = max + 1;
      if( dp[i] > omax){
          omax = dp[i];
          omi = i;
      }
    }
    
    System.out.println(omax); // length print kardenge

    //ab bfs
    ArrayDeque<Pair> queue = new ArrayDeque<>();
    queue.add(new Pair(omax, omi, arr[omi], arr[omi] + "")); //yeh mai pehla pair dal rha hu iske andar, length hogi jo dp mai overall max index pe pdi hai or jo overall max hai woh bhi length hi hai.
    
    while(queue.size() > 0){ // jabtak queue ka size grater than 0 hai tabtak kam karenge
     Pair rem = queue.removeFirst();
     
     if(rem.l == 1){ //agar remove hone wale ki length 1 ho woh answer hai use print karde, length 1 se niche nhi ja skte aap
       System.out.println(rem.psf);
     }
     
     //suppose 6 length wala abhi nikla to isse pehle wale area mai kiski length 5 ke bararbr hai aur kya uski value tumse choti hai to woh dal jayega
     
     for( int j = rem.i - 1 ; j >= 0 ; j--){ //jo remove hua hai uske index se loop lagana hai, ulta loop lagaye taki sahi order mai answer aaye, *iska aur explanation video mai dekhlo*
        
        if(dp[j] == rem.l - 1 && arr[j] <= rem.v){ //agar j pe jo value pdi hai woh rem.l -1 ke brbar hai aur uski value bhi apni value se choti honi chahiye
          queue.add(new Pair(dp[j], j, arr[j], arr[j] + " -> "+ rem.psf));
        }
     }
    }
  }

  public static void main(String []args) {
    Scanner scn = new Scanner(System.in);

    int n = scn.nextInt();

    int arr[] = new int[n];
    for (int i = 0 ; i < n ; i++) {
      arr[i] = scn.nextInt();
    }

    solution(arr);

    scn.close();
  }
}
