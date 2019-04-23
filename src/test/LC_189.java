package test;

import java.util.Arrays;
import java.util.List;


// 189.旋转数组
public class LC_189 {
	public static void main(String arg[]) {
		int[] nums = {-1,-100,3,99};
		int k = 2;
		rotate2(nums, k);
		for(int i=0; i<nums.length; i++) {
			System.out.println(nums[i]);
		}
	}
	
	// 方法一：使用 k 次循环，每次循环旋转末尾数字至首位
	public static void rotate(int[] nums, int k) {
		int len = nums.length;
		for(int i=0; i<k; i++) {
			int last = nums[len-1];
			for(int j=len-1; j>0; j--) {
				nums[j] = nums[j-1];
			}
			nums[0] = last;
		}
	}
	
	// 方法二：翻转，一共执行三次翻转。第一次，将整个数组翻转一次；第二次，将数组的前 k 个翻转；第三次，将数组的后 n-k 个翻转
	public static void rotate2(int[] nums, int k) {
		int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);

	}
	
	private static void reverse(int[] nums, int start, int end) {
		while(start < end) {
			int temp = nums[start];
			nums[start++] = nums[end];
			nums[end--] = temp;
		}
    }

}
