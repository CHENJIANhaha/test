package test;

import java.util.HashSet;

public class LC_36 {
	public static void main(String arg[]) {
		
		
	}
	
	public static boolean isValidSudoku(char[][] board) {
		// ĳ�е�ĳ�������Ƿ��Ѿ�����
		boolean[][] row = new boolean[9][9];
		// ĳ�е�ĳ�������Ƿ��Ѿ�����
		boolean[][] col = new boolean[9][9];
		// ĳ 3*3 ������ĳ�������Ƿ��Ѿ�����
		boolean[][] box = new boolean[9][9];
		
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				if(board[i][j] != '.') {
					// �� 1-9 תΪ 0-8����ֹ�������
					int num = board[i][j] - '1';
					// ȷ�� 3*3 �����λ��
					int box_index = i/3*3 + j/3;
					if(row[i][num] || col[j][num] || box[box_index][num]) {
						return false;
					}else {
						// ��¼�µ�ǰ�����Ѿ�����
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
