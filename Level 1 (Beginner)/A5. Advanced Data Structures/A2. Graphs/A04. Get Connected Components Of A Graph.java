Get Connected Components Of A Graph

1. You are given a graph.
2. You are required to find and print all connected components of the graph.
Input Format
Input has been managed for you
Output Format
Check the sample output

Constraints
None
Sample Input
7
5
0 1 10
2 3 10
4 5 10
5 6 10
4 6 10
Sample Output
[[0, 1], [2, 3], [4, 5, 6]]

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

      ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
      
      boolean[] visited = new boolean[vtces];
      
      //mai vertices ke upar loop chalaunga
      for( int i=0; i< vtces; i++){
          
          if( visited[i] == false){ //agar yeh vertex visited nhi hai to ek arraylist banayi aur getComp ki help uss arraylist ko fill karwa liya. Agar koi unvisted vertex mila to maine usko bola ja apna component mai jitne bhi vertexes hai sabko true mark karake leke aa aur sare vertex ko ek arraylist mai bhi bharke la
           ArrayList<Integer> comp = new ArrayList<>();
           getComp(graph, i, visited, comp); //yeh iss comp nam ki arraylist ko bhar layega
           comps.add(comp); //abhi jo ek component aaya hai usko comps mai add karna hai 
           
          }
      }
      
      System.out.println(comps);
   }
   
   //yeh function bas ek hi component keliye chalta hai
   public static void getComp(ArrayList<Edge>[] graph, int src, boolean[] visited, ArrayList<Integer> comp){ // yeh function comp iss arraylist ko fill karne mai meri help karega
    
    visited[src]= true; //aatehi source ko visited mark krdo
    
    //jab visited mark kiya to sathme component mai bhi add krlo
    comp.add(src);
    
    //fir mai unvisited neighbour ko call lagata hu 
    for(Edge e: graph[src]){
        int nbr = e.nbr;
        if( visited[nbr] == false){ //agar woh neighbour visited nhi hai to call laga denge
            getComp(graph, nbr, visited, comp);
        }
    }
    
   }
   
}
