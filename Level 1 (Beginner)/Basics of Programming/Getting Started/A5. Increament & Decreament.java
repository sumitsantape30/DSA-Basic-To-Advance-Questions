package GettingStarted;

public class incAnddec {

	public static void main(String[] args) {

		int i = 10;
	    if(i++ == i) { // yahape i 10 tha then i increament hogya to 11 aur 11 compare hua 10 ke sath so condition is false
	 	 System.out.println(i + " is good");
	    }
	    else {
	 	 System.out.println(i + " is bad");
	    }
	 
	    int j = 20;
	    if(++j == j) //yahape pehlehi j increament hogya to 21 and then 21 compare hua 21 ke sath which is false
	 	 System.out.println(j + " is good");
	    else
	 	 System.out.println(j + " is bad");
	}

}
