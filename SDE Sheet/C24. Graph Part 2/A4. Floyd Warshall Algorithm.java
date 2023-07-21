Problem Statement: The problem is to find the shortest distances between every pair of vertices in a given edge-weighted directed graph. The graph is represented as an adjacency matrix of size n*n. Matrix[i][j] denotes the weight of the edge from i to j. If Matrix[i][j]=-1, it means there is no edge from i to j.

Do it in place.

Example 1:

Input Format: 
matrix[][] = { {0, 2, -1, -1},
        {1, 0, 3, -1},{-1, -1, 0, -1},{3, 5, 4, 0} }

Result:
0 2 5 -1 
1 0 3 -1 
-1 -1 0 -1 
3 5 4 0 
Explanation: In this example, the final matrix 
is storing the shortest distances. For example, matrix[i][j] is 
storing the shortest distance from node i to j.
Example 2:

Input Format: 
matrix[][] = {{0,25},
              {-1,0}}

Result:   
0 25  
-1 0﻿
Explanation: In this example, the shortest distance 
is already given (if it exists).

Code:

package Codes;

import java.util.*;
import java.io.*;

public class ques {
	
	//here you have to update the input matrix with shortesh path instead of creating a new cost matrix
    public static void shortest_distance(int[][] matrix) {
    	
    	 int n = matrix.length;
         for (int i = 0; i < n; i++) {
             for (int j = 0; j < n; j++) {
                 if (matrix[i][j] == -1) { //agar woh spot -1 hai means its not possible to reach it so waha infinity dal denge
                     matrix[i][j] = (int)(1e9);
                 }
                 if (i == j) matrix[i][j] = 0; //diagonal hai to usi node se ussi node pe jane ki cost 0 hogi
             }
         }//return krne se pehle bhi yahi kam karenge tab bas check karenge ki cost nikalne ke bad bhi infinity hai to usme -1 dal denge
         

         for (int k = 0; k < n; k++) { //this is my via
             for (int i = 0; i < n; i++) {
                 for (int j = 0; j < n; j++) {
                     matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]); //previous walese compare karenge new wala nikalke donomese minumum uss spot ka answer hoga
                 }
             }
         }
         
         //if interviewer say ki negative cycle hai to yeh likhna
      /*   for( int i=0; i < n; i++) {
        	 if( matrix[i][i] < 0) {
        		 System.out.println("Have negative cycle");
        		 return;
        	 }
         } */

         for (int i = 0; i < n; i++) {
             for (int j = 0; j < n; j++) {
                 if (matrix[i][j] == (int)(1e9)) {
                     matrix[i][j] = -1;
                 }
             }
         }

    	
    	
    }

	public static void main(String[] args) {

		 int V = 4;
	        int[][] matrix = new int[V][V];

	        for (int i = 0; i < V; i++) {
	            for (int j = 0; j < V; j++) {
	                matrix[i][j] = -1;
	            }
	        }

	        matrix[0][1] = 2;
	        matrix[1][0] = 1;
	        matrix[1][2] = 3;
	        matrix[3][0] = 3;
	        matrix[3][1] = 5;
	        matrix[3][2] = 4;

	        shortest_distance(matrix);

	        for (int i = 0; i < V; i++) {
	            for (int j = 0; j < V; j++) {
	                System.out.print(matrix[i][j] + " ");
	            }
	            System.out.println("");
	        }
	    }
}

Output:

0 2 5 -1 
1 0 3 -1 
-1 -1 0 -1 
3 5 4 0 
