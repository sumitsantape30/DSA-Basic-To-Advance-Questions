Has Path?

  1. You are given a graph, a src vertex and a destination vertex.
2. You are required to find if a path exists between src and dest. If it does, print true 
     otherwise print false.
Input Format
Input has been managed for you
Output Format
true if path exists, false otherwise

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
0
6
Sample Output
true

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

  //iss function se hume yeh expectation hai ki agar src se dest tak path hogi to true return karega else false return karega
  public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean visited[]) {
    if ( src == dest) { // agar source destinantion pe pohoch jaye to destiation to destination ka rasta exist krta hi hai so return true
      return true;
    }

    visited[src] = true; //atehi sabse pehle source ko visited mark kardiya

    // src vertex ke jitne bhi neighbours hai unpe loop chalado, agar mere neighbours mese koi destination tak ja skta hai to mai bhi destination tak ja skta hu
    for (Edge e : graph[src]) { // graph[src] se source ke samne rakhi hui arraylist milegi aur maine arraylist ke upar for each loop chala diya, ek ek krke ek edge bahar nikalta rahega
      //mere iss e mai edge mili hai aur har ek edge mai src, nbr aur wt hota hai so muje nbr ka kam hai 
      int nbr = e.nbr;
      //call lagane se pehle dekhenge yeh neighbour already visited hai ya nhi hai, call tabhi lagayenge jab neighbour unvisited hoga

      if ( visited[nbr] == false) {
        //ab mi puchunga kya iss nbr se destination tak ka rasta exist krta hai
        boolean ntod = hasPath(graph, nbr, dest, visited); // ntod : nbr to dest

        if ( ntod == true) { //agar nbr to destination ka rasta exist krta hai to hum dest pe jane ki kabilitiat rakhte hai
          return true;
        }
      }
    }

    return false;

    //   for( int i=0; i< graph[src].size(); i++){
    //       Edge e = graph[src].get(i);
    //   }

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

    // hume ek visited array bhi pass karna hoga
    boolean visited[] = new boolean[vtces] ; //jitne vertices honge unte size ka
    System.out.println(hasPath(graph, src, dest, visited));

  }
}
