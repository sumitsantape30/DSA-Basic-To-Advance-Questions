Arrange Buildings

1. You are given a number n, which represents the length of a road. The road has n plots on it's each side.
2. The road is to be so planned that there should not be consecutive buildings on either side of the road.
3. You are required to find and print the number of ways in which the buildings can be built on both side of roads.
Input Format
A number n
Output Format
A number representing the number of ways in which the buildings can be built on both side of roads.
Question Video

  COMMENTConstraints
0 < n <= 45
Sample Input
6
Sample Output
441

Code:

public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		
		long dp1[]= new long[n+1]; 
		long dp2[]= new long[n+1]; 
		
		dp1[0]=1; 
		dp2[0]= 1; 
		
		for( int i=2; i< dp1.length; i++) {
			dp1[i] = dp2[i-1]; 
			dp2[i]= dp1[i-1] + dp2[i-1] ;
			
		}
		
		long ans= dp1[n] + dp2[n];
		System.out.println(ans*ans);
		
	}
