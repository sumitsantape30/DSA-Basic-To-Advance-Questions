
//============================== Brute Force==========================
import java.util.*;
class TUF {
    static int[][] rotate(int[][] matrix) {
        int n = matrix.length;
        int rotated[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][n - i - 1] = matrix[i][j]; //rotated[j] as a row kam kr rha hai aur n-1-i column no, sabse last column mai dalega so on
            }
        }
        return rotated;
    }

    public static void main(String args[]) {
        int arr[][] =  {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int rotated[][] = rotate(arr);
        System.out.println("Rotated Image");
        for (int i = 0; i < rotated.length; i++) {
            for (int j = 0; j < rotated.length; j++) {
                System.out.print(rotated[i][j] + " ");
            }
            System.out.println();
        }

    }
}


//========================Optimal====================================
class Solution {
    public void rotate(int[][] matrix) {
        
        for( int i=0; i< matrix.length; i++){
            for( int j=0; j<= i; j++){
                int temp= matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        int left= 0;
        int right= matrix[0].length-1;
        
        while( left < right){
            
            for( int row= 0; row < matrix[0].length; row++){
                
                int temp= matrix[row][left];
                matrix[row][left] = matrix[row][right];
                matrix[row][right] = temp;
            }
            
            left++;
            right--;
            
        }  
    }
}
