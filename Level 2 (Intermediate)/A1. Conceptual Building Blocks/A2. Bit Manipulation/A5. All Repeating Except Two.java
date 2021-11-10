All Repeating Except Two

1. You are given an array of numbers.
2. You have to find 2 non-repeating numbers in an array.
3. All repeating numbers are repeating even number of times.
Input Format
A number n
a1
a2..
n numbers
Output Format
2 Non-repeating number

Constraints
1 <= n <= 10^9
1 <= a1,a2.. <= 10^9 
Sample Input
6
23 27 23 17 17 37
Sample Output
27
37

Code:

import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i = 0 ; i < n; i++){
      arr[i] = scn.nextInt();
    }
    solution(arr);
  }

  public static void solution(int[] arr){
      int xxory = 0; // yeh hume x XOR y dene wala hai
      
      for(int val: arr){
          xxory= xxory ^ val;
      } // iss loop ke chalne ke bad apke pas xxory bach jayega kyuki baki sare kat jayenge
      
      // so abhi jo x XOR y bacha hai hume isme x and y alag karna hai 
      // ab hume yeh jo XOR aya hai iski rightmost set bit ka mask nikalna hai
      int rsbm = xxory & -xxory; 
      // is bit mask ko har number ke sath mai yeh check kr skta hu ki unki yeh wali bit on hai ya off, jinki bit off hai unka alag se XOR lenge aur jinki yeh bit on hai unka alag se XOR lenge. jinki bit off hai jab unka XOR lenge to usme 56 or 42 mese ek hi ayega
      
      int x=0;
      int y=0;
      
      for(int val: arr){ // ab mai yeh check kr rha hu kiski yeh bit on hai 
        if( (val & rsbm) == 0 ){ // agar inka & 0 ata hai to iss value ki woh bit off hai unka XOR alag lelo
           x = x ^ val;
            
        }else{ // agar non zero aya to iski yeh bit off thi to inka XOR alag lenge
           y = y ^ val;
        }
          
      }
      
      //as humne decide kiya tha jo chota hoga woh pehle print hoga
      if( x < y){
          System.out.println(x);
          System.out.println(y);
      }else{
          System.out.println(y);
          System.out.println(x);
      }
   
  }

}
