package practice;

import java.util.*;

public class Code {

	public static void main(String[] args) throws Exception {
		
		PriorityQueue<Integer> pq= new PriorityQueue<>();
		
		pq.add(10);
		pq.add(18);
		pq.add(-1);
		pq.add(6);
		pq.add(22);

		while(pq.size() != 0) {
			System.out.println(pq.peek());
			pq.remove();
		}

	}
}
