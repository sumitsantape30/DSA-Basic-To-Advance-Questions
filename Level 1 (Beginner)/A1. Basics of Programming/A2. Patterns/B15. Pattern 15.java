Pattern 15

Constraints
1 <= n <= 10
 Also, n is odd.
  
Sample Input
5
Sample Output
		1	
	2	3	2	
3	4	5	4	3	
	2	3	2	
		1	
  
Code:

package Patterns;

import java.util.Scanner;

public class Pattern15 {

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		
		int sp= n/2;
		int st=1;
		int val= 1;
		for( int i=1; i<= n; i++) {
			
			for( int j=1; j<= sp ; j++) {
				System.out.print("\t");
			}
			
			//column wise number incraese ho rha isliye cval lere, har row mai val control karra and then aage ke numbers cval increase krke print karra
			int cval= val; 
			for( int j=1; j<= st; j++) {
				System.out.print(cval+"\t");
				
				//addhe ke bad columns wise bhi decrease ho rha hai
				if( j <= st/2) { //
					cval++;
				}else{
					cval--;
				}
			}
			
			if( i <= n/2) {
				sp--;
				st+=2;
				//aadhe tak value ko badhne dena hai islye till n/2 val++ karenge
				val++;
			}else {
				sp++;
				st -= 2;
				val--;
			}
			
			System.out.println();
		}
		
	}

}
