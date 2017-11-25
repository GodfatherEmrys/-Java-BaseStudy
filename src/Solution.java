import java.util.ArrayList;
import java.util.List;

class Solution {
	
	public static void main(String[]args) {
		Solution s = new Solution();
		int[][] maps = {
				{1, 0, 1, 1, 1},
				{1, 0, 1, 0, 1},
				{1, 0, 1, 1, 1},
				{1, 1, 1, 0, 1},
				{0, 0, 0, 0, 1}
				};
		
		System.out.println(s.solution(maps));
	}
	
	int[] dirX = { -1, 0, 1, 0 };
	int[] dirY = { 0, 1, 0, -1 };
	
	static List<Integer> pointList = new ArrayList<Integer>();
	
	public int solution(int[][] maps) {
		
		int answer = 0;
		int movePoint = 0;

		boolean result = solu(0, 0, maps, movePoint);
		
		if(result) {
			answer = pointList.get(0);
		} else {
			return -1;
		}
		for(int i=0;i<pointList.size(); i++) {
			System.out.println(pointList.get(i));
			if(answer > pointList.get(i)) answer = pointList.get(i);
		}
		
		return answer;
	}

	public boolean solu(int x, int y, int[][] maps, int movePoint) {
		
		if((x >= maps.length || y >= maps.length) || (x < 0 || y < 0)) return false;
		
		if(maps[x][y] != 1) return false;
		else maps[x][y] = 8;
		
		for(int i=0;i<maps.length;i++) {
			for(int k=0;k<maps[i].length;k++) {
				System.out.print(maps[i][k] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		movePoint++;
		
		if(x == maps.length-1 && y == maps.length-1) {
			pointList.add(movePoint);
		}

		System.out.println(movePoint);
		for(int i=0; i < 4; i++) {
			int newX = x+dirX[i];
			int newY = y+dirY[i];
			solu(newX, newY, maps, movePoint);
		}
		return true;
	}
}