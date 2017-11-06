package study.javabase.io;

public class CallByValue {
	
	public static void main(String[]args) {
		
		/* Value */
		int number = 5115;
		/* Call by value */
		someMethod(number);
		/* Check value */
		System.out.println(number);
		
	}
	
	static boolean someMethod(int number) {
		number++;
		return true;
	}
}
