Crossword Puzzle

1. You are given a 10*10 2-D array(arr) containing only '+' and '-' characters, which represents a 
    crossword puzzle. 
2. You are also given n number of words which need to be filled into the crossword.
3. Cells containing '-' are to be filled with the given words.

Note -> Check out the question video and write the recursive code as it is intended without 
               changing signature. The judge can't force you but intends you to teach a concept.
Input Format
10 * 10 grid of characters containing only '+' and '-' 
A number n
str1
str2
...n strings
Output Format
Check the sample output and question video

Constraints
1 <= n <= 10
Sample Input
+-++++++++
+-++++++++
+-++++++++
+-----++++
+-+++-++++
+-+++-++++
+++++-++++
++------++
+++++-++++
+++++-++++
4
LONDON
DELHI 
ICELAND 
ANKARA
Sample Output
+L++++++++
+O++++++++
+N++++++++
+DELHI++++
+O+++C++++
+N+++E++++
+++++L++++
++ANKARA++
+++++N++++
+++++D++++

Code:

import java.io.*;
import java.util.*;

public class Main {

  public static void solution(char[][] arr, String[] words, int vidx) {
    if (vidx == words.length) { // aisa krte krte, agle agle words ko mauka dete dete, agar apka vidx words.length pr ajaye matlab apne sare words ko place krdiya hai to print and return
      print(arr);
      return;
    }

    String word = words[vidx]; // jis word ko yaha try kr rhe hai woh yeh word hai
    // ab us word ko kaha kaha dal ja skta hai: pure 2d array mai mai har spot pe usko try krne dunga ki sare tereliye possible options hai tu kahise bhi start kr skta hai agar woh box tere layak hai to. har spot pe horizontal vertical dono try karenge
    for ( int i = 0; i < arr.length; i++) {
      for ( int j = 0 ; j < arr.length; j++) {
        if ( arr[i][j] == '-' || arr[i][j] == word.charAt(0)) { // start karne keliye important hai ki iss spot pe dash pda ho ya apka pehle character pda ho
          if ( canPlaceWordHorizontally(arr, word, i, j)) { // agar mai horizontally place kr skta hu to horizontally place krdenge
            boolean[] wePlaced = placeWordHorizontally(arr, word, i, j); // array mai word ko place krde i,j spot pr
            //so mai put hogya ab merese agle word ko mauka dede
            solution(arr, words, vidx + 1);
            unplaceWordHorizontally(arr, wePlaced, i, j); // wapas aate hue unplace krdenge, ab unplace mai word pass karneki jarurat nhi hai wePlaced pass krdo, aur wePlaced ki help se hatado
            //so if you can place a word horizontally place it, solve it and then remove it
          }

          // aisahi if vertical keliye banega
          if (canPlaceWordVertically(arr, word, i, j)) { // kya aap vertically put kr skte hai
            boolean[] wePlaced = placeWordVertically(arr, word, i, j);
            solution(arr, words, vidx + 1);
            unplaceWordVertically(arr, wePlaced, i, j);
          }
          // kabhi kabhi ho skta hai koi word horizontally put ho skta hai aur vertically bhi put ho skta hai same spot pr isliye dono if alag rakkhe

        }
      }
    }
  }

