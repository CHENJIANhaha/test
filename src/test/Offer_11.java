package test;

public class Offer_11 {
	public static void main(String arg[]) {
		int[] nums = {1, 1, 1, 0, 1};
		System.out.println(minRotate(nums));
	}
	
	public static int minRotate(int[] nums) {
		if(nums.length <= 0) return -1;
		int i = 0;
		int j = nums.length - 1;
		// mid 初始化为 i，若 nums 为排序数组本身，直接返回数组第一项
		int mid = i;
		while(nums[i] >= nums[j]) {
			if(j-i == 1) {
				mid = j;
				break;
			}
			mid = (i+j)/2;
			// 当无法确定 mid 属于哪一部分时，使用顺序查找
			if(nums[i] == nums[mid] && nums[mid] == nums[j]) {
				return getMin(nums, i, j);
			}
			
			if(nums[i] < nums[mid]) {
				i = mid;
			}else {
				j = mid;
			}
		}
		
		return nums[mid];
	}
	
	public static int getMin(int[] nums, int i, int j) {
		int min = nums[i];
		for(int k = i+1; k <= j; k++) {
			if(nums[k] < min) {
				min = nums[k];
			}
		}
		return min;
	}
}
