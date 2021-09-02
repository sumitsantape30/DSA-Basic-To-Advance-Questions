package Stack;


public class SwapGame1 {
	
	public static class Person{
		int age;
		String name;
		
		void saysHi() {
			System.out.print(name+"["+age+"] says hi ");
		}
	}
	
	public static void swap1(Person prsn1, Person prsn2) {
		
		Person temp= prsn1; //temp bas naya reference banaya hai, naya instance nhi banaya hai
		prsn1= prsn2;
		prsn2= temp;
	}

	public static void main(String[] args) {

		Person p1= new Person();
		p1.age = 10;
		p1.name= "A";
		//p1.saysHi();
		
		Person p2= new Person();
		p2.age= 20;
		p2.name= "B";
		//p2.saysHi();
		                                                                                             
		//swap karne se pehle aur swap karne ke bad dono ki property call karenge taki hume pta chale
		p1.saysHi();
		p2.saysHi();
		swap1(p1, p2);
		System.out.println();
		p1.saysHi();
		p2.saysHi();
		
		// swap function mai jo references swap hue the  hue but jab function khatam hua to mar gye isliye swap nhi hua.
	}

}
