package test;


/**
 * 14.�����ǰ׺
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
}
