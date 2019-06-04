package test;

import java.util.Arrays;
import java.util.HashMap;

//面试题3：数组中重复的数字
public class Offer_3 {
	public static void main(String arg[]) {
		int[] nums = {1, 3, 1, 0, 2, 5, 3};
		int[] nums2 = {2, 3, 5, 4, 3, 2, 6, 7};
		System.out.println(findSameNumber(nums));
		System.out.println(findSameNumber2(nums));
		System.out.println(findSameNumber3(nums));
		System.out.println(findSameNumber4(nums2));
	}
	
	// 方法1：预排序
	public static int findSameNumber(int[] nums) {
		//对数组进行排序，排序的时间复杂度为 O(nlog(n))
		Arrays.sort(nums);
		//指针指向数组中的第一个数
		int num = nums[0];
		//遍历数组，若指针与当前数字不相等，则将指针指向当前数字
		for(int i=1; i<nums.length-1; i++) {
			if(nums[i] != num) {
				num = nums[i];
			}else {
				return num;
			}
		}
		return -1;
	}
	
	// 方法2：哈希表
	public static int findSameNumber2(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int num: nums) {
			//判断哈希表中是否已经存放过当前数字
			if(!map.containsKey(num)) {
				map.put(num, 1);
			}else {
				return num;
			}
		}
		return -1;
	}
	
	// 方法3：重排
	public static int findSameNumber3(int[] nums) {
		//判断数组是否合法
		if(nums == null || nums.length <=0) {
			return -1;
		}
		
		//判断数组中的数字是否合法，是否在 0~n-1 之间，n 为数字长度
		for(int num: nums) {
			if(num <0 || num > nums.length-1) {
				return -1;
			}
		}
		
		for(int i=0; i<nums.length; i++) {
			//判断当前数字是否与其位置相匹配，若不匹配，则将当前数字与其对应位置上的数字进行交换
			while(nums[i] != i) {
				if(nums[i] == nums[nums[i]]) {
					return nums[i];
				}
				
				int temp = nums[nums[i]];
				nums[nums[i]] = nums[i];
				nums[i] = temp;
			}
		}
		
		return -1;
	}
	
	// 方法4：二分查找
	public static int findSameNumber4(int[] nums) {
		if(nums == null || nums.length <= 0) {
			return -1;
		}
		
		for(int num: nums) {
			if(num <0 || num > nums.length-1) {
				return -1;
			}
		}
		
		int start = 1;
		int end = nums.length - 1;
		while(start <= end) {
			int mid = (end - start)/2 + start;
			int count = countRange(nums, start, mid);
			
			if(start == end) {
				if(count > 1) {
					return start;
				}else {
					break;
				}
			}
			
			if(count > (mid - start + 1)) {
				end = mid;
			}else {
				start = mid + 1;
			}
		}
		return -1;
	}
	
	public static int countRange(int[] nums, int start, int end) {
		int count = 0;
		for(int num: nums) {
			if(num >= start && num <= end) {
				count++;
			}
		}
		return count;
	}
}
