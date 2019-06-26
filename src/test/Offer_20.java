package test;

public class Offer_20 {
	public static void main(String arg[]) {
		char[] str = {'e'};
		System.out.println(isNumeric(str));
	}
	
	public static boolean isNumeric(char[] str) {
		if(str == null || str.length <= 0) return false;
		String regex = "[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?"; 
		return new String(str).matches(regex);
		
	}

}
