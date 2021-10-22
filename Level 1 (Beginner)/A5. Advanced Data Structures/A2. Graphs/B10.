Is Graph Cyclic

1. You are given a graph.
2. You are required to find and print if the graph is cyclic.
Input Format
Input has been managed for you
Output Format
true if the graph is cyclic, false otherwise

Constraints
None
Sample Input
7
6
0 1 10
1 2 10
2 3 10
3 4 10
4 5 10
5 6 10
Sample Output
false

Code:

import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }
   
   public static class Pair{
       int vtx;
       String psf;
      //isme weight ki jarurat nhi hai 
       
       public Pair(int vtx, String psf){
           this.vtx= vtx;
           this.psf= psf;
       }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }

      boolean visited[]= new boolean[graph.length];
      
      for( int i=0; i< graph.length; i++){
          if( visited[i] == false){
              //unvisited dikha to hum bolenge yr yeh component cyclic hai ya nhi btao
              boolean compans= isComplCyclic(graph, visited, i); // i ko source banake bhej diya
              if( compans == true){
                  //agar component ka answer hai true to woh component cyclic hai means whole graph is cyclic
                  System.out.println(true);
                  return;
              }
          }
      }
       
       System.out.println(false);
   }
   
   public static boolean isComplCyclic(ArrayList<Edge>[] graph, boolean visited[], int src){ 
       Queue<Pair> q= new ArrayDeque<>();
      q.add(new Pair(src, src + "")); 
      
      while( q.size() != 0){
          
          Pair rp= q.remove();
          
          if(visited[rp.vtx] == false){
              visited[rp.vtx] = true;

              for( Edge e: graph[rp.vtx]){
                  int nbr = e.nbr; 
                   
                   if( visited[nbr] == false){
                       q.add(new Pair(nbr, rp.psf + nbr));
                   }
                  
              }
          }else{
              //agar removed pair ka vertex already visited hai yeh cyclic hai
              return true;
          }
          
      }
      return false;
   }
   
   
}
