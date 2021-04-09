Sort Dates
1. You are given an array(arr) of different dates in format DD-MM-YYYY.
2. You have to sort these dates in increasing order.
Input Format
An Integer N 
arr1
arr2..
n integers
Output Format
Check the sample output and question video.

Constraints
1 <= N <= 10000
All dates are between year 0 to year 2500
Sample Input
5
12041996
20101996
05061997
12041989
11081987
Sample Output
11081987
12041989
12041996
20101996
05061997

Code:

package TimeAnsSpace;

import java.util.Scanner;

public class SortDates {

	// hume sortDates se countSort ko call lagani hai, ek dates keliye fir months keliye fir year keliye
	public static void sortDates(String[] arr) {

		//so sabse pehle days keliye count sort call karenge
		countSort(arr, 1000000, 100, 32 ); //days, range 32? coz hum values 1 se 31 pass karengeto frequency hume 1 to 31 tak ki karni hogi
		countSort(arr, 10000, 100, 12); // month, range 12? 0 se leke 12 tak sare index hote hai
		countSort(arr, 1, 10000, 2501); //year, given hai ki 2500 se bda year nhi hog isliye 2501 liye
		
		// explanation for range: jee mai 12lakh students baithte hai but marks 0 to 360 ke bich mai hi milte hai so jitni range hogi utni hi size ka frequency array banega
	}

	public static void countSort(String[] arr, int div, int mod, int range) {
		
		String ans[]= new String[arr.length];

		int farr[] = new int[range]; //frequency array hum utna hi bda banate hai jitni humari range hai

		for (int i = 0; i < arr.length; i++) {
			farr[Integer.parseInt(arr[i], 10) / div % mod]++; 
		} //string array hai isliye integer mai convert kiye. jab bhi string ko integer mai convert karege to base 10 ka use karenge isliye ,10 liya
		// suppose date 06 hai so jab bhi string mai 06 pass krte hai aur use Integer.parseInt krte hai to machine yeh smjhti hai ki yeh octal hai means iska base octal hai but hume 8 ke base pe kam nhi karna humari base to 10 pe hai so hum bol rhe hai ki 10 ka bsae use kare, decimal number system use kare octal system nhi use kare
		
		for (int i = 1; i < farr.length; i++) {
			farr[i] = farr[i] + farr[i - 1];
		} 
		
		for (int i = arr.length - 1; i >= 0; i--) {
			int pos = farr[Integer.parseInt(arr[i], 10) / div % mod]-1 ; 
			ans[pos]= arr[i];
			farr[Integer.parseInt(arr[i], 10) / div % mod]--; 
		}

		for (int i = 0; i < ans.length; i++) {
			arr[i] = ans[i];
		}
	}

	public static void print(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		String[] arr = new String[n];
		for (int i = 0; i < n; i++) {
			String str = scn.next();
			arr[i] = str;
		}
		sortDates(arr);
		print(arr);
	}

}
