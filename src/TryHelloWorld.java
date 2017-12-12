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
		// 위치 정보로 도시의 상황을 정렬한다..? 정렬하지 말까?
		sortCityByPosition(city);
		
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