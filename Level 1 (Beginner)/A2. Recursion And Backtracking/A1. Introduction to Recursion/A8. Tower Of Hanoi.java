Tower Of Hanoi
1. There are 3 towers. Tower 1 has n disks, where n is a positive number. Tower 2 and 3 are empty.
2. The disks are increasingly placed in terms of size such that the smallest disk is on top and largest disk is at bottom.
3. You are required to 
    3.1. Print the instructions to move the disks.
    3.2. from tower 1 to tower 2 using tower 3 
    3.3. following the rules
        3.3.1 move 1 disk at a time.
        3.3.2 never place a smaller disk under a larger disk.
        3.3.3 you can only move a disk at the top.

Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is.Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.
Input Format
A number n, representing number of disks
A number n1, representing id of tower 1
A number n2, representing id of tower 2
A number n3, representing id of tower 3
Output Format
n[n1 -> n2] 
..
A set of instructions in above format to represent, move nth disc from n1 tower to n2 tower

Constraints
0 <= n <= 9
10 <= n1, n2, n3 <= 10^9
n1 != n2 != n3
Sample Input
3
10
11
12
Sample Output
1[10 -> 11]
2[10 -> 12]
1[11 -> 12]
3[10 -> 11]
1[12 -> 10]
2[12 -> 11]
1[10 -> 11]

Code:

package Recursion;

import java.util.Scanner;

public class TowerOfHanoi {
	
	public static void toh( int n, int t1id, int t3id, int t2id ) {
		if( n == 0) { //agar humare pas 0 disk bachi hai to hum kuch nhi karenge, koi bhi instruction print nhi karenge
			return;
		}
		
		toh(n-1, t1id, t3id, t2id); // will print the instructions to move n-1 disks from t1 to t3 using t2
		// jo ek bachi hogi disk usko hum khud move karke instructions print karlenge
		System.out.println(n+"["+t1id+" -> "+t2id+"]"); //nth ko humne t1 se t2 mai move kardiya
		toh( n-1, t3id, t2id, t1id); //ab jo humne 3rd tower mai dali thi unko ab nth ke upar means 2nd tower mai dal denge	
	}

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int n= s.nextInt(); // number of disks
		int t1d= s.nextInt(); // tower 1 ka nam
		int t2d= s.nextInt();
		int t3d= s.nextInt();
		toh(n, t1d, t2d, t3d);
		
	}

}
