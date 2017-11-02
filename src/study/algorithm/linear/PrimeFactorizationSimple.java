/**
 * @Study Information.
 * @Reference: Algorithm Problem Solving Strategies.
 * @Problem Prime Factorization
 */

package study.algorithm.linear;

import java.util.ArrayList;

/**
 * Prime Factorization Algorithm simple way.
 * @author Emrys
 * #Prime Factorization
 * #Linear function
 * #Exponential time
 */
public class PrimeFactorizationSimple {

	/**
	 * Test main function()
	 * @param args
	 */
	public static void main(String[] args) {
		int problem = 100;
		ArrayList<Integer> result = factorization(problem);
		for(int i = 0; i < result.size(); ++i) {
			System.out.println(result.get(i));
		}

	}
	
	/**
	 * Prime Factorization function.
	 * Exponential time.
	 * @param number
	 * @return						ArrayList<Integer>.
	 */
	static ArrayList<Integer> factorization(int number){
		if(number == 1) return new ArrayList<Integer>(1);
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int div = 2; number > 1; ++div) {
			while(number % div == 0) {
				number /= div;
				result.add(div);
			}
		}
		return result;
	}
}
