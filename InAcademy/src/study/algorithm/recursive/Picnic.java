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
		
		int testcase = sc.nextInt();
		
		for(int i = 0; i < testcase; ++i) {
			number = sc.nextInt();
			int friendscase = sc.nextInt();
			areFriends = new boolean[number][number];
			boolean taken[] = new boolean[number];
			for(int j = 0; j < friendscase; ++j) {
				int y = sc.nextInt();
				int x = sc.nextInt();
				areFriends[y][x] = true;
				areFriends[x][y] = true;
			}
//			System.out.println(wrongCountPairings(taken));
			System.out.println(countPairings(taken));
		}
		sc.close();
	}
	
	/* Wrong Recursive Method */
	static int wrongCountPairings(boolean taken[]) {
		
		boolean finished = true;
		for(int i = 0; i < number; ++i) if(!taken[i]) finished = false;
		
		/* base case */
		if(finished) return 1;
		
		int result = 0;
		for(int i=0; i < number; ++i) {
			for(int j=0; j < number; ++j) {
				if(!taken[i] && !taken[j] && areFriends[i][j]) {
					taken[i] = taken[j] = true;
					result += wrongCountPairings(taken);
					taken[i] = taken[j] = false;
				}
			}
		}
		return result;
	}
	
	/* Right Recursive Method */
	static int countPairings(boolean taken[]) {
		int firstFree = -1;
		for(int i = 0; i < number; ++i) {
			if(!taken[i]) {
				firstFree = i;
				break;
			}
		}
		
		/* base case */
		if(firstFree == -1) return 1;
		
		int result = 0;
		for(int pairWith = firstFree + 1; pairWith < number; ++pairWith) {
			if(!taken[pairWith] && areFriends[firstFree][pairWith]) {
				taken[firstFree] = taken[pairWith] = true;
				result += countPairings(taken);
				taken[firstFree] = taken[pairWith] = false;
			}
		}
		return result;
	}
}
