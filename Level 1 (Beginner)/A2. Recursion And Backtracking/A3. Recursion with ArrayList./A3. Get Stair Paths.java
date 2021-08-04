Get Stair Paths
1. You are given a number n representing number of stairs in a staircase.
2. You are standing at the bottom of staircase. You are allowed to climb 1 step, 2 steps or 3 steps in one move.
3. Complete the body of getStairPaths function - without changing signature - to get the list of all paths that can be used to climb the staircase up.
Use sample input and output to take idea about output.

Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is. Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.
Input Format
A number n
Output Format
Contents of the arraylist containing paths as shown in sample output

Constraints
0 <= n <= 10
Sample Input
3
Sample Output
[111, 12, 21, 3]

Code:

package Recursion;

import java.util.ArrayList;

import java.util.Scanner;

public class getStairsPath {
	
	//isse yeh expectation hai ki yeh n se 0 tak sare paths batayega
	// n stairs utarne/chadhane ke sare tarike lake dega
	public static ArrayList<String> getStairPaths( int n){
		
		// positive basecase
		if( n == 0) { // 0 th stair se 0 pe jane ka ek rasta hota hai ki chalo hi mat
			ArrayList<String> bres= new ArrayList<String>();
			bres.add(""); // chalohi mat khade rho coz you are already there
			return bres;
		}else if( n < 0) { // negative basecase. hum aur niche nhi ja skte isse ground ke niche
			// -2(jamin ke andar) se 0 tak jane ka koi rasta nhi hai coz hum bas niche ki taraf hi jump laga skte hai upar ki taraf jump hi nhi laga skte
			// so agar negative hogya to iss case mai arraylist khali rakhenge arraylist mai kuch bhi path add nhi karenge
			ArrayList<String> bres= new ArrayList<String>(); 
			return bres;
		}
		
		//yeh pehla faith hai
		ArrayList<String> rr1 = getStairPaths(n-1); // yahapr yeh faith hai ki yeh line n-1 se 0 ke saare paths apko nikalkar de degi
		ArrayList<String> rr2 = getStairPaths(n-2); // yeh n-2 se 0 tak sare paths de dega
		ArrayList<String> rr3 = getStairPaths(n-3); // yeh n-3 se 0 tak sare paths de dega
		
		// hume n se 0 tak sare paths chahiye
		ArrayList<String> mr = new ArrayList<String>();

		// 6 to 0 ke paths ko agar upgrade karke 7 se 0 ka path banana hai to uske muh pe 1 laga denge
		for( String path: rr1 ) { // recursion result mai 1 chipkake apne answer mai add kardo
			mr.add(1 + path);
		}
		
		//isis tarah agar n-2 se 0 ke sare path dikhaye aur unke muh pr hum 2 lagade to woh n se 0 ke path ban jayenge
		for( String path: rr2 ) {
			mr.add(2 + path);
		}
		
		// isi tarah agar tum muje n-3 se 0 ke sare path dikhao aur unke muh pr hum 3 lagade to woh bhi n-3 ke 0 ke path ban jayenge
		for( String path: rr3 ) {
			mr.add(3 + path);
		}
		
//		for( int i=0; i< rr1.size(); i++) {
//			mr.add("1"+rr1.get(i));
//		}
//		
//		for( int i=0; i< rr2.size(); i++) {
//			mr.add("2"+rr2.get(i));
//		}
//		
//		for( int i=0; i< rr3.size(); i++) {
//			mr.add("3"+rr3.get(i));
//		}
		
		return mr;
	}

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int n= s.nextInt(); //You are given a number n representing number of stairs in a staircase.
		ArrayList<String> paths= getStairPaths(n);
		System.out.println(paths);
	}

}
