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
		
		int age= prsn1.age;
		prsn1.age= prsn2.age;
		prsn2.age= age;
		
		String name= prsn1.name;
		prsn1.name= prsn2.name;
		prsn2.name= name;
	} //isbar maine properties change kardi sidha prsn1 ka name hi change kardiya, mai jo change leke aya woh heap mai leke aya, heap mai aap jo change leke aate ho to woh change persist karega. last wale mai bas reference/address change kiya tha bas to woh function khatam hote hi woh wipeout hojayega, uss function mai jitne bhi functions, variable honge woh gayab.

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
// Isme swap hoga, memory mai kaise store hora woh sab dekho pta chalega
