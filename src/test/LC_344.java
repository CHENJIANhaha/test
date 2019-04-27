package test;

public class LC_344 {
	public static void main(String arg[]) {
		char[] s = {'h','e','l','l','o'};
		reverseString(s);
		for(char c: s) {
			System.out.println(c);
		}
	}
	
	public static void reverseString(char[] s) {
		int len = s.length;
		for(int i=0; i<len/2; i++) {
			swap(s, i, len-1-i);
		}
	}
	
	public static void swap(char[] s, int start, int end) {
		char temp = s[start];
		s[start] = s[end];
		s[end] = temp;
	}
}
