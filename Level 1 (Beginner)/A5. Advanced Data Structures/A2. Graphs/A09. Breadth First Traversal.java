Breadth First Traversal

1. You are given a graph, and a src vertex.
2. You are required to do a breadth first traversal and print which vertex is reached via which path, 
     starting from the src.

Note -> for output, check the sample output and question video.
Input Format
Input has been managed for you
Output Format
Check the sample output

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
2
Sample Output
2@2
1@21
3@23
0@210
4@234
5@2345
6@2346

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

      int src = Integer.parseInt(br.readLine());

      Queue<Pair> q= new ArrayDeque<>(); // hume ek pairs ki queue chahiye
      q.add(new Pair(src, src + "")); // hume ek pair add karenge jiska vertex hoga 0 aur pathsofar mai add hoga source
      boolean visited[]= new boolean[graph.length];
      
      while( q.size() != 0){
          
          Pair rp= q.remove();
          
          //remove karne ke bad agar removed pair ka vertex already visited nhi hai to kuch kam karna hai
          if(visited[rp.vtx] == false){
              //so sabse pehle usko visited mark krdo aur print kardo
              visited[rp.vtx] = true;
              System.out.println(rp.vtx + "@" + rp.psf);
              
              //ab uske unvisited neighbour ko queue mai add karna hai
              for( Edge e: graph[rp.vtx]){
                  int nbr = e.nbr; //removed pair ke vertex nikale
                   
                   if( visited[nbr] == false){ //agar woh neighbour unvisited hai to usko queue mai add kardo
                       q.add(new Pair(nbr, rp.psf + nbr)); // removed pair ke psf mai iss neighbour ko add kar denge
                   }
                  
              }
          }
          
      }
       
   }
}
