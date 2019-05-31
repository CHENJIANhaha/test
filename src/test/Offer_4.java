package test;

public class Offer_4 {
	public static void main(String arg[]) {
		int[][] array = {{1, 2, 3}, {2, 3, 4}};
		System.out.println(find(array, 0));
		
	}
	
	public static boolean find(int[][] array,  int target) {
		if(array.length == 0 || array[0].length == 0 || array == null) return false;
		int rows = array.length;
		int cols = array[0].length;
		int r = 0;
		int c = cols - 1;
		while(r < rows-1 && c >= 0) {
			int temp = array[r][c];
			if(temp > target) {
				c--;
			}else if(temp < target) {
				r++;
			}else {
				return true;
			}
		}
		return false;
	}
}
