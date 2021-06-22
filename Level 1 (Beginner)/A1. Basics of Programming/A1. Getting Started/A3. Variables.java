package GettingStarted;

public class variables {

	public static void main(String[] args) {

		//Additon
		int x= 15; //jaisehi yeh statement run hua to RAM ke andar ek location ka nam pd jayega x and wahapr values store hojayegi 15
		int y= 10; // jab yeh statement run hoga to RAM mai ek location ka nam pad jayega y and wahape 10 store hoga
		int sum= x+ y; //yeh statement run hone ke bad memory location pd jayega sum fir cumputer dekhega ki x likha hai so woh RAM mai x dhundne ki koshish karega location milegi wahase 15 value uthayega similarly y dhundega waha use 10 milega and dono ko add krke sum wali location pe dal dega
		System.out.println(sum);
		
		//Product
		int prd= x*y;
		System.out.println(prd);
		
		//Divide
		int v1= x / y; // yeh hume sirf quotient dega
		int v2= y / x;
		int v3= x % y; // yeh hume remainder dega
		System.out.println(v1+" "+v2+" "+v3);
		
		//Now I want to solve the equation
		int exp= (x * y) / (x+ y); //yaha * / % ki priority same hoti hai and > + - hoti hai aur +- ki priority apas mai same hoti hai ,yaha BODMAS jaisa kuch nhi hai, so priority barabr hone ke karan woh pehle usko solve krta hai jo left hand side pe hota hai
		//eg.  a*b/c = yahape * sabse pehle hoga and then divide karega so hume brackets lagane honge 
		System.out.println(exp);
		
	}

}

Output:
25
150
1 0 5
6
//====================================================== Question===============================================
What is the output of following code?
   
   int a = 10; 
   int b = 20;
   a = a + b;
   b = a - b;
   a = a - b;
   
   System.out.println(a + " " + b);
                               
Options
 
10 10
   
20 20
   
20 10
    
10 20
  
Answer: 20 10
int a = 10; // assigns 10 to a
int b = 20; // assigns 20 to b

a = a + b; // a is now 30;
b = a - b; // b = 30 - 20, b is now 10 and a stays 30
a = a - b; // a = 30 - 10, a is now 20 and b stays 10
