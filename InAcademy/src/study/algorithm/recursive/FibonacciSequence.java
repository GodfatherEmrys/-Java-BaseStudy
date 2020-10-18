/**
 * @author Emrys.
 * Algorithm Study.
 * @Recursivefunction.
 * @FibonacciSequence.
 */

package study.algorithm.recursive;

import java.util.Scanner;

public class FibonacciSequence {
	
	/**
	 * main.
	 * @param args.
	 * @input: (Integer).
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Input number: ");
		try {
			int inputNumber = sc.nextInt();
			fibonacciPrint(inputNumber);
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
		sc.close();
	}
	
	/**
	 * @function() fibonacci sequence by recursive function.
	 * @param (Integer)inputNumber.
	 * @return (Integer).
	 */
	private static int fibonacci(int inputNumber) {
		if(inputNumber < 2) return inputNumber;
		return fibonacci(inputNumber-1) + fibonacci(inputNumber-2);
	}
	
	/**
	 * @function() fibonacci sequence Printing method.
	 * @param (Integer)number.
	 * @return : Recursion termination == (forPrintNumber == inputNumber)
	 */
	static int forPrintNumber = 1;
	private static void fibonacciPrint(int inputNumber) {
		if(forPrintNumber == inputNumber) {
			System.out.print("[" + forPrintNumber + "]" + fibonacci(forPrintNumber));
			return;
		}
		System.out.print("[" + forPrintNumber + "]" + fibonacci(forPrintNumber) + " => ");
		forPrintNumber++;
		fibonacciPrint(inputNumber);
	}
}
