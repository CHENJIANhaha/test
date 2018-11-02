package test;


/**
 * 14.最长公共前缀
 *
 */
public class LC14_LongestCommonPrefix {
	public static void main(String[] args) {
		String[] strs = {};
		System.out.println(longestCommonPrefix(strs));
	}
	
	public static String longestCommonPrefix(String[] strs) {
		String common = "";
		int min = 0;
		
        if(strs != null && strs.length > 0) {
            min = strs[0].length(); //最短单词的长度
        }else {
            return "";
        }
        
		for(int i=0; i<strs.length; i++) {
			if(strs[i].equals("")) { //数组中存在空字符串
				return "";
			}
			if(strs[i].length() < min) { //找出长度最短的单词
				min = strs[i].length();
			}
		}
		
		for(int i=1; i<=min; i++) {
			common = strs[0].substring(0, i);
			for(int j=1; j<strs.length; j++) {
				if(!strs[j].substring(0, i).equals(common)) { //一旦出现与common不匹配的单词返回前一个common
					common = strs[0].substring(0, i-1);
					return common;
				}
			}
		}
		return common;
	}
}
