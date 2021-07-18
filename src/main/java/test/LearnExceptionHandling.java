package test;

public class LearnExceptionHandling {
public static void main(String[] args) {
	int a = 5, b = 0;
	try {
	System.out.println(a/b);
	}
	catch (ArithmeticException e) {
		System.out.println("The number cannot be divisble by Zero");
	}
	System.out.println("Out of Exception");
}
}
