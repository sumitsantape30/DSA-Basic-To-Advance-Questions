//==Variation 1====
public static int powerLinear(int x, int n) {
		
		if( n == 0) {
			return 1;
		}
		
		int xnm1= powerLinear(x , n-1);
		int pow= xnm1 * x;
		return pow;
	}

//Variation 2====
public static int Power(int x, int n) {
		if( n == 0) {
			return 1;
		}
		
		int xn= Power(x, n/2)*Power(x, n/2); 
		
		if( x % 2 != 1) { 
			xn *= x;
		}
		return xn;
	}

//Variation 3=====
public static int Power(int x, int n) {
		if( n == 0) {
			return 1;
		}
		
		int xpnb2= Power(x, n/2); 
		int xn= xpnb2* xpnb2;
		
		if( x % 2 == 1) { 
			xn *= x;
		}
		return xn;
	}
