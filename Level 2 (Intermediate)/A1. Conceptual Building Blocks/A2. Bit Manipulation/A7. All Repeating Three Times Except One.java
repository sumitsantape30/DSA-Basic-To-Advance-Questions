ll Repeating Three Times Except One

1. You are given an array of numbers.
2. All numbers occur thrice in the array except one.
3. You have to find the element that occurs once.
Input Format
A number n
a1
a2..
n numbers
Output Format
A number

Constraints
1 <= n <= 10^9
1 <= a1,a2.. <= 10^9
Sample Input
4
1 1 1 2 
Sample Output
2

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
    // mai 3 number banata hu, aur initially tn mai sare bits 1 means tn -1 lena hoga tab tn ke sar bits 1 pe set honge, aur tnp1 aur tnp2 ko 0 pe set krdo
    int tn = -1 , tnp1 = 0, tnp2 = 0; // tn: 3n, tnp1: 3n+1, tnp2: 3n+2
    
    //fir maine ek loop lagaya
    for( int i=0; i< arr.length; i++){
        int cwtn = arr[i] & tn; // common with 3n. common nikalne keliye arr[i] & 3n ka AND lelo
        int cwtnp1 = arr[i] & tnp1 ;// common with 3n+1, 
        int cwtnp2 = arr[i] & tnp2 ; // common with 2n+1
        
        // teeno ke sath common nikal liya
        // jo 3n ke sath common hai woh 3n mai off hongi aur 3n+1 mai on hongi
        
        //so pehle 3n mai off karunga aur 3n+1 mai on karunga
        tn = tn & (~cwtn);
        tnp1 = tnp1 | cwtn; // fir 3n+1 mai on kardiya
        
        //common with 3n+1 ko 3n+1 mai off kardunga
        tnp1 = tnp1 & (~cwtnp1);
        //aur 3n+2 mai jake on karde
        tnp2 = tnp2 | cwtnp1; 
        
        //aur jo cw3n+2 hai woh 3n mai jake on hojayenge to pehle tnp2 mese off krdo
        tnp2 = tnp2 & (~cwtnp2);//khud mese off kardo
        tn = tn | cwtnp2 ; // aur 3n mai jake on kardi
    }
    
    System.out.println(tnp1); // 
   
  }

}
