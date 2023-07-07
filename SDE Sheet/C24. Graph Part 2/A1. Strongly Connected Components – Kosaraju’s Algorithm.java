Problem Statement: Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, 
Find the number of strongly connected components in the graph.

Code:

package Codes;

import java.util.*;
import java.io.*;

public class ques {

	//2. toposort
	private static void dfs(int node, int[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st) {
		vis[node] = 1;
		for (Integer it : adj.get(node)) {
			if (vis[it] == 0) {
				dfs(it, vis, adj, st);
			}
		}
		st.push(node);
	}
	
	 private static void dfs3(int node, int[] vis, ArrayList<ArrayList<Integer>> adjT) {
	        vis[node] = 1;
	        for (Integer it : adjT.get(node)) {
	            if (vis[it] == 0) {
	                dfs3(it, vis, adjT);
	            }
	        }
	   }

	public static int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {

		// 1. we'll have stack basically we'll do toposort first. we are not actually usng toposort, we're using its idea
		int[] vis = new int[V];
		Stack<Integer> st = new Stack<Integer>();
		for (int i = 0; i < V; i++) {
			if (vis[i] == 0) {
				dfs(i, vis, adj, st);
			}
		}

		//3. transpose graph, for that you need transpose adjacency
		ArrayList<ArrayList<Integer>> adjT = new ArrayList<ArrayList<Integer>>(); //new adjacency matrix create krte hai aur usme dalenge transpose
		for (int i = 0; i < V; i++) {
			adjT.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < V; i++) {
			vis[i] = 0; //we remark the visited to 0 coz toposort mai it was marked visited
			for (Integer it : adj.get(i)) { //previously there was edge between "i to it" now we'll make it "it to i"
				// i -> it
				// it -> i
				adjT.get(it).add(i);
			}
		}
		
		//now we'll do dfs according to finish time
		int scc = 0; //count of strongly connected component
		while (!st.isEmpty()) { //iterate on the stack and get the topomost element on stack
			int node = st.peek();
			st.pop();
			if (vis[node] == 0) { //if its not visited then we call the dfs
				scc++;
				dfs3(node, vis, adjT);
			}
		}
		return scc;
		
	}

	public static void main(String[] args) {

		int n = 5;
        int[][] edges = {
            {1, 0}, {0, 2},
            {2, 1}, {0, 3},
            {3, 4}
        };
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < n; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        int ans = kosaraju(n, adj);
        System.out.println("The number of strongly connected components is: " + ans);
	}

}
