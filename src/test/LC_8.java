package test;

// 8. ×Ö·û´®×ª»»ÕûÊý
public class LC_8 {
	public static void main(String arg[]) {
		System.out.println(myAtoi("+-2"));
	}
	
	public static int myAtoi(String str) {
		if(str.equals("")) return 0; 
		int len = str.length();
		char[] strChar = str.toCharArray();
		StringBuilder strB = new StringBuilder(len);
		if(strChar[0] == ' ' || (strChar[0] >= '0' && strChar[0] <= '9') || strChar[0] == '-' || strChar[0] == '+') {
			for(int i=0; i<len; i++) {
				if(strChar[i] == ' ' && strB.length() == 0) {
					continue;
				}else if((strChar[i] >= '0' && strChar[i] <= '9')) {
					strB.append(strChar[i]);
				}else if((strChar[i] == '-' || strChar[i] == '+') && strB.length() == 0) {
					strB.append(strChar[i]);
				}else if(strB.length() >= 0 && !(strChar[i] >= '0' && strChar[i] <= '9')) {
					break;
				}
			}
	
			int a = 0;
			try{
				a = Integer.valueOf(strB.toString());
			}catch(NumberFormatException e) {
				if(strB.length() > 1) {
					if(strB.substring(0, 1).equals("-")) {
						return (Integer.MIN_VALUE);
					}else if(strB.substring(0, 1).equals("+")) {
						return (Integer.MAX_VALUE);
					}
				}
			}
			return a;
		}
		return 0;
	}
}
