Detect cycle in a directed graph (using DFS) : G 19
Problem Statement: Given a directed graph with V vertices and E edges, check whether it contains any cycle or not. 

Example 1:

Input: N = 10, E = 11
Output: true

Explanation: 8->9->10 is a cycle.

Code:

package Codes;

import java.util.*;
import java.io.*;

public class ques {
	
	//cycle haiki nhi check karega
	public static boolean checkCycle(int node, ArrayList<ArrayList<Integer>> adj, int visited[], int dfsVisited[]) {
		
		visited[node] = 1; //yeh visited nodes track karega
		dfsVisited[node] = 1; //current path mai jo nodes aaye hai unko track karega
		
		
		for(Integer adjacentNode: adj.get(node)) {
			
			 if( visited[adjacentNode] == 0) {
				 
				 if(checkCycle(adjacentNode, adj, visited, dfsVisited)) {
					 return true;
				 }
				 
			 }else if( dfsVisited[node] == 1) {
				 return true;
			 }
		}
		
		return false;
		
	}
	
	public static boolean detectCycle(ArrayList<ArrayList<Integer>> adj, int V) {
		
		int visited[]= new int[V+1];
		int dfsVisited[]= new int[V+1];
		
		for( int i=1; i<= V; i++) { //0 based indexing
			if( visited[i] == 0) {
				if(checkCycle(i, adj, visited, dfsVisited))return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		
		 int V = 11;
	        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
	        for (int i = 0; i < V; i++) {
	            adj.add(new ArrayList<>());
	        }
	        adj.get(1).add(2);
	        adj.get(2).add(3);
	        adj.get(3).add(4);
	        adj.get(3).add(7);
	        adj.get(4).add(5);
	        adj.get(5).add(6);
	        adj.get(7).add(5);
	        adj.get(8).add(9);
	        adj.get(9).add(10);
	        adj.get(10).add(8);

	        boolean ans = detectCycle(adj, V);
	        if (ans)
	            System.out.println("True");
	        else
	            System.out.println("False");
 
	}

}
