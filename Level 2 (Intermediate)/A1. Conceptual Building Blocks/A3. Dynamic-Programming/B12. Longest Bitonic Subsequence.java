Longest Bitonic Subsequence

1. You are given a number n, representing the number of elements.
2. You are given n numbers, representing the contents of array of length n.
3. You are required to print the length of longest bitonic subsequence of array.
Note -> bitonic subsequence begins with elements in increasing order, followed by elements in decreasing order.
Input Format
A number n
.. n more elements
Output Format
A number representing the length of longest increasing subsequence of array.

Constraints
0 <= n <= 20
0 <= n1, n2, .. <= 100
Sample Input
10
10
22
9
33
21
50
41
60
80
1
Sample Output
7

Code:

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner s= new Scanner(System.in);
        int n= s.nextInt();
        
        int arr[]= new int[n];
        
        for( int i=0; i< arr.length; i++){
            arr[i] = s.nextInt();
        }
        
        int lis[]= new int[n]; //lis ka dp array
        for( int i=0; i< arr.length; i++){
            int max = 0;
            
            for( int j=0; j< i; j++){
                if( arr[j] <= arr[i]){ //agar woh chota hai i se tabhi i uske niche lag skta hai 
                     if( lis[j] > max){
                         max = lis[j];
                     }
                }
            }
            
            //yahapr aap max leke aaye 
            lis[i] = max + 1; //dp array mai store karenge max+1
        }
        
        //ab hum solve karna chahte hai LDS(longest decreasing subsequence)
        int lds[]= new int[n]; //lds ka dp array
        //lds mai ulta solve hoga
        for( int i= arr.length-1; i >= 0 ; i--){
            int max = 0;
            
            for( int j= arr.length-1; j > i; j--){
                if( arr[j] <= arr[i]){ //agar woh chota hai i se tabhi i uske upar lag skta hai 
                     if( lds[j] > max){
                         max = lds[j];
                     }
                }
            }
            
            //yahapr aap max leke aaye 
            lds[i] = max + 1; //dp array mai store karenge max+1
        }
        
        //ab hume nikalne hai overall max
        int omax = 0;
        //ab lis aur lds same spot ke add honge
        //kahar muda hai woh lbs mai woh humara answer banega
        for( int i = 0; i< arr.length; i++){
            if( lis[i] + lds[i] -1 > omax){
                omax = lis[i] + lds[i] -1;
            }
        }
        
        System.out.println(omax);
        
    }

}
