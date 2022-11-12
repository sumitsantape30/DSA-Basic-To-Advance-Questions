Given a 9×9 incomplete sudoku, solve it such that it becomes valid sudoku. Valid sudoku has the following properties.

         1. All the rows should be filled with numbers(1 – 9) exactly once.

         2. All the columns should be filled with numbers(1 – 9) exactly once.

         3. Each 3×3 submatrix should be filled with numbers(1 – 9) exactly once.

Note: Character ‘.’ indicates empty cell.
  
Code:

import java.util.*;

class Solution {

  public static boolean solveSudoku(char[][] board) { //boolean return type isliye hai ki agar yeh current element out of 1-9 element ek bhi number agar koi cell pe safe nhi hai that's because iske previous empty cell mai jo number dala tha woh correct choice nhi thi so false return karenge otherwise true
    //traversing in the matrix, 9 bhi le skte ho or board.length;
     for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
               
        if (board[i][j] == '.') {//agar yeh cell empty hai to try out characters from 1 to 9

          for (char c = '1'; c <= '9'; c++) {
            if (isValid(board, i, j, c)) { //this character can only be placed if it is following the 3 rules
              board[i][j] = c;
              
              //so you filled one number and you made this recursion call
              if (solveSudoku(board))//yeh recursion call hoke next empty cell dhundneki koshish karega. aur agar uss next empty cell pe ek bhi number ko nhi bitha paye to return false or bitha paye to return true
                return true; //agar next empty cell mai ek character ko place karpaye to return true 
              else
                board[i][j] = '.';
            }
          }
          //current number placed krne ke bad next number keliye jo recursion call kiya tha usne false return kiya matlab humne current wala number galat place kiya hai so return false
          return false;
        }
      }
    }
    //true return krhe matlab humare current empty place pe ek safe number place hua hai out of 1-9
    return true;
  }

  public static boolean isValid(char[][] board, int row, int col, char c) {
    for (int i = 0; i < 9; i++) {
      if (board[i][col] == c) //pure column mai check karenge
        return false;

      if (board[row][i] == c) //pure row mai check karenge
        return false;

      if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) //3*3 ke matrix mai check karenge
        return false;
    }
    return true;
  }

  public static void main(String[] args) {

   char[][] board= {
                    {'9', '5', '7', '.', '1', '3', '.', '8', '4'},
                    {'4', '8', '3', '.', '5', '7', '1', '.', '6'},
                    {'.', '1', '2', '.', '4', '9', '5', '3', '7'},
                    {'1', '7', '.', '3', '.', '4', '9', '.', '2'},
                    {'5', '.', '4', '9', '7', '.', '3', '6', '.'},
                    {'3', '.', '9', '5', '.', '8', '7', '.', '1'},
                    {'8', '4', '5', '7', '9', '.', '6', '1', '3'},
                    {'.', '9', '1', '.', '3', '6', '.', '7', '5'},
                    {'7', '.', '6', '1', '8', '5', '4', '.', '9'}
                    };
    solveSudoku(board);

    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++)
        System.out.print(board[i][j] + " ");
      System.out.println();
    }
  }
}
Output:

9 5 7 6 1 3 2 8 4
4 8 3 2 5 7 1 9 6
6 1 2 8 4 9 5 3 7
1 7 8 3 6 4 9 5 2
5 2 4 9 7 1 3 6 8
3 6 9 5 2 8 7 4 1
8 4 5 7 9 2 6 1 3
2 9 1 4 3 6 8 7 5
7 3 6 1 8 5 4 2 9

Time Complexity: O(9(n ^ 2)), in the worst case, for each cell in the n2 board, we have 9 possible numbers.

Space Complexity: O(1), since we are refilling the given board itself, there is no extra space required, so constant space complexity.
