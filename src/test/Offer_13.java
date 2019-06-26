package test;

public class Offer_13 {
	private static int count = 0;
	private static int rows;
	private static int cols;
	// 记录方格中每个位置的坐标数位之和
	private static int[][] digits;
	private final static int[][] next = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
	
	public static void main(String arg[]) {
		rows = 10;
		cols = 10;
		System.out.println(countMoving(5));
	}
	
	public static int countMoving(int K) {
		if(rows <= 0 || cols <= 0) return 0;
		boolean[][] marked = new boolean[rows][cols];
		// 初始化数位之和矩阵
		getDigits(rows, cols);
		backTracing(K, 0, 0, marked);
		return count;
	}
	
	public static void backTracing(int K, int i, int j, boolean[][] marked) {
		if(i < 0 || j < 0 || i >= rows || j >= cols || marked[i][j]) return;
		// 记录下当前坐标已经判断过
		marked[i][j] = true;
		if(digits[i][j] > K) return;
		count++;
		for(int[] n: next) {
			backTracing(K, i+n[0], j+n[1], marked);
		}
	}
	
	public static void getDigits(int rows, int cols) {
		digits = new int[rows][cols];
		int maxLen = Math.max(rows, cols);
		int[] digitSum = new int[maxLen];
		for(int i = 0; i < maxLen; i++) {
			int n = i;
			while(n > 0) {
				digitSum[i] += n % 10;
				n /= 10;
			}
		}
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				digits[i][j] = digitSum[i] + digitSum[j];
			}
		}
	}
}
