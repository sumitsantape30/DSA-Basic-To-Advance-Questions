 public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) { 
    	if( sr > dr || sc > dc) { 
    		return;
    	}
    	
    	if( sr == dr && sc == dc) { 
    		System.out.println(psf);
    		return;
    	}
        
    	printMazePaths(sr, sc+1, dr, dc, psf + "h");
    	printMazePaths( sr +1, sc, dr, dc, psf + "v"); 
    }
