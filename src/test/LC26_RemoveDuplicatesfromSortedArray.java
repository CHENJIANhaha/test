package test;

import java.io.IOException;
import java.lang.reflect.Array;

public class LC26_RemoveDuplicatesfromSortedArray {
	public static void main(String args[]) throws IOException {
		int[] test = {0,0,1,1,1,2,2,3,3,4}; 
		System.out.println(removeDuplicates(test));
	}
	
	public static int removeDuplicates(int[] nums) {
		if(nums.length == 0) {
			return 0;
		}
		int i = 0;
		for(int j=1; j<nums.length; j++) {
			if(nums[i] != nums[j]) {
				i++;
				nums[i] = nums[j];
			}
		}
		return i+1;
	}
}
