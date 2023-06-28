Problem statement: Given a graph, find the topological order for the given graph.

Topological sort: The linear ordering of nodes/vertices such that if there exists an edge between 2 nodes u,v then ‘u’ appears before ‘v’.

Code:

package Codes;

import java.util.*;
import java.io.*;

public class ques {
	
	 public static ArrayList<Integer> topSort(int V, ArrayList<ArrayList<Integer>>adj) {
		 
		 int indegree[]= new int[V];
		 
		 for( int i= 0; i< V; i++) { // sabki indegree fill karenge
			 
			 for( Integer adjacentNode: adj.get(i)) {
				 indegree[adjacentNode]++;
			 }
		 }
		 
		 //hum dekhenge kiski indegree 0 hai. aur usko queue mai dalenge
		 Queue<Integer> que= new ArrayDeque<>();
		 for( int i=0; i< V; i++) { //sare nodes pe traverse krke dekhenge kiski indegree 0 hai
			 if( indegree[i] == 0) {
				 que.add(i);
			 }
		 }//yeh DAC means directed acyclic graph hai means there'll always be at least one node with 0 indegree
		 
		 ArrayList<Integer> topo = new ArrayList<>();
		 while(! que.isEmpty()) {
			 
			 int node = que.peek();
			 que.remove();
			 topo.add(node);
			 
			 //then i need to traverse on its adjacent nodes
			 //node is in your topo sort so please remove it from the indegree coz node is already there
			 for(Integer it: adj.get(node)) {
				 indegree[it]--;
				 //agar indegree 0 hogyi to i can say i have one more element and i can put that in toposort
			 }
		 }
		 return topo;
	 }
	
	public static void main(String[] args) {
		
		 ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();

         // adding new arraylists to 'adj' to add neighbour nodes
         for (int i = 0; i < 6; i++) {
             adj.add(new ArrayList < > ());
         }
         adj.get(5).add(2);
         adj.get(5).add(0);
         adj.get(4).add(0);
         adj.get(4).add(1);
         adj.get(3).add(1);
         adj.get(2).add(3);

         System.out.println(topSort(6,adj));
	}

}
