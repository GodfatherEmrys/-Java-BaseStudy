
public class Main {
	
	public int recursive(int number) {
		/* Base Case */
		/* 종료 조건 */
		if(number == 0) return 0;
		if(number == 1) return 1;
		
		/* 어떤 과정으로 할 것인가 : 점화식, 패턴 */
		return recursive(number-1) + recursive(number-2);
	}
	
	
	public static void main(String[] args) {
		
		
		
	}

}
