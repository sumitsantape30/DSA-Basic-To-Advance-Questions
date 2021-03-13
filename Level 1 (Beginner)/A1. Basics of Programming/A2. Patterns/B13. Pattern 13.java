Constraints
1 <= n <= 10
  
Sample Input
5
Sample Output
1	
1	1	
1	2	1	
1	3	3	1	
1	4	6	4	1	
  
Code:

package Patterns;

import java.util.Scanner;

public class Pattern13 {

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		 
		for( int i=0; i< n; i++) {
			int icj=1; // nC0 humesha 1 hota hai (anything c0 humesha 1 hota hai) so mai value ko 1 leke chalunga kyuki j initially 0 hai
			for( int j= 0; j<= i; j++) {
				System.out.print(icj+"\t");
				int icjp1= icj * (i-j) / (j+1); //i  j+ 1 ki value
				// aur icj ko update kardenge taki next time yeh print kare
				icj= icjp1;
			}
			System.out.println();
		}
	}
}
