import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * 1보다 큰 N개의 도시 중 한 곳에 공항을 지을 예정입니다.
 * 사람들의 편의를 위해 공항으로부터 각 사람들까지의 도시간 이동 거리가 최소가 되는 도시에 짓기로 하였습니다.
 * 편의상 도시는 일직선상에 놓여있다고 가정하며 좌표의 범위는 음수가 포함됩니다.
 * 또한 좌표는 정렬되어 있지 않습니다.
 * 직선상의 위치와 그 도시에 사는 사람들의 수가 주어질 때,
 * 공항을 지을 도시의 위치를 반환해주는 함수 chooseCity 함수를 완성하세요.
 * 거리가 같은 도시가 2개 이상일 경우 위치가 더 작은 쪽의 도시를 선택하면 됩니다.
 * 예를 들어 다음과 같은 정보의 도시가 있다고 가정해 봅시다.
 * 위치 1 2 3
 * 인구 5 2 3
 * 이 경우, 각각의 도시에 공항을 지었을 때의 사람들의 이동 거리는 8, 8, 12 이므로 1번 또는 2번에 지을 수 있지만,
 * 1의 위치가 더 작으므로 1을 반환해주면 됩니다. 
 */

/**
 * 프로그래머스 공항짓기 문제 난이도 레벨4
 * @Date 2017-12-12
 * @author Emrys
 */
class TryHelloWorld {
	
	static final int POSITION = 0;
	static final int PEOPLE = 1;
	
	public static void main(String[] args) {
		TryHelloWorld test = new TryHelloWorld();
		int tn = 3;
		int[][] tcity = { { 1, 5 }, { 2, 2 }, { 3, 3 } };
		System.out.println(test.chooseCity(tn, tcity));
	}
	
	public int chooseCity(int n, int[][] city) {
		// 정답을 담을 변수 answer.
		int answer = 0;
		
		/* 위치 정보로 도시의 상황을 정렬을 해보자.
		 * 순서에 맞춰서 계산 시켜야 하니까는.
		 */
		sortCityByPosition(city);
		answer = city[0][POSITION];
		
		/* 정렬이 끝나고 나면 한 도시가 선택되었을 때 그 도시가 가질 수 있는 값을 만들어 본다.
		 * 이때 이 값을 리스트에 담아 정리해놓아볼까? 가장 작은 값을 가져야 하니깐.
		 * 리스트는 해쉬맵을 활용해볼건데, 도시변수[도시위치]로 어느 도시를 가리키는지 표현해놓아보는 것도 좋겠다.
		 */
		Map<Integer, Integer> cityInform = new HashMap<Integer, Integer>();

		for(int i=0; i<city.length; i++) {
			/* 선택된 도시를 정하는 과정에 있다. */
			int tempPosition = 0;
			for(int k=0; k<city.length; k++) {
				/* 지역이 같은 아이들은 컨티뉴로 올려줘보겠다. */
				if(i == k) continue;
				/* 다른 지역끼리의 계산을 한 후에 해쉬맵에 있는 값에 합산시켜 이동거리를 계산해준다.
				 * 이 때 정렬을 미리 해놓았기 때문에 항상 i와 k를 비교해서 큰 쪽이 항상 크다.
				 * 사실.. 그냥 계산한 후에 절대값으로 바꿔주는 작업을 해도 되기는 할 것 같으니,
				 * 계산한 후에 절대값으로 바꿔보자.
				 * 해쉬맵에 들어가는 값은 ( 기준이 되는 위치 i 의 포지션, 계산된 값 )
				 * */
				tempPosition += city[k][PEOPLE] * (Math.abs(city[i][POSITION] - city[k][POSITION]));
				cityInform.put(city[i][POSITION], tempPosition);
			}
		}
		
		for(int i=0; i<city.length; i++) {
			System.out.printf("도시위치, 인구이동: %d, %d\n",city[i][POSITION], cityInform.get(city[i][POSITION]));
			for(int k=0; k<city.length; k++) {
				if(i == k) continue;
				if(cityInform.get(answer) > cityInform.get(city[k][POSITION])) answer = city[k][POSITION];
			}
		}
		
		return answer;
	}
	
	/**
	 * 도시를 위치 기반으로 정렬하는 메소드(버블정렬)
	 * @param city
	 * @return
	 */
	public static int[][] sortCityByPosition(int[][] city) {
		for(int i=0; i<city.length; i++) {
			for(int k=i+1; k<city.length; k++) {
				if(city[i][0] > city[k][0]) {
					int temp = city[i][0];
					city[i][0] = city[k][0];
					city[k][0] = temp;
				}
			}
		}
		return city;
	}
}