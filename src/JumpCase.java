class JumpCase {
	
	static int[] matrix = new int[9999];

	public JumpCase() {
		matrix[0] = 1;
		matrix[1] = 1;
		matrix[2] = 2;
	}
	
	public int jumpCase(int num) {
      if(matrix[num] != 0) return matrix[num];
      if(num <= 2) matrix[num] = num;
      return matrix[num] = jumpCase(num-1) + jumpCase(num-2);
    }

    public static void main(String[] args) {
        JumpCase c = new JumpCase();
        int testCase = 32;
        long start = System.nanoTime();
        c.jumpCase(testCase);
        long end = System.nanoTime();
        System.out.println(end - start);
    }
}