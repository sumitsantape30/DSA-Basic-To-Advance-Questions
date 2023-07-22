Problem Statement: Given a weighted, undirected, and connected graph of V vertices and E edges. The task is to find the sum of weights of the edges of the Minimum Spanning Tree.
(Sometimes it may be asked to find the MST as well, where in the MST the edge-informations will be stored in the form {u, v}(u = starting node, v = ending node).)

Code:

package Codes;

import java.util.*;
import java.io.*;

public class ques {

	public static class Pair {
		int node;
		int distance;

		public Pair(int distance, int node) {
			this.node = node;
			this.distance = distance;
		}
	} //agar sare MST mai sari edges return krni hoti to hum ek parent bhi rakhte.
	//and distance is the weight here

	public static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
		
		//min heap lenge
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);

		int[] vis = new int[V];
		// {wt, node}
		pq.add(new Pair(0, 0)); //src kahise bhi le skte ho mai 0 se lerha
		
		int sum = 0;
		while (pq.size() > 0) {
			
			int wt = pq.peek().distance; //wt is at second position 
			int node = pq.peek().node; //node is at first position
			pq.remove();

			if (vis[node] == 1) //agar visited hai means yeh node already MST ka part hai
				continue;
			// add it to the mst
			vis[node] = 1; //visited nhi hai to visited mark krdenge aur sathme iska weight sum mai dal denge
			sum += wt;
			//agar question mai MST manga hota to yahipe add karenge

			//then iterate on adjacent guys
			for (int i = 0; i < adj.get(node).size(); i++) {
				int edW = adj.get(node).get(i).get(1);
				int adjNode = adj.get(node).get(i).get(0);
				
				if (vis[adjNode] == 0) { // if its not visited matlab mst ka part nhi hai to isko PQ mai dal denge
					pq.add(new Pair(edW, adjNode));
				}
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		
		int V = 5;
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
        int[][] edges =  {{0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}};

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<ArrayList<Integer>>());
        }

        for (int i = 0; i < 6; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            ArrayList<Integer> tmp1 = new ArrayList<Integer>();
            ArrayList<Integer> tmp2 = new ArrayList<Integer>();
            tmp1.add(v);
            tmp1.add(w);

            tmp2.add(u);
            tmp2.add(w);

            adj.get(u).add(tmp1);
            adj.get(v).add(tmp2);
        }

        int sum = spanningTree(V, adj);
        System.out.println("The sum of all the edge weights: " + sum);

	}
}

Output: 
The sum of all the edge weights: 5
