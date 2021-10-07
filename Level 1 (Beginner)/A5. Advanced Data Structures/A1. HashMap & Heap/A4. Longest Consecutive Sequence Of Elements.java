Longest Consecutive Sequence Of Elements

1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing elements of array a.
3. You are required to print the longest sequence of consecutive elements in the array (ignoring duplicates).

Note -> In case there are two sequences of equal length (and they are also the longest), then print the one for which the starting point of which occurs first in the array.
Input Format
A number n
n1
n2
.. n number of elements
Output Format
Elements of longest sequence of consecutive elements of array in separate lines (ignoring duplicates)
Question Video

Constraints
1 <= n <= 30
0 <= n1, n2, .. n elements <= 15
Sample Input
17
12
5
1
2
10
2
13
7
11
8
9
11
8
9
5
6
11
Sample Output
5
6
7
8
9
10
11
12
13

Code:

import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    HashMap<Integer, Boolean> map = new HashMap<>();

    int n = scn.nextInt();
    int arr[] = new int[n];

    for ( int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
      map.put(arr[i] , true); //map mai dal denge and consider every element is a starting point of thesequence
    }

        //ab invalid starting points ko discard karenge
        for ( int i = 0; i < n; i++) {
      if ( map.containsKey(arr[i] - 1) == true) { //agar mere piche wali key present hai to mai starting point nhi ho skta so mere samne false rkhdo
        map.put(arr[i], false); //merse just chota number present hai to mai starting point nhi ho skta
      }
    }

    //ab hume apna answer banana hai
    int sp = 0; //starting point
    int maxlen = 0; //max length

    for ( int i = 0; i < arr.length; i++) {

      if (map.get(arr[i]) == true) { //agar merepe true pda hai to current starting point mai hu aur iski length hai 1
        int curr = arr[i];
        int len = 1;

        while (map.containsKey(curr + 1) == true) { //jabtak current+1 map mai milta rahega tabtak curr ko ek se aage badhate jao aur length kobhi badhao
          curr++;
          len++;
        }
        
        //jaisehi iss loop se bahar ayenge to muje pta hoga ki arr[i] starting point rakhte hue kitne length ka sequence mai bana paya 
        
        if(len > maxlen){ //aga uss starting point se jo sequence ban rha hai uski length maxlength se jada hui to maxlength ko aur sathmehi starting point ko update krdo 
            sp = arr[i];
            maxlen = len;
        }
      }
    }
    
    //so yahapr max length wala subsequence aajayega aur ab print kardenge
    for( int i=0; i< maxlen; i++){
            System.out.println(sp + i); 
    }
  }

}
