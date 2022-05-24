Next Greater Element To The Right

1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing elements of array a.
3. You are required to "next greater element on the right" for all elements of array
4. Input and output is handled for you.

"Next greater element on the right" of an element x is defined as the first element to right of x having value greater than x.
Note -> If an element does not have any element on it's right side greater than it, consider -1 as it's "next greater element on right"
e.g.
for the array [2 5 9 3 1 12 6 8 7]
Next greater for 2 is 5
Next greater for 5 is 9
Next greater for 9 is 12
Next greater for 3 is 12
Next greater for 1 is 12
Next greater for 12 is -1
Next greater for 6 is 8
Next greater for 8 is -1
Next greater for 7 is -1
Input Format
Input is managed for you
Output Format
Output is managed for you

Constraints
0 <= n < 10^5
-10^9 <= a[i] <= 10^9
Sample Input
5
5
3
8
-2
7
Sample Output
8
8
-1
7
-1

Code:

package Stack;

import java.util.Scanner;
import java.util.Stack;

public class nextGeneratorElement {

	public static int[] takeInput() {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int[n];
		
		for( int i=0; i< arr.length; i++) {
			arr[i]= s.nextInt();
		}
		return arr;
	}
	
	public static int[] solve( int arr[]) {
		
		// arr ki size kahi ek array banayenge 
		int nge[]= new int[arr.length]; //next greater element
		
		Stack<Integer> st= new Stack<Integer>();
		
		//last element ko push kara denge aur usme ans -1 dal denge ki last element ka next grater hota nhi
		st.push(arr[arr.length-1]);
		
		nge[arr.length-1]= -1; // nge[arr.length-1]= arr.length bhi le skte ho
		
		// i= arr.length-1 ; i>=0; i-- sebhi loop chala skte ho
		// ab last 2nd element se ulta loop chalega
		for( int i= arr.length-2; i>=0; i-- ) {
			//har element keliye 3 bate hai pop, answer, push
			
			//pop all smaller elements
			while( st.size()>0 && arr[i] >= st.peek() ) { //tabtak pop karenge jabtak stack ki size 0 na hojoaye aur jo arr[i] hai woh stack ke peek se bda hai or equal hai
				st.pop(); 
			} //jaise size 0 hogyi or stack ki top pe koi bada elements aagya to iss loop ke bahar ajayenge
			
			//update ans
			//bahar aaye hai to 2 bate ho skti hai ya to stack khali hogyi hai 
			if( st.size() == 0) { //agar stack khali hogyi hai to isne sabko pop kara diya matlab sabse bda yeh hai
				// to uss case mai next greater element is -1
				nge[i]= -1;
			}else {
				// dusri bat yeh ho skti hai ki yeh bahar tab aya jab stack ke top pe koi isse bda agya to uss case mai jo stack ka top hai wahi iska ans hai
				nge[i]= st.peek();
			}
			
			//aur jate jate yeh khud ko stack mai push krdega
			st.push(arr[i]); //push current element in the stack
			
		}
		
		return nge;// last mai ussi array ko return kardenge
		
	}
	
	public static void print(int arr[]) {
		
		for( int i=0; i< arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void main(String[] args) {

		int arr[]= takeInput();
		int ans[]= solve(arr);
		print(ans);
	}
}

Analysis: 

Time Complexity:
O(n)

5. Space Complexity:
O(n)
