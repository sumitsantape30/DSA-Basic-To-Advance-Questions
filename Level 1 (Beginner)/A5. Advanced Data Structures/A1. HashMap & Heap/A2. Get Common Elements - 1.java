Get Common Elements - 1
Easy  Prev   Next
1. You are given a number n1, representing the size of array a1.
2. You are given n1 numbers, representing elements of array a1.
3. You are given a number n2, representing the size of array a2.
4. You are given n2 numbers, representing elements of array a2.
5. You are required to print all elements of a2 which are also present in a1 (in order of their occurence in a2). Make sure to not print duplicates (a2 may have same value present many times).
Input Format
A number n1
n1 number of elements line separated
A number n2
n2 number of elements line separated
Output Format
All relevant elements of a2 in separate lines (no duplicacy)

Constraints
1 <= n1, n2 <= 100
0 <= a1[i], a2[i] < 10
Time complexity should be O(n)
Sample Input
9
5
5
9
8
5
5
8
0
3
18
9
7
1
0
3
6
5
9
1
1
8
0
2
4
2
9
1
5

Sample Output
9
0
3
5
8

Code:

import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {

    Scanner s= new Scanner(System.in);
    int n1=s.nextInt();
    int a1[]= new int[n1];
    for( int i=0; i< n1; i++){
        a1[i]= s.nextInt();
    }

    int n2= s.nextInt();
    int a2[]= new int[n2];
    
    for( int i=0 ; i< n2; i++){
        a2[i]= s.nextInt();
    }
    
    HashMap<Integer, Integer> map= new HashMap<>();
    for( int i=0; i< n1; i++){
        if( map.containsKey(a1[i])){
            map.put(a1[i], map.get(a1[i]) + 1);
        }else{
            map.put(a1[i], 1);
        }
    }
    
    for( int i=0; i< n2; i++){
        if( map.containsKey(a2[i])){
            System.out.println(a2[i]);
            map.remove(a2[i]);
        }
    }

 }

}
