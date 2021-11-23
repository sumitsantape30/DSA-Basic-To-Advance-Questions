Sum Of Bit Differences Of All Pairs

1. You are given an array of n numbers.
2. You have to find the sum of bit differences in all pairs that can be formed from n numbers.
3. Bit difference of two numbers is defined as the count of different bits at same positions in binary representations of two numbers.
Input Format
A number n
a1
a2..
n numbers
Output Format
Check the sample ouput and question video.
Question Video

Constraints
1 <= n <= 10^9
1 <= arr[i] <= 10^9
Sample Input
3
1 2 3
Sample Output
8

Code:

import java.io.*;
import java.util.*;

public class Main {

  public static long solution(int[] arr){ // sare longs hi lelo kyuki bade bade number pass kiye honge
    long res = 0;
    
    for( int i=0; i< 32; i++){ //oth bit se 32th bit tak focus karunga
      long counton = 0; // jitno mai on thi
      
      for( int val: arr){
          //ab hume check karna hai yeh bit on hai ya nhi hai
          if((val & (1 << i)) != 0 ){ //0 aya to yeh bit off hoti hai, non zero aya to yeh bit on hoti hai
            counton++; // bit on hai to count badhalo
          }
      }
      
      //yahapr jab aap aaoge to apko yeh pta lag jayega ki kitne numbers mai yeh bit on thi
        long countoff = arr.length - counton; // sare array mese on wale minus kardenge to off wale mil jayenge
        //ab kitne difference ayega apka
        long diff = counton * countoff * 2; 
        res += diff; // aur isko result mai add krte rhe
    }
    return res;
  }

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i = 0 ; i < arr.length; i++){
      arr[i] = scn.nextInt();
    }
    System.out.println(solution(arr));
  }

}
