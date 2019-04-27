package test;

import java.util.HashSet;

public class LC_36 {
	public static void main(String arg[]) {
		
		
	}
	
	public static boolean isValidSudoku(char[][] board) {
		// 某行的某个数字是否已经存在
		boolean[][] row = new boolean[9][9];
		// 某列的某个数字是否已经存在
		boolean[][] col = new boolean[9][9];
		// 某 3*3 宫格内某个数字是否已经存在
		boolean[][] box = new boolean[9][9];
		
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				if(board[i][j] != '.') {
					// 将 1-9 转为 0-8，防止数组溢出
					int num = board[i][j] - '1';
					// 确定 3*3 宫格的位置
					int box_index = i/3*3 + j/3;
					if(row[i][num] || col[j][num] || box[box_index][num]) {
						return false;
					}else {
						// 记录下当前数字已经存在
						row[i][num] = true;
						col[j][num] = true;
						box[box_index][num] = true;
					}
				}
			}
		}
		
		return true;
	}

}
