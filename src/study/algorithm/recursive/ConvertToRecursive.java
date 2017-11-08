/**
 * @author Emrys.
 * Algorithm Study.
 * @Recursivefunction.
 */
package study.algorithm.recursive;

import java.util.Scanner;

public class ConvertToRecursive {
	
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(recursiveSum(sc.nextInt()));
		sc.close(); 
	}
	
	/**
	 * 
	 * @param number
	 * @return
	 */
	static int forEachSum(int number) {
		int result = 0;
		for (int i = 1; i <= number; ++i) result += i;
		return result;
	}
	
	/**
	 * 
	 * @param number
	 * @return
	 */
	static int recursiveSum(int number) {
		if(number == 1) return 1;
		return number + recursiveSum(number - 1);
	}
	
}
