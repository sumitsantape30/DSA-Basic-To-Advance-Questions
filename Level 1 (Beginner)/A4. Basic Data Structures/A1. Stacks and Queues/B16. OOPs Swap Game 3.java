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
		// kisi chiz ko hum new krte hai aur usme values aasign nhi kari hoti hai to integers by default 0 hote hai aur strings by default null hoti hai
		
		prsn1= new Person(); /p1 new kardiya ab purane p1 mai koi change nhi aayega. jobhi change honge woh new p1 mai hi honge 
		
		int age= prsn1.age;
		prsn1.age= prsn2.age;
		prsn2.age= age;
		
		prsn2= new Person();
		
		String name= prsn1.name;
		prsn1.name= prsn2.name;
		prsn2.name= name;
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
		
		p1.saysHi();
		p2.saysHi();
		swap1(p1, p2);
		System.out.println();
		p1.saysHi();
		p2.saysHi();
		
	}
}


