package test;

public class LC_48 {
	public static void main(String arg[]) {
		
	}
	
	public static void rotate(int[][] matrix) {
		int len = matrix.length-1;
		int times = matrix.length-1;
		for(int i=0; i<times; i++) {
			for(int j=i; j<times; j++) {
				swap(matrix, i, j, j, len-i);
				swap(matrix, i, j, len-i, len-j);
				swap(matrix, i, j, len-j, i);
			}
			times--;
		}
	}
	
	public static void swap(int[][] matrix, int x1, int y1, int x2, int y2) {
		int temp = matrix[x1][y1];
		matrix[x1][y1] = matrix[x2][y2];
		matrix[x2][y2] = temp;
	}

}
