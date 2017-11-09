package study.algorithm.exhaustivesearch;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class BoardCover {
	
	static int coverType[][][] = {
			{{0, 0},{1, 0},{0, 1}},
			{{0, 0},{0, 1},{1, 1}},
			{{0, 0},{1, 0},{1, 1}},
			{{0, 0},{1, 0},{1, -1}}
			};
	
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);

		sc.close();
	}

	static boolean set(ArrayList<ArrayList<Integer>> board, int y, int x, int type, int delta){
		boolean ok = true;
		for (int i = 0; i < 3; ++i){
			int ny = y + coverType[type][i][0];
			int nx = x + coverType[type][i][1];
			if (ny < 0 || ny >= board.size() || nx < 0 || nx >= board.get(0).size()) ok = false;
		}

		return false;
	}
}
