Breadth First Search (BFS): Level Order Traversal
Problem Statement: Given an undirected graph, return a vector of all nodes by traversing the graph using breadth-first search (BFS).

Pre-req: Graph Representation, Queue STL

Examples:

Example 1:
Input:

Output: 1 2 5 3 4
Example 2:
Input:

Output: 1 2 7 3 6 8 10 4 5 9

Code:

package Codes;

import java.util.*;
import java.io.*;

public class ques {
	
	
	public static ArrayList<Integer> getBFSOfGraph(int V, ArrayList<ArrayList<Integer>> adj){
		
		boolean visited[]= new boolean[V+1];
		ArrayList<Integer> ans = new ArrayList<>();
		
		Queue<Integer> que= new ArrayDeque<>();
		
		que.add(1);
		visited[1] = true;
		
		while( ! que.isEmpty()) {
			
			Integer node=  que.remove();
			ans.add(node);
			
			for(Integer it: adj.get(node)) {
				if( visited[it] == false) {
					visited[it] = true;
					que.add(it);
				}
			}
			
		}
		
		return ans;
		
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

		
		ArrayList<Integer> dfs = getBFSOfGraph(9, adj);
		
		for( int i=0; i< dfs.size(); i++)System.out.println(dfs.get(i));
		
	}

}