  public static boolean canPlaceWordHorizontally( char[][] arr, String word, int i, int j) { // kya aap iss i,j spot pe word ko horizontally put kr skte hai yeh sawal hai
    // left and right side hai to mai + hona, yafir kuch bhi nhi hone perfect fix hona chahiye

    if ( j - 1 >= 0 && arr[i][j - 1] != '+') { // matalb agar apki left side hai aur apki left side ke upar + nhi kuch aur pda hai to return false
      return false;
    } else if ( j + word.length() < arr[0].length && arr[i][j + word.length()] != '+') { // agar right side mai yeh word board ke andar hai aur word ke just next spot ke upar + nhi pda to return false
      return false;
    }
    //agar aap perfect fit ho to loop chalayenge, yeh horizontally hai
    for ( int jj = 0; jj < word.length(); jj++) {

      if ( j + jj >= arr[0].length) { // agar yeh word horizontally board ke bahar nikal jaye matlab word put karneki jagah hi nhi hai to return false
        return false;
      }

      if ( arr[i][j + jj] == '-' || arr[i][j + jj] == word.charAt(jj)) { // agar dash pda hai or word ka wahi character pda hai
        continue; // aisa hua to chalte rahiye koi dikkat nhi
      } else {
        // agar aisa nhi hai to return false
        return false; // dash bhi nhi pda aur koi aisa character bhi nhi pda jo humare equal hai to return false
      }
    }

    return true;
  }

  public static boolean canPlaceWordVertically( char[][] arr, String word, int i, int j) {

    if ( i - 1 >= 0 && arr[i-1][j] != '+') { // column har jagah yahi rahega sirf row ko chedenge
      return false;
    } else if ( i + word.length() < arr[0].length && arr[i + word.length()][j] != '+') {
      return false;
    }
    for ( int ii = 0; ii < word.length(); ii++) {

      if ( i + ii >= arr.length) {
        return false;
      }

      if ( arr[i + ii][j] == '-' || arr[i + ii][j] == word.charAt(ii)) {
        continue;
      } else {
        return false;
      }
    }

    return true;

  }
  
  //put krte waqt hume sirf dhyan rakhna hai ki hum put kr rhe hai chracter ya pehlese pda tha
  public static boolean[] placeWordHorizontally(char[][] arr, String word, int i, int j){
      
      boolean wePlaced[] = new boolean[word.length()];// humne dala tha yeh character yeh btata hai
      
      for( int jj = 0; jj < word.length(); jj++){ // horizontally put karna hai 
          if( arr[i][j + jj] == '-'){ // dash pda hai matlab hume chracter dalna hai
            arr[i][j + jj] = word.charAt(jj); // charater ko place krde
            wePlaced[jj] = true; // true krde humne uss character ko dala
          }
      }
      
      return wePlaced; // yeh unplace mai kam ayega isliye return kar rhe
  }
  
  public static void unplaceWordHorizontally( char[][] arr, boolean[] wePlaced, int i, int j){
      //agar uss jagah pe placed hai to wahape - dal denge
      for( int jj = 0; jj < wePlaced.length; jj++){ 
          if( wePlaced[jj] == true){ // jj position pe agar true pda hai matlab humne dala tha yeh character
            arr[i][j + jj] = '-';
          } 
      }
  }
  
  public static boolean[] placeWordVertically(char[][] arr, String word, int i, int j){
      
      boolean wePlaced[] = new boolean[word.length()];
      
      for( int ii = 0; ii < word.length(); ii++){  // imse loop vertically lagega
          if( arr[i + ii][j] == '-'){ 
            arr[i + ii][j] = word.charAt(ii); 
            wePlaced[ii] = true; 
          }
      }
      
      return wePlaced; 
  }
  
  public static void unplaceWordVertically( char[][] arr, boolean[] wePlaced, int i, int j){
      for( int ii = 0; ii < wePlaced.length; ii++){ 
          if( wePlaced[ii] == true){ 
            arr[i + ii][j] = '-';
          } 
      }
  }
  

  public static void print(char[][] arr) {
    for (int i = 0 ; i < arr.length; i++) {
      for (int j = 0 ; j < arr.length; j++) {
        System.out.print(arr[i][j]);
      }
      System.out.println();
    }

  }
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    char[][] arr = new char[10][10];
    for (int i = 0 ; i < arr.length; i++) {
      String str = scn.next();
      arr[i] = str.toCharArray();
    }
    int n = scn.nextInt();
    String[] words = new String[n];
    for (int i = 0 ; i  < words.length; i++) {
      words[i] = scn.next();
    }
    solution(arr, words, 0);
  }
}
