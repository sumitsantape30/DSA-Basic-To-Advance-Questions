Problem Statement: Given an adjacency list of a graph adj of V no. of vertices having 0 based index. Check whether the graph is bipartite or not.

If we are able to colour a graph with two colours such that no adjacent nodes have the same colour, it is called a bipartite graph.

Code:
	
package Codes;

import java.util.*;
import java.io.*;

public class ques {
	
	public static boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
		
		Queue<Integer> que= new ArrayDeque<>();
		//o based indexing hai to. o ko que mai push krdo
		que.add(0);
		
		//colous banayenge aur usme -1 dal denge showing its uncoloured
		int colour[]= new int[V];
		for( int i=0; i< V; i++) {
			colour[i] = -1;
		}
		
		colour[0] = 0; //initially 0th colour ko 0 se color karenge
		
		while( ! que.isEmpty()) {
			
			int node = que.peek();
			que.remove();
			
			for( Integer adjacent: adj.get(node)) {
				
				//if adjacent node is yet not coloured you will give the opposite colour to that node
				if( colour[adjacent] == -1) {
					colour[adjacent] = 1- colour[node]; //// Assign opposite color to adjacent vertex
					que.add(adjacent);
					
				}else if(colour[adjacent] == colour[node]) { //but agar woh already coloured hai then we'll check if adjacent nodes colour is equal to my colour
					//agar mere adjacent ka colour mere jaisahi hai means someone would have coloured it from different path
					
					return false;//we say its not a bipartite
					
				}
			}
		}
		return true; //if you were able put colours then its a bipartite so return true
	}

	public static void main(String[] args) {

		 ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();
	        for (int i = 0; i < 4; i++) {
	            adj.add(new ArrayList < > ());
	        }
	        adj.get(0).add(2);
	        adj.get(2).add(0);
	        adj.get(0).add(3);
	        adj.get(3).add(0);
	        adj.get(1).add(3);
	        adj.get(3).add(1);
	        adj.get(2).add(3);
	        adj.get(3).add(2);
	        
	        System.out.println(isBipartite(4, adj));
	}

}
