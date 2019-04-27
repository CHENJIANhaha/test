package test;

public class LC_66 {
	public static void main(String arg[]) {
		int[] nums = {1,2,3,4};
		nums = plusOne(nums);
		for(int num: nums) {
			System.out.println(num);
		}
	}
	
	public static int[] plusOne(int[] digits) {
		int len = digits.length;
		for(int i=len-1; i>=0; i--) {
			if(digits[i] == 9) {
				digits[i] = 0;
			}else {
				digits[i] ++;
				return digits;
			}
		}
		
		int[] result = new int[digits.length + 1];
		result[0] = 1;
		return result;
	}

}
