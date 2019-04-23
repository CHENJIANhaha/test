package test;

// 136.只出现一次的数字
public class LC_136 {
	public static void main(String arg[]) {
		int[] nums = {1,2,2,3,3};
		System.out.println(singleNumber(nums));
	}
	
	public static int singleNumber(int[] nums) {
		int result = 0;
		for(int i=0; i<nums.length; i++) {
			result = result^nums[i];
		}
		return result;
	}

}
