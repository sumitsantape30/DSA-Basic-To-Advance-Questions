Problem Statement: Given a weighted, directed and connected graph of V vertices and E edges, Find the shortest distance of all the vertices from the source vertex S.

Note: If the Graph contains a negative cycle then return an array consisting of only -1.

Code:

package Codes;

import java.util.*;
import java.io.*;

public class ques {

	static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
		//distance array banayenge jisme initially sari values infinity hongi
		int[] dist = new int[V];
		for (int i = 0; i < V; i++)
			dist[i] = (int) (1e8);
		dist[S] = 0; //source ka distance 0 rahega
		
		// V x E is the time complexity. V-1 times iterations karenge. we'll do relaxtion for v-1 times
		for (int i = 0; i < V - 1; i++) {
			
			for (ArrayList<Integer> it : edges) { //we'll go on all the edges
				
				int u = it.get(0);
				int v = it.get(1);
				int wt = it.get(2);
				
				//relaxation
				if (dist[u] != 1e8 && dist[u] + wt < dist[v]) { //if its reachable we update the dist of v
					dist[v] = dist[u] + wt;
				}
			}
		}
		
		//agar negative cycle hai to we'll return an array having -1
		//humne N-1 relaxation karliye ab ek bar karenge, agar iss Nth time mai bhi reduce horhi hai values means yeh loop mai hai aur negative cycle contain krta hai
		// Nth relaxation to check negative cycle
		for (ArrayList<Integer> it : edges) {
			int u = it.get(0);
			int v = it.get(1);
			int wt = it.get(2);
			if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {
				int temp[] = new int[1];
				temp[0] = -1;
				return temp;
			}
		}
		//you should not be reducing at the Nth iteration you should have completed all the shortest path in N-1 iterations at the worst case
		
		return dist;
		
	}
	
	//so when your graph has negative edge weights and if graph has negative cycles that's when you should implement the bellman ford algo


	public static void main(String[] args) {

		int V = 6;
		int S = 0;
		ArrayList<ArrayList<Integer>> edges = new ArrayList<>() {
			{
				add(new ArrayList<Integer>(Arrays.asList(3, 2, 6)));
				add(new ArrayList<Integer>(Arrays.asList(5, 3, 1)));
				add(new ArrayList<Integer>(Arrays.asList(0, 1, 5)));
				add(new ArrayList<Integer>(Arrays.asList(1, 5, -3)));
				add(new ArrayList<Integer>(Arrays.asList(1, 2, -2)));
				add(new ArrayList<Integer>(Arrays.asList(3, 4, -2)));
				add(new ArrayList<Integer>(Arrays.asList(2, 4, 3)));
			}
		};

		int[] dist = bellman_ford(V, edges, S);
		for( int i=0; i< dist.length; i++) {
			System.out.println(dist[i]);
		}

	}

}
