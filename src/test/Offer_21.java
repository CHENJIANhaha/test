package test;

public class Offer_21 {
	public static void main(String arg[]) {
		int[] nums = {1, 2, 3, 4, 5, 6};
		reOrderOddEven(nums);
		for(int num: nums) System.out.print(num);
		
	}
	
	public static void reOrderOddEven(int[] nums) {
		int start = 0;
		int end = nums.length - 1;
		while(start < end) {
			while(start < end && !isEven(nums[start])) {
				start++;
			}
			while(start < end && isEven(nums[end])) {
				end--;
			}
			
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
		}
	}
	
	public static boolean isEven(int num) {
		return (num & 1) == 0;
	}

}
