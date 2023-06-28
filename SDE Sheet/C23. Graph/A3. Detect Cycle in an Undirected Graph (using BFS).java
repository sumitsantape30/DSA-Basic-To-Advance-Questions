Problem Statement: Given an undirected graph with V vertices and E edges, check whether it contains any cycle or not. 

Examples:

Example 1:
Input:
V = 8, E = 7


Output:  0

Explanation: No cycle in the given graph.
Example 2:
Input:
V = 8, E = 6


Output: 1 

Explanation: 4->5->6->4 is a cycle

Code:

package Codes;

import java.util.*;
import java.io.*;

public class ques {
	
	public static class Pair{
		int first;
		int second;
		
		public Pair() {
			
		}
		
		public Pair( int first, int second) {
			this.first = first;
			this.second = second;
		}
	}
	
	//agar ek component hai to yeh function bas uss component ke nodes ko visit karega aur wapas chala jayega koi cycle return nhi karega
	public static boolean detectCycle(int src, ArrayList<ArrayList<Integer>> adj, boolean visited[]) {
		
		
		Queue<Pair> que = new ArrayDeque<>();
		que.add( new Pair(src, -1));
		visited[src] = true;
		
		while(! que.isEmpty()){
			
			int node = que.peek().first;
			int par = que.peek().second;
			que.remove();
			
			for( Integer adjacentNode: adj.get(node)) {
				
				if( visited[adjacentNode] == false) {
					que.add(new Pair(adjacentNode, node));
					visited[adjacentNode] = true;
					
				}else if( par != adjacentNode) { //agar yeh already visited hai to chances hai ki yeh cycle ho skti hai. agar yeh mere parent jaisahi hai mean maine hi isko just abhi visit kiya tha to kuch nhi karenge. agar yeh parent jaisa nhi hai matlab kisi aur ne isko visit kiya tha dusri path se means cycle hai
					//agar visited hai aur usse mai nhi aya means jo aya woh mere parent ke equal nhi hai to cycle detect krti hai
					return true;
				}
			}
			
			
		}
		return false;
	}
	
	//jab multiple components rahenge to har component keliye indivisually check karna pdega
	public static boolean isCyclePresent(int V, ArrayList<ArrayList<Integer>> adj) {
		
		boolean visited[]= new boolean[V+1]; //1 based indexing
		
		//1 based indexing rhi to start loop from 1 to <=n. and for 0 based indexing start from 0 to <n
				for( int i=1; i<= V; i++) {
					
					if( visited[i] == false) {
						if(detectCycle(i, adj, visited) == true){//agar current element visited nhi hai to call this function aur uska source i rahega
							return true; //if you get a cycle it'll return true
						}
					}
					
					return false; //if you dont get a cycle it'll return false
			  }
				
			return false;  //agar sare components mese ke bhi true nhi hai means cycle present nhi hai
				
	}
	
	public static void main(String[] args) {
		
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		
		for( int i=0; i < 10; i++) {
			adj.add( new ArrayList<>());
		}
		
		adj.get(1).add(2);
		adj.get(1).add(6);
		adj.get(2).add(1);
		adj.get(2).add(3);
		adj.get(2).add(4);
		adj.get(4).add(2);
		adj.get(4).add(5);
		adj.get(5).add(4);
		adj.get(5).add(8);
		adj.get(8).add(5);
		adj.get(8).add(7);
		adj.get(7).add(6);
		adj.get(7).add(8);
		adj.get(6).add(1);
		adj.get(6).add(7);
		adj.get(6).add(9);
		adj.get(9).add(6);
		
		
		Boolean ans = isCyclePresent(9, adj);
		System.out.println(ans);
		
	}

}
