package test;

public class LC_283 {
	public static void main(String arg[]) {
		int[] nums = {0,0,1};
		moveZeroes(nums);
		for(int num: nums) {
			System.out.println(num);
		}
	}
	
	public static void moveZeroes(int[] nums) {
		int i=0, j=0;
		for(i=0; i<nums.length; i++) {
			if(nums[i] != 0) {
				nums[j++] = nums[i];
			}
		}
		
		while(j < nums.length) {
			nums[j++] = 0;
		}
	}
}
