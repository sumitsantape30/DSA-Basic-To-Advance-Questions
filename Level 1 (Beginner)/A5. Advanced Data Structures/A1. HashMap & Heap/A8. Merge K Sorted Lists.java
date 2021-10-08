Merge K Sorted Lists

1. You are given a list of lists, where each list is sorted.
2. You are required to complete the body of mergeKSortedLists function. The function is expected to merge k sorted lists to create one sorted list.
Input Format
Input is managed for you
Output Format
Output is managed for you
Question Video

Constraints
Space complextiy = O(k)
Time complexity = nlogk
where k is the number of lists and n is number of elements across all lists.
Sample Input
4
5
10 20 30 40 50
7
5 7 9 11 19 55 57
3
1 2 3
2
32 39
Sample Output
1 2 3 5 7 9 10 11 19 20 30 32 39 40 50 55 57 


Code:

import java.io.*;
import java.util.*;

public class Main {

 //yeh class comparable of pair interface ko implement karegi. comparable ke andar ek hi function hota hai compareTO woh function hume likhna hoga 
  public static class Pair implements Comparable<Pair> {
    //har pair mai 3 chize rakhunga
    int data; // data rahega
    int li; // fir woh data konse list ko belong krta hai: list index
    int di; //data index: uss list ka konsa banda

    Pair(int data, int li, int di) {
      this.data = data;
      this.li = li;
      this.di = di;
    }

    public int compareTo(Pair o) {// o : other
        //java mai by default chote bande ko jada priority hoti hai 
      return this.data - o.data;
    }
    //agar aap default behaviour nhi chahte ho ki bade bande ko sabse jada priotiy mile to apko likhna hoga, return o.data - this.data;
  }

  public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists) {
    ArrayList<Integer> ans = new ArrayList<>(); // my answer

    //ab priority queue banaunga pair class ki
    PriorityQueue<Pair> pq = new PriorityQueue<>();
    //iss priority mai ab harr list ke 0th pe rakhe bando ko dalna hai

    for( int i=0; i< lists.size(); i++){
        ArrayList<Integer> list= lists.get(i); // hume single list in multiple lists mil gyi
        pq.add(new Pair(list.get(0),i, 0)); //pq mai ab naya pair add karunga jiska list index hoga i, data index hoga 0. ith list ke 0th pe rakhe hue bande ko pair mai dalke PQ mai add krdo
    }
    
    while( pq.size() != 0 ){ //jabtak priority queue ka size 0 nhi hota tabtak apna kam chalega
      Pair rp = pq.remove(); // priority queue mese remove kiya aur apne answer mai use add karlo
      ans.add(rp.data); //answer mai removed pair ka data add karenge
      
      //jo banda apne remove kiya hai agar uska next banda exist krta hai to usko PQ mai add karawana hoga
      if(rp.di + 1 < lists.get(rp.li).size()){ // jo remove kiya uska data index chota hona chahiye size se tabhi to nikal paoge
          pq.add(new Pair(lists.get(rp.li).get(rp.di +1), rp.li, rp.di + 1)) ; // ek naya pair banake add karenge, jiska list index wahi rahega joki removed pair ka list index hai, aur jiska data index ek se badh jayega 
      }
    }

    return ans;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int k = Integer.parseInt(br.readLine());
    ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
    for (int i = 0; i < k; i++) {
      ArrayList<Integer> list = new ArrayList<>();

      int n = Integer.parseInt(br.readLine());
      String[] elements = br.readLine().split(" ");
      for (int j = 0; j < n; j++) {
        list.add(Integer.parseInt(elements[j]));
      }

      lists.add(list);
    }

    ArrayList<Integer> mlist = mergeKSortedLists(lists);
    for (int val : mlist) {
      System.out.print(val + " ");
    }
    System.out.println();
  }

}
