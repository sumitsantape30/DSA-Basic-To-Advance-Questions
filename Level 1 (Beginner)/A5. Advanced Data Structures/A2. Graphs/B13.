Shortest Path In Weights

1. You are given a graph and a source vertex. The vertices represent cities and the edges represent 
    distance in kms.
2. You are required to find the shortest path to each city (in terms of kms) from the source city along 
    with the total distance on path from source to destinations.

Note -> For output, check the sample output and question video.
Input Format
Input has been managed for you
Output Format
Check the sample output

Constraints
None
Sample Input
7
9
0 1 10
1 2 10
2 3 10
0 3 40
3 4 2
4 5 3
5 6 3
4 6 8
2 5 5
0
Sample Output
0 via 0 @ 0
1 via 01 @ 10
2 via 012 @ 20
5 via 0125 @ 25
4 via 01254 @ 28
6 via 01256 @ 28
3 via 012543 @ 30

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

  //pair class banayenge
  static class Pair implements Comparable< Pair> { //mai niche pair class ki pq banana chahta hu to isko comparable of pair ko implement karna hoga
    int vtx;
    String psf;
    int wsf;

    Pair(int vtx, String psf, int wsf) {
      this.vtx = vtx;
      this.psf = psf;
      this.wsf = wsf;
    }

    public int compareTo(Pair o) {
      return this.wsf - o.wsf;
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

    int src = Integer.parseInt(br.readLine());

    PriorityQueue< Pair> pq = new PriorityQueue<>();
    boolean[] visited = new boolean[graph.length];
    pq.add(new Pair(src, src + "", 0)); //jo source vertex hai usko pair banake add krdo

    while (pq.size() != 0) { //jabtak queue khali nhi hojati tabtak kam karenge. remove, mark and print
      Pair rp = pq.remove();

//agar woh removed pair pehlese visited hai to kuch nhi karna agar woh visited nhi hai to visited mark krdo aur print krdo
      if (visited[rp.vtx] == false) {
        visited[rp.vtx] = true;;

      System.out.println(rp.vtx + " via " + rp.psf
                         + " @ " + rp.wsf);

      // ab iske unvisited nbrs ko pq mai add krdo
      for (Edge e : graph[rp.vtx]) {
        int nbr = e.nbr;
        if (visited[nbr] == false) { //agar nbr visited nhi hai to usko pq mai add karna hai
          pq.add(new Pair(nbr, rp.psf + nbr, rp.wsf + e.wt)); //removed pair ke psf mai nbr ko add krdenge aur wsf mai bhi nbr ka wt add kardenge
         }
       }
      }
    }
  }
}
