Find Anagram Mappings

1. You are given two integer arrays(A and B), where B is an anagram of A.
2. B is an anagram of A means B is made by randomizing the order of the elements in A.
3. For every element in A, you have to print the index of that element in B.

Note -> Both arrays(A and B) are of the same length.
Input Format
A number N
a1
a2.. N numbers
b1
b2.. N numbers
Output Format
N space separated integers.

Constraints
1 <= length of both arrays <= 10^4
1 <= A[i],B[i] <= 10^5
Sample Input
6
1 2 3 4 5 2
4 3 2 1 5 2
Sample Output
3 2 1 0 4 5 

Code:

import java.util.*;

public class Main {

  public static class Pair{ //pair mai rakhenge index aur arraylist

    int idx = 0;
    ArrayList<Integer> list = new ArrayList<>();

  }

  public static int[] anagramMappings(int[] arr1, int[] arr2) {
    HashMap<Integer, Pair> map = new HashMap<>() ;//hume banana hoga hashmap of int vs pair

    //pehle arr2 ko process karenge
    for ( int i = 0; i < arr2.length; i++) {
      if ( map.containsKey(arr2[i])) { //dekhenge kya yeh arr[i] map mai pda hai ya nhi pda hai, agar map contain krta hai to aap naya pair nhi banayenge pair nikalenge
        Pair p = map.get(arr2[i]);
        //aur pair ki list mai add krdo
        p.list.add(i);

      } else {
        //agar nhi pda hai
        Pair p = new Pair();
        p.list.add(i); // p ki list ke andar add krdo tumhara i. yeh pair tayar hogyi ab arr2[i] samne iss pair ko dalde
        map.put(arr2[i], p); //arr2[i] ke samne new Pair dalde, new Pair mai index humesha by default 0 pe set rahega aur list khali hogi
      }
    }

    int ans[] = new int[arr1.length];

    //ab first array mai loop lagayenge
    for ( int i = 0; i < arr1.length; i++) {
      //value humesha milegi hume kyuki anagrams hai
      Pair p = map.get(arr1[i]);
      //ab iss pair ke andar jahapr index point kr rha hai woh wali value aap answer mai dalenge
      ans[i] = p.list.get(p.idx);
      p.idx++; //aur iske bad index ko badhana na bhule
    }

    return ans;
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int n = s.nextInt();
    int[] a = new int[n];
    int[] b = new int[n];
    for (int i = 0; i < a.length; i++) {
      a[i] = s.nextInt();
    }
    for (int j = 0; j < b.length; j++) {
      b[j] = s.nextInt();
    }
    int[] res = anagramMappings(a, b);
    for (int j = 0; j < res.length; j++) {
      System.out.print(res[j] + " ");
    }
  }

}
