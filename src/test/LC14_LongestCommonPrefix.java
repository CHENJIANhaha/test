package test;


/**
 * 14.最长公共前缀
 *
 */

public class LC14_LongestCommonPrefix {
	public static void main(String[] args) {
		String[] strs = {"flower","flow","flight"};
		System.out.println(longestCommonPrefix2(strs));
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
	
	//方法二：横向比较字符串
	public static String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) { // string.indexOf(str)，返回str在string中第一次出现的位置
            	System.out.println(strs[i].indexOf(prefix));
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }        
        return prefix;
    }
	
	//方法三：纵向比较字符串
	public static String longestCommonPrefix3(String[] strs) {
		if(strs.length == 0) return "";
		for(int i=0; i<strs[0].length(); i++) {
			char c = strs[0].charAt(i);
			for(int j=1; j<strs.length; j++) {
				if(strs[j].length() == i || strs[j].charAt(i) != c) {
					// 当不再可能又公共的字符时
					return strs[0].substring(0, i);
				}
			}
		}
		return strs[0];
	}
}
