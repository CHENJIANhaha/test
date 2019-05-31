package test;

public class Offer_5 {
	public static void main(String arg[]) {
		StringBuffer str = new StringBuffer(" We are happy");
		System.out.println(replaceBlank(str));
	}
	
	public static String replaceBlank(StringBuffer str) {
		if(str == null || str.length() <= 0) 
			return "";
		int p1 = str.length() - 1;
		for(int i=0; i<=p1; i++) {
			if(str.charAt(i) == ' ') {
				str.append("  ");
			}
		}
		
		int p2 = str.length() - 1;
		while(p1 >= 0 && p2 > p1) {
			char c = str.charAt(p1--);
			if(c != ' ') {
				str.setCharAt(p2--, c);
			}else {
				str.setCharAt(p2--, '0');
				str.setCharAt(p2--, '2');
				str.setCharAt(p2--, '%');
			}
		}
		
		return str.toString();
	}
}
