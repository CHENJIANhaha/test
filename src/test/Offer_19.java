package test;

public class Offer_19 {
	public static void main(String arg[]) {
		String str = "abbbb";
		String pattern = "abbbbb*";
		char[] strA = str.toCharArray();
		char[] patternA = pattern.toCharArray();
		System.out.println(match2(strA, patternA));
	}
	
	public static boolean match(char[] str, char[] pattern) {
		if(str.length <= 0 || pattern.length <= 0) return false;
		return matchCore(str, 0, pattern, 0);
	}
	
	public static boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {
		if(strIndex == str.length && patternIndex == pattern.length) return true;
		if(strIndex != str.length && patternIndex == pattern.length) return false;
		// 匹配串第二位为 *
		if(patternIndex+1 < pattern.length && pattern[patternIndex+1] == '*') {
			// 字符串第一位和匹配串第一位匹配
			if((strIndex != str.length && str[strIndex] == pattern[patternIndex]) || 
					(strIndex != str.length && pattern[patternIndex] == '.')) {
				return matchCore(str, strIndex+1, pattern, patternIndex+2) || // aab a*ab 字符串后移一位，匹配串后移两位
						matchCore(str, strIndex, pattern, patternIndex+2) || // ab a*ab 字符串不动，匹配串后移两位
						matchCore(str, strIndex+1, pattern, patternIndex); // aaaab a*b 字符串后移一位，匹配串不动
			}else {
				// 字符串第一位和匹配串第一位不匹配，匹配串后移两位
				return matchCore(str, strIndex, pattern, patternIndex+2);
			}
		}
		
		// 匹配串的第二位不为 *
		if(patternIndex+1 < pattern.length && pattern[patternIndex+1] != '*') {
			// 字符串第一位和匹配串第一位匹配
			if((strIndex != str.length && str[strIndex] == pattern[patternIndex]) || 
					(strIndex != str.length && pattern[patternIndex] == '.')) {
				return matchCore(str, strIndex+1, pattern, patternIndex+1);
			}
		}
		return false;
	}
	
	public static boolean match2(char[] str, char[] pattern) {
		int m = str.length;
		int n = pattern.length;
		boolean[][] dp = new boolean[m+1][n+1];
		dp[0][0] = true;
		for(int i = 1; i <= n; i++) {
			if(pattern[i-1] == '*')
				dp[0][i] = dp[0][i-2];
		}
		
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				if(str[i-1] == pattern[j-1] || pattern[j-1] == '.') {
					dp[i][j] = dp[i-1][j-1];
				}else if(pattern[j-1] == '*')
					if(pattern[j-2] == str[i-1] || pattern[j-2] == '.') {
						dp[i][j] |= dp[i][j-1]; // a* counts as single a
						dp[i][j] |= dp[i-1][j]; // a* counts as multiple a
						dp[i][j] |= dp[i][j-2]; // a* counts as empty
					}else {
						dp[i][j] = dp[i][j-2]; // a* only counts as empty
					}
			}
		}
		return dp[m][n];
	}

}
