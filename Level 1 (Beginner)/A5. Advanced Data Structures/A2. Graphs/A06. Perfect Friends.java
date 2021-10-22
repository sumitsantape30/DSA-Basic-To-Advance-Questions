Perfect Friends

1. You are given a number n (representing the number of students). Each student will have an id 
     from 0 to n - 1.
2. You are given a number k (representing the number of clubs)
3. In the next k lines, two numbers are given separated by a space. The numbers are ids of 
     students belonging to same club.
4. You have to find in how many ways can we select a pair of students such that both students are 
     from different clubs.
Input Format
Input has been managed for you
Output Format
Check the sample output

Constraints
None
Sample Input
7
5
0 1
2 3
4 5
5 6
4 6
Sample Output
16

Code:


import java.io.*;
import java.util.*;

public class Main {
    
    //muje issme bas neighbour ki aur source ki jarurat hai, aur weight ki jarurat nhi hai
    static class Edge {
    int src;
    int nbr;

    public Edge(int src, int nbr) {
      this.src = src;
      this.nbr = nbr;
    }
  }

   public static void main(String[] args) throws Exception {
     Scanner s= new Scanner(System.in);
    
      int n = s.nextInt();
      int k = s.nextInt();
      
      //sabse pehle ek graph banalete
      ArrayList<Integer>[] graph= new ArrayList[n]; // n number of friends hai to utni size ka array banayenge
      
      for( int i=0; i< n; i++){
          graph[i]= new ArrayList<>();
      }
      
      //fir agli K lines uthani haimuje
      for( int i=0; i< k; i++){
          
          //isme a aur b do values aayegi
          int a= s.nextInt();
          int b= s.nextInt();
          graph[b].add(new Edge(b, a)); // graph of b ke samne mai add karunga ek edge, graph[b] is a arraylist. us edge mai b is source aur a is nbr
          graph[a].add(new Edge(a, b));
      } // so ab pura graph ban chuka hai
      
      //ab muje connected components alag karne hai
      
      ArrayList<ArrayList<Integer>> comps= new ArrayList<>();
      
      boolean[] visited = new boolean[n];
      //for every unvisted vertex i'll make call to the gcc 
      for( int i=0; i< visited.length; i++){
          if( visited[i] == false){
              //for every unvisited vertex i'll make a call
              ArrayList<Integer> comp= new ArrayList<>();
              gcc(graph, i, visited, comp);
              comps.add(comp);
          } 
      }
      
      //ab hume apna answer banana hai
      
        int ans= 0;
         for( int i=0; i< comps.size() - 1; i++){ 
             for( int j= i +1; j< comps.size(); j++){
                 ans += comps.get(i).size() * comps.get(j).size();
             }
         }
         
         System.out.println(ans);
      
   }
   
         public static void gcc(ArrayList<Edge>[] graph, int src, boolean visited[],  ArrayList<Integer> comp){ //iss function ka kam hai ki yeh ek component ko comp iss arraylist mai bharke return karwa deta hai 
             
             visited[src]= true; // aatehi src ko visited mark krdo
             comp.add(src); //aur component mai add kare
             
             for(Edge e: graph[src]){
                 //fir aap uske unvisited neighbours pe call lagaoge
                 int nbr = e.nbr;
                 if( visited[nbr] == false){
                     gcc(graph, nbr, visited, comp);
                 }
             }
             
             
         }
   

}
