

Code:

package Codes;

import java.util.*;
import java.io.*;

public class code {

	// faith and expectations
	private static Stack<Integer> sortedStack(Stack<Integer> st) {
		// Base condition
		if (st.size() == 1) {
			return st;
		}
		int topEl = st.pop();

		sortedStack(st); // faith

		// bache hume element ko hum sorted stack mai insert krdenge
		return insertElementAt(st, topEl);
	}

	private static Stack<Integer> insertElementAt(Stack<Integer> st, int el) {
		// Base condition
		if (st.size() == 0 || st.peek() <= el) { // agar ele stack ke peek se chota hai to stack mai dal denge
			st.push(el);
			return st;
		}

		// top element se el bada hai so usko pop karenge aur bolenge bache hue stack mai el ko dalde
		int topEl = st.pop();

		insertElementAt(st, el);

		// fir topEl ko dal denge stack mai
		st.push(topEl);
		return st;
	}

	public static void main(String args[]) {

		Stack<Integer> st = new Stack<>();
		st.push(9);
		st.push(3);
		st.push(5);
		st.push(10);

		System.out.println("Stack before sorting:");
		for (Integer s : st) {
			System.out.print(s + " ");
		}

		System.out.println("\nStack after sorting:");
		Stack<Integer> sorted = sortedStack(st);
		for (Integer i : sorted) {
			System.out.print(i + " ");
		}
	}

}

//input & output
Stack before sorting:
9 3 5 10 
Stack after sorting:
3 5 9 10 
