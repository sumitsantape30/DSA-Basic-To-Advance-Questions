All Indices Of Array

1. You are given a number n, representing the count of elements.
2. You are given n numbers.
3. You are given a number x. 
4. You are required to find the all indices at which x occurs in array a.
5. Return an array of appropriate size which contains all indices at which x occurs in array a.

Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is. Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.
Input Format
A number n
n1
n2
.. n number of elements
A number x
Output Format
Return the array of indices from the allIndices function. Display is managed for you.

  COMMENTConstraints
1 <= n <= 10^4
0 <= n1, n2, .. n elements <= 10 ^ 3
0 <= x <= 10 ^ 3
Sample Input
6
15
11
40
4
4
9
4
Sample Output
3
4


Code:
package Recursion;

import java.util.Scanner;

public class AllIndices {
	
	public static int[] takeInput() {
		
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int arr[]= new int[n];
		
		for( int i=0; i< arr.length; i++) {
			arr[i]= s.nextInt();
		}
		return arr;
	}
	
	//jate hue bas yeh count karenge ki kitni bar yeh element exist krta hai 
	//aur wapas te hue array mai uski position fill karenge
	public static int[] allIndices( int arr[], int x, int idx, int fsf) {
		if( idx == arr.length) { // hum basecase pe pohoch gye means end mai so ab hum ek naya array banake return karenge
			return new int[fsf]; //found so far ki jitni value hogi utni size ka array banakr return kardenge
		}
		
		if( arr[idx]== x) { // agar equal hai to yeh wali call karenge
			// yeh jo values lake dega woh array mai receive karenge
			int iarr[]=allIndices(arr, x, idx+1, fsf +1); //index bhi badhega and found so far bhi badhega
		   // jo basecase mai array bana woh iski niche wale level means yaha return hua then iarr ne receive kiya usko
			//yeh iarr found so far ki jitni size hai usi size ka arry hai actually wahi array hai
			
			// jahape equal hai and jo answer recieve kiya hai usko directly return nhi karna pehle usme iarr mai fsf wali position ke upar index dalna hai aur fir hume iarr return karna hai
			iarr[fsf]= idx;
			return iarr;
		}else {
			int iarr[]= allIndices(arr, x, idx+1, fsf); // agar equal nhi hai to sirf index badhega fsf nhi badhege
		   //iss case mai bina kuch kare iarr return karna hai
		    return iarr;
		}
		//isme array sirf ek bar ban rha hai woh chota array sirf woh basecase mai bana hai jo nicheke levels hai use piche piche return kar rhe hai bas, woh as it is return kar rhe hai or value mai change karke return kr rhe hai
	}
	
	  public static int[] allIndices2(int[] arr, int x, int idx, int fsf) {
               if(idx == arr.length){
                  return new int[fsf];
               } 
        
               if(arr[idx] == x){
                    fsf++; 
               }
               int ans[] =  allIndices(arr, x, idx + 1, fsf);
        
               if(arr[idx] == x){
                    ans[fsf - 1] = idx;
               }
                return ans;
         }

	public static void main(String[] args) {

		int arr[]= takeInput();
		int result[]= allIndices(arr, 3, 0, 0);
		
		for( int i=0; i< result.length; i++) {
			System.out.println(result[i]);
		}
	}

}
