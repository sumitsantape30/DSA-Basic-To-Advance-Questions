Problem Statement: Given an undirected graph and a number m, determine if the graph can be colored with at most m colors such that no two adjacent vertices of the graph are colored with the same color.

Examples:

Example 1:
Input: 
N = 4
M = 3
E = 5
Edges[] = {
  (0, 1),
  (1, 2),
  (2, 3),
  (3, 0),
  (0, 2)
}

Output: 1

Explanation: It is possible to colour the given graph using 3 colours.

Code:

import java.util.*;
class TUF {
    public static boolean graphColoring(List < Integer > [] G, int[] color, int i, int m) {//youve given a graph G, then you have given color array so you can store the colours, then i is starting node, m is the number of colours you can have at maximum
        // Your code here
        int n = G.length;
        if (solve(i, G, color, n, m) == true) return true;//is this returns a true I can say it is possible to color
        return false;//or i'll say it not possible to color
    }
    
    private static boolean isSafe(int node, List < Integer > [] G, int[] color, int n, int col) {
        for (int it: G[node]) {//I traverse for col's adjacent nodes
            if (color[it] == col) return false; //agar yeh colour already kahipe exist krta hai. I'm checking if adjacent colour is equal to col that i'm trying to use for this node
        }
        return true;//returing true if none of the adjacent node having the same colour
    }
    
    private static boolean solve(int node, List < Integer > [] G, int[] color, int n, int m) {
        if (node == n) return true; //i could reach node because I was able to colur everything properly so I'll return true

        //if it not n then I try to colour it with every possible colour from 1 to m
        for (int i = 1; i <= m; i++) { 
            if (isSafe(node, G, color, n, i)) {//if it is possible/safe to colour that node then I'll colour it. this checks if any of the possible node having same colur i that Im trying to use it currently
                color[node] = i;//colore the node with colour i
                if (solve(node + 1, G, color, n, m) == true) return true; //then we call the function for the next serial number node. If this function returns true there's no need to go back to remove the previous color. humne sahi colouring ki hai so you can break out saying return true
                color[node] = 0;//but agar iss function se false aya to jo apne pehle colour kiya tha usko remove karo humne galat coluring ki hai so take it off
            }
        }
        //jab for loop khatam hoga to i can say ki I tried with every colour from 1 to m and this return true on line 27 never got executed so it was not possible to colur this particular node with any of the colours from 1 to m, and if it is not possible i'll definitely not colour the graph
        return false;//saying its not possible to colour this graph
    }
    public static void main(String[] args) {
        int N = 4, M = 3;
        List < Integer > [] G = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            G[i] = new ArrayList < > ();
        }
        G[0].add(1);
        G[1].add(0);
        G[1].add(2);
        G[2].add(1);
        G[2].add(3);
        G[3].add(2);
        G[3].add(0);
        G[0].add(3);
        G[0].add(2);
        G[2].add(0);
        int[] color = new int[N];
        boolean ans = graphColoring(G, color, 0, M);
        if (ans == true)
            System.out.println("1");
        else
            System.out.println("0");
    }
}
Output: 1

Time Complexity: O( N^M) (n raised to m)

Space Complexity: O(N)

Special thanks to Rushikesh Adh
