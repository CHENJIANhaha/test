package test;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

//350.两个数组的交集2
public class LC_350 {
	public static void main(String arg[]) {
		int[] nums1 = {1,2,3,4};
		int[] nums2 = {2,2,3};
		int[] result = interset(nums1, nums2);
		for(int i=0; i<result.length; i++) {
			System.out.println(result[i]);
		}
		
	}
	
	public static int[] interset(int[] nums1, int[] nums2) {
		HashSet<Integer> hs = new HashSet<>();
		List<Integer> result = new ArrayList<Integer>();
		int len1 = nums1.length;
		int len2 = nums2.length;
		if(len1 <= len2) {
			for(int i=0; i<len1; i++) {
				for(int j=0; j<len2; j++) {
					if(nums2[j] == nums1[i]) {
//						result.add(nums1[i]);
						hs.add(nums1[i]);
						break;
					}
				}
			}
		}else {
			for(int i=0; i<len2; i++) {
				for(int j=0; j<len1; j++) {
					if(nums1[j] == nums2[i]) {
//						result.add(nums2[i]);
						hs.add(nums2[i]);
						break;
					}
				}
			}
		}
		
		int[] interset = new int[hs.size()];
		int i = 0;
		for(int num: hs) {
			interset[i++] = num;
		}
		return interset;
	}
}
