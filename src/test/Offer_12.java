package test;

public class Offer_12 {
	private final static int[][] next = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
	private static int rows;
	private static int cols;
	
	public static void main(String arg[]) {
		char[][] matrix= {{'a', 'b', 't', 'g'}, {'c', 'f', 'c', 's'}, {'j', 'd', 'e', 'h'}};
		char[][] matrix2 = {{}};
		String str = "bfce";
		System.out.println(hasPath(matrix2, str));
	}
	
	public static boolean hasPath(char[][] matrix, String str) {
		char[] strArray = str.toCharArray();
		rows = matrix.length;
		cols = matrix[0].length;
		if(rows == 0 || cols == 0) return false;
		// 记录矩阵中的数是否被记录在路径中
		boolean[][] marked = new boolean[rows][cols];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if(backTracing(matrix, marked, strArray, 0, i, j)) return true;
			}
		}
		return false;
	}
	
	// 回溯
	public static boolean backTracing(char[][] matrix, boolean[][] marked, char[] str, int pathLen, int i, int j) {
		// 当经历的路径长度为字符串的长度，证明当前路径为所寻路径
		if(pathLen == str.length) return true;
		// 若超出范围、矩阵中的字符与字符串中的字符不匹配、当前字符已经在路径中，返回false
		if(i >= rows || i < 0 || j >= cols || j < 0 || marked[i][j] || matrix[i][j] != str[pathLen]) return false;
		marked[i][j] = true;
		// 判断左右上下的字符是否匹配
		for(int[] n: next) {
			if(backTracing(matrix, marked, str, pathLen+1, i+n[0], j+n[1])) return true;
		}
		marked[i][j] = false;
		return false;
	}

}
