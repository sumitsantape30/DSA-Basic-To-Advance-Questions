Is Graph Bipartite

1. You are given a graph.
2. You are required to find and print if the graph is bipartite

Note -> A graph is called bipartite if it is possible to split it's vertices in two sets of mutually 
               exclusive and exhaustive vertices such that all edges are across sets.
Input Format
Input has been managed for you
Output Format
true if the graph is bipartite, false otherwise

Constraints
None
Sample Input
7
8
0 1 10
1 2 10
2 3 10
0 3 10
3 4 10
4 5 10
5 6 10
4 6 10
Sample Output
false

Code:

import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }
   
   public static class Pair{
       int vtx;
       int level;
       
       public Pair(int vtx, int level){
           this.vtx= vtx;
           this.level= level;
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
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      //hume sare components check karne honge agar kisi bhi component mai odd length ki cycle nikalti hai to graph no bipartite hoga 
      boolean[] visited= new boolean[graph.length];
      
      for( int i=0; i< graph.length; i++){
          //for every component I'll call that function, agar koi vertex visited nhi hai matlab woh ek alag component hai
          if( visited[i]== false){
              boolean isCompBiparatite= isBipartite(graph, i, visited);
              //agar ek component bipartite nhi hota to apna answer bhi false ayega
              if(isCompBiparatite == false){
                  System.out.println(false);
                  return;
              }
          }
      }
      System.out.println(true);
   }
   
   public static boolean isBipartite(ArrayList<Edge>[] graph, int src,  boolean[] visited){
       HashMap<Integer, Integer> map= new HashMap<>(); // hm to store information of old level 
       
       //aatehi ek queue banayenge
       Queue<Pair> q= new ArrayDeque<>();
       q.add(new Pair(src, 0)); //src add kiya aur level 0
       

       //ab maine bola jabtak q ka size 0 nhi hojata tabtak kam chalega
       while( q.size() != 0){
           //ab muje remove karna hai then makr visited, print karna hai aur uske unvisited neighbours ko queue mai add krdo
           Pair rp= q.remove();
           if(visited[rp.vtx] == true){ //fir maine dekha removed pair ka vertex kahi pehlese visited to nhi hai agar hai matlab cycle is present
               
               if( rp.level != map.get(rp.vtx) ){ //agar removed pair(means current pair) ka level uske old level ke barbar nhi hai to graph is non bipartite
                   return false;
               }
               
           }else{
               //agar woh pehlese visited nhi hai, pehli bar aa rhe ho to usko visited mark kardo
               visited[rp.vtx] = true;
               map.put(rp.vtx, rp.level); //uska vertex preserve karenge
               //remove kiya mark kiya print hume karwana nhi hai to ab iske unvisited neighbour ko queue mai add karna hai 
                for(Edge e: graph[rp.vtx]){
                    int nbr= e.nbr;
                    if( visited[nbr] == false){ //agar woh unvisited neighbour hai to usko queue mai add karenge
                        q.add(new Pair(nbr, rp.level + 1)); //vertex will be nbr aur level will be jo removed pair ka level tha usse ek jada
                    }
                }
               
           }
       }
    
       //yahatk aaye means graph is bipartite so return true
       return true;
     
   } 
}
