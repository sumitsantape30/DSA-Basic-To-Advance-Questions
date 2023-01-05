
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

package Codes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.*;


public class code {	
	
	public static class Pair implements Comparable<Pair>{
		int data;
		int di;
		int li;
		
		public Pair(int data, int di, int li) {
			this.data= data;
			this.di = di;
			this.li = li;
		}
		
		@Override
		public int compareTo(Pair o) {
			return this.data - o.data;
		}
		
	}
	
	public static ArrayList<Integer> mergeKSorted(ArrayList<ArrayList<Integer>> lists){
		
		ArrayList<Integer> res = new ArrayList<>();
		
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		
		for( int i=0; i< lists.size(); i++) {
			
			ArrayList<Integer> list = lists.get(i);
			pq.add(new Pair(list.get(0), 0, i));
		}
		
		while( pq.size() > 0) {
			
			Pair rp = pq.remove();
			res.add(rp.data);
			
			if( rp.di + 1 < lists.get(rp.li).size()) {
				
				pq.add(new Pair(lists.get(rp.li).get(rp.di+1), rp.di+1, rp.li));
				
			}
		}
		
		return res;
		
	}
	
	public static void main(String args[]) throws NumberFormatException, IOException {
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

		    ArrayList<Integer> mlist = mergeKSorted(lists);
		    for (int val : mlist) {
		      System.out.print(val + " ");
		    }
		    System.out.println();
		
	}

}
