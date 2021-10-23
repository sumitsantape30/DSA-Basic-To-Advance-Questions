Hamiltonian Path And Cycle

1. You are given a graph and a src vertex.
2. You are required to find and print all hamiltonian paths and cycles starting from src. The cycles must end with "*" and paths with a "."

Note -> A hamiltonian path is such which visits all vertices without visiting any twice. A hamiltonian path becomes a cycle if there is an edge between first and last vertex.
Note -> Print in lexicographically increasing order.
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
0 3 10
3 4 10
4 5 10
5 6 10
4 6 10
2 5 10
0
Sample Output
0123456.
0123465.
0125643*
0346521*

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

      int src = Integer.parseInt(br.readLine());

      hamiltonianPathAndCycle(graph, src, src, new boolean[graph.length], "" + src, 0);
   }
   
   //hume original source bhi rakhna hoga jo hume help karega yeh dhundne mai ki yeh path hai ya cycle. vvsf: vertex visited so far. mai asf ko length ke sath compare nhi kr skta coz neighbour kitne bhi digit ka ho skta hai isliye vertex visited so far rakh liya maine
    public static void hamiltonianPathAndCycle(ArrayList< Edge>[] graph, int src, int osrc, boolean[] visited, String asf, int vvsf) {
    if (vvsf == graph.length - 1) { //agar aap n-1 vertex visit kr chuke ho aur aakhri vertex ke upar aaye ho to yahape apko apna answer print karna hai 
      System.out.print(asf);

     // ab iss answer ke piche * lagega ya . yeh hume decide karna hai 
     //agar first aur last vertex ke bich edge hai to cycle hai nhito path hai, basically original source ke neighbour mai kya yeh aakhri vertex aati hai? 
      boolean isHC = false; //is Hamiltonian cycle, isko hum initially false rakh rhe hai
      for (Edge e : graph[osrc]) {
        if (e.nbr == src) { //agar original source ka neighbour current source means vertex ke barabr hua  to mai isHC ko true mark kardunga
          isHC = true;
          break;
        }
      }
      //fir mai bahar aake iski value check karunga 
      //aagar isHC ki value true hoti hai to end mai * print karenge nhi . print krenge
      if (isHC) {
        System.out.println("*");
      } else {
        System.out.println(".");
      }
      return;
    }

    visited[src]= true; //aatehi src ko visited mark kara diya
    for (Edge e : graph[src]) {
        int nbr= e.nbr;
      if (visited[nbr] == false) { //unvisited pe call karenge
        hamiltonianPathAndCycle(graph, nbr, osrc, visited, asf + nbr, vvsf + 1); 
      }
    }
    
    visited[src] = false; //wapas aate waqt visited ko false mark karna hoga
  }


}
