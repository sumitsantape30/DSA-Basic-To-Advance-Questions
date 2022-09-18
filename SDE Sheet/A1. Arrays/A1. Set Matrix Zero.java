package Codes;

import java.util.*;
import java.io.*;

public class Codes {
	
        //Brute Force
	static void setZeroes(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {

                	//setting entire row, yeh spot agar 0 hai to iss spot ke upper side wale elements ko -1 set krhe
                    int ind = i - 1;
                    while (ind >= 0) {

                        if (matrix[ind][j] != 0) {
                            matrix[ind][j] = -1;
                        }
                        ind--;
                    }
                    
                    //same column mai spot ke  niche wale elements ko -1 set krhee
                    ind = i + 1;
                    while (ind < rows) {
                        if (matrix[ind][j] != 0) {
                            matrix[ind][j] = -1;
                        }
                        ind++;
                    }
                    
                    //same row mai spot ke  left side wale elements ko -1 set krhee
                    ind = j - 1;
                    while (ind >= 0) {
                        if (matrix[i][ind] != 0) {
                            matrix[i][ind] = -1;

                        }
                        ind--;
                    }
                    
                    //same row ke spot ke right side wale elements ko -1 set krhe
                    ind = j + 1;
                    while (ind < cols) {
                        if (matrix[i][ind] != 0) {
                            matrix[i][ind] = -1;

                        }
                        ind++;
                    }
                    
                }
            }
        }
        //fir jaha jaha -1 rakha the waha 0 kr denge
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] <= 0) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
	
	//optimized approach
	static void setZeroes2(int [][] matrix) {
		  int rows = matrix.length, cols = matrix[0].length;
		  int dummy1[]=new int[rows];
		  int dummy2[]=new int[cols];
		  Arrays.fill(dummy1,-1);
		  Arrays.fill(dummy2,-1);
		  for (int i = 0; i < rows; i++) {
		    for (int j = 0; j < cols; j++) {
		      if (matrix[i][j] == 0) {
		        dummy1[i] = 0;
		        dummy2[j] = 0;
		      }
		    }

		  }
		  
		  for (int i = 0; i < rows; i++) {
		    for (int j = 0; j < cols; j++) {
		      if (dummy1[i] == 0 || dummy2[j]==0) {
		          matrix[i][j] = 0;
		      }
		    }
		  }
	}

	public static void main(String[] args) {
		int arr[][] = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroes(arr);
        System.out.println("The Final Matrix is ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}

