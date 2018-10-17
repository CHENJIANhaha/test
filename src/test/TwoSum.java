package test;

public class TwoSum {
	public static void main(String[] args) {
		int[] nums = {3,3};
		int target = 6;
		int[] result = twoSum(nums, target);
		for(int i = 0; i < 2; i++) {
			System.out.println(result[i]);
		}
	}
	
	public static int[] twoSum(int[] nums, int target) {
        int a = 0, b = 0, c = 0;
        int[] result;
        result = new int[2];
        for(int i = 0; i < nums.length; i++) {
            a = nums[i];
            for(int j = i+1; j < nums.length; j++) {
                b = nums[j];
                c = a + b;
                if(c==target) {
                	result[0] = i;
                	result[1] = j;
                    break;
                }
            }
        }
        return result;
    }
}
