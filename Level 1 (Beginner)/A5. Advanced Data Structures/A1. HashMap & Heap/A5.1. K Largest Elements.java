K Largest Elements

1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing elements of array a.
3. You are given a number k.
4. You are required to find and print the k largest elements of array in increasing order.
Input Format
Input is managed for you
Output Format
Print the k largest elements of array in increasing order in separate lines.

Constraints
1 <= n <= 30
0 <= n1, n2, .. n elements <= 100
0 < k <= n
Sample Input
13
12
62
22
15
37
99
11
37
98
67
31
84
99
4
Sample Output
84
98
99
99

Code:

import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int[] arr = new int[n];

      for (int i = 0; i < n; i++) {
         arr[i] = Integer.parseInt(br.readLine());
      }

      int k = Integer.parseInt(br.readLine());
      
      PriorityQueue<Integer> pq= new PriorityQueue<>();
      
      for( int i=0; i< k; i++){
          pq.add(arr[i]); // 0 to i-k elements aisehi pq mai add kardo
      } //iss loop mai k bande add ho rhe hai to TC will be O(klogk)
      
      //ab rest of the bando keliye
      for( int i=k; i< arr.length; i++){ // k se leke last tak travel karo 
          if( arr[i] > pq.peek()){ //agar current element bada hota hai pq ke peek se means team ke weakest player ko usne hara diya ro weakest ko remove kardo aur current bande ko pq mai add krdo
          pq.remove();
          pq.add(arr[i]);
          }
      }
      
      while(pq.size() != 0){ //fir jabtak priority queue khali nhi hojati tabtak remove krte hue print karenge
          System.out.println(pq.remove());
      }
      
    }

}
