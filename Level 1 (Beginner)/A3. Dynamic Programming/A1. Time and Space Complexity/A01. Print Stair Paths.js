public static void printStairPaths(int n, String asf) {
		
		if( n < 0) { 
			return; 
		}
		
		if( n == 0) { 
			System.out.println(path);
			return;
		}
		
		printStairPaths( n -1 , asf + "1"); 
		printStairPaths( n -2, asf + "2"); 
		printStairPaths( n -3, asf + "3"); 
 }
