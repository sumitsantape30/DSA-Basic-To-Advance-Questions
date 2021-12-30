package practice;
import java.util.*;
import java.io.*;

public class Codes {	
	 
	public static void main(String[] args) {
	
		//Queue ek interface hai usko ArrayDeque class aur Linkedlist class Queues ko implement krte hai
		Queue<Integer> que= new ArrayDeque<Integer>();
		
		que.add(10);
		System.out.println(que);
		que.add(20);
		que.add(30);
		que.add(40);
		
		System.out.println(que.peek());
		
		while(!que.isEmpty()){
			System.out.println(que.remove());
		}
		
	}

}
