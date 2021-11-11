One Repeating And One Missing

1. You are given an array of length n containing numbers from 1 to n.
2. One number is present twice in array and one is missing.
3. You have to find these two numbers.
Input Format
A number n
a1
a2..
n numbers
Output Format
Missing number
Repeating Number
Question Video

 Constraints
1 <= n <= 10^9
1 <= a1,a2.. <= 10^9 
Sample Input
7
1 
3 
4 
5 
1 
6 
2
Sample Output
Missing Number -> 7
Repeating Number -> 1

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
    
    int xor = 0;
    for( int i=0; i < arr.length; i++){
        xor ^= arr[i]; // pehle array ki sari values ko xor karliya
    }
    
    //fir ek additional wala
    for( int i=1; i<= arr.length; i++){
        xor ^= i; 
    }
    
    // so abhi apki sari value bhi XOR hogyi aur woh 1 2 3 4 5 6 7 bhi XOR hogya ab woh missing number aur dublicate number bacha hua hai woh apko identify karna hai
    int rsb = xor & -xor;
    
    //so ab jinka bit on ho unka alag set banta tha aur jink woh bit off ho unka alag set banta tha
    int x= 0;
    int y= 0;
    for( int val: arr){
       if( (val & rsb) == 0 ){ //agar woh bit off hai 
           x = x ^ val;
       }else{ // agar woh bit on hai 
           y = y ^ val;
       }
    }
    
    //yahi wala kam hum woh additional wale ke sath bhi karenge
    for( int i=1; i<= arr.length; i++){
       if( (i & rsb) == 0 ){  
           x = x ^ i;
       }else{  
           y = y ^ i;
       }
    }
    
    // iske bad x aur y mai missing aur duplicate numbers alag alag pde honge
    // ab konsa missing aur konsa duplicate hai yeh check kanra padega
    for(int val: arr){
        if( val == x){ //agar tumhari value x ke barabr hogyi to x duplicate hai
         //so missing number is y and repeating number is x
           System.out.println("Missing Number -> "+ y);
           System.out.println("Repeating Number -> "+ x);
            break;
        }else if( val == y){ //agar value y ke barbr hogyi to y duplicate hai
           System.out.println("Missing Number -> "+x);
           System.out.println("Repeating Number -> "+y);
            break;
        }
    }
   
  }

}
