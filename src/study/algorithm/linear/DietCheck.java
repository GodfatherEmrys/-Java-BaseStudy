/**
 * @Study Information.
 * @Reference: Algorithm Problem Solving Strategies.
 * @MovingAverage
 */

package study.algorithm.linear;

import java.util.ArrayList;

import java.util.Scanner;

/**
 * @author Emrys.
 * #Linear function,
 * #Moving Average,
 * #Time Complexity,
 */
public class DietCheck {
	
	/**
	 * Test main function().
	 * @param args
	 */
	public static void main(String[]args) {

		Scanner sc = new Scanner(System.in);
		
		ArrayList<Double> dietList = new ArrayList<Double>();
		ArrayList<Double> movingAverageList;
		
		System.out.print("Input the count of diet records: ");
		int checkDays = sc.nextInt();
		
		for(int i = 0; i < checkDays; i++) {
			dietList.add(sc.nextDouble());
		}
		
		System.out.print("Input the MA[Moving Average] check Length: ");
		int checkMALength = sc.nextInt();
		
		movingAverageList  = movingAverageSecondWay(dietList, checkMALength);
		
		for(int i = 0; i < movingAverageList.size(); i++) {
			System.out.println(movingAverageList.get(i));
		}
		
		sc.close();
	}
	
	/**
	 * This is simple way to get result, however, if it can not process for diet list of huge size.
	 * { N - (M - 1) } * N = N^2 - M*N + N = O(N^2)
	 * @param dietList			the list of diet records.
	 * @param checkMALength		Moving Average Length for checking.
	 * @return					the list of Moving Average. (size() == dietList.size - checkMALength)
	 */
	public static ArrayList<Double> movingAverageFirstWay(ArrayList<Double> dietList, int checkMALength){
		
		ArrayList<Double> result = new ArrayList<Double>();
		int wholeDays = dietList.size();	
		
		for(int i = checkMALength-1; i < wholeDays; ++i) {
			double partialSum = 0;
			for(int j = 0; j < checkMALength; ++j) partialSum += dietList.get(i-j);
			result.add(partialSum / checkMALength);
		}
		
		return result;
	}
	
	/**
	 * This way can remove duplicate calculation.
	 * M - 1 + { N - ( M - 1 ) } = O(N)
	 * @param dietList			the list of diet records.
	 * @param checkMALength		Moving Average Length for checking.
	 * @return					the list of Moving Average. (size() == dietList.size - checkMALength)
	 */
	public static ArrayList<Double> movingAverageSecondWay(ArrayList<Double> dietList, int checkMALength){
		
		ArrayList<Double> result = new ArrayList<Double>();
		int wholeDays = dietList.size();
		double partialSum = 0;
		
		for(int i=0; i < checkMALength - 1; i++) partialSum += dietList.get(i);
		
		for(int i = checkMALength - 1; i < wholeDays; ++i) {
			partialSum += dietList.get(i);
			result.add(partialSum / checkMALength);
			partialSum -= dietList.get(i - checkMALength + 1);
		}
		
		return result;
	}
}
