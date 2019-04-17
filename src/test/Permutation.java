package test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
	public static void main(String[] args) {
		char[] arr = {'(', ')'};
		int n = arr.length;
		permutation(n, arr);
		List<String> combinations = new ArrayList<> ();
        generate(new char[2], 0, combinations);
        System.out.println("combinations: " + combinations.toString());
	}
	
	public static void swap(char[] str, int a, int b) {
		char temp = str[a];
		str[a] = str[b];
		str[b] = temp;
	}
	
	/*全排列：head's Algorithm*/	
	public static void permutation(int n, char[] str) {
		if(n == 1) {
			System.out.println(Arrays.toString(str)); //数组转字符串
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
	
	public static void generate(char[] current, int pos, List<String> result) {
		if(pos == current.length) {
			result.add(new String(current));
		}else {
			current[pos] = '(';
			generate(current, pos+1, result);
			current[pos] = ')';
			generate(current, pos+1, result);
		}
	}
}
