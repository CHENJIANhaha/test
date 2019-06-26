package test;


/**
 * 14.�����ǰ׺
 *
 */

public class LC14_LongestCommonPrefix {
	public static void main(String[] args) {
		String[] strs = {"flower","flow","flight"};
		System.out.println(longestCommonPrefix2(strs));
		System.out.println(7^4);
	}
	
	public static String longestCommonPrefix(String[] strs) {
		String common = "";
		int min = 0;
		
        if(strs != null && strs.length > 0) {
            min = strs[0].length(); //��̵��ʵĳ���
        }else {
            return "";
        }
        
		for(int i=0; i<strs.length; i++) {
			if(strs[i].equals("")) { //�����д��ڿ��ַ���
				return "";
			}
			if(strs[i].length() < min) { //�ҳ�������̵ĵ���
				min = strs[i].length();
			}
		}
		
		for(int i=1; i<=min; i++) {
			common = strs[0].substring(0, i);
			for(int j=1; j<strs.length; j++) {
				if(!strs[j].substring(0, i).equals(common)) { //һ��������common��ƥ��ĵ��ʷ���ǰһ��common
					common = strs[0].substring(0, i-1);
					return common;
				}
			}
		}
		return common;
	}
	
	//������������Ƚ��ַ���
	public static String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) { // string.indexOf(str)������str��string�е�һ�γ��ֵ�λ��
            	System.out.println(strs[i].indexOf(prefix));
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }        
        return prefix;
    }
	
	//������������Ƚ��ַ���
	public static String longestCommonPrefix3(String[] strs) {
		if(strs.length == 0) return "";
		for(int i=0; i<strs[0].length(); i++) {
			char c = strs[0].charAt(i);
			for(int j=1; j<strs.length; j++) {
				if(strs[j].length() == i || strs[j].charAt(i) != c) {
					// �����ٿ����ֹ������ַ�ʱ
					return strs[0].substring(0, i);
				}
			}
		}
		return strs[0];
	}
}
