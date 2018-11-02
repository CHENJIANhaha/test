package test;

/**
 * 13.罗马数字转整数
 *
 */
public class LC13_RomanToInteger {
	public static void main(String[] args) {
		System.out.println(romanToInt("MCMXCIV"));
	}
	
	public static int romanToInt(String s) {
		char[] arr = s.toCharArray();
		int number = 0;
		
		for(int i=0; i<arr.length; i++) {
			if(i<arr.length-1 && charToInt(arr[i]) < charToInt(arr[i+1])) {
				number -= 2*charToInt(arr[i]); //如果i小于i+1说明这部分罗马数字转整数需要i+1减去i，由于在计算i-1时已经将i加过一次，所以现在需要将i减两倍
			}
			number += charToInt(arr[i]);
		}
		
        return number;
    }
	
	public static int charToInt(char c) {
		int number = 0;
		switch(c) {
		case 'I':
			number = 1;
			break;
		case 'V':
			number = 5;
			break;
		case 'X':
			number = 10;
			break;
		case 'L':
			number = 50;
			break;
		case 'C':
			number = 100;
			break;
		case 'D':
			number = 500;
			break;
		case 'M':
			number = 1000;
			break;
		}
		return number;
	}
}
