Problem Statement: Given a DAG( Directed Acyclic Graph ), print all the vertex of the graph in a topologically sorted order. If there are multiple solutions, print any.

Pre-req: DFS traversal, Graphs, Stack data structure.
	
Code:

package Codes;

import java.util.*;
import java.io.*;

public class ques {

	public static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {

		Stack<Integer> st = new Stack<>();
		int visited[] = new int[V];

		for (int i = 0; i < V; i++) {

			if (visited[i] == 0) {
				findTopoSort(i, adj, visited, st);
			}
		}

		int topo[] = new int[V];
		int ind = 0;
		while (!st.isEmpty()) {
			topo[ind++] = st.pop();
		}
		// for(int i = 0;i<N;i++) System.out.println(topo[i] + " ");
		return topo;

	}

	public static void findTopoSort(int node, ArrayList<ArrayList<Integer>> adj, int visited[], Stack<Integer> st) {

		visited[node] = 1;

		for (Integer adjacent : adj.get(node)) {

			if (visited[adjacent] == 0) {
				findTopoSort(adjacent, adj, visited, st);
			}

		}

		st.push(node);
	}

	public static void main(String[] args) {

		 ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
	        int n=6;
	        for(int i=0;i<n;i++)
	        {
	            ArrayList<Integer> arr=new ArrayList<>();
	            adj.add(arr);
	        }
	        
	        adj.get(5).add(2);
	        adj.get(5).add(0);
	        adj.get(4).add(0);
	        adj.get(4).add(1);
	        adj.get(2).add(3);
	        adj.get(3).add(1);
	        
	        int res[] = topoSort(6, adj);
	   
	        System.out.println("Toposort of the given graph is:" );
	        for (int i = 0; i < res.length; i++) {
	        	
	        System.out.print(res[i]+" ");
	        
	        }
	}

}
