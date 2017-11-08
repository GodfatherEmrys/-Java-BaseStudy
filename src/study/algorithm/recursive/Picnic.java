/**
 * Studying...
 */
package study.algorithm.recursive;

import java.util.Scanner;

public class Picnic {

	static int number;
	static boolean areFriends[][];
	
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		boolean taken[] = { false, false, false, false, false, false, false, false, false, false, false };
		int testcase = sc.nextInt();
		
		for(int i = 0; i < testcase; ++i) {
			number = sc.nextInt();
			int friendscase = sc.nextInt();
			areFriends = new boolean[number][number];
			for(int j = 0; j < friendscase; ++j) {
				int y = sc.nextInt();
				int x = sc.nextInt();
				areFriends[y][x] = true;
			}
			System.out.println(countPairings(taken));
		}
		sc.close();
	}
	
	static int countPairings(boolean taken[]) {
		boolean finished = true;
		for(int i=0; i< number; ++i) if(!taken[i]) finished = false;
		if(finished) return 1;
		int result = 0;
		for(int i=0; i < number; ++i) {
			for(int j=0; j < number; ++j) {
				if(!taken[i] && taken[j] && areFriends[i][j]) {
					taken[i] = taken[j] = true;
					result += countPairings(taken);
					taken[i] = taken[j] = false;
				}
			}
		}
		return result;
	}
}
