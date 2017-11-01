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
 * Linear function,
 * Moving Average,
 */
public class DietCheck {
	
	/**
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
		
		movingAverageList  = movingAverageOne(dietList, checkMALength);
		
		for(int i = 0; i < movingAverageList.size(); i++) {
			System.out.println(movingAverageList.get(i));
		}
		
		sc.close();
	}
	
	/**
	 * 
	 * @param dietList			the list of diet records.
	 * @param checkMALength		Moving Average Length for checking.
	 * @return					the list of Moving Average. (size() == dietList.size - checkMALength)
	 */
	public static ArrayList<Double> movingAverageOne(ArrayList<Double> dietList, int checkMALength){
		/*
		if(dietList.size() < checkMALength) throw new ArrayIndexOutOfBoundsException("MA check Length can not over diet records list size.");
		*/
		ArrayList<Double> result = new ArrayList<Double>();
		int wholeDays = dietList.size();	
		
		for(int i = checkMALength-1; i < wholeDays; ++i) {
			double partialSum = 0;
			for(int j = 0; j < checkMALength; ++j) partialSum += dietList.get(i-j);
			result.add(partialSum / checkMALength);
		}
		
		return result;
	}
}
