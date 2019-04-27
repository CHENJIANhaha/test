package test;

import java.util.HashMap;

public class LC_387 {
	public static void main(String arg[]) {
		String s = "c";
		System.out.println(firstUniqChar(s));
	}
	
	public static int firstUniqChar(String s) {
		char[] c = s.toCharArray();
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i=0; i<c.length; i++) {
			if(!map.containsKey(c[i])) {
				map.put(c[i], 1);
			}else {
				map.put(c[i], map.get(c[i])+1);
			}	
		}
		
		for(int i=0; i<c.length; i++) {
			if(map.get(c[i]) == 1) {
				return i;
			}
		}
		return -1;
	}
}
