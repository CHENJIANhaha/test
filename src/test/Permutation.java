package test;
import java.util.Arrays;

public class Permutation {
	public static void main(String[] args) {
		char[] arr = {'a', 'b', 'c'};
		int n = arr.length;
		permutation(n, arr);
	}
	
	public static void swap(char[] str, int a, int b) {
		char temp = str[a];
		str[a] = str[b];
		str[b] = temp;
	}
	
	/*È«ÅÅÁĞ£ºhead's Algorithm*/	
	public static void permutation(int n, char[] str) {
		if(n == 1) {
			System.out.println(Arrays.toString(str));
		}else {
			for(int i = 0; i < n-1; i++) {
				permutation(n-1, str);
				if(n%2 == 0) {
					swap(str, i, n-1);
				}else {
					swap(str, 0, n-1);
				}
			}
			permutation(n-1, str);
		}
	}
}
