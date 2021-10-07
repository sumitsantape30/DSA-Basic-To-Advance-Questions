package practice;

import java.util.*;
import java.util.HashMap;

public class Code {

	
	public static void main(String[] args) throws Exception {

	/*
		HashMap<String, Integer> map= new HashMap<String, Integer>();
		map.put("India", 145); //keys are always unique
		map.containsKey("China");
		map.remove("USA");
		map.get("India");
		map.getOrDefault("India", 0); // agar present hai to india ki value dedo aagar nhi milti hai to default value 0 dedo
		map.size(); //kitni keys hai
		
		map.keySet(); //sari ki sari keys mil jayegi

		// all these functions are o(1) ( */
		
		HashMap<String, Integer> map= new HashMap<>();
		map.put("India", 135);
		map.put("China", 190);
		map.put("USA", 90);
		map.put("China", 191);
		map.put("Pakistan", 60);
		
		System.out.println(map.size());
		System.out.println(map);
		
		map.remove("Pakistan");
        System.out.println(map);
        
        System.out.println(map.get("USA"));
        
        if( map.containsKey("India") == true) {
        	System.out.println("Hurray");
        }
        
        ArrayList<String> keys= new ArrayList<>(map.keySet());
        for(String key: keys) {
        	System.out.println(key);
        }
	}
}
