package test;

import java.util.Arrays;
import java.util.HashMap;

// 242. 有效的字母异位词
public class LC_242 {
	public static void main(String arg[]) {
		String s = "aacc", t = "ccac";
		System.out.println(isAnagram3(s, t));
	}
	
	public static boolean isAnagram(String s, String t) {
		char[] array_s = s.toCharArray();
		char[] array_t = t.toCharArray();
		
		if(array_s.length != array_t.length) {
			return false;
		}
		
		Arrays.sort(array_s);
		Arrays.sort(array_t);
		
		return Arrays.equals(array_s, array_t);
	}
	
	public static boolean isAnagram2(String s, String t) {
		if(s.length() != t.length()) {
			return false;
		}
		
		char[] array_s = s.toCharArray();
		char[] array_t = t.toCharArray();
		HashMap<Character, Integer> hms = new HashMap<>();
		
		for(char c: array_s) {
			hms.put(c, hms.getOrDefault(c, 0) + 1);
		}
		
		for(char c: array_t) {
			Integer count = hms.get(c);
			if(count == null || count == 0) {
				return false;
			}else if(count > 1){
				hms.put(c, count-1);
			}else {
				hms.remove(c);
			}
		}
		
		return hms.isEmpty();
	}
	
	public static boolean isAnagram3(String s, String t) {
		if(s.length() != t.length()) return false;
		
		int[] sCounts = new int[26];
		int[] tCounts = new int[26];
		char[] sChar = s.toCharArray();
		char[] tChar = t.toCharArray();
		
		for(int i=0; i<s.length(); i++) {
			sCounts[sChar[i] - 'a']++;
			tCounts[tChar[i] - 'a']++;
		}
		
		for(int i=0; i<26; i++) {
			if(sCounts[i] != tCounts[i]) return false;
		}
		
		return true;
	}
}
