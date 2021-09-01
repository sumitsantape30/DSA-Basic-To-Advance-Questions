Sliding Window Maximum
Hard  Prev   Next
1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing the elements of array a.
3. You are given a number k, representing the size of window.
4. You are required to find and print the maximum element in every window of size k.

e.g.
for the array [2 9 3 8 1 7 12 6 14 4 32 0 7 19 8 12 6] and k = 4, the answer is [9 9 8 12 12 14 14 32 32 32 32 19 19 19]
Input Format
Input is managed for you
Output Format
Maximum of each window in separate line

code:

package Stack;

import java.util.Scanner;
import java.util.Stack;

public class SlidingWindowMaximum {
	
	public static int[] takeInput() {
		
		Scanner s=new Scanner(System.in);
		int n= s.nextInt();
		int arr[]= new int[n];
		
		for( int i=0; i< arr.length; i++) {
			arr[i]= s.nextInt();
		}
		return arr;
	}
	
	public static void slidingWindowMax(int arr[], int k) {
		Stack<Integer> st= new Stack<Integer>();
		int nge[]= new int[arr.length];
		
		st.push(arr.length-1);
		nge[arr.length-1]= arr.length;
		
		for( int i= arr.length-2; i >= 0; i--) {
			
			while(st.size() > 0 && arr[i] > arr[st.peek()]) {
				 st.pop();
			}
			
			if( st.size() == 0) {
				nge[i]= arr.length;
			}else {
				nge[i]=  st.peek();
			}
			st.push(i);
		}
		
		//i se start hone wali 4 element ke window ka max nikalna yeh humara kam hoga aur j hai jo i ki help karega max nikalne ke andar
		int j=0;
		for( int i= 0; i<= arr.length-k; i++) {
			// enter the loop to find the maximum of window starting at i (i pe jo window start ho rhi hai uska maxi nikalne keliye iss loop mai enter kariye)
			// arr.length-k tak kyu chalaya? taki last window tak hi chale isliye, i ko aur aage le jane ki jarurat nai hai
			
			if( j < i) {
				//agar j na badh paye aur j i se piche reh jaye tab j ko i ke barabr karlo
				j=i;
			} //ab barabr aane ke bad woh apna next grater walagame khelega
			
			// agar mera yeh neext greater element range ke andar hai to yahi meraanswer hai
			while( nge[j] < i+k) { //agar jo next greater hai j ka woh window ke andar hai to aap next greater pe jate rahiye uchal uchal ke
				j = nge[j]; 
			} 
			
			//kabtak window ke end point se chota hai tabtak aap jump karke jate jaiye aur last mai jab aap nikalenge to window ke apke bahar hoga to bahar nikalkar print krdo
			System.out.println(arr[j]);
		}
	} // yeh O(n*k) hai
	
	//JB's : yeh O(n)
	public static void slidingWindowMaxJB(int arr[], int k) {
		
		Deque<Integer> dq= new ArrayDeque<>(); //double ended queue le lenge
		
		for( int i=0; i< k; i++) { //pehle k elements keliye alag se kam hoga
			// first k elements keliye kya karenge? next grater wali approch, apne se chote bando ko pop karao
			
			while(dq.size() > 0 && arr[dq.peek()] < arr[i]) { //jabtak dq size > 0 hai aur jabtak current elements se chote elements milte rahenge tabtak last element pop krte rho
				dq.removeLast();
			}
			//fir current index ko dq ke last mai add krdo
			dq.add(i);	
		}
		
		//so pehle k bando ka maxm aachuka hai print krdo
		System.out.println(arr[dq.peek()]);
		
		//ab k se aage wale elements ki kahanai
		for( int i=k; i < arr.length; i++) {
			while(dq.size() > 0 && arr[dq.peek()] < arr[i]) { 
				dq.removeLast();
			}
			dq.addLast(i);
			
			if(dq.peek() <= i-k) {
				dq.removeFirst();
			}
			System.out.println(arr[dq.peek()]);
		}
		
	}

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		int arr[]= takeInput();
		int k= s.nextInt();
		slidingWindowMax(arr, k);
		
	}

}

