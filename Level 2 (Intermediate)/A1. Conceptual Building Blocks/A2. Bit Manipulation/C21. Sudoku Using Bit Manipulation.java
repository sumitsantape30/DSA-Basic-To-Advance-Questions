Sudoku Using Bit Manipulation

1. You are give a partially filled 9*9 2-D array(arr) which represents an incomplete sudoku state.
2. You are required to assign the digits from 1 to 9 to the empty cells following some rules.
Rule 1 -> Digits from 1-9 must occur exactly once in each row.
Rule 2 -> Digits from 1-9 must occur exactly once in each column.
Rule 3 -> Digits from 1-9 must occur exactly once in each 3x3 sub-array of the given 2D array.

Assumption -> The given Sudoku puzzle will have a single unique solution.
Note -> You have to Solve this problem using bits.
Input Format
9*9 integers ranging from 1 to 9.
0 represents an empty cell.
Output Format
You have to print the solved sudoku. 

Constraints
0 <= arr[i][j] <= 9
Sample Input
3 0 6 5 0 8 4 0 0
5 2 0 0 0 0 0 0 0
0 8 7 0 0 0 0 3 1
0 0 3 0 1 0 0 8 0
9 0 0 8 6 3 0 0 5
0 5 0 0 9 0 6 0 0
1 3 0 0 0 0 2 5 0
0 0 0 0 0 0 0 7 4
0 0 5 2 0 6 3 0 0
Sample Output
3 1 6 5 7 8 4 9 2 
5 2 9 1 3 4 7 6 8 
4 8 7 6 2 9 5 3 1 
2 6 3 4 1 5 9 8 7 
9 7 4 8 6 3 1 2 5 
8 5 1 7 9 2 6 4 3 
1 3 8 9 4 7 2 5 6 
6 9 2 3 5 1 8 7 4 
7 4 5 2 8 6 3 1 9 

Code:

// import java.io.*;
import java.util.*;

public class Main {

  public static void display(int[][] arr){
    for (int ii = 0; ii < arr.length; ii++) {
      for (int jj = 0; jj < arr.length; jj++) {
        System.out.print(arr[ii][jj] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

  public static void solveSudoku(int[][] arr, int[] rows, int[] cols, int[][] grid, int i, int j) { // abhi mujhe i aur j spot diya hua hai
    //basecase: last cell visit karne ke bad  
     if( i == arr.length){ 
         display(arr);
         return;
     }
  
      if( arr[i][j] > 0){ //agar woh already bhara hua hai matlab waha 0 nhi pda hai then I can't make call to the next spot
         solveSudoku(arr, rows, cols, grid, j == arr[0].length -1 ? i + 1: i, j == arr[0].length -1 ? 0: j + 1); // array yahi rahega, row and col array ko aap touch nhi kar paoge, aur grid ko bhi kuch nhi kr paoge, aur agar apka j arr[0].length-1 (8) hua means j ki maximum value hui to row badh jayegi warna row wahi rahegi. agar j apni maximum pe hua matlab apni row ka woh aakhri column hai to woh badh nhi skta 0 hojayega warna woh badh jayega
      }else{
          for( int num = 1; num <= 9; num++){ // jo number mai koshish kr skta hu woh 1 to 9 ho skte hai lekin jaruri hai ki woh numbers ki corresponding bits off honi chahiye
           if(
             (rows[i] & (1 << num)) == 0 && // AND karke you must get a 0 ki row[i] ke andar numth bit off hai 
             (cols[j] & (1 << num)) == 0 && // aisa hua to cols[j] ke andar numth bit off hai
             (grid[i / 3][j / 3] & (1 << num)) == 0 
             
             ){ // so yeh teeno hume 0 milte hai to hum iss number ko koshish kr skte hai 
               arr[i][j] = num; // arr[i][j] mai yeh number dalkar aap call laga skte hai
               rows[i] ^= (1 << num);  //hume ab woh bit on karni hogi to mai toggle operation use karunga bit ko on karne keliye
               cols[j] ^= (1 << num); // isme bhi toggle karke on kardenge
               grid[i / 3][j / 3] ^= (1 << num); 
               solveSudoku(arr, rows, cols, grid, j == arr[0].length -1 ? i+1: i, j == arr[0].length - 1? 0: j + 1);
               grid[i / 3][j / 3] ^= (1 << num); 
               cols[j] ^= (1 << num); // wapas aate hue off krdo
               rows[i] ^= (1 << num); // wapas aate hue toggle karenge to off hojayegi
               arr[i][j] = 0; // num dala, call lagadi, aur ab number ko hata denge
             }
          }
      }
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int[][] arr = new int[9][9];
    int[] rows = new int[9];
    int[] cols = new int[9];
    int[][] grid = new int[3][3];

    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        int digit = scn.nextInt();
        arr[i][j] = digit;
        rows[i] |= (1 << digit);
        cols[j] |= (1 << digit);
        grid[i / 3][j / 3] |= (1 << digit);
        //initially row, columns and grid ke andr jo bits set honi chahiye woh set karke di hai 
      }
    }

    solveSudoku(arr, rows, cols, grid, 0, 0);
  }

}
