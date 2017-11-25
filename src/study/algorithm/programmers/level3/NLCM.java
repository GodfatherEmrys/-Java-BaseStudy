package study.algorithm.programmers.level3;

import java.util.Arrays;

class NLCM {
	
	static long answer = 1;

	public void nlcm(int[] num) {
		
		boolean next = true;
		
		a: while(next) {
			b: for(int k=0;k<num.length;k++) {
				if(num[k] != 1) break a;
			}
		}
		
		for(int i=2;i<num[num.length-1];i++) {
			for(int k=0;k<num.length;k++) {
				if(num[k]%i == 0) num[k]/=i;
			}
			answer*=i;
		}
		
		for(int k=0;k<num.length;k++) {
			if(num[k] != 1) nlcm(num);
		}
		
	}

	public static void main(String[] args) {
		NLCM c = new NLCM();
		int[] ex = { 2, 6, 8, 16 };
		Arrays.sort(ex);
		System.out.println(answer);
	}
}