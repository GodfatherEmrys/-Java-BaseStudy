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
	
	public int chooseCity(int n, int[][] city) {
		// 위치 정보로 도시의 상황을 정렬을 해보자. 순서에 맞춰서 계산 시켜야 하니까는.
		sortCityByPosition(city);
		
		/* 정렬이 끝나고 나면 한 도시가 선택되었을 때 그 도시가 가질 수 있는 값을 만들어 본다.
		 * 이때 이 값을 리스트에 담아 정리해놓아볼까? 가장 작은 값을 가져야 하니깐.
		 * 리스트는 어레이 리스트를 활용해볼건데, 도시변수[도시위치]로 어느 도시를 가리키는지 표현해놓아보는 것도 좋겠다.
		 */
		int answer = 0;

		return answer;
	}

	public static void main(String[] args) {
		TryHelloWorld test = new TryHelloWorld();
		int tn = 3;
		int[][] tcity = { {4, 2}, { 1, 5 }, { 2, 2 }, { 3, 3 } };
		System.out.println(test.chooseCity(tn, tcity));
	}
}