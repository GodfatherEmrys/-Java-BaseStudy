package study.javabase.common;

public class BreakLabel {
	
	@SuppressWarnings("unused")
	public static void main(String[]args) {
		/**
		 * 기존의 break문은 그 break가 속해있는 반복문을 빠져나가는 명령어였다.
		 * 만약 Break Label을 설정하고 break를 사용할 때 Break Label을 지정한다면
		 * break는 속해있는 반복문이 아닌 Break Label이 가리키고 있는 반복문을 탈출하게 된다. 
		 */
		FirstBreakLabel: for(int i = 0; i < 5; i++) {
			System.out.println("i: " + i);
			SecondBreakLabel: for(int k = 0; k < 10; k++) {
				System.out.println("k: " + k);
				ThirdBreakLabel: for(int p = 0; p < 15; p++) {
					System.out.println("p: " + p);
					if(p == 9) break FirstBreakLabel;
				}
			}
		}
		
	}
}
