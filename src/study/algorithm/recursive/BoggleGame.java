/**
 * @author Emrys.
 * Algorithm Study.
 * @Recursivefunction/recursion
 * @BruteForce
 * @ExhaustiveSearch
 * @BoggleGame
 */
package study.algorithm.recursive;

public class BoggleGame {
	
	/* for direction */
	static int dx[] = { -1, -1, -1, 1, 1 ,1 , 0, 0 };
	static int dy[] = { -1, 0, 1, -1, 0, 1, -1, 1 };
	
	/* boggle game board */
	static char board[][] = {
							{'U','R','L','P','M'},
							{'X','P','R','E','T'},
							{'G','I','A','E','T'},
							{'X','T','N','Z','Y'},
							{'X','O','Q','R','S'}
							};
	
	public static void main(String[]args) {
		System.out.println(hasWord(1,2,"RETTYS"));
	}
	
	/**
	 * Recursive Function
	 * @param y
	 * @param x
	 * @param word
	 * @return
	 */
	static boolean hasWord(int y, int x, String word) {
		
		/* base cases */
		if(!inRange(y, x)) return false;
		if(board[y][x] != word.charAt(0)) return false;
		if(word.length() == 1) return true;
		
		/* recursive part */
		for(int direction = 0; direction < 8; ++direction) {
			int nextY = y + dy[direction], nextX = x + dx[direction];
			if(hasWord(nextY, nextX, word.substring(1))) return true;
		}
		
		/* fail case? */
		return false;
	}
	
	/* direction checker whether in board or not */
	static boolean inRange(int y, int x) {
		return !((x < 0 || y < 0) || (x >= board.length || y >= board.length));
	}
}
