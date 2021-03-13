Constraints
1 <= n <= 5
  
Sample Input
5
Sample Output
0	
1	1	
2	3	5	
8	13	21	34	
55	89	144	233	377	
  
Code:

package Patterns;

import java.util.Scanner;

public class Pattern12 {

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		
		//pehle triangle ka code likhenge fir fibonacci series ko introduce karenge
		
		//for bino
		int a= 0;
		int b= 1;
		
		for( int i=1; i<= n; i++) {
			for( int j=1; j<= i; j++) {
				
				System.out.print(a+"\t"); 
				//fibo mai 3rd number banate hai sum of previous two, aur fir first number second number ke barabr hojata hai, aur second number third number ke barbr hojata hai and print hum humesha first number hi krte hai coz woh saare numbers se travel krta hai
				int c= a+b;
				a= b;
				b= c;
				
			}
			System.out.println();
		}
	}
}
