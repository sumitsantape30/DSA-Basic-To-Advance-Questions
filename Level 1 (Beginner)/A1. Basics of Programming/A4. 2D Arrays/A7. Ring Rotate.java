Ring Rotate

You are given a n*m matrix where n are the number of rows and m are the number of columns. You are also given n*m numbers representing the elements of the matrix.
You will be given a ring number 's' representing the ring of the matrix. For details, refer to image.

shell-rotate

You will be given a number 'r' representing number of rotations in an anti-clockwise manner of the specified ring.
You are required to rotate the 's'th ring by 'r' rotations and display the rotated matrix.
Input Format
A number n
A number m
e11
e12..
e21
e22..
.. n * m number of elements of array a
A number s
A number r
Output Format
output is handled by display function

Constraints
1 <= n <= 10^2
1 <= m <= 10^2
-10^9 <= e11, e12, .. n * m elements <= 10^9
0 < s <= min(n, m) / 2
-10^9 <= r <= 10^9
Sample Input
5
7
11
12
13
14
15
16
17
21
22
23
24
25
26
27
31
32
33
34
35
36
37
41
42
43
44
45
46
47
51
52
53
54
55
56
57
2
3
Sample Output
11 12 13 14 15 16 17
21 25 26 36 46 45 27
31 24 33 34 35 44 37
41 23 22 32 42 43 47
51 52 53 54 55 56 57

 Code:

package TwoDArrays;

import java.util.Scanner;

public class shellRotate {
	
	public static int[][] takeInput(){
		
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int m= s.nextInt();
		
		int arr[][]= new int[n][m];
		
		for( int i=0; i< arr.length; i++) {
			for( int j= 0; j< arr[0].length; j++) {
				arr[i][j]= s.nextInt();
			}
		}
		return arr;
	}
	
	public static void rotateShell( int arr[][], int s, int r) {
		// so yaha 3 steps hai
		
		//first step is fill 1D array with shell, iss function mai hum 2D array aur shell pass karenge uske badle mai woh 1D array la dega
		int oned[]= fillOnedFromShell(arr, s);
		
		//ab hum rotate karenge 1D array ko
		rotate(oned, r);
		
		// first rotated 1D array se dubara shell bharlenge
		fillShellFromOneD(arr, s, oned); //isko input mai hume 2D array shell and 1D array dena pdega
	}
	
	// fillOnedFromShell and fillShellFromOneD keliye spiral display wala logic use hoga
	public static int[] fillOnedFromShell(int arr[][], int s) {
			int minr= s-1; // jo shell keliye min row hoga, jo humara top left hota hai min row and min column
		    int minc= s-1;
			//max row and max column
		    int maxr= arr.length-s;
		    int maxc= arr[0].length-s;
		    
		    //ab jaise hum spiral mai ek ek wall print krte the waise karenge but usse phele yeh dekhte hai ki humare array ka size kitna hoga
		    //hume minr minc and maxr maxc mil gya to 1D array ka size kitna hoga ? *open book and usme shell 2 dekho* usme 4 side ke 4bhi elements honge and koi bhi corner 2 times lena nhi
		    // shell size(sz)= lw + bt + rw + tp -4; 
		    // left wall ki length will be maxr - minr +1, left and right wall ki length same hogi isliye 2 times of length of left wall kiya and same with top and botton wall
		    // int sz= 2*(maxr- minr +1) + 2*(maxc - minc +1) -4 ; //isko aur simplify krte *pen paper se krke dekho you'll understand
		    int sz= 2 * (maxr- minr + maxc + minc);
		    
		    //apne pas ab size hai now we can declare our 1D array
		    int oned[]= new int[sz];
		    int idx=0;
		    
		    // ab spiral display karenge
		    //left wall pe chalna hai
		    for( int i= minr, j= minc; i<= maxr; i++) {
		    	//1D array mai uss shell ke elements ko dalenge
		    	oned[idx]=  arr[i][j];
		    	idx++;
		    }
		    
		    //bottom wall pe chalna hai
		    for( int i = maxr, j= minc+ 1; j <= maxc; j++) {
		    	oned[idx]= arr[i][j];
		    	idx++;
		    }
		    
		    //right wall pe chalna hai 
		    for( int i= maxr-1, j= maxc; i>= minr; i--) {
		    	oned[idx]= arr[i][j];
		    	idx++;
		    }
		    // top wall pe chalna hai
		    for( int j= maxc-1 , i= minr; j >= minc +1 ; j--) {  //maxc-1 se minc +1 tak jayenge coz first column already ho chuka hoga so minc+1 kiye
		    	oned[idx]= arr[i][j];
		    	idx++;
		    }
		    return oned;
		    
		}
	
	//rotate oneD array
	public static void rotate( int oned[], int r) { //input mai 1D array ayega and usko r rotation se rotate karna hai
		
		r= r % oned.length;
		if( r < 0) {
			r= r + oned.length; // agar r negative hai to usko positive banalo by adding arr.length
		}
		
		// part 1 reverse karenge
		reverse(oned, 0, oned.length-r-1);
		//fir part 2 reverse karenge
		reverse(oned, oned.length-r, oned.length-1);
		//fir pura reverse krdo
		reverse(oned,0 , oned.length-1);	
	}
	
	public static void reverse( int oned[], int li, int ri) {
		
		while( li < ri) {
			int temp= oned[li];
			oned[li]= oned[ri];
			oned[ri]= temp;
			li++;
			ri--;
		}
		
	}
	
	//rotate hone ke bad wapas firse shell mai dalne keliye same hi program hai with some changes
	// isme hume upar se 1D array mila hai isliye banake ki jarurat nhi hai aur size ki bhi jarurat nhi hai
	// aur direction badal jayegi arr[i][j] = oned[idx] hojayega
	public static void fillShellFromOneD(int arr[][], int s, int oned[]) {
		int minr= s-1;
		int minc= s-1;
		//max row and max column
	    int maxr= arr.length-s;
	    int maxc= arr[0].length-s;
	    
	     int sz= 2 * (maxr- minr + maxc + minc);
	    
	    int idx=0;
	    
	    for( int i= minr, j= minc; i<= maxr; i++) {
	    	arr[i][j]= oned[idx];
	    	idx++;
	    }
	    
	    //bottom wall pe chalna hai
	    for( int i = maxr, j= minc+ 1; j <= maxc; j++) {
	    	arr[i][j]= oned[idx];
	    	idx++;
	    }
	    
	    //right wall pe chalna hai 
	    for( int i= maxr-1, j= maxc; i>= minr; i--) {
	    	 arr[i][j]= oned[idx];
	    	idx++;
	    }
	    // top wall pe chalna hai
	    for( int j= maxc-1 , i= minr; j >= minc +1 ; j--) {  //maxc-1 se minc +1 tak jayenge coz first column already ho chuka hoga so minc+1 kiye
	        arr[i][j]= oned[idx];
	    	idx++;
	    }
	}
	
	 public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

	public static void main(String[] args) {

		Scanner scn= new Scanner(System.in);
		// pehle 2d array input lenge
		int arr[][]= takeInput();
		// then shell puchna padega, kis shell ko hum rotate karna chahte hai
		int s= scn.nextInt();
		// then aur kitne se rotate karna chahte hai yeh bhi puchenge
		int r= scn.nextInt();
		rotateShell(arr, s, r);
		display(arr);
		
	}

}
