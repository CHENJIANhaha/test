package test;

public class LC_PalindromeNumber {
	public static void main(String[] args) {
		System.out.println(palindrome(121));
	}
	
	public static Boolean palindrome(int number) {
		String origin = Integer.toString(number);
		char[] str = origin.toCharArray();
		String reverse = "";
		for(int i=str.length-1; i>=0; i--) {
			reverse += str[i];
		}
		return origin.equals(reverse);
	}
}
