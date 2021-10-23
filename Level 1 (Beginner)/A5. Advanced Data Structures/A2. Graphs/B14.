Minimum Wire Required To Connect All Pcs

1. You are given a graph and a source vertex. The vertices represent computers and the edges 
     represent length of LAN wire required to connect them.
2. You are required to find the minimum length of wire required to connect all PCs over a network. 
     Print the output in terms of which all PCs need to be connected, and the length of wire between 
     them.

Note -> For output, check the sample output and question video.
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
0 3 40
3 4 2
4 5 3
5 6 3
4 6 8
Sample Output
[1-0@10]
[2-1@10]
[3-2@10]
[4-3@2]
[5-4@3]
[6-5@3]


Code:

import java.io.*;
import java.util.*;

public class Main {
  
  public static class Edge {
    int src;
    int nbr;
    int wt;

    Edge(int src, int nbr, int wt) {
      this.src = src;
      this.nbr = nbr;
      this.wt = wt;
    }
  }

//ab comparison hoga wt ke basis pe
  public static class Pair implements Comparable< Pair> {
    int vtx; 
    int pv; //parent vertex, ki kahase aa rha hai
    int wt; //edge wt

    public Pair(int vtx, int pv, int wt) {
      this.vtx = vtx;
      this.pv = pv;
      this.wt = wt;
    }

    public int compareTo(Pair o) {
      return this.wt - o.wt;
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

    PriorityQueue<Pair> pq = new PriorityQueue<>(); //aatehi pq of pair class banadenge
    pq.add(new Pair(0, -1, 0)); //aur pq mai add karo ek naya pair, parent indiex -1 le rhe hai
    boolean[] visited= new boolean[graph.length];
    
    while (pq.size() != 0) { //jabtak pq khali nhi hojati tabtak kam karenge
       
       Pair rp = pq.remove();
       
       if( visited[rp.vtx] == false){ //agar removed pair ka vertex visited nhi hai to use visited mark kardo
         visited[rp.vtx]= true;
         
         //ab print, print bhi tabhi karenge agar uska parent index -1 nhi hai tabhi print karenge
         if(rp.pv != -1){
              System.out.println("[" + rp.vtx + "-" + rp.pv + "@" + rp.wt + "]");
         }
         
         //ab iske unvisited nbr ko pq mai add
         for(Edge e: graph[rp.vtx]){
             int nbr= e.nbr;
             if( visited[nbr] == false){ //agar yeh nbr unvisited hai to usko pq mai add kardo
               pq.add(new Pair(nbr, rp.vtx, e.wt));
                 
             }
         }
       }
        
    }
  }

}
