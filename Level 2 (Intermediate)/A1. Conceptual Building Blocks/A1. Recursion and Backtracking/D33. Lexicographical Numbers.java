Lexicographical Numbers

1. You are given a number.
2. You have to print all the numbers from 1 to n in lexicographical order.

Note -> Check out the question video and write the recursive code as it is intended without 
               changing signature. The judge can't force you but intends you to teach a concept.
Input Format
A number
Output Format
Check the sample output and question video

Constraints
1 <= n <= 50000
Sample Input
14
Sample Output
1
10
11
12
13
14
2
3
4
5
6
7
8
9

Code:

import java.io.*;
import java.util.*;

public class Main {
    
    public static void dfs( int i, int n){
        if( i > n){ // jab i n se bada hojaye to return
            return;
        }
        
        System.out.println(i); // jobhi number ata hai woh khudko prnint krta hai 
        // mai to print hogya ab meri family print hogi
        for( int j=0; j< 10; j++){
            dfs( 10 * i + j, n); // mujhme(i) 10 multipy karo aur j add krke pass karo
        }
        
    }
    
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

        //shuruwat mai 1 se leke 9 tak ki recursion call lagani padegi
        for( int i=1; i<=9; i++){
            dfs(i, n); // i pas kiya aur n pass kiya ki kahatk print karna hai 
        }
	}
	
}
