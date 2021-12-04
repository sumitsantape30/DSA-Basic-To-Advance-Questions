Tug Of War

1. You are given an array of n integers.
2. You have to divide these n integers into 2 subsets such that the difference of sum of two subsets 
     is as minimum as possible.
3. If n is even, both set will contain exactly n/2 elements. If  is odd, one set will contain (n-1)/2 and 
    other set will contain (n+1)/2 elements.
3. If it is not possible to divide, then print "-1".

Note -> Check out the question video and write the recursive code as it is intended without 
               changing signature. The judge can't force you but intends you to teach a concept.
Input Format
A number n
n integers 
Output Format
Check the sample ouput and question video.

Constraints
1 <= n <= 20
1 <= arr[i] <= 100
Sample Input
6
1
2
3
4
5
6
Sample Output
[1, 3, 6] [2, 4, 5]

Code:
import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int[] arr = new int[scn.nextInt()];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = scn.nextInt();
    }
    solve(arr, 0, new ArrayList<>(), new ArrayList<>(), 0, 0);
    System.out.println(ans);
  }

  static int mindiff = Integer.MAX_VALUE;
  static String ans = "";

  public static void solve(int[] arr, int vidx, ArrayList<Integer> set1, ArrayList<Integer> set2, int soset1, int soset2) { // vids yeh represent krta hai ki pehle level pr arr[0] solve hoga dusre level pr arr[1] solve hoga so on. soset1: sum of set 1, soset2: sum of set 2
    
    if( vidx == arr.length){ // sabke faisle ho chuke hai
     //but muje sari seperations nhi print karni, muje woh seperation print karna hai jiska andar donoka gap minimum hoga
     int delta = Math.abs(soset1 - soset2);
     if(delta < mindiff){ //agar yeh delta mindiff se chota hai to min difference ko update krde ki naya mindifference mila hai
       mindiff = delta;
       ans = set1 + " " + set2;
     }
     return;
    }

    //mai use set1 mai add kr rha hu
    if (set1.size() < (arr.length + 1) / 2 ) { //addition tabhi possible hai jab set1 ka size chota hai (arr.length+1)/2 se, yeh wala check odd even donoko handle krta hai 
      set1.add(arr[vidx]);
      solve(arr, vidx + 1, set1, set2, soset1 + arr[vidx], soset2); // iss elements ko set mai daldiya to agle level keliye vidx + 1, set1 mai add kiya to sum of set1 (soset1_ mai arr[vidx] add kiya.
      set1.remove(set1.size() - 1); // aur wapas aate hue remove krdena chahiye, set1 mese aakhri element ko remove karliya jae
    }

    //dusri option hai ki set mai add krlo issko
    if (set2.size() < (arr.length + 1) / 2 ) {
      set2.add(arr[vidx]);
      solve(arr, vidx + 1, set1, set2, soset1, soset2 + arr[vidx]); // set2 ka sum badhega
      set2.remove(set2.size() - 1);
    }
  }

}
