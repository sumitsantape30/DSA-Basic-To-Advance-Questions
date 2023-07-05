Problem Statement: Given an adjacency list of a graph adj of V no. of vertices having 0 based index. Check whether the graph is bipartite or not.

If we are able to colour a graph with two colours such that no adjacent nodes have the same colour, it is called a bipartite graph.

Code:

package Codes;

import java.util.*;
import java.io.*;

public class ques {

	private static boolean dfs(int node, int col, int color[], ArrayList<ArrayList<Integer>> adj) {

		color[node] = col;

		// traverse adjacent nodes
		for (int it : adj.get(node)) {
			// if uncoloured
			if (color[it] == -1) { //coloured nhi hai to opposite colour ke sath nbr keliye call krenge
				if (dfs(it, 1 - col, color, adj) == false)
					return false;
			}
			// if previously coloured and have the same colour to bipartite hai
			else if (color[it] == col) {
				return false;
			}
		}

		return true;
	}

	public static boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
		int color[] = new int[V];
		for (int i = 0; i < V; i++)
			color[i] = -1;

		// for connected components
		for (int i = 0; i < V; i++) {
			if (color[i] == -1) {
				if (dfs(i, 0, color, adj) == false)
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {

		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			adj.add(new ArrayList<>());
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

