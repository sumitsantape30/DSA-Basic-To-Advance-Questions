package Graphs;

import java.util.ArrayList;

public class intro {
	
    //adjacency list ko banake print karna hai 
	
	//muje chahiye ek edge class, jo pair class hai usko edge class bolre
	public static class Edge{
		int src;
		int nbr;
		int wt;
		//bina source kebhi kam chal jeyega
		
		public Edge(int src, int nbr, int wt) {
			this.src= src;
			this.nbr= nbr;
			this.wt = wt;
		}
	}

	public static void main(String[] args) {

		// graph arraylists ka array hai
		//array ke samne arraylist rakhi hai
		ArrayList<Edge>[] graph= new ArrayList[7];
		
		for( int i=0; i< graph.length; i++) { //harjagh null pda hoga so new arraylist dalke ayenge karna padega
			graph[i]= new ArrayList<>();
		}
		
		graph[0].add(new Edge(0, 1, 10)); //graph array ke 0th pe rakhi hui arraylist mai new Pair/edge dal rh hai
		graph[0].add(new Edge(0, 3, 40)); //0 ka ek aur neighbour hai 3 aur uska edge weight hai 40
		
		graph[1].add(new Edge(1, 1, 10));
		graph[1].add(new Edge(1, 2, 10));
		
		graph[2].add(new Edge(2, 1, 10));
		graph[2].add(new Edge(2, 1, 10));
		
		graph[3].add(new Edge(3, 0, 10));
		graph[3].add(new Edge(3, 2, 10));
		graph[3].add(new Edge(3, 4, 3));
		
		graph[4].add(new Edge(4, 3, 3));
		graph[4].add(new Edge(4, 5, 3));
		graph[4].add(new Edge(4, 1, 7));
		
		graph[5].add(new Edge(5, 4, 3));
		graph[5].add(new Edge(5, 6, 2));
		
		graph[6].add(new Edge(6, 4, 7));
		graph[6].add(new Edge(6, 5, 2));
		
		//ab muje iss graph ko print karna hai
		
		for( int i=0; i< graph.length; i++) { //so itne number of vertices hai
			
			System.out.print(i+" -> ");
			
			//har vertice ke samne ek arraylist stored hogi so uspe loop chalaya
			for( Edge e: graph[i]) { // graph[i] is an arraylist aur uspe for each loop chala diya to ek ek edge mere pas bahar ata rahega
				
				System.out.print("["+ e.nbr + "@" + e.wt + "]");
			}
			//ek vertice ki arraylist print hone ke bad enter mardo
			System.out.println();
		}
		
	}

}

Output:

0 -> [1@10][3@40]
1 -> [1@10][2@10]
2 -> [1@10][1@10]
3 -> [0@10][2@10][4@3]
4 -> [3@3][5@3][1@7]
5 -> [4@3][6@2]
6 -> [4@7][5@2]
