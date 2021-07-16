
class HelloWorld {
    public static void main(String[] args) {
        StringBuilder sb= new StringBuilder("Hello");
        System.out.println(sb);
        
        char ch= sb.charAt(0); //get
        System.out.println(ch);
        
        sb.setCharAt(0,'d'); //update/replace
        System.out.println(sb);
        //So string builder mai hum string mai set bhi kr skte hai 
        
        //kahibichme character insert karne keliye setChar se uss index pe koi character replace kr skte hai
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
