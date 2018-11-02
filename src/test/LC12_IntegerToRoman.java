package test;

/**
 * 12.整数转罗马数字
 *
 */
public class LC12_IntegerToRoman {
	public static void main(String[] args) {
		System.out.println(toRoman(3));
	}
	
	public static String toRoman(int num) {
		String str = "";
		int[] integer = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		for(int i=0; i<integer.length; i++) {
			while(num >= integer[i]) {
				str += roman[i];
				num -= integer[i];
			}
		}
		return str;
	}
}
