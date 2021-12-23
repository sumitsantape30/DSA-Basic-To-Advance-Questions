Matrix Multiplication

1. You are given a number n1, representing the number of rows of 1st matrix.
2. You are given a number m1, representing the number of columns of 1st matrix.
3. You are given n1*m1 numbers, representing elements of 2d array a1.
4. You are given a number n2, representing the number of rows of 2nd matrix.
5. You are given a number m2, representing the number of columns of 2nd matrix.
6. You are given n2*m2 numbers, representing elements of 2d array a2.
7. If the two arrays representing two matrices of dimensions n1 * m1 and n2 * m2 can be multiplied, display the contents of prd array as specified in output Format.
8. If the two arrays can't be multiplied, print "Invalid input".
Input Format
A number n1
A number m1
e11
e12..
e21
e22..
.. n1 * m1 number of elements of array a1
A number n2
A number m2
e11'
e12'..
e21'
e22'..
.. n2 * m2 number of elements of array a2
Output Format
e11' e12' e13' ..
e21' e22' e23' ..
.. elements of prd array

Constraints
1 <= n1 <= 10^2
1 <= m1 <= 10^2
-10^9 <= e11, e12, .. n1 * m1 elements <= 10^9
1 <= n2 <= 10^2
1 <= m2 <= 10^2
-10^9 <= e11', e12', .. n2 * m2 elements <= 10^9
Sample Input
2
3
10
0
0
0
20
0
3
4
1
0
1
0
0
1
1
2
1
1
0
0
Sample Output
10 0 10 0
0 20 20 40
  
Code:

//================================================== Correct Solution=================================================

import java.io.*;
import java.util.*;

public class Main {


  public static void multiply( int one[][], int two[][]) {

    int r1 = one.length;
    int c1 = one[0].length;

    int r2 = two.length;
    int c2 = two[0].length;

    // pehle matrix ka column is not equal to rows of 2nd matrix to multiply ho hi nhi skta coz invalid input to invalid output deke khatam karenge means return karenge
    if ( c1 != r2) {
      System.out.println("Invalid input");
      return;
    }

    // otherwise hum ek product nam ki matrix banayenge and it's size will be pehle matrix ki rows + and second ke columns
    int prod[][] = new int[r1][c2];
    // ab mai product array pe loop chalaunga
    for ( int i = 0; i < prod.length; i++) {
      for ( int j = 0; j < prod[0].length; j++) {
        //ab hume product array ko fill krna hai
        for ( int k = 0; k < c1; k++) { //yeh k constant hai in both. And as c1 and r2 equal hai so yeh loop tabtak chalega
          prod[i][j] += one[i][k] * two[k][j]; // one ke andar row wahi rahegi and two ke andar row vary karegi and column wahi rahega
          // a21*b13 : so isme jab a mai 1 column hota hai to b mai 1 row hoti hai, a22*b23: isme jab a mai 2 column hota hai to b mai bhi 2 row hota hai so basically woh k hai
        }
      }
    }

    //ab print karenge yeh product array

    for ( int i = 0; i < prod.length; i++) {
      for ( int j = 0; j < prod[0].length; j++) {
        System.out.print(prod[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) throws Exception {
   
    Scanner s = new Scanner(System.in);
    int r1 = s.nextInt();
    int c1 = s.nextInt();

    int one[][] = new int[r1][c1];

    for ( int i = 0; i < one.length; i++) {
      for ( int j = 0; j < one[0].length; j++) {
        one[i][j] = s.nextInt();
      }
    }
    
    int r2 = s.nextInt();
    int c2 = s.nextInt();

    int two[][] = new int[r2][c2];

    for ( int i = 0; i < two.length; i++) {
      for ( int j = 0; j < two[0].length; j++) {
        two[i][j] = s.nextInt();
      }
    }
    
    multiply(one, two);
        
  }

}

//======================================================== Some error================================================
package TwoDArrays;

import java.util.Scanner;

public class MatrixMultiplication {
	
	public static int[][] takeInput(){
		
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int m= s.nextInt();
		
		int arr[][]= new int[n][m];
		
		for( int i=0; i< arr.length; i++) {
			for( int j=0; j< arr[0].length; j++) {
				arr[i][j]= s.nextInt();
			}
		}
		return arr;
	}
	
	public static void multiply( int one[][], int two[][]){
		
		int r1= one.length;
		int c1= one[0].length;
		
		int r2= two.length;
		int c2= two[0].length;
		
		// pehle matrix ka column is not equal to rows of 2nd matrix to multiply ho hi nhi skta coz invalid input to invalid output deke khatam karenge means return karenge
		if( c1 != r2) {
			System.out.println("Invalid input");
			return;
		}
		
		// otherwise hum ek product nam ki matrix banayenge and it's size will be pehle matrix ki rows + and second ke columns
		int prod[][]= new int[r1][c2];
		// ab mai product array pe loop chalaunga
		for( int i=0; i< prod.length; i++) {
			for( int j=0; j< prod[0].length; j++) {
				//ab hume product array ko fill krna hai
				for( int k=0; k< c1; k++) { //yeh k constant hai in both. And as c1 and r2 equal hai so yeh loop tabtak chalega
					prod[i][j] += one[i][k] * two[k][j]; // one ke andar row wahi rahegi and two ke andar row vary karegi and column wahi rahega
				   // a21*b13 : so isme jab a mai 1 column hota hai to b mai 1 row hoti hai, a22*b23: isme jab a mai 2 column hota hai to b mai bhi 2 row hota hai so basically woh k hai 
				}
			}
		}
		
		//ab print karenge yeh product array
		
		for( int i=0; i< prod.length; i++) {
			for( int j=0; j< prod[0].length; j++) {
				System.out.print(prod[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	
	
	public static void main(String[] args) {

		//pehla matrix input lenge
		int one[][]= takeInput();
		
		//dusra matrix
		int two[][]= takeInput();
		
		multiply(one, two);
		
	}

}
