package study.javabase.io;

import java.util.ArrayList;

public class CallByReference {
	
	public static void main(String[]args) {
		
		/* Reference */
		ArrayList<Integer> arrNum = new ArrayList<>();
		/* Call by reference */
		someMethod(arrNum);
		/* Check value */
		for(int i=0; i<arrNum.size();i++) {
			System.out.println(arrNum.get(i));
		}
		
	}
	
	static boolean someMethod(ArrayList<Integer> arrNum) {
		arrNum.add(1);
		return true;
	}
	
}
