import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print(Calculator.Calculate("1+1"));	
		} catch(Exception e) {
			e.printStackTrace();
		}
		sc.close();	
	}
}
