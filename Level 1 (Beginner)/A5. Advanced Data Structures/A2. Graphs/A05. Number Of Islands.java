Number Of Islands

1. You are given a 2d array where 0's represent land and 1's represent water. 
     Assume every cell is linked to it's north, east, west and south cell.
2. You are required to find and count the number of islands.
Input Format
Input has been managed for you
Output Format
Number of islands

Constraints
None
Sample Input
8
8
0 0 1 1 1 1 1 1
0 0 1 1 1 1 1 1
1 1 1 1 1 1 1 0
1 1 0 0 0 1 1 0
1 1 1 1 0 1 1 0
1 1 1 1 0 1 1 0
1 1 1 1 1 1 1 0
1 1 1 1 1 1 1 0
Sample Output
3

Code:

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int m = Integer.parseInt(br.readLine());
    int n = Integer.parseInt(br.readLine());
    int[][] arr = new int[m][n];

    for (int i = 0; i < arr.length; i++) {
      String parts = br.readLine();
      for (int j = 0; j < arr[0].length; j++) {
        arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
      }
    }

    boolean[][]visited = new boolean[arr.length][arr[0].length]; //1
    int islands = 0;
    for (int i = 0; i < arr.length; i++) {    //2
      for (int j = 0; j < arr[0].length; j++) {
        if (arr[i][j] == 0 && visited[i][j] == false) { //jaha jaha 0 present hai aur woh 0 unvisited hai getComponent ko call laga dunga
          getComp(arr, i, j, visited);
          islands++;
        }
      }
    }
    System.out.println(islands); //3

  }

  public static void getComp(int[][]arr, int i, int j, boolean[][]visited) {
    if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || arr[i][j] == 1 || visited[i][j] == true) { // agar i and j range ke bahar jate hai , yafir woh pehlese visited hai yafir wahape 1 pda hai to yahase laut jayenge
      return;
    }
    
    visited[i][j] = true; //source ko visited mark krdo
    // agala kam iske unvisited neighbour ko call lagado but maine bina dekhe aisehi 4 bhi neighbours ko call lagadi
    getComp(arr, i - 1, j, visited); 
    getComp(arr, i, j + 1, visited);
    getComp(arr, i, j - 1, visited);
    getComp(arr, i + 1, j, visited);
  }

}
