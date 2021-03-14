Constraints
1 <= n <= 10
Sample Input
7
Sample Output
1												1	
1	2										2	1	
1	2	3								3	2	1	
1	2	3	4						4	3	2	1	
1	2	3	4	5				5	4	3	2	1	
1	2	3	4	5	6		6	5	4	3	2	1	
1	2	3	4	5	6	7	6	5	4	3	2	1	
  
n= 4
1						1	
1	2				2	1	
1	2	3		3	2	1	
1	2	3	4	3	2	1	
  
Code:

package Patterns;

import java.util.Scanner;

public class Pattern16 {

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int n = s.nextInt();
		
		int st= 1;
		int sp= 2*n- 3;
		
		for( int i= 1; i<= n; i++) {
			int val= 1; // har row 1 sehi start ho rha hai isliye val ko andar rakhenge
			
			for( int j= 1; j <= st; j++) {
				System.out.print(val+"\t");
				val++ ;// first half mai value increase ho rhi and then decrease
			}
			
			for( int j=1; j<= sp; j++) {
				System.out.print("\t");
			}
			
			//ek star extra print hoga isliye star ki value ek pehlehi kam krdete second half mai jane se pehle
			if( i == n) { //agar i n ki value ke barabr hogya to star ki value ek se kam kardenge second half se pehle
				st--;
				val--; //coz last row mai second half mai unki value 432 nhi hogi 321 hogi isliye val mai ek extra minus kiye
			}
			
			for( int j=1; j<= st; j++) {
				val--;
				System.out.print(val+"\t");
				// hum yahape val-- nhi karenge coz usse second half mai 4 3 2 1 print hoga but hume chahiye 3 2 1, so hum chahenge ki print se pehlehi reduce hojaye
			}
			
			st++;
			sp -= 2;
			
			System.out.println();
		}
	}

}


  
  
