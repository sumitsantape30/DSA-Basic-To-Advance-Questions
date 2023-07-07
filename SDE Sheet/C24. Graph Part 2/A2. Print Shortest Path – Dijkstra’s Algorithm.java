G-35 : Print Shortest Path – Dijkstra’s Algorithm
Problem Statement: 

You are given a weighted undirected graph having n+1 vertices numbered from 0 to n and m edges describing there are 
edges between a to b with some weight, find the shortest path between the vertex 1 and the vertex n, and if the path does 
not exist then return a list consisting of only -1.

Code:

package Codes;

import java.util.*;
import java.io.*;

public class ques {
	
	public static class Pair{ //its a weighted graph so we need a pair
	    int first;
	    int second;
	    public Pair(int first,int second){
	        this.first = first;
	        this.second = second;
	    }
	}

    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
    	
    	//you've given the edges so create a graph first
    	// Create an adjacency list of pairs of the form node1 -> {node2, edge weight}
        // where the edge weight is the weight of the edge from node1 to node2.
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>(); 
        for(int i = 0;i<=n;i++) {
            adj.add(new ArrayList<>()); 
        }
        for(int i = 0;i<m;i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2])); 
            adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2])); 
        }
        
        //Algorithm yahase
        // Create a priority queue for storing the nodes along with distances  in the form of a pair { dist, node }.
        PriorityQueue<Pair> pq =  new PriorityQueue<Pair>((x,y) -> x.first - y.first); //by default minimum wala element top pe rahega

        // Create a dist array for storing the updated distances and a parent array for storing the nodes from where the current nodes represented by indices of the parent array came from.
        //it'a 1 based array so n+1 size ka banayenge
        int[] dist = new int[n+1]; 
        int[] parent =new int[n+1]; 
        for(int i = 1;i<=n;i++) {
            dist[i] = (int)(1e9); //sare distance ke infinte se mark karenge
            parent[i] = i;  //aur parent ko khudse mark karenge
        }
        
        dist[1] = 0; //pehle wale ka distance 0 rahega

        // Push the source node to the queue.
        pq.add(new Pair(0, 1)); 
        
        while(pq.size() != 0) {

            // Topmost element of the priority queue is with minimum distance value.
            Pair it = pq.peek(); 
            int node = it.second;
            int dis = it.first; 
            pq.remove(); 
            
            // Iterate through the adjacent nodes of the current popped node.
            for(Pair iter : adj.get(node)) {
                int adjNode = iter.first; 
                int edW = iter.second; //edge weight

                // Check if the previously stored distance value is greater than the current computed value or not, 
                // if yes then update the distance value.
                if(dis + edW < dist[adjNode]) { //dis is distance taken till now + current edge weight
                    dist[adjNode] = dis + edW; //if its less than previous then update
                    pq.add(new Pair(dis + edW, adjNode)); //then add it in pq

                    // Update the parent of the adjNode to the recent node where it came from.
                    parent[adjNode] = node; 
                }
            }
        }
        
        //ab 
		List<Integer> path = new ArrayList<>();

		// if you could not reach the destination just return the list containing -1
		if (dist[n] == 1e9) {
			path.add(-1);
			return path;
		}
		
		//not we reached the destination then we'll store the path

		int node = n;
		// o(N)
		while (parent[node] != node) {
			path.add(node);//we add this node in path
			node = parent[node]; //and we move back to the parent of this node
		}
		path.add(1);//jab woh source pe ata hai to loop nhi chalta so src ko alag se dalenge

		// Since the path stored is in a reverse order, we reverse the array to get the final answer and then return the array.
		Collections.reverse(path);
		return path;
	}
    
	public static void main(String[] args) {

		int V = 5, E = 6;

        int[][] edges = {{1,2,2},{2,5,5},{2,3,4},{1,4,1},{4,3,3},{3,5,1}};

        List < Integer > path = shortestPath(V, E, edges);
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + " ");
        }
        System.out.println();
	}

}
