package test;

public class Offer_17 {
	public static void main(String arg[]) {
		print1ToMaxDigits(1);
	}
	
	public static void print1ToMaxDigits(int n) {
		if(n <= 0) return;
		char[] nums = new char[n];
		print1ToMaxDigits(nums, 0);
	}
	
	public static void print1ToMaxDigits(char[] nums, int digit) {
		// 字符长度符合要求，打印数字
		if(digit == nums.length) {
			printNum(nums);
			return;
		}
		
		for(int i = 0; i < 10; i++) {
			nums[digit] = (char) (i + '0');
			print1ToMaxDigits(nums, digit + 1);
		}
	}
	
	public static void printNum(char[] nums) {
		int index = 0;
		// 将 index 指向第一个非0数
		while(index < nums.length && nums[index] == '0') {
			index++;
		}
		
		while(index < nums.length) {
			System.out.print(nums[index++]);
		}
		System.out.println();
	}

}
