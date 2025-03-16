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
			//The binary representation of the integer i needs to have the same number of bits as the number of elements in the array (arr.length).
			
			// ab woh binary number ke upar traverse karna hai left to right aur decide karna hai woh digit print hoga ya nhi
			
			int div= (int)Math.pow(10, arr.length-1 ); //pehli bar keliye divisor ki yeh value hogi

			//Why the Binary Length Matches the Array Length? read at the bottom of this page
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

//Why the Binary Length Matches the Array Length:
//The key is the number of bits required to represent the number i:

//A binary number i will always be padded with leading zeroes to match the length of the array. This is what ensures that every subset has a binary representation with exactly n bits.
//If you are converting i into a binary number, i will be treated as a base-2 number, and the number of bits needed to represent it will be padded to match the length of the array (arr.length).

