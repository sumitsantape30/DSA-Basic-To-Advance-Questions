Difference Of Two Arrays

1. You are given a number n1, representing the size of array a1.
2. You are given n1 numbers, representing elements of array a1.
3. You are given a number n2, representing the size of array a2.
4. You are given n2 numbers, representing elements of array a2.
5. The two arrays represent digits of two numbers.
6. You are required to find the difference of two numbers represented by two arrays and print the arrays. a2 - a1

Assumption - number represented by a2 is greater.
Input Format
A number n1
n1 number of elements line separated
A number n2
n2 number of elements line separated
Output Format
A number representing difference of two numbers (a2 - a1), represented by two arrays.

Constraints
1 <= n1, n2 <= 100
0 <= a1[i], a2[i] < 10
number reresented by a1 is smaller than number represented by a2
Sample Input
3
2
6
7
4
1
0
0
0
Sample Output
7
3
3

Code:

//=============================== Correct Solution===================================
import java.io.*;
import java.util.*;

public class Main{
	
	public static void difference( int a1[], int a2[], int n1, int n2) {
		
		//assumptions mai arr2 value mai bada hai, value mai bada hai matlab ya to dono size mai equal honge ya arr2 length mai bhi bda hoga. So n2 jitna banayenge diff array
		int diff[]= new int[n2];
		int c=0; //carry
		
		int i= a1.length-1;
		int j= a2.length-1;
		int k= diff.length-1;
		
		//jabtak k rahega tabtak kam chalega
		while( k >= 0) {
			int d= 0;
			int a1v = i >= 0 ? a1[i]: 0 ; //arr1 ki values. Agar i greater than equal to 0 hai to arr1 ki value mani jayegi arr1[i], agar value negative ho chuki hai i ki to arr1[i] ki value 0 consider karli jaye
					
			
			//arr2 mese arr1 ko minus karna hai as arr2 bada diya hai
			if( a2[j] + c >= a1v) { // so arr2 + carry bada number hai arr1 se to substract hojayega warna carry leke substract karna padega
				//so agar carry aur upar wali digit milake badi hai to hum bindas substract karenge aur substact ke bad humara carry hojayega
				d = a2[j] + c - a1v;
				c= 0;
				
			}else { //agar upar wala chota pd gya to carry -1 de denge aage means borrow leliya, aur iska nam ka upar wale ko 10 extra milega
				d= a2[j] + c + 10 - a1v;
				c= -1;
			}
			
			//ab inko diff array mai dal denge
			diff[k]= d;
			
			i--;
			j--;
			k--;
		}
		
		//print krte waqt preceding 0s print nhi karna chahiye
		int idx= 0;
		while( idx < diff.length) { //jabtak hum uske end tak nhi pahuchte tabtak
			if( diff[idx] == 0) { //agar diff of inx par 0 hai to idx ko ++ krde
				idx++; 
			}else { //aur jaisehi non zero aaye break karde
				break;
			}// so jabtak 0 aate rhe usko pass krta rhe aur jaisehi non zero aaye loop ko break karke bahar aajaye
		}
		
		//ab humare initial wale zeros nikal chuke hai aur index aage badh chuka hai to yahase aage ke sare numbers print krne hai 
		while( idx < diff.length) {
			System.out.println(diff[idx]);
			idx++;
		}
	}

	public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int a[] = new int[n1];
        
        for(int i = 0; i < n1; i++) {
       	 a[i] = sc.nextInt();
        }
        
        int n2 = sc.nextInt();
        int b[] = new int[n2];
        
        for(int i = 0; i < n2; i++) {
       	 b[i] = sc.nextInt();
        }
        
		difference(a, b, n1, n2);
	}

}

//=========================================================================================

package FunctionsAndArrays;

import java.util.Scanner;

public class DifferenceBetweenTwoArrays {
	
	public static int[] takeInput() {
		
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int arr[]= new int[n];
		
		for( int i=0; i< arr.length; i++) {
			arr[i]= s.nextInt();
		}
		return arr;
	}
	
	public static void difference( int arr1[], int arr2[], int n1, int n2) {
		
		//assumptions mai arr2 value mai bada hai, value mai bada hai matlab ya to dono size mai equal honge ya arr2 length mai bhi bda hoga. So n2 jitna banayenge diff array
		int diff[]= new int[n2];
		int c=0; //carry
		
		int i= arr1.length-1;
		int j= arr2.length-1;
		int k= diff.length-1;
		
		//jabtak k rahega tabtak kam chalega
		while( k >= 0) {
			int d= 0;
			int arr1val= i >= 0 ? arr1[i]: 0 ; //arr1 ki values. Agar i greater than equal to 0 hai to arr1 ki value mani jayegi arr1[i], agar value negative ho chuki hai i ki to arr1[i] ki value 0 consider karli jaye
					
			
			//arr2 mese arr1 ko minus karna hai as arr2 bada diya hai
			if( arr2[j] + c >= arr1val) { // so arr2 + carry bada number hai arr1 se to substract hojayega warna carry leke substract karna padega
				//so agar carry aur upar wali digit milake badi hai to hum bindas substract karenge aur substact ke bad humara carry hojayega
				d = arr2[j] + c - arr1val;
				c= 0;
				
			}else { //agar upar wala chota pd gya to carry -1 de denge aage means borrow leliya, aur iska nam ka upar wale ko 10 extra milega
				d= arr2[j] + c + 10 - arr1val;
				c= -1;
			}
			
			//ab inko diff array mai dal denge
			diff[k]= d;
			
			i--;
			j--;
			k--;
		}
		
		//print krte waqt preceding 0s print nhi karna chahiye
		int idx= 0;
		while( idx < diff.length) { //jabtak hum uske end tak nhi pahuchte tabtak
			if( diff[idx] == 0) { //agar diff of inx par 0 hai to idx ko ++ krde
				idx++; 
			}else { //aur jaisehi non zero aaye break karde
				break;
			}// so jabtak 0 aate rhe usko pass krta rhe aur jaisehi non zero aaye loop ko break karke bahar aajaye
		}
		
		//ab humare initial wale zeros nikal chuke hai aur index aage badh chuka hai to yahase aage ke sare numbers print krne hai 
		while( idx < diff.length) {
			System.out.println(diff[idx]);
			idx++;
		}
	}

	public static void main(String[] args) {

		int arr1[]= takeInput();
		int n1= arr1.length;
		int arr2[]= takeInput();
		int n2= arr2.length;
		difference(arr1, arr2, n1, n2);
	}

}
