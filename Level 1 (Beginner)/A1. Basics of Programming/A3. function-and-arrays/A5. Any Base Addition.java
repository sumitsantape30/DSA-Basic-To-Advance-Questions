Any Base Addition

1. You are given a base b.
2. You are given two numbers n1 and n2 of base b.
3. You are required to add the two numbes and print their value in base b.
Input Format
A base b
A number n1
A number n2
Output Format
A number representing the sum of n1 and n2 in base b.

Constraints
2 <= b <= 10
0 <= n1 <= 256
0 <= n2 <= 256
Sample Input
8
777
1
Sample Output
1000

Code:
package FunctionsAndArrays;

import java.util.Scanner;

public class AnyBaseAddition {
	
	 public static int getSum(int b, int n1, int n2){

		 int rv=0;
		 int c= 0; //initially mera carry 0 hai
		 int p=1; //power hai yeh
		 //mera kam tabtak chalega jabtak n1 mai digit bachi hai ya fir n2 mai digit bachi hai ya carry bacha hai
		 while( n1 > 0 || n2 > 0 || c > 0) {
			 
			 //ab n1 aur n2 ki aakhri digit nikalenge
			 //ab pehli digit nikalenge
			 int d1= n1 % 10;
			 int d2= n2% 10; //dusri digit
			 
			 //ab donoko chota karenge
			 //ab n1 ko chota karunga
			 n1= n1 /10;
			 n2= n2/10; //n2 kobhi chota karunga
			 
			 //ab mai dono digit ka sum nikalta hu aur sathme carry bhi add hota hai
			 int d= d1+ d2 + c;
			 //agar inn teeno ko add karke jo number aya woh 8 se chota aya to thik hai, agar woh 8  se bada hai to woh carry chodega aur ayapr spare chodega
			 // following is the way to do it
			 c = d/ b; //agar woh 8 ya 8 se bda number chhod rha hai to carry apne aap 1 hojayega aur agar 7 tak ka  number chodata hai to 7/8 is zero
			 d = d % b; //this is my remaining digit, remainder
			 
			 //ab yeh digit hume use krni hai yeh rv mai add hogi and yeh normal add nhi hogi iske sath ek power multiply hogi
			 rv += d* p;
			 //aur power ko 10 se badhe dijiyega
			 p= p * 10;
			 
		 }
		 return rv;
		 
	 }

	public static void main(String[] args) {
	      Scanner scn = new Scanner(System.in);
	      int b = scn.nextInt();
	      int n1 = scn.nextInt();
	      int n2 = scn.nextInt();
	  
	      int d = getSum(b, n1, n2);
	      System.out.println(d);
	   }
	  
}

Input:
8
236
754
Output:
1212
