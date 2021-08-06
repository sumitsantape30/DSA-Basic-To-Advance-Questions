Count Sort

1. You are given an array(arr) of integers.
2. You have to sort the given array in increasing order using count sort.
Input Format
An Integer n 
arr1
arr2..
n integers
Output Format
Check the sample ouput and question video.

Constraints
1 <= N <= 10000
-10^8 <= arr[i] <= 10^8
Sample Input
5
7 
-2 
4 
1 
3
Sample Output
-2
1
3
4
7
  
Code:

package TimeAnsSpace;

import java.util.Scanner;

public class CountSort {
	
	//count sort kab lafgaya jata hai? jab bohot saari values ho lekin range kam ho means jee ka exam to 12lakh dete hai but number 0 to 360 ke bich mai hi aate hai
	public static void countSort(int arr[], int min, int max) {
		
		//ab hum range nikalenge and usase apna frequency array declare karenge
		int range= min - max +1;
		int farr[]= new int[range];
		
		//1. create frequency array
		//ab har value ki frequency banayenge ki kon kitni bar appear hua
		for( int i=0; i< arr.length; i++) { //so b original array pe travel karke frequency array ko bharenge
			//kis index pe woh value badhawayega? jo arr[i] hai usmese min minus hoga, uss index pe woh frequency badhwayega
			int idx= arr[i]- min;
			//ab frequency array mai index wale spot pe jayenge aur usko ++ karenge
			farr[idx]++;
			//farr[arr[i]-min]++;
		}
		//iss step ke bad humare pas frequency aa chuki hogi
		
		//2. convert frequency array into prefixsum array
		//ab iss farr ko prefixsum mai convert kardenge
		//ab hum usko simple frequency ke hisab se chipka nhi skte instead hum frequency ko convert karke prefix sum array create karlenge
		for( int i=1; i< farr.length; i++) {
			//frquency array pe loop lagake iske har position ke andar usse pichle wala add kardenge
			farr[i]= farr[i] + farr[i-1]; 
		} // so mera prefix sum array mai convert hogya
		
		//3. travel from right to left in original array and fill answer array
		//ab mai array pe ulta loop lagaunga
		//pehle ek ans array banayenge woh bhi array jitne hi banega
		int ans[]= new int[arr.length];
		// ab ulta loop lagayenge
		for( int i=arr.length-1 ; i >=0 ; i--) {
			//ab meri ayegi value
			int val= arr[i]; //arr[i] mese value laayi
	
			// ab frequency array batayega usko kaha dala jaye, woh position batayega idex nhi batyaega
			int pos= farr[val - min]; //freqeuncy array mai jab usko value ko use karunga but hume pta hai woh sidhi use hoti nhi hai uss value se humesha min minus karna pdta hai
			//int pos= farr[arr[i]-min]; // varr[i] (last value) iss position pe aana chahta hai
			
			//so hume mil gyi position ab position pe nhi dump karenge answer ke andar, index se pos 1 minus hota hai
			int idx = pos- 1;
			//answer mai hum index pe receive karenge apni value
			ans[idx]= val;	
			
			//aur frequency array mai jo position hai woh kam karenge
			farr[val - min]--; // iss wali spot pe -- karde, means agli bar keliye position update
		}
		//hume orignal array ma hi change lana tha so usme wapas dal denge
		//ab answer mai loop lagakr original array mai dal denge
		for( int i=0; i< ans.length; i++) {
			arr[i]= ans[i];
		}
	}
	
	public static void countSort( int arr[],int min, int max) {
		
		int farr[]= new int[max- min +1];
		
		for( int i=0; i< arr.length; i++) {
			farr[arr[i]- min]++;
		}
		
		for( int i=1; i< farr.length; i++) {
			farr[i]= farr[i-1] + farr[i];
		}
		
		int ans[]= new int[arr.length];
		
		for( int i= arr.length-1; i>=0; i--) {
			int pos= farr[arr[i]- min];
			ans[pos-1]= arr[i];
			farr[arr[i] - min]--;
			
		}
		
		for( int i=0; i< arr.length; i++) {
			arr[i]= ans[i];
		}
	}

	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void main(String[] args) throws Exception {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
	    
		//sabse pehle array mese min and max nikal lenge
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
			max = Math.max(max, arr[i]);
			min = Math.min(min, arr[i]);
		}
		countSort(arr, min, max);
		print(arr);
	}
}
