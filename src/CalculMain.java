import java.util.ArrayList;
import java.util.Arrays;

public class CalculMain {
	
	static int answer = 0;
	public int solution(String arr[]) {
		answer = recursiveSolution(answer, arr);
		
		return answer;
	}
	
	public int recursiveSolution(int answer, String arr[]) {
		
		if(arr.length < 3) {
			int newAnswer = Integer.parseInt(arr[0]);
			return answer > newAnswer ? answer : newAnswer;
		}
		int i = 0;
		while(arr.length < 3) {
			ArrayList<String> arrList = new ArrayList<String>(Arrays.asList(arr));
			if(arrList.size() <= 3) {
				int newAnswer = calculator(arr[i],arr[i+1],arr[i+2]);
				return answer > newAnswer ? answer : newAnswer;
			}
			for(int k=i;k<i+3;k++) arrList.remove(i);
			arrList.add(i, String.valueOf(calculator(arr[i],arr[i+1],arr[i+2])));
			for(int k=0;k<arrList.size();k++) System.out.println("List?"+arrList.get(k));
			recursiveSolution(answer, arrList.toArray(new String[arrList.size()]));
		}
		
		return answer;
	}
	    
	public int calculator(String aNumber, String calc, String bNumber) {
		if("+".equals(calc)) {
			return Integer.parseInt(aNumber)+Integer.parseInt(bNumber);
		} else if ("-".equals(calc)) {
			return Integer.parseInt(aNumber)-Integer.parseInt(bNumber);
		} else {
			throw new NumberFormatException();
		}
	}
	
	public static void main(String[]args) {
		CalculMain cc = new CalculMain();
		String arr[] = {"1", "-", "3", "+", "5", "-", "8"};
		System.out.println(cc.solution(arr));
	}
	
}