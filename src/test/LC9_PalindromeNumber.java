package test;

/**
 * 9.回文数
 *
 */
public class LC9_PalindromeNumber {
	public static void main(String[] args) {
		System.out.println(palindrome2(121));
	}
	
	//方法一：数字转字符串
	public static Boolean palindrome(int number) {
		String origin = Integer.toString(number);
		char[] str = origin.toCharArray();
		String reverse = "";
		for(int i=str.length-1; i>=0; i--) {
			reverse += str[i];
		}
		return origin.equals(reverse);
	}
	
	//方法二：反转一半数字
	public static Boolean palindrome2(int number) {
		//数字小于0或是10的倍数一定不是回文数
		if(number < 0 || (number != 0 && number%10 == 0)) {
			return false;
		}
		
		//将原始数字对半分开，保留前一半，后一半进行反转，反转后的数字应该等于原始数字
		int reverseNumber = 0;
		while(number > reverseNumber) { //当原始数字小于反转数据时，证明反转数字的位数已经达到原始数字的一半
			reverseNumber = reverseNumber*10 + number%10; //反转数字
			number = number/10; //原始数字
		}
		
		return number == reverseNumber || number == reverseNumber/10; //原始数字的位数为偶数||原始数字的位数为奇数
	}
}
