Multisolver - Smallest, Longest, Ceil, Floor, Kthlargest Path

1. You are given a graph, a src vertex and a destination vertex.
2. You are give a number named "criteria" and a number "k".
3. You are required to find and print the values of 
3.1 Smallest path and it's weight separated by an "@"
3.2 Largest path and it's weight separated by an "@"
3.3 Just Larger path (than criteria in terms of weight) and it's weight separated by an "@"
3.4 Just smaller path (than criteria in terms of weight) and it's weight separated by an "@"
3.5 Kth largest path and it's weight separated by an "@"
Input Format
Input has been managed for you
Output Format
Check sample output

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
6
30
4
Sample Output
Smallest Path = 01256@28
Largest Path = 032546@66
Just Larger Path than 30 = 012546@36
Just Smaller Path than 30 = 01256@28
4th largest path = 03456@48


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

  static class Pair implements Comparable<Pair> {
    int wsf;
    String psf;

    Pair(int wsf, String psf) {
      this.wsf = wsf;
      this.psf = psf;
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
    int dest = Integer.parseInt(br.readLine());

    int criteria = Integer.parseInt(br.readLine());
    int k = Integer.parseInt(br.readLine());

    boolean[] visited = new boolean[vtces];
    multisolver(graph, src, dest, visited, criteria, k, src + "", 0);

    System.out.println("Smallest Path = " + spath + "@" + spathwt);
    System.out.println("Largest Path = " + lpath + "@" + lpathwt);
    System.out.println("Just Larger Path than " + criteria + " = " + cpath + "@" + cpathwt);
    System.out.println("Just Smaller Path than " + criteria + " = " + fpath + "@" + fpathwt);
    System.out.println(k + "th largest path = " + pq.peek().psf + "@" + pq.peek().wsf);
  }


  //yeh data memebers hai inki value hume set karni hai, inko static manlo
  static String spath; // smaller path
  static Integer spathwt = Integer.MAX_VALUE; //smaller path ka weight
  static String lpath;
  static Integer lpathwt = Integer.MIN_VALUE;
  static String cpath;
  static Integer cpathwt = Integer.MAX_VALUE;
  static String fpath;
  static Integer fpathwt = Integer.MIN_VALUE;
  static PriorityQueue<Pair> pq = new PriorityQueue<>(); // kth largest keliye priority queue use karenge

  public static void multisolver(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, int criteria, int k, String psf, int wsf) { // wsf: wieght so far

    if ( src == dest) { // pichle question mai yaha ane ke bad sare raste print krte the aur return krjate the
      //   System.out.println(psf+"@"+wsf); but muje yeh nhi karna muje data members ki value set krni hai
      
      // smallest keliye
       if (wsf < spathwt) { //smallest keliye default value +infinity hai to maine bola agar curremt raste ka wsf chota hota hai smallest weight path weight se to smallest path weight ko updte krdo aur sathme hi smallest path kobhi update krdo
        spathwt = wsf;
        spath = psf;
      }
      //largest keliye
      if (wsf > lpathwt) { //agar current raste ke weight largest path weight se jada ata hai to largest path weight ko update krdenge sathme largest path kobhi update krdenge
        lpathwt = wsf;
        lpath = psf;
      }
      //ceil path: just greater path (bado mai sabse chota, smallest among bigger paths, smaller hai isliye iske liye cpath ko default value +infinity se initialise kiya gya hai)
      if (wsf > criteria && wsf < cpathwt) { // agar weight sofar criteria se bada hai aur chota hai ceil path wt se to yahi mera ab ceil hoga so update krdo
        cpathwt = wsf;
        cpath = psf;
      }
      // floor path weight: choto mai sabse bada
      if (wsf < criteria && wsf > fpathwt) { 
        fpathwt = wsf;
        fpath = psf;
      }
      //for kth largest (team selection wala funda yad karo)
      if (pq.size() < k) { //agar priority queue ka size k se chota hai to kuch comparison nhi hoga sidha PQ mai add krdo
        pq.add(new Pair(wsf, psf));
      } else { // agar size k ke equal or bada hai to 
        if (wsf > pq.peek().wsf) { //pq ke peek ka weight so far ki value agar choti aati hai current weight so far se to pq mese remove krdo aur pq mai add karo current path ko add 
          pq.remove();
          pq.add(new Pair(wsf, psf));
        }
      }
      return;
    }

    //1. sabse pehle muje likhna hai code to generate all paths
    // aatehi sabse pehle source ko visited mark kardo
    visited[src] = true;

    //ab uske unvisited neighbour ko call lagegi
    for (Edge e : graph[src]) {
      int nbr = e.nbr; // agar woh neighbour unvisited hua to lagegi call
      if (visited[nbr] == false) {
        multisolver( graph, nbr, dest, visited, criteria, k, psf + nbr, wsf + e.wt);
      }
    }

    visited[src] = false; //wapas aate hue false kardenge
  }
}
