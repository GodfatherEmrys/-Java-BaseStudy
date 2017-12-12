class Try2 {

	static final int POSITION = 0;
	static final int PEOPLE = 1;

	public static void main(String[] args) {
		Try2 test = new Try2();
		int tn = 3;
		int[][] tcity = { { 1, 5 }, { 2, 2 }, { 3, 3 } };
		System.out.println(test.chooseCity(tn, tcity));
	}

	public int chooseCity(int n, int[][] city) {
		int answer = 0;
		int value = 0;
		int minrail = 0;
		for (int i = 0; i < city.length; i++) {
			int railroad = 0;
			for (int k = 0; k < city.length; k++) {
				if (i == k)
					continue;
				railroad += city[k][PEOPLE] * Math.abs(city[i][POSITION] - city[k][POSITION]);
			}
			if (value == 0) {
				value = city[i][POSITION];
				minrail = railroad;
			} else {
				if(minrail > railroad) {
					value = city[i][POSITION];
					minrail = railroad;
				}
			}
		}
		answer = value;
		return answer;
	}
}