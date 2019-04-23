package test;

import java.util.Arrays;
import java.util.List;


// 189.��ת����
public class LC_189 {
	public static void main(String arg[]) {
		int[] nums = {-1,-100,3,99};
		int k = 2;
		rotate2(nums, k);
		for(int i=0; i<nums.length; i++) {
			System.out.println(nums[i]);
		}
	}
	
	// ����һ��ʹ�� k ��ѭ����ÿ��ѭ����תĩβ��������λ
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
	
	// ����������ת��һ��ִ�����η�ת����һ�Σ����������鷭תһ�Σ��ڶ��Σ��������ǰ k ����ת�������Σ�������ĺ� n-k ����ת
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
