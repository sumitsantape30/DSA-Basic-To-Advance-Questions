package temp;

import java.util.ArrayList;
import java.util.Scanner;

public class VehicleUse {
	

	public static void main(String[] args) {
		
		Scanner s= new Scanner(System.in);
		int n = s.nextInt();
		
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
		
		for( int i=0; i<= n; i++) { //n = 1 based indexing rhi to n+1 arraylists dalni padegi
			adj.add( new ArrayList<Integer>());
		}
		
		adj.get(1).add(2);
		adj.get(2).add(1);
		
		adj.get(2).add(3);
		adj.get(3).add(2);
		
		adj.get(1).add(3);
		adj.get(3).add(1);
		
		for( int i=0; i< adj.size(); i++) {
			
			ArrayList<Integer> list = adj.get(i);
			for( int ele: list) {
				System.out.print(ele);
			}
			System.out.println();
		}
	}

}
