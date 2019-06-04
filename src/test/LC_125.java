package test;

import java.util.ArrayList;
import java.util.List;

// 125. 验证回文字符串
public class LC_125 {
	public static void main(String arg[]) {
		System.out.println(isPalindrome2("race a car"));
	}
	
	public static boolean isPalindrome(String s) {
		s = s.toLowerCase();
		char[] sChar = s.toCharArray();
		List<Character> list = new ArrayList<>();
		for(char c: sChar) {
			if((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
				list.add(c);
			}
		}
		
		for(int i=0; i<list.size()/2; i++) {
			if(list.get(i) != list.get(list.size()-1-i)) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isPalindrome2(String s) {
		s = s.toLowerCase();
		int len = s.length();
		StringBuilder strB = new StringBuilder(len); 
		for(char c: s.toCharArray()) {
			if((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
				strB.append(c);
			}
		}
		return strB.toString().equals(strB.reverse().toString());
	}

}
