package GettingStarted;

public class incAnddec {

	public static void main(String[] args) {

		int i = 10;
		//System.out.println(i++ +" "+i); o/p: 10 11
		
	    if(i++ == i) { // yahape i 10 tha then i increament hogya to 11 but i++ wale i mai 10 hi rahega aur == ke bad wale i mai 11 rahega, so 10 compare ho rha hai with 11 which is false
		 System.out.println(i + " is good");
	    }
	    else {
	 	 System.out.println(i + " is bad");
	    }
	 
	    int j = 20;
	    if(++j == j) //yahape pehlehi j increament hogya to 21 and then 21 compare hua 21 ke sath coz == ke bad ke i ki value bhi 21hogyi hai so condition is false
	 	 System.out.println(j + " is good");
	    else
	 	 System.out.println(j + " is bad");
	}
}

Output:

11 is bad
21 is good

