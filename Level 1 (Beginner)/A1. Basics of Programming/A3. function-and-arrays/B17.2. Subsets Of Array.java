package Restart;

import java.util.Scanner;

public class Problems {
	
	public static int[] takeInput() {
		
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int arr[]= new int[n];
		
		for( int i=0; i< arr.length; i++) {
			arr[i]= s.nextInt();
		}
		return arr;
	}
	
	public static void subset( int arr[]) { // input wale array ke sare subsets print karwa dega
		
		// sabse pehla kam total number of subsets nikalo
		int tns= (int)Math.pow(2, arr.length);
		
		for( int i=0; i< tns; i++) { //ab loop chala do
			
			// iske bad har ek number(index) ka binary conversion chahiye
			int bn= decTobn(2, i);
			
			// ab woh binary number ke upar traverse karna hai left to right aur decide karna hai woh digit print hoga ya nhi
			
			int div= (int)Math.pow(10, arr.length-1 ); //pehi bar keliye diviso ki value hogi
			
			for( int j=0; j< arr.length; j++) { // yeh loop utni bar chalega jitne array ke elements hai
				// ab quotient aur remainder nikalunga
				int q= bn / div;
				int r= bn % div;
				
				if( q == 1) { //agar quotient aya 1 to hum array ke element ko print karenge nhito dash print hota hai 
					System.out.print(arr[j] + "\t");
				}else {
					System.out.print("-\t");
				}
				// ab agli bar keliye binary number aur divisor update hoga
				bn= r;
				div /= 10;
				
			}
			//pura ek subset print karne ke bad enter lagake next line mai agla subset print hoga
			System.out.println();
			
		}	
	}
	
	public static int decTobn(int b, int n) {
		
		int ans=0;
		int power= 1;
		
		while( n > 0) {
			
			int r= n % b;
			int q= n / b;
			
			ans += (r* power);
			power= power* 10;
			n=  q;
		}
		return ans;
	}
	
	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int arr[]= takeInput();
		subset(arr);
	}
}

