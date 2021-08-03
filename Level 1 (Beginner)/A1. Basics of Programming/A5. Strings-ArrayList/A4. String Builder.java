
class HelloWorld {
    public static void main(String[] args) {
        StringBuilder sb= new StringBuilder("Hello");
        System.out.println(sb);
        
        char ch= sb.charAt(0); //get
        System.out.println(ch);
        
        sb.setCharAt(0,'d'); //update/replace
        System.out.println(sb);
        //So string builder mai hum string mai set bhi kr skte hai 
        
        //kahibichme character insert karne keliye aur setChar se uss index pe koi character replace kr skte hai
        sb.insert(2, 'y'); // insert
        System.out.println(sb);
        
        //ab koi index se koi character delete karne keliye
        sb.deleteCharAt(2); //delete
        System.out.println(sb);
        
        sb.append('g');// last mai add karne keliye
        
        System.out.println(sb.length());
        
        //iss string builder ko string mai convert karne keliye tostring function use kr skte hai
    }
}

Output:
java -cp /tmp/TwPXJxGR5f HelloWorld
Hello
H
dello
deyllo
dello
6

//====================================================To count the time required =================================================================

    // String jada time lete hai than string builder so string builder performance wise string builder superior hai
       //String
        String s = "hello";
		
		long start= System.currentTimeMillis();
		
		for( int i= 1; i<= 100000; i++) {
			s += 'e';
		}
		long end= System.currentTimeMillis();
		
		long duration= end- start;
		System.out.println(duration);


        //String Builder
       StringBuilder sb= new StringBuilder("Hello");
		
        long start= System.currentTimeMillis();
		
		for( int i= 1; i<= 10000; i++) {
			sb.append('e');
		}
		long end= System.currentTimeMillis();
		
		long duration= end- start;
		System.out.println(duration);
