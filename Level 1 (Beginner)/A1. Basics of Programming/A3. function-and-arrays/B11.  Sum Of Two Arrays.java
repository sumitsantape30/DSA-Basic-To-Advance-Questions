Sum Of Two Arrays

1. You are given a number n1, representing the size of array a1.
2. You are given n1 numbers, representing elements of array a1.
3. You are given a number n2, representing the size of array a2.
4. You are given n2 numbers, representing elements of array a2.
5. The two arrays represent digits of two numbers.
6. You are required to add the numbers represented by two arrays and print the
arrays.

Input Format
A number n1
n1 number of elements line separated
A number n2
n2 number of elements line separated
Output Format
A number representing sum of two numbers, represented by two arrays.
Question Video

Constraints
1 <= n1, n2 <= 100
0 <= a1[i], a2[i] < 10

Sample Input
5
3
1
0
7
5
6
1
1
1
1
1
1
Sample Output
1
4

Code:

package FunctionsAndArrays;

import java.util.Scanner;

public class SumOfTwoArrays {
	
	public static int[] takeInput() {
		
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		
		int arr[]= new int[n];
		
		for( int i=0; i< arr.length; i++) {
			arr[i]= s.nextInt();
		}
		return arr;
	}
	
	public static void sum( int arr1[], int arr2[], int n1, int n2) {
		
		//dono array mese jo bda hoga utne size ka sum array banayenge
		int sum[]= new int[n1 > n2 ? n1 : n2]; //agar n1 bada hai n2 se to n1 size ka otherwise n2 size ka
		
		int c= 0; //carry
		
		int i= arr1.length-1;
		int j= arr2.length- 1;
		int k= sum.length-1;
		
		while( k >= 0) { //jatbak k hai tabtak kam chalega
			// ab muje i and j ko add karna hai and usko k mai dalna hai to digit mai carry rakh lete hai
			int d= c; //digit
			
			if( i >= 0) { //agar i abhi bacha hai means i abhi negative nhi hua hai matlab arr1 wale elements bache hue hai to digit mai isko add karle
				d += arr1[i];
			}
			
			if( j >= 0) { //agar j bacha hua hai to j ko bhi digit mai add karlenge
				d += arr2[j];
			}
			
			//ab carry establish karenge
			c= d / 10;
			d = d % 10; //humari digit choti hogyi
			
			//ab digit ko sum array mai dal denge
			sum[k]= d;
			
			//sabko ek ek step piche lenge
			i--;
			j--;
			k--;
		}
		
		//so ab print krte waqt, agar carry non zero hai 
		if( c != 0) { //agar carry non zero hai to carry bhi print hoga
			System.out.println(c);
		}
		
		//otherwise sum wala array print karde
		for( int val : sum) {
			System.out.println(val);
		}
		
	}

	public static void main(String[] args) {

		int arr1[]= takeInput();
		int n1= arr1.length;

		int arr2[]= takeInput();
		int n2= arr2.length;
		sum( arr1, arr2, n1, n2);
	}

}
