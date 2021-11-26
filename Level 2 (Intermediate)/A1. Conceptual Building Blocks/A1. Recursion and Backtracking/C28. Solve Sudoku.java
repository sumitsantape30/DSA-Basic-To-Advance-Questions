Solve Sudoku

1. You are give a partially filled 9*9 2-D array(arr) which represents an incomplete sudoku state.
2. You are required to assign the digits from 1 to 9 to the empty cells following some rules.
Rule 1 -> Digits from 1-9 must occur exactly once in each row.
Rule 2 -> Digits from 1-9 must occur exactly once in each column.
Rule 3 -> Digits from 1-9 must occur exactly once in each 3x3 sub-array of the given 2D array.

Assumption -> The given Sudoku puzzle will have a single unique solution.
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
    
  public static void display(int[][] board){
    for(int i = 0; i < board.length; i++){
      for(int j = 0; j < board[0].length; j++){
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void solveSudoku(int[][] board, int i, int j) {
      if( i == board.length){ //aur agar aise put krte krte i agar arr.length pe pohoch jaye means aap sabkuch put krke aaye ho to display karo and return
          display(board);
          return;
      }
      
     //pehle muje chinta hai mera next cell kaha hoga
     int ni = 0; // ni: next i
     int nj = 0; // nj: next j
     // agale level keliye agli call lagani hai to next cell apko chahiye hi
     
     if( j == board[0].length -1){ // agar apka j extreme column mai hai 
         ni = i + 1; // extreme column pr hai to next row ka i hoga i+1
         nj = 0; // aur next j hoga 0
     }else{ // aur agar woh non extreme hai, agar aap aakhri column mai nhi hai 
        ni = i ; // to row wahi rahegi
        nj = j + 1; // aur column badh jayega
     }
     
     //ab kya wahapr pehlese value pdi hai
     if( board[i][j] != 0){ // agaar us spot pe non zero value pdi hai to there's nothing to do, yahapr kuch nhi karna upar ke level pr jayenge
       solveSudoku(board, ni, nj); // ki iss spot pe pehlese non zero value pdi hai to jo pehlese pda hai usko hum na uda skte hai na badal skte hai bas aage ja skte hai to agle box ki call lagade
     }else{ // agar wahape 0 pda hai 
       for( int po= 1; po <= 9; po++){ //possible options hai yeh real options nhi hai ab tumhe check karna hoga ki yeh possible options sahi hai ya nhi
         if(isValid(board, i, j, po) == true){ // board ke iss i,j spot pe kya mai yeh possible value dal skta hu ya nhi dal skta yeh check karhe
              // agar yeh valid hai to board ke iss spot mai yeh possible option nam ka word dal de aur agle box ko call lagade
              board[i][j] = po;
              solveSudoku(board, ni, nj);
              board[i][j] = 0; // aur backtrack krte waqt jo apne dala tha usko undo krde
         }
       }
     }
  }
  
  public static boolean isValid( int[][] board, int x, int y, int val){ // x,y iss spot pe yeh val valid hai ya nhi hai yeh check karenge
    
    //pehle mai check krta hu puri row mai
    for( int j = 0; j < board[0].length; j++){ // row mai columns change honge row fixed rahegi, jo mai val dalna chahta hu woh kahi pehlese dali hui to nhi hai iss row mai
       if( board[x][j] == val){ // x row ke sare columns dekh liye ki kahi yeh value pehlese padi to nhi hai
           return false; // agar pehlese pdi hai to return false
       }
    } // so apni row ke sare columns check karliye ki kahi yeh pehlese to pdi nhi hai
      
      //ab apne column ke sari row check karunga, column apna y hi rahega
      for( int i=0 ; i< board.length; i++){
          if( board[i][y] == val){ // apne column ki sari rows dekhunga ki kahi yeh value pehlese to pdi nhi hai
            return false;
          }
      }
      
      //ab apko check krna hai kahi submatrix mai to nhi pda
      int smi = x / 3 * 3; // submatrix ka i
      int smj = y / 3 * 3; // submatrix ka j
      //ab wahase 3 ka loop chalana hai, 3X3 ka box hai
      for(int i = 0; i < 3 ; i++){
          for( int j = 0 ; j< 3; j++){
              if( board[smi + i][smj + j] == val){ //agar isme valud pdi hai to return false
                  return false;
              }
          }
      }
      
      return true; // agar upar wala false return nhi hota hai to return true
      
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int[][] arr = new int[9][9];
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        arr[i][j] = scn.nextInt();
      }
    }

    solveSudoku(arr, 0, 0);
  }
}
