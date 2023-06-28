Problem Statement: Given an undirected graph with V vertices and E edges, check whether it contains any cycle or not. 

Examples:

Example 1:
Input:
V = 8, E = 7

Output: No

Explanation: No cycle in the given graph.
Example 2:
Input:
V = 8, E = 6

Output: Yes 

Explanation: 
4->5->6->4 is a cycle.
Solution

Intuition:
The cycle in a graph starts from a node and ends at the same node. 
DFS is a traversal technique that involves the idea of recursion and backtracking. DFS goes in-depth, i.e., traverses all nodes by going 
ahead, and when there are no further nodes to traverse in the current path, then it backtracks on the same path and traverses other 
unvisited nodes. The intuition is that we start from a source and go in-depth, and reach any node that has been previously visited in 
the past; it means there’s a cycle.

Code:
package Codes;

import java.util.*;
import java.io.*;

public class ques {
	
	//cycle haiki nhi check karega
	public static boolean dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean visited[]) {
		
		visited[node] = true;
		
		for(Integer adjacentNode: adj.get(node)) {
			
			 if( visited[adjacentNode] == false) {
				 
				 if(dfs(adjacentNode, node, adj, visited)) {
					 return true;
				 }
				 
			 }else if(adjacentNode != parent) {
				 return true;
			 }
			
		}
		return false;
	}
	
	public static boolean detectCycle(ArrayList<ArrayList<Integer>> adj, int V) {
		
		boolean visited[]= new boolean[V+1];
		
		for( int i=0; i< V; i++) { //0 based indexing
			if( visited[i] == false) {
				if(dfs(i, -1, adj, visited))return true;//agar koi ek component mai cycle hai to yaha true ayega
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        
        System.out.println(detectCycle( adj, 4));
	}

}
