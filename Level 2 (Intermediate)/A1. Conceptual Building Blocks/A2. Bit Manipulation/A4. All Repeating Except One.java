All Repeating Except One

1. You are given an array of numbers.
2. All numbers occur twice in the array except one.
3. You have to find that number by traversing only once in the array and without using any extra 
     space.
Input Format
A number n
a1
a2..
n numbers
Output Format
Non-repeating number

Constraints
1 <= n <= 10^9
1 <= a1,a2.. <= 10^9 
Sample Input
5
23 27 23 17 17
Sample Output
27

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
    
    int uni = 0; //hum humara unique number initialise karenge
    for( int val: arr){ // array mai lagayenge loop aur har value ke sath XOR le lenge
       uni = uni ^ val;
    }// so ab jo duplicates honge woh kat jayenge aur jo unique element hoga last mai woh bach jayega
    
    System.out.println(uni);
    
  }

}
