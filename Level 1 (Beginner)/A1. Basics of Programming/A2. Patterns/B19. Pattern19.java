package Patterns;

import java.util.Scanner;

public class Pattern19 {

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		
		for( int i=1; i<= n; i++) {
			
			for( int j=1; j<= n; j++) {
				//hum isko 5 hisso mai divide kar lenge
				
				//agar humari row hai first to usko alag way mai treat karenge
				if( i == 1) { 
					
					//first row keliye, jab j first half mai hai means n/2+1 th tak hai yafir j last mai hona chahiye to star print karenge otherwise space
					if(j == n || j <= n/2 +1) { //j ya to aakhri hona chahiye ya to n/2+1th tak hona chahiye to uss case mai hum print karenge star
						System.out.print("*\t");
					}else {
						System.out.print("\t");
					}
				
				} //nhi agar humari row hai first upper half mai to hum apne columns ko alag way mai treate karenge
				else if( i <= n/2) { 
					
					if(j == n || j == n/2 +1) {
						System.out.print("*\t");
					}else {
						System.out.print("\t");
					}
					
				} //agar hum special wali row pe hai to alag way mai trate karenge  (iska meaning is upar wali do bate zuti hai to kya yeh sacchi bat hai)
				else if( i == n/2+1) { //jo half ke just bad wali row hai woh completely print karenge

						System.out.print("*\t");
					
				} // agar humari row hai n/2+1 se badi hai magar n se choti hai (upar wali teeno bat zuti hai to kya yeh sacchi hai)
				else if( i < n ) {
					
					if(j == 1 || j == n/2 +1) {
						System.out.print("*\t");
					}else {
						System.out.print("\t");
					}
					  
				}else { // upar wala sabkuch zuta hai to of course woh nth row hai
					
					if(j == 1 || j >= n/2 +1) {  //jab first ho ya n/2+1 ke bad ho
						System.out.print("*\t");
					}else {
						System.out.print("\t");
					}
				}
			}
			System.out.println(); 
		}
	}
}

Output:
5 
  
*	*	*		*	
		*		*	
*	*	*	*	*	
*		*			
*		*	*	*	

