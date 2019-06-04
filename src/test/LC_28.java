package test;

// 28.  µœ÷ strStr
public class LC_28 {
	public static void main(String arg[]) {
		System.out.println(strStr2("", ""));
	}
	
	public static int strStr(String haystack, String needle) {
		int result = haystack.indexOf(needle);
		return result;
	}
	
	//KMP À„∑®
	public static int strStr2(String haystack, String needle) {
		if(needle.equals("")) {
			return 0;
		}
		char[] t = haystack.toCharArray();
		char[] p = needle.toCharArray();
		int i=0, j=0;
		int[] next = getNext(needle);
		while(i<t.length && j<p.length) {
			if(j == -1 || t[i] == p[j]) {
				i++;
				j++;
			}else {
//				i = i-j+1;
//				j = 0;
				j = next[j];
			}
		}
		
		if(j == p.length) {
			return i-j;
		}else {
			return -1;
		}
	}
	
	public static int[] getNext(String needle) {
		char[] p = needle.toCharArray();
		int[] next = new int[p.length];
		next[0] = -1;
		int k = -1;
		int j = 0;
		
		while(j < p.length-1) {
			if(k == -1 || p[j] == p[k]) {
				if(p[++j] == p[++k]) {
					next[j] = next[k];
				}else {
					next[j] = k;
				}
			}else {
				k = next[k];
			}
		}
		return next;
	}

}
