Utf - 8 Encoding

1. You are given an array of integers.
2. You are required to test whether the array represents a valid sequence of UTF-8 characters or 
     not.
3. A character in UTF-8 can be from 1 to 4 bytes long and follows some rules - 
       (i)  For 1-byte long character, first bit will be 0 and rest represents its unicode code.
       (ii) For n-bytes long character, first n-bits will be 1's, the n+1th bit is 0, followed by n-1 bytes 
             with most significant 2 bits being 10.

Note -> Only the least significant 8 bits of each element in array is used for data.
Note -> Check out the question video for details.
Input Format
A number N
arr1
arr2..
N numbers
Output Format
Check the sample output and question video.

  COMMENTConstraints
1 <= n <= 10^9
0 < a[i] <= 255
Sample Input
3
197
130
1
Sample Output
true

Code:

import java.io.*;
import java.util.*;

public class Main {

  public static boolean solution(int[] arr) {
    int rbytes = 0; // remaining bytes starting mai 0

    for ( int val : arr) {
      if ( rbytes == 0) { //agar remaining bytes khatam ho chuki hai to niche wale check lagayenge, khatam ho chuki hai means  yeh start of new character hai. jabtak remaining bytes hoti hai to yeh pichle number kohi continue kr rha hai

        //sabse pehle mai yeh check karunga, kya mera number 0 se begin hota hai, ya 110 se begin hota hai, ya 1110 se begin hota hai
        if ( (val >> 7) == 0b0) { // hume input mai integers mile hai to woh hote hai 32 bits ka  to upar 24 bit sabki 0 hai yeh assume karo sirf last byte means last 8 bits mai hi data hai. so usko 7 bar move karo aur dekho ki woh binary ke 1 ke equal hogya ki nhi.
          //1st byte of 1 length char

          rbytes = 0; //1 length ka char tha aur uski pehli byte hai to remaining bytes 0 hi rahengi

        } else if ( (val >> 5) == 0b110 ) { // agar mai value ko 5 bar move karu aur move karne pe muje binary ka 110 mile, to yeh 2 byte ka character yahase start ho rha hai. 1st byte of 2 length char

          rbytes = 1; // 2 length ka char hai aur apne pehli byte dekhi hai to remaining bytes 1 hojayengi

        } else if ( (val >> 4) == 0b1110 ) { // agar move krne ke bad apko mila binary ka 1110 to tum valid ho. 1st byte of 3 length char

          rbytes = 2;//yaha 3 length ka char hai aur pehli bye yeh thi to 2 bytes aur reh jayengi

        } else if ( (val >> 3) == 0b11110 ) { // ab mai usko sirf 3 bar move karunga, 3 bar move karne ke bad maine dekha 0b11110 tobhi tum valid ho. 1st byte of 4 length char

          rbytes = 3;//4 length ka char hai aur yeh pehli byte hai to abhi 3 bytes aur bachi hai
        }
      } else { // agar remaining bytes bachi hui hai

        if (( val >> 6) == 0b10) { // remaining bytes bachi hui hoti hai to aisa hona chahiye, agar aisa hai to rbytes-- karenge ki ek byte aur thik hogyi
          rbytes--;
        } else {
          //aur agar aisa nhi hai to return false
          return false;
        }
      }
    }

    //special case: agar remaining bytes 0 aayi hai to matlab jo last start hua tha woh pura hogya andar, usko pura check krke aa rhe hai
    if ( rbytes == 0) {
      return true;
    } else {
      //agar kuch byte reh gyi hai to reurn false
      return false;
    }

  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0 ; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    System.out.println(solution(arr));
  }

}
