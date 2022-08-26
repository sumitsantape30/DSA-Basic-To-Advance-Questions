package practice;
import java.util.*;
public class Accenture {
	
	public static void method1( int a, int b) {
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("a: "+a+"&"+" b: "+b);
	}
	
	public static void method2( int a, int b) {
		a = a * b;
		b = a / b;
		a = a / b;
		System.out.println("a: "+a+"&"+" b: "+b);
	}
	
	public static void method3( int a, int b) {
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println("a: "+a+"&"+" b: "+b);
	}
	
	public static void method4( int a, int b) {
		
		int temp = a;
		a = b;
		b = temp;
		System.out.println("a: "+a+"&"+" b: "+b);
	}

	public static void main(String[] args) {
		int a = 36;
		int b = 32;
		
		method1(a, b);
		method2(a, b);
		method3(a, b);
		
	}

}
