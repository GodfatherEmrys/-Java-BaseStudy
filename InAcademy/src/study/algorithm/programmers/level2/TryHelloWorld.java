package study.algorithm.programmers.level2;

public class TryHelloWorld {
	
	public String getDayName(int a, int b) {
		
		String answer = "";
		
		int days = 0;
		
		switch(a){
			case 12: days += 30;
			case 11: days += 31;
			case 10: days += 30;
			case 9: days += 31;
			case 8: days += 31;
			case 7: days += 30;
			case 6: days += 31;
			case 5: days += 30;
			case 4: days += 31;
			case 3: days += 29; 
			case 2: days += 31;
			case 1: days += b; break;
		}
		
		switch(days%7) {
			case 1: return "FRI";
			case 2: return "SAT";
			case 3: return "SUN";
			case 4: return "MON";
			case 5: return "TUE";
			case 6: return "WED";
			case 0: return "THU";
		}
		return answer;
	}
	
	public static void main(String[]args) {
		TryHelloWorld test = new TryHelloWorld();
		int a = 5, b = 24;
		System.out.println(test.getDayName(a, b));
	}
}
